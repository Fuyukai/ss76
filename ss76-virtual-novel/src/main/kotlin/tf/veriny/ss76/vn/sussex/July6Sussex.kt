package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.scene.createAndRegisterOnePageScene
import tf.veriny.ss76.engine.scene.createAndRegisterScene

/*
Dear Occupant,

Going out when time doesn't flow is risky. You are lucky that it's only the beginning of this new cycle.

Us maids see a lot that we're not meant to. You're in danger.

Please meet me in the dusty room at midday. Don't let anyone follow you, and don't trust either of what they say.

An observer

--

Dear resident

It is dangerous to go out when the river does not flow. You are lucky you are at the beginning of the cycle.

Maids look a lot about what we do not mean. You are at risk.

Please meet me in a dusty room at noon. Someone should not follow you, and do not trust either of what they say.

Observer
*/

public fun registerSussexJuly6Scenes() {
    createAndRegisterScene("sussex-july-6-start") {
        clearScreenColour = Color.BLUE
        topText = "SS76 - Route One - 06/07"

        page {
            line("Today's date is Thursday, the 6th of July.")
            newline()

            line("It's a :push:@sky@ dark, cloudy day. :pop:")
            line("It hasn't @sky@stopped @sky@raining in days.")
            newline()

            changeSceneButton("sussex-july-6-dream", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-6-dream") {
        page {
            line("Last night, I had a strange dream.")
            newline()

            line("I was a child again, and I had to make a village. There was only one rule " +
                 "- don't touch the buildings that were already there.")
            newline()

            line("So I made a village, and it was good. I liked my village. I liked the people " +
                 "that lived in it. I took good care of them, and I had lots of friends.")
            newline()

            changeSceneButton("sussex-july-6-morning-1", ">> Next")
        }
    }

    createAndRegisterOnePageScene("sussex-july-6-mother-text") {
        line(":push:@yellow@ I need to change this :pop:")

        line("Your mum texted you at around half ten yesterday evening.")
        newline()

        dline("MTHR: Just got a call from someone about you")

        dline("MTHR: Fine if you stay overnight but I would like a heads up")

        dline("MTHR: See if you can borrow some pint glasses your dad dropped one today")

        dline("MTHR: Have fun see you on Saturday xx")

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-1") {


        line(
            "The sound of lightning hitting the lightning rod wakes you up."
        )
        newline()

        line("You pull yourself out from under the (annoyingly thin) blanket and grab for your " +
             "glasses.")
        newline()

        line(
            "The clock on the wall tells you it is 3:33am on the 6th of July. The sun won't " +
            "rise for three hours yet, and breakfast isn't for another hour after that."
        )
        newline()

        line(
            "You lay back down and stare at the ceiling. The loud bang scared you so hard " +
            "you're fully awake now. There's no real chance that you get back to sleep any time " +
            "soon."
        )
        newline()

        line(
            "You pull your phone from its charging dock, and check if anyone else heard it. " +
            "There's only one message; from your `push-scene-sussex-july-6-mother-text`@linked@mother."
        )
        newline()

        changeSceneButton("sussex-july-6-morning-2", "You decide to get up.")
    }

    createAndRegisterOnePageScene("sussex-inset-day") {
        line(
            "Inset days, also known as teacher training days, are days where teachers are " +
            "expected to attend, but students are not."
        )
        newline()

        line("Inset actually means :push:@sky@ in-service training day :pop: although no " +
             "school really uses the term anymore. It's a holdover from your parent's generation.")
        newline()

        line(
            "They're officially designated for schools to train teachers on new technology or " +
            "new curriculums, but in modern Tory Britain their main purpose is for overworked " +
            "teachers to catch up on planning or marking."
        )
        newline()

        line("The older, more bastard teachers also use it to develop new torture techniques " +
             "for use in their 'lessons'.")
        newline()

        line("It's strange to have two inset days in a row in July, though.")
        newline()

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-2") {
        line(
            "It's an `push-scene-sussex-inset-day`@linked@inset day today, so you don't " +
            "have to worry about being tired later on."
        )
        newline()

        line(
            "You slip on the guest slippers to match your guest pajamas. You only brought your " +
            "suit with you so you're having to wear the horribly ugly, non-fitting guest clothing."
        )
        line("The slippers nearly fall off your feet as you open the door and step outside.")
        newline()

        line("It is too dark to see properly, as always. The housekeepers have to walk around " +
             "with torches even during the day. You're lucky that you even have a lamp in your room.")
        newline()

        line(
            "You creep down the corridor, your footsteps echoing faintly behind you. Your " +
            "room is at the very end, so you have to sneak past the other rooms to avoid waking " +
            "anyone up."
        )
        newline()

        changeSceneButton(
            "sussex-july-6-morning-3",
            "The faint smell of cleaning chemicals fills your nose."
        )
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-3") {
        line("The doors on the guest rooms are numbered and have keycard locks, although " +
             "they're not used.")
        newline()

        line(
            "It makes this floor feel like a hotel, rather than a set of guest bedrooms. It " +
            "even has the peculiar 'active silence' of a hotel, as if one was always wearing " +
            "noise-cancelling headphones."
        )
        newline()

        line("Each room has a unique layout and design, too. Number one is Char's room, with " +
             "the large bath in the en suite and the queen sized bed.")
        newline()

        line("Number three is Cate's room. She's even scribbled all over the number in her own " +
             "repulsive handwriting.")
        newline()

        line("Number seven is Jess' room. It'd be really funny if you kicked the door down " +
             "and jumped on her in her sleep and killed her.")
        newline()

        changeSceneButton(
            "sussex-july-6-morning-4",
            "You're too much of a pussy to do that, though."
        )
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-4") {
        line("You make it to the stairwell at the end of the corridor. It's pitch black; the " +
             "lights turn off during the night to save energy.")
        newline()

        line(
            "You shake your phone to turn on its pitiful flashlight and make your way down " +
            "the stairs. Everywhere upstairs is effectively off-limits right now, so the only " +
            "option is the ground floor."
        )
        newline()

        line("You push open the door to the ground rooms and close it behind you again. It " +
             "gives out a pitiful squeak, as if it matches its sound to your personality.")
        newline()

        line("An early morning shift maid slides past you as you walk past, holding an unlit " +
             "cigarette in her right hand. You give her a nod of acknowledgement.")
        newline()

        changeSceneButton("sussex-july-6-morning-5", "She completely ignores you.")
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-5") {
        line(
            "There's not really anything interesting on the ground floor. There's the dining " +
            "rooms with their massive glass doors, sitting somberly untouched since last afternoon."
        )
        newline()

        line("The door to the indoor swimming pool is slightly ajar; it's likely being cleaned.")
        newline()

        line(
            "There's a handful of rooms you assume are just display rooms. They're adorned in " +
            "lots of furniture, ranging from cheap IKEA tat to seemingly bespoke wooden disasters."
        )
        line("There's a rather disturbing amount of dust sitting there when you shine your " +
             "phone light through the windows.")
        newline()

        line(
            "A lot of the rest of the rooms are bedrooms or service rooms for the live-in staff."
        )
        newline()

        line(
            "What kind of nutter has an entire hotel crew living in their house to care for " +
            "two people and the occasional guests?"
        )
        newline()

        changeSceneButton("sussex-july-6-morning-6", "Eventually, you exit the back door.")
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-6") {
        line(
            "The back door opens out onto a covered patio, with a handful of chairs set out " +
            "like a pub garden."
        )
        newline()

        line(
            "The rain is really pouring down. At least it's coming straight down, so you " +
            "won't ruin somebody else's clothes again."
        )
        newline()

        line(
            "There's a handful of housekeeping staff here before their shift begins, chatting " +
            "amongst themselves. They don't seem very happy, but then who would be working here?"
        )
        newline()

        line(
            "You don't have anything else to do, so you close the door behind you and " +
            "take a seat to watch the rain fall into the garden."
        )
        newline()

        changeSceneButton("sussex-july-6-morning-7", "Your shoes are still out there, somewhere.")
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-7") {
        line("It's been :push:@sky@ raining for weeks :pop: now.")
        newline()

        line("You don't really like the rain. Purportedly it makes you moody and depressed, " +
             "but you don't have real emotions, do you?")
        newline()

        line("The staff are still chatting and laughing besides you. They noticed you sitting " +
             "down, but there's no reason to interact with you.")
        newline()

        line("You see a flash of lightning in the sky, followed by the deafening clap of " +
             "thunder not even a second later. Lightning is a beautiful thing, isn't it?")
        newline()

        line("Nature is almost too powerful.")
        newline()

        changeSceneButton(
            "sussex-july-6-morning-8",
            "One of the maids accidentally bumps your head with her elbow."
        )
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-8") {
        dline("????: What are you doing out here at this hour, sir?")

        line("You shrug. That's not an answer.")
        newline()

        dline(
            "????: Well, please close the door behind you next time. Mr Ashton doesn't like cold " +
            "in his house."
        )

        line("You forgot to close the door behind you. You're such an inconsiderate idiot.")
        newline()

        line("The staff all exit, leaving you all alone.")
        newline()

        changeSceneButton("sussex-july-6-morning-9", "Faint words echo in your mind.")
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-9") {
        line(
            "The rain pitter-patters on the tile in front of you, the wind occasionally " +
            "threatening to send it splashing onto you."
        )
        newline()

        line("You lean back and rest your head in your palms. It's really rare for you to get " +
             "a moment by yourself these days.")
        newline()

        line(
            "You think back to what happened yesterday evening, at the gazebo. If the stars " +
            "weren't obscured by the thunderstorm, you might remember Cate's astronomy lesson."
        )
        newline()

        line("Nobody had phone signal, so the situation with the numbers never got resolved.")

        line("Then, there's the weird stuff that ¬shuftxt¬Jess said to you.")
        newline()

        line(
            "But, the thought seems to get plucked out of your mind. It's really hard to " +
            "hear the words in your head again, as if they are fundamentally incompatible with the " +
            "world."
        )
        newline()

        changeSceneButton("sussex-july-6-morning-10", "You just sit and daydream for a while.")
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-10") {
        line("The lights flicker behind you as the housekeeping staff pass by. " +
             "The rain refuses to let up; maybe it never will.")
        newline()

        line("Your phone says it is almost 4 o'clock now. It's really time for you to go back " +
             "to bed. You let out a big yawn in agreement and push your chair back under the table.")
        newline()

        line(
            "The door behind you is still open. Oddly, the maids must have forgotten to close " +
            "it when they left."
        )
        newline()

        line(
            "You close it behind you and walk along the corridor, passing a small handful " +
            "of cleaning staff. They don't acknowledge you."
        )
        newline()

        changeSceneButton(
            "sussex-july-6-morning-11",
            "The stairwell up to the guest rooms is now lit again."
        )
        line("It's still not very bright, though.")
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-11") {
        line(
            "The door to the guest corridor is open too, but there's no staff up here this " +
            "early. They don't want to wake the guests up and suffer their wrath."
        )
        newline()

        line("The lights suddenly stop at the fourth floor, as per usual.")
        newline()

        line("You walk along the corridor once again. It's still so plain and sterile. " +
             "There's nothing interesting here, at all, exactly like before.")
        newline()

        line(
            "The door to your room comes up once again, exactly the same as it was when you left."
        )
        newline()

        line("There's exactly nobody in this hall, exactly the same amount as when you woke up.")

        line(
            "Your bed is messy, exactly as it was when you left it. You shut the door behind " +
            "you and climb into bed."
        )
        newline()

        changeSceneButton(
            "sussex-july-6-morning-12",
            "The door handle rattles and something slides under the door."
        )
    }

    createAndRegisterOnePageScene("sussex-july-6-morning-12") {
        line("You explode out of bed, startled by the attempted home invasion.")
        newline()

        line(
            "An unsealed envelope has been shot under the bed. It looks pristine, aside " +
            "from a muddy formerly oval mark wiped across the front of it."
        )
        newline()

        line(
            "There's nothing else written, and the seal flap dangles off with no attempt made " +
            "to adhere it closed."
        )
        newline()

        line("You rip it open (how terribly brutal!) and examine the paper stuffed inside.")
        newline()

        line(
            "It's a piece of notebook paper, folded over unevenly on the long side, with " +
            "handwritten text extending halfway down."
        )
        newline()

        changeSceneButton("sussex-july-6-morning-13", "You read the letter.")
    }

    createAndRegisterScene("sussex-july-6-morning-13") {
        clearScreenColour = Color.RED
        topText = "..."

        page {
            line("Dear resident")
            newline()

            line(
                "It is dangerous to go out when the river does not flow. " +
                "You are lucky you are at the beginning of the cycle."
            )
            newline()

            line("Maids look a lot about what we do not mean. You are at risk.")
            newline()

            line(
                "Please meet me in a dusty room at noon. Someone should not follow you, and " +
                "do not trust either of what they say."
            )
            newline()

            line("Observer")
            newline(2)

            changeSceneButton(
                "sussex-july-6-morning-14",
                "You rip the door open and peer into the corridor."
            )
        }
    }

    createAndRegisterScene("sussex-july-6-morning-14") {
        clearScreenColour = Color.RED
        topText = "SS76 - Route One - 06/07"

        page {
            line("You look to the left of you. There's nobody there.")
            newline()

            line("You look to the right of you. There's nobody there.")
            newline()

            line("Whoever gave you the letter is gone. You slink back in, uneasy.")
            newline()

            line("The adrenaline wears off and your body starts to ache from tiredness again.")
            newline()

            line(
                "There's nothing left but to go back to sleep for a few hours, and meet " +
                "whoever it was this lunchtime."
            )
            newline()


            //changeSceneButton("sussex-july-6-breakfast-1", ">> Next")
            backButton("-- END OF CURRENT SCENES --")
        }
    }
}