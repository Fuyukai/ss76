package tf.veriny.ss76.engine.screen

import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.utils.Disposable
import ktx.app.KtxInputAdapter

/**
 * A screen is responsible for managing sub-renderers.
 */
public interface Screen : KtxInputAdapter, Disposable {
    /**
     * Renders the current screen.
     */
    public fun render(delta: Float)
}