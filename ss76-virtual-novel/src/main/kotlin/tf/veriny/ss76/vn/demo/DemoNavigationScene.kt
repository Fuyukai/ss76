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

            pushSceneButton("demo-changelog", "Changelog")
            newline()

            pushSceneButton("save-menu", "Checkpoint Menu")
            newline()

            pushSceneButton("credits-menu", "Credits")
        }

        page {
            line("ROUTE ONE JUMP POINTS #1")
            newline()

            changeSceneButton(
                "sussex-july-3-start",
                "2021-08-24: Route One, 03/07"
            )
            newline()

            changeSceneButton("sussex-july-4-start", "2021-08-26: Route One, 04/07")
            newline()

            changeSceneButton(
                "sussex-july-4-school-10",
                "2021-08-27: Route One, 04/07, School Midpoint"
            )
            newline()

            changeSceneButton(
                "sussex-july-4-school-y-1",
                "2021-09-02: Route One, 04/07, Part 2"
            )
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

    createAndRegisterScene("demo-changelog") {
        page {
            line("Version 0.6:")
            line("- Add ability to change the screen clear colour.")
            line("- Rework Route One, Day One's middle a lot.")
            line("- Beginning of Route One, Day Two")
        }

        page {
            line("Version 0.5:")
            line("- Add text shake effect.")
            line("- Finish Route One, Day One's first draft.")
        }

        page {
            line("Version 0.4:")
            line("- Fix renderer for lower screen resolutions.")
            line("- Change default font for lower screen resolutions.")
            line("- Add F1/F2/F3 shortcuts.")
            line("- More content on the Sussex route.")
            newline()

            //backButton()
        }
        page {
            line("Version 0.3:")
            line("- Add terrible low-res renderer that uses a camera to downscale things.")
            line("- Character biographies.")
            newline()

            //backButton()
        }

        page {
            line("Version 0.2:")
            line("- Initial release I sent to people. Actually has the content.")
            newline()

            //backButton()
        }

        page {
            line("Version 0.1:")
            line("- Engine implementation. No content.")
            newline()

            //backButton()
        }
    }
}