package tf.veriny.ss76

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxApplicationAdapter
import ktx.app.KtxInputAdapter
import tf.veriny.ss76.engine.*
import tf.veriny.ss76.engine.renderer.OddCareRenderer
import tf.veriny.ss76.engine.screen.ErrorScreen
import tf.veriny.ss76.engine.nvl.NVLScreen
import tf.veriny.ss76.engine.screen.Screen
import tf.veriny.ss76.vn.CommonScenes
import tf.veriny.ss76.vn.demo.registerDemoNavigationScenes
import tf.veriny.ss76.vn.demo.registerDemoUIScene
import tf.veriny.ss76.vn.norfolk.registerNorfolkJuly3Scenes
import tf.veriny.ss76.vn.registerMainMenuScenes
import tf.veriny.ss76.vn.registerMiscScenes
import tf.veriny.ss76.vn.side.registerSideLostInTheForest
import tf.veriny.ss76.vn.side.registerSidePlotAlexRadio
import tf.veriny.ss76.vn.sussex.*
import tf.veriny.ss76.engine.system.registerSystemScenes
import tf.veriny.ss76.vn.truth.registerTruthDayOneScenes
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

    // == Demo == //
    private lateinit var demoRenderer: OddCareRenderer

    // == Scene stuff == //
    public val sceneManager: SceneManager = SceneManager("signalling-system-76")
    public val checkpointManager: CheckpointManager = CheckpointManager("signalling-system-76", sceneManager)
    public val buttonManager: ButtonManager = ButtonManager()
    private val sceneSaver = SS76BuildUpdateManager()

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
                    fontManager.nextFont()
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

        val sceneName = if (IS_DEMO) {
            "demo-meta-menu"
        } else {
            System.getProperty("scene", "main-menu")
        }

        registerSystemScenes(sceneName)
        changeScreen(NVLScreen)

        sceneManager.pushScene("system-startup-scene")
    }

    @OptIn(ExperimentalTime::class)
    private fun createImpl() {
        val fontGenTime = measureTime {
            fontManager.loadAllFonts()
            fontManager.changeFont("Mx437_PhoenixEGA_8x8-2y")
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

            // == SUSSEX ROUTE == //
            registerSussexJuly3Scenes()
            registerSussexJuly4Scenes()
            //registerJuly4SussexPt2Scenes()
            registerSussexJuly5Scenes()
            registerSussexJuly5Pt2Scenes()
            registerSussexJuly6Scenes()

            // == NORFOLK ROUTES == //
            registerNorfolkJuly3Scenes()

            // == SIDE PLOTS == //
            registerSidePlotAlexRadio()
            registerSideLostInTheForest()

            // == TRUTH ENDING == //
            registerTruthDayOneScenes()

            CommonScenes.register()

            // Load newer scene versions if needed
            if (alwaysLoad) {
                val loaded = sceneSaver.loadScenes(always = true)
                if (loaded != SS76BuildUpdateManager.LoadStatus.SUCCESS) {
                    println("Didn't load from scene bundle ($loaded); using pre-packaged scenes instead.")
                } else {
                    println("Loaded scenes from scene bundle.")
                }
            } else {
                if (!isInsideJar()) {
                    sceneSaver.saveScenes()
                } else {
                    val loaded = sceneSaver.loadScenes()
                    if (loaded != SS76BuildUpdateManager.LoadStatus.SUCCESS) {
                        println("Didn't load from scene bundle; using pre-packaged scenes instead.")
                    } else {
                        println("Loaded scenes from scene bundle.")
                    }
                }
            }
        }

        // debug
        if (!isInsideJar()) {
            sceneManager.writeAllSceneData()
            val printSceneCounts = System.getProperty("print-scene-counts", "false").toBooleanStrict()
            if (printSceneCounts) {
                val routes = listOf("sussex", "norfolk", /*"kent"*/)
                for (r in routes) {
                    for (day in 3..18) {
                        println("${r.slice(0..1)}${day}j-")
                        val count = sceneManager.registeredScenes.keys.count {
                            it.startsWith("$r-july-$day") ||
                            it.startsWith("${r.slice(0..1)}${day}j-")
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

        if (debugTitle) {
            if (titleTimer <= 0) {
                titleTimer = 60
                Gdx.graphics.setTitle("SIGNALLING SYSTEM 76")
            } else {
                titleTimer--
            }
        }
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
        }

        this.screen = screen
        input.addProcessor(this.screen)
    }
}