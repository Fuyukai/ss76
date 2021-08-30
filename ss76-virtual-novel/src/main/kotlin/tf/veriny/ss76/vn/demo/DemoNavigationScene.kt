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
        }

        page {
            line("ROUTE ONE JUMP POINTS #1")
            newline()

            changeSceneButton(
                "sussex-july-3-start",
                "2021-08-24: Route One, 3rd Of July"
            )
            newline()

            changeSceneButton(
                "sussex-july-3-school-i-1",
                "2021-08-24: Expanded school scene"
            )
            newline()

            changeSceneButton("sussex-july-4-start", "2021-08-26: Route One, 4th Of July")
            newline()

            changeSceneButton("sussex-july-4-school-10", "2021-08-27: sussex-july-4-school-10")
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