package tf.veriny.ss76.engine.scene

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.ButtonAction
import tf.veriny.ss76.engine.ButtonManager


/**
 * Builder helper for creating new scene definitions.
 */
public class SceneDefinitionBuilder(private val sceneId: String) {
    private val pages: MutableList<StringBuilder> = mutableListOf()
    private val buttons: MutableMap<String, ButtonManager.Button> = mutableMapOf()
    private val onLoadHandlers: MutableList<(VirtualNovelScene) -> Unit> = mutableListOf()

    private var buttonCounter = 0

    /**
     * Registers a function to be ran on load.
     */
    public fun onLoad(block: (VirtualNovelScene) -> Unit) {
        onLoadHandlers += block
    }

    /**
     * Builder for building a single page.
     */
    public inner class PageBuilder {
        private fun ensureBlankChar() {
            val page = pages.last()
            val lastChar = page.lastOrNull()
            if (lastChar != null && lastChar != ' ' && lastChar != '\n') {
                page.append(' ')
            }
        }

        /**
         * Adds a new line of text to this page. This will be automatically split and
         * formatted according to the various formatting characters.
         */
        public fun line(data: String, addNewline: Boolean = true) {
            val sb = pages.last()
            sb.append(data)
            if (addNewline) sb.append('\n')
        }

        public fun dline(data: String, addNewline: Boolean = true) {
            val sb = pages.last()
            val realText = ":push:¬dialogue¬ $data :pop: "

            line(realText, addNewline = false)
            if (addNewline) {
                newline(2)
            }
        }

        /**
         * Adds a newline.
         */
        public fun newline(count: Int = 1) {
            val sb = pages.last()
            repeat(count) { sb.append('\n') }
        }

        /**
         * Adds a generic button to the current page. This can be referenced with backtick syntax
         * on nodes.
         */
        public fun addButton(id: String, linkedScene: String? = null, action: ButtonAction) {
            buttons[id] = ButtonManager.Button(id.toString(), linkedScene, action)
        }

        // convenience
        /**
         * Adds a button that changes the current scene.
         */
        public fun changeSceneButton(sceneId: String, text: String) {
            ensureBlankChar()
            val buttonName = "change-scene-${buttonCounter++}"
            val realText = ":push:@salmon@`$buttonName` $text :pop:"

            line(realText, addNewline = false)
            addButton(buttonName) {
                SS76.sceneManager.changeScene(sceneId)
            }
        }

        /**
         * Adds a button that pushes a new scene onto the stack.
         */
        public fun pushSceneButton(sceneId: String, text: String) {
            ensureBlankChar()
            val currentButton = (buttonCounter++).toString().padStart(2, '0')
            val realText = ":push:@linked@`$currentButton` $text :pop:"
            line(realText, addNewline = false)

            addButton(currentButton, linkedScene = sceneId) {
                SS76.sceneManager.pushScene(sceneId)
            }
        }

        /**
         * Adds a green back button.
         */
        public fun backButton(text: String = "« Back") {
            val realText = ":push:@green@`back-button` $text :pop:"
            line(realText)

            addButton("back-button") {
                SS76.sceneManager.exitScene()
            }
        }

    }

    /**
     * Creates a new page.
     */
    public fun page(block: PageBuilder.() -> Unit) {
        pages.add(StringBuilder())
        val builder = PageBuilder()
        builder.block()
    }

    /**
     * Creates a definition from a page.
     */
    private fun createDefinitionFromPage(page: StringBuilder): List<TextualNode> {
        val pageFullString = page.toString()
        try {
            return splitScene(pageFullString, v = sceneId == "sussex-july-3-school-2-2")
        } catch (e: Exception) {
            throw IllegalStateException("Caught error trying to tokenize:\n$pageFullString", e)
        }
    }

    /**
     * Creates the scene definition for this builder.
     */
    public fun createDefinition(): VirtualNovelSceneDefinition {
        val pages = mutableListOf<List<TextualNode>>()
        for (page in this.pages) {
            val nodes = createDefinitionFromPage(page)
            pages.add(nodes)
        }

        return PreparedSceneDefinition(
            sceneId, onLoadHandlers, buttons, pages
        )
    }
}

/**
 * Creates a new scene.
 */
public inline fun createScene(
    sceneId: String,
    immediate: Boolean = false,
    block: SceneDefinitionBuilder.() -> Unit,
): VirtualNovelScene {
    val builder = SceneDefinitionBuilder(sceneId)
    builder.block()

    val definition = builder.createDefinition()
    return VirtualNovelScene(definition)
}

/**
 * Creates a new scene and registers it with the scene manager.
 */
public inline fun createAndRegisterScene(
    sceneId: String, block: SceneDefinitionBuilder.() -> Unit
): VirtualNovelScene {
    val scene = createScene(sceneId, block = block)
    SS76.sceneManager.registerScene(scene)
    return scene
}