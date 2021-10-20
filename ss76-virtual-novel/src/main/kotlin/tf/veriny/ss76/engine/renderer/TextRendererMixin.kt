package tf.veriny.ss76.engine.renderer

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.math.Rectangle
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.FontManager
import tf.veriny.ss76.engine.scene.SceneState
import tf.veriny.ss76.engine.scene.TextualNode
import tf.veriny.ss76.mojibakify
import tf.veriny.ss76.randomChar
import kotlin.math.ceil
import kotlin.random.Random

public abstract class TextRendererMixin {

    protected val glyphLayout: GlyphLayout = GlyphLayout()

    // rng that is deterrministic for 30 frames
    protected var rng: Random = Random(0)
    // true rng that is never re-seeded
    protected val trueRng: Random = Random.Default

    protected fun reseedRng(timer: Int) {
        rng = Random(timer.floorDiv(30))
    }

    protected open var currentXOffset: Float = 0f
    protected open var currentYOffset: Float = 0f

    protected open fun newline(font: FontManager.Font) {
        currentXOffset = 0f
        currentYOffset += font.characterHeight + 2f
    }

    /**
     * Raw word renderer. Doesn't handle anything but writing the words to the screen.
     */
    protected abstract fun renderWordRaw(
        font: FontManager.Font,
        colour: Color,
        word: String,
        effects: Set<TextualNode.Effect> = setOf(),
        calcRectangle: Boolean = false,
    ): Rectangle?

    /**
     * This is where all the fun happens.
     *
     * @param frameNode: The node to use frame numbers from.
     * @param node: The node to use for actually drawing.
     */
    protected open fun renderTextNode(
        state: SceneState,
        frameNode: TextualNode, node: TextualNode = frameNode
    ) {
        val font = SS76.fontManager.fonts[node.font] ?: error("${node.font} is not a valid font")
        // == Before == //
        currentXOffset += font.characterWidth * frameNode.padding

        var colour = node.colour
        if (state.definition.effects.invert) {
            if (colour == Color.WHITE) colour = Color.BLACK
            else if (colour == Color.BLACK) colour = Color.WHITE
        }

        var text = node.text
        var isTruncated = false

        // truncate text appropriate, if needed
        if (state.timer < frameNode.endFrame) {
            val totalFrames = (frameNode.endFrame - frameNode.startFrame).toFloat()
            val framesLeft = (frameNode.endFrame - state.timer).toFloat()
            val fraction = 1 - (framesLeft / totalFrames)
            val length = ceil((text.length * fraction)).toInt()
            if (length < text.length) {
                isTruncated = true
                text = text.substring(0..length)
            }
        }

        //if (state.definition.effects.mojibake && text.isNotEmpty() && rng.nextBoolean()) {
        //    text = text.mojibakify(rng)
        //}

        // override red/green if the node is linked to a button
        if (node.colourLinkedToButton) {
            val button = state.definition.buttons[node.buttonId]
            check(button != null) { "node linked to non-existent button?" }
            val visited = SS76.sceneManager.hasVisitedScene(button.linkedId!!)
            colour = if (visited) {
                Color.GREEN
            } else {
                Color.RED
            }
        }

        if (TextualNode.Effect.SHUFNUM in node.effects) {
            val sb = StringBuilder()
            for (char in text) {
                if (char.isDigit()) {
                    sb.append(rng.nextInt(0, 9))
                } else {
                    sb.append(char)
                }
            }
            text = sb.toString()
        } else if (TextualNode.Effect.SHUFTXT in node.effects) {
            text = buildString {
                // undo truncation. gretchy said this was a cool eeffect...
                for (c in node.text) {
                    if (c.isDigit() || c.isLetter()) {
                        append(randomChar(rng))
                    } else {
                        append(c)
                    }
                }
            }
        }

        if (TextualNode.Effect.MOJIBAKE in node.effects) {
            text = text.mojibakify(rng)
        }

        // == Render == //
        if (node.text.isNotEmpty()) {
            val shouldCalcRectangle = !isTruncated && node.buttonId != null
            val rect = renderWordRaw(
                font, colour, text, node.effects, calcRectangle = shouldCalcRectangle
            )
            if (rect != null) {
                val button = state.definition.buttons[node.buttonId]
                check(button != null) { "node linked to non-existent button ${node.buttonId}" }
                SS76.buttonManager.addClickableArea(button, rect)
            }
        }

        // == After == //
        if (node.causesSpace) {
            currentXOffset += font.characterWidth
        }

        if (node.causesNewline) {
            newline(font)
        }
    }

    protected fun drawWords(state: SceneState) {
        val nodes = state.definition.getTokensForPage(state.pageIdx)
        // tfw need manual iterator
        val it = nodes.iterator()
        while (it.hasNext()) {
            val node = it.next()
            if (node.effects.contains(TextualNode.Effect.RESET)) {
                state.timer = 0
                break
            }

            // text scroll: nodes past the current timer aren't drawn
            if (node.startFrame > state.timer) break
            // glitchy text scroll: if this node would be truncated, instead use the node
            // one over
            if (
                node.startFrame < state.timer &&
                node.endFrame > state.timer &&
                it.hasNext()
            ) {
                val nextNode = it.next()
                renderTextNode(state, node, nextNode)
            } else {
                renderTextNode(state, node)
            }
        }
    }
}