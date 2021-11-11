package tf.veriny.ss76.engine.scene

import kotlin.math.max
import kotlin.math.min

/**
 * Shared state for a single scene.
 */
public class SceneState(
    /** The definition for this scene. */
    public val definition: SceneDefinition,
    /** The current timer for this scene. */
    public var timer: Int = 0,
    /** The current page index. */
    public var pageIdx: Int = 0,
) {

    /** Jumps to the next page, clamped. */
    public fun pageNext() {
        val oldIdx = pageIdx
        pageIdx = min(pageIdx + 1, definition.pageCount - 1)
        if (oldIdx != pageIdx) timer = 0
    }

    /** Jumps to the previous page, clamped. */
    public fun pageBack() {
        val oldIdx = pageIdx
        pageIdx = max(0, pageIdx - 1)
        if (oldIdx != pageIdx) timer = 0
    }
}