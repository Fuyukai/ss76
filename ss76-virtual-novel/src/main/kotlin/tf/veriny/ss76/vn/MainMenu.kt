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
                "Welcome to Signalling System 76."
            )
            newline()

            line("It is recommended that you read this virtual novel in a dark room, in the cold.")
            newline()

            line("What do you want to do?")
            newline(2)

            changeSceneButton("su3j-prologue-1", "@green@Start @green@reading")
            newline()
            pushSceneButton("save-menu", "@green@Load @green@a @green@save")
            newline()
            pushSceneButton("credits-menu", "Credits")
            newline()

            if (SS76.IS_DEBUG || SS76.IS_DEMO) {
                newline()
                changeSceneButton("demo-meta-menu", "Demo menu")
            }
        }
    }
}