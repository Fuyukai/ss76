package tf.veriny.ss76.engine.scene

import com.badlogic.gdx.graphics.Color

/**
 * Container class defining the effects a scene should have.
 */
public data class SceneEffects(
    /** The custom background used for this scene. */
    var backgroundColour: Color = Color.BLUE,
    /** If this scene should be drawn inverted. */
    var invert: Boolean = false,
    /** The custom top text used for this scene. */
    var topText: String = "SIGNALLING SYSTEM 76",

    /** Lightning effect. */
    var lightning: Boolean = false,
) {
    public companion object {
        public val NONE: SceneEffects = SceneEffects()
    }
}
