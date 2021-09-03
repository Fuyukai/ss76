package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.engine.scene.createAndRegisterScene


public fun registerSussexJuly5Pt2Scenes() {
    createAndRegisterScene("sussex-july-52-start") {
        topText = "SS76 - Route One - 05/07"

        page {
            line("Today's date is Wednesday, the 5rd of July.")
            newline()

            line("It's just gone @teal@13:00.")
            newline()

            line("It's a @sky@mildly @sky@cloudy day.")
            line("It hasn't rained in as long as you can remember.")
            newline()

            //changeSceneButton("sussex-july-52-mansion-1", ">> Next")
            changeSceneButton("demo-menu", ">> Next")
        }
    }
}