package tf.veriny.ss76.vn.demo

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.nvl.NVLScreen
import tf.veriny.ss76.engine.renderer.BackgroundTestRenderer
import tf.veriny.ss76.engine.renderer.LetterTestRenderer
import tf.veriny.ss76.engine.renderer.TileMapADVRenderer
import tf.veriny.ss76.engine.renderer.map.DoorRenderer
import tf.veriny.ss76.engine.scene.createAndRegisterScene
import tf.veriny.ss76.engine.screen.WindowSizeShifter
import tf.veriny.ss76.vn.sussex.CarRenderer

public fun registerDemoNavigationScenes() {
    createAndRegisterScene("demo-meta-menu") {
        page {
            line("This is the Signalling System 76 debug menu.")
            newline()

            line("Unless this is a demo build, you shouldn't be here.")
            newline()

            pushSceneButton("credits-menu", "Credits")
            newline()

            pushSceneButton("oss-credits", "OSS Credits")
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

            pushSceneButton("background-renderer", "2021-09-25: Backgrounds test")
            newline()

            pushSceneButton("letter-renderer", "2021-09-26: Letters text")
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

    createAndRegisterScene("resize-large") {
        onLoad {
            SS76.sceneManager.exitScene()
            val screen = WindowSizeShifter(900, 1600, NVLScreen)
            SS76.changeScreen(screen)
        }
    }

    createAndRegisterScene("car-renderer") {
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

    createAndRegisterScene("background-renderer") {
        onLoad {
            SS76.changeScreen(BackgroundTestRenderer())
        }
    }

    createAndRegisterScene("letter-renderer") {
        onLoad { SS76.changeScreen(LetterTestRenderer()) }
    }

    createAndRegisterScene("door-test") {
        advRenderer = DoorRenderer()

        page {
            line("")
        }
    }

    createAndRegisterScene("flag-test-menu") {
        page {
            pushSceneButton("flag-test-set", "Set event flag")
            newline()
            pushSceneButton("flag-test-clear", "Clear event flag")
            newline()
            pushSceneButton("flag-test-check", "Show event flag")
        }
    }

    createAndRegisterScene("flag-test-set") {
        onLoad {
            SS76.eventFlagsManager.set("demo-test-flag")
            SS76.sceneManager.exitScene()
        }
    }

    createAndRegisterScene("flag-test-clear") {
        onLoad {
            SS76.eventFlagsManager.reset("demo-test-flag")
            SS76.sceneManager.exitScene()
        }
    }

    createAndRegisterScene("flag-test-check") {
        enablePagination = false

        onLoad {
            val isSet = SS76.eventFlagsManager.get("demo-test-flag")
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