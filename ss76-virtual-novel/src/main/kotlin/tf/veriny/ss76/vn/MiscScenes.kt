package tf.veriny.ss76.vn

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

public fun registerMiscScenes() {
    createAndRegisterScene("credits-menu") {
        page {
            line("=== Development Credits ===")
            newline()

            line("Story: Lura Skye")
            line("Engine development: Lura Skye")
            line("Character design: Lura Skye")
            line("Dialogue writing: Lura Skye")
            line("Side-story writing: Lura Skye")
            line("Another arbitrary credit: Lura Skye")
            newline()

            backButton()

        }

        page {
            line("=== Reading Credits ===")
            newline()

            line("UI testing/Story review: Lewis O Fivelifecut")
            line("UI testing/Story review: Gretchen S Mary")
            line("Story review: Erin 'Two' Leftoutofdark")

            backButton()
        }

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

            addButton(OpenBrowserButton("ofp", "https://int10h.org/oldschool-pc-fonts/"))
            addButton(OpenBrowserButton("gdx", "https://github.com/libgdx/libgdx"))
        }
    }
}
