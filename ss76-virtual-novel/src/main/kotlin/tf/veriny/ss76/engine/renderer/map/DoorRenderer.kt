package tf.veriny.ss76.engine.renderer.map

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import tf.veriny.ss76.engine.renderer.TileMapADVRenderer
import tf.veriny.ss76.engine.scene.SceneState

public class DoorRenderer : TileMapADVRenderer("gfx/map/su6j-door.tmx") {
    private lateinit var letterAtlas: TextureAtlas

    override fun create() {
        super.create()
        letterAtlas = TextureAtlas(Gdx.files.internal("gfx/letters.atlas"))
    }

    override fun dispose() {
        super.dispose()
        letterAtlas.dispose()
    }


    override fun renderOverMap(batch: SpriteBatch, camera: OrthographicCamera, sceneState: SceneState) {

    }


}