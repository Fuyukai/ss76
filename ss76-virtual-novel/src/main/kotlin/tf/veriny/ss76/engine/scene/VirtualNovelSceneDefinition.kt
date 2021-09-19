package tf.veriny.ss76.engine.scene

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.ButtonManager

public typealias onLoad = (VirtualNovelScene) -> Unit


/**
 * A scene definition that has already been prepared. This is useful for non-dynamic scenes.
 */
public class VirtualNovelSceneDefinition(
    public val id: String,
    public val originalButtons: Map<String, ButtonManager.Button>,
    private val pages: List<List<TextualNode>>,
    public val originalPages: List<String>,
    public val clearScreenColour: Color? = null,
    public val changedTopText: String? = null,
    public val dynamic: Boolean = false,
    onLoadHandlers: List<onLoad> = listOf(),
    invert: Boolean = false,
)  {
    public val buttons: Map<String, ButtonManager.Button> = originalButtons.toMutableMap().apply {
        put("page-next", ButtonManager.NEXT_BUTTON)
        put("page-back", ButtonManager.BACK_BUTTON)

        put("record", ButtonManager.GLOBAL_BACK_BUTTON)
        put("checkpoint", ButtonManager.CHECKPOINT_BUTTON)
    }

    /** If this definition has custom onLoad handlers. */
    public val hasCustomOnLoad: Boolean = onLoadHandlers.isNotEmpty()

    /** If this scene should invert the central black box. */
    public val invert: Boolean = invert

    /** If the renderer should render extra components. */
    public val renderExtras: Boolean = !invert

    @OptIn(ExperimentalStdlibApi::class)
    public val onLoadHandlers: List<onLoad> = buildList<onLoad> {
        addAll(onLoadHandlers)
        if (clearScreenColour != null) {
            add { SS76.clearScreenColor = clearScreenColour }
        }
        if (changedTopText != null) {
            add { SS76.setTopText(changedTopText) }
        }
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


