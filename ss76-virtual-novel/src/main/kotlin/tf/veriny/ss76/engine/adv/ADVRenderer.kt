package tf.veriny.ss76.engine.adv

import com.badlogic.gdx.graphics.OrthographicCamera
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.SceneState
import tf.veriny.ss76.use

/**
 * The renderer for ADV scenes.
 */
public class ADVRenderer(
    public val subRenderer: ADVSubRenderer
) {
    private val camera = OrthographicCamera(1280f, 960f).also {
        it.setToOrtho(false, 1280f, 960f)
        it.update()
    }


    /**
     * Renders
     */
    public fun render(sceneState: SceneState) {
        val batch = SS76.batch
        val oldProj = batch.projectionMatrix
        val oldTrans = batch.transformMatrix

        try {
            batch.projectionMatrix = camera.combined
            batch.use { subRenderer.render(batch, sceneState) }
        } finally {
            batch.projectionMatrix = oldProj
            batch.transformMatrix = oldTrans
        }
    }
}