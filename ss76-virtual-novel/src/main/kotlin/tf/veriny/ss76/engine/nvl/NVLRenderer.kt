package tf.veriny.ss76.engine.nvl

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import ktx.app.clearScreen
import tf.veriny.ss76.SS76
import tf.veriny.ss76.SS76.batch
import tf.veriny.ss76.engine.ButtonManager
import tf.veriny.ss76.engine.FontManager
import tf.veriny.ss76.engine.renderer.TextRendererMixin
import tf.veriny.ss76.engine.scene.SceneState
import tf.veriny.ss76.engine.scene.TextualNode
import tf.veriny.ss76.use
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin
import kotlin.random.Random

/**
 * A renderer for a scene in NVL mode.
 */
public class NVLRenderer : TextRendererMixin() {
    private companion object {
        private val BACKGROUND_BG = Color(48/255f, 48/255f, 48/255f, 0f)
    }

    // lightning effect timer
    private var lastLightningMax = 0
    private var lightningTimer = 0

    /**
     * Raw word renderer. Doesn't handle anything but writing the words to the screen.
     */
    override fun renderWordRaw(
        font: FontManager.Font,
        colour: Color,
        word: String,
        effects: Set<TextualNode.Effect>,
        calcRectangle: Boolean
    ): Rectangle? {
        //println(SS76.fontManager.currentFont.fonts.entries)
        val bitmapFont = font.fonts[colour]!!
        glyphLayout.setText(bitmapFont, word)

        var xOffset = padding + currentXOffset
        var yOffset = Gdx.graphics.height - padding - currentYOffset

        if (TextualNode.Effect.SHAKE in effects) {
            xOffset += Random.Default.nextInt(-2, 2)
            yOffset += Random.Default.nextInt(-1, 1)
        }

        bitmapFont.draw(SS76.batch, word, xOffset, yOffset)
        // no space, that's handled by the external code
        // avoid calculating rectangles for anything that isn't a link node.
        val rect = if (calcRectangle) {
            val extraWidth = font.characterWidth
            Rectangle(
                padding + currentXOffset - (extraWidth / 2),
                (Gdx.graphics.height - padding) - currentYOffset - glyphLayout.height,
                glyphLayout.width + extraWidth, glyphLayout.height
            )
        } else null

        currentXOffset += glyphLayout.width

        return rect
    }

    // cache page buttons

    /**
     * Renders the paging buttons.
     */
    private fun getPageButtons(state: SceneState): List<TextualNode> {
        if (!state.definition.enablePagination) return emptyList()

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
        val font = SS76.fontManager.defaultFont
        val width = font.characterWidth

        /*val isUpdated = SS76.record.updated
        if (isUpdated) {
            glyphLayout.setText(SS76.fontManager.currentFont.white, "Checkpoint / ! Record")
        } else {
            glyphLayout.setText(SS76.fontManager.currentFont.white, "Checkpoint / Record")
        }*/
        currentXOffset = -width
        currentYOffset = -glyphLayout.height * 2

        run {
            val rect = renderWordRaw(font, Color.GREEN, "Inventory", calcRectangle = true)
            SS76.buttonManager.addClickableArea(ButtonManager.INVENTORY_BUTTON, rect!!)
        }

        // scroll to the right side again
        glyphLayout.setText(font.white, "Up / Checkpoint")
        currentXOffset = (Gdx.graphics.width - padding - border - (glyphLayout.width))

        run {
            val rect = renderWordRaw(font, Color.GREEN, "Up", calcRectangle = true)
            SS76.buttonManager.addClickableArea(ButtonManager.GLOBAL_BACK_BUTTON, rect!!)
        }
        currentXOffset += width
        renderWordRaw(font, Color.WHITE, "/")
        currentXOffset += width
        run {
            val rect = renderWordRaw(font, Color.GREEN, "Checkpoint", calcRectangle = true)
            SS76.buttonManager.addClickableArea(ButtonManager.CHECKPOINT_BUTTON, rect!!)
        }
    }

    /**
     * Called when the scene is rendered.
     */
    public fun render(state: SceneState) {
        reseedRng(state.timer)
        SS76.buttonManager.reset()

        val definition = state.definition
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

        if (bgColour != null) {
            clearScreen(bgColour.r, bgColour.g, bgColour.b, bgColour.a)
        } else {
            val timer = SS76.globalTimer
            val blue = 0.25f * sin(timer / 100f) + 0.75f
            val green = 1 - (0.25f * sin(timer / 100f) + 0.75f)
            val red = 1 - (0.25f * cos(timer / 100f) + 0.75f)

            clearScreen(red, green, blue, 0f)
        }

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
            drawWords(state)

            if (!state.definition.effects.disableClickables) {
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

                // 6) Draw debug scene data
                if (SS76.IS_DEBUG) {
                    if (SS76.isBabyScreen) {
                        SS76.fontManager.defaultFont.white.draw(
                            batch,
                            "Scene ID: ${SS76.sceneManager.currentScene.definition.id}",
                            15f,
                            20f
                        )
                    } else {
                        SS76.fontManager.defaultFont.white.draw(
                            batch,
                            "Scene ID: ${SS76.sceneManager.currentScene.definition.id}",
                            15f,
                            50f
                        )
                    }
                }
            }
        }

        state.timer++
    }

}