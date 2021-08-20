package tf.veriny.ss76.vn.side

import tf.veriny.ss76.scene.text.createAndRegisterScene

/**
 * Contains scenes relating to Alex's radio sideplot.
 */
public fun registerSidePlotAlexRadio() {
    createAndRegisterScene("side.sussex.alex-radio-0") {
        page {
            line("Uh, I haven't written this side story fully yet.")
            backButton()
        }
    }
}