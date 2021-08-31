package tf.veriny.ss76.vn.demo

import tf.veriny.ss76.engine.FontManager
import tf.veriny.ss76.engine.scene.createAndRegisterScene

/**
 * Registers the all new Demo UI scene.
 */
public fun registerDemoUIScene() {
    createAndRegisterScene("renderer-v2-demo") {
        page {
            line("This is a demo screen!")
            newline()

            line(
                "The renderer has been completely rewritten. Now it supports lots of fancy " +
                "features!"
            )
            newline()

            line("The next line wraps.")
            line("Signaling System No. 7 (or Signalling System No. 7, SS7) is a set of " +
                 "telephony signaling protocols developed in 1975, which is used to set up and tear " +
                 "down telephone calls in most parts of the world-wide public switched telephone " +
                 "network (PSTN)")
            newline()

            line("Colours:")
            newline()

            val colours = FontManager.COLOURS.keys.joinToString(" ") {  "@$it@$it" }
            line(colours)
        }

        page {
            line("The last word in this sentence will ¬shake¬shake.")
            line(":push:¬shake¬ But, not the last word in this :pop: sentence.")
        }

        page {
            line("Shuffled numbers: ¬shufnum¬0123456789")
            line("Shuffled text: ¬shuftxt¬abcdefghi")
        }
    }
}