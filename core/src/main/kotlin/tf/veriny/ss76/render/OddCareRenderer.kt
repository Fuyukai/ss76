package tf.veriny.ss76.render

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color.RED
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import ktx.freetype.generateFont
import tf.veriny.ss76.SS76

/**
 * Demo button at the top of the screen.
 */
internal class OddCareRenderer {
    private val demoFont: BitmapFont

    init {
        val font = FreeTypeFontGenerator(Gdx.files.internal("fonts/MxPlus_Cordata_PPC-21.ttf"))

        demoFont = font.generateFont {
            size = 84
            color = RED
            mono = true
        }
    }

    // one second off, 2 seconds on
    private var timer = 0

    internal fun render() {
        if (timer.rem(90) > 30) {
            demoFont.draw(SS76.batch,"DEMO", 10f, 960 - 10f)
        }

        timer++

    }
}