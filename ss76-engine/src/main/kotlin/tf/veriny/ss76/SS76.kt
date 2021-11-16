package tf.veriny.ss76

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxApplicationAdapter
import tf.veriny.ss76.engine.*
import tf.veriny.ss76.engine.nvl.NVLScreen
import tf.veriny.ss76.engine.renderer.OddCareRenderer
import tf.veriny.ss76.engine.screen.ErrorScreen
import tf.veriny.ss76.engine.system.registerSystemScenes
import kotlin.time.ExperimentalTime

/**
 * Main game object.
 */
@Suppress("GDXKotlinStaticResource", "NAME_SHADOWING")  // don't care, these will never be disposed
public class SS76(
    private val namespace: String,
    private val registrar: SceneRegistrar,
) : KtxApplicationAdapter {
    public companion object {
        private const val LURA_DEMO_BUILD = false
        // used for saving scene data
        public const val LURA_VERSION: Int = 9

        public val IS_DEMO: Boolean =
            LURA_DEMO_BUILD || System.getProperty("demo", "false").toBooleanStrict()

        public val IS_DEBUG: Boolean =
            System.getProperty("debug", "false").toBooleanStrict()

        /** If this is a smaller screen size. */
        public val isBabyScreen: Boolean by lazy {
            Gdx.graphics.height < 960
        }
    }

    private lateinit var state: EngineState

    /** The global monotonic timer. Never decrements. */
    public var globalTimer: Int = 0

    override fun create() {
        try {
            createImpl()
        } catch (e: Exception) {
            state.screenManager.changeScreen(ErrorScreen(state, e))
            return
        }
    }

    @OptIn(ExperimentalTime::class)
    private fun createImpl() {
        state = EngineState(namespace, registrar)
        state.created()

        Gdx.input.inputProcessor = state.input

        // debug
        if (!isInsideJar()) {
            state.sceneManager.writeAllSceneData()
            val printSceneCounts = System.getProperty("print-scene-counts", "false").toBooleanStrict()
            if (printSceneCounts) {
                val routes = listOf("su")
                for (r in routes) {
                    for (day in 3..18) {
                        val count = state.sceneManager.registeredScenes.keys.count {
                            it.startsWith("$r${day}j-")
                        }

                        // suck my dick deprecations
                        println("${r.capitalize()} ${day.toString().padStart(2, '0')}/07: $count scenes")
                    }
                }
            }
        }

    }

    override fun render() {
        state.render()
    }


}