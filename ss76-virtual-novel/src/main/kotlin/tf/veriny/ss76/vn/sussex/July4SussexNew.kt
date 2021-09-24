package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.scene.Inventory
import tf.veriny.ss76.engine.scene.sceneSequence
import tf.veriny.ss76.vn.CommonScenes
import tf.veriny.ss76.vn.items.CommonItemScenes

/**
 * 04/07
 */
public fun registerSussexJuly4Scenes(): Unit = sceneSequence {
    setTopText("SS76 - Route One - 04/07")

    copyAndSetInventory("s4j-inv-start") {
        remove("physics-hw")
    }

    createAndRegisterScene("sussex-july-4-start") {
        page {
            line("Today's date is Tuesday, the 4th of July.")
            newline()

            line("It's a sunny day. It's @pink@even @pink@¬shake¬hotter than yesterday.")
            line(":push:@sky@ Small clouds break up the skyline. :pop:")
            newline()

            line("It's the last day of school today.")
            newline()

            line("It hasn't rained in weeks.")
            newline()

            changeSceneButton("sussex-july-4-pre-1", ">> Next")
        }
    }

    createAndRegisterOnePageScene("sussex-july-4-pre-1") {
        line("It's a hot summer day. It's 8:20am, and you've just left your house.")
        newline()

        line(
            "The sun is beating down on you. You've only been out for a few " +
            "minutes, but you're already disgustingly sweaty."
        )
        newline()

        line(
            "You look across the street. Char's house sits empty. She probably left " +
            "before you today, as she has done every single day for the past couple of years."
        )
        newline()

        line("You've never seen her leave her house." + " ".repeat(30))
        newline()

        line("The neighbouring houses are empty, as usual. You can hear the sound of cars " +
             "from the nearby main road.")
        line("There's not really anyone around.")
        newline()

        changeSceneButton("sussex-july-4-pre-2", "You start walking.")
    }

    createAndRegisterScene("sussex-july-4-pre-2") {
        page {
            line("You take a different route on the walk to than the walk back from school. " +
                 "You cut through the heath on the way back, but go around on the way back.")
            newline()

            line("The exit you use from the heath is really steep uphill.", addNewline = false)
            pushSceneButton(
                CommonScenes.FELL_DOWN_HEATH.id,
                "You've already fallen down it before,"
            )
            line("so you don't want to go down there again.")
            newline()

            line("Luckily, there's a smaller", addNewline = false)
            changeSceneButton("sussex-july-4-pre-3", "shortcut")
            line("you can take.")
            newline()

            line(
                "Most people go around, walking on the road, but Char showed you this little " +
                "clearing a few years ago that's far safer."
            )
        }
    }

    val gorse = createAndRegisterScene("sussex-i-hate-gorse") {
        page {
            line("Ulex europaeus. It's an evil bastard plant.")
            newline()

            line(
                "There's nothing worse than going back to school after the summer holiday and " +
                "finding one of these has extended a horrible little tendril across your walking " +
                "route."
            )
            newline()

            line(
                "It would be better if all the funding wasted on vanity projects like " +
                "eradicating malaria went to eradicating this plant instead."
            )
            newline()

            line("The gorse remains ignorant of its impending doom at our hand.")
            line(":push:¬shake¬ Soon, it'll claim its last victim. :pop:")
            newline()

            backButton()
        }
    }

    createAndRegisterScene("sussex-july-4-pre-3") {
        page {
            line("Today, however, the shortcut is covered in massive, muddy puddles, stretching " +
                 "deep into the inner sanctum of the wildlands.")
            newline()

            line(
                "The sides of the walkway are blocked by those horrible " +
                "`push-scene-${gorse.id}`@linked@shrubs that prickle you if you even dare to brush " +
                "them lightly."
            )
            newline()

            line("It feels like the heath itself is trying to stop you from going further.")
            newline()

            line("When you were younger, you would stomp through puddles with impunity, " +
                 "ruining your socks and almost giving yourself trench foot.")
            newline()

            line("As a nearly adult, though, you recognise the comfort of a good pair of socks.")
            newline()

            line("You turn around and", addNewline = false)
            changeSceneButton("sussex-july-4-pre-5", "make your way back out through the clearing.")
        }
    }


    createAndRegisterScene("sussex-july-4-pre-5") {
        page {
            line(
                "The sun is shining directly in your eyes now. You raise your hand up to try " +
                "and block it out to no avail."
            )
            newline()

            line(
                "The alternative route takes you through the car park at the head of the heath. " +
                "There's a mild smattering of cars; either dog walkers, or parents dropping their lazy " +
                "children off."
            )
            newline()

            line("The assortment of cars is terrifically boring. There's the standard tosser " +
                 "cars - the BMWs and the Audis. There's a handful of 4x4s, undoubtedly driven by " +
                 "people who definitely don't need a 4x4.")
            newline()

            line("There's a couple of bikes chained to a bench. Cyclists deserve to get ran over.")
            newline()

            line("There's an unmarked black van sitting at the end. It has one of those", addNewline = false)
            pushSceneButton(CommonScenes.SPINNY_VAN_THING.id, "spinny things")
            line("on its roof.")
            newline()

            changeSceneButton(
                "sussex-july-4-pre-8",
                "You give it a good stare as you walk past."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-pre-8") {
        page {
            line(
                "The path out of the car park goes on for a little while longer before it's " +
                "cut down the middle by a dual carriageway."
            )
            newline()

            line("You walk over the bridge over the A-road, looking wistfully at the vehicles " +
                 "driving by.")
            newline()

            line("This is a pretty popular suicide spot. One is able to jump out from the dense " +
                 "bushes on either side straight into the path of the oncoming vehicles.")
            newline()


            line("Long ago, when you walked to school with Char, she would always get on about the", addNewline = false)
            pushSceneButton(CommonScenes.CARS.id, "evils of cars")
            line("when you passed this spot.")
            newline()

            line("The cars seem to be going", addNewline = false)
            changeSceneButton("sussex-july-4-pre-9", "a lot faster than they should be.")
        }
    }

    val duck = createAndRegisterOnePageScene("su4j-duck") {
        line(
            "One day, you walked straight into a tree branch, and had a major cut all the way " +
            "up your face."
        )
        newline()

        line("You looked absolutely ridiculous. Nobody enjoyed your Joker impression, at all.")
        newline()

        line(
            "Even your parents laughed at you when they saw you, and they laughed even harder " +
            "when you told them your idiotic accident, and they laughed so hard at your reaction " +
            "they cried too."
        )
        newline()

        backButton()

    }

    createAndRegisterOnePageScene("sussex-july-4-pre-9") {
        line(
            "You cross a roundabout, and then take yet another shortcut across a wooded area."
        )
        newline()

        line(
            "The dirt and leaves beneath you are thrown around in little tornadoes caused by " +
            "the winds."
        )
        newline()

        line(
            "You :push:`push-scene-${duck.id}`@linked@ instinctively duck :pop: under a tree " +
            "branch that doesn't exist."
        )

        line("Through the tree trunks you see a black car blazing past down the road.")
        newline()

        line("That's far too unsafe. This town is heavily", addNewline = false)
        pushSceneButton("side.lost-forest-1", "forested")
        line(
            "and a speeding car like that could easily veer off and kill a student, " +
            "or worse, a tree."
        )
        newline()

        changeSceneButton("sussex-july-4-pre-10", "That would be a real shame.")
    }

    createAndRegisterOnePageScene("sussex-july-4-pre-10") {
        line(
            "You walk up the hill that your school is on. It's pretty steep. Your legs " +
            "ache slightly as you reach the peak."
        )
        newline()

        line(
            "It's 9 o'clock on a hot summer July day. You've just arrived at school. " +
            "It's the last day today, and you're going on holiday tomorrow."
        )
        newline()

        line(
            "You're late just like usual. You really just can't help it."
        )
        newline()

        line("But that's okay. Sixth form students are basically immune to punishment.")
        newline()

        changeSceneButton("sussex-july-4-school-1", "You enter the reception hall.")
    }

    val note = createAndRegisterOnePageScene("su4j-note") {
        line("Dear Late-Boy,")
        newline()

        line("I won't be here tomorrow because I have a summer job. I hope you don't miss me.")
        newline()

        line("The sign-in book is just below the desk.")
        newline()

        line("Fuck you xx")
        newline()

        line("Love from,")
        line("The Receptionist")
        newline()

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-4-school-1") {
        line(
            "It's eerily silent today. You can't even hear the scribbling of pens from the " +
            "office."
        )
        newline()

        line(
            "The receptionist isn't here today. A far prettier " +
            ":push:`push-scene-${note.id}`@linked@ post-it note :pop: replaces his ugly, ugly face."
        )
        newline()

        line("You reach through the glass and awkwardly maneuver your arm below the desk to " +
             "grab the late sign-in book.")
        newline()

        line("It's yesterday's book. I guess you won't be registered today.")
        newline()

        changeSceneButton(
            "sussex-july-4-school-3",
            "You leave it there and walk over to the stairs."
        )
    }

    createAndRegisterOnePageScene("sussex-july-4-school-3") {
        line("Something deep in your mind buzzes. You feel as if you've forgotten something, " +
             "but you've also forgotten what that is.")
        newline()

        line("The ominous pit in your stomach makes you think it was likely to be something " +
             "extremely important, too.")
        newline()

        line("You don't make it to the stairs; the lift beside it catches your attention instead.")
        newline()

        line("The out of order sign and the yellow tape over the door has been finally removed. " +
             "Your prayers have finally been answered, albeit on the worst possible day of the year.")
        newline()

        line(
            "Your finger makes it halfway to the call button before the doors open anyway. " +
            "A flurry of notebook paper shoots out, followed by an"
        )
        changeSceneButton("sussex-july-4-school-4", "extremely firm grip")
        line("on your shirt collar.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-4") {
        line(
            "You fall over into the lift, moving your leg away just before its jaws close " +
            "around it."
        )
        newline()

        dline("CHAR: Oi! Get up! I can't believe you're late on today of all days!")

        line("You involuntarily wince in preparation of a ruler strike.")
        newline()

        dline("CHAR: I had to cover for you. You're lucky I can imitate your pathetic, coward " +
              "voice.")

        line(
            "You're too stupid to realise why you're being scolded, actually. " +
            "You just stare up at her, blankly."
        )
        newline()

        dline(
            "CHAR: Don't you remember? The assembly that, and I quote, " +
            "'will get you expelled if you don't attend'?"
        )

        changeSceneButton("sussex-july-4-school-5", "Well, it looks like you're getting expelled now.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-5") {
        dline(
            "CHAR: Honestly, the head is so full of himself. You didn't miss anything, " +
            "though. Get up!"
        )

        line("She drags you up by the neck, causing a suspicious tearing sound to emanate " +
             "from the bottom of your shirt.")
        newline()

        dline(
            "CHAR: Come on. We've got a computing lesson with the shit teacher today. " +
            "At least it's the only lesson of the day."
        )

        line("Normally, you would go home if you just had frees for the rest of the day. " +
             "But instead the school does this stupid song-and-dance routine with form time at the " +
             "end of the day, and it is mandatory.")
        newline()

        line("CHAR:", addNewline = false)
        changeSceneButton("sussex-july-4-school-6", "I hope you've packed everything for tomorrow.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-6") {
        line("The lift continues its slow descent upwards, eventually dropping you off at the " +
             "second floor, home to the wild IT students.")
        newline()

        line("Computer Science is your one good subject, but your terrible luck means you have " +
             "two horrible teachers.")
        newline()

        line("One doesn't know how to teach, and he's retiring this year.")
        line("The other treats you like little children. Who stops sixth formers from talking " +
             "in a lesson?")
        newline()

        line("Today you have the former, which means at the very least it'll be a fun lesson " +
             "of nothingness. Perfectly fitting for a last day.")
        newline()

        changeSceneButton("sussex-july-4-school-7", "You push open the door.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-7") {
        line("Predictably, that lesson was a complete waste of time. Only three hours stand " +
             "between you and the summer holiday now.")
        newline()

        dline("CHAR: The retard squad said they have some new 'discovery' for us today.")

        dline(
            "CHAR: I told them to meet me in our chemistry room. I need to get one of my mock papers back, too."
        )

        line("Char drags you up the stairs to the fifth floor where your chemistry lessons take place.")
        newline()

        line("She's not on good terms with most of the teachers - she's smarter than all of " +
             "them, after all - but she's good friends with her chemistry teacher, somehow.")
        line("Like all the others, though, he doesn't pay any attention to you.")
        newline()

        changeSceneButton("sussex-july-4-school-8", "He greets her as she walks in.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-8") {
        dline("????: Good morning, Miss Philips. I've got a reply back from the exam board.")

        dline("CHAR: What did they say?")

        dline(
            "????: They said they'll change the marking scheme from next year so that your " +
            "answer would get full marks if you put it in a real exam."
        )

        dline("CHAR: I wouldn't want to lose my 100% correct streak.")

        dline("????: Well, you know how risky it is to cite unreleased research in an A-level paper.")

        line("Her face goes bright red as she sits down.")
        newline()

        line("She takes out one of her notebooks and notes something down.")

        changeSceneButton("sussex-july-4-school-9", "The door clicks open again.")
    }

    val friends = createAndRegisterOnePageScene("common.friends-r1-second") {
        line("You have four friends. (What a loser.)")
        newline()

        line("They are:")
        newline()

        pushSceneButton(
            CommonScenes.CHAR_BIOGRAPHY_1.id,
            "Charlotte 'Char' Philips,"
        )
        line("your favourite friend")

        pushSceneButton(
            CommonScenes.ALEX_BIOGRAPHY_1.id,
            "Alexander 'Alex' Ashton,"
        )
        line("a mosquito given human form")

        pushSceneButton(
            CommonScenes.CATE_BIOGRAPHY_1.id,
            "Catherine 'Cate' Schwartz,"
        )
        line("the most insincere person ever")

        pushSceneButton(
            CommonScenes.JESS_BIOGRAPHY_1.id,
            "Jessica 'Jess' Davies,",
        )
        line("the Big Bang Theory of human beings")  // hehe...
        newline()

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-4-school-9") {
        dline("????: It looks like your friends are here. They came here about ten minutes ago " +
              "asking for you. I have a lesson to teach now; please lock the room when you leave.")

        line("The three stooges and the teacher walk past each other, closing the door behind them.")

        dline("CHAR: What the fuck are you doing here?")

        dline("????: It's nice to see you too, Shartlotte.")

        line("This horrible bitch is your fourth", addNewline = false)
        pushSceneButton(friends.id, "'friend',")
        line("Jessica (or Jess as she likes to be called).")

        dline("CHAR: You've got some nerve showing your face here uninvited after what you did.")

        dline("JESS: I was invited here by Alex, actually. He said he wanted to show me something.")

        changeSceneButton("sussex-july-4-school-10", "The little rat boy pops his head up.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-10") {
        dline("ALEX: Yes! It's true! Jessica is coming on holiday with us too!")

        line("Char's face goes many indescribable colours at this horrific revelation.")
        newline()

        dline("CHAR: What. No. I'm going to be trapped in a house with her for the next " +
              "three weeks?")

        dline("JESS: What. Yes. Come on Charlotte, do you seriously still hold a grudge over " +
              "that one time?")

        dline("CHAR: You ripped that notebook up deliberately.")

        dline("JESS: Well, it's not like it had anything important in it.")

        dline("CHAR: You should kill yourself.")

        changeSceneButton(
            "sussex-july-4-school-11",
            "The argument is interrupted by a gamma ray burst from Alex's direction."
        )
    }

    createAndRegisterOnePageScene("sussex-july-4-school-11") {
        line(
            "He still has that stupid plaster on his head. " +
            "He probably showered with it still on. Ewwww."
        )
        newline()

        dline("ALEX: I hope everyone packed lightly! I've got so so so so so so so so many " +
              "cool things to give you all!")

        dline("CATE: Alex, are you going to tell everyone about our new discoveries?")

        dline("ALEX: Oh! Yes! Let me get everything set up!")

        line("He pulls a laptop out of his bag and goes to fiddle with the projector.")
        newline()

        line("Jess leans in to Char and taps her shoulder.")

        dline("JESS: Hey. I've got a puzzle for you.")

        changeSceneButton("sussex-july-4-school-12", "CHAR: Why are you acting like we're friends?")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-12") {
        dline("JESS: You're so moody. That time of the month?")

        dline("CHAR: Jess, if you keep this up, I will make sure you end up having an accident.")

        dline("JESS: My name is JESSICA. It is NOT Jess. And you don't have the balls.")

        dline("CHAR: Literally. What stupid dumb puzzle did you want?")

        dline("JESS: It's a lateral thinking puzzle. It's 1971, a man cr-")

        dline("CHAR: A moose. He swerves to avoid it and hits a tree.")

        changeSceneButton(
            "sussex-july-4-school-13",
            "Jess leans back, defeated by a superior intellect."
        )
    }

    createAndRegisterOnePageScene("sussex-july-4-school-13") {
        dline("ALEX: Okay! I've got everything ready!")

        dline("CHAR: You idiot. We can't see shit.")

        line("It's too bright, and the projector is really washed out too, so nothing but a " +
             "mess of vague bright colours is visible.")
        newline()

        dline("ALEX: Oops! That's okay! There's nothing important here!")

        dline("CHAR: Then why did you set it up?")

        dline("JESS: He wanted to show us something, obviously. You're so smart, yet you missed that?")

        changeSceneButton("sussex-july-4-deduction-1", "He launches into his explanation anyway.")
    }

    setTopText("SIGNALLING SYSTEM 76")
    clearColour(Color.SLATE)

    createAndRegisterScene("sussex-july-4-deduction-1") {
        page {
            dline("ALEX: Okay! Here we go!")

            dline("CHAR: Wait, wait, wait. Did you invent a stupid catchphrase too?")

            dline("CATE: I think a quick recap is in order, about what we discovered yesterday.")

            dline("CHAR: I already know what you discovered yesterday. You embarrassed me with it.")

            dline("ALEX: It's for the benefit of our guest! She doesn't know it!")

            line("Char gives Jess the side-eye.")
            newline()

            changeSceneButton("sussex-july-4-deduction-2", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-2") {
        page {
            dline(
                "ALEX: Two days ago, I discovered a super duper mysterious signal on my radio set."
            )

            dline(
                "CATE: It has a tone, a voice stating a sequence of numbers, and another tone. " +
                "The message repeats every minute, at seven seconds past."
            )

            dline(
                "ALEX: I only got ten super duper weird minutes of it two days ago, but " +
                "yesterday I recorded hours and hours and hours of it, until I left for school today!"
            )

            dline("CATE: Yes, we have gone over these recordings. Alex will play a sample now.")

            line(
                "Alex walks over and plays a sample from his phone. The counters are six, three, five, " +
                "and fifty-two."
            )
            newline()

            dline("CATE: This was recorded at 18:05 yesterday evening.")

            changeSceneButton("sussex-july-4-deduction-3", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-3") {
        page {
            dline("JESS: Wait. Hold on. I recognise those tones.")

            dline("CHAR: Are they the retard activation noises?")

            dline("JESS: This message has two", addNewline = false)
            pushSceneButton(CommonScenes.DTMF.id, "¬dialogue¬DTMF")
            dline("tones. My dad was a phone engineer and he taught me how to decode these by " +
                  "ear."
            )

            line("What a useless skill.")
            newline()

            dline("JESS: They're both just zero. But why are they DTMF?")

            dline("CHAR: Why do you exist?")

            dline("CATE: 'DTMF'... can you explain what that means?")

            changeSceneButton(
                "sussex-july-4-deduction-4",
                "Jess gives a boring and pointless explanation. It's probably wrong."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-4") {
        page {
            dline("CATE: I see. Then, this message may possibly be related to phones.")

            dline(
                "JESS: Related to phones... Oh! I remember, I was reading a news page, " +
                "and somebody had commented about this weird phone number. It might be related!"
            )

            dline(
                "ALEX: Oh! It's so totally related! A super duper mysterious signal, and a " +
                "super duper mysterious phone number, and super duper mysterious broadband sounds!"
            )

            dline("JESS: It's DT, not BT, silly. I'll pull up the article comments.")

            line("Jess slides over one of Alex's laptops and starts typing.")
            newline()

            dline("JESS: Okay, here. Take a look at the comments.")

            changeSceneButton("sussex-july-4-deduction-5", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-5") {
        page {
            line("Everyone leans in to read the comments, even Char.")
            newline()

            dline(
                "CHAR: Wow. I knew you were a pretty horrible person, but I can't believe " +
                "you're that low."
            )

            dline("ALEX: Why are they talking about cockroaches?")

            dline("CHAR: I'm glad you didn't get to vote in the referendum.")

            dline("ALEX: Isn't Cate part-German? I don't think she's done anything like that...")

            line("Jess goes a shade of bright red.")
            newline()

            dline("JESS: No! Not that comment! The one below it!")

            changeSceneButton("sussex-july-4-deduction-6", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-6") {
        page {
            dline(
                "CATE: This man misdialed a phone number, accidentally dialing something " +
                "that gave a sequence of five numbers and then hung up."
            )

            dline("ALEX: Wow! That sounds like our super duper weird signal!")

            dline("CATE: I have added the comment to my notes.")

            dline(
                "ALEX: Anyway, we discovered some other super duper interesting and really " +
                "exciting stuff!"
            )

            line(
                "It is not 'super duper' interesting. It not even regularly interesting. " +
                "You have no choice but to play along, though."
            )
            newline()

            dline("CATE: We discovered three interesting things about the numbers.")

            changeSceneButton("sussex-july-4-deduction-7", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-7") {
        page {
            dline("CATE: First, we confirmed that these are hourly counters.")

            dline("JESS: Hourly counters? What does that mean?")

            dline(
                "CATE: Oh, my apologies. The numbers decrement by one at regular intervals, " +
                "meaning that they are counting down to something. What that is, we do not know."
            )

            dline(
                "CATE: It would be appreciated if you, or anyone else, did not interrupt our " +
                "explanations, so that we can explain in full."
            )

            line(
                "Cate gives a warm smile. Jess looks away, embarrassed. Serves her right for " +
                "interrupting."
            )
            newline()

            dline(
                "CATE: At three minutes past the hour, each number goes down. This happened " +
                "at 17:03, 18:03, 19:03, 20:03, 07:03, 08:03, and 09:03."
            )

            changeSceneButton("sussex-july-4-deduction-8", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-8") {
        page {
            dline(
                "CHAR: How can you be so sure it's an hourly countdown if there's such a " +
                "massive gap? You two are really rubbish detectives."
            )

            dline(
                "CATE: If you would please let me explain. There is no such gap in the actual " +
                "recording."
            )

            dline(
                "CHAR: So you turned off your radio at 10pm? I'd fire you if you made such a stupid error."
            )

            dline(
                "CATE: No, the radio was on and listening at all times. The recording has no " +
                "gaps in the audio, either."
            )

            dline("CHAR: That doesn't make sense. There's no gap, but there's also a gap?")
            line("JESS: For the first time in your life, shut up and listen.")
            line("CHAR: Nobody asked for your input.")
            line("JESS: Likewise.")
            newline()

            changeSceneButton("sussex-july-4-deduction-9", ">> Next")

        }
    }

    createAndRegisterScene("sussex-july-4-deduction-9") {
        page {
            dline(
                "CATE: The recording software Alex uses embeds timestamps in the recording."
            )

            dline("ALEX: Yeah! It's not really useful... but I don't know how to turn it off!")

            dline(
                "CATE: The last timestamp from yesterday is at 20:59:07. " +
                "The first timestamp from today is at 06:30:07."
            )

            dline(
                "ALEX: I went to bed at half eleven or so. I didn't check the radio because " +
                "I would have to stop recording to see the data."
            )

            dline(
                "ALEX: The radio was definitely on and recording at that time, though. The " +
                "recording light was on."
            )

            dline("CATE: This leads us to our second interesting thing.")

            changeSceneButton("sussex-july-4-deduction-10", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-10") {
        page {
            dline("ALEX: There's somehow nine hours missing from the recording.")

            dline("CHAR: It stopped recording at 9, you didn't notice until you woke up the " +
                  "next day, and sheepishly turned it back on. Then, you didn't tell us because it " +
                  "makes you look like the idiot you are.")

            dline("CHAR: Mystery solved. You're both shit at this.")

            dline(
                "ALEX: No, I am 100% telling the truth! I get woken up by the maids at " +
                "7 o'clock every morning! I couldn't've reset it!"
            )

            dline("CHAR: You're lying.")

            line("Char is cutting through all the nonsense. That's the obvious explanation.")
            newline()

            changeSceneButton("sussex-july-4-deduction-12", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-12") {
        page {
            dline(
                "CATE: I am very certain that Alex did not lie." +
                " The recording has a distinct amount of static noise."
            )

            dline("CATE: This leads us to the third interesting point.")

            dline("CATE: What is this noise that appears? How is it related to the countdown?")

            dline(
                "ALEX: It really hurts your ears to listen to it, even if you turn down the " +
                "volume."
            )

            dline(
                "CATE: The noise appears just before the third number would reach zero. " +
                "We can assume that the third number is then a countdown to this 'noise event', " +
                "and subsequent jump in time."
            )

            dline("ALEX: We still have no clue what the time jump means. It's so super weird!")

            changeSceneButton("sussex-july-4-deduction-13", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-13") {
        page {
            dline("CATE: Unfortunately, recording more just raised even more questions.")

            dline("ALEX: It's so annoying!")

            dline("CATE: Other than a super duper amazingly cool event appearing, it seems like we " +
                  "will have to wait for one of two things.")

            line("CATE: One, if the same recording gap happens tonight.")
            line("CATE: Two, the expiration of the last timer.")
            newline()

            dline("CATE: That's all we have to say on this matter.")

            changeSceneButton("sussex-july-4-school-y-1", "The stupid lecture finally ends.")
        }
    }

    setTopText("SS76 - Route One - 04/07")
    clearColour(Color.BLUE)

    createAndRegisterOnePageScene("sussex-july-4-school-y-1") {
        dline("CHAR: Well, that was great. Are you going to waste any more of my time today?")

        dline(
            "JESS: Personally, I found that very interesting. Maybe you're just too stupid " +
            "for it."
        )

        dline("CHAR: You are literally a humanities student.")

        dline("ALEX: Yeah, she is! So am I! History is so super duper cool to read about!")

        dline("CHAR: Who cares about history? It's a bunch of dead guys who don't matter anymore.")

        dline("JESS: Did you look at that phone number any further?")

        line("CATE: Yes. Unfortunately, it was", addNewline = false)
        changeSceneButton("sussex-july-4-school-y-2", "automatically censored by the comment system.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-2") {
        dline(
            "CATE: We only have six out of the eleven digits available. Three at the " +
            "beginning, three at the end."
        )

        dline(
            "CATE: The three at the beginning are '014'. The three at the end are " +
            "¬shufnum¬666."
        )

        dline(
            "CHAR: Great lead, Jess. That's completely useless." +
            "There's a hundred area codes beginning with 14 and a thousand numbers for each. " +
            "That's nearly two million possible combinations."
        )

        dline("JESS: Well, Charlotte, us humanities students prefer to actually do stuff " +
              "rather than mull about the theories.")

        line("Humanities students also prefer to be unemployed.")
        newline()

        changeSceneButton("sussex-july-4-school-y-3", "Jess starts fiddling with her old, outdated phone.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-3") {
        dline(
            "CHAR: What are you doing? Do you seriously think you can dial all two " +
            "million numbers?"
        )

        dline("JESS: It would only take a million to have a 50% chance.")

        dline(
            "CHAR: You're so stupid. How long do you think it will take to enter in a " +
            "million numbers, dial them, and check if it's the same voice?"
        )

        dline("JESS: I have an autodialer app. At least I'm trying, unlike you.")

        line("Something flashes across Char's face.")
        newline()

        dline(
            "CHAR: An autodialer... That could work. We don't need your stupid solution, " +
            "I can do this properly. Alex, give me that laptop."
        )

        line("Char drags the laptop over to in front of her and starts", addNewline = false)
        changeSceneButton("sussex-july-4-school-y-4", "frantically typing.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-4") {
        dline("ALEX: What are you doing, Miss Charlotte? It looks super duper intense!")

        dline("CHAR: Shut up, worm. I need to concentrate. Actually, give me your debit card.")

        dline("ALEX: Okay! Here you go! Do you need my passwords too?")

        line("Alex tries to hand his card over, but his hand is intercepted by Jess.")
        newline()

        dline("JESS: Excuse me. What the fuck?")

        dline("ALEX: It's cool! Miss Charlotte has never misused my card before!")

        dline("JESS: :push:¬shake¬ What do you mean, BEFORE? :pop:")

        changeSceneButton(
            "sussex-july-4-school-y-6",
            "Char swipes the card from Alex's hand and starts entering the details."
        )
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-6") {
        dline(
            "CHAR: I need to set up a few accounts, but they cost money. It's only a few " +
            "thousand pounds."
        )

        dline(
            "ALEX: Accounts for what? Are you doing some super duper secret harassment work " +
            "again? I don't like it when you do that..."
        )

        dline(
            "CHAR: No, my dear friend. I'm buying phone numbers and writing an autodialer. " +
            "One vastly better than Jess' little app."
        )

        line("Alex's little rat face beams so much you could see it from space.")
        newline()

        dline(
            "ALEX: Wow! That's so super duper epically amazingly cool! With your genius, " +
            "we'll find the number in no time!"
        )

        changeSceneButton(
            "sussex-july-4-school-y-7",
            "Char ignores the pointless praise and keeps typing."
        )
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-7") {
        dline("JESS: Alex, don't give her the money. She's evil.")

        dline("CHAR: I'm not as evil as you.")

        dline("JESS: You're not as pretty as me, either.")

        line("Char smacks Jess' outstretched arm with her ruler and grabs the debit card again.")

        dline("JESS: Ow! What the hell is wrong with you?")

        dline("CHAR: You always interfere with me. Just let me be.")

        changeSceneButton("sussex-july-4-school-y-8", "The room falls into near-silence.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-8") {
        line("The lunch bell rings. Only an hour and a half to go until summer.")
        newline()

        dline("JESS: Oh, that's the lunch bell. I'll go get stuff for everyone. Who wants some food?")

        line("You shake your head. Alex and Cate give the good maid their orders.")

        dline("JESS: Charlotte, do you want me to get you something?")

        dline("CHAR: Will you poison it?")

        dline(
            "JESS: Absolutely, and with something that will make you suffer for as long as " +
            "possible before dying."
        )

        dline("CHAR: No thanks.")

        changeSceneButton("sussex-july-4-school-y-9", "Jess struts out, and Char continues typing.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-9") {
        dline("ALEX: Oh! It's almost the end of the day!")

        dline("CATE: Yes, it is. I am quite excited about tomorrow.")

        dline("ALEX: Miss Charlotte, I'm going to have a driver pick you up at your house. " +
              "Is that okay?")

        dline("CHAR: Yes, yes, shut up.")

        dline("ALEX: Great! Amazing! Fantastic! I'm so excited for you to come and visit!")

        dline("CATE: Yes, it is quite fantastic. I have not had a holiday in years.")

        line("Cate's idea of a holiday is probably 'helping the poor' or other stupid nonsense.")
        newline()

        changeSceneButton("sussex-july-4-school-y-10", "Jess struts back into the room.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-10") {
        dline("JESS: Okay~ I have everyone's food.")

        line("She places down the meals on the workbench and starts eating.")

        dline("CHAR: You know, I spilt some fluorine there the other day.")

        line("Jess spits out the food all over Charlotte. What the fuck is wrong with her?")

        dline("CHAR: Hey! What the fuck was that for??")

        dline("JESS: You said there was fluorine there! I don't wanna get poisoned!")

        dline("CHAR: What kind of secondary school lets students handle fluorine??")

        changeSceneButton(
            "sussex-july-4-school-y-11",
            "Humanities students are so incredibly stupid."
        )
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-11") {
        line("Char stops typing all of a sudden, ceasing the pleasant noise of keyboard clacking.")
        newline()

        dline("CHAR: Okay. It's done. ")

        dline("ALEX: Wow! You've finished the super duper cool autodialer??")

        line("He tries to take the laptop back but he is met with a swift chop.")
        newline()

        dline("ALEX: Whoa! What did I do?!")

        dline("CHAR: Don't. Touch. You might ruin it. Just let it run for a day or so.")

        line("Alex's sheer joy is almost infectious, like a horrible virus. You instinctively " +
             "recoil away from the source of happiness.")
        newline()

        dline("ALEX: Wow!! Thank you so so so so much!!! We're gonna solve this mystery in no time!")

        line("JESS:", addNewline = false)
        changeSceneButton("sussex-july-4-school-y-12", "Speaking of mysteries...")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-12") {
        line("Jess has a twisted and horrible grin spreading over her face.")

        dline("JESS: ... did anyone else see that black van speeding up the hill this morning?")

        dline("CHAR: What black van?")

        dline("JESS: The one parked outside! It looks like a government vehicle...")

        line("Char's face goes white.")

        dline("CHAR: What did you say?")

        dline("JESS: The one parked outside! It looks li-")

        dline("CHAR: Not literally, you fucking retard. Where is it?")

        changeSceneButton("sussex-july-4-school-y-13", "Jess giggles to herself.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-13") {
        dline(
            "JESS: I just told you! It's parked outside! You should really unclog your ugly " +
            "little ears."
        )

        dline("CHAR: I hope you die alone, slowly and painfully.")

        dline("JESS: That's not very nice.")

        dline("CATE: I saw it too. It was in the car park used by the teachers earlier today.")

        dline("ALEX: I didn't see it! I totally wish I did, though!")

        line(
            "Char starts to pack her things into her bag again. She throws her pens into a " +
            "pocket, and delicately places her notebooks inside a plastic bag inside her real bag."
        )
        newline()

        dline("CHAR: See you all tomorrow.")

        dline("JESS: What? Where are you going? It's not home time yet.")

        changeSceneButton("sussex-july-4-school-y-14", "She starts dragging you outside.")
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-14") {
        line("A soft hand grips your own hand. You're pulled back momentarily.")
        newline()

        dline("JESS: Are you going with her too?")

        line("A shiver rises up your spine. You can't find the words, so you just nod.")
        newline()

        dline("JESS: Okay, but one thing...")

        line("She leans over and stares deep into your eyes. Her delicate lips form a slight smile " +
             "as she examines your soul.")
        newline()

        line("You feel the tugging on your collar resume.")
        newline()

        dline("JESS: Nevermind.")

        changeSceneButton(
            "sussex-july-4-school-y-15",
            "She lets go of your hand and sits back in her chair."
        )
    }

    createAndRegisterOnePageScene("sussex-july-4-school-y-15") {
        dline(
            "ALEX: I'm glad Miss Charlotte helped me today. It's a real shame she didn't stay and " +
            "see the numbers..."
        )

        dline("CATE: Charlotte is a super genius. I am sure she already knows what will happen.")

        dline("JESS: Yes... she does seem to be very obstructionist.")

        dline(
            "CATE: Charlotte has her own interests, and we have ours. It is perfectly " +
            "natural."
        )

        dline("JESS: That's not what I mean, though. It's-")

        dline(
            "CATE: I do not think you should talk about her behind her back. It is extremely " +
            "rude."
        )

        dline("JESS: No, seriously. She's dismissive about this constantly. It's almost as if")

        changeSceneButton("sussex-july-4-wh-1", ">> Next")
    }

    createAndRegisterScene("sussex-july-4-wh-1") {
        page {
            line(
                "Char leans over the bridge, lost in thought. The cars below you drive past " +
                "leaving entrails of dust and pollution."
            )
            newline()

            line("CHAR: I really really", addNewline = false)
            pushSceneButton(CommonScenes.CARS.id, "hate cars.")
            newline(2)

            dline("CHAR: You know, if we can walk three miles every day I don't see why " +
                  "adults need to drive.")

            line("Yeah. Cars are terrible. You agree with her. @black@Don't @black@you?")
            newline()

            dline(
                "CHAR: Imagine if this was a railway. You'd see all the fancy trains - " +
                "well, with Southern, mostly just shit trains actually - running past instead. It'd " +
                "be so cool."
            )

            changeSceneButton("sussex-july-4-wh-2",
                "You stare at Char as she leans over. Weirdo."
            )
        }
    }

    // http://www.wcb-ccd.org.uk/perspectif/library/BEH_Report_FINAL%20(1).pdf
    val glasses = createAndRegisterScene("sussex-july-4-glasses") {
        page {
            line("According to the Wales Council for the Blind, 69% of people in the UK wear " +
                 "glasses, and 13% of the population wears contact lenses.")
            newline()

            line(
                "Overall, 74% of people in the UK either wear some sort of corrective lenses, " +
                "or have had laser eye surgery."
            )
            newline()

            line(
                "This means that it is perfectly average to wear glasses. In fact, if you don't " +
                "wear glasses, you're a freak!"
            )
            newline()

            backButton()
        }
    }

    createAndRegisterScene("sussex-july-4-wh-2") {
        page {
            line("Char is perfectly average.")
            newline()

            line(
                "She has medium-length hair. Despite it being the summer, she still has her " +
                "winter paleness. She's average height. Her uniform fits her perfectly averagely."
            )
            newline()

            line("Average eyes. Not too colourful, but not too dull. Like", addNewline = false)
            pushSceneButton(glasses.id, "most people")
            line("she wears brown-framed glasses.")
            newline()

            line(
                "It's good to be average. One doesn't stick out as much if you're average. " +
                "Nobody's been harassed before for being average."
            )
            newline()

            line("CHAR:", addNewline = false)
            changeSceneButton(
                "sussex-july-4-wh-3", "There's been a lot of weird stuff recently."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-wh-3") {
        page {
            dline("CHAR: That stupid radio signal. The black van.")

            dline("CHAR: And suddenly, Jess decides to butt in again after months.")

            dline("CHAR: It's all so annoying.")

            line("She pushes herself up and faces you.")
            newline()

            dline("CHAR: Hey. If you notice anything else weird, you'll let me know, won't you?")

            line("You nod. Of course you will.")
            newline()

            dline("CHAR: Yeah. That's why we're best friends. Oh, this reminds me.")

            changeSceneButton("sussex-july-4-wh-4", "She reaches into her pocket.")
        }
    }

    copyAndSetInventory("s4j-inv-rock") {
        put("rock", CommonItemScenes.ROCK_ITEM)
    }

    // the rock that saves you from the end of the universe
    createAndRegisterScene("sussex-july-4-wh-4") {
        page {
            dline("CHAR: Take this. It's special.")

            line("She hands you a smooth stone. It's deep black, like a chunk of obsidian.")
            newline()

            line("You roll it around in your hands. It's very light, somehow.")
            newline()

            dline("CHAR: Keep it in your pocket. I made it, just for you. It's from Outside.")

            dline("CHAR: Well... I didn't make it, but I did make what I found into that.")

            dline("CHAR: Just. Don't show anyone else it, and ¬shake¬especially don't tell " +
                  "anyone else I made it for you. And whatever you do, :push:@magenta@ do not drop " +
                  "it. :pop:"
            )

            line(":push:@violet@ The Smooth Stone has been added to your inventory. :pop:")
            newline()

            changeSceneButton("sussex-july-4-wh-5",
                "Char starts walking away. You're gonna get left behind."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-wh-5") {
        page {
            line("You walk together, over the heath. It's getting dark again.")
            newline()

            dline("CHAR: Oh yeah. I'm coming over yours for dinner tonight.")

            line(
                "Your mother is a really good chef. You don't make your own meals usually, " +
                "but whenever Char is around your mother always cooks."
            )
            newline()

            dline(
                "CHAR: I hope she makes that special sauce for her chili tonight. It's my " +
                "favourite."
            )

            line("You continue walking. Up the heath. Cross the road. Down the alley.")
            line("Char is strangely quiet tonight. She has a lot on her mind, probably.")
            newline()

            changeSceneButton("sussex-july-4-wh-6", "You eventually make it to your house.")
        }
    }

    createAndRegisterScene("sussex-july-4-wh-6") {
        page {
            line("It's dark outside now. You unlock the door and open it up.")
            newline()

            line(
                "Your mother walks out from the living room. She's holding a bunch of " +
                "unpacked clothing."
            )
            newline()

            dline("MTHR: Oh, you're home! How was your day?")

            line("Char walks in behind you.")
            newline()

            dline("MTHR: Oh! Well, this is a very pleasant surprise! Hello, Charlotte. How are you?")

            dline("CHAR: I am fantastic, Mrs ¬shuftxt¬fffff.")

            dline(
                "MTHR: Oh, that is just wonderful to hear. I was just about to make dinner! " +
                "Are you staying?"
            )

            line("CHAR:", addNewline = false)
            changeSceneButton("sussex-july-4-wh-7", "If you would be so kind as to let me, yes!")
        }
    }

    createAndRegisterScene("sussex-july-4-wh-7") {
        page {
            line("You and Char sit down at the kitchen table.")
            newline()

            dline("MTHR: Oh, it has been months since you've visited. It's always a joy to have you " +
                  "around.")

            dline(
                "MTHR: And as luck would have it, I'm making chili for dinner. That's your " +
                "favourite, right?"
            )

            line(
                "Char and your parents get on amazingly. They act as if she's their second, " +
                "¬shake¬better child."
            )
            newline()

            line("They chat and joke and laugh and eat and chat and joke and laugh.")
            line("They joke and chat and eat and laugh and chat and joke.")
            line("They eat and chat and eat and chat.")
            line("They joke and joke and joke.")
            line("They laugh and laugh.")
            newline()

            changeSceneButton("su5j-start", "The hours pass away.")
        }
    }
}