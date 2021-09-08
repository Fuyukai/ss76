package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.scene.createAndRegisterScene

public fun registerSussexJuly6Scenes() {
    createAndRegisterScene("sussex-july-6-start") {
        clearScreenColour = Color.BLUE
        topText = "SS76 - Route One - 06/07"

        page {
            line("Today's date is Thursday, the 6th of July.")
            newline()

            line("It's a :push:@sky@ dark, cloudy day. :pop:")
            line("It hasn't @sky@stopped @sky@raining in days.")
            newline()

            changeSceneButton("sussex-july-6-dream", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-6-dream") {
        page {
            line("Last night, I had a strange dream.")
            newline()

            line("I was a child again, and I had to make a village. There was only one rule " +
                 "- don't touch the buildings that were already there.")
            newline()

            line("So I made a village, and it was good. I liked my village. I liked the people " +
                 "that lived in it. I took good care of them, and I had lots of friends.")
            newline()

            backButton("-- END OF DEMO --")
        }
    }
}