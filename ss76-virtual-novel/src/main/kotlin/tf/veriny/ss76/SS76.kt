package tf.veriny.ss76

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxApplicationAdapter
import ktx.app.KtxInputAdapter
import ktx.app.clearScreen
import ktx.freetype.generateFont
import tf.veriny.ss76.engine.*
import tf.veriny.ss76.render.OddCareRenderer
import tf.veriny.ss76.vn.CommonScenes
import tf.veriny.ss76.vn.demo.registerDemoNavigationScenes
import tf.veriny.ss76.vn.demo.registerDemoUIScene
import tf.veriny.ss76.vn.registerMiscScenes
import tf.veriny.ss76.vn.side.registerSideLostInTheForest
import tf.veriny.ss76.vn.side.registerSidePlotAlexRadio
import tf.veriny.ss76.vn.sussex.*
import tf.veriny.ss76.vn.system.registerSystemScenes
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

    private lateinit var SS76_FONT: BitmapFont

    // == Rendering == //
    public lateinit var batch: SpriteBatch
        private set

    public lateinit var shapeRenderer: ShapeRenderer
        private set

    public var clearScreenColor: Color = Color.BLUE

    // == Error handling == //
    private lateinit var errorFont: BitmapFont
    private var lastError: Exception? = null

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

    // == Top text == //
    public var topText: String = "SIGNALLING SYSTEM 76"
        private set
    private var topWidth: Float = 0f

    private fun recalcTopText() {
        topWidth = GlyphLayout(SS76_FONT, topText).width
    }

    @OptIn(ExperimentalTime::class)
    override fun create() {
        val topGenerator = FreeTypeFontGenerator(Gdx.files.internal("fonts/Mx437_Wang_Pro_Mono.ttf"))
        SS76_FONT = topGenerator.generateFont {
            size = if (isBabyScreen) {
                32
            } else {
                48
            }
            mono = true
            color = Color.SALMON
        }
        recalcTopText()
        errorFont = topGenerator.generateFont {
            size = 24
            mono = true
            color = Color.WHITE
        }
        topGenerator.dispose()

        batch = SpriteBatch()

        shapeRenderer = ShapeRenderer()
        shapeRenderer.projectionMatrix = batch.projectionMatrix
        shapeRenderer.transformMatrix = batch.transformMatrix
        shapeRenderer.updateMatrices()

        fontManager.loadAllFonts()
        fontManager.changeFont("Mx437_PhoenixEGA_8x8-2y")

        sceneManager.loadSeenScenes()
        checkpointManager.register()

        demoRenderer = OddCareRenderer()
        //buttonRenderer = ButtonRenderer()

        Gdx.input.inputProcessor = input
        input.addProcessor(buttonManager)
        input.addProcessor(sceneManager)
        //input.addProcessor(buttonRenderer.input)

        val alwaysLoad = System.getProperty("always-load-scenes", "false").toBooleanStrict()

        val registerTime = measureTime {
            try {
                // == DEMO == //
                registerDemoUIScene()
                registerDemoNavigationScenes()

                // == META == //
                //registerMainMenuScenes()
                registerMiscScenes()

                // == SUSSEX ROUTE == //
                registerSussexJuly3Scenes()
                registerSussexJuly4Scenes()
                //registerJuly4SussexPt2Scenes()
                registerSussexJuly5Scenes()
                registerSussexJuly5Pt2Scenes()
                registerSussexJuly6Scenes()

                // == SIDE PLOTS == //
                registerSidePlotAlexRadio()
                registerSideLostInTheForest()

                // == TRUTH ENDING == //
                registerTruthDayOneScenes()

                CommonScenes.register()

                // Load newer scene versions if needed
                if (alwaysLoad) {
                    sceneSaver.loadScenes(always = true)
                } else {
                    if (!isInsideJar()) {
                        sceneSaver.saveScenes()
                    } else {
                        val loaded = sceneSaver.loadScenes()
                        if (!loaded) {
                            println("Didn't load from scene bundle; using pre-packaged scenes instead.")
                        }
                    }
                }

            } catch (e: Exception) {
                if (!isInsideJar()) throw e
                lastError = e
            }
        }

        // debug
        if (!isInsideJar()) {
            sceneManager.writeAllSceneData()
            val printSceneCounts = System.getProperty("print-scene-counts", "false").toBooleanStrict()
            if (printSceneCounts) {
                val routes = listOf("sussex", "suffolk", /*"kent"*/)
                for (r in routes) {
                    for (day in 3..18) {
                        val count = sceneManager.registeredScenes.keys.count {
                            it.startsWith("$r-july-$day") ||
                            it.startsWith("${r.slice(0..2)}${day}j-")
                        }

                        // suck my dick deprecations
                        println("${r.capitalize()} ${day.toString().padStart(2, '0')}/07: $count scenes")
                    }
                }
            }
        }

        println("Registered ${sceneManager.sceneCount} scenes in $registerTime.")

        // unused
        //registerMiscScenes()
        if (lastError == null) {
            val sceneName = if (IS_DEMO) {
                "demo-meta-menu"
            } else {
                System.getProperty("scene", "main-menu")
            }


            registerSystemScenes(sceneName)
            sceneManager.pushScene("system-startup-scene")
        }
    }

    private fun drawTopMessage() {
        val yOffset = Gdx.graphics.height - 10f
        SS76_FONT.draw(batch, topText, (Gdx.graphics.width / 2) - topWidth / 2, yOffset)
    }

    override fun render() {
        if (lastError == null) {
            renderNormally()
        } else {
            renderError()
        }
    }

    /**
     * Draws the error box.
     */
    private fun renderError() {
        Gdx.input.inputProcessor = null
        clearScreen(255f, 0f, 0f, 0f)

        val tb = lastError!!.stackTraceToString()
        batch.use {
            val message = if (sceneManager.stackSize == 0) {
                "Fatal error when loading engine!"
            } else {
                "Fatal error when rendering scene ${sceneManager.currentScene.id}"
            }

            errorFont.draw(
                this, message,
                1f,
                Gdx.graphics.height - 10f
            )

            errorFont.draw(this, tb, 1f, Gdx.graphics.height - 30f)
        }
    }


    private fun renderNormally() {
        clearScreen(clearScreenColor.r, clearScreenColor.g, clearScreenColor.b, clearScreenColor.a)

        val scene = sceneManager.currentScene

        try {
            scene.render()
        } catch (e: Exception) {
            lastError = e
            return renderError()
        }

        batch.use {
            if (scene.renderExtras) {
                drawTopMessage()

                if (IS_DEBUG) {
                    if (isBabyScreen) {
                        fontManager.currentFont.white.draw(batch,
                            "Scene ID: ${sceneManager.currentScene.id}",
                            15f,
                            20f
                        )
                    } else {
                        fontManager.currentFont.white.draw(batch,
                            "Scene ID: ${sceneManager.currentScene.id}",
                            15f,
                            50f
                        )
                    }
                }
            }

            if (IS_DEMO) {
                demoRenderer.render()
            }
        }

        //WHITE_FONT.draw(batch, "counter: $counter", 120f, 960 - 100f)
        //WHITE_FONT.draw(batch, items.toString(), 120f, 960 - 200f)
        //WHITE_FONT.draw(batch, "|", 1280 - 120f, 960 - 200f)

    }

    // == Helper global functions == //

    /**
     * Sets the top text.
     */
    public fun setTopText(topText: String) {
        this.topText = topText
        recalcTopText()
    }
}