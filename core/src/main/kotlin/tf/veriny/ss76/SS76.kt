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
import tf.veriny.ss76.render.OddCareRenderer
import tf.veriny.ss76.scene.Scene
import tf.veriny.ss76.scene.UnimplementedScene
import tf.veriny.ss76.scene.registerDemoNavigationScenes
import tf.veriny.ss76.scene.registerDemoUIScene
import tf.veriny.ss76.scene.text.createAndRegisterScene
import tf.veriny.ss76.vn.registerJokeScenes
import tf.veriny.ss76.vn.registerMainMenuScenes
import tf.veriny.ss76.vn.registerMiscScenes
import tf.veriny.ss76.vn.side.registerSidePlotAlexRadio
import tf.veriny.ss76.vn.sussex.registerSussexJuly3Scenes
import java.nio.file.Path
import kotlin.io.path.forEachDirectoryEntry

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
    public const val LURA_VERSION: String = "0.4"

    public val IS_DEMO: Boolean =
        LURA_DEMO_BUILD || System.getProperty("demo", "false").toBooleanStrict()


    /** If this is a smaller screen size. */
    public val isBabyScreen: Boolean by lazy {
        Gdx.graphics.height < 960
    }

    // == Links == //
    /** The set of links that have been previously visited. */
    public val visited: MutableSet<String> = mutableSetOf("SKIP")

    // == Fonts == //
    private const val FONT_SIZE_BIG = 32
    private const val FONT_SIZE_SMALL = 20

    private val FONT_SIZE: Int get() {
        return if (isBabyScreen) FONT_SIZE_SMALL else FONT_SIZE_BIG
    }

    private lateinit var SS76_FONT: BitmapFont

    private val generatedFonts: MutableList<GeneratedFonts> = mutableListOf()
    private var fontIdx = 0

    public val whiteFont: BitmapFont get() = generatedFonts[fontIdx].white
    public val greenFont: BitmapFont get() = generatedFonts[fontIdx].green
    public val redFont: BitmapFont get() = generatedFonts[fontIdx].red
    public val orangeFont: BitmapFont get() = generatedFonts[fontIdx].orange

    /** The width of a single space glyph. */
    public var spaceWidth: Float = 0f
        private set

    /** The height of a single line. */
    public var lineHeight: Float = 0f
        private set

    /**
     * Generates the fonts for a specific font name.
     */
    private fun generateFonts(name: String) {
        println("generating $name")
        val mainGenerator = FreeTypeFontGenerator(Gdx.files.internal(name))

        val white = mainGenerator.generateFont {
            size = FONT_SIZE
            mono = true
            color = Color.WHITE
        }

        // clickable (seen before)
        val green = mainGenerator.generateFont {
            size = FONT_SIZE
            mono = true
            color = Color.GREEN
        }
        // clickable (not seen before)
        val red = mainGenerator.generateFont {
            size = FONT_SIZE
            mono = true
            color = Color.RED
        }

        val orange = mainGenerator.generateFont {
            size = FONT_SIZE
            mono = true
            color = Color.SALMON
        }

        generatedFonts.add(GeneratedFonts(name, white, green, red, orange))
        mainGenerator.dispose()
    }

    private fun switchFont(idx: Int) {
        fontIdx = idx
        spaceWidth = GlyphLayout(whiteFont, " ").width
        lineHeight = whiteFont.lineHeight
    }

    private fun nextFont() {
        fontIdx = (++fontIdx).rem(generatedFonts.size)
    }

    // == Rendering == //
    public lateinit var batch: SpriteBatch
        private set

    public lateinit var shapeRenderer: ShapeRenderer
        private set

    // == Demo == //
    private lateinit var demoRenderer: OddCareRenderer

    // == Scene stuff == //
    internal var previousScene: Scene? = null

    /** The known scenes. */
    private val scenes = mutableMapOf<String, Scene>()

    /** The stack of scenes. */
    internal val sceneStack: ArrayDeque<Scene> = ArrayDeque<Scene>()

    // == Debug == //
    private lateinit var dataScene: Scene

    // == Input == //
    private val input = InputMultiplexer(object : KtxInputAdapter {
        override fun keyDown(keycode: Int): Boolean {
            // helper functionality that overrides all sub-screens.
            when (keycode) {
                Input.Keys.F1 -> {
                    pushScene(dataScene.id)
                }

                Input.Keys.F2 -> {
                    // push demo UI
                    if (IS_DEMO) {
                        repeat(sceneStack.size - 1) { exitScene() }
                        changeScene("demo-meta-menu")
                    }
                }
                Input.Keys.F3 -> {
                    nextFont()
                }
                else -> return super.keyDown(keycode)
            }

            return true
        }
    })

    // == Top text == //
    private var topText: String = "SIGNALLING SYSTEM 76"
    private var topWidth: Float = 0f

    private fun recalcTopText() {
        topWidth = GlyphLayout(SS76_FONT, topText).width
    }

    override fun create() {
        val topGenerator = FreeTypeFontGenerator(Gdx.files.internal("fonts/Mx437_Wang_Pro_Mono.ttf"))
        SS76_FONT = topGenerator.generateFont {
            size = if (isBabyScreen) {
                32
            } else {
                48
            }
            mono = true
            color = Color.CORAL
        }
        recalcTopText()
        topGenerator.dispose()

        val url = javaClass.getResource("/fonts")!!.toURI()
        val path = Path.of(url)
        path.forEachDirectoryEntry {
            // le libgdx
            generateFonts("fonts/${it.fileName}")
        }

        val idx = if (isBabyScreen) {
            generatedFonts.indexOfFirst { it.name == "fonts/Mx437_IBM_Model3x_Alt4.ttf" }
        } else {
            generatedFonts.indexOfFirst { it.name == "fonts/Mx437_PhoenixEGA_8x8-2y.ttf" }
        }
        switchFont(idx)

        batch = SpriteBatch()

        shapeRenderer = ShapeRenderer()
        shapeRenderer.projectionMatrix = batch.projectionMatrix
        shapeRenderer.transformMatrix = batch.transformMatrix
        shapeRenderer.updateMatrices()

        demoRenderer = OddCareRenderer()

        Gdx.input.inputProcessor = input

        registerJokeScenes()
        registerDemoUIScene()
        registerDemoNavigationScenes()
        registerMainMenuScenes()

        // == SUSSEX ROUTE == //
        registerSussexJuly3Scenes()
        registerSidePlotAlexRadio()

        // unused
        registerMiscScenes()

        dataScene = createAndRegisterScene("lura-engine-debug-scene") {
            page {
                line("Known scenes: ${scenes.size}")
                line("Known fonts: ${generatedFonts.size}")
                newline(5)

                line("Press F2 to reload main menu.")
                backButton("Go back to previous scene.")
            }
        }


        if (IS_DEMO) {
            pushScene("demo-meta-menu")
        } else {
            val scene = System.getProperty("scene", "main-menu")
            pushScene(scene)
        }
    }

    private fun drawTopMessage() {
        val yOffset = Gdx.graphics.height - 10f
        SS76_FONT.draw(batch, topText, (Gdx.graphics.width / 2) - topWidth / 2, yOffset)
    }

    override fun render() {
        super.render()

        clearScreen(0F, 0F, 255F)

        val scene = sceneStack.last()
        scene.draw()

        batch.use {
            demoRenderer.render()
            drawTopMessage()

            if (isBabyScreen) {
                whiteFont.draw(batch,
                    "Scene ID: ${sceneStack.last().id} / Font: ${generatedFonts[fontIdx].name}",
                    15f,
                    20f
                )
            } else {
                whiteFont.draw(batch,
                    "Scene ID: ${sceneStack.last().id} / Font: ${generatedFonts[fontIdx].name}",
                    15f,
                    50f
                )
            }
        }

        //WHITE_FONT.draw(batch, "counter: $counter", 120f, 960 - 100f)
        //WHITE_FONT.draw(batch, items.toString(), 120f, 960 - 200f)
        //WHITE_FONT.draw(batch, "|", 1280 - 120f, 960 - 200f)

    }

    // == Helper global functions == //
    private fun getScene(scene: String): Scene {
        return scenes[scene] ?: UnimplementedScene(scene)
    }

    private fun activateScene(scene: Scene) {
        scene.sceneActive()
        input.addProcessor(0, scene.input)
        visited.add(scene.id)
    }

    public fun registerScene(scene: Scene) {
        scenes[scene.id] = scene
    }

    /**
     * Sets the top text.
     */
    public fun setTopText(topText: String) {
        this.topText = topText
        recalcTopText()
    }

    /**
     * Pushes and activates a scene.
     */
    public fun pushScene(scene: Scene) {
        if (sceneStack.isNotEmpty()) {
            val tos = sceneStack.last()
            tos.sceneInactive()
            previousScene = tos
        }
        sceneStack.add(scene)
        activateScene(scene)
    }

    /**
     * Pushes and activates a scene, using its string id.
     */
    public fun pushScene(scene: String) {
        val scene = getScene(scene)
        pushScene(scene)
    }

    /**
     * Changes the top scene on the stack.
     */
    public fun changeScene(scene: Scene) {
        val tos = sceneStack.removeLast()
        tos.sceneInactive()
        previousScene = tos

        sceneStack.add(scene)
        activateScene(scene)
    }

    /**
     * Changes the top scene on the stack, using its ID.
     */
    public fun changeScene(scene: String) {
        val scene = getScene(scene)
        changeScene(scene)
    }

    /**
     * Exits from the top scene.
     */
    public fun exitScene() {
        val tos = sceneStack.removeLast()
        tos.sceneInactive()
        previousScene = tos

        val newTos = sceneStack.last()
        activateScene(newTos)
    }

    /**
     * Draws white text.
     */
    public fun drawWhiteText(toDraw: CharSequence, x: Float, y: Float) {
        whiteFont.draw(batch, toDraw, x, y)
    }
}