package tf.veriny.ss76

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import org.lwjgl.glfw.GLFW
import tf.veriny.ss76.engine.SceneRegistrar

/**
 * Launches the SS76 engine.
 *
 * @param namespace: The namespace to use for saved data.
 * @param registrar: The scene registration object.
 * @param windowTitle: The title to use for the window. Defaults to 'Signalling System 76'.
 */
public fun launchEngine(
    namespace: String, registrar: SceneRegistrar,
    windowTitle: String = "Signalling System 76",
) {

    val babyScreen = run {
        System.getProperty("is-baby-screen", "false").toBooleanStrict() || run {
            GLFW.glfwInit()
            val monitor = GLFW.glfwGetPrimaryMonitor()
            val res = GLFW.glfwGetVideoMode(monitor)
            res!!.height() < 960
        }
    }
    val config = Lwjgl3ApplicationConfiguration().apply {
        setTitle("Signalling System 76")
        if (babyScreen) {
            setWindowedMode(800, 600)
        } else {
            setWindowedMode(1280, 960)
        }

        setResizable(false)
        setWindowIcon("icon-128x128.png")
        useVsync(true)
        setIdleFPS(60)
        setForegroundFPS(60)
    }

    Lwjgl3Application(SS76(namespace, registrar), config)
}
