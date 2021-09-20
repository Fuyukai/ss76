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
        line("Who are you going to call?")
        newline()

        line(":push:@salmon@ Your mother :pop:")
        line(":push:@salmon@ 999 :pop:")
        line(":push:@salmon@ Sex hotline :pop:")
        newline()

        line("For some reason, your touch screen isn't responding.")
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
}