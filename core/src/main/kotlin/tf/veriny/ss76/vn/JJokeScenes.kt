package tf.veriny.ss76.vn

import tf.veriny.ss76.scene.text.createAndRegisterScene

public fun registerJokeScenes() {
    createAndRegisterScene("zack-snyder") {
        page {
            line("This film is presented in a 4:3 to preserve the integrity of Zack Snyder's creative vision.")
        }
    }
}