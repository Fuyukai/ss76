package tf.veriny.ss76.vn

import tf.veriny.ss76.scene.text.TextualScene
import tf.veriny.ss76.scene.text.createAndRegisterScene

/**
 * "Namespace" of scenes shared between multiple routes.
 */
public object CommonScenes {
    public val END_OF_DEMO: TextualScene = createAndRegisterScene("end-of-demo") {
        page {
            line("You've reached the end of the Signalling System 76 demo.")
            newline()

            line("I hope you've enjoyed it. If there's any feedback you wish to give, good or " +
                 "bad, please let me know.")
            newline()

            line("Press F2 to reload the main/demo menu.")
        }
    }

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
                "Combined with the lack of windows and insulated walls, it is always freezing " +
                "cold up here. It'd probably be possible to store bodies here."
            )
            newline()

            backButton()
        }
    }

    internal val FLOOR_5_YEAR7S = createAndRegisterScene("common.floor5.y7") {
        // char kills year 7s
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
                "You've been friends with Char since the very first day."
            )
            newline()

            line("She's the most normal person in existence. Everything about her is normal.")
            newline()

            line("She has long brown hair that goes down to her shoulders, perfect skin with " +
                 "no blemishes due to her skincare routine, and an excellent dress sense.")
            newline()

            backButton()
        }
    }


    internal val CHAR_BIOGRAPHY_2 = createAndRegisterScene("common.friends.char-real") {
        page {
            line("Name: Charlotte 'Char' Philips")
            line("Age: 18")
            line("Height: 175cm (5'9\")")
            line("Favourite colour: Orange")
            newline()

            line(
                "Char assaulted me on the first day because I asked her about her hobbies."
            )
            newline()

            line(
                "She's actually in the year above me. She's technically finished school, but " +
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

    internal val ALEX_BIOGRAPHY_2 = createAndRegisterScene("common.friends.alex-real") {
        page {
            line("Name: Alexander 'Alex' Ashton")
            line("Age: 16")
            line("Height: 177.2cm")
            line("Favourite colour: White")
            newline()

            line("Very full of himself, but still charming.")
            newline()

            line("Extremely excitable.")
            newline()

            line("He's really smart, but not good at social cues. His parents don't really care about him.")
            newline()

            line("I feel sorry for him, but I'm friends with him because he's a good guy.")
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
                 "stereotypical English accent, and she doesn't look German.")
            newline()

            line(
                "Overly nice. She's so fake about it. You wish she wouldn't force herself to " +
                "act that way."
            )
            newline()

            backButton()
        }
    }

    internal val CATE_BIOGRAPHY_2 = createAndRegisterScene("common.friends.cate-real") {
        page {
            line("Name: Catherine 'Cate' Schwartz")
            line("Age: 17")
            line("Height: 165.5cm")
            line("Favourite colour: Lime")
            newline()

            line("Her grandparents are German, which explains the last name. " +
                 "She's definitely English through and through.")
            newline()

            line("She's really nice to everyone. She gives fantastic advice.")
            newline()

            backButton()

        }
    }

    internal val JESS_BIOGRAPHY_1 = createAndRegisterScene("common.friends.jess") {
        page {
            line("Name: Jessica 'Jess' Taylor")
            line("Age: 17 going on 30")
            newline()

            line(
                "She moved to this school's sixth form from some terrible comprehensive " +
                "(redundant)."
            )
            newline()

            line("She's a complete suck-up to the teachers. She's a straight-A* student.")
            newline()

            line(
                "She only graces you with her presence when she's not busy reminding everyone " +
                "that homework is due, or policing the uniforms of the Year 9s."
            )
            newline()

            line("Luckily, she's not planning on university, otherwise you'd have to hear her " +
                 "drivel about applying to Oxbridge.")
            newline()

            backButton()
        }
    }


    internal val FRIENDS = createAndRegisterScene("common.friends-r1-first") {
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
                ALEX_BIOGRAPHY_1.id,
                "Alexander 'Alex' Ashton,"
            )
            line("the worst person you know")

            pushSceneButton(
                CATE_BIOGRAPHY_1.id,
                "Catherine 'Cate' Schwartz,"
            )
            line("the fakest person in existence")
            newline()

            backButton()
        }
    }

    internal val HEATHLAND = createAndRegisterScene("common.heathland") {
        page {
            line(
                "Heaths are habitats where lots of shrubs and bushes grow. " +
                "Sometimes you get small trees, too."
            )
            newline()

            line(
                "They're formed over many years from old plants burning down and " +
                "fertilising the soil for the next generation of heath plants."
            )
            newline()

            line("Many governments practice controlled burns for this reason, but there is " +
                 "still a significant problem of inconsiderate people setting fire to the bushes " +
                 "outside of these instances."
            )
            newline()

            line("Unfortunately, heaths are disappearing worldwide. It's a shame.")
            newline()
            backButton()
        }
    }

    // 4th scenes

    internal val FRIENDS_R1_TWO = createAndRegisterScene("common.friends-r1-second") {
        page {
            line("You have four friends. (What a loser.)")

            line(
                "You've known most of them since Year 7."
            )
            newline()

            line("They are:")
            newline()

            pushSceneButton(
                CHAR_BIOGRAPHY_1.id,
                "Charlotte 'Char' Philips,"
            )
            line("the wisest lady you know")

            pushSceneButton(
                ALEX_BIOGRAPHY_1.id,
                "Alexander 'Alex' Ashton,"
            )
            line("a mosquito given human form")

            pushSceneButton(
                CATE_BIOGRAPHY_1.id,
                "Catherine 'Cate' Schwartz,"
            )
            line("the most insincere person ever ")

            pushSceneButton(
                JESS_BIOGRAPHY_1.id,
                "Jessica 'Jess' Davies,",
            )
            line("Minister for Brownnosing")  // hehe...
            newline()

            backButton()

        }
    }

    internal val FELL_DOWN_HEATH = createAndRegisterScene("https://www.youtube.com/watch?v=ilmX2IwAAw8") {
        page {
            line(
                "When you first started walking to school, you tried cutting across the heath " +
                "on the way there."
            )
            newline()

            line("The way down has a steep hill with thick tree roots across and an " +
                 "old desiccated MDF plate partially buried at the bottom.")
            newline()

            line("The tree roots caught your foot as you slid down, slamming you face-first " +
                 "into the dirt below.")
            newline()

            line(
                "You required a filling on your front tooth. You still can't drink cold water."
            )
            newline()

            backButton()

        }
    }
}