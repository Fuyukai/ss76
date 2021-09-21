package tf.veriny.ss76.engine.adv

import com.badlogic.gdx.graphics.OrthographicCamera
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.screen.Screen
import tf.veriny.ss76.use

/**
 * Screen for displaying ADV mode.
 */
public class ADVScreen(subrenderer: ADVSubRenderer) : Screen {
    private val renderer = ADVRenderer(subrenderer)

    public fun isAlreadyRendering(renderer: ADVSubRenderer): Boolean = this.renderer.subRenderer == renderer

    override fun render(delta: Float) {
        renderer.render(SS76.sceneManager.currentScene)
    }
}