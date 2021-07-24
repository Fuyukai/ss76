package tf.veriny.ss76

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

public object Lwjgl3Launcher {
    @JvmStatic public fun main(args: Array<String>) {
        createApplication()
    }

    private fun createApplication(): Lwjgl3Application {
        val config = Lwjgl3ApplicationConfiguration().apply {
            setTitle("Signalling System 76")
            setWindowedMode(1280, 960)
            setResizable(false)
            setWindowIcon("icon-128x128.png")
        }

        return Lwjgl3Application(SS76, config)
    }
}