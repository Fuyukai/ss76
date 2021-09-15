package tf.veriny.ss76.engine

import okio.BufferedSink
import okio.BufferedSource
import okio.ByteString.Companion.EMPTY
import okio.ByteString.Companion.encodeUtf8
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.BasicSceneDefinition
import tf.veriny.ss76.engine.scene.PageBuilder
import tf.veriny.ss76.engine.scene.VirtualNovelScene
import tf.veriny.ss76.engine.scene.splitScene

/**
 * A wrapper that re-registers a scene every time it updates. This allows for simple dynamic scenes
 * (e.g. the checkpoint menu or the the Record).
 *
 * A dynamic scene is saveable. A dynamic scene cannot use onLoad handlers due to this.
 */
public open class UpdatableSceneWrapper(
    public val sceneId: String
) : Saveable {
    private val buttons = mutableMapOf<String, ButtonManager.Button>()

    // starts with one page of stringbuilder, for the first page
    private var pages = mutableListOf<StringBuilder>(StringBuilder())

    public fun register() {
        val parsedPages = pages.map { splitScene(it.toString()) }

        val definition = BasicSceneDefinition(
            sceneId, buttons, parsedPages,
            dynamic = true,
        )
        val scene = VirtualNovelScene(definition)
        SS76.sceneManager.reregisterScene(scene)
    }

    /**
     * Resets the scene. A subsequent call to register() is required.
     */
    public fun reset() {
        pages = mutableListOf(StringBuilder())
        buttons.clear()
    }

    /**
     * Adds a new button.
     */
    public fun addButton(button: ButtonManager.Button) {
        buttons[button.name] = button
    }

    /**
     * Updates the number of pages in this scene.
     */
    public fun updatePageLength(length: Int) {
        when {
            pages.size == length -> return
            pages.size > length -> {
                pages = pages.dropLast((pages.size - length)).toMutableList()
            }
            pages.size > length -> {
                (0 until (pages.size - length)).forEach { pages.add(StringBuilder()) }
            }
        }
    }

    // not so good API, but it works.
    /**
     * Clears the page specified.
     */
    public fun clearPage(page: Int) {
        pages[page].clear()
    }

    /**
     * Edits the specified page by index.
     */
    public open fun edit(page: Int, block: PageBuilder.() -> Unit) {
        val sb = pages[page]
        val builder = PageBuilder(sb, buttons)
        builder.block()

        register()
    }

    override fun read(buffer: BufferedSource) {
        pages.clear()
        buttons.clear()

        val pages = buffer.readByte().toInt()
        for (idx in 0 until pages) {
            val size = buffer.readInt().toLong()
            val data = buffer.readUtf8(size)
            val sb = StringBuilder(data)
            this.pages.add(sb)
        }

        val buttons = buffer.readByte().toInt()
        for (idx in 0 until buttons) {
            val type = ButtonManager.ButtonType.values()[buffer.readInt()]
            val size1 = buffer.readInt()
            val name = buffer.readUtf8(size1.toLong())
            val size2 = buffer.readInt()
            val sceneId = buffer.readUtf8(size2.toLong())

            when {
                // special case back-button
                sceneId == "back-button" -> {
                    this.buttons["back-button"] = ButtonManager.Button(name) {
                        SS76.sceneManager.exitScene()
                    }
                }

                type == ButtonManager.ButtonType.PUSH -> {
                    this.buttons[name] = ButtonManager.Button(
                        name, linkedId = sceneId, buttonType = type
                    ) { SS76.sceneManager.pushScene(sceneId) }
                }

                type == ButtonManager.ButtonType.CHANGE -> {
                    this.buttons[name] = ButtonManager.Button(
                        name, linkedId = sceneId, buttonType = type
                    ) { SS76.sceneManager.changeScene(sceneId) }
                }

                else -> error("invalid button read from stream ($name $sceneId $type)")
            }
        }
    }

    override fun write(buffer: BufferedSink) {
        buffer.writeByte(pages.size)
        for (page in pages) {
            val text = page.toString()
            val encoded = text.encodeUtf8()
            buffer.writeInt(encoded.size)
            buffer.write(encoded)
        }

        buffer.writeByte(buttons.size)
        for ((name, button) in buttons) {
            val type = button.buttonType.ordinal
            buffer.writeInt(type)
            val nameEncoded = name.encodeUtf8()
            buffer.writeInt(nameEncoded.size)
            buffer.write(nameEncoded)

            val sceneEncoded = button.linkedId?.encodeUtf8() ?: EMPTY
            buffer.writeInt(sceneEncoded.size)
            buffer.write(sceneEncoded)
        }
    }

}