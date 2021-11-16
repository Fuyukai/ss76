package tf.veriny.ss76.vn

import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.SceneRegistrar
import tf.veriny.ss76.engine.system.registerOSSCredits
import tf.veriny.ss76.vn.demo.registerDemoNavigationScenes
import tf.veriny.ss76.vn.demo.registerDemoUIScene
import tf.veriny.ss76.vn.sussex.registerChessPt1Scenes
import tf.veriny.ss76.vn.sussex.registerSu3JScenes
import tf.veriny.ss76.vn.sussex.registerSu4JScenes

public object SS76Registrar : SceneRegistrar {
    override fun register(sceneManager: SceneManager) {
        // == META == //
        registerDemoNavigationScenes(sceneManager)
        registerDemoUIScene(sceneManager)
        registerMainMenuScenes(sceneManager)
        registerMiscScenes(sceneManager)

        // == CONTENT == //
        registerSu3JScenes(sceneManager)
        registerSu4JScenes(sceneManager)
        registerChessPt1Scenes(sceneManager)
        registerOSSCredits(sceneManager)
    }
}