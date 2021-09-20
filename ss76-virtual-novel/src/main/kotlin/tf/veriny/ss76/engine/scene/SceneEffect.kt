package tf.veriny.ss76.engine.scene

import com.badlogic.gdx.graphics.Color

/**
 * Marker interface for a "scene effect".
 */
public sealed interface SceneEffect {
    /**
     * Enables a custom background (clear screen) colour.
     */
    public class ChangeBackgroundColour(public val colour: Color) : SceneEffect

    /**
     * Enables the inversion effect.
     */
    public object Invert : SceneEffect

    /**
     * Changes the top text during this scene.
     */
    public class ChangeTopText(public val topText: String) : SceneEffect
}