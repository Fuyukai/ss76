package tf.veriny.ss76.engine.adv

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import tf.veriny.ss76.engine.scene.SceneState

/**
 * The ADB sub-renderer allows drawing things above the ADV dialogue box.
 *
 * The renderer uses a camera (1280x960), so you can safely draw on it without worrying about
 * screen resolutions.
 */
public interface ADVSubRenderer {
    /**
     * Renders this sub-renderer.
     */
    public fun render(batch: SpriteBatch, sceneState: SceneState)
}