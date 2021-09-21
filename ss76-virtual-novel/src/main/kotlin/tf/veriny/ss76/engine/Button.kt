package tf.veriny.ss76.engine

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.renderer.NVLRenderer

/**
 * A single button.
 */
public interface Button : Runnable {
    /** The name of this button. */
    public val name: String

    /** The linked scene ID for this button, if any. */
    public val linkedId: String?
        get() = null
}

/**
 * A button for changing scene.
 */
public class ChangeSceneButton(
    public override val name: String,
    public override val linkedId: String
) : Button {

    override fun run() {
        SS76.sceneManager.changeScene(linkedId)
    }
}

/**
 * A button for pushing a new scene.
 */
public class PushSceneButton(
    public override val name: String,
    public override val linkedId: String
) : Button {
    override fun run() {
        SS76.sceneManager.pushScene(linkedId)
    }
}

/**
 * A button that exits the current scene.
 */
public object BackButton : Button {
    override val name: String = "back-button"

    override fun run() {
        SS76.sceneManager.exitScene()
    }
}

public object PrevPageButton : Button {
    override val name: String = "next-page"

    override fun run() {
        SS76.sceneManager.currentScene.pageBack()
    }
}

public object NextPageButton : Button {
    override val name: String = "prev-page"

    override fun run() {
        SS76.sceneManager.currentScene.pageNext()
    }
}

