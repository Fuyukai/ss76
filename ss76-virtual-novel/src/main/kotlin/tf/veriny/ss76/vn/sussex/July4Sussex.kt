package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.SS76
import tf.veriny.ss76.scene.text.buildDateMarkerScene
import tf.veriny.ss76.scene.text.createAndRegisterScene

private const val JULY_4_FORECAST = "It's a sunny day. It's even hotter than yesterday. " +
                                    "Small clouds break up the skyline."
private val JULY_4_DATE_SCENE = buildDateMarkerScene(
    "sussex-july-4-start", "Tuesday", 4, JULY_4_FORECAST,
    "sussex-july-4-school-1"
)

public fun registerSussexJuly4Scenes() {
    SS76.registerScene(JULY_4_DATE_SCENE)

    createAndRegisterScene("sussex-july-4-school-1") {
        page {
            line("You've reached the end of Day One, Route one.")
            newline()

            line("The current demo ends here. Thanks for reading!")
            newline()

            line("Please report to Lura with any of your thoughts over this, good or bad.")
            newline()

            line("Press F2 to return to the demo menu.")
        }
    }
}