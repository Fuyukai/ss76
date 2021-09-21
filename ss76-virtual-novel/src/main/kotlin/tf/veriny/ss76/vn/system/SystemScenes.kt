package tf.veriny.ss76.vn.system

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.ButtonManager
import tf.veriny.ss76.engine.ChangeSceneButton
import tf.veriny.ss76.engine.PushSceneButton
import tf.veriny.ss76.engine.scene.createAndRegisterScene

/**
 * Registers a handful of system maintenance scenes. These are generated at boot up.
 */
public fun registerSystemScenes(loadScene: String) {
    createAndRegisterScene("system-startup-scene") {
        // calc dangling buttons
        val dangling = mutableListOf<String>()
        for (scene in SS76.sceneManager.registeredScenes.values) {
            val buttons = scene.buttons.filter {
                it.value is ChangeSceneButton || it.value is PushSceneButton
            }

            for (button in buttons) {
                val linkedScene = button.value.linkedId
                if (linkedScene == null) {
                    dangling += "Button ${button.key} in ${scene.id} is a scene change button, but has " +
                                ":push:@red@ no linked scene ID :pop:\n"
                } else {
                    val actualScene = SS76.sceneManager.registeredScenes[linkedScene]
                    if (actualScene == null) {
                        dangling += "Button ${button.key} in ${scene.id} references non-existent " +
                                    "scene: @salmon@$linkedScene\n"
                    }
                }
            }
        }

        onLoad {
            if (dangling.isEmpty()) { SS76.sceneManager.changeScene(loadScene) }
        }

        page {
            line(":push:@green@ SS76 Engine Startup Scene :pop:")
            newline()

            line("Dangling scenes: ${dangling.size}")
            newline()

            changeSceneButton(loadScene,"Ignore warnings and load scene $loadScene")
        }

        for (i in dangling.chunked(5)) {
            page {
                for (item in i) {
                    line(item)
                }
            }
        }
    }
}