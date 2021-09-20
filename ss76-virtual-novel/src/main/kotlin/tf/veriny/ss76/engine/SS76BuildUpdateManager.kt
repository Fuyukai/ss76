@file:Suppress("UnnecessaryVariable")

package tf.veriny.ss76.engine

import okio.buffer
import okio.sink
import okio.source
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.NVLRenderer
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
        private const val MESSAGE = "7FELFThis program cannot be run in DOS Mode"
    }

    /** The bundle version that was loaded. */
    public var loadedBundleVersion: Int = -1
        private set

    /**
     * Loads the scenes from the current working directory.
     *
     * Returns true if the scenes were successfully loaded.
     */
    public fun loadScenes(always: Boolean = false): Boolean {
        val path = Path.of("./scenes-data.dat")
        if (!path.exists()) return false

        path.inputStream().use {
            val rawSource = it.source()
            val rawBuffer = rawSource.buffer()

            val message = rawBuffer.readUtf8(MESSAGE.length.toLong())
            if (message != MESSAGE) {
                error("Missing magic number in data bundle")
            }

            val buffer = rawBuffer

            val version = buffer.readInt()
            if (!always && version <= SS76.LURA_VERSION) {
                println("Detected old/same scenes bundle: $version")
                return false
            }

            loadedBundleVersion = version

            val sceneCount = buffer.readInt()
            println("Loading $sceneCount scenes from scene bundle")

            for (scidx in 0 until sceneCount) {
                val def = buffer.readSceneDefinition()
                val scene = NVLRenderer(def)
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
            val rawSink = it.sink()
            val rawBuffer = rawSink.buffer()

            rawBuffer.writeUtf8(MESSAGE)
            rawBuffer.flush()

            val buffer = rawBuffer
            buffer.writeInt(SS76.LURA_VERSION)

            val scenes = mutableListOf<NVLRenderer>()
            for (scene in SS76.sceneManager.registeredScenes.values) {
                val def = scene.definition
                if (def.dynamic) {
                    println("skipping dynamic scene ${scene.id}")
                    continue
                }

                if (def.hasCustomOnLoad) {
                    println("skipping custom load scene ${scene.id}")
                    continue
                }

                val buttons = def.originalButtons.values.filter { b ->
                    b.buttonType == ButtonManager.ButtonType.OTHER && b.name != "back-button"
                }
                if (buttons.isNotEmpty()) {
                    println("skipping scene ${scene.id} due to extra buttons: $buttons")
                    continue
                }
                scenes.add(scene)
            }

            println("Saving ${scenes.size} scenes to the data bundle.")

            buffer.writeInt(scenes.size)
            for (scene in scenes) {
                buffer.writeSceneDefinition(scene.definition)
            }

            buffer.flush()
            rawSink.close()
        }
    }
}