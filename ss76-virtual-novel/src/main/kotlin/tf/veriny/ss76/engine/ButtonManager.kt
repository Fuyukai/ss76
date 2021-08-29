package tf.veriny.ss76.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Cursor
import com.badlogic.gdx.math.Rectangle
import ktx.app.KtxInputAdapter
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.VirtualNovelScene

public typealias ButtonAction = (VirtualNovelScene) -> Unit

/**
 * Manages the clickable buttons on a scene.
 */
public class ButtonManager : KtxInputAdapter {
    /**
     * A single button.
     */
    public data class Button(
        /** The name of this button. */
        public val name: String,
        /** The linked scene ID of this button. */
        public val linkedId: String? = null,
        /** The action to take on clicking this button. */
        public val action: (VirtualNovelScene) -> Unit
    )

    // mapping of button -> rectangle of possible locations on screen.
    // used when moving the mouse or clicking it
    private val buttonRects = mutableMapOf<Button, MutableSet<Rectangle>>()

    public fun addClickableArea(button: Button, rect: Rectangle) {
        var set = buttonRects[button]
        if (set == null) {
            set = mutableSetOf()
            buttonRects[button] = set
        }
        set.add(rect)
    }

    /**
     * Resets the current set of button rectangles.
     */
    public fun reset() {
        buttonRects.clear()
    }

    private fun hit(screenX: Int, screenY: Int): Button? {
        val realX: Float = screenX.toFloat()
        val realY: Float = (Gdx.graphics.height - screenY.toFloat())

        for ((node, set) in buttonRects.entries) {
            for (rect in set) {
                if (rect.contains(realX, realY)) {
                    return node
                }
            }
        }

        return null
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        // always intercept this

        if (hit(screenX, screenY) != null) {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand)
        } else {
            Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow)
        }
        return true
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val node = hit(screenX, screenY)
        if (node == null) {
            return false
        } else {
            node.action.invoke(SS76.sceneManager.currentScene)
        }

        return true
    }
}