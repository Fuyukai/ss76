package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.adv.ADVSubRenderer
import tf.veriny.ss76.engine.scene.SceneState
import tf.veriny.ss76.use

// TODO: Make disposable
/**
 * Renders the cars.
 */
public class CarRenderer : ADVSubRenderer {
    private companion object {
        private val ATLAS = TextureAtlas(Gdx.files.internal("gfx/car-renderer.atlas"))
    }

    private val tiles = listOf(
        "grass", "grass", "grass",  // embankment right
        "road-side", "road-stripe-left",
        "road-stripe-right", "road-stripe-left", "road-stripe-right", "road-stripe-left",
        "road-stripe-right", "road-side-2",
        "grass", "grass-rail-left", "grass-rail-right", "grass",
        "road-side", "road-stripe-left",
        "road-stripe-right", "road-stripe-left", "road-stripe-right", "road-stripe-left",
        "road-stripe-right", "road-side-2",
        "grass", "grass", "grass"
    )

    private var timer = 0

    private fun renderCars() {

    }

    override fun render(batch: SpriteBatch, sceneState: SceneState) {
        var xOffset: Float
        for (y in 0..16) {
            xOffset = 0f
            for (tile in tiles) {
                val region = ATLAS.findRegion(tile)!!
                val offset = timer.mod(region.originalHeight)
                batch.draw(region, xOffset, y * region.originalHeight.toFloat() - offset)
                xOffset += region.originalWidth
            }
        }

        renderCars()

        timer++
    }
}