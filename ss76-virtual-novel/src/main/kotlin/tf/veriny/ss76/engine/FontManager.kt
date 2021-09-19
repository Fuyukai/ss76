package tf.veriny.ss76.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import ktx.freetype.generateFont
import tf.veriny.ss76.SS76
import java.net.URI
import java.nio.file.FileSystems
import java.nio.file.Path
import kotlin.io.path.forEachDirectoryEntry

/**
 * Deals with loading and generating fonts.
 */
public class FontManager {
    public companion object {
        private const val FONT_SIZE_BIG = 32
        private const val FONT_SIZE_SMALL = 20

        // auto generated colours
        public val COLOURS: Map<String, Color> = mutableMapOf(
            "white" to Color.WHITE,
            "red" to Color.RED,
            "pink" to Color.PINK,    // 2
            "purple" to Color.PURPLE,  // 3
            "green" to Color.GREEN,   // 4
            "lime" to Color.LIME,    // 5
            "teal" to Color.TEAL,    // 6
            "blue" to Color.BLUE,    // 7
            "sky" to Color.SKY,     // 8
            "slate" to Color.SLATE,   // 9
            "orange" to Color.ORANGE,  // a
            "salmon" to Color.SALMON,   // b
            "magenta" to Color.MAGENTA, // c
            "violet" to Color.VIOLET,  // d
            "yellow" to Color.YELLOW,  // e
            "black" to Color.BLACK,   // f
        )
    }

    public data class Font(
        public val filename: String,
        public val fonts: MutableMap<Color, BitmapFont>
    ) {
        public val white: BitmapFont = fonts[Color.WHITE]!!
    }

    private val fonts = mutableListOf<Font>()
    private var fontIdx: Int = -1

    /** The current font. */
    public val currentFont: Font get() = fonts[fontIdx]

    /** The height of the current font. */
    public val fontHeight: Float get() = currentFont.white.lineHeight

    /** The width of a single character. */
    public var characterWidth: Float = 0.0f
        private set

    /**
     * Looks up a font by name.
     */
    public fun lookupFont(name: String): Font? {
        return fonts.find { it.filename == name }
    }

    private fun setFont(idx: Int) {
        fontIdx = idx
        println("new font: ${currentFont.filename}")
        val layout = GlyphLayout()
        layout.setText(currentFont.white, " ")
        characterWidth = layout.width
    }

    /**
     * Changes the globally rendered font to the specified font.
     */
    public fun changeFont(name: String) {
        val idx = fonts.indexOfFirst { it.filename == name }
        if (idx == -1) error("No such font: $name")
        setFont(idx)
    }

    /**
     * Changes to the next font.
     */
    public fun nextFont() {
        setFont((fontIdx + 1).rem(fonts.size))
    }

    private fun generateFont(path: String) {
        println("generating $path")
        val generator = FreeTypeFontGenerator(Gdx.files.internal(path))
        val fonts = mutableMapOf<Color, BitmapFont>()
        for (colour in COLOURS) {
            val font = generator.generateFont {
                size = if (SS76.isBabyScreen) FONT_SIZE_SMALL else FONT_SIZE_BIG
                color = colour.value
                mono = true
                genMipMaps = true
            }
            fonts[colour.value] = font
        }


        generator.dispose()
        val name = path.split("/").last().split(".").first()
        this.fonts.add(Font(name, fonts))
    }

    /**
     * Loads all the fonts packed with the current jar.
     */
    public fun loadAllFonts() {
        // todo: this needs to be updated for jpackage
        val url = javaClass.classLoader.getResource("fonts")!!.toURI()
        if (url.scheme == "file") {
            val path = Path.of(url)
            path.forEachDirectoryEntry { p ->
                // le libgdx
                generateFont("fonts/${p.fileName}")
            }
        } else {
            val split = url.toString().split("!")

            FileSystems.newFileSystem(URI.create(split[0]), mutableMapOf<String, String>()).use {
                val path = it.getPath(split[1])
                path.forEachDirectoryEntry { p ->
                    // le libgdx
                    generateFont("fonts/${p.fileName}")
                }
            }
        }

        changeFont("Mx437_PhoenixEGA_8x8-2y")
    }
}