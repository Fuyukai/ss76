package tf.veriny.ss76.engine

/**
 * Interface for an end-user scene registrar.
 */
public fun interface SceneRegistrar {
    /**
     * Registers all the scenes in this registrar with the specified scene manager.
     */
    public fun register(sceneManager: SceneManager)
}