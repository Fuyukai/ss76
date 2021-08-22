package tf.veriny.ss76.scene

import tf.veriny.ss76.SS76
import tf.veriny.ss76.scene.text.LinkNode
import tf.veriny.ss76.scene.text.createAndRegisterScene

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

            link("demo-changelog", ">> Changelog", LinkNode.LinkType.BACK_BUTTON) {
                SS76.pushScene("demo-changelog")
            }
        }

        page {
            line("UI DEMOS")
            newline()

            changeSceneButton(
                "lura-july-2021-engine-demo", "July 2021 UI Demonstration"
            )

        }

        page {
            line("SUSSEX ROUTE JUMP POINTS #1")
            newline()

            changeSceneButton(
                "sussex-july-3-start",
                "2021-08-15: Route One, July 3rd"
            )
            newline()

            changeSceneButton(
                "sussex-july-3-school-9",
                "2021-08-20: Route One, July 3rd, School #9"
            )
            newline()

            changeSceneButton(
                "side.sussex.alex-radio-0",
                "2021-08-21: side.sussex.alex-radio-0"
            )
        }
    }

    createAndRegisterScene("demo-changelog") {
        page {
            line("Version 0.4:")
            line("- Fix renderer for lower screen resolutions.")
            line("- Change default font for lower screen resolutions.")
            line("- Add F1/F2/F3 shortcuts.")
            line("- More content on the Sussex route.")
            newline()

            backButton()
        }
        page {
            line("Version 0.3:")
            line("- Add terrible low-res renderer that uses a camera to downscale things.")
            line("- Character biographies.")
            newline()

            backButton()
        }

        page {
            line("Version 0.2:")
            line("- Initial release I sent to people. Actually has the content.")
            newline()

            backButton()
        }

        page {
            line("Version 0.1:")
            line("- Engine implementation. No content.")
            newline()

            backButton()
        }
    }
}