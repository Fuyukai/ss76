package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.SS76
import tf.veriny.ss76.isInsideJar
import tf.veriny.ss76.scene.text.buildDateMarkerScene
import tf.veriny.ss76.scene.text.createAndRegisterScene
import tf.veriny.ss76.vn.CommonScenes

private const val JULY_4_FORECAST = "It's a sunny day. It's even hotter than yesterday. " +
                                    "Small clouds break up the skyline."
private val JULY_4_DATE_SCENE = buildDateMarkerScene(
    "sussex-july-4-start", "Tuesday", 4, JULY_4_FORECAST,
    "sussex-july-4-school-1"
)

public fun registerSussexJuly4Scenes() {
    SS76.registerScene(JULY_4_DATE_SCENE)

    createAndRegisterScene("sussex-july-4-school-1") {
        onLoad {
            if (isInsideJar()) {
                SS76.changeScene(CommonScenes.END_OF_DEMO)
            }
        }

        page {

        }
    }

}