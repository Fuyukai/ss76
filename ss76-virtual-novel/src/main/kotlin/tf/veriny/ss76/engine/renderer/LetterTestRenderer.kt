package tf.veriny.ss76.engine.renderer

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import ktx.app.clearScreen
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.renderer.map.DoorRenderer
import tf.veriny.ss76.engine.screen.Screen
import tf.veriny.ss76.engine.util.murmurhash3_32
import tf.veriny.ss76.use
import kotlin.math.absoluteValue
import kotlin.math.roundToInt
import kotlin.random.Random

public class LetterTestRenderer : Screen {
    private companion object {
        private val QUOTE = listOf(
            "That's right. It's starting right now.",
            "Hehehehe...",
            "Wh-What is it?",
            "It all just ended, and now we're starting again?",
            "Huh?",
            "No, never mind. Let's go.",
            "Let's go to that point where it all begins.",
        )

        private val FORBIDDEN = mutableSetOf<String>(
            "letter-o",
            "letter-u",
            "letter-t",
            "letter-s",
            "letter-i",
            "letter-d",
            "letter-e",
        )
    }

    private val letterAtlas = TextureAtlas(Gdx.files.internal("gfx/letters.atlas"))
    private val letterMapping = ('a'..'z').associateWith {
        val name = "letter-$it"
        val texture = letterAtlas.regions.find { it.name == name }
        texture
    }


    private var timer = 0

    init {
        SS76.buttonManager.reset()
    }

    private val boxes = Array<Array<Boolean>>(80) { Array(60) { false } }
    private val intBoxes = Array(20) {
        Array(15) {
            if (Random.Default.nextBoolean()) {
                val frameCount = Random.Default.nextInt(60, 120)
                frameCount.shl(16).or(frameCount)
            } else 0
        }
    }
    private var mode = 0

    override fun render(delta: Float) {
        clearScreen(1f, 0f, 1f, 1f)

        when (mode) {
            0 -> {
                renderRandom()
            }
            1 -> {
                renderQuote()
            }
            2 -> {
                renderFloating()
            }
        }
    }

    private fun renderFloating() {
        SS76.batch.use {
            for (x in intBoxes.indices) {
                val arr = intBoxes[x]
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
                        if (letterTex.name in FORBIDDEN) {
                            continue
                        }

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

    private fun renderQuote() {
        var xOffset = 150f
        var yOffset = 150f
        SS76.batch.use {
            for (line in QUOTE) {
                for (char in line) {
                    val texture = letterMapping[char.toLowerCase()]
                    if (texture != null) {
                        draw(texture, xOffset, Gdx.graphics.height - yOffset, 16f, 16f)
                    }
                    xOffset += 24
                }

                xOffset = 150f
                yOffset += 24
            }
        }
    }

    private fun renderRandom() {
        // pray to the jvm escape analysis gods
        for (element in boxes) {
            for (j in element.indices) {
                element[j] = false
            }
        }

        val random = Random(timer.floorDiv(30))
        SS76.batch.use {
            val count = random.nextInt(300, 480)
            for (i in 0 until count) {
                val texture = letterAtlas.regions[random.nextInt(letterAtlas.regions.size)]
                val x = random.nextInt(0, Gdx.graphics.width).floorDiv(16)
                val y = random.nextInt(16, Gdx.graphics.height).floorDiv(16)
                if (!boxes[x][y]) {
                    boxes[x][y] = true
                } else {
                    continue
                }

                draw(texture, x * 48f, y * 48f, 32f, 32f)
            }
        }
        timer++
    }

    override fun keyDown(keycode: Int): Boolean {
        when (keycode) {
            Input.Keys.LEFT -> {
                mode--
            }
            Input.Keys.RIGHT -> {
                mode++
            }
            else -> {
                return false
            }
        }

        return true
    }

    override fun dispose() {
        letterAtlas.dispose()
    }
}