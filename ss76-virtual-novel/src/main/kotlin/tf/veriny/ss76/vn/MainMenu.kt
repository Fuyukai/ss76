package tf.veriny.ss76.vn

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.createAndRegisterOnePageScene
import tf.veriny.ss76.engine.scene.createAndRegisterScene

/*
package tf.veriny.ss76.vn

import tf.veriny.ss76.SS76
import tf.veriny.ss76.scene.text.LinkNode
import tf.veriny.ss76.scene.text.TextualScene
import tf.veriny.ss76.scene.text.createScene

private val MAIN_MENU_SCENE = createScene("main-menu") {
    page {
        line(
            "It is the 3rd of July. You are a 17 year old boy in Year 12. " +
            "You have finished your last mock exams. The exams gave you a BCC prediction in your",
            addNewline = false,
        )
        pushSceneButton("a-level-explain-scene", "A-levels.")
        newline(2)

        line("The frequency is 4625 Hz.")
        newline()

        line("What do you want to do?")
        newline()

        changeSceneButton("reading-menu", "Start reading")
        newline()
        changeSceneButton("save-menu", "Load a save")
        newline()
        pushSceneButton("credits-menu", "Credits")
        newline(2)
        // BACK_BUTTON means link
        link("SKIP", "Toggle glitchy line effect", type = LinkNode.LinkType.BACK_BUTTON) {
            TextualScene.GLITCHY = !TextualScene.GLITCHY
            it.reset()
        }
        newline(2)

        line(
            "It is recommended that you read this virtual novel on a hot summer day, in a dark room, " +
            "under the cool air of your air conditioning or a fan on maximum setting, preferably " +
            "on a laptop whilst tucked into bed and laying on your front."
        )
    }
}
*/

public fun registerMainMenuScenes() {
    createAndRegisterScene("main-menu") {
        page {
            line(
                "It is the 3rd of July. You are a 17 year old boy in Year 12."
            )
            newline()

            line("What do you want to do?")
            newline(2)

            changeSceneButton("reading-menu", "@green@Start @green@reading")
            newline()
            changeSceneButton("save-menu", "@green@Load @green@a @green@save")
            newline()
            pushSceneButton("credits-menu", "Credits")
            newline()

            if (SS76.IS_DEBUG) {
                newline()
                changeSceneButton("demo-meta-menu", "Demo menu")
            }
        }
    }

    createAndRegisterScene("norfolk-route-start") {
        onLoad {
            if (SS76.sceneManager.hasVisitedScene("sussex-end")) {
                SS76.sceneManager.changeScene("no3j-start")
            }
        }

        page {
            line("You should read Route One (Inconvenient) before starting this route.")
            newline()

            backButton("Go back,")
            //changeSceneButton("no3j-start", "or continue at your own risk.")
            line(":push:@salmon@ or continue at your own risk.")
        }
    }

    createAndRegisterScene("the-truth-start") {
        onLoad {
            if (SS76.sceneManager.hasVisitedScene("norfolk-end")) {
                SS76.sceneManager.changeScene("tt-1-start")
            }
        }

        page {
            line(
                "You should read Route One (Inconvenient) and Route Two (Uncomfortable) before " +
                "reading this."
            )
            newline()

            backButton("Go back,")
            //changeSceneButton("tt-1-start", "or continue at your own risk.")
            line(":push:@salmon@ or continue at your own risk.")
        }
    }

    createAndRegisterScene("the-reality-start") {
        onLoad {
            if (SS76.sceneManager.hasVisitedScene("truth-end")) {
                SS76.sceneManager.changeScene("tr-1-start")
            }
        }

        page {
            line("This is the final route. You should have read the other three before " +
                 "reading this.")
            newline()

            backButton("Go back,")
            //changeSceneButton("tr-1-start", "or continue at your own risk.")
            line(":push:@salmon@ or continue at your own risk.")
        }
    }

    createAndRegisterScene("reading-menu") {
        page {
            line("I had a strange dream last night.")
            line("When I woke up, I had but one question, and two paths to follow.")
            newline()

            pushSceneButton(
                "sussex-july-3-start",
                "The first path is inconvenient."
            )
            line("(Route One)")
            newline()

            pushSceneButton(
                "norfolk-route-start",
                "The second path is uncomfortable."
            )
            line("(Route Two)")
            newline(2)

            line("But, the two paths end before I am ready.")
            newline()

            pushSceneButton("the-truth-start", "One hides the reality.")
            newline()
            pushSceneButton("the-reality-start", "One hides the truth.")
            newline()
        }
    }


}