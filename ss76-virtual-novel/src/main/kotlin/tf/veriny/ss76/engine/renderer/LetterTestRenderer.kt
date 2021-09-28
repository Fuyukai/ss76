package tf.veriny.ss76.engine.renderer

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import ktx.app.clearScreen
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.screen.Screen
import tf.veriny.ss76.use
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
    }

    private val atlas = TextureAtlas(Gdx.files.internal("gfx/letters.atlas"))
    private val letterMapping = ('a'..'z').associateWith {
        val name = "letter-$it"
        val texture = atlas.regions.find { it.name == name }
        texture
    }


    private var timer = 0

    init {
        SS76.buttonManager.reset()
    }

    private val boxes = Array<Array<Boolean>>(80) { Array(60) { false } }
    private var mode = false

    override fun render(delta: Float) {
        clearScreen(1f, 0f, 1f, 1f)

        if (mode) {
            renderRandom()
        } else {
            renderQuote()
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
                val texture = atlas.regions[random.nextInt(atlas.regions.size)]
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

    override fun dispose() {
        atlas.dispose()
    }
}