package tf.veriny.ss76

/*import tf.veriny.ss76.scene.registerDemoNavigationScenes
import tf.veriny.ss76.scene.registerDemoUIScene
import tf.veriny.ss76.scene.text.TextualNode
import tf.veriny.ss76.scene.text.createAndRegisterScene
import tf.veriny.ss76.vn.demo.registerButtonDemos
import tf.veriny.ss76.vn.registerJokeScenes
import tf.veriny.ss76.vn.registerMainMenuScenes
import tf.veriny.ss76.vn.registerMiscScenes
import tf.veriny.ss76.vn.side.registerSidePlotAlexRadio
import tf.veriny.ss76.vn.sussex.registerSussexJuly3Scenes
import tf.veriny.ss76.vn.sussex.registerSussexJuly4Scenes*/
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
import tf.veriny.ss76.vn.demo.registerDemoNavigationScenes
import tf.veriny.ss76.vn.demo.registerDemoUIScene
import tf.veriny.ss76.vn.side.registerSidePlotAlexRadio
import tf.veriny.ss76.vn.sussex.registerSussexJuly3Scenes
import tf.veriny.ss76.vn.sussex.registerSussexJuly4Scenes
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * Main game object. Global!
 */
@Suppress("GDXKotlinStaticResource", "NAME_SHADOWING")  // don't care, these will never be disposed
public object SS76 : KtxApplicationAdapter {
    private class GeneratedFonts(
        val name: String,
        val white: BitmapFont, val green: BitmapFont, val red: BitmapFont, val orange: BitmapFont
    )

    private const val LURA_DEMO_BUILD = false
    public const val LURA_VERSION: String = "0.7"

    public val IS_DEMO: Boolean =
        LURA_DEMO_BUILD || System.getProperty("demo", "false").toBooleanStrict()


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
    public val checkpointManager: CheckpointManager = CheckpointManager("signalling-system-76")
    public val record: Record = Record()
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
            size = 20
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

        val registerTime = measureTime {
            try {
                // == DEMO == //
                registerDemoUIScene()
                registerDemoNavigationScenes()

                // == META == //
                //registerMainMenuScenes()
                //registerButtonDemos()

                // == SUSSEX ROUTE == //
                registerSussexJuly3Scenes()
                registerSussexJuly4Scenes()

                registerSidePlotAlexRadio()
            } catch (e: Exception) {
                lastError = e
            }
        }

        // debug
        // sceneManager.writeAllSceneData()

        println("Registered ${sceneManager.sceneCount} scenes in $registerTime.")

        // unused
        //registerMiscScenes()

        if (IS_DEMO) {
            sceneManager.pushScene("demo-meta-menu")
        } else {
            val scene = System.getProperty("scene", "main-menu")
            sceneManager.pushScene(scene)
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
            errorFont.draw(
                this, "Fatal error when rendering scene ${sceneManager.currentScene.id}",
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
            drawTopMessage()

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

            demoRenderer.render()
            //buttonRenderer.render()
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