@file:Suppress("SpellCheckingInspection")

package tf.veriny.ss76

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer


/**
 * Helper function to automatically begin and dispose a Batch.
 */
public inline fun <T : Batch, R> T.use(fn: T.() -> R): R {
    try {
        begin()
        return fn()
    } finally {
        end()
    }
}

/**
 * Helper function to automatically begin and dispose a ShapeRenderer.
 */
public inline fun <R> ShapeRenderer.use(type: ShapeRenderer.ShapeType, fn: ShapeRenderer.() -> R): R {
    try {
        begin(type)
        return fn()
    } finally {
        end()
    }
}

public fun Any?.ignore(): Unit = Unit



public fun isInsideJar(): Boolean {
    val uri = SS76::class.java.getResource("SS76.class")!!.toURI()
    return uri.scheme == "jar"
}

