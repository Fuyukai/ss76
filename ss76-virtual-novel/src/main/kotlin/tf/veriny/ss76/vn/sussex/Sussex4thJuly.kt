package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.NextPageButton
import tf.veriny.ss76.engine.scene.sceneSequence
import kotlin.random.Random

private const val FLESH_FLAG = "ch2-defied-father"

public fun registerSu4JScenes(): Unit = sceneSequence("su4j-") {
    disableTextSkip()

    createAndRegisterOnePageScene("start") {
        line("Today's date is Saturday, the 4th of July.")
        newline()

        line("It's a @sky@sunny @sky@summer @sky@day. It's pretty hot, but pretty humid too.")
        newline()

        changeSceneButton("su4j-resort-1", ">>> Next")
    }

    createAndRegisterOnePageScene("resort-1") {
        line("At long last, it's finally the summer holiday. You're really excited about " +
             "this; this year has been so tedious and it's great to finally decompress.")
        newline()

        line("You're not looking for a wild and wacky holiday - but something nice, " +
             "meandering, and calm.")
        newline()

        line("There's no need for shenanigans, for tricks, or for any tomfoolery!")
        newline()

        line("No wildness, no extravagance, no, none of that!")
        newline()

        line("You just want a", addNewline = false)
        changeSceneButton("su4j-resort-2", "nice, calm getaway.")
    }

    createAndRegisterOnePageScene("resort-2") {
        line("And what a getaway it is! It's a fancy holiday resort on the beach!")
        newline()

        line("Now, here in England, it might not be the best of weather.")
        line("The sun might not shine that hard.")
        line("The rain might be an unwelcome visitor.")
        line("And, most of all, it might be intolerably humid.")
        newline()

        line("But that's no excuse not to enjoy yourself! " +
             "The pool is warm and the sea is cold.")
        newline()

        line("The breakfast is hot and the desserts are chilled. After all, there's no time " +
             "for 'normal meals' when you could be eating sausages and ice cream all week!")
        newline()

        changeSceneButton("su4j-resort-3", "It's a shame about the people, though.")
    }

    createAndRegisterOnePageScene("resort-3") {
        line("But still, there's lots of activities to do. It's like a Centre Parcs, " +
             "but on the beach.")
        newline()

        line("Swimming, clay painting, crime solving, clay pigeon shooting, it's like a " +
             "school enrichment week, but not forced!")
        newline()

        line("You arrived here with Char and her family; her dad, and her younger sister. " +
             "They have a joined room, but you and Char have two separate rooms - and, they are " +
             "truly luxurious.")
        newline()

        line("A double bed, air conditioning, a big telly in the corner! It's standard for a " +
             "hotel, but not a resort hotel!")
        newline()

        changeSceneButton("su4j-resort-4", "It's perfect for hiding away.")
    }

    createAndRegisterOnePageScene("resort-4") {
        line("Neither you nor Char are really into the whole 'holibobs' business. " +
             "Your ideal holiday is somewhere interesting! Somewhere with heritage!")
        newline()

        line("A place to sit in the sun and fry for a week and a half? ¬shake¬BORING!")
        newline()

        line("But, to the adults, that's not acceptable! There's a mighty knock on your door!")
        newline()

        dline("????: Oi. I paid for this trip, you're not going to marinate in bed for the " +
              "next week.")

        line("That's Char's dad. But, you don't want to leave. It's cold and comfortable in here.")
        newline()

        line("Do you:")
        changeSceneButton("su4j-resort-5", "Ignore him", "ch2-defied-father")
        newline()
        changeSceneButton("su4j-resort-5", "Get up and leave")
    }

    createAndRegisterScene("resort-5") {
        enablePagination = false

        onLoad {
            if (SS76.eventFlagsManager.get("ch2-defied-father")) {
                it.pageIdx = 0
            } else {
                it.pageIdx = 1
            }
        }

        addButton(NextPageButton)

        page {
            line("You opt to just ignore him. It's your holiday, and it's your life. " +
                 ":linger:300")
            newline()

            line("The knocking grows even more menacing, though. Are you sure you thought " +
                 "this though? :linger:60")
            newline()

            line("Char's dad is a :push:¬mojibake¬ mightily scary man. :pop:")
            newline()

            line("It's really not a good idea to defy him. The knocking and pounding is a " +
                 "a good sign of your impending doom. :linger:300")
            newline()

            line("Maybe it'll do good to go outside. There's lots of activities for you to do. " +
                 "Surely, there will be something that achieves one of your goals?")
            newline()

            line(":push:@salmon@`next-page` Let's leave the room.")
        }

        page {
            line(
                "You get up and swing the door open, with a visible annoyance. Char's dad " +
                "stands staring at you."
            )
            newline()

            line("He's an ugly man. He's short, thin, and balding. His mouth is too big and " +
                 "his nose is too small. He's straight out of the Oblivion character designer.")
            newline()

            line("His forehead veins bulge outwards, threatening to cause a stroke at any " +
                 "second. Throb, throb, throb - the blood pumping is so clearly visible.")
            newline()

            line(":push:@pink@ If you put your finger out and pressed down on a vein, would he die? " +
                 ":linger:600 :pop:")
            newline()

            dline("FTHR: Get up and get out into the sun. I didn't pay a grand a head for " +
                  "you to sit in that room all day like last time.")

            changeSceneButton("su4j-resort-6", "He yanks you out of the room.")
        }
    }

    createAndRegisterOnePageScene("resort-6") {
        line("The resort walls are hardly soundproof. The sound of children playing and " +
             "adults... 'playing' is very visible everywhere in these halls.")
        newline()

        line("Everything here has all the tackiness one would expect from a package holiday " +
             "seaside resort.")
        newline()

        line("The diseased carpet that squelches under your feet. The paper walls.")
        newline()

        line("Just this alone is enough to make any sane person want to hide away from the world.")
        newline()

        line("You trail awkwardly behind Char's dad, and Char's dad's child trails behind " +
             "you too.")
        newline()

        line("The hall stretches ", addNewline = false)
        repeat(Random.Default.nextInt(1, 13)) {
            line("on, :linger:60 and ", addNewline = false)
        }
        line("on - until, after an eternity, you finally reach the", addNewline = false)
        changeSceneButton("su4j-resort-7", "central plaza.")
    }

    createAndRegisterScene("resort-7") {
        enablePagination = false

        onLoad {
            val defied = SS76.eventFlagsManager.get(FLESH_FLAG)
            if (!defied) {
                it.pageIdx = pages.size - 1
            }
        }

        addButton(NextPageButton)

        page {
            line("You're pushed through the doors, out into the sunlight. Oh, the horrible sunlight!")
            newline()

            line("Your blood boils in the daylight. Your skin sears and burns, stripping away.")
            newline()

            line("You scratch at your arms, deeply, @pink@deeply, pulling out chunks of cooked " +
                 "flesh. :linger:60")
            newline()

            line("The sunlight penetrates deeply into your bones, bleaching them. They fizzle " +
                 "and @pink@crackle and @pink@snap, and the remains of your legs fall away into " +
                 "ashes. :linger:60")
            newline()

            line("Your tendons recoil, like worms and bugs @pink@wriggling :linger:60 and " +
                 "@pink@writhing :linger:60 :push:@salmon@`next-page` under your skin. :pop:")
            newline()
        }

        page {
            line("You try and scream for help, but your voice merely gurgles. The laughing " +
                 "children, the laughing adults, and the laughing animals brush past you.")
            newline()

            line("Ignoring you. Uncaring. They don't even watch as your body breaks down.")
            newline()

            line("The pain is unceasing, unending. Your skull creaks and splits, sending " +
                 "your spinal fluid jetting out.")
            newline()

            line("It runs down your face, mixing with your eye jelly, blotting out what " +
                 "remains of your vision.")
            newline()

            line("Your organs mingle, having their time of their life. Liver, kidney, stomach, " +
                 "heart? It's all :push:@salmon@`next-page` the same now. :pop:")
        }

        page {
            line("Char's dad slaps you on the back, sending you recoiling forwards. " +
                 "The same kind of joking slap you give a friend! How nice!")
            newline()

            line("But... this was too hard! That's not how you treat a friend. He gave it a " +
                 "bit too much power!")
            newline()

            line("You spin around to meet his gaze. His, @black@unceasing gaze.")
            newline()

            line("Is there something else behind @pink@those eyes?")
            newline()

            dline("????: Here. Go make some friends, loser. If I catch you back in your room " +
                  "before dinner...")

            changeSceneButton(
                "su4j-resort-8",
                "He walks away, in the direction of the on-resort pub."
            )
        }

        page {
            line("Char's dad gives you a gentle push out through the open doors. How delicate!")
            newline()

            dline("????: Here. Go make some friends. If I catch you back in your room before " +
                  "dinner...")

            line("And, just like that, he ambles away in the direction of the pub.")
            newline()

            dline("CHAR: Don't mind me dad. He grew up in a different time.")

            line("Char walks out ahead, and", addNewline = false)
            changeSceneButton("su4j-resort-8", "examines the surroundings.")
        }
    }

    createAndRegisterOnePageScene("resort-8") {
        line("The plaza is massive. The ground is covered in multicoloured slabs, creating " +
             "paths out of grand rainbows.")
        newline()

        line("Benches, gazebos, and bushes divert the flow of traffic, creating a labyrinth " +
             "of fun!")
        newline()

        line("There's children and parents running everywhere, their screaming and shouting " +
             "mingling with the rushing of the artificial rivers creating a cacophony of joy.")
        newline()

        line(":push:@pink@ It's a stark contrast. :pop: :linger:60")
        newline()

        line("You cross over one of the bridges and find yourself in a large square with " +
             "games tables dotted. There's people playing board games, both the complex and the " +
             "simple ones.")
        newline()

        changeSceneButton("su4j-resort-9", "It almost feels like a school playground.")
    }

    createAndRegisterOnePageScene("resort-9") {
        line("There's one table. There's one horrible, terrible, awful table, sitting at the " +
             "back of the plaza. A chess table.")
        newline()

        line("There's a horrible, terrible, awful, creepy woman. Staring. At... Char.")
        newline()

        dline("CHAR: There's nothing for us here. Let's go find somewhere in the shade.")

        line("You're drawn to this table. It's hard to resist... but you're stronger than that.")
        newline()

        dline("CHAR: Come on.")

        line("You turn around, but...", addNewline = false)
        changeSceneButton("chess-pt1-0", "you're oddly drawn to it.")
        newline(2)

        line("It's not a good idea to go there. You should", addNewline = false)
        changeSceneButton("su4j-resort-10", "follow Char.")
    }

    createAndRegisterOnePageScene("resort-10") {
        line("The rainbow streets lead to all kinds of magical and wonderful and horrifying " +
             "places.")
        newline()

        line("The central resort is arranged in a grid, the paths forming a spider " +
             "web out to the seven corners")
    }
}
