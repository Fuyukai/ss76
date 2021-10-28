package tf.veriny.ss76

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxApplicationAdapter
import ktx.app.KtxInputAdapter
import tf.veriny.ss76.engine.ButtonManager
import tf.veriny.ss76.engine.CheckpointManager
import tf.veriny.ss76.engine.FontManager
import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.nvl.NVLScreen
import tf.veriny.ss76.engine.renderer.OddCareRenderer
import tf.veriny.ss76.engine.screen.ErrorScreen
import tf.veriny.ss76.engine.screen.Screen
import tf.veriny.ss76.engine.system.registerOSSCredits
import tf.veriny.ss76.engine.system.registerSystemScenes
import tf.veriny.ss76.vn.CommonScenes
import tf.veriny.ss76.vn.demo.registerDemoNavigationScenes
import tf.veriny.ss76.vn.demo.registerDemoUIScene
import tf.veriny.ss76.vn.registerMainMenuScenes
import tf.veriny.ss76.vn.registerMiscScenes
import tf.veriny.ss76.vn.side.registerSideLostInTheForest
import tf.veriny.ss76.vn.side.registerSidePlotAlexRadio
import tf.veriny.ss76.vn.sussex.registerSu3JScenes
import tf.veriny.ss76.vn.sussex.registerSu4JScenes
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * Main game object. Global!
 */
@Suppress("GDXKotlinStaticResource", "NAME_SHADOWING")  // don't care, these will never be disposed
public object SS76 : KtxApplicationAdapter {
    private const val LURA_DEMO_BUILD = false
    // used for saving scene data
    public const val LURA_VERSION: Int = 9

    public val IS_DEMO: Boolean =
        LURA_DEMO_BUILD || System.getProperty("demo", "false").toBooleanStrict()

    public val IS_DEBUG: Boolean = System.getProperty("debug", "false").toBooleanStrict()

    /** If this is a smaller screen size. */
    public val isBabyScreen: Boolean by lazy {
        Gdx.graphics.height < 960
    }

    // == Fonts == //
    public val fontManager: FontManager = FontManager()

    // == Rendering == //
    public lateinit var batch: SpriteBatch
        private set

    public lateinit var shapeRenderer: ShapeRenderer
        private set

    public lateinit var screen: Screen
        private set

    /** The global monotonic timer. Never decrements. */
    public var globalTimer: Int = 0

    // == Demo == //
    private lateinit var demoRenderer: OddCareRenderer

    // == Scene stuff == //
    public val sceneManager: SceneManager = SceneManager("signalling-system-76")
    public val checkpointManager: CheckpointManager = CheckpointManager("signalling-system-76", sceneManager)
    public val buttonManager: ButtonManager = ButtonManager()

    // == Input == //
    private val input = InputMultiplexer(object : KtxInputAdapter {
        override fun keyDown(keycode: Int): Boolean {
            // helper functionality that overrides all sub-screens.
            when (keycode) {
                Input.Keys.F1 -> {
                    //sceneManager.pushScene(dataScene.id)
                }

                Input.Keys.F2 -> {
                    // push demo UI
                    if (IS_DEMO) {
                        repeat(sceneManager.stackSize - 1) { sceneManager.exitScene() }
                        sceneManager.changeScene("demo-meta-menu")
                    }
                }
                Input.Keys.F3 -> {

                }
                else -> return super.keyDown(keycode)
            }

            return true
        }
    })

    override fun create() {
        batch = SpriteBatch()

        shapeRenderer = ShapeRenderer()
        shapeRenderer.projectionMatrix = batch.projectionMatrix
        shapeRenderer.transformMatrix = batch.transformMatrix
        shapeRenderer.updateMatrices()

        try {
            createImpl()
        } catch (e: Exception) {
            screen = ErrorScreen(e)
            return
        }

        /*val sceneName = if (IS_DEMO) {
            "demo-meta-menu"
        } else {
            System.getProperty("scene", "main-menu")
        }*/
        val sceneName = System.getProperty("scene", "main-menu")

        registerSystemScenes(sceneName)
        changeScreen(NVLScreen)

        sceneManager.pushScene("system-startup-scene")
    }

    @OptIn(ExperimentalTime::class)
    private fun createImpl() {
        val fontGenTime = measureTime {
            fontManager.loadAllFonts()
        }
        println("All fonts generated in $fontGenTime.")

        sceneManager.loadSeenScenes()
        checkpointManager.register()

        demoRenderer = OddCareRenderer()
        //buttonRenderer = ButtonRenderer()

        Gdx.input.inputProcessor = input
        input.addProcessor(buttonManager)
        //input.addProcessor(buttonRenderer.input)

        val alwaysLoad = System.getProperty("always-load-scenes", "false").toBooleanStrict()

        val registerTime = measureTime {
            // == DEMO == //
            registerDemoUIScene()
            registerDemoNavigationScenes()

            // == META == //
            registerMainMenuScenes()
            registerMiscScenes()
            registerOSSCredits()

            // == MAIN ROUTE == //
            registerSu3JScenes()
            registerSu4JScenes()

            CommonScenes.register()
        }

        // debug
        if (!isInsideJar()) {
            sceneManager.writeAllSceneData()
            val printSceneCounts = System.getProperty("print-scene-counts", "false").toBooleanStrict()
            if (printSceneCounts) {
                val routes = listOf("su")
                for (r in routes) {
                    for (day in 3..18) {
                        val count = sceneManager.registeredScenes.keys.count {
                            it.startsWith("$r${day}j-")
                        }

                        // suck my dick deprecations
                        println("${r.capitalize()} ${day.toString().padStart(2, '0')}/07: $count scenes")
                    }
                }
            }
        }

        println("Registered ${sceneManager.sceneCount} scenes in $registerTime.")

    }

    private val debugTitle = System.getProperty("update-window-title", "false").toBooleanStrict()
    private var titleTimer = 60

    override fun render() {
        screen.render(Gdx.graphics.deltaTime)
        if (IS_DEMO) {
            batch.use { demoRenderer.render() }
        }

        globalTimer++
    }

    override fun resize(width: Int, height: Int) {
        batch = SpriteBatch()
        shapeRenderer = ShapeRenderer()
        shapeRenderer.projectionMatrix = batch.projectionMatrix
        shapeRenderer.transformMatrix = batch.transformMatrix
        shapeRenderer.updateMatrices()
    }

    /**
     * Changes the current screen.
     */
    public fun changeScreen(screen: Screen) {
        if (this::screen.isInitialized) {
            val oldScreen = this.screen
            input.removeProcessor(oldScreen)
            oldScreen.dispose()
        }

        this.screen = screen
        input.addProcessor(this.screen)
    }
}