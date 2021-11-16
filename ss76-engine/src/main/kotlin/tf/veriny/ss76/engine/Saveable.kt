package tf.veriny.ss76.engine

import okio.BufferedSink
import okio.BufferedSource

/**
 * Defines something that is saved to a checkpoint file.
 */
public interface Saveable {
    /**
     * Writes the data for this Saveable to the buffer.
     */
    public fun write(buffer: BufferedSink)

    /**
     * Reads the data for this Saveable from the buffer.
     */
    public fun read(buffer: BufferedSource)
}