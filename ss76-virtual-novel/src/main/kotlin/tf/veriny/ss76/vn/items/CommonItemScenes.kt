package tf.veriny.ss76.vn.items

import tf.veriny.ss76.engine.scene.createAndRegisterOnePageScene

/**
 * Registers scenes for your phone.
 */
public object CommonItemScenes {
    internal val BASIC_INSPECT = createAndRegisterOnePageScene("item.phone-basic-inspect") {
        line("It's a phone.")
        newline()

        line("What more do you want?")
        newline()

        line("It's a Galaxy S6. Happy?")
        newline()

        backButton()
    }

    internal val DAY_1_USE_PHONE = createAndRegisterOnePageScene("item.phone-use-1") {
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

    internal val PHYSICS_HOMEWORK = createAndRegisterOnePageScene("item.physics-homework-inspect") {
        line("It's two sets of physics homework.")
        newline()

        line("This focuses on mechanics, electric stuff, and particle physics.")
        newline()

        backButton()
    }

    internal val PHYSICS_HOMEWORK_USE = createAndRegisterOnePageScene("item.physics-homework-use") {
        line("A gardener used a trolley to move a paving stone.")
        line("A force meter was attached to the handle of the trolley.")
        newline()

        line("The gardener recorded the following measurements when the trolley was at rest in the" +
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

    internal val ROCK_DESCRIPTION = createAndRegisterOnePageScene("item.orb") {
        line("It's a round stone.")
        newline()

        backButton()
    }

    internal val ROCK_DESCRIPTION_1 = createAndRegisterOnePageScene("item.orb.use-1") {
        line(":push:@magenta@ That's not a good idea. :pop:")
    }
}