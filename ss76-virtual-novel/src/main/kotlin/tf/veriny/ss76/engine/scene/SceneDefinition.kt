package tf.veriny.ss76.engine.scene

import tf.veriny.ss76.engine.*

public typealias onLoad = () -> Unit


/**
 * A scene definition that has already been prepared. This is useful for non-dynamic scenes.
 */
public class SceneDefinition(
    public val id: String,
    public val originalButtons: Map<String, Button>,
    private val pages: List<List<TextualNode>>,
    public val originalPages: List<String>,
    public val effects: SceneEffects,
    public val linkedInventoryId: Int = -1,
    public val dynamic: Boolean = false,
    onLoadHandlers: List<onLoad> = listOf(),
)  {
    public val buttons: Map<String, Button> = originalButtons.toMutableMap().apply {
        put("page-next", NextPageButton)
        put("page-back", PrevPageButton)

        put("record", ButtonManager.GLOBAL_BACK_BUTTON)
        put("checkpoint", ButtonManager.CHECKPOINT_BUTTON)
    }

    /** If this definition has custom onLoad handlers. */
    public val hasCustomOnLoad: Boolean = onLoadHandlers.isNotEmpty()

    @OptIn(ExperimentalStdlibApi::class)
    public val onLoadHandlers: List<onLoad> = buildList<onLoad> {
        addAll(onLoadHandlers)
    }

    /** Gets the page count for the specified page. */
    public val pageCount: Int get() = pages.size

    /**
     * Gets the tokens for the specified page.
     */
    public fun getTokensForPage(pageIdx: Int): List<TextualNode> {
        return pages[pageIdx]
    }
}


