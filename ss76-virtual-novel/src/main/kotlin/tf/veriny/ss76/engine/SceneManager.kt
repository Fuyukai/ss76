package tf.veriny.ss76.engine

import com.badlogic.gdx.Input
import ktx.app.KtxInputAdapter
import okio.BufferedSink
import okio.BufferedSource
import okio.ByteString.Companion.encodeUtf8
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.Inventory
import tf.veriny.ss76.engine.renderer.NVLRenderer
import tf.veriny.ss76.engine.scene.SceneDefinition
import tf.veriny.ss76.engine.scene.SceneState
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption.*

/**
 * Responsible for handling loaded scenes.
 */
public class SceneManager(public val namespace: String) : KtxInputAdapter, Saveable {
    private companion object {
        val CONTENT_PREFIXES = listOf(
            "sussex", "suffolk", "kent", "common", "truth", "reality",
            "side."
        )
    }

    private val seenScenes /*on the sea shore*/= mutableSetOf<String>()
    public val registeredScenes: MutableMap<String, SceneDefinition> = mutableMapOf()
    public val sceneCount: Int get() = registeredScenes.size

    // stack of renderers, *not* definitions.
    private val stack = ArrayDeque<SceneState>()
    public val stackSize: Int get() = stack.size
    // current *renderer*, not definitions.
    public val currentScene: SceneState get() = stack.last()

    private var previousScene: SceneDefinition? = null

    /** The inventory system instance. */
    public val inventory: Inventory = Inventory(this)

    init {
        inventory.changeState(0)
    }

    public fun currentSceneIs(id: String): Boolean = currentScene.definition.id == id

    /**
     * Registers a single scene.
     */
    public fun registerScene(scene: SceneDefinition) {
        registeredScenes[scene.id] = scene
    }

    /**
     * Re-registers a scene. This will update any references in the current stack of scenes.
     */
    public fun reregisterScene(scene: SceneDefinition) {
        val old = registeredScenes[scene.id]
        registeredScenes[scene.id] = scene

        if (old == null) return
        if (stack.isEmpty()) return

        when {
            // TOS requires unloading the old scene and replacing it with the new one
            currentScene.definition == old -> {
                stack.removeLast()
                val state = SceneState(scene)
                activateScene(state)
            }
            // just swap the references to the old scenes with the new one
            previousScene == old -> {
                previousScene = scene
            }
            else -> {
                for (idx in 0 until stackSize) {
                    if (stack[idx].definition == old) {
                        stack[idx] = SceneState(definition = scene)
                    }
                }
            }
        }
    }

    /**
     * Saves the previously seen scenes.
     */
    public fun saveSeenScenes() {
        val dataDir = CheckpointManager.BASE_DIR
        val saveDir = dataDir.resolve(namespace)
        Files.createDirectories(saveDir)

        val saveData = saveDir.resolve("seen.txt")
        val savedScenes = seenScenes.joinToString("\n")
        Files.writeString(saveData, savedScenes, CREATE, TRUNCATE_EXISTING)
    }

    /**
     * Loads the previous seen scenes.
     */
    public fun loadSeenScenes() {
        val dataDir = CheckpointManager.BASE_DIR
        val saveDir = dataDir.resolve(namespace)
        Files.createDirectories(saveDir)

        val saveData = saveDir.resolve("seen.txt")
        if (!Files.exists(saveData)) return
        val scenes = Files.readString(saveData).split("\n")
        seenScenes.addAll(scenes)
    }

    public fun hasVisitedScene(scene: String): Boolean {
        return seenScenes.contains(scene)
    }

    public fun hasVisitedScene(scene: SceneDefinition): Boolean = hasVisitedScene(scene.id)

    // == Scene stack == //

    private fun activateScene(scene: SceneState) {
        seenScenes.add(scene.definition.id)
        saveSeenScenes()

        if (scene.definition.linkedInventoryId > 0) {
            inventory.changeState(scene.definition.linkedInventoryId)
        }

        scene.definition.onLoadHandlers.forEach { it.invoke() }
    }

    /**
     * Pushes and activates a scene.
     */
    public fun pushScene(scene: SceneDefinition) {
        if (stack.isNotEmpty()) {
            val tos = stack.last()
            previousScene = tos.definition
        }

        val state = SceneState(scene)
        stack.add(state)
        activateScene(state)
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
    public fun changeScene(scene: SceneDefinition) {
        val tos = stack.removeLast()
        previousScene = tos.definition

        val state = SceneState(scene)
        stack.add(state)
        activateScene(state)
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
        previousScene = tos.definition

        val newTos = stack.last()
        activateScene(newTos)
    }

    /**
     * Gets a single scene.
     */
    public fun getScene(scene: String): SceneDefinition {
        return registeredScenes[scene] ?: error("missing scene definition: $scene")
    }

    // == Saving == //
    override fun write(buffer: BufferedSink) {
        val scenes = stack.map { it.definition.id }
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
        Files.newBufferedWriter(
            file, Charsets.UTF_8,
            CREATE, WRITE, TRUNCATE_EXISTING
        ).use {
            it.write("=== DEBUG SCENE OUTPUT ===\n\n")

            for (entry in registeredScenes) {
                if (!CONTENT_PREFIXES.any { i -> entry.key.startsWith(i) }) {
                    continue
                }

                //it.write("== SCENE ==\n")
                val name = entry.key
                val scene = entry.value

                //it.write("ID: ${scene.id}\n")
                //it.write("Page count: ${scene.pageCount}\n\n")
                for (page in 0 until scene.pageCount) {
                    //it.write("= PAGE $page =\n")
                    val tokens = scene.getTokensForPage(page)
                    for (token in tokens) {
                        it.write(token.repr())
                    }
                    //it.write("= END PAGE $page=\n\n")
                }
                //it.write("== END SCENE ==\n\n")
            }
        }

    }

    // == Input == //

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        currentScene.timer = 999999999
        return true
    }

    override fun keyDown(keycode: Int): Boolean {
        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.DPAD_LEFT) {
            currentScene.pageBack()
        } else if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.DPAD_RIGHT) {
            currentScene.pageNext()
        } else if (keycode == Input.Keys.SPACE) {
            currentScene.timer = 0
            return true
        } else if (keycode == Input.Keys.ENTER) {
            val buttons = SS76.buttonManager.buttonRects.keys.filterIsInstance<ChangeSceneButton>()

            if (buttons.isEmpty() || buttons.size > 1) return false

            val button = buttons.first()
            button.run()
        }

        return false
    }
}