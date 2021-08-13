package tf.veriny.ss76.vn

import tf.veriny.ss76.scene.text.TextualScene
import tf.veriny.ss76.scene.text.createAndRegisterScene

/**
 * "Namespace" of scenes shared between multiple routes.
 */
public object CommonScenes {
    // to future me: move everything unused to this
    // region unused for now.
    public val DONT_LIKE_PHONES: TextualScene = createAndRegisterScene("common.dlp") {
        page {
            line(
                "You don't really like mobile phones. It was unthinkable for any secondary " +
                "school kid to *not* have a mobile phone, so you did have one until you were " +
                "sixteen."
            )
            newline()
            line(
                "One day, you dropped it at school accidentally, shattering the screen and " +
                "breaking the digitizer. It was completely broken. You weren't upset, because your " +
                "phone was a constant source of distraction. You couldn't afford a new one, so you " +
                "never bought a new one. It's better off that way, isn't it? "
            )
            newline(2)
            backButton()
        }
    }
    public val DESK_DESCRIPTION: TextualScene = createAndRegisterScene("common.desk") {
        page {
            line(
                "Your desk is a simple Ikea desk. It is extremely cluttered because you " +
                "worry that you might throw something away very important. Old papers from homework " +
                "you never turned in, printed documents "
            )
            newline()
            line(
                "On the back of the desk is your computer monitor. It's just a hand-me-down " +
                "from your dad, who got a new one a few months ago. It works for your purposes, " +
                "which is rushed homework, some light programming, and Paradox games."
            )
            newline()
            line(
                "Next to your monitor is your phone. It's nothing fancy. Just an early 2010s " +
                "model. Why change what doesn't need to be upgraded?"
            )
            backButton()
        }
    }

    // previously used in 3rd of july routes as an exposition scene.
    public val SCHOOL_SIZE: TextualScene = createAndRegisterScene("common.schoolsize") {
        page {
            line(
                "Your school is a selective secondary school, being all boys from Year 7 to " +
                "Year 11, and co-ed in Sixth Form."
            )
            line(
                "It's also absolutely massive. The main building has six floors and is bigger " +
                "than the town centre. It's bigger than a university. It was built all the way back " +
                "in the 1950s."
            )
            newline()

            // the internet is terrible because it's dial-up. because the phones are so old.
            // that's how the wardialing "club" can even do the phreaking.
            line(
                "The fifth floor is where you spend most of your time. It's lined with computer " +
                "rooms after a refit a few years back. The internet is absolutely terrible though."
            )
            newline()
            // throwaway line... this has no meaning. but it's meant to make the reader think.
            line(
                "The government of the time gave an absolutely massive grant to build the" +
                "main campus. Legend has it, one of the administrators was blackmailing a cabinet " +
                "minister about some less-than-moral wartime activities."
            )
            newline()
            backButton()
        }
    }


    // endregion

    // used
    public val SCHOOL_WORKING_LIFT: TextualScene = createAndRegisterScene("common.schoollift") {
        page {
            // faculty really don't like kids using lifts. they think its just kids being lazy.
            // of course, theyre fine to use the lifts themselves.
            line(
                "The school building originally only had one lift, to be used by disabled " +
                "pupils."
            )
            line(
                "It was strictly controlled, with a pass required to use it. Eventually, " +
                "complaints by parents caused the faculty to cave in and build four more, with open " +
                "access for everyone."
            )
            newline()

            // maybe it's deliberate :)
            line(
                "Unfortunately, wear and tear means that there's usually only one lift that " +
                "actually works. The staff always say that repairs will be soon, but if it breaks " +
                "then that lift will be out of service until at least the next school year. "
            )
            newline()

            line(
                "One year, on the first day you came in, all five lifts were upgraded to be " +
                "faster and in working order. This was the only time you could remember that all " +
                "five actually worked. This lasted approximately a month before the school was back " +
                "down to one."
            )
            newline()

            line("Curiously, the only lift that consistently works is the one by the staff room.")
            newline()

            backButton()
        }
    }

    public val SCHOOL_ATTENDANCE: TextualScene = createAndRegisterScene("common.school_attendance") {
        page {
            // the archangel project requires fresh minds/parents dont want their kids out of school

            line(
                "One time, one of your classmates bunked off entirely. He left in the morning " +
                "but never actually arrived at school."
            )
            newline()

            line(
                "The school proceeded to call both the local police and a private security " +
                "company to track him down and return him, with force if needed."
            )
            newline()

            line(
                "At about 11:00, he was frog-marched into your lesson by two very " +
                "strong-looking men in body armour. He was never really the same again."
            )
            newline()
            backButton()
        }
    }

    public val FLOOR_5_AIR_CON: TextualScene = createAndRegisterScene("common.floor5.ac") {
        page {
            line(
                "The school's server room is on the fifth floor, so the air conditioning is " +
                "always on."
            )
            newline()

            // throwaway line!
            line(
                "Combined with the lack of windows and insulated walls, it is always freezing" +
                "cold up here. It'd probably be possible to store bodies here."
            )
            newline()

            backButton()
        }
    }

    internal val FLOOR_5_YEAR7S = createAndRegisterScene("common.floor5.y7") {
        page {
            line("Only the older years have lessons up here.")
            newline()

            line(
                "Nobody's quite sure why, but it's probably due to a combination of the labs being " +
                "very specialised, the computers being borderline unusable due to the internet speeds, " +
                "and the younger kids being terrified of the atmosphere. "
            )
            newline()

            line(
                "However, there's always been a persistent rumour that, long ago, the Year 7s " +
                "would have lessons on the fifth floor, and every month one would disappear."
            )
            newline()
            line(
                "Nobody knew by what or why. It's almost definitely false. You still keep one " +
                "eye on the back of your head."
            )
            newline()
            backButton()
        }
    }

    // friend biographies
    internal val CHAR_BIOGRAPHY_1 = createAndRegisterScene("common.friends.char") {
        page {
            line("Name: Charlotte 'Char' Philips (with ONE l)")
            line("Age: 17")
            line("Height: 175cm (5'9\")")
            line("Favourite colour: Orange")
            line("Favourite food: Pineapples")
            newline()

            line(
                "You've been friends with Char since the very first day. You didn't really have " +
                "any choice - she saw you in the first break, and that was it."
            )
            newline()

            line("She's the most normal person in existence. Everything about her is normal.")
            newline()

            backButton()
        }
    }


    internal val CHAR_BIOGRAPHY_2 = createAndRegisterScene("common.friends.char-real") {
        page {
            line("Name: Charlotte 'Char' Philips")
            line("Age: 18")
            line("Height: 175cm (5'9\")")
            newline()

            line(
                "Char assaulted you on the first day because you asked her about her hobbies."
            )
            newline()

            line(
                "She's actually in the year above you. She's technically finished school, but " +
                "for some reason she's still here."
            )

            line(
                "She tries her hardest to be as 'normal' as possible. Unfortunately for her, " +
                "that makes her pretty damn weird. "
            )
            newline()

            backButton()
        }
    }

    internal val ALEX_BIOGRAPHY_1 = createAndRegisterScene("common.friends.alex") {
        page {
            line("Name: Alexander 'Alex' Ashton")
            line("Age: 16")
            line("Height: 150cm")
            newline()

            line("The worst person you know.")
            newline()

            line("Self-centred. Full of himself. Mean. Spoiled rich kid.")
            newline()

            line("He has nobody else, so you feel sorry for him. That's why you're friends with him.")
            newline()

            backButton()
        }
    }

    internal val CATE_BIOGRAPHY_1 = createAndRegisterScene("common.friends.cate") {
        page {
            line("Name: Catherine 'Cate' Schwartz")
            line("Age: 17")
            newline()

            line("Her last name makes her seem like a kraut, but she's not. She speaks with a " +
                 "perfect English accent, and she doesn't look German.")
            newline()

            line("Overly nice. She's so fake about it.")
        }
    }


    internal val FRIENDS = createAndRegisterScene("common.friends") {
        page {
            line("You have three friends. (What a loser.)")
            newline()

            line(
                "You've known them since Year 7. None of your other primary school friends " +
                "passed their 11+. They're all a bunch of weirdos. It's no wonder you gravitated " +
                "towards them. "
            )
            newline()

            line("They are:")
            newline()

            pushSceneButton(
                CHAR_BIOGRAPHY_1.id,
                "Charlotte 'Char' Philips,"
            )
            line("the most normal girl in existence")

            pushSceneButton(
                "common.friends.alex",
                "Alexander 'Alex' Ashton,"
            )
            line("the worst person you know")

            pushSceneButton(
                "common.friends.cate",
                "Catherine 'Cate' Schwartz,"
            )
            line("the kindest person in existence")

            newline()
            backButton()
        }
    }
}