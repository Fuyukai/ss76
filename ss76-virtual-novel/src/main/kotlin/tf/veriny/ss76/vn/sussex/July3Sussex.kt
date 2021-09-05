package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.scene.createAndRegisterScene
import tf.veriny.ss76.vn.CommonScenes

//import tf.veriny.ss76.vn.CommonScenes

public fun registerSussexJuly3Scenes() {
    createAndRegisterScene("sussex-july-3-start") {
        topText = "SS76 - Route One - 03/07"

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
            line("That's okay. You're always late. You're an idiot and keep waking up late. " +
                 "But who's going to punish a sixth form student?")
            newline()

            line("You wonder why the teachers even bother to teach in July. It's too hot to " +
                 "pay any attention.")
            newline()

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
                "You're pretty sure he's related to a teacher, which is why he works here."
            )
            newline()

            line("He's a failure, just like you.")

            dline("RCPT: I hope your teachers never say anything really import.")

            dline("RCPT: For example, something you need on an exam but you didn't learn.")

            dline("RCPT: And I really hope it doesn't cause you fail, and end up being kicked out, " +
                  "and causes you to miss our daily chats.")

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

            line(
                "Even during the swine flu pandemic. Most of your classmates never liked you " +
                "again after that winter."
            )
            newline()

            line("Not that they thought highly of you before.")
            newline()

            line("But this year, you've abandoned that. No wonder your grades are so bad.")
            newline()

            line("It's a good thing nobody here really checks up on you.")
            newline()

            changeSceneButton(
                "sussex-july-3-school-4",
                "You sign your name into the late book once again."
            )
        }
    }

    // Time to get into the lift.
    createAndRegisterScene("sussex-july-3-school-4") {
        page {
            line("You amble over to the ", addNewline = false)
            pushSceneButton(CommonScenes.SCHOOL_WORKING_LIFT.id, "working lift")
            line("located at the other end of the hall and call it.")
            newline()

            line("...")
            newline()

            line("...")
            newline()

            line(
                "The lift is taking a long time. Nothing in your life is punctual, but it " +
                "shouldn't be this slow."
            )
            newline()

            line("You reach to call the call button again, but are interrupted by a teacher " +
                 "stepping out carrying a massive pile of textbooks.")
            newline()

            dline("????: Excuse me, could you help me with something? These books need to be " +
                  "returned to the library. I'm late for my lesson, so you need to take them there for me.")

            changeSceneButton(
                "sussex-july-3-school-5",
                "You don't get a chance to disagree."
            )
            line("Not that you would, would you?")
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

            line("He interrupts your thoughts as you walk into the library.")
            newline()

            dline(
                "LBRN: What are you doing? Oh, those are the textbooks I've been waiting on.",
            )

            dline(
                "LBRN: These books bring back memories. I remember seeing these brand new, " +
                "when I was just a wee lad working as an assistant here."
            )

            line(
                "You don't say a word. Responding to elderly people's inane chatter is a " +
                "pointless affair."
            )
            newline()

            backButton()
        }
    }

    createAndRegisterScene("sussex-july-3-school-5") {
        page {
            line(
                "The teacher dumps the pile into your weak little arms. They sag under the " +
                "weight."
            )
            newline()

            line(
                "The library is on the same floor. You're already so late that there's no " +
                "point in rushing there."
            )
            newline()

            line("The", addNewline = false)
            pushSceneButton("sussex-july-3-librarian", "librarian")
            line("is unnecessarily slow. Elderly people are annoying.")
            newline()

            line("He scans the first book. He rambles on.")
            line("He scans the second book. His life story is rubbish.")
            line("He scans the third book. You stop listening.")
            line("There's sixteen books left.")
            newline()

            line(
                "After fifteen minutes, the librarian finally finishes checking the books out. " +
                "You take your leave."
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

            line("The fluorescent lights above you flicker on, one by one.")
            line(
                "If you wasn't a regular visitor, you could easily imagine that this area was " +
                "abandoned. The floors are dusty and the walls are unclean."
            )
            newline()

            line(
                "One side of the wall leads to the classrooms. These range from the old and " +
                "abandoned computer labs (which nobody ever used), to the still-used science labs " +
                "for the", addNewline = false
            )
            pushSceneButton(CommonScenes.FLOOR_5_YEAR7S.id, "upper years")
            line("who are confined up here to experiment using the old and obselete equipment.")
            newline()

            line(
                "The other side contains storage rooms. You don't know what's in these rooms; " +
                 "nobody's ever checked. They're probably unused."
            )
            newline()

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
                "This particular room is a corner room, so it is twice the size of the other " +
                "rooms. It has two exits, but one of them is effectively welded to the door frame by " +
                "eons of dust."
            )
            newline()

            line("You've never been the first one here. Not once since the room was annexed.")
            newline()

            line("Your", addNewline = false)
            pushSceneButton(CommonScenes.FRIENDS.id, "friends")
            line("will be waiting inside.")
            newline()

            changeSceneButton("sussex-july-3-school-9", "You push open the door.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-9") {
        page {
            dline("CHAR: ... and that's why the katana is the dumbest sword for losers.")

            dline("ALEX: Is it only dumb for losers? I think they're super duper cool.")

            dline("CATE: They are very impressive material-wise, though.")

            dline("ALEX: They're really epically cool when they swoosh through the air, too!")

            dline("CHAR: Dummy. Using a katana makes you dumb, and a loser.")

            line(
                "Char is educating everyone on something again. To everyone's annoyance, " +
                "she's always right about basically everything."
            )
            newline()

            line(
                "Your presence goes mostly unnoticed. The discussion continues for a while, " +
                "eventually ending in an explanation of why polearms are for cowards."
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
                "The room is extremely dark, lit up only by the glow of phone screens and " +
                "computer monitors. A handful of requisitioned table lamps sit unused."
            )
            newline()

            line(
                "Everyone sits around a mega-table made from four of those rectangular school " +
                "tables pushed together, forming a large square with a gap in the middle. Cables " +
                "run down into the hole and plug into an assortment of sockets."
            )
            newline()

            line(
                "The old school-issued computers are in a pile in one of the corners. In life, " +
                "they were slow even for when they were introduced, and have been subsequently " +
                "gutted of anything slightly useful by the group members."
            )
            newline()

            line(
                "Instead, everyone has a set of their own computers bought by Alex, ranging " +
                "from laptops to tablets to towers."
            )
            newline()

            changeSceneButton(
                "sussex-july-3-school-new-1",
                "You open yours up and turn it back on."
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-new-1") {
        page {
            line("Char slides over and sits next to you. The other two don't notice you.")
            newline()

            dline(
                "CHAR: What hour do you call this? Not only are you so late today, you don't even say " +
                "hello to me."
            )

            line(
                "You try and explain the situation with the books, but Char cuts you off before you " +
                "get even one stupid word out."
            )
            newline()

            dline("CHAR: Your uniform is a mess. Don't you take any pride in your appearance at all?")

            line(
                "She reaches over and adjusts your tie and collar so they don't look like you " +
                "got dressed whilst paralysed and in the dark."
            )
            newline()

            changeSceneButton(
                "sussex-july-3-school-new-2",
                "Alex and Cate don't notice your humiliation."
            )
        }
    }

    createAndRegisterScene("sussex-july-3-school-new-2") {
        page {
            line(
                "The two idiots mostly keep to their side, and Char mostly keeps to her side."
            )
            newline()

            line(
                "There's usually cross-party negotiations though, nearly always initiated by " +
                "Alex. He really likes to share the recent events in his life for some reason."
            )
            newline()

            line(
                "It's never anything important. He's never had a single worthwhile thought in " +
                "his entire life."
            )
            newline()

            line(
                "Sometimes, though, it's hard not to play along. His enthusiasm grows on you " +
                "like an infected, pus-filled wound."
            )
            newline()

            line("A stray particle flips a bit inside his head and", addNewline = false)
            changeSceneButton("sussex-july-3-school-11", "he shoots to his feet.")
        }
    }


    createAndRegisterScene("sussex-july-3-school-11") {
        page {
            dline("ALEX: Oh! Does anyone here know about number stations?")

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

            line("Maybe he should keep this ultra-super-secret to himself.")
            newline()

            changeSceneButton(
                "sussex-july-3-school-12-1",
                "You're certain he would literally explode if he did that, though."
            )

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
                "you can't just phone someone up and ask them ultra-super-secret details!"
            )

            dline("CATE: Because somebody could be eavesdropping, right?")

            dline("ALEX: Yes! That's why!")

            dline(
                "ALEX: Instead, the government sends out special radio signals that the " +
                "spies pick up."
            )

            dline(
                "CHAR: Are you a spy? I don't see any other reason for this stupid " +
                "explanation."
            )

            dline(
                "ALEX: Well, I've discovered something. Something really cool, and really " +
                "awesome."
            )

            changeSceneButton(
                "sussex-july-3-school-13",
                "It's not going to be cool, or really awesome."
            )

        }
    }

    createAndRegisterScene("sussex-july-3-school-13") {
        page {
            dline("ALEX: I think I've found one nearby!")

            dline("CATE: Wow, really? Where is it?")

            dline("ALEX: I don't know!")

            line("He giggles to himself as if that was the funniest joke ever told.")
            newline()

            dline(
                "ALEX: I know it's nearby because the signal is really, really, really " +
                "strong on my", addNewline = false
            )
            pushSceneButton("side.sussex.alex-radio-0", "radio set.")
            newline(2)

            dline(
                "CHAR: Dummy. How does that prove it's nearby? It could just have a strong " +
                "signal."
            )

            line("Char has gotten involved with this nonsense too, now. ")
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
                "recordings! It takes a while to sort through them!"
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
            line("SIX" + " ".repeat(15))
            line("FOUR" + " ".repeat(15))
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
        clearScreenColour = Color.SLATE
        topText = "SIGNALLING SYSTEM 76"

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
                "ALEX: Yeah! It must mean seventy-seven, not two sevens! It's a super duper " +
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
        clearScreenColour = Color.BLUE
        topText = "SS76 - 03/07"

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
                "through the letterbox. It had a note, saying that you see it too once I've read it."
            )

            dline("CHAR: Give me that.")

            line("Char yanks the letter out of his hand, and starts reading it.")
            newline()

            changeSceneButton("sussex-july-3-school-24", "You try and get a peek in.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-24") {
        page {
            line("To Alex,")
            newline()

            line(":push:¬shuftxt¬ You are a stupid, overeager little rat, aren't you, eh?")
            newline()

            line("I'm pointing at you, I'm pointing at you, but I'm not actually addressing you, " +
                 "I'm addressing the one prat in the country who's bothered to decompile the " +
                 "scene code, take a read and actually work out the rubbish that I'm saying. " +
                 "What a poor, sad life he's got!"
            )
            newline()

            line(
                "Frankly, your dialogue is crap anyway, anybody coulda done it, I hate the lot of you, " +
                "bollocks to you! :pop: "
            )

            line("Yours, a concerned onlooker.")
            newline()

            changeSceneButton(
                "sussex-july-3-school-25",
                "The letters seem to jump around the page as you glimpse it."
            )
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