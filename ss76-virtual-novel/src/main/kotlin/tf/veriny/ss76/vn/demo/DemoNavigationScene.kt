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
            line("This is the Signalling System 76 demo menu.")
            newline()

            line("Unless this is a demo build, you shouldn't be here.")
            newline()

            pushSceneButton("credits-menu", "Credits")
            newline()

            pushSceneButton("oss-credits", "OSS Credits")
        }

        page {
            line("ROUTE ONE JUMP POINTS #1")
            newline()

            pushSceneButton(
                "sussex-july-3-start",
                "2021-08-24: Route One, 03/07"
            )
            newline()

            pushSceneButton("sussex-july-4-start", "2021-08-26: Route One, 04/07")
            newline()

            pushSceneButton("su5j-start", "2021-09-20: Route One, 05/07")
            newline()

            pushSceneButton("su6j-start", "2021-09-14: Route One, 06/07")
            newline()
        }

        page {
            line("ROUTE ONE SIDE STORY JUMP POINTS #1")
            newline()

            pushSceneButton("sussex-july-4-pre-9", "2021-09-04: Forest Side Story pre-scene")
            newline()
        }


        page {
            line("UI DEMOS")
            newline()

            pushSceneButton(
                "renderer-v2-demo", "Renderer V2 Demo"
            )
            newline()

            pushSceneButton("invert", "2021-09-08: Invert.")
            newline()

            pushSceneButton("invert-2", "2021-09-08: The world ends.")
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
}