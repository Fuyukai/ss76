package tf.veriny.ss76.engine.system

import tf.veriny.ss76.engine.Button
import tf.veriny.ss76.engine.scene.createAndRegisterScene
import java.awt.Desktop
import java.net.URI

private class OpenBrowserButton(override val name: String, private val link: String) : Button {
    override fun run() {
        val os = System.getProperty("os.name").lowercase()

        if (os == "linux") {
            Runtime.getRuntime().exec("xdg-open $link")
        } else if (Desktop.isDesktopSupported()) {
            val desktop = Desktop.getDesktop()
            desktop.browse(URI(link))
        }
    }
}

public fun registerOSSCredits() {
    createAndRegisterScene("oss-credits") {
        page {
            line("=== Resources Used ===")
            newline()

            line(
                "SS76 uses resources from the :push:`ofp`@green@ Oldschool Font Pack :pop: " +
                "which is licenced under the Creative Commons Attribution-ShareAlike 4.0 International " +
                "License."
            )
            newline()

            line("SS76 is based on the `gdx`@green@LibGDX game engine.")
            newline()

            addButton(OpenBrowserButton("ofp", "https://int10h.org/oldschool-pc-fonts/"))
            addButton(OpenBrowserButton("gdx", "https://github.com/libgdx/libgdx"))
        }
    }
}