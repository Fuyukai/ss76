package tf.veriny.ss76.engine.screen

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.renderer.NVLRenderer
import tf.veriny.ss76.engine.renderer.Renderer
import tf.veriny.ss76.engine.scene.SceneDefinition

/**
 * The NVL screen is responsible for rendering a scene in NVL mode.
 */
public class NVLScreen : Screen {
    private var currentRenderer = NVLRenderer()

    /**
     * Renders the current screen.
     */
    override fun render(delta: Float) {
        currentRenderer.render(SS76.sceneManager.currentScene)
    }

}