package tf.veriny.ss76.engine

import com.badlogic.gdx.graphics.Color
import okio.BufferedSink
import okio.BufferedSource
import okio.ByteString
import okio.ByteString.Companion.encodeUtf8
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.SceneEffects
import tf.veriny.ss76.engine.scene.VirtualNovelSceneDefinition
import tf.veriny.ss76.engine.scene.splitScene

/**
 * Reads a colour from a [BufferedSource].
 */
public fun BufferedSource.readColour(): Color {
    val r = Float.fromBits(readInt())
    val g = Float.fromBits(readInt())
    val b = Float.fromBits(readInt())
    val a = Float.fromBits(readInt())
    return Color(r, g, b, a)
}

/**
 * Writes a colour to a [BufferedSink].
 */
public fun BufferedSink.writeColour(c: Color) {
    writeInt(c.r.toRawBits())
    writeInt(c.g.toRawBits())
    writeInt(c.b.toRawBits())
    writeInt(c.a.toRawBits())
}

/**
 * Reads a scene definition from a [BufferedSource].
 */
public fun BufferedSource.readSceneDefinition(): VirtualNovelSceneDefinition {
    val sceneNameLength = readInt()
    val sceneId = readUtf8(sceneNameLength.toLong())
    val invert = readByte().toInt() == 1

    val hasCustomColour = readByte() == (1).toByte()
    val colour = if (hasCustomColour) readColour() else null

    val hasCustomTopText = readByte() == (1).toByte()
    val topText = if (hasCustomTopText) {
        val size = readInt()
        readUtf8(size.toLong())
    } else null

    val pageCount = readByte().toInt()
    val pages = mutableListOf<String>()

    for (idx in 0 until pageCount) {
        val size = readInt().toLong()
        val data = readUtf8(size)
        pages.add(data)
    }

    val nodes = pages.map { splitScene(it, v = sceneId == "sussex-july-3-school-3") }

    val buttons = mutableMapOf<String, ButtonManager.Button>()
    val buttonCount = readByte().toInt()
    for (idx in 0 until buttonCount) {
        val type = ButtonManager.ButtonType.values()[readInt()]
        val size1 = readInt()
        val name = readUtf8(size1.toLong())
        val size2 = readInt()
        val linkedSceneId = readUtf8(size2.toLong())

        when {
            // special case back-button
            name == "back-button" -> {
                buttons["back-button"] = ButtonManager.Button(name) {
                    SS76.sceneManager.exitScene()
                }
            }

            type == ButtonManager.ButtonType.PUSH -> {
                buttons[name] = ButtonManager.Button(
                    name, linkedId = linkedSceneId, buttonType = type
                ) { SS76.sceneManager.pushScene(linkedSceneId) }
            }

            type == ButtonManager.ButtonType.CHANGE -> {
                buttons[name] = ButtonManager.Button(
                    name, linkedId = linkedSceneId, buttonType = type
                ) { SS76.sceneManager.changeScene(linkedSceneId) }
            }

            else -> error("invalid button read from stream ($name $linkedSceneId $type)")
        }
    }

    return VirtualNovelSceneDefinition(
        sceneId, buttons, nodes, originalPages = pages,
        effects = SceneEffects.NONE
        //clearScreenColour = colour, changedTopText = topText,
        //invert = invert
    )
}

public fun BufferedSink.writeSceneDefinition(definition: VirtualNovelSceneDefinition) {
    val sceneId = definition.id.encodeUtf8()
    buffer.writeInt(sceneId.size)
    buffer.write(sceneId)
    //buffer.writeByte(if (definition.invert) 1 else 0)

    /*if (definition.clearScreenColour != null) {
        buffer.writeByte(1)
        buffer.writeColour(definition.clearScreenColour)
    } else {
        buffer.writeByte(0)
    }

    if (definition.changedTopText != null) {
        buffer.writeByte(1)
        val tt = definition.changedTopText.encodeUtf8()
        buffer.writeInt(tt.size)
        buffer.write(tt)
    } else {
        buffer.writeByte(0)
    }*/

    buffer.writeByte(definition.pageCount)
    for (pageIdx in 0 until definition.pageCount) {
        val encoded = definition.originalPages[pageIdx].encodeUtf8()
        buffer.writeInt(encoded.size)
        buffer.write(encoded)
    }

    buffer.writeByte(definition.originalButtons.size)
    for ((name, button) in definition.originalButtons) {
        val type = button.buttonType.ordinal
        buffer.writeInt(type)
        val nameEncoded = name.encodeUtf8()
        buffer.writeInt(nameEncoded.size)
        buffer.write(nameEncoded)

        val sceneEncoded = button.linkedId?.encodeUtf8() ?: ByteString.EMPTY
        buffer.writeInt(sceneEncoded.size)
        buffer.write(sceneEncoded)
    }
}
