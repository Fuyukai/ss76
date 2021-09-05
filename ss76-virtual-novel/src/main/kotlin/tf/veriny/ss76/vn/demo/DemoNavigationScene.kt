package tf.veriny.ss76.vn.demo

import tf.veriny.ss76.engine.scene.createAndRegisterScene

public fun registerDemoNavigationScenes() {
    createAndRegisterScene("demo-meta-menu") {
        page {
            line("This is the Signalling System 76 demo menu.")
            newline()

            line("This is primarily for the benefit of my friends who are very graciously " +
                 "helping me with either writing, UI design or both.")
            newline()

            line("This scene allows jumping to predefined demo points.")
            newline()

            pushSceneButton("save-menu", "Checkpoint Menu")
            newline()

            pushSceneButton("credits-menu", "Credits")
        }

        page {
            line("ROUTE ONE JUMP POINTS #1")
            newline()

            pushSceneButton(
                "sussex-july-3-start",
                "2021-08-24: Route One, 03/07"
            )
            newline()

            pushSceneButton("sussex-july-4-start", "2021-08-26: Route One, 04/07")
            newline()

            pushSceneButton("sussex-july-5-start", "2021-09-03: Route One, 05/07")
            newline()

            pushSceneButton("sussex-july-52-start", "2021-09-03: Route One, 05/07, Part 2")
        }

        page {
            line("ROUTE ONE SIDE STORY JUMP POINTS #1")
            newline()

            pushSceneButton("sussex-july-4-pre-9", "2021-09-04: Forest Side Story pre-scene")
            newline()
        }


        page {
            line("UI DEMOS")
            newline()

            changeSceneButton(
                "renderer-v2-demo", "Renderer V2 Demo"
            )
            newline()
        }
    }
}