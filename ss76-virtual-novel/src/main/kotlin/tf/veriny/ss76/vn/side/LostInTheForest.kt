package tf.veriny.ss76.vn.side

import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.scene.createAndRegisterScene

public fun registerSideLostInTheForest(sm: SceneManager): Unit = with(sm) {
    createAndRegisterScene("side.lost-forest-1") {
        page {
            line("Your home town is a mix of suburban shoeboxes, forests, and heathland.")
            newline()

            line(
                "You can barely walk a minute in any direction before being cut off by the " +
                "towering trees."
            )
            newline()

            line(
                "It creates a horrible mixture of urbanism and rural life. Tiny, cramped ugly " +
                "houses everywhere (and they're all new builds!) surrounded by an impenetrable veil " +
                "of bushes and trees."
            )
            newline()

            line(
                "When you're a child, though, it's a fantastic time. Many children whittle " +
                "away the hours playing in amongst the natural areas."
            )
            newline()

            changeSceneButton("side.lost-forest-2", "Every town has its rumours.")
        }
    }

    createAndRegisterScene("side.lost-forest-2") {
        page {
            line("Primary school children really do love unsubstantiated rumours.")
            newline()

            dline(
                "????: My mum told me that there's a bear in the woods who comes out at night " +
                "and eats children!"
            )

            dline("????: That's not true! Bears come out in the day!")

            dline("????: Do bears like chicken nuggets?")

            dline(
                "????: My daddy's friend likes to hide in the woods, but he told me not to " +
                "tell anyone."
            )

            dline("????: YOUR DAD IS FRIENDS WITH A BEAR? HE'S GOING TO KILL US!")

            changeSceneButton(
                "side.lost-forest-3",
                "Their wild imaginations didn't stop them from playing there, though.."
            )
        }
    }

    createAndRegisterScene("side.lost-forest-3") {
        page {
            line(
                "You used to play in the woods too, with your old friends. Every day, after " +
                "school. You would all go quite deep, too. At your insistence."
            )
            newline()

            line(
                "You don't remember their names. It's been so long, and they never contacted " +
                "you again anyway."
            )
            newline()

            line(
                "You didn't believe the rumours. You were practically asking for a bear to eat " +
                "your face, honestly. Your friends did, however. They were really terrified of the " +
                "child-eating nocturnal bear."
            )
            newline()

            line(
                "You would usually get home before dusk crept in, but it's so easy to forget " +
                "how quickly the days recede sometimes."
            )
            newline()

            changeSceneButton("side.lost-forest-4", "One day, you had a bright idea.")
        }
    }

    createAndRegisterScene("side.lost-forest-4") {
        page {
            line(
                "It was a brutally cold November day, the first school day after the clocks " +
                "went back. You and your friends were kicking the wet leaves at each other as you " +
                "delved into the forests."
            )
            newline()

            line(
                "Before you realised it, the daylight was dying and you were quite deep into " +
                "one not far from home."
            )
            newline()

            dline("????: Hey... it's getting dark... my mum is gonna get really worried.")

            dline("????: We should go back. The bear is going to lurk.")

            line(
                "A putrid light went off in your head. You started to devise a truly excellent " +
                "prank - one that would show your silly friends that the bear isn't real."
            )
            newline()

            line("You told them that that you knew the way back to the houses, and would lead " +
                 "the way.")
            newline()

            line("The darkening conditions and endless leaves made it easy to", addNewline = false)
            changeSceneButton("side.lost-forest-5", "slip away from their sight.")
        }
    }

    createAndRegisterScene("side.lost-forest-5") {
        page {
            line("As soon as they realised you had gone missing, a terror crept over them that " +
                 "was plainly visible for anyone to see. The moment had come.")
            newline()

            line(
                "You let out a horrible shriek, loud enough to scare away the local wildlife " +
                "observing your idiotic antics."
            )
            newline()

            line(
                "You screamed about the bear. You screamed about how it was eating you."
            )
            line(
                "Your friends screamed about the bear. Your friends screamed about how it " +
                "was eating you."
            )
            newline()

            line(
                "You stopped screaming, and silence fell. Your friends were quaking in their " +
                "boots, as still as statues. If they moved, the bear would surely come for them next."
            )
            newline()

            changeSceneButton("side.lost-forest-6", "You lunged at them from the shadows.")
        }
    }

    createAndRegisterScene("side.lost-forest-6") {
        page {
            line(
                "Their screams could be heard all the way from the other side of the country. " +
                "A foul stench filled your nostrils as they legged it as fast as they possibly " +
                "could out of the forest, in every direction, anywhere away from you."
            )
            newline()

            line("Predictably, the next day none of your friends wanted to talk to you.")
            repeat(3) { line("Or the next day.") }
            newline()

            line("What a horrible little child you were.")
            newline()

            backButton()
        }
    }
}