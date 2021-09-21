package tf.veriny.ss76.engine.renderer

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import ktx.app.clearScreen
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.ButtonManager
import tf.veriny.ss76.engine.DeactivationType
import tf.veriny.ss76.engine.scene.SceneDefinition
import tf.veriny.ss76.engine.scene.SceneState
import tf.veriny.ss76.engine.scene.TextualNode
import tf.veriny.ss76.use
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

/**
 * A renderer for a scene in NVL mode.
 */
public class NVLRenderer : Renderer {
    private companion object {
        private val BACKGROUND_BG = Color(48/255f, 48/255f, 48/255f, 0f)

        fun randomString(r: Random, length: Int) : String {
            val chars = ('A'..'Z') + ('a'..'z')
            return (0 until length).joinToString("") { chars.random(r).toString() }
        }
    }

    private val padding: Float
        get() = if (SS76.isBabyScreen) 60f else 90f

    private var currentXOffset = 0f
    private var currentYOffset = 0f

    private val glyphLayout = GlyphLayout()

    // lightning effect timer
    private var lastLightningMax = 0
    private var lightningTimer = 0

    // rng that is deterrministic for 30 frames
    private var rng: Random = Random(0)
    // true rng that is never re-seeded
    private var trueRng: Random = Random(1024L)

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
        calcRectangle: Boolean = false,
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
            val extraWidth = SS76.fontManager.characterWidth
            Rectangle(
                padding + currentXOffset - (extraWidth / 2),
                (Gdx.graphics.height - padding) - currentYOffset - glyphLayout.height,
                glyphLayout.width + extraWidth, glyphLayout.height
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
    private fun renderTextNode(
        state: SceneState,
        frameNode: TextualNode, node: TextualNode = frameNode
    ) {
        // == Before == //
        currentXOffset += SS76.fontManager.characterWidth * frameNode.padding

        var colour = node.colour
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
            val size = node.text.length
            text = when {
                node.text.endsWith(".") -> randomString(rng, size - 1) + "."
                node.text.endsWith(",") -> randomString(rng, size - 1) + ","
                else -> randomString(rng, size)
            }
        }

        // == Render == //
        if (node.text.isNotEmpty()) {
            val shouldCalcRectangle = !isTruncated && node.buttonId != null
            val rect = renderWordRaw(
                text, colour, node.effects, calcRectangle = shouldCalcRectangle
            )
            if (rect != null) {
                val button = state.definition.buttons[node.buttonId]
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
    private fun getPageButtons(state: SceneState): List<TextualNode> {
        val nodes = mutableListOf<TextualNode>()
        for (b in listOf("«", "PREVIOUS")) {
            val node = TextualNode(
                b, startFrame = 0, endFrame = 0, buttonId = "page-back",
                colour = Color.SALMON
            )
            nodes.add(node)
        }

        val definition = state.definition
        for (b in "== PAGE ${state.pageIdx + 1}/${definition.pageCount} ==".split(" ")) {
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

    private fun drawClickables(border: Float) {
        val width = SS76.fontManager.characterWidth

        /*val isUpdated = SS76.record.updated
        if (isUpdated) {
            glyphLayout.setText(SS76.fontManager.currentFont.white, "Checkpoint / ! Record")
        } else {
            glyphLayout.setText(SS76.fontManager.currentFont.white, "Checkpoint / Record")
        }*/
        currentXOffset = -width
        currentYOffset = -glyphLayout.height * 2

        run {
            val rect = renderWordRaw("Inventory", Color.GREEN, calcRectangle = true)
            SS76.buttonManager.addClickableArea(ButtonManager.INVENTORY_BUTTON, rect!!)
        }

        // scroll to the right side again
        glyphLayout.setText(SS76.fontManager.currentFont.white, "Up / Checkpoint")
        currentXOffset = (Gdx.graphics.width - padding - border - (glyphLayout.width))

        run {
            val rect = renderWordRaw("Up", Color.GREEN, calcRectangle = true)
            SS76.buttonManager.addClickableArea(ButtonManager.GLOBAL_BACK_BUTTON, rect!!)
        }
        currentXOffset += width
        renderWordRaw("/", Color.WHITE)
        currentXOffset += width
        run {
            val rect = renderWordRaw("Checkpoint", Color.GREEN, calcRectangle = true)
            SS76.buttonManager.addClickableArea(ButtonManager.CHECKPOINT_BUTTON, rect!!)
        }
    }

    /**
     * Called when the scene is rendered.
     */
    public fun render(state: SceneState) {
        SS76.buttonManager.reset()

        val definition = state.definition
        rng = Random(state.timer.floorDiv(30))

        val bgColour = if (definition.effects.lightning) {
            val shouldDoFlash = trueRng.nextInt(0, 240) == 66
            if (shouldDoFlash) {
                lightningTimer = trueRng.nextInt(37, 174)
                lastLightningMax = lightningTimer
            } else {
                lightningTimer = max(lightningTimer - 1, 0)
            }

            if (lightningTimer <= 0 || lastLightningMax <= 0) {
                Color.BLACK
            } else {
                val perc/*ocet*/ = (lightningTimer.toFloat() / lastLightningMax.toFloat())
                Color(perc, perc, perc, 1f)
            }
        } else {
            definition.effects.backgroundColour
        }
        clearScreen(bgColour.r, bgColour.g, bgColour.b, bgColour.a)

        val invert = definition.effects.invert


        // Step 0) Update offsets.
        currentXOffset = 0f
        currentYOffset = 0f

        val border = if (SS76.isBabyScreen) 47f else 75f

        // Step 1) Render the black box.
        SS76.shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            val colour = if (definition.effects.invert) Color.WHITE else Color.BLACK

            if (SS76.isBabyScreen) {
                rect(
                    47f, 47f, 800 - (47f * 2), 600 - (47f * 2),
                    colour, colour, colour, colour
                )
            } else {
                rect(
                    75f, 75f, 1280 - (75f * 2), 960 - (75f * 2),
                    colour, colour, colour, colour
                )
            }

            /*// draw little backgrounds on the clickables
            // they extend (spaceWidth / 2) outside to "join" them
            val width = SS76.fontManager.characterWidth
            for ((button, rects) in SS76.buttonManager.buttonRects) {
                for (r in rects) {
                    rect(
                        r.x - (width/2), r.y - 4f, r.width + width, r.height + 4f,
                        BACKGROUND_BG, BACKGROUND_BG, BACKGROUND_BG, BACKGROUND_BG
                    )
                }
            }*/
        }

        // Step 2) Begin drawing.
        SS76.batch.use {
            // 3a) Draw pages if needed.
            if (definition.pageCount > 1) {
                val pageButtons = getPageButtons(state)
                for (node in pageButtons) {
                    renderTextNode(state, node)
                }
            }

            // 3b) Draw the current nodes, including glitchy nodes.
            val nodes = definition.getTokensForPage(state.pageIdx)
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

            if (!invert) {
                // 4) Draw clickables.
                drawClickables(border)

                // 5) Draw top text.
                val topText = definition.effects.topText
                glyphLayout.setText(SS76.fontManager.topTextFont, topText)
                val yOffset = Gdx.graphics.height - 10f
                SS76.fontManager.topTextFont.draw(
                    SS76.batch,
                    topText,
                    (Gdx.graphics.width / 2) - (glyphLayout.width / 2),
                    yOffset
                )
            }
        }

        state.timer++
    }

}