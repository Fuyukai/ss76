package tf.veriny.ss76.scene.text

import org.apache.commons.text.WordUtils
import tf.veriny.ss76.scene.Scene

/**
 * A single textual node.
 */
public sealed class TextualNode {
    public companion object {
        /**
         * Helper function to split a string into a series of textual nodes.
         */
        public fun split(
            s: String, trailingNewline: Boolean, leftMargin: Int = 0
        ): List<TextualNode> {
            val length = 68 - leftMargin
            val wrappedLines = s
                .split("\n")
                .map { WordUtils.wrap(it, length, "\n", false) }

            val tokens = mutableListOf<TextualNode>()

            // Oh god oh fuck
            for (line in wrappedLines) {
                if (line == "") {
                    // used to be a newline
                    tokens.add(Newline)
                    continue
                }

                val sublines = line.split("\n")
                for ((slIdx, subline) in sublines.withIndex()) {
                    val words = subline.split(" ")
                    if (slIdx != 0 && leftMargin > 0) {
                        tokens.add(Pad(leftMargin))
                    }

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


/** Superclass for nodes with text. */
public abstract class NodeWithText(public val word: String) : TextualNode()

/** A single word. */
public class WordNode(word: String) : NodeWithText(word) {
    override fun toString(): String {
        return "WordNode(\"$word\")"
    }
}

/** A padding node. */
public class Pad(public val count: Int) : TextualNode()

/** A newline. Forces the renderer to move down one line. */
public object Newline : TextualNode()

/**
 * A link to another scene, perhaps.
 *
 * @param id: The ID of the scene being linked to.
 */
public class LinkNode(
    public val id: String,
    text: String,
    public val type: LinkType,
    public val action: (Scene) -> Unit,
) : NodeWithText(text) {
    public enum class LinkType {
        /**
         * Push link, that pushes a new scene on the stack. This is red when the scene is unseen,
         * and green when the scene has been seen before.
         */
        PUSH_LINK,

        /**
         * The next scene link. This is always orange.
         */
        NEXT_SCENE,

        /**
         * The back button. This is always green.
         */
        BACK_BUTTON,
    }

    override fun toString(): String {
        return "LinkNode(link to '$id')"
    }
}