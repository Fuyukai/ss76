package tf.veriny.ss76.scene.text

import tf.veriny.ss76.SS76
import tf.veriny.ss76.getDayOfMonthSuffix
import tf.veriny.ss76.scene.Scene

/**
 * Builder object for the text scene.
 */
public class TextSceneBuilder(private val id: String) {
    private val pages = mutableListOf<MutableList<TextualNode>>()
    private val onLoad = mutableListOf<(Scene) -> Unit>()

    private inner class SimpleTextualScene : TextualScene(onLoad) {
        override val id: String = this@TextSceneBuilder.id
        override fun getTextToRender(): List<TextualNode> {
            return pages[0]
        }
    }

    public class PageBuilder {
        internal val tokens = mutableListOf<TextualNode>()

        /**
         * Creates a single line. It will be automatically wrapped.
         */
        public fun line(text: String, addNewline: Boolean = true, leftMargin: Int = 0) {
            tokens += TextualNode.split(text, trailingNewline = addNewline, leftMargin = leftMargin)
        }

        public fun dline(text: String, addNewline: Boolean = true) {
            line(text, addNewline, leftMargin = 6)
            if (addNewline) {
                newline(1)
            }
        }

        public fun dline2(text: String, addNewline: Boolean = true) {
            dline("\u0000" + text, addNewline)
        }

        /**
         * Creates a link that performs an action when clicked.
         */
        public fun link(
            id: String, text: String, type: LinkNode.LinkType, action: (Scene) -> Unit
        ) {
            val token = LinkNode(
                id = id, text = text, action = action, type = type,
            )
            tokens.add(token)
        }

        /**
         * Adds a newline.
         */
        public fun newline(count: Int = 1) {
            repeat(count) {
                tokens += Newline
            }
        }

        /**
         * Adds a link to another scene.
         */
        public fun pushSceneButton(sceneId: String, text: String) {
            val token = LinkNode(sceneId, text, LinkNode.LinkType.PUSH_LINK) {
                SS76.pushScene(sceneId)
            }
            tokens += token
        }

        /**
         * Adds the back button.
         */
        public fun backButton(text: String = "Back", skipSeen: Boolean = false) {
            val realText = "« $text"
            val token = LinkNode("SKIP", realText, LinkNode.LinkType.BACK_BUTTON) {
                it.reset()
                SS76.exitScene()
            }
            tokens += token
        }

        /**
         * Adds a change scene button.
         */
        public fun changeSceneButton(nextScene: String, text: String, skipSeen: Boolean = false) {
            val token = LinkNode(nextScene, text, LinkNode.LinkType.NEXT_SCENE) {
                it.reset()
                SS76.changeScene(nextScene)
            }
            tokens += token
        }

    }

    public fun page(block: PageBuilder.() -> Unit) {
        val page = PageBuilder()
        page.block()
        this.pages += page.tokens
    }

    public fun onLoad(fn: (Scene) -> Unit) {
        onLoad += fn
    }

    public fun build(): TextualScene {
        if (pages.size == 1) {
            return SimpleTextualScene()
        }
        return SimplePageableScene(id, pages, onLoad)
    }

}

/**
 * Builds a new textual scene using a DSL.
 */
public fun createScene(id: String, block: TextSceneBuilder.() -> Unit): TextualScene {
    val builder = TextSceneBuilder(id)
    builder.block()
    return builder.build()
}

/**
 * Builds the date marker scene.
 */
public fun buildDateMarkerScene(
    id: String,
    weekday: String, day: Int, forecast: String,
    nextSceneId: String,
    block: TextSceneBuilder.() -> Unit = {}
): TextualScene {
    return createScene(id) {
        page {
            val realDay = day.toString().padStart(2, '0')
            onLoad { SS76.setTopText("SS76 - $realDay/07") }

            line("Today's date is $weekday, the ${day}${getDayOfMonthSuffix(day)} of July.")
            newline()
            line(forecast)
            newline()
            changeSceneButton(nextSceneId, "» Next")
        }

        block()
    }
}

/**
 * Creates and registers a new scene.
 */
public fun createAndRegisterScene(id: String, block: TextSceneBuilder.() -> Unit): TextualScene {
    val scene = createScene(id, block)
    SS76.registerScene(scene)
    return scene
}