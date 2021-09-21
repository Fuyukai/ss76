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
    /** The current page index. Used in various places. */
    pageIdx: Int = 0,
) {
    public var pageIdx: Int = pageIdx
        private set

    public fun pageNext() {
        println(definition.pageCount - 1)
        pageIdx = min(pageIdx + 1, definition.pageCount - 1)
    }

    public fun pageBack() {
        pageIdx = max(0, pageIdx - 1)
    }
}