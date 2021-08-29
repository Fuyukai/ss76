package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.createAndRegisterScene
import tf.veriny.ss76.vn.CommonScenes

//import tf.veriny.ss76.vn.CommonScenes

public fun registerSussexJuly3Scenes() {
    createAndRegisterScene("sussex-july-3-start") {
        onLoad {
            SS76.setTopText("SS76 - Route One - 03/07")
        }

        page {
            line("Today's date is Monday, the 3rd of July.")
            newline()

            line("It's a sunny day, with @sky@no @sky@clouds to be seen.")
            line(":push:@sky@ It hasn't rained in weeks. :pop:")
            newline()

            changeSceneButton("sussex-july-3-school-1", ">> Next")
        }
    }

    // Getting to school
    createAndRegisterScene("sussex-july-3-school-1") {
        page {
            line(
                "It's a hot summer day. It's 9AM. You've just arrived at school, which you're " +
                "late for by a few minutes."
            )
            // Foreshadowing: He's gonna get punished for being late.
            line("That's okay. You're always late. You're an idiot and keep waking up late. " +
                 "But who's going to punish a sixth form student?")
            newline()

            // Actually, I wonder this too.
            line("You wonder why the teachers even bother to teach in July. It's too hot to " +
                 "pay any attention.")
            newline()

            // this awkwardly wraps...
            // throw-away line except to establish the size of the school.
            // why is the school so big? idk, makes it harder to find ppl. signifies well funded,
            // (although it's not, its in decline, how can I link this forward).
            // contrast to the ideal character traits of the MC, who is kinda out of place by being
            // a bit poorer.
            line(
                "There's a few students in the same situation as you. Some are clearly " +
                "panicking; maybe it's their first time being late. You think that they shouldn't " +
                "worry; after all, they can't even catch somebody as serially disrespectful as you."
            )
            newline()

            changeSceneButton(
                "sussex-july-3-school-2-1",
                "You look up at the school."
            )
        }
    }

    // no pages!
    createAndRegisterScene("sussex-july-3-school-2-1") {
        page {
            line(
                "You attend a coed grammar school. Grammar schools are rare sights these days, " +
                "but coed ones are even rarer."
            )
            newline()

            line(
                "It's shaped in a gigantic square. It has six floors, and each floor is " +
                "massive. Each floor has a big gap between its roof and the floor of the one above, " +
                "and is connected by four stairwells on each corner and one stairwell directly above " +
                "the reception hall, each one coiling around an elevator."
            )
            newline()


            line(
                "The government of the time gave out an absolutely massive grant to build this. " +
                "Legend has it, one of the administrators was blackmailing a cabinet " +
                "minister about some less-than-moral wartime activities. He still works here, " +
                "actually."
            )
            newline()

            line(
                "The bottom three floors have windows on the classrooms and the stairs " +
                "connecting them, but the upper three don't."
            )
            newline()

            changeSceneButton(
                "sussex-july-3-school-2-2",
                "The thought of looking out at that height gives you the shivers."
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-2-2") {
        page {
            line(
                "You make your way into the reception hall. The walls and ceiling are tiled " +
                "with pristine white slabs - a hard version of the stereotypical psychiatric hospital " +
                "room walls. You wonder how they keep it clean."
            )
            newline()

            line("The receptionist glares at you. You've interrupted his crossword. Again.")
            line("You're so inconsiderate.")
            newline()

            line("You ask for the sign-in book.")
            newline()

            line("RCPT: ", addNewline = false)
            changeSceneButton("sussex-july-3-school-2-3", "Late again?")
        }
    }

    createAndRegisterScene("sussex-july-3-school-2-3") {
        page {
            line(
                "You smile weakly and nod. The receptionist does not like you. " +
                "You're pretty sure he's related to a teacher, which is why he works here. He " +
                "doesn't want to do his job."
            )
            newline()

            dline(
                "RCPT: I hope your teachers never say anything really important, something you " +
                "need on an exam but haven't learned, which causes you to fail and end up being " +
                "kicked out.",
            )
            newline()

            line("You mumble vaguely about a free period.")
            newline()

            changeSceneButton("sussex-july-3-school-3", "That was a lie.")
        }
    }


    createAndRegisterScene("sussex-july-3-school-3") {
        page {
            line(
                "You've skipped a lot of lessons this year. Before Year 12, you were such a " +
                "goody-two shoes. You had 100% attendance for five years running!"
            )
            newline()

            line("The other kids hated you more than usual when you gave them the swine flu.")
            newline()

            line(
                "But this year you've been going back on that. " +
                "No wonder your grades are so terrible."
            )
            newline()

            line("You sign in late at the front desk, and get going to your")
            changeSceneButton("sussex-july-3-school-4", "hideout.")
        }
    }

    // Time to get into the lift.
    createAndRegisterScene("sussex-july-3-school-4") {
        page {
            line("You make your way to the ", addNewline = false)
            pushSceneButton(CommonScenes.SCHOOL_WORKING_LIFT.id, "working lift")
            line(" and call it.")
            newline()

            line("...")
            newline()

            line("...")
            newline()

            line(
                "You would think that the lift is taking a long time, but your thoughts are " +
                "interrupted by it finally arriving."
            )
            newline()

            line("Unfortunately for you, a teacher steps out carrying a massive pile of " +
                 "textbooks.")
            newline()

            changeSceneButton(
                "sussex-july-3-school-5",
                "TCHR: Excuse me, could you help me with something?"
            )
        }
    }

    createAndRegisterScene("sussex-july-3-textbooks") {
        page {
            line(
                "There's a stack of about twenty books here. They're all an inch thick and " +
                "the stack is really heavy."
            )
            newline()

            line(
                "The textbooks are clearly aged. You wonder if there's even anything modern " +
                "to learn in these anymore."
            )
            newline()
            backButton()
        }
    }

    // this is basically just flavour.
    createAndRegisterScene("sussex-july-3-librarian") {
        page {
            line(
                "The librarian is a very old man. Some of the kids like to joke that he came " +
                "with the building."
            )
            newline()

            line(
                "He really leans into the rumour sometimes. He tells the younger kids stories " +
                "about how there were special rooms built underground for acts that " +
                "'were too bad for detention'."
            )
            newline()

            line("He greets you pleasantly as you walk into the library.")
            newline()

            dline(
                "LBRN: Ah, I've been waiting for these. Thanks for bringing them to me, lad.",
            )
            newline()

            line("You ignore him. How terribly rude. You've never cared for pleasantries.")
            newline()
            backButton()
        }
    }

    // Uh oh! You're delayed. On the Sussex route, he agrees, and ends up late.
    // On the Kent/Suffolk route, he tells the guy to fuck off and keeeps going.
    // This is nothing but a diversion so he can't delete the log before Alex gets in.
    createAndRegisterScene("sussex-july-3-school-5") {
        page {
            dline(
                "TCHR: These books need to be returned to the library. I'm late for my lesson. " +
                "Can you take them there for me?"
            )
            newline()

            line("You agree unhesitatingly. You're such a doormat.")
            newline()

            line("The teacher dumps the ", addNewline = false)  // The
            pushSceneButton("sussex-july-3-textbooks", "books")
            line(" into your arms.")
            line("Luckily the library is on the same floor. It's a short walk away. ")
            newline()

            line("The", addNewline = false)
            pushSceneButton("sussex-july-3-librarian", "librarian")
            line("is unnecessarily slow. Elderly people are annoying.")
            newline()

            line("He scans the first book. He sits and stares at the computer screen.")
            line("He scans the second book. He sits and stares at the computer screen.")
            line("He scans the third book. He sits and stares at the computer screen.")
            line("He scans the fourth book. He sits and stares at the computer screen.")
            line("He scans the fifth book. He sits and stares at the computer screen.")
            line("There's thirty books left.")
            newline()
            changeSceneButton(
                "sussex-july-3-school-6",
                "Good thing your time isn't worth much."
            )

        }
    }

    createAndRegisterScene("sussex-july-3-school-6") {
        page {
            line(
                "After fifteen minutes, the librarian finally finishes checking the books out. " +
                "You take your leave."
            )
            newline()

            line(
                "Normally, you are the first one in your bunking off room. Your friends are " +
                "even later than you - which is saying something."
            )

            line(
                "But with that massive delay, you're certainly going to be the last one " +
                "there. You won't be able to steal away the good chair this time."
            )
            newline()

            changeSceneButton(
                "sussex-july-3-school-7",
                "You get back in the lift and press the five button."
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-7") {
        page {
            line("The lift drops you off at the fifth floor, and you step out into the")
            pushSceneButton(CommonScenes.FLOOR_5_AIR_CON.id, "cold air")
            line("of the fifth floor.")
            newline()

            line(
                "The corridor slowly lights up with the harsh tones of the fluorescent lights " +
                "turning on, detecting someone else stepping foot in the hallowed hall."
            )
            line(
                "If you wasn't a regular visitor, you could easily imagine that this floor was " +
                "abandoned. The floors are dusty and the only noises are the hum of server fans."
            )
            newline()

            line(
                "One side of rooms contains the classrooms. These are either the computer " +
                "labs that nobody used, or the science lessons for the"
            )
            pushSceneButton(CommonScenes.FLOOR_5_YEAR7S.id, "upper years")
            // wraps awkwardly without the stray newline...
            line("who are confined up here due to the destructive\ndemonstrations.")
            newline()

            line(
                "The other side contains storage rooms, and one padlocked door contains the " +
                "school's server rooms. Your hideout is inside one of the reclaimed computer rooms."
            )
            line("You begin the long trek along the corridor.")
            newline()

            changeSceneButton(
                "sussex-july-3-school-8",
                "As you walk, the sound of chatter becomes audible."
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-8") {
        page {
            line(
                "You find the door to your hideout. It's air-proof (after some covert " +
                "modifications) to keep the cold out, and secured by a padlock."
            )
            newline()

            line(
                "The padlock was unlocked, confirming that you're at the very least not " +
                "the first one here."
            )
            newline()

            line("You've never been the first one here. Not once since the room was annexed.")
            newline()

            line("Your", addNewline = false)
            pushSceneButton(CommonScenes.FRIENDS.id, "friends")
            line("will be waiting inside.")

            changeSceneButton("sussex-july-3-school-9", "You open the door.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-9") {
        page {
            dline("CHAR: ... and that's why the katana is the dumbest sword for losers.")

            dline(
                "ALEX: Is it only dumb for losers? Is it cool if I wield it? " +
                "I don't care about carbon, I care about how cool it looks! And how cool it is to " +
                "swoosh it around!"
            )
            dline("CHAR: Dummy. Using a katana makes you dumb, and a loser.")

            newline()

            line(
                "Char is educating everyone on something again. To everyone's annoyance, " +
                "she's always right about basically everything."
            )
            newline()

            line(
                "Your presence is not unnoticed. Everyone rotates to look at you as you " +
                "enter the room."
            )

            newline()

            changeSceneButton(
                "sussex-july-3-school-10",
                "You get the rubbish chair and sit down."
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-10") {
        page {
            line(
                "The room is very dark, lit up only by a couple of desk lamps and the glow of " +
                "computer monitors."
            )
            newline()

            line(
                "The old school-issued computers are in a pile in one of the corners. In life, " +
                "they were slow even for when they were introduced, and have been subsequently " +
                "gutted of anything slightly useful by the group members."
            )
            newline()

            line(
                "Instead, laptops 'acquired' by Alex have been given to everyone. " +
                "Char has three due to her multitasking, Alex has two, Cate has one, and you have " +
                "one."
            )
            newline()

            line(
                "Unfortunately, the internet is really bad up here. Instead, Char installed a " +
                "really cool looking machine that sends some sort of radiation through the floor to " +
                "borrow internet from the lower classrooms."
            )
            newline()

            changeSceneButton(
                "sussex-july-3-school-10-2",
                "Don't stick your fingers in it."
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-10-2") {
        page {
            dline("CHAR: Look who decided to turn up today! Is this a new record?")

            line(
                "Char turns to the 'Lateness World Records' whiteboards behind her. " +
                "It's a good joke, recording the most late you've ever been to the hideout."
            )
            newline()

            // todo: sideplot Christmas record
            dline(
                "CHAR: Thirty-four minutes and fifty-two seconds! You're such an idiot. " +
                "If you had been just twenty seconds later, you'd beat the Halloween record."
            )

            line(
                "You try and mention the teacher with the books, " +
                "but Char isn't taking excuses today."
            )
            newline()

            dline(
                "CHAR: Well, we're all here now. Alex, did you have something you wanted to " +
                "incoherently ramble on about this morning?"
            )

            line(
                "Alex loves to update us on his hobbies. Nobody wants to hear it, but he " +
                "doesn't take no for an answer."
            )
            newline()

            line("ALEX: So,", addNewline = false)
            changeSceneButton(
                "sussex-july-3-school-11",
                "who here knows about number stations?"
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-11") {
        page {
            line("Everyone here knows about number stations. Alex has explained them multiple times before.")
            newline()

            dline("CHAR: We all know what a number station is. You've explained them before, idiot. Several. Times.")

            dline("ALEX: Well, a number station is something used by ultra-super-secret government spies.")

            line("Here he goes again.")
            newline()

            dline(
                "ALEX: The government transmits strings of numbers to the ultra-super-secret " +
                "spies."
            )

            changeSceneButton("sussex-july-3-school-12", "You honestly don't care.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-12-1") {
        page {
            dline("CATE: Why do they do that?")

            line(
                "Cate is trying to be nice and play along. You're sure she hates it just as " +
                "much as you do underneath."
            )
            newline()

            dline(
                "ALEX: Oh! Fantastic question! Well, when you're an ultra-super-secret spy, " +
                "you can't just phone someone up and ask \"what's the deetz, dude?\""
            )

            dline(
                "ALEX: Instead, the government sends out special radio signals that the " +
                "spies pick up."
            )

            changeSceneButton("sussex-july-3-school-13", "Sounds like a load of rubbish.")

        }
    }

    createAndRegisterScene("sussex-july-3-school-12") {
        page {
            dline(
                "CHAR: Are you a spy? I don't see any other reason for this stupid " +
                "explanation."
            )

            line("Alex remains completely unfazed by Char's words.")
            newline()

            dline("ALEX: Well, I've discovered something. Something really cool, and really " +
                  "awesome.")

            line("You think that it's definitely not going to be cool, and really awesome.")
            newline()

            line("ALEX: I've found", addNewline = false)
            changeSceneButton("sussex-july-3-school-13", "one nearby here.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-13") {
        page {
            line(
                "Just as you guessed, it wasn't cool or interesting. " +
                "Sadly, only you and Char share this sentiment."
            )
            newline()

            dline("CATE: Wow, really? Where is it?")

            dline("ALEX: I don't know!")

            line("He giggles, annoyingly.")
            newline()

            dline(
                "ALEX: I know it's nearby because the signal is really, really, really " +
                "good on my", addNewline = false
            )
            pushSceneButton("side.sussex.alex-radio-0", "radio set.")
            newline(2)

            dline(
                "CHAR: Dummy. How does that prove it's nearby? It could just have a strong " +
                "signal."
            )

            line(
                "Char has gotten involved with this nonsense too. " +
                "She can't help but educate people sometimes."
            )
            newline()

            line("ALEX: Well,", addNewline = false)
            changeSceneButton("sussex-july-3-school-14", "take a listen!")
        }
    }

    createAndRegisterScene("sussex-july-3-school-14") {
        page {
            line(
                "Alex unplugs his headphones from one of his laptops, and starts fiddling " +
                "with some nonsense application."
            )
            newline()

            line("Everyone sits there in awkward silence for a minute.")
            newline()

            repeat(3) {
                line("..." + (" ".repeat(20)))
                newline()
            }

            dline(
                "ALEX: Aha! Found it! I've got so many recordings! So many cool and awesome " +
                "recordings!"
            )

            changeSceneButton("sussex-july-3-school-15", "He plays the recording.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-15") {
        page {
            line("A long, high-pitched pulse." + " ".repeat(20))
            newline()

            line("Then, a heavily slowed down song starts playing." + " ".repeat(20))
            newline()

            line("Then, a woman's voice. She says a string of numbers:")
            newline()

            line("SEVEN" + " ".repeat(15))
            line("FOUR" + " ".repeat(15))
            line("SIX" + " ".repeat(15))
            line("SEVEN" + " ".repeat(15))
            line("SEVEN" + " ".repeat(15))
            newline()

            line("Finally, a short high-pitched pulse,", addNewline = false)
            changeSceneButton("sussex-july-3-school-16", "and the sound stops.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-16") {
        page {
            line("Alex is practically shaking in glee.")
            newline()

            dline("ALEX: Don't you wonder what that means? The pulses, do they have meanings?")

            dline("CATE: Maybe the pulses are for synchronisation, of some equipment?")

            line(
                "You bet Cate feels really smart for bringing that up. She always has to " +
                "show off."
            )
            newline()

            dline(
                "ALEX: Whoa. Good thinking! That's totally what's happening. " +
                "But what about the numbers?"
            )

            dline("CHAR: Dummy. Why do you care? These signals aren't for you.")

            line("Char is right. Alex is just eavesdropping.")
            newline()

            dline("ALEX: I have to know! I love", addNewline = false)
            changeSceneButton("sussex-july-3-school-i-1", "mysteries!")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i-1") {
        page {
            dline("ALEX: Number stations are really weird and really secret and really freaky.")

            dline("ALEX: I'm gonna go mental if I can't solve this!")

            dline(
                "CATE: Surely the beauty of mysteries is not knowing the solution? You would get " +
                "bored rather quickly if you could solve every one of them."
            )

            dline(
                "CHAR: That's a stupid statement. What good is a mystery if you can't find " +
                "the answer? That's why I hate those stupid true crime podcasts."
            )

            dline("ALEX: Don't worry! Me and Cate are on the case! We'll figure it out!")

            dline("CHAR: Fine. Go pretend to be an idiotic detective. Just keep it quiet.")

            changeSceneButton("sussex-july-3-school-i-2", "They are not quiet.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i-2") {
        page {
            line(
                "Alex and Cate are on the case. You're sure they won't figure anything out."
            )
            line("Alex has no brain cells, and Cate's are dedicated to being pretty.")
            newline()

            line("They spend their day discussing new theories.")
            newline()

            dline("ALEX: ... what about this super idea ...")
            dline("CATE: ... I don't think so... what about ...")
            dline("ALEX: ... great idea, but what if it's also ...")
            dline("CATE: ... if you look at the spectrogram like this ...")
            dline("ALEX: ... what's seven times six again? ...")

            changeSceneButton("sussex-july-3-school-i-3", "Suddenly, Alex makes a big mistake.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i-3") {
        page {
            line(
                "Alex walks up to the whiteboard. Whilst one half is reserved for Char, " +
                "the other half is also reserved for Char. The second half is empty."
            )
            newline()

            line(
                "Alex grabs the whiteboard pen and starts scribbling. Char immediately " +
                "notices."
            )
            newline()

            // complex
            dline("CHAR: What the ¬shake¬HELL do you think you're doing?")

            line("Char's voice shakes the entire room. Alex jumps five foot into the air.")
            newline()

            dline("ALEX: I'm-I'm- I need to use the whiteboard, Miss Charlotte!!")

            dline("CHAR: ¬SHAKE¬MY whiteboard, you mean!")
            newline()

            changeSceneButton(
                "sussex-july-3-school-i-4",
                "Alex has gone as pale as a sheet."
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-i-4") {
        page {
            dline("ALEX: Please, Miss Charlotte, may I use your whiteboard?!?!?!")
            dline(
                "CHAR: If you ever touch my whiteboard without permission again, the only number " +
                "that will matter to you will be your fucking patient number."
            )
            dline("ALEX: Super okay!")

            line("Alex immediately switches back to his useful annoying self. He scribbles " +
                 "some nonsense on the whiteboard, and takes a step back to admire his art.")

            line(
                "Cate is sitting at the table, still smiling. She is completely unfazed by this " +
                "incident."
            )
            newline()

            line("The pair continue their hollering and jabbering", addNewline = false)
            changeSceneButton("sussex-july-3-school-19", "until lunchtime.")
        }
    }

    // == POST-LUNCH == //
    createAndRegisterScene("sussex-july-3-school-19") {
        page {
            line(
                "The nanosecond the clock ticks over to 12:55, everyone but you jumps up to " +
                "run to the cafeteria."
            )
            newline()

            line(
                "Sixth formers may have priority, but that doesn't stop the little weasel " +
                "Year 10s from trying to steal all the good food first. They're far too emboldened " +
                "by the Year 11s being missing."
            )
            newline()

            line("After five minutes, the group returns with the spoils of war.")
            newline()

            line("Alex has two bags of crisps ransacked from the vending machine.")
            line("Cate has a meat-replacement vegan sausage butty, complete with vegan butter.")
            line(
                "Char has two slices of pizza. She's also responsible for your meal, so she " +
                "brings you back some lukewarm tomato soup."
            )
            newline()

            line("Alex inhales his food first. He eats like a duck. An annoying human duck.")
            line("Then he resumes", addNewline = false)
            changeSceneButton("sussex-july-3-school-i2-1", "tapping away")
            line("at his keyboards.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i2-1") {
        page {
            line(
                "Once Cate finishes her... 'lunch'... she gets her laptop out and starts " +
                "typing something up."
            )
            newline()

            dline("CHAR: Aren't you going to assist the young detective over there?")

            dline(
                "CATE: I am summarising our theories for today. I do hope you enjoy my " +
                "explanations."
            )

            line("Cate gives a massive teethy grin. Detestable.")
            newline()

            dline(
                "CHAR: What... do you... Are you seriously going to bore us to death with " +
                "your nonsense too? Isn't having to listen to your excessive enthusiasm " +
                "punishment enough?"
            )

            dline("ALEX: We've discovered something", addNewline = false)
            changeSceneButton("sussex-july-3-school-i2-2", "really important!")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i2-2") {
        page {
            line(
                "Nothing about this was really important. " +
                "You feel like you have no choice in this, though."
            )
            newline()

            dline(
                "ALEX: I was looking at the file and it turns out I'm accidentally a " +
                "super duper amazing genius!"
            )

            dline("CATE: He really is. I wrote it down here.")

            dline("CHAR: Have you ever had your IQ tested, Alex?")

            dline("ALEX: Yeah! I've done all the super duper cool online IQ tests!")

            dline("CHAR: And what did they say?")

            dline("ALEX: That I'm super duper smart! Now, listen to my", addNewline = false)
            changeSceneButton("sussex-july-3-school-i2-3", "explanations!")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i2-3") {
        onLoad {
            SS76.clearScreenColor = Color.SLATE
            SS76.setTopText("SIGNALLING SYSTEM 76")
        }

        page {
            dline("ALEX: Okay! Here we go!")

            dline(
                "ALEX: I was checking my files, and for some reason there was one really " +
                "extremely long recording."
            )

            dline(
                "ALEX: Turns out, I forgot to stop recording the signal! It goes on for " +
                "ten super duper long minutes!"
            )

            dline(
                "CATE: The recording started at 5:55, and ends at 6:07. " +
                "The signal repeats every minute, at seven seconds."
            )

            dline("CATE: The one we heard today was played at 5:55.")

            line("Cate is talking like she's a BBC news presenter.")
            newline()

            changeSceneButton("sussex-july-3-school-i2-5", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i2-5") {
        page {
            dline("ALEX: However! We noticed something really very interesting!")

            dline("CATE: At 06:03, the message changed. Four of the numbers decremented by one.")

            dline("ALEX: It's a timestamp! The numbers are hours! When the hour ticks over each " +
                  "number changes by one!")

            dline("CATE: It seems most likely that the numbers are a set of distinct countdowns.")

            dline("CATE: We do not know what they are counting down to, or how long each decrement represents.")

            line("Cate was really getting into character. It's almost cute.")
            newline()

            changeSceneButton("sussex-july-3-school-i2-6", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i2-6") {
        page {
            dline("CATE: Interestingly, the fourth number didn't change.")

            dline(
                "ALEX: Yeah! It must mean Seventy-Seven, not two sevens! It's a super duper " +
                "cool double counter!"
            )

            dline(
                "CATE: So, assuming that it is an hourly counter, that gives us a breakdown " +
                "for all of the digits."
            )

            dline(
                "CATE: The first digit reached zero at approximately midnight last night." +
                "The second digit reached zero at 22:03, and the third at 21:03."
            )

            dline("CATE: The fourth and final digit will reach zero at 22:03, on the 6th of July.")

            dline("ALEX: Three days! Three long days! I can barely wait such an extremely ultimately long time!")

            changeSceneButton("sussex-july-3-school-i2-7", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i2-7") {
        page {
            dline("CATE: This raises several questions.")

            dline("ALEX: First! What the hell do the numbers mean!")

            dline("ALEX: Second! Where the hell are the numbers coming from!")

            dline("ALEX: Third! What happens in three days time!")

            dline("CATE: Tonight, Alex will record as much as possible. Tomorrow, we will " +
                  "find if these are truly hourly counters, and what happens when they reset.")

            dline("ALEX: That was our totally awesome explanation!")

            changeSceneButton("sussex-july-3-school-i2-8", "You are not impressed.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i2-8") {
        onLoad {
            SS76.clearScreenColor = Color.BLUE
            SS76.setTopText("SS76 - 03/07")
        }

        page {
            line("Char stares at them for a minute. Then she speaks her heart.")
            newline()

            dline("CHAR: :push:¬shake¬ C l e a n  u p  m y  w h i t e b o a r d. :pop:")
            newline()

            line(
                "Alex jumps up ten feet in the air this time. He grabs the eraser and quickly " +
                "washes his scribbles off of the other side of the whiteboard."
            )
            newline()

            dline(
                "CHAR: Are you done wasting my valuable time with this complete and utter " +
                "drivel now?"
            )

            line("Cate is smiling, still.")
            newline()

            dline("CATE: Yes, we are. I hope you enjoyed it.")

            dline(
                "CHAR: Look. You two can play detective all you want. We want absolutely nothing to do " +
                "with it."
            )

            line("Suddenly, the", addNewline = false)
            changeSceneButton("sussex-july-3-school-23", "home bell rings.")
            line("The two stooges have taken up a\nentire afternoon's worth of time.")
        }
    }

    // Expand this: Alex goes "Also, I have this but I got so excited I forgot",
    // char sees it, goes mad a bit, then things continue. you don't ever get to see what was on the
    // note.
    createAndRegisterScene("sussex-july-3-school-23") {
        page {
            dline("CHAR: We're going home now. Thanks for wasting our time.")

            line("Everyone begins to pack up. Alex looks like he's remembered something.")
            newline()

            dline("ALEX: Oh... yes...")

            line(
                "Alex reaches into his bag and finds an opened but folded envelope. He walks " +
                "up to Char."
            )
            newline()

            dline(
                "ALEX: Miss Charlotte, one of the maids said she found this yesterday, posted " +
                "through the letterbox. It had a note, saying that you should read it."
            )

            dline("CHAR: Give me that.")

            line("Char yanks the letter out of his hand, and", addNewline = false)
            changeSceneButton("sussex-july-3-school-24", "starts reading it.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-24") {
        page {
            line("Char reads the letter intensely.")
            newline()

            line("You can't see it.")
            line("It's right there.")
            line("But you can't see it.")
            line("Your head hurts when you look at it.")
            line("It's right there, and you can see it.")
            line("It's not there. The letter isn't there anymore.")
            line("You try looking back at it, but it doesn't work.")
            line("You turn away from it, but you don't remember doing so.")
            line("You can't see it. It doesn't work, when you try and see it.")
            changeSceneButton("sussex-july-3-school-25", "You didn't see it.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-25") {
        page {
            dline("ALEX: We're really great amazing friends, right?")

            line("Char is clenching her teeth. She's bubbling with rage.")
            newline()

            dline("CHAR: Yes. Yes.. we are.")

            dline("ALEX: Good! I don't believe any of it, anyway.")

            line("With that, he turns and runs out into the corridor.")
            newline()

            line("Cate is still here, about to leave. Char turns to her.")
            newline()

            line("Char lets out a big sigh.")
            newline()

            line("CHAR:", addNewline = false)
            changeSceneButton("sussex-july-3-walk-1", "We'll help you.")
            newline()

            dline("CHAR: With your detective game.")

            line("Cate looks genuinely surprised. You're surprised.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-1") {
        page {
            line(
                "Char insists walking you home every day. You both live on the same street, " +
                "so it makes sense to walk together."
            )
            newline()

            line(
                "It's a mile walk. You trail behind her in silence, as she explains topics " +
                "you're far too stupid to understand. She's very good at explaining, though."
            )
            newline()

            line("You cut through the local", addNewline = false)
            pushSceneButton(CommonScenes.HEATHLAND.id, "heathland")
            line("as a shortcut.")
            line("The smell of burnt plants forces its way into your nose.")
            newline()

            dline(
                "CHAR: Ugh, some idiot probably flicked a cigarette down there. Someone " +
                "just kill all smokers."
            )

            changeSceneButton("sussex-july-3-walk-2", "Your mother was a smoker.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-2") {
        page {
            line(
                "Was. She gave it up ten years ago, so she would be spared. You agree with the " +
                "idea."
            )
            newline()

            line(
                "Char continues about the virtues of smoker genocide until you're at your " +
                 "home road."
            )
            newline()

            line(
                "You live in a small suburb, in a small 2-bedroom terraced council house with " +
                "your parents. Nobody lives to the left of you. Nobody lives to the right of you."
            )
            newline()

            line("Those houses haven't been occupied for as long as you can remember.")
            newline()

            line("Char lives", addNewline = false)
            changeSceneButton("sussex-july-3-walk-3", "across the road from you.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-3") {
        page {
            line(
                "Char's house is much bigger than yours. It has absorbed the two plots " +
                "alongside it to create a six bedroom majesty."
            )
            newline()

            line(
                "Char's parents have installed all this fancy energy saving technology, " +
                "so the windows are always dark from the outside no matter what."
            )
            newline()

            line(
                "It has a massive front garden full of wild flowers and home grown " +
                "vegetables. The flowers are such that something is always in season, year-round, " +
                "making for a stunning display."
            )
            newline()

            line("It makes your house look quite", addNewline = false)
            changeSceneButton("sussex-july-3-walk-4", "pathetic")
            line("in comparison.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-4") {
        page {
            line(
                "Char stands by the side of the road, watching you as you walk to your front " +
                "door."
            )
            newline()

            line("You fumble with your keys, dropping them by accident. You can somehow feel the eye " +
                 "roll behind you.")
            newline()

            line("You enter and close the door behind you. ")
            newline()

            line(
                "It's only just gone 4 o'clock, but it's still surprisingly dark inside."
            )
            newline()

            line(
                "Your parents aren't home. They work until five. They don't pay you very " +
                "much attention anyway."
            )
            newline()

            changeSceneButton("sussex-july-3-walk-5","You make your way to your bedroom.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-5") {
        page {
            line("You look out the window. Your window faces forward.")
            line("Char is still there, looking for you.")
            newline()

            line(
                "You're glad she cares about you enough to see if you've gone upstairs. " +
                "You wouldn't want to trip over, break your neck, and have nobody realise for three " +
                "hours."
            )
            newline()

            line(
                "She gives you a smile, a wave, and walks away to her home. You draw the " +
                "curtains and turn on your lamp. It's almost night-time, and you can barely see."
            )
            newline()

            line("You sit down at your computer.")
            newline()

            line("Your phone starts to ring. The shrill tones hurt your head.")
            newline()

            line("Your mind goes hazy, and you go to bed.")
            newline()

            changeSceneButton("sussex-july-4-start", ">> Next")
        }
    }
}