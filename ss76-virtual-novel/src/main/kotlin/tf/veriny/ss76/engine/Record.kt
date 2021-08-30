package tf.veriny.ss76.engine

import okio.BufferedSink
import okio.BufferedSource
import tf.veriny.ss76.engine.scene.PageBuilder

/**
 * The record is a button at the bottom used to store important information.
 */
public class Record : UpdatableSceneWrapper("record") {
    public var updated: Boolean = false
        private set

    /** Mark the record as opened. */
    public fun markOpened() { updated = false }

    public override fun edit(page: Int, block: PageBuilder.() -> Unit) {
        super.edit(page, block)
        updated = true
    }

    init {
        super.edit(0) {
            line("You think you're a @pink@funny @pink@guy, don't you?")
            newline()

            line("Opening this before it should be used. That's ¬shake¬rude.")
            newline()

            line(
                "Here's a hint: the button will flash between @green@green and @red@red " +
                "when there's anything interesting here."
            )
        }


    }

    override fun write(buffer: BufferedSink) {
        super.write(buffer)
        buffer.writeInt(if (updated) 1 else (0))
    }

    override fun read(buffer: BufferedSource) {
        super.read(buffer)

        val i = buffer.readInt()
        updated = i == 1
    }
}