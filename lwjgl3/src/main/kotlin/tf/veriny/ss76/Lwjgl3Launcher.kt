package tf.veriny.ss76

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import org.lwjgl.glfw.GLFW

public object Lwjgl3Launcher {
    @JvmStatic public fun main(args: Array<String>) {
        createApplication()
    }

    private fun createApplication(): Lwjgl3Application {
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
        }

        return Lwjgl3Application(SS76, config)
    }
}