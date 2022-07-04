package tf.veriny.ss76

import tf.veriny.ss76.vn.SS76Registrar

public object MakeUp {
    @JvmStatic public fun main(args: Array<String>) {
        launchEngine(
            "signalling-system-76", SS76Registrar,
            "Signalling System 76", "SIGNALLING SYSTEM 76"
        )
    }
}