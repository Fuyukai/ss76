package tf.veriny.ss76.engine

import okio.buffer
import okio.sink
import okio.source
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.VirtualNovelScene
import java.nio.file.Path
import java.nio.file.StandardOpenOption.CREATE
import java.nio.file.StandardOpenOption.TRUNCATE_EXISTING
import kotlin.io.path.exists
import kotlin.io.path.inputStream
import kotlin.io.path.outputStream

/**
 * Handles saving and loading content scenes.
 */
public class SS76BuildUpdateManager {
    public companion object {
        /** The list of prefixes that designate a contentful scene. */
        public val CONTENTFUL_SCENES: List<String> = listOf(
            "sussex", "suffolk", "kent", "kent",
            "common", "truth", "reality", "side.",
        )

        private const val MESSAGE = "This program cannot be run in DOS mode"
    }

    /**
     * Loads the scenes from the current working directory.
     *
     * Returns true if the scenes were successfully loaded.
     */
    public fun loadScenes(): Boolean {
        val path = Path.of("./scenes-data.dat")
        if (!path.exists()) return false

        path.inputStream().use {
            val buffer = it.source().buffer()

            val message = buffer.readUtf8(MESSAGE.length.toLong())
            if (message != MESSAGE) {
                error("Missing magic number in data bundle")
            }

            val version = buffer.readInt()
            if (version <= SS76.LURA_VERSION) {
                println("Detected old/same scenes bundle: $version")
                return false
            }

            val sceneCount = buffer.readInt()
            println("Loading $sceneCount scenes from scene bundle")

            for (scidx in 0 until sceneCount) {
                val def = buffer.readSceneDefinition()
                val scene = VirtualNovelScene(def)
                SS76.sceneManager.reregisterScene(scene)
            }
        }

        return true
    }

    /**
     * Saves scenes to disk.
     */
    public fun saveScenes() {
        val path = Path.of("./scenes-data.dat")

        path.outputStream(CREATE, TRUNCATE_EXISTING).use {
            val buffer = it.sink().buffer()

            buffer.writeUtf8(MESSAGE)
            buffer.writeInt(SS76.LURA_VERSION)

            val scenes = SS76.sceneManager.registeredScenes.filter { e ->
                CONTENTFUL_SCENES.any { it -> e.key.startsWith(it) }
            }.filterNot { it.value.definition.hasCustomOnLoad }

            println("Saving ${scenes.size} scenes to the data bundle.")

            buffer.writeInt(scenes.size)
            for ((k, v) in scenes) {
                buffer.writeSceneDefinition(v.definition)
            }

            buffer.flush()
            buffer.close()
        }
    }
}