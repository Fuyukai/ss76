package tf.veriny.ss76.engine

import tf.veriny.ss76.EngineState
import tf.veriny.ss76.SS76

/**
 * A single button.
 */
public interface Button {
    /** The name of this button. */
    public val name: String

    /** The linked scene ID for this button, if any. */
    public val linkedId: String?
        get() = null

    /**
     * Does something when this button is clicked.
     */
    public fun run(state: EngineState)
}

/**
 * A button for changing scene.
 */
public class ChangeSceneButton(
    public override val name: String,
    public override val linkedId: String,
    /** The event flag to set. */
    public val setFlag: String? = null,
) : Button {

    override fun run(state: EngineState) {
        if (setFlag != null) state.eventFlagsManager.set(setFlag)
        state.sceneManager.changeScene(linkedId)
    }
}

/**
 * A button for pushing a new scene.
 */
public class PushSceneButton(
    public override val name: String,
    public override val linkedId: String,
    /** The event flag to set. */
    public val setFlag: String? = null,
) : Button {
    override fun run(state: EngineState) {
        if (setFlag != null) state.eventFlagsManager.set(setFlag)
        state.sceneManager.pushScene(linkedId)
    }
}

/**
 * A button that exits the current scene.
 */
public object BackButton : Button {
    override val name: String = "back-button"

    override fun run(state: EngineState) {
        state.sceneManager.exitScene()
    }
}

public object PrevPageButton : Button {
    override val name: String = "prev-page"

    override fun run(state: EngineState) {
        state.sceneManager.currentScene.pageBack()
    }
}

public object NextPageButton : Button {
    override val name: String = "next-page"

    override fun run(state: EngineState) {
        state.sceneManager.currentScene.pageNext()
    }
}

