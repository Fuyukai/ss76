package tf.veriny.ss76.scene.text

import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import tf.veriny.ss76.scene.Scene
import kotlin.math.max
import kotlin.math.min


/**
 * A scene that supports paging over multiple pages.
 */
public class SimplePageableScene(
    public override val id: String,
    pages: List<List<TextualNode>>,
    onLoad: List<(Scene) -> Unit>
) : TextualScene(onLoad) {
    public var pageIdx: Int = 0

    private fun pageBack() {
        val prev = pageIdx
        pageIdx = max(0, pageIdx - 1)
        if (prev != pageIdx) reset()
    }

    private fun pageForward() {
        val prev = pageIdx
        pageIdx = min(pages.size - 1, pageIdx + 1)
        if (prev != pageIdx) reset()
    }

    private val pages = run {
        val newPages = mutableListOf<List<TextualNode>>()
        val backNode = LinkNode(
            "SKIP", "« PREVIOUS", LinkNode.LinkType.NEXT_SCENE
        ) { pageBack() }
        val forwardNode = LinkNode(
            "SKIP", "FORWARD »", LinkNode.LinkType.NEXT_SCENE
        ) { pageForward() }
    
        for ((id, page,)  in pages.withIndex()) {
            val splitNodes = TextualNode.split(
                "== Page ${id + 1}/${pages.size} ==", trailingNewline = false
            )
            val newPage = mutableListOf<TextualNode>(backNode)
            newPage.addAll(splitNodes)
            newPage.add(forwardNode)
            repeat(2) { newPage.add(Newline) }
            newPage.addAll(page)
            newPages.add(newPage)
        }
        newPages
    }

    private inner class PageableInputSource : TextualScene.TextualSceneInput() {
        override fun keyDown(keycode: Int): Boolean {
            if (keycode == Input.Keys.LEFT || keycode == Input.Keys.DPAD_LEFT) {
                pageBack()
            } else if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.DPAD_RIGHT) {
                pageForward()
            } else {
                return super.keyDown(keycode)
            }

            return true
        }
    }

    override val input: InputProcessor = PageableInputSource()

    override fun getTextToRender(): List<TextualNode> {
        return pages[pageIdx]
    }


}