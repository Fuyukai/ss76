package tf.veriny.ss76.vn

import tf.veriny.ss76.scene.text.TextualScene
import tf.veriny.ss76.scene.text.createAndRegisterScene
import tf.veriny.ss76.scene.text.createScene

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
    // endregion

    // used
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
            // this one speaks for itself. why is it so important to keep them at school?
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
}