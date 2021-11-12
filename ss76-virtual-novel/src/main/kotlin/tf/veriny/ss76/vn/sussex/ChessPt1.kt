package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.engine.scene.createAndRegisterOnePageScene
import tf.veriny.ss76.engine.scene.createAndRegisterScene

public fun registerChessPt1Scenes() {
    val statements = listOf(
        "That lady looks creepy. It's probably not a good idea to go over there.",
        "No, seriously. She looks really weird. We shouldn't go over there.",
        "She's staring at me. I don't think it's a good idea to go over there.",
        "You're not even good at chess. It's not a good idea to go over there.",
        "She looks like a professional. It's not a good idea to go over there.",
        "It's not a good idea to go over there.",
        "I can't stop you from going over there, but you really shouldn't.",
        "Why do you want to go over there so badly?",
        "I think it's a really bad time to go over there. I'll play chess with you later.",
        "She looks pretty good at chess. You shouldn't go over there.",
        "Are you absolutely sure you want to go over there? I don't like chess.",
        "It's a really bad idea to go over there. Stop.",
        "Why aren't you listening to me? Stop.",
        "I don't want to play chess. Stop.",
        "No. It's a bad idea. Stop.",
        "Why do you want to go over there so badly? Stop.",
        "She looks like a London player. It's best to stay away.",
        "Seriously. Stop.",
        "You don't want to play against a London player. Stop.",
        "My dad thinks chess is for losers. We should listen to him. Stop.",
        "No. Stop.",
        "Seriously, why are you so insistent on going over there? Stop!",
        "This is ¬mojibake¬my ¬mojibake¬choice, not ¬mojibake¬yours. Stop!",
        "I'm not :push:¬mojibake¬ letting you drag me :pop: over there. Stop!",
        "... I don't want to play chess.",
        "... Please.",
        "... Why do you want to play chess so badly?",
        "... Please stop.",
        "... It's a really, really, really bad idea to go over there.",
        "... My ¬mojibake¬late... no, nevermind.",
        "... Are you sure? You really want to play chess?",
        "Are you absolutely sure? You really want to play chess?",
        "You're just like me. Why do you want to play chess?",
        "I'm ¬mojibake¬awake. I don't want to play chess.",
        "I can't ¬mojibake¬fight.",
        "Okay. Let's play chess."
    )

    var counter = 0
    for (st in statements) {
        createAndRegisterScene("chess-pt1-$counter") {
            effects.disableTextSkip = true

            page {
                dline("CHAR: $st")

                backButton("<<< Don't play.")
                line(":linger:${counter * 30}")
                changeSceneButton("chess-pt1-${counter + 1}", "Play chess")
            }
        }

        counter++
    }

    createAndRegisterOnePageScene("chess-pt1-${counter}") {
        line(":push:@yellow@ I didn't expect you to actually skip through the waiting. " +
             "There's nothing here (yet).")
    }

}