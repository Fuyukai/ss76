package tf.veriny.ss76.engine

import dev.dirs.BaseDirectories
import okio.buffer
import okio.sink
import okio.source
import tf.veriny.ss76.SS76
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption.CREATE
import java.nio.file.StandardOpenOption.TRUNCATE_EXISTING
import java.nio.file.attribute.FileTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.io.path.createDirectories
import kotlin.io.path.getLastModifiedTime

/**
 * Responsible for saving checkpoints.
 */
public class CheckpointManager(
    private val namespace: String,
    private val sceneManager: SceneManager,
) {
    public companion object {
        public val BASE_DIR: Path
        init {
            val bb = BaseDirectories.get().dataDir
            BASE_DIR = if (bb == null) {
                // windows shit...
                val dir = Path.of(System.getenv("APPDATA"))
                dir.resolve("ss76")
            } else {
                Path.of(bb).resolve("ss76")
            }
        }

        private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")

        public const val CHECKPOINT_VERSION: Int = 1
    }

    /** The directory to use for saving. */
    private val saveDir = BASE_DIR.resolve(namespace).also { it.createDirectories() }

    /** The menu for checkpoints. */
    private val checkpointScene = UpdatableSceneWrapper("save-menu")

    private inner class CheckpointButton(val idx: Int, val load: Boolean) : Button {
        override val name: String = if (load) "load-$idx" else "save-$idx"

        override fun run() {
            if (load) loadCheckpoint(idx)
            else saveCheckpoint(idx)
        }
    }

    public fun register() {
        updateCheckpointScene()
    }

    private fun getCheckpointDate(number: Int): FileTime? {
        val file = saveDir.resolve("checkpoint.$number.dat")
        return try {
            file.getLastModifiedTime()
        } catch (e: IOException) {
            null
        }
    }

    private fun updateCheckpointScene() {
        checkpointScene.reset()
        checkpointScene.edit(0) {
            line("@slate@Checkpoint @slate@Menu")
            newline()

            line(
                "A checkpoint saves the current state of your reading on a particular route. " +
                "When loading a checkpoint, the current scene and scene stack are restored. " +
                "Thus, you can save anywhere, no matter how deep."
            )
            newline()

            for (idx in 0 until 5) {
                val time = getCheckpointDate(idx)
                if (time == null) {
                    line("Slot #$idx - @green@empty - @salmon@`save-$idx`SAVE")
                } else {
                    val zone = ZoneId.systemDefault()
                    val it = time.toInstant().atZone(zone)
                    val ts = it.format(formatter)

                    line("Slot #$idx - :push:@sky@ $ts :pop: - @salmon@`load-$idx`LOAD / @salmon@`save-$idx`SAVE")
                }

                checkpointScene.addButton(CheckpointButton(idx, true))
                checkpointScene.addButton(CheckpointButton(idx, false))
            }

            newline()
            backButton()
        }

        checkpointScene.register(sceneManager)
    }

    /**
     * Writes the checkpoint with the specified ID.
     */
    public fun saveCheckpoint(idx: Int) {
        val file = saveDir.resolve("checkpoint.$idx.dat")
        Files.newOutputStream(file, CREATE, TRUNCATE_EXISTING).use {
            val sink = it.sink().buffer()

            // magic number
            sink.writeUtf8("SS76")
            // version
            sink.writeInt(CHECKPOINT_VERSION)

            // write scene stack
            SS76.sceneManager.write(sink)

            sink.flush()
            sink.close()
        }

        updateCheckpointScene()
    }

    /**
     * Saves the checkpoint with the specified ID.
     */
    public fun loadCheckpoint(idx: Int) {
        val file = saveDir.resolve("checkpoint.$idx.dat")
        Files.newInputStream(file).use {
            val source = it.source().buffer()

            check(source.readUtf8(4L) == "SS76") { "checkpoint file missing magic" }
            val version = source.readInt()
            check(version == CHECKPOINT_VERSION) { "invalid checkpoint version $version" }

            SS76.sceneManager.read(source)
        }

        // pop the checkpoint scene off
        if (SS76.sceneManager.currentSceneIs("save-menu")) {
            SS76.sceneManager.exitScene()
        }
    }
}