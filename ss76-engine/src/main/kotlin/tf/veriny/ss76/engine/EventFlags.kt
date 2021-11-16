package tf.veriny.ss76.engine

import okio.BufferedSink
import okio.BufferedSource
import readPascalString
import tf.veriny.ss76.EngineState
import writePascalString

/**
 * Manages event flags. These are simple flags that can be set to true or false.
 */
public class EventFlags(private val state: EngineState) : Saveable {
    private val flags = mutableSetOf<String>()

    /**
     * Sets an event flag.
     */
    public fun set(flag: String) {
        flags.add(flag)
    }

    /**
     * Resets an event flag.
     */
    public fun reset(flag: String) {
        flags.remove(flag)
    }

    /**
     * Gets if an event flag is set.
     */
    public fun get(flag: String): Boolean = flag in flags

    override fun read(buffer: BufferedSource) {
        val count = buffer.readInt()
        for (i in 0 until count) {
            val flag = buffer.readPascalString()
            flags.add(flag)
        }
    }

    override fun write(buffer: BufferedSink) {
        buffer.writeInt(flags.size)
        for (flag in flags) {
            buffer.writePascalString(flag)
        }
    }
}