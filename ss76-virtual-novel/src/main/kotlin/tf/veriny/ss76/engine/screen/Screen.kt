package tf.veriny.ss76.engine.screen

import com.badlogic.gdx.InputMultiplexer
import ktx.app.KtxInputAdapter

/**
 * A screen is responsible for managing sub-renderers.
 */
public interface Screen : KtxInputAdapter {
    /**
     * Renders the current screen.
     */
    public fun render(delta: Float)
}