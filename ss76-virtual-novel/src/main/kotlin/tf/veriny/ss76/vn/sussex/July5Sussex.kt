package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.engine.scene.createAndRegisterScene

public fun registerSussexJuly5Scenes() {
    createAndRegisterScene("sussex-july-5-start") {
        topText = "SS76 - Route One - 05/07"

        page {
            line("Today's date is Wednesday, the 5rd of July.")
            newline()

            line("It's a sunny day. Some clouds :push:@sky@ break up the skyline. :pop:")
            line("It hasn't rained in as long as you can remember.")
            newline()

            changeSceneButton("sussex-july-3-school-1", ">> Next")
        }
    }
}