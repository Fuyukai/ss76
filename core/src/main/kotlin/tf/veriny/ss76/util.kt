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

// https://stackoverflow.com/a/4011232/15026456
public fun getDayOfMonthSuffix(n: Int): String? {
    return if (n in 11..13) {
        "th"
    } else when (n.rem(10)) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
}