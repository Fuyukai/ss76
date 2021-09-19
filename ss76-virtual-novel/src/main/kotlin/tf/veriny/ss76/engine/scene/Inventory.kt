package tf.veriny.ss76.engine.scene

import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.UpdatableSceneWrapper

/**
 * The inventory is just a bunch of items you have. You can inspect them, but they don't do much.
 *
 * It's kind of weird to have an inventory system that doesn't really matter, isn't it?
 *
 * The inventory is implemented as a set of states, where each states contains the items the
 * inventory has. The item has an INSPECT and USE button, which is fixed. If you want to change the
 * text that the item uses, you need to add a different state.
 */
public class Inventory(private val sceneManager: SceneManager) {
    public companion object {
        private val QUOTES = mutableListOf(
            "\"You know, normal people say 'pocket'.\" - Char",
            "\"Don't call your pockets your inventory around me. It's embarrassing.\" - Char",
            "\"You're not a video game protagonist.\" - Char",
            "\"People are going to think its weird if you refer to your pockets as your 'inventory'.\" - Char",
        )
    }

    /** A single item in the inventory. */
    public data class InventoryItem(
        public val name: String,
        public val inspectScene: String,
        public val useScene: String = "util.item-unused"
    )

    /** A singular state in the inventory. */
    public data class InventoryState(
        public val key: String,
        public val items: Map<String, InventoryItem>
    )

    // inventory states are keyed by number, but also have an optional string ID that helps to look
    // them up. numbers are auto-assigned.
    private val states: MutableList<InventoryState> = mutableListOf(
        InventoryState("empty", mutableMapOf())
    )

    private var currentState: InventoryState = states[0]

    public var currentStateIdx: Int = 0
        private set

    private val scene = UpdatableSceneWrapper("inventory-screen")

    /**
     * Recreates the inventory view scene.
     */
    private fun recreateScene() {
        scene.reset()
        scene.edit(0) {
            line(QUOTES.random())
            newline()

            line("Inventory listing:")
            if (currentState.items.isEmpty()) {
                line("It's empty. Just like you.")
            }

            for ((idx, item) in currentState.items.values.withIndex()) {
                line(
                    "${idx + 1}. ${item.name} - " +
                    "`push-scene-${item.inspectScene}`@salmon@INSPECT / " +
                    "`push-scene-${item.useScene}`@salmon@USE"
                )
            }
            newline()
            backButton()
        }

        scene.register(sceneManager)
    }

    /**
     * Changes the inventory state to the one specified by the index.
     */
    public fun changeState(key: Int) {
        require(key >= 0) { "cannot have negative indexes" }

        currentState = states[key]
        currentStateIdx = key
        recreateScene()
    }

    public fun findStateIdx(key: String): Int {
        return states.indexOfFirst { it.key == key }
    }

    /**
     * Creates a new inventory state and adds it to the list of states, returning the ID of the
     * state.
     */
    public fun newState(key: String, items: Map<String, InventoryItem>): Int {
        val newState = InventoryState(key = key, items = items)
        states.add(newState)
        return states.size - 1
    }

    public fun newStateCopyOf(
        old: InventoryState,
        newName: String,
        block: MutableMap<String, InventoryItem>.() -> Unit
    ): Int {
        val items = old.items.toMutableMap()
        items.block()

        return newState(newName, items)
    }

    /**
     * Creates a new inventory state, copying from the specified old name, returning the new ID
     * number of the state.
     */
    public fun newStateCopyingFrom(
        oldName: String,
        newName: String,
        block: MutableMap<String, InventoryItem>.() -> Unit
    ): Int {
        val state = states.find { it.key == oldName } ?: error("no such state: $oldName")
        return newStateCopyOf(state, newName, block)
    }

    /**
     * Creates a new inventory state, copying from the last state, returning the new ID number of
     * the state.
     */
    public fun newStateCopyingLast(
        newName: String, block: MutableMap<String, InventoryItem>.() -> Unit
    ): Int {
        val state = states.last()
        return newStateCopyOf(state, newName, block)
    }
}
