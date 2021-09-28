package tf.veriny.ss76.engine.adv

import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import ktx.app.clearScreen
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.ChangeSceneButton
import tf.veriny.ss76.engine.screen.Screen
import tf.veriny.ss76.use

/**
 * Screen for displaying ADV mode.
 */
public class ADVScreen(public val subrenderer: ADVSubRenderer) : Screen {
    public val renderer: ADVRenderer = ADVRenderer(subrenderer)

    init {
        subrenderer.create()
    }

    public fun isAlreadyRendering(renderer: ADVSubRenderer): Boolean = this.renderer.subRenderer == renderer

    override fun render(delta: Float) {
        clearScreen(0f, 0f, 0f, 1f)

        renderer.render(SS76.sceneManager.currentScene)
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        // todo: maybe dont succ input

        val current = SS76.sceneManager.currentScene
        val nodes = current.definition.getTokensForPage(current.pageIdx)
        val frame = nodes.last().endFrame
        if (current.timer > frame) {
            current.pageNext()
        } else {
            SS76.sceneManager.currentScene.timer = 999999999
        }

        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        val current = SS76.sceneManager.currentScene

        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.DPAD_LEFT) {
            current.pageBack()
        } else if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.DPAD_RIGHT) {
            current.pageNext()
        } else if (keycode == Input.Keys.SPACE) {
            current.timer = 99999999
            return true
        }

        return false
    }

    override fun dispose() {
        subrenderer.dispose()
    }
}