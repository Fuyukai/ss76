package tf.veriny.ss76.scene

import com.badlogic.gdx.InputProcessor

/**
 * Simple scene class, used to draw things. Conceptually similar to screens but does far less.
 */
public abstract class Scene {
    /** The ID of this Scene. */
    public abstract val id: String

    /** The input processor used when this scene is active. */
    public abstract val input: InputProcessor

    /**
     * Called when this scene becomes the active Top of Stack scene.
     */
    public open fun sceneActive() {}

    /**
     * Called when this scene is no longer active, either because another scene was pushed or this
     * scene returned.
     */
    public open fun sceneInactive(): Unit = reset()

    /**
     * Resets the scene. Useful from link nodes.
     */
    public open fun reset() {}

    /**
     * Draws the scene. Simple as.
     */
    public abstract fun draw()
}