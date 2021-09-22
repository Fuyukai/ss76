package tf.veriny.ss76.vn.truth

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.sceneSequence

public fun registerTruthDayOneScenes(): Unit = sceneSequence("tt-1-") {
    createAndRegisterOnePageScene("start") {
        line("Today's date is the 20th of July, 2012.")
        newline()

        line("It's a sunny day.")
        newline()

        line("A friend once asked me,", addNewline = false)
        //changeSceneButton(
        //    "tt-1-plane-1",
        //    "it's only been one day since the last time we saw each other, hasn't it?"
        //)
    }
}