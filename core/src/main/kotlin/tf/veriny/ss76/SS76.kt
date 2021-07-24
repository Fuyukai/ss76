package tf.veriny.ss76

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxApplicationAdapter
import ktx.app.clearScreen
import ktx.freetype.generateFont
import tf.veriny.ss76.scene.Scene
import tf.veriny.ss76.vn.registerMainMenuScenes
import tf.veriny.ss76.vn.sussex.registerSussexJuly3Scenes

/**
 * Main game object. Global!
 */
@Suppress("GDXKotlinStaticResource", "NAME_SHADOWING")  // don't care, these will never be disposed
public object SS76 : KtxApplicationAdapter {
    private const val FONT = "fonts/Mx437_PhoenixEGA_8x8-2y.ttf"
    private const val FONT_SIZE = 32

    /*private val text = TextualNode.split("It is the 3rd of July. You are a 17 year old boy in Year 12. You have finished your last mock exams. You are predicted BCC in your A-levels." +
        "\n" +
        "The frequency is 4625 Hz.\n" +
        "\n" +
        "What do you want to do?\n" +
        "\n" +
        " * Start from the beginning.\n" +
        " * Load a save file.\n" +
        " * Check the credits.\n" +
        "\n" +
        "It is recommended that you read this VN on a hot summer day, in a dark room, under the cool air of your air conditioning or a fan on maximum setting, preferably on a laptop whilst tucked into bed and laying on your front.\n")



    private val text = TextualNode.split("Signaling System No. 7 (or Signalling System No. 7, SS7) is a set of telephony signaling protocols developed in 1975, which is used to set up and tear down telephone calls in most parts of the world-wide public switched telephone network (PSTN). The protocol also performs number translation, local number portability, prepaid billing, Short Message Service (SMS), and other services.\n" +
        "\n" +
        "In North America SS7 is often referred to as Common Channel Signaling System 7 (CCSS7). In the United Kingdom, it is called C7 (CCITT number 7), number 7 and Common Channel Interoffice Signaling 7 (CCIS7). In Germany, it is often called Zentraler Zeichengabekanal Nummer 7 (ZZK-7). ")

     */

    // == Links == //
    /** The set of links that have been previously visited. */
    public val visited: MutableSet<String> = mutableSetOf("SKIP")

    // == Fonts == //
    private lateinit var SS76_FONT: BitmapFont
    public lateinit var WHITE_FONT: BitmapFont
        private set
    public lateinit var GREEN_FONT: BitmapFont
        private set
    public lateinit var RED_FONT: BitmapFont
        private set
    public lateinit var ORANGE_FONT: BitmapFont
        private set
    public lateinit var batch: SpriteBatch
        private set

    /** The width of a single space glyph. */
    public var spaceWidth: Float = 0f
        private set

    /** The height of a single line. */
    public var lineHeight: Float = 0f
        private set


    // == Scene stuff == //
    /** The known scenes. */
    private val scenes = mutableMapOf<String, Scene>()

    /** The stack of scenes. */
    private val sceneStack: ArrayDeque<Scene> = ArrayDeque<Scene>()

    public lateinit var shapeRenderer: ShapeRenderer
        private set

    private val input = InputMultiplexer()

    // == Top text == //
    private var topText: String = "SIGNALLING SYSTEM 76"
    private var topWidth: Float = 0f

    private fun recalcTopText() {
        topWidth = GlyphLayout(SS76_FONT, topText).width
    }

    override fun create() {
        val generator = FreeTypeFontGenerator(Gdx.files.internal(FONT))
        SS76_FONT = generator.generateFont {
            size = 48
            mono = true
            color = Color.ORANGE
        }
        recalcTopText()

        WHITE_FONT = generator.generateFont {
            size = FONT_SIZE
            mono = true
            color = Color.WHITE
        }

        spaceWidth = GlyphLayout(WHITE_FONT, " ").width
        lineHeight = WHITE_FONT.lineHeight

        // clickable (seen before)
        GREEN_FONT = generator.generateFont {
            size = FONT_SIZE
            mono = true
            color = Color.GREEN
        }
        // clickable (not seen before)
        RED_FONT = generator.generateFont {
            size = FONT_SIZE
            mono = true
            color = Color.RED
        }

        ORANGE_FONT = generator.generateFont {
            size = FONT_SIZE
            mono = true
            color = Color.SALMON
        }

        generator.dispose()
        batch = SpriteBatch()
        shapeRenderer = ShapeRenderer()
        shapeRenderer.projectionMatrix = batch.projectionMatrix
        shapeRenderer.transformMatrix = batch.transformMatrix
        shapeRenderer.updateMatrices()

        Gdx.input.inputProcessor = input

        registerMainMenuScenes()

        // == SUSSEX ROUTE == //
        registerSussexJuly3Scenes()

        val scene = System.getProperty("scene", "main-menu")
        pushScene(scene)
    }

    override fun render() {
        super.render()

        clearScreen(0F, 0F, 255F)
        batch.use {
            SS76_FONT.draw(batch, topText, 1280/2 - topWidth / 2, 960f - 10)
        }

        val scene = sceneStack.last()
        scene.draw()
        //WHITE_FONT.draw(batch, "counter: $counter", 120f, 960 - 100f)
        //WHITE_FONT.draw(batch, items.toString(), 120f, 960 - 200f)
        //WHITE_FONT.draw(batch, "|", 1280 - 120f, 960 - 200f)

    }

    // == Helper global functions == //
    private fun getScene(scene: String): Scene {
        val gotScene = scenes[scene]
        if (gotScene == null) {
            val lastScene = sceneStack.lastOrNull()?.id ?: "<none>"
            val message = "no such scene '$scene' (linked from '$lastScene')"
            error(message)
        }
        return gotScene
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

        val newTos = sceneStack.last()
        activateScene(newTos)
    }

    /**
     * Draws white text.
     */
    public fun drawWhiteText(toDraw: CharSequence, x: Float, y: Float) {
        WHITE_FONT.draw(batch, toDraw, x, y)
    }
}