package tf.veriny.ss76.vn.items

import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.scene.Inventory
import tf.veriny.ss76.engine.scene.createAndRegisterOnePageScene

/**
 * Registers scenes for your phone.
 */
@Suppress("PropertyName", "UNUSED")
public class CommonItemScenes(sm: SceneManager) {
    internal val BASIC_INSPECT = sm.createAndRegisterOnePageScene("item.phone-basic-inspect") {
        line("It's a phone.")
        newline()

        line("What more do you want?")
        newline()

        line("It's a Galaxy S6. Happy?")
        newline()

        backButton()
    }

    internal val DAY_1_USE_PHONE = sm.createAndRegisterOnePageScene("item.phone-use-1") {
        line("You are now 5 steps away from being a developer.")
        line("You are now 4 steps away from being a developer.")
        line("You are now 3 steps away from being a developer.")
        line("You are now 2 steps away from being a developer.")
        line("You are now 1 step away from being a developer.")
        newline()

        line("You are now a developer!")
        newline()

        backButton()
    }

    internal val PHONE_INSPECT_2 = sm.createAndRegisterOnePageScene("item.phone-2") {
        line("It's a phone.")
        newline()

        line("More specifically, it's your phone.")
        newline()

        backButton()
    }

    internal val PHONE_USE_2 = sm.createAndRegisterOnePageScene("item.phone-use-2") {
        line("Now's not the time to become a developer.")
        newline()

        backButton()
    }

    public val PHONE_ITEM: Inventory.InventoryItem = Inventory.InventoryItem("PHONE", BASIC_INSPECT.id, DAY_1_USE_PHONE.id)

    internal val PHYSICS_HOMEWORK = sm.createAndRegisterOnePageScene("item.physics-homework-inspect") {
        line("It's two sets of physics homework.")
        newline()

        line("This focuses on mechanics, electric stuff, and particle physics.")
        newline()

        backButton()
    }

    internal val PHYSICS_HOMEWORK_USE = sm.createAndRegisterOnePageScene("item.physics-homework-use") {
        line("A gardener used a trolley to move a paving stone.")
        line("A force meter was attached to the handle of the trolley.")
        newline()

        line("The gardener recorded the following measurements when the trolley was at rest in the " +
             "position shown in the diagram.")
        newline()

        line("mass of trolley and paving stone = 18.5 kg")
        line("length of trolley = 97 cm")
        line("force on handle = 50 N")
        newline()

        line("(a)  Determine the distance of the centre of gravity of the loaded trolley from the wheels.")
        newline()

        repeat(4) {
            line("_".repeat(40))
        }
        newline()

        backButton()
    }

    public val PHYS_HW_ITEM: Inventory.InventoryItem = Inventory.InventoryItem(
        "PHYSICS HW",
        PHYSICS_HOMEWORK.id, PHYSICS_HOMEWORK_USE.id
    )

    internal val ROCK_DESCRIPTION_1 = sm.createAndRegisterOnePageScene("item.orb-1") {
        line("It's a round stone.")
        newline()

        backButton()
    }

    internal val ROCK_USE_1 = sm.createAndRegisterOnePageScene("item.orb.use-1") {
        backButton()
    }

    public val ROCK_ITEM: Inventory.InventoryItem = Inventory.InventoryItem(
        "SMOOTH STONE",
        ROCK_DESCRIPTION_1.id,
        ROCK_USE_1.id
    )

    internal val CAT_HAIR = sm.createAndRegisterOnePageScene("item.cat-hair") {
        line("It's a handful of cat hair.")
        newline()

        line("The hair is multicoloured, just like your cat.")
        newline()

        line("Maybe you should give it back.")
        newline()

        backButton()
    }

    internal val CAT_HAIR_USE = sm.createAndRegisterOnePageScene("item.cat-hair.use") {
        line("You take the hair and shove it inside your mouth. What the actual fuck is wrong with you?")
        newline()

        line("It tastes like a combination of hair and Toxoplasmosis gondii. You're going to get a disease.")
        newline()

        line(
            "You chew the hair. Unsurprisingly, your teeth can't chew hair, so it just kinda floats around " +
            "in your spit."
        )
        newline()

        line(
            "You involuntarily gag and cough and the brand new hairball flies out of your " +
            "mouth and into your hand."
        )
        newline()

        line("You fling it about to dry it off, and stick the hair back in your pocket.")
        newline()

        backButton()
    }

    internal val INCOMPREHENSIBLE_INSPECT = sm.createAndRegisterOnePageScene("item.incomprehensible") {
        line("It's not something you can comprehend.")
        newline()

        backButton()
    }

    internal val INCOMPREHENSIBLE_USE = sm.createAndRegisterOnePageScene("item.incomprehensible-use") {
        line("")
    }

    internal val WEIRD_LETTER = sm.createAndRegisterOnePageScene("item.weird-letter") {
        line("Dear resident")
        newline()

        line(
            "It is dangerous to go out when the river does not flow. " +
            "You are lucky you are at the beginning of the cycle."
        )
        newline()

        line("Maids look a lot about what we do not mean. You are at risk.")
        newline()

        line(
            "Please meet me in a dusty room at noon. Someone should not follow you, and " +
            "do not trust either of what they say."
        )
        newline()

        line("Observer")
        newline(2)

        backButton()
    }

    internal val WEIRD_LETTER_USE = sm.createAndRegisterOnePageScene("item.weird-letter.use") {
        line("What?")
        newline()

        line("How can you use a letter?")
        newline()

        line("You're so stupid.")
        newline()

        backButton()
    }
}