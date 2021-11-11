package tf.veriny.ss76.engine.scene

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.BackButton
import tf.veriny.ss76.engine.Button
import tf.veriny.ss76.engine.ChangeSceneButton
import tf.veriny.ss76.engine.PushSceneButton
import tf.veriny.ss76.engine.adv.ADVSubRenderer
import tf.veriny.ss76.ignore

/**
 * A single builder for a single page.
 */
public class PageBuilder(
    private val page: StringBuilder,
    private val buttons: MutableMap<String, Button>
) {
    private fun ensureBlankChar() {
        val lastChar = page.lastOrNull()
        if (lastChar != null && lastChar != ' ' && lastChar != '\n') {
            page.append(' ')
        }
    }

    /**
     * Clears the current page.
     */
    public fun clear() {
        page.clear()
    }

    /**
     * Adds a new line of text to this page. This will be automatically split and
     * formatted according to the various formatting characters.
     */
    public fun line(data: String, addNewline: Boolean = true) {
        page.append(data)
        if (addNewline) page.append('\n')
    }

    public fun lline(data: String, addNewline: Boolean = true) {
        page.append(data)
        ensureBlankChar()
        page.append(":linger:")
        if (addNewline) page.append('\n')
    }

    public fun dline(
        data: String, addNewline: Boolean = true, linger: Boolean = true, lingerFrames: Int = 60
    ) {
        ensureBlankChar()
        var realText = ":push:¬dialogue¬ $data :pop: "

        if (linger) realText += ":linger:$lingerFrames"

        line(realText, addNewline = false)
        if (addNewline) {
            newline(2)
        }
    }

    /**
     * Adds a newline.
     */
    public fun newline(count: Int = 1) {
        repeat(count) { page.append('\n') }
    }

    /**
     * Adds a generic button to the current page. This can be referenced with backtick syntax
     * on nodes.
     */
    public fun addButton(
        button: Button,
    ) {
        buttons[button.name] = button
    }

    // convenience
    /**
     * Adds a button that changes the current scene.
     */
    public fun changeSceneButton(sceneId: String, text: String, eventFlag: String? = null) {
        ensureBlankChar()
        val buttonName = "change-scene-$sceneId"
        val realText = ":push:@salmon@`$buttonName` $text :pop: "

        line(realText, addNewline = false)
        addButton(ChangeSceneButton(buttonName, sceneId, eventFlag))
    }

    /**
     * Adds a button that pushes a new scene onto the stack.
     */
    public fun pushSceneButton(sceneId: String, text: String, eventFlag: String? = null) {
        ensureBlankChar()
        val buttonName = "push-scene-$sceneId"
        val realText = ":push:@linked@`push-scene-$sceneId` $text :pop: "
        line(realText, addNewline = false)

        addButton(PushSceneButton(buttonName, sceneId, eventFlag))

    }

    /**
     * Adds a green back button.
     */
    public fun backButton(text: String = "« Back") {
        val realText = ":push:@green@`back-button` $text :pop: "
        line(realText)

        addButton(BackButton)
    }

}

/**
 * Builder helper for creating new scene definitions.
 */
public class SceneDefinitionBuilder(
    private val sceneId: String,
    /**
     * The scene effects used for this scene.
     */
    public val effects: SceneEffects = SceneEffects(),
) {
    @PublishedApi
    internal val pages: MutableList<StringBuilder> = mutableListOf()
    @PublishedApi
    internal val buttons: MutableMap<String, Button> = mutableMapOf()
    private val onLoadHandlers: MutableList<(SceneState) -> Unit> = mutableListOf()

    /** If pagination should be enabled. Useful for choiced scenes. */
    public var enablePagination: Boolean = true

    /** The linked inventory index. */
    public var linkedInventoryIdx: Int = 0

    /** The colour to clear the screen on loading. */
    public var clearScreenColour: Color?
        get() = effects.backgroundColour
        set(value) { effects.backgroundColour = value }

    /** The top text to change to on loading. */
    public var topText: String
        get() = effects.topText
        set(value) { effects.topText = value }

    /** If this scene should draw with the colours inverted. */
    public var invert: Boolean
        get() = effects.invert
        set(value) { effects.invert = value }

    /** The ADV mode sub-renderer for this scene. */
    public var advRenderer: ADVSubRenderer? = null

    /**
     * Registers a function to be ran on load.
     */
    public fun onLoad(block: (SceneState) -> Unit) {
        onLoadHandlers += block
    }

    /**
     * Creates a new page.
     */
    public inline fun page(block: PageBuilder.() -> Unit) {
        val page = StringBuilder()
        val builder = PageBuilder(page, buttons)
        builder.block()
        pages.add(page)
    }

    /**
     * Creates a definition from a page.
     */
    private fun createDefinitionFromPage(page: StringBuilder): List<TextualNode> {
        val printScene = System.getProperty("ss76-print-scene-data")

        val pageFullString = page.toString()
        val nodes = try {
            splitScene(pageFullString, v = sceneId == printScene)
        } catch (e: Exception) {
            throw IllegalStateException("Caught error trying to tokenize:\n$pageFullString", e)
        }

        if (sceneId == printScene) {
            println("Round-trip parse:\n")
            println(nodes.joinToString("") { it.repr() })
            println()

            println("Scene timings:\n")
            nodes.debugPrintTimings()
        }

        // auto-create missing buttons
        val missing = nodes.filter { it.buttonId != null && !buttons.contains(it.buttonId) }

        for (node in missing) {
            val buttonName = node.buttonId!!
            // todo: less gross
            when {
                buttonName.startsWith("push-scene-") -> {
                    val sceneId = buttonName.removePrefix("push-scene-")
                    val button = PushSceneButton(buttonName, sceneId)
                    buttons[buttonName] = button
                }
                buttonName.startsWith("ps-") -> {
                    val sceneId = buttonName.removePrefix("ps-")
                    val button = PushSceneButton(buttonName, sceneId)
                    buttons[buttonName] = button
                }

                buttonName.startsWith("change-scene-") -> {
                    val sceneId = buttonName.removePrefix("change-scene-")
                    val button = PushSceneButton(buttonName, sceneId)
                    buttons[buttonName] = button
                }
                buttonName.startsWith("cs-") -> {
                    val sceneId = buttonName.removePrefix("cs-")
                    val button = PushSceneButton(buttonName, sceneId)
                    buttons[buttonName] = button
                }
                else -> throw IllegalArgumentException("Missing definition for button $buttonName")
            }.ignore()
        }

        return nodes
    }

    /**
     * Creates the scene definition for this builder.
     */
    public fun createDefinition(): SceneDefinition {
        val pages = mutableListOf<List<TextualNode>>()
        for (page in this.pages) {
            val nodes = createDefinitionFromPage(page)
            pages.add(nodes)
        }

        return SceneDefinition(
            sceneId, buttons, pages, originalPages = this.pages.map { it.toString() },
            linkedInventoryId = linkedInventoryIdx,
            effects = effects,
            onLoadHandlers = this.onLoadHandlers,
            advSubRenderer = advRenderer,
            enablePagination = enablePagination
        )
    }
}

/**
 * Builder for a scene sequence.
 */
public class SceneSequenceBuilder(public val idPrefix: String) {
    /** The current effects. This is copied to all scenes. */
    public val currentEffects: SceneEffects = SceneEffects()

    private var lastInventoryIdx: Int = 0

    /** The current ADV renderer. */
    public var advRenderer: ADVSubRenderer? = null

    /**
     * Changes the current linked inventory state.
     */
    public fun changeInventoryState(key: String) {
        val inv = SS76.sceneManager.inventory.findStateIdx(key)
        lastInventoryIdx = inv
    }

    /**
     * Sets the current clear screen colour for use in all subsequent scenes.
     */
    public fun clearColour(colour: Color) {
        currentEffects.backgroundColour = colour
    }

    /**
     * Sets the current top text for use in all subsequent scenes.
     */
    public fun setTopText(topText: String) {
        currentEffects.topText = topText
    }

    /**
     * Disables inversion.
     */
    public fun enableInvert() {
        currentEffects.invert = true
        currentEffects.backgroundColour = Color.WHITE
    }

    public fun disableInvert() {
        currentEffects.invert = false
        currentEffects.backgroundColour = null
    }

    public fun enableLightning() {
        currentEffects.lightning = true
        currentEffects.backgroundColour = Color.BLACK
    }

    public fun disableLightning() {
        currentEffects.lightning = false
        currentEffects.backgroundColour = null
    }

    public fun disableTextSkip() {
        currentEffects.disableTextSkip = true
    }

    public fun enableTextSkip() {
        currentEffects.disableTextSkip = false
    }

    /**
     * Creates and registers a new scene.
     */
    public fun createAndRegisterScene(
        sceneId: String, block: SceneDefinitionBuilder.() -> Unit
    ): SceneDefinition {
        val builder = SceneDefinitionBuilder(idPrefix + sceneId, currentEffects.copy())
        builder.linkedInventoryIdx = lastInventoryIdx
        builder.advRenderer = advRenderer
        builder.block()

        val definition = builder.createDefinition()
        SS76.sceneManager.registerScene(definition)
        return definition
    }

    /**
     * Creates and registers a new, single-page scene.
     */
    public inline fun createAndRegisterOnePageScene(
        sceneId: String, crossinline block: PageBuilder.() -> Unit
    ): SceneDefinition {
        return createAndRegisterScene(sceneId) { page(block) }
    }

    /**
     * Copies the last inventory and creates a new one, setting the inventory index for all
     * subsequent scenes.
     */
    public fun copyAndSetInventory(
        newName: String, block: MutableMap<String, Inventory.InventoryItem>.() -> Unit
    ) {
        val idx = SS76.sceneManager.inventory.newStateCopyingLast(newName, block)
        lastInventoryIdx = idx
    }
}

/**
 * Creates a sequence of scenes which share certain properties.
 */
public inline fun sceneSequence(idPrefix: String = "", block: SceneSequenceBuilder.() -> Unit) {
    val builder = SceneSequenceBuilder(idPrefix)
    builder.block()
}

/**
 * Creates a new scene.
 */
public inline fun createScene(
    sceneId: String,
    block: SceneDefinitionBuilder.() -> Unit,
): SceneDefinition {
    val builder = SceneDefinitionBuilder(sceneId)
    builder.block()

    return builder.createDefinition()
}

/**
 * Creates a new scene and registers it with the scene manager.
 */
public inline fun createAndRegisterScene(
    sceneId: String, block: SceneDefinitionBuilder.() -> Unit
): SceneDefinition {
    val scene = createScene(sceneId, block = block)
    SS76.sceneManager.registerScene(scene)
    return scene
}

public inline fun createAndRegisterOnePageScene(
    sceneId: String, block: PageBuilder.() -> Unit
): SceneDefinition {
    return createAndRegisterScene(sceneId) { page(block) }
}