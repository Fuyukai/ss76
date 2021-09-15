package tf.veriny.ss76.engine.scene

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.SS76
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
public class BasicSceneDefinition(
    override val id: String,
    public val originalButtons: Map<String, ButtonManager.Button>,
    private val pages: List<List<TextualNode>>,
    public val clearScreenColour: Color? = null,
    public val changedTopText: String? = null,
    public val dynamic: Boolean = false,
    onLoadHandlers: List<onLoad> = listOf(),
    invert: Boolean = false,
) : VirtualNovelSceneDefinition {
    override val buttons: Map<String, ButtonManager.Button> = originalButtons.toMutableMap().apply {
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
    override val onLoadHandlers: List<onLoad> = buildList<onLoad> {
        addAll(onLoadHandlers)
        if (clearScreenColour != null) {
            add { SS76.clearScreenColor = clearScreenColour }
        }
        if (changedTopText != null) {
            add { SS76.setTopText(changedTopText) }
        }
    }

    override val pageCount: Int
        get() = pages.size

    override fun getTokensForPage(pageIdx: Int): List<TextualNode> {
        return pages[pageIdx]
    }

    override fun loadThisFrame(): Unit = Unit
}


