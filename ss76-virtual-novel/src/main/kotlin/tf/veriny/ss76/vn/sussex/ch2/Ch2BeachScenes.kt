package tf.veriny.ss76.vn.sussex.ch2

import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.scene.createAndRegisterOnePageScene
import tf.veriny.ss76.engine.scene.sceneSequence

public fun registerCh2BeachScenes(sm: SceneManager): Unit = sm.sceneSequence("ch2-") {
    createAndRegisterOnePageScene("beach-1") {
        line("The resort opens out to the beach, bordering the beautifully cold North Sea.")
        newline()

        line("Clouds of ice and steam rise up from the ocean, and a layer of " +
             "jellyfish floats atop the clear waters.")
        newline()

        line("Swimmers and non-swimmers alike are distributed throughout the sea, " +
             "sploshing and splishing and splashing at each other.")
        newline()

        line(
            "The sandy beach is dotted with sunbathing humans, " +
            "sunbathing sandcastles, and sunbathing sand humans, all laid out on multicolour towels."
        )
        newline()

        line("The seagulls above soar and yell obscenities at the red lobsters below, their " +
             "song synchronised with the crashing of the waves.")
        newline()

        changeSceneButton("ch2-beach-2", "It really puts you in the mood for a drink.")
    }

    createAndRegisterOnePageScene("beach-2") {
        dline("CHAR: We should get a drink. I'm thirsty.")

        line("You agree. You're on holiday, after all! It's the best place to get piss drunk.")
        newline()

        line("The resort bar is at the other end of the beach, a small trek away.")
        newline()

        line("Why is it so far? It seems pointless to put it so far.")
        newline()

        line("It's so infuriating. It's so infuriating. There's no reason to put something " +
             "like that so far!")
        newline()

        line("Oh, and it's not like you're going to get dehydrated on the walk here! It's not" +
             "that long!")
        newline()

        changeSceneButton("ch2-beach-3", "It's not that hot, either!")
    }

    createAndRegisterOnePageScene("beach-3") {
        line("It baffles the mind! Why would @pink@ANYONE build a resort in such an " +
             "inconvenient manner!")
        newline()

        line("They are here to SERVE the GUESTS!")
        newline()

        line("Everything should be @pink@ABSOLUTELY @pink@CONVENIENT!")
        newline()

        line("Whoever designed this should be fired! :linger:120 Or, killed.")
        newline()

        line("It goes against the fundamental principles of hospitality!")
        newline()

        line(":push:@pink@ It's a complete insult. :pop: :linger:300")
        newline()

        changeSceneButton("ch2-beach-4", "But... never mind that.")
    }

    createAndRegisterOnePageScene("beach-4") {
        line("The bar is just a normal bar. Wooden countertop, various multicoloured " +
             "bottles on display in the back, the strong smell of disinfectant.")
        newline()

        line("The wood has been stripped down by years of alcoholic decay, and there's " +
             "visible indents where the regular @black@degenerate alkies have dug their " +
             "@black@disgusting elbows in over the years.")
        newline()

        line("You and Char take a seat on one of the bar stools each. They're old and hard, " +
             "the seat padding having long been worn away.")
        newline()

        line("The salty sea air rolls in and out behind you, in ripples. The red and yellow " +
             "beach flag swishes around above you.")
        newline()


    }
}