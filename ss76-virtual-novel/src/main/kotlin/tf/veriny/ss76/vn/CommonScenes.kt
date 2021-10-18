package tf.veriny.ss76.vn

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Sound
import tf.veriny.ss76.engine.scene.SceneDefinition
import tf.veriny.ss76.engine.scene.createAndRegisterScene

/**
 * "Namespace" of scenes shared between multiple routes.
 */
public object CommonScenes {
    @Suppress("GDXKotlinStaticResource")  // don't care
    private lateinit var DTMF_AUDIO: Sound

    public fun register() {
        DTMF_AUDIO = Gdx.audio.newSound(Gdx.files.internal("audio/dtmf.ogg"))
    }

    public val END_OF_DEMO: SceneDefinition = createAndRegisterScene("end-of-demo") {
        page {
            line("You've reached the end of the Signalling System 76 demo.")
            newline()

            line("I hope you've enjoyed it. If there's any feedback you wish to give, good or " +
                 "bad, please let me know.")
            newline()

            line("Press F2 to reload the main/demo menu.")
        }
    }

    public val A_LEVELS_SCENE: SceneDefinition = createAndRegisterScene("a-level-explain-scene") {
        page {
            line(
                "A-levels are one of the possible last stages of UK higher education. You pick " +
                "three or four subjects you really wish to continue, and spend 8 hours in the " +
                "educational week dedicated to that subject."
            )
            newline(2)
            backButton()
        }
        page {
            line(
                "A-levels are graded on a scale from A* to U. BCC is a relatively average grade. " +
                "These grades are used to apply to higher education. However, you apply at the end of " +
                "year 12, well before any exams, so you don't have grades. Instead, you do a series of " +
                "mock exams halfway through Year 12 which give you a set of predicted grades, which are then " +
                "used by higher education institutions to determine if they will give you an offer or not. " +
                "Of course, your real grades at the end of Year 13 are used to see if you actually get " +
                "into Universities."
            )
            newline(2)
            backButton()
        }
    }

    // to future me: move everything unused to this
    // region unused for now.
    public val DONT_LIKE_PHONES: SceneDefinition = createAndRegisterScene("common.dlp") {
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
    public val DESK_DESCRIPTION: SceneDefinition = createAndRegisterScene("common.desk") {
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
    public val SCHOOL_SIZE: SceneDefinition = createAndRegisterScene("common.schoolsize") {
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
    public val SCHOOL_WORKING_LIFT: SceneDefinition = createAndRegisterScene("common.schoollift") {
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

    public val SCHOOL_ATTENDANCE: SceneDefinition = createAndRegisterScene("common.school_attendance") {
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

    public val FLOOR_5_AIR_CON: SceneDefinition = createAndRegisterScene("common.floor5.ac") {
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

            line("An annoying little rat. He doesn't know when to shut up.")
            newline()

            line(
                "He has an IQ of 6. He has a bright career as a shopping trolley attendant."
            )
            newline()

            line("He's a spoiled rich kid, too. He's been waited on his whole life.")
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

            line("Her last name makes her seem like a kraut, but she's not.")
            newline()

            line(
                "Overly nice. She's so fake about it. You wish she wouldn't force herself to " +
                "act that way."
            )
            newline()

            line(
                "She pretends to know a lot about science and tech, but she's just skimming off of " +
                "other people's hard work."
            )
            newline()

            line("She tries to speak in RP, but her grating native Sussex accent comes through anyway.")
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

            line("She tries to speak in RP, but her cute native Suffolk accent comes through anyway.")

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

            line(
                "She's a complete suck-up to the teachers. She's a straight-A* student, " +
                "although that doesn't matter because she's a humanities student."
            )
            newline()

            line(
                "She only graces you with her presence when she's not busy reminding everyone " +
                "that homework is due or policing the uniforms of the Year 9s."
            )
            newline()

            line("She has grey hairs and some faintly visible wrinkles already, from a life of " +
                 "stressing so hard about her schoolwork. She'll be dead at 25 from a heart attack.")
            newline()

            backButton()
        }
    }


    internal val FRIENDS = createAndRegisterScene("common.friends-r1-first") {
        page {
            line("You have three friends. (What a loser.)")
            newline()

            line(
                "You've known them since Year 7. Nobody from your old primary school passed " +
                "the entrance exam, so you had to make new friends. Naturally, you gravitated towards " +
                "the weirdos."
            )

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
            line("a hyperactive rat")

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

            line("Many local authorities practice controlled burns for this reason, but there is " +
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

    internal val FELL_DOWN_HEATH = createAndRegisterScene("common.fallen-down") {
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

    internal val SPINNY_VAN_THING = createAndRegisterScene("common.spinny-van-thing") {
        page {
            line("When you were a kid, you asked your mother what the spinny things on vans were.")
            newline()

            line("She told you it was so that the government could watch naughty children and take " +
                 "them away if they were badly behaved.")
            newline()

            line("You were terrified to walk past a van for years.")
            newline()

            line("It was quite funny, really. Not for you.")
            newline()

            line("Eventually you learned they were actually just fans, not cameras. You'd stopped " +
                 "hiding at this point anyway.")
            newline()

            line("You still engage in pointless staring contests with them.")
            newline()

            backButton()
        }
    }

    // call forward to the monologue about charlotte's cat in ending #2
    // future me: make sure to write that. you know what we mean
    public val CARS: SceneDefinition = createAndRegisterScene("sussex-i-hate-cars") {
        page {
            line(
                "Cars are terrible, evil things. If one was religious, they could say that " +
                "cars are even the work of the devil."
            )
            newline()

            line("What just society lets anyone drive a metal box that can instantly kill any " +
                 "person unfortunate enough to stand in its way?")
            newline()

            line(
                "Yeah, someone has to take a test to get a driver's licence. Would it be " +
                "okay if nuclear grenades were given out to everyone if they took a test for it?"
            )
            newline()

            line("All drivers should be @pink@¬shake¬killed.")
            newline()

            backButton()
        }
    }

    internal val DTMF = createAndRegisterScene("common.dtmf") {
        onLoad {
            DTMF_AUDIO.play()
        }

        page {
            line(
                "DTMF, or Dual Tone Multiple Frequency, is two sine wave tones laid over " +
                "each-other to represent a single number or letter."
            )
            newline()

            line(
                "DTMF finds most usage in old, analogue telephony networks. A key on a " +
                "keypad causes one of sixteen combinations of two frequences to be sent on a phone " +
                "line, registering on the other end as a single digit in a phone number."
            )
            newline()

            line(
                "DTMF replaced the old pulse dialing system used in rotary phones, where the " +
                "dial would interrupt a signal a certain number of times to encode that number."
            )
            newline()

            line(
                "DTMF encodes the numbers one through nine, the hash (#) and star (*), and " +
                "the letters A, B, C, and D, although most phones don't have the letters."
            )
            newline()

            line(
                "With a bit of training, it's possible to distinguish the frequencies by ear. " +
                "One could then theoretically eavesdrop on the numbers somebody is dialing over a " +
                "phone without having to tap it."
            )

            backButton()
        }
    }
}