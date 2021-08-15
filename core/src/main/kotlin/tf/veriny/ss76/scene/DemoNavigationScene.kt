package tf.veriny.ss76.scene

import tf.veriny.ss76.scene.text.createAndRegisterScene

public fun registerDemoNavigationScenes() {
    createAndRegisterScene("demo-meta-menu") {
        page {
            line("This is the Signalling System 76 demo menu.")
            newline()

            line("This is primarily for the benefit of my friends who are very graciously " +
                 "helping me with either writing, UI design or both.")
            newline()

            line("This page allows jumping to predefined demo points.")
            newline()
        }

        page {
            line("UI DEMOS")
            newline()

            changeSceneButton(
                "lura-july-2021-engine-demo", "July 2021 UI Demonstration"
            )

        }

        page {
            changeSceneButton(
                "sussex-july-3-start",
                "2021-08-15: Route One, July 8th"
            )
        }
    }
}