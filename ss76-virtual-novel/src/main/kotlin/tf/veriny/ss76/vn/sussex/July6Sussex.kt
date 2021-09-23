package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.scene.Inventory
import tf.veriny.ss76.engine.scene.createAndRegisterOnePageScene
import tf.veriny.ss76.engine.scene.createAndRegisterScene
import tf.veriny.ss76.engine.scene.sceneSequence
import tf.veriny.ss76.vn.items.CommonItemScenes

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

public fun registerSussexJuly6Scenes(): Unit = sceneSequence("su6j-") {
    clearColour(Color.BLUE)
    setTopText("SS76 - Route One - 06/07")

    createAndRegisterScene("start") {
        page {
            line("Today's date is Thursday, the 6th of July.")
            newline()

            line("It's a :push:@sky@ dark, cloudy day. :pop:")
            line("It hasn't @sky@stopped @sky@raining in days.")
            newline()

            changeSceneButton("su6j-dream", ">> Next")
        }
    }

    createAndRegisterScene("dream") {
        page {
            line("Last night, I had a strange dream.")
            newline()

            line("I was a child again, and I had to make a village. There was only one rule " +
                 "- don't touch the buildings that were already there.")
            newline()

            line("So I made a village, and it was good. I liked my village. I liked the people " +
                 "that lived in it. I took good care of them, and I had lots of friends.")
            newline()

            changeSceneButton("su6j-morning-1", ">> Next")
        }
    }

    createAndRegisterOnePageScene("mother-text") {
        line("Your mum texted you at around half ten yesterday evening.")
        newline()

        dline("MTHR: Mooring up for the night [pic]")

        dline("MTHR: Really cold here")

        dline("MTHR: Hope you had a good day xx")

        backButton()
    }

    enableLightning()

    createAndRegisterOnePageScene("morning-1") {
        line(
            "The sound of lightning hitting the lightning rod wakes you up with a jolt."
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
            "You lie back down and glare at the ceiling. The noise made you jump so hard " +
            "you're properly awake now. Your whole body is shaking."
        )
        newline()

        line("There's no chance you're getting back to sleep any time soon.")
        newline()

        line(
            "You pull your phone from its charging dock, and check if anyone else heard it. " +
            "There's only one message; from your `push-scene-su6j-mother-text`@linked@mother."
        )
        newline()

        changeSceneButton("su6j-morning-2", "You decide to get up.")
    }

    createAndRegisterOnePageScene("morning-2") {
        line(
            "You slip on your pair of horrible, ugly, absolutely terrible yellow crocs, and " +
            "put on your worn out dressing gown. Between the heavy rain and the constant flow of " +
            "air condition, you find it too bitterly cold to walk around without it."
        )
        newline()

        line(
            "You unlatch the door and swing it open silently. You step out into the hall, " +
            "the carpet crunching beneath you."
        )
        newline()

        line("The hallway is kept really dark at all times - nearly too dark to see. " +
             "The housekeepers have to walk around with torches even during the day. " +
             "You're lucky that you even have a lamp in your room."
        )
        newline()

        line(
            "You creep down the corridor, your footsteps echoing faintly behind you. Your " +
            "room is at the very end, so you have to sneak past the other rooms to avoid waking " +
            "anyone up."
        )
        newline()

        changeSceneButton(
            "su6j-morning-3",
            "The faint smell of cleaning chemicals fills your nose."
        )
    }

    createAndRegisterOnePageScene("morning-3") {
        line("The doors on the guest rooms are numbered and have keycard locks, although " +
             "they're not used.")
        newline()

        line("It makes this floor feel like a hotel, not a place for guests. " +
             "The atmosphere seems to actively suck any and all sound out of it, with only the " +
             "whooshing of air currents left unscathed.")
        newline()

        line("Each room has a unique layout and design. Number one is Char's room, with " +
             "the large and fancy bath in the en suite and the queen sized bed, fit for royalty.")
        newline()

        line("Number three is Cate's room. She's even scribbled all over the number in her own " +
             "repulsive handwriting.")
        newline()

        line("Number seven is Jess' room. It'd be really funny if you kicked the door down " +
             "and jumped on her in her sleep and killed her slowly and painfully.")
        newline()

        changeSceneButton(
            "su6j-morning-4",
            "You're too much of a pussy to do that, though."
        )
    }

    createAndRegisterOnePageScene("morning-4") {
        line("You make it to the stairwell at the end of the corridor. It's pitch black; the " +
             "lights turn off during the night to save energy.")
        newline()

        line(
            "You shake your phone to turn on the onboard flashlight and make your way down " +
            "the stairs. Everywhere upstairs is effectively off-limits right now, so the only " +
            "option is the ground floor."
        )
        newline()

        line("You push open the door to the ground rooms and close it behind you again. It " +
             "gives out a pitiful squeak, as if it matches its sound to your personality.")
        newline()

        line("An early morning shift maid slithers past you as you walk past, holding an unlit " +
             "cigarette in her right hand. You give her a nod of acknowledgement.")
        newline()

        changeSceneButton("su6j-morning-5", "She completely ignores you.")
    }

    createAndRegisterOnePageScene("morning-5") {
        line(
            "There's not really anything interesting on the ground floor. "
        )
        newline()

        line("The door to the indoor swimming pool is slightly ajar; it's likely being cleaned.")
        newline()

        line(
            "There's a handful of rooms that are likely just display rooms. They're adorned in " +
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

        changeSceneButton("su6j-morning-6", "You find the back door and exit through it.")
    }

    createAndRegisterOnePageScene("morning-6") {
        line(
            "The back door opens out onto a covered patio, with a handful of chairs set out " +
            "like a pub garden."
        )
        newline()

        line(
            "The rain is pouring down on the lean-to above, giving a thunderous applause to " +
            "the occupants below."
        )
        newline()

        line(
            "There's a handful of housekeeping staff here before their shift begins, chatting " +
            "amongst themselves. They don't seem very happy, but who would be working here?"
        )
        newline()

        line(
            "You don't have anything else to do, so you close the door behind you and " +
            "take a seat to watch the rain fall into the garden."
        )
        newline()

        line(
            "The occasional lightning flash illuminates the deeper reaches of the garden, " +
            "showing the trees standing guard in the distance."
        )
        newline()

        changeSceneButton("su6j-morning-7", "Your shoes are still out there, somewhere.")
    }

    createAndRegisterOnePageScene("morning-7") {
        line("It's been :push:@sky@ raining for weeks :pop: now.")
        newline()

        line("You don't really like the rain. Purportedly, it makes you moody and depressed, " +
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
            "su6j-morning-8",
            "One of the maids accidentally bashes your head with her elbow."
        )
    }

    createAndRegisterOnePageScene("morning-8") {
        dline("????: What are you doing out here at this hour, sir?")

        line("You shrug with one arm and rub your head with your other arm. That's not an answer.")
        newline()

        dline(
            "????: Well, please close the door behind you next time. Mr Ashton doesn't like cold " +
            "in his house."
        )

        line("You forgot to close the door behind you. You're so inconsiderate.")
        newline()

        line("The staff all exit, leaving you all alone.")
        newline()

        line("Some of the overhead lamps flicker and fade away, as there's nothing worth " +
             "illuminating anymore.")
        newline()

        changeSceneButton("su6j-morning-9", "Faint words echo in your mind.")
    }

    createAndRegisterOnePageScene("morning-9") {
        line(
            "The rain pitter-patters on the tile in front of you, the wind occasionally " +
            "threatening to send it splashing onto you."
        )
        newline()

        line(
            "You lean back and rest your head in your palms. It's rare to get a moment alone " +
            "to yourself like this."
        )
        newline()

        line(
            "You think back to what happened yesterday evening, at the gazebo. If the stars " +
            "weren't obscured by the thunderstorm, you might remember Cate's astronomy lesson."
        )
        newline()

        line("Nobody had phone signal, so the situation with the numbers never got resolved.")
        newline()

        line("Then, there's the weird stuff that ¬shuftxt¬Jess said to you.")
        newline()

        line("The thoughts seem to struggle away from you as quickly as you can think them.")
        newline()

        changeSceneButton(
            "su6j-morning-10",
            "Instead, you just sit and daydream for a while."
        )
    }

    createAndRegisterOnePageScene("morning-10") {
        line("The lights flicker behind you as the housekeeping staff pass by. " +
             "The rain refuses to let up. Maybe it never will.")
        newline()

        line(
            "Your phone says it is almost 4 o'clock now. It's really time for you to go back " +
            "to bed. You let out a big yawn in agreement and push your chair back under the table."
        )
        newline()

        line(
            "The door behind you is still open. The maids must have forgotten to close " +
            "it when they left. They're nothing but disgusting hypocrites."
        )
        newline()

        line(
            "You close it behind you and walk along the corridor, passing a small handful " +
            "of cleaning staff. They refuse to acknowledge you."
        )
        newline()

        changeSceneButton(
            "su6j-morning-11",
            "The stairs going up and down are now lit again."
        )
        line("It's still not very bright.")
    }

    disableLightning()
    createAndRegisterOnePageScene("morning-11") {
        line(
            "The door to the guest corridor is open too, but there's no staff up here this " +
            "early. They don't want to wake the guests up and suffer their wrath."
        )
        newline()

        line("Looking up, the lighting suddenly stops at the third floor.")
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
            "you, latch it closed, and climb into bed."
        )
        newline()

        changeSceneButton(
            "su6j-morning-12",
            "The door handle rattles and something slides under the door."
        )
    }

    createAndRegisterOnePageScene("morning-12") {
        line("You explode out of bed.")
        newline()

        line(
            "An unsealed envelope has been shot under the door. It looks pristine, aside " +
            "from a muddy mark wiped across the face of it."
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

        changeSceneButton("su6j-morning-13", "You read the letter.")
    }

    createAndRegisterScene("morning-13") {
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
                "su6j-morning-14",
                "You tear open the door and meekly peer into the corridor."
            )
        }
    }

    copyAndSetInventory("su6j-morning-14") {
        val weirdLetter = Inventory.InventoryItem(
            "WEIRD LETTER",
            CommonItemScenes.WEIRD_LETTER.id,
            CommonItemScenes.WEIRD_LETTER_USE.id,
        )

        put("weird-letter", weirdLetter)
    }

    createAndRegisterScene("morning-14") {
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

            line(":push:@violet@ Weird letter has been added to your inventory. :pop:")

            //changeSceneButton("su6j-breakfast-1", ">> Next")
            changeSceneButton("su6j-aaaaa", ">> Next")
        }
    }

    createAndRegisterOnePageScene("su6j-aaaaa") {
        line("This is the end of the content so far.")
        newline()

        line("There's some Day 4 content beeyond this, but it's rough and unfinished so I " +
             "won't be showing it.")
        newline()

        line("Thanks for reading. ")
    }

    createAndRegisterOnePageScene("breakfast-1") {
        line("The sound of fists hitting the door wakes you up with a jolt.")
        newline()

        line("You pull yourself out of the (annoyingly thin) blanket and grab for your glasses.")
        newline()

        line(
            "The clock on the wall tells you it is 7:41am on the 6th of July. " +
            "The sun rose an hour ago, and breakfast was ten minutes ago."
        )
        newline()

        line("There's a lot of muffled yelling flowing from the door.")
        newline()

        line("You swivel around and slide out of bed, your legs wobbling uneasily beneath you.")
        line(
            "You walk over to the door and unlatch it. It opens and slams into you, knocking " +
            "you off your feet."
        )
        newline()

        changeSceneButton("su6j-breakfast-2", "An extremely angry girl follows it.")
    }

    createAndRegisterOnePageScene("breakfast-2") {
        dline("CHAR: HEY! YOU'RE LATE ¬SHAKE¬AGAIN!")

        dline("CHAR: Do you hate me? Is that why you're constantly late? You want me to suffer, " +
              "don't you?")

        dline("CHAR: Sitting in a room with the three least funny people who have ever " +
              "lived? It's torture. You could sell them to the government for use at black sites.")

        line("You lay spread out on the floor, dazed by the door-on-human assault.")
        newline()

        line("Char gives you a hard kick in the side. You curl over into the fetal position, " +
             "like a stupid little baby.")
        newline()

        dline("CHAR: Get up! You have three minutes before I drag you down there.")

        line("She closes the door, although it's quite obvious she is still standing behind there, " +
             "making sure you actually do get a move on.")
        newline()

        changeSceneButton(
            "su6j-breakfast-3",
            "You take the world's quickest piss and get your dressing gown on again."
        )
    }

    createAndRegisterOnePageScene("breakfast-3") {
        line("The door slams open again, this time narrowly avoiding you.")
        newline()

        dline("CHAR: Time's up!")

        line("You notice the familiar feeling of hand to neck touch shortly before being " +
             "dragged out of the room. You have no shoes on.")
        newline()

        dline("CHAR: Did you forget your shoes? I hope nobody broke any glass up here.")

        line("You half-trip and stumble down the hall as she drags you. The cable of your " +
             "dressing gown wraps itself around your legs, constricting your movement.")
        newline()

        line("Char's stamping and stomping is muffled by the noise of the air swirling.")
        newline()

        changeSceneButton(
            "su6j-breakfast-4",
            "You clamber down the stairwell, nearly tripping in the darkness."
        )
    }

    createAndRegisterOnePageScene("breakfast-4") {
        line("Breakfast is being served in the same dining room as yesterday.")
        newline()

        line("You feel your IQ being dragged down as you enter the room. The other three are " +
             "already sitting here. They stop their discussion " +
             "(presumably it was something completely worthless, as per usual) to glare at you and Char.")
        newline()

        dline("ALEX: Good super duper morning! Did you sleep well!?")

        line("You just nod. Something whispers to you that it would be a bad idea to say anything else.")

        dline("JESS: You're still in your pajamas, Charlotte? How childish~")

        dline("CHAR: I'm on holiday. I have no reasons to change out of them. Besides, Alex is fine with it.")

        dline("ALEX: Yeah! It's super duper cool! I just want everyone to be super duper happy!")

        dline(
            "CATE: It would be nice if you two would not fight so early in the morning. " +
            "We have a big day ahead of us."
        )

        changeSceneButton(
            "su6j-breakfast-5",
            "An entourage of waiters arrive to break up the conversation."
        )
    }

    createAndRegisterOnePageScene("breakfast-5") {
        line("Breakfast is being served in the same dining room as yesterday.")
        line("It's a 'help yourself' fry-up, unlike yesterday's custom meals.")
        newline()

        line("However, there's nothing fancy under the cloches today - only a fantastic glut of fried meat.")
        newline()

        line("There's bacon in a rainbow from mildly seared back bacon to crispy streaky.")
        newline()

        line(
            "There's at least five different types of sausage stacked into pyramids, the fat " +
            "dripping off them into a pile over the platters."
        )
        newline()

        line("A mountain of toast looms over everything else - cooked and buttered to absolute " +
             "perfection.")
        newline()

        changeSceneButton("su6j-breakfast-6", "Your mouth starts to salivate in anticipation.")
    }

    createAndRegisterOnePageScene("breakfast-6") {
        dline("CHAR: Oh my god... It's even better than yesterday...")

        line("Char undergoes carcinisation with the tongs on the table and starts shovelling " +
             "food onto her plate.")
        newline()

        line("Unfortunately, @magenta@some @magenta@people here are absolutely content to ruin " +
             "everything good in this life with their constant moralising.")
        newline()

        dline("CATE: This is quite a lot of food for just five people, is it not?")

        dline("JESS: Looks like Charlotte is going to eat everything by herself.")

        line("Char is too busy chewing to argue, so she just whacks Jess on the nose with her ruler.")

        dline("JESS: Do you have one of those in your pajamas, too?")

        line("A single drop of blood drips down onto Jess' empty plate.")

        dline("ALEX: My dad insists that everyone is well-fed! It's stuck up on the wall in " +
              "the kitchen!")

        changeSceneButton(
            "su6j-breakfast-7",
            "Everyone else takes a selection of food from what's on offer."
        )
    }

    createAndRegisterOnePageScene("breakfast-7") {
        line("There's a lot of gentle eating, and a bit of not-so-gentle eating.")
        newline()

        line("In the end, there's still a sizeable amount of breakfast left over, despite everyone's best effort.")
        newline()

        dline("CHAR: Oh man that's good. This place is like a dream.")

        dline("ALEX: Okay! I'll have the waiters take the leftovers away!")

        line("He opens something on his phone and starts :push:¬shake¬ poking and prodding it. :pop:")
        newline()

        dline(":push:¬shake¬ CHAR: I could stay he- what is... this shaking? :pop:")

        dline(":push:¬shake¬ ALEX: Oh! I totally forgot to tell everyone! :pop:")

        dline(":push:¬shake¬ CATE: This is quite concerning. Surely it cannot be an earthquake? " +
              "They are extremely :pop: rare in this country.")

        dline("ALEX: It's so super duper amazingly cool! I'm gonna show everyone it in a little bit!")

        changeSceneButton("su6j-ug-1", "That is a very concerning statement.")
    }

    createAndRegisterOnePageScene("ug-1") {
        line(
            "Everyone sits for a while to let the food settle. It's not a good idea to run around " +
            "on an empty stomach."
        )
        newline()

        dline("ALEX: Okay, let's go! You're all going to be super duper excited!")

        line("Alex bounds out. Jess and Cate follow him. You and Char remain seated for a little bit.")
        line("She puts her hands on your shoulders.")
        newline()

        dline("CHAR: Do you remember anything from when we went ¬shuftxt¬Outside?")

        line("Your head is shaken. You couldn't remember what they said, even if you tried.")
        newline()

        dline("CHAR: Do you still have the stone?")

        line("You nod your head.")
        newline()

        dline("CHAR: Let's go see what all this stupid fuss is about.")

        changeSceneButton("su6j-ug-2", "She drags you out of the room.")
    }

    createAndRegisterOnePageScene("ug-2") {
        line("You and Char meet up with the rest of the group as they make it to the stairwell.")
        newline()

        dline("JESS: Oh, you're still here? I hoped you had died~")

        dline("CHAR: Oi, rat boy. Where are we going?")

        line("He just giggles, annoyingly. Out of all his annoying habits, that one is close " +
             "to the top ten worst.")
        newline()

        line("He leads everyone up to the second floor, along the corridors, and to a very " +
             "familiar room.")
        newline()

        dline(
            "CHAR: We've already been in here, you dolt. I'm pretty sure a bunch of VR " +
            "equipment can't shake this entire house."
        )

        changeSceneButton("su6j-ug-3", "He says nothing as he pushes the door open.")
    }

    createAndRegisterOnePageScene("ug-3") {
        line("The room is completely empty. Everything from yesterday has been stripped out.")
        line("There's no treadmills - not even an indent in the carpet where they were.")
        line("There's no projector, and no computers, and no cabling.")
        newline()

        dline("CHAR: Wow. You removed stuff. That's truly impressive.")

        line("Alex walks over to the far wall, and starts feeling it up. His hand scrapes up " +
             "and down until he presses a hidden panel.")
        newline()

        line("The entire floor lurches downwards. It starts to make a low rumble, but not the " +
             "one you heard before.")
        newline()

        line("Everyone but Alex and Cate trips and slams into the floor.")
        newline()

        dline("CHAR: Whoa! What the fuck just happened?!?")

        dline("JESS: Hopefully you broke your neck~")

        changeSceneButton("su6j-ug-4", "The entire room is descending.")
    }

    createAndRegisterOnePageScene("ug-4") {
        dline("ALEX: We're going to a super duper secret place!")

        line("The rumble continues. The lights change tone, from a dim white to a dim blue.")
        newline()

        dline("CATE: What happened to the lights? Blue light is bad for your eyes.")

        line("That's a completely useless factoid.")
        newline()

        dline("ALEX: It goes blue to show we're underground!")

        dline("CHAR: Underground?!?!?! The fuck do you mean, underground?")

        dline("ALEX: This room! It's going underground! It's going super duper deep!")

        dline(
            "CHAR: What the fuck?? What kind of house has a room that just fucking sinks into the " +
            "ground randomly??"
        )

        changeSceneButton("su6j-ug-5", "Alex just giggles again.")
    }

    createAndRegisterOnePageScene("ug-5") {
        line("A ding comes from outside the doors, and they slide open automatically.")
        newline()

        line("A blast of cold, aritifical air comes flodding")
        newline()
    }
}