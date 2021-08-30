package tf.veriny.ss76.engine.scene

import tf.veriny.ss76.engine.ButtonManager

public typealias onLoad = (VirtualNovelScene) -> Unit

/**
 * A single definition for a virtual novel scene. This produces a series of tokens with metadata to
 * be rendered.
 */
public interface VirtualNovelSceneDefinition {
    /** The ID of this scene. */
    public val id: String

    /** The number of pages this definition has. */
    public val pageCount: Int

    /** The list of functions to be called on scene load. */
    public val onLoadHandlers: List<(VirtualNovelScene) -> Unit>

    /** The mapping of buttons for this scene. */
    public val buttons: Map<String, ButtonManager.Button>

    /**
     * Gets the tokens for a single page. This shouldn't do any loaded.
     */
    public fun getTokensForPage(pageIdx: Int): List<TextualNode>

    /** Loads the definition for this frame. */
    public fun loadThisFrame()
}

/**
 * A scene definition that has already been prepared. This is useful for non-dynamic scenes.
 */
public class PreparedSceneDefinition(
    override val id: String,
    override val onLoadHandlers: List<onLoad>,
    buttons: Map<String, ButtonManager.Button>,
    private val pages: List<List<TextualNode>>
) : VirtualNovelSceneDefinition {
    override val buttons: Map<String, ButtonManager.Button> = buttons.toMutableMap().apply {
        put("page-next", ButtonManager.NEXT_BUTTON)
        put("page-back", ButtonManager.BACK_BUTTON)
    }

    override val pageCount: Int
        get() = pages.size

    override fun getTokensForPage(pageIdx: Int): List<TextualNode> {
        return pages[pageIdx]
    }

    override fun loadThisFrame(): Unit = Unit
}


