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

private val A_LEVELS_SCENE = createScene("a-level-explain-scene") {
    page {
        line(
            "A-levels are one of the possible last stages of UK higher education. You pick " +
            "three or four subjects you really wish to continue, and spend 8 hours in the " +
            "educational week dedicated to that subject."
        )
        newline(2)
        backButton()
    }
    page {
        line(
            "A-levels are graded on a scale from A* to U. BCC is a relatively average grade. " +
            "These grades are used to apply to higher education. However, you apply at the end of " +
            "year 12, well before any exams, so you don't have grades. Instead, you do a series of " +
            "mock exams halfway through Year 12 which give you a set of predicted grades, which are then " +
            "used by higher education institutions to determine if they will give you an offer or not. " +
            "Of course, your real grades at the end of Year 13 are used to see if you actually get " +
            "into Universities."
        )
        newline(2)
        backButton()
    }
}

private val CREDITS_SCENE = createScene("credits-menu") {
    page {
        line("=== CREDITS ===")
        newline()

        line("Story: Lura Skye")
        line("Engine development: Lura Skye")
        newline(2)

        line("Credits to the LibGDX and LWJGL developers for the engines this virtual novel " +
             "was based on.")
        newline()
        backButton()
    }
}

private val ROUTE_SELECT_SCREEN = createScene("reading-menu") {
    page {
        line("== Route Select ==")
        line(
            "This virtual novel lets you read the routes in any order. " +
            "There are three main routes, and two true routes. For best effect, you should " +
            "read the three main routes first (in the order of your choice), then read the two " +
            "true routes in the order specified here."
        )
        newline(2)

        line("Main routes:")
        pushSceneButton("sussex-july-3-start", "1. Sussex")
        newline()
        pushSceneButton("kent-july-3-start", "2. Kent")
        newline()
        pushSceneButton("suffolk-july-3-start", "3. Suffolk")
        newline(2)

        line("True routes:")
        pushSceneButton("true-insanity", "The Truth")
        newline()
        pushSceneButton("true-mundane", "The Reality")

    }
}


public fun registerMainMenuScenes() {
    SS76.registerScene(MAIN_MENU_SCENE)
    SS76.registerScene(A_LEVELS_SCENE)
    SS76.registerScene(CREDITS_SCENE)
    SS76.registerScene(ROUTE_SELECT_SCREEN)
}