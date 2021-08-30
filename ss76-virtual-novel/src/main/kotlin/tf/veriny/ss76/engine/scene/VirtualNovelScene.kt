package tf.veriny.ss76.engine.scene

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.DeactivationType
import tf.veriny.ss76.use
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

/**
 * A virtual novel scene, with text.
 */
public class VirtualNovelScene(
    public val definition: VirtualNovelSceneDefinition
) {
    public val id: String get() = definition.id

    private val padding: Float
        get() = if (SS76.isBabyScreen) 60f else 90f

    private var currentXOffset = 0f
    private var currentYOffset = 0f

    private var pageIdx = 0

    private val glyphLayout = GlyphLayout()

    /**
     * Called when the scene is loaded.
     */
    public fun sceneLoaded() {
        SS76.buttonManager.reset()
        definition.onLoadHandlers.forEach { it.invoke(this) }
    }

    public fun sceneUnloaded(reason: DeactivationType) {
        when (reason) {
            DeactivationType.POPPED -> { resetTimer() }
            DeactivationType.PUSHED -> {}
        }

        SS76.buttonManager.reset()
    }

    public fun pageBack() {
        SS76.buttonManager.reset()
        pageIdx--
        timer = 0
    }

    public fun pageForward() {
        SS76.buttonManager.reset()
        pageIdx++
        timer = 0
    }

    // frame timer
    private var timer = 0

    public fun resetTimer() {
        timer = 0
    }

    /** Sets the timer to a reasonably high value. */
    public fun skipTimer() {
        timer = 9999999
    }

    // == Input == //

    private fun newline() {
        currentXOffset = 0f
        currentYOffset += SS76.fontManager.fontHeight + 2f
    }

    /**
     * Raw word renderer. Doesn't handle anything but writing the words to the screen.
     */
    private fun renderWordRaw(
        word: String,
        colour: Color,
        effects: Set<TextualNode.Effect> = setOf(),
        calcRectangle: Boolean = false
    ): Rectangle? {
        //println(SS76.fontManager.currentFont.fonts.entries)
        val font = SS76.fontManager.currentFont.fonts[colour] ?: error("unknown colour $colour")
        glyphLayout.setText(font, word)

        var xOffset = padding + currentXOffset
        var yOffset = Gdx.graphics.height - padding - currentYOffset

        if (TextualNode.Effect.SHAKE in effects) {
            xOffset += Random.Default.nextInt(-2, 2)
            yOffset += Random.Default.nextInt(-1, 1)
        }

        font.draw(SS76.batch, word, xOffset, yOffset)
        // no space, that's handled by the external code
        // avoid calculating rectangles for anything that isn't a link node.
        val rect = if (calcRectangle) {
            Rectangle(
                padding + currentXOffset,
                (Gdx.graphics.height - padding) - currentYOffset - glyphLayout.height,
                glyphLayout.width, glyphLayout.height
            )
        } else null
        currentXOffset += glyphLayout.width

        return rect
    }

    /**
     * This is where all the fun happens.
     *
     * @param frameNode: The node to use frame numbers from.
     * @param node: The node to use for actually drawing.
     */
    private fun renderTextNode(frameNode: TextualNode, node: TextualNode = frameNode) {
        // == Before == //
        currentXOffset += SS76.fontManager.characterWidth * frameNode.padding

        // == Render == //
        var colour = node.colour
        var text = node.text
        var isTruncated = false

        // truncate text appropriate, if needed
        if (timer < frameNode.endFrame) {
            val totalFrames = (frameNode.endFrame - frameNode.startFrame).toFloat()
            val framesLeft = (frameNode.endFrame - timer).toFloat()
            val fraction = 1 - (framesLeft / totalFrames)
            val length = ceil((text.length * fraction)).toInt()
            if (length < text.length) {
                isTruncated = true
                text = text.substring(0..length)
            }
        }

        // override red/green if the node is linked to a button
        if (node.colourLinkedToButton) {
            val button = definition.buttons[node.buttonId]
            check(button != null) { "node linked to non-existent button?" }
            val visited = SS76.sceneManager.hasVisitedScene(button.linkedId!!)
            colour = if (visited) {
                Color.GREEN
            } else {
                Color.RED
            }
        }

        if (node.text.isNotEmpty()) {
            val shouldCalcRectangle = !isTruncated && node.buttonId != null
            val rect = renderWordRaw(
                text, colour, node.effects, calcRectangle = shouldCalcRectangle
            )
            if (rect != null) {
                val button = definition.buttons[node.buttonId]
                check(button != null) { "node linked to non-existent button ${node.buttonId}" }
                SS76.buttonManager.addClickableArea(button, rect)
            }
        }

        // == After == //
        if (node.causesSpace) {
            currentXOffset += SS76.fontManager.characterWidth
        }

        if (node.causesNewline) {
            newline()
        }
    }

    // cache page buttons

    /**
     * Renders the paging buttons.
     */
    private fun getPageButtons(): List<TextualNode> {
        val nodes = mutableListOf<TextualNode>()
        for (b in listOf("«", "PREVIOUS")) {
            val node = TextualNode(
                b, startFrame = 0, endFrame = 0, buttonId = "page-back",
                colour = Color.SALMON
            )
            nodes.add(node)
        }

        for (b in "== PAGE ${pageIdx + 1}/${definition.pageCount} ==".split(" ")) {
            val node = TextualNode(b, startFrame = 0, endFrame = 0, colour = Color.WHITE)
            nodes.add(node)
        }

        nodes.add(TextualNode(
            "NEXT", startFrame = 0, endFrame = 0, buttonId = "page-next",
            colour = Color.SALMON
        ))
        nodes.add(
            TextualNode(
                "»", startFrame = 0, endFrame = 0, buttonId = "page-next",
                colour = Color.SALMON, causesNewline = true
            )
        )

        // blank newline
        nodes.add(TextualNode("", startFrame = 0, endFrame = 0, causesNewline = true))

        return nodes
    }

    /**
     * Called when the scene is rendered.
     */
    public fun render() {
        // Step 0) Update offsets.
        currentXOffset = 0f
        currentYOffset = 0f

        // Step 1) Render the black box.
        SS76.shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            if (SS76.isBabyScreen) {
                rect(
                    47f, 47f, 800 - (47f * 2), 600 - (47f * 2),
                    Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
                )
            } else {
                rect(
                    75f, 75f, 1280 - (75f * 2), 960 - (75f * 2),
                    Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
                )
            }
        }

        // Step 2) Load the data for the scene definition.
        definition.loadThisFrame()

        // Step 3) Begin drawing.
        SS76.batch.use {
            // 3a) Draw pages if needed.
            if (definition.pageCount > 1) {
                pageIdx = min(max(pageIdx, 0), definition.pageCount - 1)
                val pageButtons = getPageButtons()
                for (node in pageButtons) {
                    renderTextNode(node)
                }
            }

            // 3b) Draw the current nodes, including glitchy nodes.
            val nodes = definition.getTokensForPage(pageIdx)
            // tfw need manual iterator
            val it = nodes.iterator()
            while (it.hasNext()) {
                val node = it.next()
                // text scroll: nodes past the current timer aren't drawn
                if (node.startFrame > timer) break
                // glitchy text scroll: if this node would be truncated, instead use the node
                // one over
                if (
                    node.startFrame < timer &&
                    node.endFrame > timer &&
                    it.hasNext()
                ) {
                    val nextNode = it.next()
                    renderTextNode(node, nextNode)
                } else {
                    renderTextNode(node)
                }
            }

            // 3c) Draw clickables at the bottom.

        }

        timer++

    }

}