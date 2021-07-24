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
        public fun line(text: String, addNewline: Boolean = true) {
            tokens += TextualNode.split(text, trailingNewline = addNewline)
        }

        /**
         * Creates a link that performs an action when clicked.
         */
        public fun link(
            id: String, text: String, skipSeen: Boolean = false, action: (Scene) -> Unit
        ) {
            val token = TextualNode.LinkNode(
                id = id, text = text, action = action, skipSeen = skipSeen
            )
            tokens.add(token)
        }

        /**
         * Adds a newline.
         */
        public fun newline(count: Int = 1) {
            repeat(count) {
                tokens += TextualNode.Newline
            }
        }

        /**
         * Adds a link to another scene.
         */
        public fun pushSceneButton(sceneId: String, text: String, skipSeen: Boolean = false) {
            return link(sceneId, text, skipSeen=skipSeen) { SS76.pushScene(sceneId) }
        }

        /**
         * Adds the back button.
         */
        public fun backButton(text: String = "Back", skipSeen: Boolean = false) {
            val realText = "« $text"
            return link("SKIP", text = realText, skipSeen = skipSeen) {
                it.reset()
                SS76.exitScene()
            }
        }

        /**
         * Adds a change scene button.
         */
        public fun changeSceneButton(nextScene: String, text: String, skipSeen: Boolean = false) {
            return link(nextScene, text, skipSeen = skipSeen) {
                it.reset()
                SS76.changeScene(nextScene)
            }
        }

        /**
         * Adds the next button.
         */
        public fun nextSceneButton(nextScene: String, text: String = "Next", skipSeen: Boolean = false) {
            val realText = "» $text"
            return link("SKIP", text = realText, skipSeen = skipSeen) {
                it.reset()
                SS76.changeScene(nextScene)
            }
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
            nextSceneButton(nextSceneId, "Next")
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