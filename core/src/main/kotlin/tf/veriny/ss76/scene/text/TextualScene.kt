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
        private const val FRAMES_PER_WORD = 3
        private const val PADDING = 90

        public var GLITCHY: Boolean = true
    }

    protected open inner class TextualSceneInput : KtxInputAdapter {
        private fun hit(screenX: Int, screenY: Int): TextualNode.LinkNode? {
            val realX = screenX.toFloat()
            val realY = Gdx.graphics.height - (screenY.toFloat())
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
    private val knownLinkPositions: MutableMap<TextualNode.LinkNode, Rectangle> = mutableMapOf()

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

        font.draw(SS76.batch, text, PADDING + currentXOffset, (960 - PADDING) - currentYOffset)
        currentXOffset += width
    }

    @Suppress("IMPLICIT_CAST_TO_ANY")
    protected fun drawNode(node: TextualNode) {
        when (node) {
            is TextualNode.WordNode -> {
                drawFont(SS76.WHITE_FONT, node.word)
            }
            is TextualNode.Newline -> {
                currentXOffset = 0f
                // 2 pixel offset to avoid conjoining Ys to Gs
                currentYOffset += SS76.lineHeight + 2f
            }
            is TextualNode.LinkNode -> {
                val visited = node.id in SS76.visited || node.skipSeen
                val font = if (visited) SS76.GREEN_FONT else SS76.RED_FONT
                val text = if (visited) node.word else "! " + node.word

                // figure out rectangle, BEFORE doing the render, as render updates currentXOffset
                if (node !in knownLinkPositions) {
                    layout.setText(font, text)
                    val rect = Rectangle(
                        PADDING + currentXOffset,
                        (960 - PADDING) - currentYOffset - layout.height,
                        layout.width, layout.height
                    )
                    knownLinkPositions[node] = rect
                }

                drawFont(font, text)

                Unit
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
            rect(
                75f, 75f, 1280 - (75f * 2), 960 - (75f * 2),
                Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK
            )
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

                if (nextNode is TextualNode.WordNode && nextNode.word.isNotEmpty()) {
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