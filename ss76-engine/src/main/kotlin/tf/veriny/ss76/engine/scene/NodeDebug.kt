package tf.veriny.ss76.engine.scene

/**
 * Prints debug information about a series of textual nodes.
 */
public fun Collection<TextualNode>.debugPrintTimings() {
    for (node in this) {
        val text = when {
            node.causesNewline -> "<CRLF>"
            node.text.isBlank() -> "<emtpy>"
            else -> node.text
        }
        print("|${node.startFrame}|${node.endFrame}|$text")
        if (node.causesNewline) println()
        else if (node.causesSpace) print(" ")
    }
}