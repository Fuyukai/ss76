package tf.veriny.ss76.vn

import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.scene.createAndRegisterScene


public fun registerMiscScenes(sm: SceneManager) {
    sm.createAndRegisterScene("credits-menu") {
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
    }
}
