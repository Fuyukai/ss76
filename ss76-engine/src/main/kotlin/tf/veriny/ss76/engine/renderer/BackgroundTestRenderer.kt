package tf.veriny.ss76.engine.renderer

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import ktx.app.clearScreen
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.screen.Screen
import tf.veriny.ss76.use

/**
 * A test renderer for rendering various patterns on-screen.
 */
public class BackgroundTestRenderer : Screen {
    public companion object {
        public val PATTERNS: List<String> = listOf(
            "pink-blue-cb",
            "pink-stripes",
        )
        private const val GRID_SIZE = 64f
    }

    init {
        //SS76.buttonManager.reset()
    }

    private val atlas = TextureAtlas(Gdx.files.internal("gfx/backgrounds.atlas"))

    private var chosenIndex = 0
    private var chosenIndex2 = 0

    override fun render(delta: Float) {
        clearScreen(0f, 0f, 0f, 1f)

        val r1 = atlas.regions[chosenIndex]
        val r2 = atlas.regions[chosenIndex2]
        /*SS76.batch.use {
            for (x in 0..16) {
                for (y in 0..16) {
                    val region = if ((x + y) % (2) == 0) r1 else r2

                    val drawX = x * GRID_SIZE
                    val drawY = y * GRID_SIZE
                    draw(region, drawX, drawY)
                }
            }

            //SS76.fontManager.currentFont.white.draw(this, r1.name, (1280 - 400f), 200f)
            //SS76.fontManager.currentFont.white.draw(this, r2.name, (1280 - 400f), 100f)
        }*/

    }

    override fun keyDown(keycode: Int): Boolean {
        return when (keycode) {
            Input.Keys.ENTER -> {
                chosenIndex = (chosenIndex + 1).mod(atlas.regions.size)
                true
            }
            Input.Keys.SPACE -> {
                chosenIndex2 = (chosenIndex2 + 1).mod(atlas.regions.size)
                true
            }
            else -> {
                false
            }
        }

    }

    override fun dispose() {
        atlas.dispose()
    }
}