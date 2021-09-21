package tf.veriny.ss76.engine.screen

/**
 * A screen is responsible for managing sub-renderers.
 */
public interface Screen {
    /**
     * Renders the current screen.
     */
    public fun render(delta: Float)
}