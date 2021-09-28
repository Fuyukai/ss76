package tf.veriny.ss76.engine.renderer.map

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.renderer.TileMapADVRenderer
import tf.veriny.ss76.engine.scene.SceneState
import tf.veriny.ss76.engine.util.murmurhash3_32
import tf.veriny.ss76.use
import kotlin.math.absoluteValue
import kotlin.math.roundToInt
import kotlin.random.Random

public class DoorRenderer : TileMapADVRenderer("gfx/maps/su6j-door.tmx") {
    private companion object {


    }

    private lateinit var letterAtlas: TextureAtlas

    override fun create() {
        super.create()
        letterAtlas = TextureAtlas(Gdx.files.internal("gfx/letters.atlas"))
    }

    override fun dispose() {
        super.dispose()
        letterAtlas.dispose()
    }

    // pray to the JVM gods
    private val boxes = Array(20) {
        Array(15) {
            if (Random.Default.nextBoolean()) {
                val frameCount = Random.Default.nextInt(60, 120)
                frameCount.shl(16).or(frameCount)
            } else 0
        }
    }

    override fun renderOverMap(batch: SpriteBatch, camera: OrthographicCamera, sceneState: SceneState) {
        SS76.batch.use {
            for (x in boxes.indices) {
                val arr = boxes[x]
                for (y in arr.indices) {
                    val box = arr[y]
                    if (box != 0) {
                        val maxTimer = box.or(0xff00).shr(16)
                        val timer = box.and(0x00ff)
                        val letterSize = (32f * (timer.toFloat() / maxTimer.toFloat())).roundToInt().toFloat()

                        if (timer == 0) {
                            arr[y] = 0
                        } else {
                            arr[y] = (maxTimer.shl(16)).or(timer - 1)
                        }

                        val hash = murmurhash3_32(x, y)
                        val letterIdx = (hash % letterAtlas.regions.size).absoluteValue
                        val letterTex = letterAtlas.regions[letterIdx]!!
                        //if (letterTex.name in FORBIDDEN) {
                        //    continue
                        //}

                        draw(letterTex, 100f + (x * 48f), Gdx.graphics.height - (y * 48f), letterSize, letterSize)
                    } else {
                        if (!Random.Default.nextBoolean()) continue
                        val frameCount = Random.Default.nextInt(60, 120)
                        arr[y] = (frameCount.shl(16)).or(frameCount)
                    }
                }
            }
        }
    }


}