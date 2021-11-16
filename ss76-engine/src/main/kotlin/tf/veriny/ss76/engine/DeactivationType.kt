package tf.veriny.ss76.engine

/**
 * An enumeration of the possible deactivation types.
 */
public enum class DeactivationType {
    /** This scene has been deactivated because a new scene has been pushed on top of it. */
    PUSHED,

    /** This scene has been deactivated because it has been popped from the scene stack. */
    POPPED,
}