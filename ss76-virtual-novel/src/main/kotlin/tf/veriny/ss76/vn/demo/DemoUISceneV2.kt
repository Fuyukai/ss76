package tf.veriny.ss76.vn.demo

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.FontManager
import tf.veriny.ss76.engine.scene.DEFAULT_FRAMES_PER_WORD
import tf.veriny.ss76.engine.scene.createAndRegisterScene

/**
 * Registers the all new Demo UI scene.
 */
public fun registerDemoUIScene() {
    createAndRegisterScene("renderer-v2-demo") {
        page {
            line("This is a demo screen!")
            newline()

            line(
                "The renderer has been completely rewritten. Now it supports lots of fancy " +
                "features!"
            )
            newline()

            line("The next line wraps.")
            line("Signaling System No. 7 (or Signalling System No. 7, SS7) is a set of " +
                 "telephony signaling protocols developed in 1975, which is used to set up and tear " +
                 "down telephone calls in most parts of the world-wide public switched telephone " +
                 "network (PSTN)")
            newline()

            line("Colours:")
            newline()

            val colours = FontManager.COLOURS.keys.joinToString(" ") {  "@$it@$it" }
            line(colours)
        }

        page {
            line("The last word in this sentence will ¬shake¬shake.")
            line(":push:¬shake¬ But, not the last word in this :pop: sentence.")
        }

        page {
            line("Shuffled numbers: ¬shufnum¬0123456789")
            line("Shuffled text: ¬shuftxt¬abcdefghi")
        }

        page {
            dline("????: Extremely long dialogue. This should wrap cleanly with a 6-character " +
                  "indent due to the special dialogue effect. If it works properly, that is!")
        }
    }

    createAndRegisterScene("invert") {
        invert = true
        clearScreenColour = Color.WHITE

        page {
            line(":push:@black@ Invert. :pop:")
        }

        page {
            newline(11)
            line(" ".repeat(27) + ":push:@black@ The world ends. :pop:")
        }
    }

    createAndRegisterScene("lightning") {
        effects.lightning = true

        page {
            line("Cool lightning effect.")
        }
    }

    createAndRegisterScene("linger-test") {
        page {
            line("Linger: 30 frames (0.5s) :linger:30")
            line("Linger: 60 frames (1s) :linger:60")
            line("Linger: 120 frames (2s) :linger:120")
            line("Fin")
        }

        page {
            line("Frames per word: $DEFAULT_FRAMES_PER_WORD")
            newline()

            for (i in 1 until 5) {
                val newFpw = DEFAULT_FRAMES_PER_WORD + i
                line(":fpw:$newFpw Frames per word: $newFpw")
                newline()
            }

            line(":fpw:1 One frame per word. Lots of extra text " + "etc ".repeat(60))

            line(":fpw:reset Reset. Frames per word: $DEFAULT_FRAMES_PER_WORD")
        }
    }

    createAndRegisterScene("charset") {
        page {
            line("""
                ☺ ☻ ♥ ♦ ♣ ♠ • ◘ ○ ◙ ♂ ♀ ♪ ♫ ☼ ► ◄ ↕ ‼ ¶ § ▬ ↨ ↑ ↓ → ← ∟ ↔ ▲ ▼  ! " # ${'$'} % & \' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9 : ; < = > ? A B C D E F G H I J K L M N O P Q R S T U V W X Y Z [ ] ^ _  a b c d e f g h i j k l m n o p q r s t u v w x y z { | } ~ ⌂ Ç ü é â ä à å ç ê ë è ï î ì Ä Å É æ Æ ô ö ò û ù ÿ Ö Ü ¢ £ ¥ ₧ ƒ á í ó ú ñ  ª º ¿ ⌐ ½ ¼ ¡ « » ░ ▒ ▓ │ ┤ ╡ ╢ ╖ ╕ ╣ ║ ╗ ╝ ╜ ╛ ┐ └ ┴ ┬ ├ ─ ┼ ╞ ╟ ╚ ╔ ╩ ╦ ╠ ═ ╬ ╧ ╨ ╤ ╥ ╙ ╘ ╒ ╓ ╫ ╪ ┘ ┌ █ ▄ ▌ ▐ ▀ α ß Γ π Σ σ µ τ Φ Θ Ω δ ∞ φ ε ∩ ≡ ± ≥ ≤ ⌠ ⌡ ÷ ≈ ° ∙ · √ ⁿ ² ■ 
            """.trimIndent())
        }
    }

    createAndRegisterScene("mojibake") {
        //effects.mojibake = true

        page {
            line("""
                Mojibake is the garbled text that is the result of text being decoded using an unintended character encoding.[1] The result is a systematic replacement of symbols with completely unrelated ones, often from a different writing system.

                This display may include the generic replacement character ("�") in places where the binary representation is considered invalid. A replacement can also involve multiple consecutive symbols, as viewed in one encoding, when the same binary code constitutes one symbol in the other encoding. This is either because of differing constant length encoding (as in Asian 16-bit encodings vs European 8-bit encodings), or the use of variable length encodings (notably UTF-8 and UTF-16). 
            """.trimIndent())
        }

        page {
            line("¬mojibake¬Test Test ¬mojibake¬Test Test")
        }
    }

    createAndRegisterScene("font-change") {
        page {
            line("This line is in the default font.")
            newline()

            line(":font:alt This line is in the alt font.")
            newline()

            line(":font:default This :font:alt line :font:default alternates.")
        }
    }

    createAndRegisterScene("chomp") {
        page {
            line("@red@R :chomp: @green@G :chomp: @blue@B")
        }
    }

    createAndRegisterScene("trollface") {
        page {
            dline("????: ¬ayana¬")
            newline()

            dline("????: please kill me")
        }
    }
}