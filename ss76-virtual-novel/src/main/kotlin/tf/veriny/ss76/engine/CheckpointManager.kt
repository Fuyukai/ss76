package tf.veriny.ss76.engine

import dev.dirs.BaseDirectories
import okio.ByteString.Companion.encodeUtf8
import okio.buffer
import okio.sink
import okio.source
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.ButtonManager.Button
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
public class CheckpointManager(private val namespace: String) {
    public companion object {
        public val BASE_DIR: Path = Path.of(BaseDirectories.get().dataDir).resolve("ss76")
        private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")

        public const val CHECKPOINT_VERSION: Int = 1
    }

    /** The directory to use for saving. */
    private val saveDir = BASE_DIR.resolve(namespace).also { it.createDirectories() }

    /** The menu for checkpoints. */
    private val checkpointScene = UpdatableSceneWrapper("save-menu")

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

                checkpointScene.addButton(Button("load-$idx") { loadCheckpoint(idx) })
                checkpointScene.addButton(Button("save-$idx") { saveCheckpoint(idx) })
            }

            newline()
            backButton()
        }

        checkpointScene.register()
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

            // top colours
            sink.writeInt(SS76.clearScreenColor.r.toRawBits())
            sink.writeInt(SS76.clearScreenColor.g.toRawBits())
            sink.writeInt(SS76.clearScreenColor.b.toRawBits())
            sink.writeInt(SS76.clearScreenColor.a.toRawBits())

            // top text
            val topText = SS76.topText.encodeUtf8()
            sink.writeInt(topText.size)
            sink.write(topText)

            // write scenes
            SS76.sceneManager.write(sink)
            // write record
            SS76.record.write(sink)

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

            SS76.clearScreenColor.r = Float.fromBits(source.readInt())
            SS76.clearScreenColor.g = Float.fromBits(source.readInt())
            SS76.clearScreenColor.b = Float.fromBits(source.readInt())
            SS76.clearScreenColor.a = Float.fromBits(source.readInt())

            // load top text
            val ttSize = source.readInt()
            val topText = source.readUtf8(ttSize.toLong())
            SS76.setTopText(topText)

            SS76.sceneManager.read(source)
            SS76.record.read(source)
        }

        // pop the checkpoint scene off
        if (SS76.sceneManager.currentScene.id == "save-menu") {
            SS76.sceneManager.exitScene()
        }
    }
}