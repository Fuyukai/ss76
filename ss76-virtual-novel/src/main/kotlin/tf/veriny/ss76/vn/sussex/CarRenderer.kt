package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.math.Vector
import com.badlogic.gdx.math.Vector2
import tf.veriny.ss76.engine.adv.ADVSubRenderer
import tf.veriny.ss76.engine.scene.SceneState
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

// TODO: Make disposable
/**
 * Renders the cars.
 */
public class CarRenderer : ADVSubRenderer {
    private companion object {
        private val ATLAS = TextureAtlas(Gdx.files.internal("gfx/ss76.atlas"))
        private val GRID_SIZE = ATLAS.regions[0].originalWidth

        private val TILES = listOf(
            "grass", "grass",  // embankment right
            "road-side-new", "road-stripe-left",
            "road-stripe-right", "road-stripe-left",
            "road-stripe-right", "road-side-2-new",
            "grass", "grass-rail-left-new", "grass-rail-right-new", "grass",
            "road-side-new", "road-stripe-left",
            "road-stripe-right", "road-stripe-left",
            "road-stripe-right", "road-side-2-new",
            "grass", "grass", "grass"
        )
    }

    private class Lane(val gridOffset: Float, val speed: Float) {
        val cars: MutableList<Vector2> = mutableListOf()
        var spawnTimer = 0
    }

    /** If spooky mode is on. */
    public var spooky: Boolean = false

    private var timer = 0

    private val lanes = arrayOf(
        Lane(3f, 7f), Lane(7f, 3f)
    )

    private fun renderCars(batch: SpriteBatch) {
        // our car (red car) is on the middle lane (overtaking people. what a cunt)
        val redCar = ATLAS.findRegion("boat-red")
        val blueCar = ATLAS.findRegion("boat")

        val sineOffset = cos((timer.floorDiv(10).mod(180)).toFloat()) * 2f
        var redCarPos = (5f * GRID_SIZE) - (redCar.packedWidth / 2)
        if (!spooky) redCarPos += sineOffset
        val yOffset = ((16 - 8f) * GRID_SIZE)

        batch.draw(redCar, redCarPos, yOffset)

        for (lane in lanes) {
            if (!spooky && lane.cars.size < 3 && lane.spawnTimer <= 0) {
                var xPos = (lane.gridOffset * GRID_SIZE) - (blueCar.packedWidth / 2)
                xPos += (sineOffset * 4f)
                val newPos = Vector2(xPos, 16f * GRID_SIZE)
                lane.cars.add(newPos)
                lane.spawnTimer = Random.Default.nextInt(30, 180)
            }

            for ((idx, car) in lane.cars.toMutableList().withIndex()) {
                if (car.y < 0f) {
                    lane.cars.removeAt(idx)
                } else {
                    batch.draw(blueCar, car.x, car.y)
                    car.y -= lane.speed
                }
            }

            lane.spawnTimer--
        }

    }

    override fun render(batch: SpriteBatch, sceneState: SceneState) {
        var xOffset: Float
        for (y in 0..20) {
            xOffset = 0f
            for (tile in TILES) {
                val region = ATLAS.findRegion(tile)!!
                val offset = timer.mod(region.originalHeight)
                batch.draw(region, xOffset, y * region.originalHeight.toFloat() - (offset * 6))
                xOffset += region.originalWidth
            }
        }

        renderCars(batch)

        timer++
    }
}