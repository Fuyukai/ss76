package tf.veriny.ss76.vn.demo

import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.nvl.NVLScreen
import tf.veriny.ss76.engine.scene.createAndRegisterScene
import tf.veriny.ss76.engine.screen.WindowSizeShifter
import tf.veriny.ss76.vn.sussex.CarRenderer

public fun registerDemoNavigationScenes(sceneManager: SceneManager): Unit = sceneManager.let { sm ->
    sm.createAndRegisterScene("demo-meta-menu") {
        page {
            line("This is the Signalling System 76 debug menu.")
            newline()

            line("Unless this is a demo build, you shouldn't be here.")
            newline()

            changeSceneButton("main-menu", "Jump to main menu")
            pushSceneButton("credits-menu", "Credits")
            newline()

            pushSceneButton("engine-oss-credits", "OSS Credits")
            newline()

            line("¬ayana¬le")
        }

        page {
            line("The jump points are deprecated due to requiring checkpoints for event " +
                 "flags.")
            newline()

            line("The only jump point now is Chapter 2. Start from a checkpoint in the next " +
                 "build.")
            newline()

            changeSceneButton("su4j-start", "2021-11-11: Chapter 2, Start")
        }

        page {
            line("ENGINE DEMOS")
            newline()

            pushSceneButton(
                "renderer-v2-demo", "Renderer V2 Demo"
            )
            newline()

            pushSceneButton("invert", "2021-09-08: Invert.")
            newline()

            pushSceneButton("lightning", "2021-09-20: Lightning flashes")
            newline()

            pushSceneButton("resize-large", "2021-09-21: Grow screen")
            newline()

            pushSceneButton("car-renderer", "2021-09-22: Le boat has arrived")
            newline()

            //pushSceneButton("background-renderer", "2021-09-25: Backgrounds test")
            //newline()

            //pushSceneButton("letter-renderer", "2021-09-26: Letters text")
        }

        page {
            line("ENGINE DEMOS #2")
            newline()

            pushSceneButton("linger-test", "2021-10-05: Lingering text")
            newline()

            pushSceneButton("mojibake", "2021-10-18: Mojibake test")
            newline()

            pushSceneButton("font-change", "2021-10-20: Font changes")
            newline()

            pushSceneButton("flag-test-menu", "2021-11-11: Event flag test")
        }
    }

    sm.createAndRegisterScene("resize-large") {
        onLoad {
            it.engineState.sceneManager.exitScene()
            val screen = WindowSizeShifter(900, 1600)
            it.engineState.screenManager.changeScreen(screen)
        }
    }

    sm.createAndRegisterScene("car-renderer") {
        this.advRenderer = CarRenderer()

        page {
            line("Car renderer page #1")
        }

        page {
            line("Car renderer page #2")
        }

        page {
            line("Car renderer page #3")
        }
    }

    sm.createAndRegisterScene("flag-test-menu") {
        page {
            pushSceneButton("flag-test-set", "Set event flag")
            newline()
            pushSceneButton("flag-test-clear", "Clear event flag")
            newline()
            pushSceneButton("flag-test-check", "Show event flag")
        }
    }

    sm.createAndRegisterScene("flag-test-set") {
        onLoad {
            it.engineState.eventFlagsManager.set("demo-test-flag")
            it.engineState.sceneManager.exitScene()
        }
    }

    sm.createAndRegisterScene("flag-test-clear") {
        onLoad {
            it.engineState.eventFlagsManager.reset("demo-test-flag")
            it.engineState.sceneManager.exitScene()
        }
    }

    sm.createAndRegisterScene("flag-test-check") {
        enablePagination = false

        onLoad {
            val isSet = it.engineState.eventFlagsManager.get("demo-test-flag")
            it.pageIdx = if (isSet) 1 else 0
        }

        page {
            line("The flag is not set")
            newline()
            backButton()
        }

        page {
            line("The flag is set")
            newline()
            backButton()
        }
    }
}