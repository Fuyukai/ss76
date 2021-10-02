package tf.veriny.ss76.engine.nvl

import com.badlogic.gdx.Input
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.ChangeSceneButton
import tf.veriny.ss76.engine.screen.Screen

/**
 * The NVL screen is responsible for rendering a scene in NVL mode.
 */
public object NVLScreen : Screen {
    private val currentRenderer = NVLRenderer()

    /**
     * Renders the current screen.
     */
    override fun render(delta: Float) {
        currentRenderer.render(SS76.sceneManager.currentScene)
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val current = SS76.sceneManager.currentScene
        if (!current.definition.effects.disableTextSkip) current.timer = 999999
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        val current = SS76.sceneManager.currentScene

        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.DPAD_LEFT) {
            current.pageBack()
        } else if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.DPAD_RIGHT) {
            current.pageNext()
        } else if (keycode == Input.Keys.SPACE) {
            if (!current.definition.effects.disableTextSkip) current.timer = 999999
            return true
        } else if (keycode == Input.Keys.ENTER) {
            val buttons = SS76.buttonManager.buttonRects.keys.filterIsInstance<ChangeSceneButton>()

            if (buttons.isEmpty() || buttons.size > 1) return false

            val button = buttons.first()
            button.run()
        }

        return false
    }

    override fun dispose() {

    }
}