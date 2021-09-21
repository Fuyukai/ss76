@file:Suppress("UnnecessaryVariable")

package tf.veriny.ss76.engine

import okio.buffer
import okio.sink
import okio.source
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.renderer.NVLRenderer
import java.nio.file.Path
import java.nio.file.StandardOpenOption.CREATE
import java.nio.file.StandardOpenOption.TRUNCATE_EXISTING
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream
import kotlin.io.path.exists
import kotlin.io.path.inputStream
import kotlin.io.path.outputStream

/**
 * Handles saving and loading content scenes.
 */
public class SS76BuildUpdateManager {
    public companion object {
        private const val MESSAGE = "This GZIP data cannot be run in DOS mode."
    }

    public enum class LoadStatus {
        NONEXISTENT,
        BAD_MAGIC,
        BAD_NUMBER,
        SUCCESS,
    }

    /** The bundle version that was loaded. */
    public var loadedBundleVersion: Int = -1
        private set

    /**
     * Loads the scenes from the current working directory.
     *
     * Returns true if the scenes were successfully loaded.
     */
    public fun loadScenes(always: Boolean = false): LoadStatus {
        return LoadStatus.BAD_MAGIC

        /*val path = Path.of("./scenes-data.dat")
        if (!path.exists()) return LoadStatus.NONEXISTENT

        path.inputStream().use {
            val magic = it.readNBytes(MESSAGE.length)
            if (!magic.contentEquals(MESSAGE.encodeToByteArray())) {
                return LoadStatus.BAD_MAGIC
            }

            val realStream = GZIPInputStream(it)

            val rawSource = realStream.source()
            val buffer = rawSource.buffer()

            val version = buffer.readInt()
            loadedBundleVersion = version

            if (!always && version <= SS76.LURA_VERSION) {
                println("Detected old/same scenes bundle: $version")
                return LoadStatus.BAD_NUMBER
            }

            val sceneCount = buffer.readInt()
            println("Loading $sceneCount scenes from scene bundle")

            for (scidx in 0 until sceneCount) {
                val def = buffer.readSceneDefinition()
                val scene = NVLRenderer(def)
                SS76.sceneManager.reregisterScene(scene)
            }
        }

        return LoadStatus.SUCCESS*/
    }

    /**
     * Saves scenes to disk.
     */
    public fun saveScenes() {
        /*val path = Path.of("./scenes-data.dat")

        path.outputStream(CREATE, TRUNCATE_EXISTING).use {
            val ba = MESSAGE.encodeToByteArray()
            it.write(ba)

            val realStream = GZIPOutputStream(it)

            val rawSink = realStream.sink()
            val rawBuffer = rawSink.buffer()
            val buffer = rawBuffer
            buffer.writeInt(SS76.LURA_VERSION)

            val scenes = mutableListOf<NVLRenderer>()
            for (def in SS76.sceneManager.registeredScenes.values) {
                if (def.dynamic) {
                    println("skipping dynamic scene ${def.id}")
                    continue
                }

                if (def.hasCustomOnLoad) {
                    println("skipping custom load scene ${def.id}")
                    continue
                }

                val buttons = def.originalButtons.values.filter {
                    it !is
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
        }*/
    }
}