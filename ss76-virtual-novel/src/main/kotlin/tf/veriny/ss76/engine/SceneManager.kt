package tf.veriny.ss76.engine

import com.badlogic.gdx.Input
import dev.dirs.BaseDirectories
import ktx.app.KtxInputAdapter
import tf.veriny.ss76.engine.scene.VirtualNovelScene
import java.nio.file.Files
import java.nio.file.Path

/**
 * Responsible for handling loaded scenes.
 */
public class SceneManager(public val namespace: String) : KtxInputAdapter {
    private val seenScenes /*on the sea shore*/= mutableSetOf<String>()
    private val registeredScenes = mutableMapOf<String, VirtualNovelScene>()

    public val sceneCount: Int get() = registeredScenes.size

    private var previousScene: VirtualNovelScene? = null

    /**
     * Registers a single scene.
     */
    public fun registerScene(scene: VirtualNovelScene) {
        registeredScenes[scene.id] = scene
    }

    /**
     * Saves the previously seen scenes.
     */
    public fun saveSeenScenes() {
        val dataDir = Path.of(BaseDirectories.get().dataDir)
        val saveDir = dataDir.resolve("ss76/$namespace")
        Files.createDirectories(saveDir)

        val saveData = saveDir.resolve("seen.txt")
        val savedScenes = seenScenes.joinToString("\n")
        Files.writeString(saveData, savedScenes)
    }

    /**
     * Loads the previous seen scenes.
     */
    public fun loadSeenScenes() {
        val dataDir = Path.of(BaseDirectories.get().dataDir)
        val saveDir = dataDir.resolve("ss76/$namespace")
        Files.createDirectories(saveDir)

        val saveData = saveDir.resolve("seen.dat")
        if (!Files.exists(saveData)) return
        val scenes = Files.readString(saveData).split("\n")
        seenScenes.addAll(scenes)
    }

    public fun hasVisitedScene(scene: String): Boolean {
        return seenScenes.contains(scene)
    }

    public fun hasVisitedScene(scene: VirtualNovelScene): Boolean = hasVisitedScene(scene.id)

    // == Scene stack == //
    private val stack = ArrayDeque<VirtualNovelScene>()

    public val stackSize: Int get() = stack.size
    public val currentScene: VirtualNovelScene get() = stack.last()

    private fun activateScene(scene: VirtualNovelScene) {
        stack.add(scene)
        scene.sceneLoaded()
    }

    /**
     * Pushes and activates a scene.
     */
    public fun pushScene(scene: VirtualNovelScene) {
        if (stack.isNotEmpty()) {
            val tos = stack.last()
            tos.sceneUnloaded(DeactivationType.PUSHED)
            previousScene = tos
        }

        activateScene(scene)
    }

    /**
     * Pushes and activates a scene, using its string id.
     */
    public fun pushScene(scene: String) {
        val realScene = getScene(scene)
        pushScene(realScene)
    }

    /**
     * Changes the top scene on the stack.
     */
    public fun changeScene(scene: VirtualNovelScene) {
        val tos = stack.removeLast()
        tos.sceneUnloaded(DeactivationType.POPPED)
        previousScene = tos

        activateScene(scene)
    }

    /**
     * Changes the top scene on the stack, using its ID.
     */
    public fun changeScene(scene: String) {
        val scene = getScene(scene)
        changeScene(scene)
    }

    /**
     * Exits from the top scene.
     */
    public fun exitScene() {
        val tos = stack.removeLast()
        tos.sceneUnloaded(DeactivationType.POPPED)
        previousScene = tos

        val newTos = stack.last()
        activateScene(newTos)
    }

    /**
     * Gets a single scene.
     */
    public fun getScene(scene: String): VirtualNovelScene {
        return registeredScenes[scene] ?: error("missing scene definition: $scene")
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        currentScene.skipTimer()
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.DPAD_LEFT) {
            currentScene.pageBack()
        } else if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.DPAD_RIGHT) {
            currentScene.pageForward()
        } else if (keycode == Input.Keys.SPACE || keycode == Input.Keys.ENTER) {
            currentScene.skipTimer()
            return true
        }

        return false
    }
}