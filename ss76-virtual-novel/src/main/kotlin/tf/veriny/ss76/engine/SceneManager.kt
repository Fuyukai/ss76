package tf.veriny.ss76.engine

import com.badlogic.gdx.Input
import dev.dirs.BaseDirectories
import ktx.app.KtxInputAdapter
import okio.BufferedSink
import okio.BufferedSource
import okio.ByteString.Companion.encodeUtf8
import tf.veriny.ss76.engine.scene.VirtualNovelScene
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

/**
 * Responsible for handling loaded scenes.
 */
public class SceneManager(public val namespace: String) : KtxInputAdapter, Saveable {
    private val seenScenes /*on the sea shore*/= mutableSetOf<String>()
    private val registeredScenes = mutableMapOf<String, VirtualNovelScene>()
    public val sceneCount: Int get() = registeredScenes.size

    private val stack = ArrayDeque<VirtualNovelScene>()
    public val stackSize: Int get() = stack.size
    public val currentScene: VirtualNovelScene get() = stack.last()

    private var previousScene: VirtualNovelScene? = null

    /**
     * Registers a single scene.
     */
    public fun registerScene(scene: VirtualNovelScene) {
        registeredScenes[scene.id] = scene
    }

    /**
     * Re-registers a scene. This will update any references in the current stack of scenes.
     */
    public fun reregisterScene(scene: VirtualNovelScene) {
        val old = registeredScenes[scene.id]
        registeredScenes[scene.id] = scene

        if (old == null) return
        if (stack.isEmpty()) return

        when {
            // TOS requires unloading the old scene and replacing it with the new one
            currentScene == old -> {
                old.sceneUnloaded(DeactivationType.POPPED)
                stack.removeLast()
                activateScene(scene)
                scene.resetTimer()
            }
            // just swap the references to the old scenes with the new one
            previousScene == old -> {
                previousScene = scene
            }
            else -> {
                for (idx in 0 until stackSize) {
                    if (stack[idx] == old) {
                        stack[idx] = scene
                    }
                }
            }
        }
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
        Files.writeString(saveData, savedScenes, StandardOpenOption.TRUNCATE_EXISTING)
    }

    /**
     * Loads the previous seen scenes.
     */
    public fun loadSeenScenes() {
        val dataDir = Path.of(BaseDirectories.get().dataDir)
        val saveDir = dataDir.resolve("ss76/$namespace")
        Files.createDirectories(saveDir)

        val saveData = saveDir.resolve("seen.txt")
        if (!Files.exists(saveData)) return
        val scenes = Files.readString(saveData).split("\n")
        seenScenes.addAll(scenes)
    }

    public fun hasVisitedScene(scene: String): Boolean {
        return seenScenes.contains(scene)
    }

    public fun hasVisitedScene(scene: VirtualNovelScene): Boolean = hasVisitedScene(scene.id)

    // == Scene stack == //

    private fun activateScene(scene: VirtualNovelScene) {
        seenScenes.add(scene.id)
        saveSeenScenes()

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

        stack.add(scene)
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

        stack.add(scene)
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

    // == Saving == //
    override fun write(buffer: BufferedSink) {
        val scenes = stack.map { it.id }
        buffer.writeInt(scenes.size)
        for (scene in scenes) {
            val encoded = scene.encodeUtf8()
            val size = encoded.size
            buffer.writeInt(size)
            buffer.write(encoded)
        }
    }

    override fun read(buffer: BufferedSource) {
        val sceneCount = buffer.readInt()
        for (idx in 0 until sceneCount) {
            val size = buffer.readInt()
            val sceneId = buffer.readUtf8(size.toLong())
            pushScene(sceneId)
        }
    }

    // == Debug == //
    public fun writeAllSceneData() {
        val file = Path.of("./scenes.txt")
        Files.newBufferedWriter(file, Charsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE).use {
            it.write("=== DEBUG SCENE OUTPUT ===\n\n")

            for (entry in registeredScenes) {
                //it.write("== SCENE ==\n")
                val name = entry.key
                val scene = entry.value.definition
                scene.loadThisFrame()

                //it.write("ID: ${scene.id}\n")
                //it.write("Page count: ${scene.pageCount}\n\n")
                for (page in 0 until scene.pageCount) {
                    //it.write("= PAGE $page =\n")
                    val tokens = scene.getTokensForPage(page)
                    for (token in tokens) {
                        it.write(token.repr())
                        if (!token.causesNewline && token.causesSpace) it.write(" ")
                    }
                    //it.write("= END PAGE $page=\n\n")
                }
                //it.write("== END SCENE ==\n\n")
            }
        }

    }

    // == Input == //

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