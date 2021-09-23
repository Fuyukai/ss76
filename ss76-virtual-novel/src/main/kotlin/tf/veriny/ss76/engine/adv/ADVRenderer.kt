package tf.veriny.ss76.engine.adv

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.nvl.NVLRenderer
import tf.veriny.ss76.engine.renderer.TextRendererMixin
import tf.veriny.ss76.engine.scene.SceneState
import tf.veriny.ss76.engine.scene.TextualNode
import tf.veriny.ss76.roundedRect
import tf.veriny.ss76.use
import kotlin.random.Random

/**
 * The renderer for ADV scenes.
 */
public class ADVRenderer(
    public val subRenderer: ADVSubRenderer
) : TextRendererMixin() {
    // FUCK IT
    private val ownBatch = SpriteBatch()

    private val camera = OrthographicCamera(1280f, 960f).also {
        it.setToOrtho(false, 1280f, 960f)
        it.update()

        ownBatch.projectionMatrix = it.combined
    }

    private val padding: Float
        get() = /*if (SS76.isBabyScreen) 60f else*/ 90f

    private val yBoxOffset get() = 3 * (Gdx.graphics.height.toFloat() / 4f)

    override fun renderWordRaw(
        word: String,
        colour: Color,
        effects: Set<TextualNode.Effect>,
        calcRectangle: Boolean
    ): Rectangle? {
        val font = SS76.fontManager.currentFont.fonts[colour] ?: error("unknown colour $colour")
        glyphLayout.setText(font, word)

        var xOffset = padding + currentXOffset
        var yOffset = (Gdx.graphics.height - yBoxOffset) - currentYOffset

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
                (Gdx.graphics.height - yBoxOffset) - currentYOffset - glyphLayout.height,
                glyphLayout.width + extraWidth, glyphLayout.height
            )
        } else null

        currentXOffset += glyphLayout.width

        return rect
    }

    /**
     * Renders the ADV mode screen.
     */
    public fun render(sceneState: SceneState) {
        reseedRng(sceneState.timer)
        SS76.buttonManager.reset()
        val batch = SS76.batch
        val shape = SS76.shapeRenderer

        ownBatch.use { subRenderer.render(ownBatch, sceneState) }

        //shape.projectionMatrix = camera.combined
        shape.use(ShapeRenderer.ShapeType.Filled) {
            color = Color.BLACK
            val pad = /*if (SS76.isBabyScreen) 47f else*/ 75f
            roundedRect(pad, 15f,
                Gdx.graphics.width - (pad * 2),
                Gdx.graphics.height - yBoxOffset,
                15f
            )
        }

        batch.use {
            currentXOffset = 0f
            currentYOffset = 0f
            drawWords(sceneState)
        }



        sceneState.timer++
    }
}