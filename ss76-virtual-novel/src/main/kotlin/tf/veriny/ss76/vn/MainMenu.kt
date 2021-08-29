/*package tf.veriny.ss76.vn

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

private val CREDITS_SCENE = createScene("credits-menu") {
    page {
        line("=== CREDITS ===")
        newline()

        line("Story: Lura Skye")
        line("Engine development: Lura Skye")
        line("Character design: Lura Skye")
        line("Dialogue writing: Lura Skye")
        line("Side-story writing: Lura Skye")
        line("Another arbitrary credit: Lura Skye")
        newline()

        line("UI testing/Story review: Lewis O Fivelifecut")
        line("UI testing/Story review: Gretchen S Mary")

        //line("Credits to the LibGDX and LWJGL developers for the engines this virtual novel " +
        //     "was based on.")
        newline()
        backButton()
    }
}

private val ROUTE_SELECT_SCREEN = createScene("reading-menu") {
    page {
        line("== Route Select ==")
        line(
            "You should read Route One, then Route Two, then the Truth ending, " +
            "then the Reality ending. Otherwise, the plot doesn't make sense."
        )
        line("All routes are unlocked at the start if you're doing a re-read, though.")
        newline(2)

        line("Main routes:")
        pushSceneButton("sussex-july-3-start", "Route One")
        newline()
        pushSceneButton("kent-july-3-start", "Route Two")
        newline()
        newline(2)

        line("True routes:")
        pushSceneButton("no-cheating", "The Truth")
        //pushSceneButton("charlotte-god", "The Truth")
        newline()
        pushSceneButton("no-cheating", "The Reality")
        //pushSceneButton("you-god", "The Reality")

    }
}


public fun registerMainMenuScenes() {
    SS76.registerScene(MAIN_MENU_SCENE)
    //SS76.registerScene(A_LEVELS_SCENE)
    SS76.registerScene(CREDITS_SCENE)
    SS76.registerScene(ROUTE_SELECT_SCREEN)
}*/