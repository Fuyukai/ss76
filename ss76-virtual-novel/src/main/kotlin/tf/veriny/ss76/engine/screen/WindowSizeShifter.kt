package tf.veriny.ss76.engine.screen

import com.badlogic.gdx.Gdx
import ktx.app.clearScreen
import tf.veriny.ss76.SS76
import kotlin.math.max
import kotlin.math.min

/**
 * Shifts the window size each frame.
 */
public class WindowSizeShifter(
    public val newHeight: Int, public val newWidth: Int, public val nextScreen: Screen
) : Screen {

    override fun render(delta: Float) {
        clearScreen(0f, 0f, 0f, 1f)

        var changed = false
        var cHeight = Gdx.graphics.height
        var cWidth = Gdx.graphics.width

        if (Gdx.graphics.height > newHeight) {
            cHeight = max(cHeight - 7, newHeight)
            changed = true
        } else if (Gdx.graphics.height < newHeight) {
            cHeight = min(cHeight + 7, newHeight)
            changed = true
        }

        if (Gdx.graphics.width > newWidth) {
            cWidth = max(cWidth - 7, newWidth)
            changed = true
        } else if (Gdx.graphics.width < newWidth) {
            cWidth = min(cWidth + 7, newWidth)
            changed = true
        }

        if (changed) {
            Gdx.graphics.setWindowedMode(cWidth, cHeight)
        } else {
            SS76.changeScreen(nextScreen)
        }
    }

    override fun dispose() {

    }
}