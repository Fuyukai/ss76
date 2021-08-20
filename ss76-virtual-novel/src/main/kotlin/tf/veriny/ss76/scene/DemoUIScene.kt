package tf.veriny.ss76.scene

import tf.veriny.ss76.scene.text.LinkNode
import tf.veriny.ss76.scene.text.TextualScene
import tf.veriny.ss76.scene.text.createAndRegisterScene

public fun registerDemoUIScene() {
    createAndRegisterScene("lura-july-2021-engine-demo") {
        page {
            line("This is a demo scene!")
            newline()

            link("SKIP", "Toggle glitchy line effect", type = LinkNode.LinkType.BACK_BUTTON) {
                TextualScene.GLITCHY = !TextualScene.GLITCHY
                it.reset()
            }
            newline(2)

            line("The next line wraps.")
            line("Signaling System No. 7 (or Signalling System No. 7, SS7) is a set of " +
                 "telephony signaling protocols developed in 1975, which is used to set up and tear " +
                 "down telephone calls in most parts of the world-wide public switched telephone " +
                 "network (PSTN)")
            newline()

            pushSceneButton(
                "lura-july-2021-engine-demo-1",
                "Push scene button (lura-july-2021-engine-demo-1)"
            )
            newline()
            pushSceneButton(
                "lura-july-2021-engine-demo-2",
                "Push scene button (lura-july-2021-engine-demo-2)"
            )
            newline(2)

            changeSceneButton(
                "lura-july-2021-engine-demo-4",
                "Click here to be softlocked"
            )
            newline(2)

            dline("ABCD: I'm a dialogue line. I also wrap, but in a special way; I have an " +
                  "extra amount of padding so that all the dialogue lines up properly.")

            pushSceneButton("le-crash-has-arrived", "When the game is crashed :blush:")
        }
    }

    createAndRegisterScene("lura-july-2021-engine-demo-1") {
        page {
            line("This is a pushed scene. You are *above* the previous scene on the stack.")
            line("This is Scene #1. When you go back, it will show this link in green.")
            line("Scene #2 will be shown in red.")
            newline()

            backButton()
        }
    }

    createAndRegisterScene("lura-july-2021-engine-demo-2") {
        page {
            line("This is a pushed scene. You are *above* the previous scene on the stack.")
            line("This is scene #2.")

            pushSceneButton(
                "lura-july-2021-engine-demo-3",
                "Push scene button (lura-july-2021-engine-demo-3)"
            )
            newline(2)
            backButton()
        }

        page {
            line("When the page is next :blush:")
        }
    }

    createAndRegisterScene("lura-july-2021-engine-demo-3") {
        page {
            line("You are now two scenes higher on the stack.")
            line("Going back will return you to Scene #2.")
            line("Going back from that scene will return you to the root demo scene.")
            newline()

            pushSceneButton(
                "le-crash-has-arrived", "When the game is crashed but even more :blush:"
            )
            newline(2)

            backButton()
        }
    }

    createAndRegisterScene("lura-july-2021-engine-demo-4") {
        page {
            line("When the game is softlocked!")
        }
    }
}