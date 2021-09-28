package tf.veriny.ss76.engine.screen

import com.badlogic.gdx.Gdx
import ktx.app.clearScreen
import tf.veriny.ss76.SS76
import tf.veriny.ss76.use

/**
 * The screen for rendering errors.
 */
public class ErrorScreen(public val error: Throwable) : Screen {
    override fun render(delta: Float) {
        clearScreen(255f, 0f, 0f, 0f)

        val tb = error.stackTraceToString()
        SS76.batch.use {
            val message = if (SS76.sceneManager.stackSize == 0) {
                "Fatal error when loading engine!"
            } else {
                "Fatal error when rendering scene ${SS76.sceneManager.currentScene.definition.id}"
            }

            SS76.fontManager.errorFont.draw(
                this, message,
                1f,
                Gdx.graphics.height - 10f
            )

            SS76.fontManager.errorFont.draw(this, tb, 1f, Gdx.graphics.height - 30f)
        }
    }

    override fun dispose() {

    }
}