package tf.veriny.ss76.engine.scene

import tf.veriny.ss76.engine.FontManager

public const val DEFAULT_FRAMES_PER_WORD: Int = 5
private val DIRECTIVE_RE = ":(.+):(.*)".toRegex()

public data class Token(
    /** The colour name. */
    public val colour: String?,

    /** The set of effects. */
    public val effects: Set<String>,

    /** The button associated with the token. */
    public val buttonName: String?,

    /** The text of the token. */
    public val text: String,

    /** If this token has a newline. */
    public val hasNewline: Boolean = false,
)

private enum class TokenifyState {
    BEGIN,
    TEXT,
    COLOUR,
    EFFECT,
    BUTTON,
}

/**
 * Tokenifies the word.
 */
private fun tokenify(
    currentColour: String? = null,
    currentEffects: Set<String> = setOf(),
    currentButton: String? = null,
    word: String
): Token {
    // This is a terrible function.
    var colour = currentColour
    val effects = currentEffects.toMutableSet()
    var button = currentButton
    val wordBuilder = StringBuilder()

    val currentBuilder = StringBuilder()
    var state = TokenifyState.BEGIN

    var hasNewline = false

    for (char/*lotte*/ in word) {
        if (hasNewline) {
            error("Got character '$char' after newline")
        }

        if (state == TokenifyState.TEXT) {
            wordBuilder.append(char)
            continue
        }

        when (char) {
            '@' -> {
                state = when (state) {
                    TokenifyState.BEGIN -> TokenifyState.COLOUR
                    TokenifyState.COLOUR -> {
                        colour = currentBuilder.toString()
                        currentBuilder.clear()
                        TokenifyState.BEGIN
                    }
                    else -> error("Can't handle '@' during state $state")
                }
            }
            '¬' -> {
                state = when (state) {
                    TokenifyState.BEGIN -> TokenifyState.EFFECT
                    TokenifyState.EFFECT -> {
                        if (currentBuilder.isNotEmpty()) {
                            effects.add(currentBuilder.toString())
                        }
                        currentBuilder.clear()
                        TokenifyState.BEGIN
                    }
                    else -> error("Can't handle '¬' during state $state")
                }
            }
            ',' -> {
                when (state) {
                    TokenifyState.BEGIN, TokenifyState.TEXT -> {
                        wordBuilder.append(char)
                        state = TokenifyState.TEXT
                    }
                    TokenifyState.EFFECT -> {
                        effects.add(currentBuilder.toString())
                        currentBuilder.clear()
                    }
                    else -> error("Can't handle ',' during state $state")
                }
            }
            '`' -> {
                state = when (state) {
                    TokenifyState.BEGIN -> TokenifyState.BUTTON
                    TokenifyState.BUTTON -> {
                        button = currentBuilder.toString()
                        currentBuilder.clear()
                        TokenifyState.BEGIN
                    }
                    else -> error("Can't handle '`' during state $state")
                }
            }
            '\n' -> {
                if (state != TokenifyState.TEXT && state != TokenifyState.BEGIN) {
                    error("Can't handle newline during state $state")
                }
                hasNewline = true
            }
            else -> {
                when (state) {
                    TokenifyState.BEGIN, TokenifyState.TEXT -> {
                        wordBuilder.append(char)
                    }
                    TokenifyState.EFFECT, TokenifyState.BUTTON, TokenifyState.COLOUR -> {
                        currentBuilder.append(char)
                    }
                }
            }
        }
    }

    return when (state) {
        TokenifyState.COLOUR -> {
            error("Missing closing '@' in $word")
        }
        TokenifyState.EFFECT -> {
            error("Missing closing '¬' in $word")
        }
        TokenifyState.BUTTON -> {
            error("Missing closing '`' in $word")
        }
        else -> {
            val word = wordBuilder.toString()
            Token(colour, effects, button, word, hasNewline = hasNewline)
        }
    }
}

/**
 * Splits a single scene into a stream of TextualNode directives.
 */
public fun splitScene(text: String, rightMargin: Int = 70, v: Boolean = false): List<TextualNode> {
    val nodes = mutableListOf<TextualNode>()

    // State variables
    //  The frame that the current node will be rendered on.
    var frameCounter = 0
    //  The current number of frames per word.
    var currentFramesPerWord = DEFAULT_FRAMES_PER_WORD
    //  The length of the current line.
    var currentLineLength = 0

    // pushed data, automatically used during tokenization
    val pushed = ArrayDeque<Token>()


    val lines = text.split("\n")
    for (line in lines) {
        currentLineLength = 0

        val words = line.split(" ")
        for (rawWord in words) {
            // directives include stuff like :push: or :pop:.
            val directive = DIRECTIVE_RE.matchEntire(rawWord)
            if (directive != null) {
                val dNamee = directive.groups[1]!!.value
                val dValue = directive.groups[2]!!.value

                when (dNamee) {
                    "push" -> {
                        val tos = pushed.lastOrNull()
                        val token = tokenify(
                            tos?.colour, tos?.effects ?: setOf(),
                            tos?.buttonName, dValue
                        )
                        check(token.text.isEmpty()) { "cannot push markup '$dValue' with text" }
                        pushed.addLast(token)
                    }
                    "pop" -> {
                        pushed.removeLast()
                    }
                    else -> error("unknown directive $dNamee")
                }

                continue
            }

            val start = frameCounter
            val end = (start + currentFramesPerWord).also { frameCounter = it }

            val tos = pushed.lastOrNull()
            val token = tokenify(
                tos?.colour, tos?.effects ?: setOf(),
                tos?.buttonName, rawWord
            )

            // calculate effects first; we need to know if a dialogue effect is active to insert
            // causesNewline and update padding early
            val parsedEffects =
                token.effects.mapTo(mutableSetOf()) { TextualNode.Effect.valueOf(it.uppercase()) }
            val isDialogue = TextualNode.Effect.DIALOGUE in parsedEffects
            // useless effect for the renderer. kept anyway when outputting the unravelled nodes
            // parsedEffects.remove(TextualNode.Effect.DIALOGUE)

            val word = token.text
            val nextLength = currentLineLength + word.length + 1

            // update previous node, if needed
            val overflowed =
                //(isDialogue && nextLength >= (rightMargin - 7)) ||
                (nextLength >= rightMargin)

            if (overflowed) {
                val last = nodes.lastOrNull()
                last?.causesNewline = true
                last?.causesSpace = false
                currentLineLength = word.length + 1
            } else {
                currentLineLength = nextLength
            }

            // now we can finally create the node and update its properties
            val node = TextualNode(
                token.text, startFrame = start, endFrame = end,
                causesNewline = token.hasNewline,
                causesSpace = !token.hasNewline,
                buttonId = token.buttonName,
                effects = parsedEffects
            )

            // first dialogue line on an overflowed line always has 7 characters of padding
            if (isDialogue && overflowed) {
                currentLineLength += 6
                node.padding = 6
            }

            // calc colour if needed
            val colourName = token.colour?.lowercase() ?: "white"
            val colour = (if (colourName == "linked") {
                if (token.buttonName == null) {
                    error("cannot have 'linked' colour token and a null button name")
                } else {
                    node.colourLinkedToButton = true
                    FontManager.COLOURS["white"]
                }
            } else FontManager.COLOURS[token.colour ?: "white"]) ?: error("unknown colour: ${token.colour}")

            node.colour = colour
            nodes.add(node)
        }

        val newlineNode = TextualNode(
            "", startFrame = frameCounter, endFrame = frameCounter, causesNewline = true,
            causesSpace = false,
        )
        nodes.add(newlineNode)
    }

    return nodes
}

public fun main(args: Array<String>) {
    val sceneText = ":push:@green@ this text is green :push:¬shake¬ and this shakes too :pop: no more shaking :pop:"

    println(splitScene(sceneText).joinToString(" ") { it.repr() })
}