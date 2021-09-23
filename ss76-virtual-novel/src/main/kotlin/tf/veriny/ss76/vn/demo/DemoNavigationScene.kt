package tf.veriny.ss76.vn.demo

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.nvl.NVLRenderer
import tf.veriny.ss76.engine.nvl.NVLScreen
import tf.veriny.ss76.engine.scene.createAndRegisterScene
import tf.veriny.ss76.engine.screen.Screen
import tf.veriny.ss76.engine.screen.WindowSizeShifter
import tf.veriny.ss76.isInsideJar
import tf.veriny.ss76.vn.sussex.CarRenderer

public fun registerDemoNavigationScenes() {
    createAndRegisterScene("demo-meta-menu") {
        page {
            line("This is the Signalling System 76 demo menu.")
            newline()

            line("Unless this is a demo build, you shouldn't be here.")
            newline()

            pushSceneButton("credits-menu", "Credits")
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

            pushSceneButton("su5j-drive-1", "2021-09-22: Route One, 05/07, Car Scene")
            newline()

            pushSceneButton("sussex-july-6-start", "2021-09-14: Route One, 06/07")
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

            if (!isInsideJar()) {
                pushSceneButton("invert-2", "2021-09-08: The world ends.")
                newline()
            }

            pushSceneButton("lightning", "2021-09-20: Lightning flashes")
            newline()

            pushSceneButton("resize-large", "2021-09-21: Grow screen")
            newline()

            if (!isInsideJar()) {
                pushSceneButton("car-renderer", "Le boat has arrived")
            }
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
}