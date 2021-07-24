package tf.veriny.ss76.scene.text

import org.apache.commons.text.WordUtils
import tf.veriny.ss76.scene.Scene

/**
 * A single textual node.
 */
public sealed class TextualNode {
    /** Superclass for nodes with text. */
    public abstract class NodeWithText(public val word: String) : TextualNode()

    /** A single word. */
    public class WordNode(word: String) : NodeWithText(word) {
        override fun toString(): String {
            return "WordNode(\"$word\")"
        }
    }
    /** A newline. Forces the renderer to move down one line. */
    public object Newline : TextualNode()

    /**
     * A link to another scene, perhaps.
     *
     * @param id: The ID of the scene being linked to.
     */
    public class LinkNode(
        public val id: String,
        public val action: (Scene) -> Unit,
        text: String,
        public val skipSeen: Boolean = false
    ) : NodeWithText(text) {
        override fun toString(): String {
            return "LinkNode(link to '$id')"
        }
    }

    public companion object {
        /**
         * Helper function to split a string into a series of textual nodes.
         */
        public fun split(s: String, trailingNewline: Boolean): List<TextualNode> {
            val wrappedLines = s
                .split("\n")
                .map { WordUtils.wrap(it, 68, "\n", false) }

            val tokens = mutableListOf<TextualNode>()

            // Oh god oh fuck
            for (line in wrappedLines) {
                if (line == "") {
                    // used to be a newline
                    tokens.add(Newline)
                    continue
                }

                val sublines = line.split("\n")
                for (subline in sublines) {
                    val words = subline.split(" ")
                    for (word in words) {
                        tokens.add(WordNode(word))
                    }
                    tokens.add(Newline)
                }

                if (!trailingNewline) {
                    tokens.removeLast()
                }
            }

            return tokens
        }
    }
}