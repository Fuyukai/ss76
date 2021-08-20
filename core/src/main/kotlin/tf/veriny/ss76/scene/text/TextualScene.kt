package tf.veriny.ss76.scene.text

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Cursor
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import ktx.app.KtxInputAdapter
import tf.veriny.ss76.SS76
import tf.veriny.ss76.ignore
import tf.veriny.ss76.scene.Scene
import tf.veriny.ss76.use
import kotlin.math.floor
import kotlin.math.min

/**
 * A textual scene that draws words.
 */
public abstract class TextualScene(
    /** The list of handlers to call when this scene loads. */
    private val onLoad: List<(Scene) -> Unit>
) : Scene() {
    public companion object {
        private const val FRAMES_PER_WORD = 5


        public var GLITCHY: Boolean = true
    }

    private val padding: Float
        get() {
            return if (SS76.isBabyScreen) {
                50f
            } else {
                90f
            }
        }

    protected open inner class TextualSceneInput : KtxInputAdapter {
        @Suppress("JoinDeclarationAndAssignment")
        private fun hit(screenX: Int, screenY: Int): LinkNode? {
            /*val isBabyScreen = (Gdx.graphics.height < 960)*/

            val realX: Float
            val realY: Float

            /*if (isBabyScreen) {
                realX = (screenX.toFloat()) * 1280 / 800
                realY = (600 - screenY.toFloat()) * 960 / 600
            } else {*/
                realX = screenX.toFloat()
                realY = (Gdx.graphics.height - screenY.toFloat())
            //}

            for ((node, rect) in knownLinkPositions.entries) {
                if (rect.contains(realX, realY)) {
                    return node
                }
            }

            return null
        }

        override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
            if (hit(screenX, screenY) != null) {
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand)
            } else {
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow)
            }
            return true
        }

        override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
            val node = hit(screenX, screenY)
            if (node == null) {
                // allow skipping
                timer = 999999
            } else {
                node.action.invoke(this@TextualScene)
            }

            return true
        }

        override fun keyDown(keycode: Int): Boolean {
            if (keycode == Input.Keys.SPACE || keycode == Input.Keys.ENTER) {
                timer = 999999
                return true
            }

            return false
        }
    }

    public override val input: InputProcessor = TextualSceneInput()

    protected val layout: GlyphLayout = GlyphLayout()

    // if you leave it open for a year, the timer will overflow and start redrawing. so, uh, don't
    // do that.
    public var timer: Int = 0

    private var currentXOffset = 0f
    private var currentYOffset = 0f

    // mapping of drawn link positions to their ""collision"" rectangles.
    // this is only a mapping to avoid duplicates, otherwise we do linear searches.
    private val knownLinkPositions: MutableMap<LinkNode, Rectangle> = mutableMapOf()

    override fun sceneActive() {
        for (load in onLoad) {
            load.invoke(this)
        }
        // positions may shift due to removing the !.
        knownLinkPositions.clear()
    }

    // stub inactive because we don't want to reset the timer.
    override fun sceneInactive(): Unit = Unit
    override fun reset() {
        timer = 0
        knownLinkPositions.clear()
    }

    /**
     * Gets the text for the current page. Use empty lines to split paragraphs. Lines longer
     * than 80 characters will be word wrapped.
     */
    public abstract fun getTextToRender(): List<TextualNode>

    protected fun drawFont(font: BitmapFont, text: String) {
        layout.setText(font, text)
        val width = layout.width + SS76.spaceWidth

        val yOffset = Gdx.graphics.height - padding - currentYOffset

        font.draw(SS76.batch, text, padding + currentXOffset, yOffset)
        currentXOffset += width
    }

    @Suppress("IMPLICIT_CAST_TO_ANY")
    protected fun drawNode(node: TextualNode) {
        when (node) {
            is WordNode -> {
                drawFont(SS76.WHITE_FONT, node.word)
            }
            is Newline -> {
                currentXOffset = 0f
                // 2 pixel offset to avoid conjoining Ys to Gs
                currentYOffset += SS76.lineHeight + 2f
            }
            is LinkNode -> {
                val font: BitmapFont
                val text: String

                when (node.type) {
                    LinkNode.LinkType.NEXT_SCENE -> {
                        font = SS76.ORANGE_FONT
                        text = node.word
                    }
                    LinkNode.LinkType.BACK_BUTTON -> {
                        font = SS76.GREEN_FONT
                        text = node.word
                    }
                    LinkNode.LinkType.PUSH_LINK -> {
                        val visited = node.id in SS76.visited
                        font = if (visited) SS76.GREEN_FONT else SS76.RED_FONT
                        text = if (visited) node.word else "! ${node.word}"
                    }
                }

                // figure out rectangle, BEFORE doing the render, as render updates currentXOffset
                if (node !in knownLinkPositions) {
                    layout.setText(font, text)
                    val rect = Rectangle(
                        padding + currentXOffset,
                        (Gdx.graphics.height - padding) - currentYOffset - layout.height,
                        layout.width, layout.height
                    )
                    knownLinkPositions[node] = rect
                }

                drawFont(font, text)

            }
            is Pad -> {
                currentXOffset += SS76.spaceWidth * node.count
            }
            else -> TODO()
        }.ignore()
    }

    /**
     * Draws any components anchored to the top of the screen. This will be called before the main
     * text is rendered.
     */
    public open fun drawTopAnchor() {}


    override fun draw() {
        currentXOffset = 0f
        currentYOffset = 0f

        // 80px of padding on each side
        // window is 1280 wide

        // draw filled black rect for VN "window"
        SS76.shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            if (SS76.isBabyScreen) {
                rect(
                    35f, 35f, 800 - (35f * 2), 600 - (35f * 2),
                    Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
                )
            } else {
                rect(
                    75f, 75f, 1280 - (75f * 2), 960 - (75f * 2),
                    Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
                )
            }
        }


        SS76.batch.use {
            drawTopAnchor()

            val words = getTextToRender()
            val nodesToDraw = min(words.size, (timer.floorDiv(FRAMES_PER_WORD)))
            if (nodesToDraw <= 0) {
                timer++
                return
            }

            // offsets ignore the padding.
            for (i in 0 until nodesToDraw) {
                val node = words[i]

                drawNode(node)
            }

            if (nodesToDraw + 1 < words.size) {
                // NB: Doing +1 creates an off-by-one error, but makes a REALLY cool effect.
                val nextNode = if (GLITCHY) {
                    words[nodesToDraw + 1]
                } else {
                    words[nodesToDraw]
                }

                if (nextNode is WordNode && nextNode.word.isNotEmpty()) {
                    // if the word length is less than frames_per_word, we can't smoothly
                    // interpolate it. instead we just do a percentage divide of the remainder
                    // and apply that to the word length, rounded down.
                    val remainder = timer.rem(FRAMES_PER_WORD).toDouble()
                    val fraction = (remainder / FRAMES_PER_WORD)
                    val sliceUpper = floor(nextNode.word.length * fraction).toInt()
                    val toRender = nextNode.word.substring(0..sliceUpper)
                    drawFont(SS76.WHITE_FONT, toRender)
                }
            }

            timer++
        }
    }

}