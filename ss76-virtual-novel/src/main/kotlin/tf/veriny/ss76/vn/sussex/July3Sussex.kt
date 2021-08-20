package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.SS76
import tf.veriny.ss76.scene.text.Newline
import tf.veriny.ss76.scene.text.WordNode
import tf.veriny.ss76.scene.text.buildDateMarkerScene
import tf.veriny.ss76.scene.text.createAndRegisterScene
import tf.veriny.ss76.vn.CommonScenes

// this'll confuse anyone doing decompile dives
private val WHEN_THE_SEX_IS_SUS = """
                     .,..,,*,,..,,,,,,,**                   
                 .*,,...................,*/                 
               ,,...../..,.,,,***/******,,*,*//             
             ,,.  ..,,,,,//((##%%%%%%####(/,,..,*           
           .,*.  ,,****,/((#####%%%&%%#####(/*....          
           *.. .**//***/((((###%%%%&%%####(#(/,....         
          ,,...*****/*/(((#######%%%%%%#####(/*....         
          ., .,****/((((((((((######%%%#####((*....         
           ...***,,,,*///(((((((((((/****//(##/,..,         
           ...,,**,....,,,**/((//**...,,..,*/##,...         
            ,.***.,**   ,.,,(#%#*.,**,.,(/(*/#%*.//         
           /../*,,,*/,,,,,,*(###((/*,,,,/(##//(/,*(         
           .,,***/(((((//***/##(((((////(((###///(%         
           , ,**//(((/****,/((#(((((/***/(((((((#%%         
            .******.,*,****/(((((//(((//**,*(#*(#(.         
              ****,,,**,,,,,****//(((/**,,..,/**            
              **/,/*,.,,,,,*,*/*****#//../*./(/             
               ****/*,,#%#&(%%#&&&@@&&.*(/,(*/              
                ,**//**,.*%#%%%&&##*#**((((//               
                  .*//**,*,(((*(#(%%(/((#(*                 
              .,***,,/***//***/*///((((#((/(#/##            
        .,****.*/* *,,,****///////((((#(*/(((*/##(##%%      
((///***,,****.**.**,,,,,///(((((((#(((*//,/#/(#########(#% 
/*,,,,**,,**/*,/*,,,,***,,*//(((((((/,*//((*,/###########%%#
"""


private const val JULY_3_FORECAST = "It's a sunny day, with no clouds to be seen."
private val JULY_3_DATE_SCENE = buildDateMarkerScene(
    "sussex-july-3-start", "Monday", 3, JULY_3_FORECAST,
    "sussex-july-3-school-1"
)

public fun registerSussexJuly3Scenes() {
    SS76.registerScene(JULY_3_DATE_SCENE)

    createAndRegisterScene("stop-posting-about-amongus") {
        onLoad { SS76.setTopText("WHEN THE IMPOSTER IS SUS :BLUSH:") }
        page {
            val lines = WHEN_THE_SEX_IS_SUS.split("\n")
            for (line in lines) {
                tokens += WordNode(line)
                tokens += Newline
            }
        }

        page {
            line(WHEN_THE_SEX_IS_SUS)
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

            line(
                "You awkwardly hurry through the front gates, your sleeves lightly glued to " +
                "your arms by the body sweat."
            )
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
                "and are connected by four stairwells on each corners and one stairwell directly above " +
                "the reception hall, each one coiling around an elevator."
            )
            newline()


            line(
                "The government of the time gave an absolutely massive grant to build this. " +
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
                "You make your way into the reception hall. The walls and ceiling are a " +
                "pristine white tile. You wonder how they keep it clean."
            )
            newline()

            line("The receptionist glares at you. You've interrupted his crossword. Again.")
            line("You're so inconsiderate.")
            newline()

            line("You ask for the sign-in book.")
            newline()

            line("RCPT: Late again?")
            newline()

            line(
                "You smile weakly and nod. The receptionist does not like you. " +
                "You're pretty sure he's related to a teacher, which is why he works here. He " +
                "doesn't want to do his job."
            )
            newline()

            line(
                "RCPT: I hope your teachers never say anything really important, something you " +
                "need on an exam but haven't learned, which causes you to fail and end up being " +
                "kicked out.",
                leftMargin = 6
            )
            newline()

            line("You mumble something about a free period.")
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

            line("The other kids hated you more than usual for giving them the swine flu.")
            newline()

            line(
                "But this year you've been going back on that. " +
                "No wonder your grades are so terrible."
            )
            newline()

            line(
                "Whilst the school is pretty lax about actually attending lessons, they are " +
                "very diligent about making sure you",
                addNewline = false
            )
            pushSceneButton(CommonScenes.SCHOOL_ATTENDANCE.id, "actually turn up.")
            newline(2)

            line(
                "You sign in late at the front desk so you don't get suicided by the " +
                "Attendance Police later on. "
            )
            newline()
            changeSceneButton("sussex-july-3-school-4", "Time to go to the hideout.")
        }
    }

    // Time to get into the lift.
    createAndRegisterScene("sussex-july-3-school-4") {
        page {
            line("You make your way to the", addNewline = false)
            pushSceneButton(CommonScenes.SCHOOL_WORKING_LIFT.id, "working lift")
            line("and call it.")
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

            line(
                "LBRN: Ah, I've been waiting for these. Thanks for bringing them to me, lad.",
                leftMargin = 6
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
            line(
                "TCHR: These books need to be returned to the library. I'm late for my lesson. " +
                "Can you take them there for me?", leftMargin = 6
            )
            newline()

            line("You agree unhesitatingly. You're such a doormat.")
            newline()

            line("The teacher dumps the", addNewline = false)  // The
            pushSceneButton("sussex-july-3-textbooks", "books")
            line("into your arms.")
            line("Luckily the library is on the same floor. It's a short walk away. ")
            newline()

            line("The", addNewline = false)
            pushSceneButton("sussex-july-3-librarian", "librarian")
            line("is pretty damn slow.")
            newline()

            line("He scans the first book. He sits and stares at the computer screen.")
            line("He scans the second book. He sits and stares at the computer screen.")
            line("He scans the third book. He sits and stares at the computer screen.")
            line("He scans the fourth book. He sits and stares at the computer screen.")
            line("He scans the fifth book. He sits and stares at the computer screen.")
            line("There's thirty books left.")
            newline()
            changeSceneButton("sussex-july-3-school-6", "You don't have time for this.")

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

            line("But with that massive delay, you're certainly going to be the last one " +
                 "there. Char is going to steal your favourite chair again.")
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
                "The padlock was unlocked, confirming that you're at the very least not" +
                "the first one here."
            )
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

            line("Your presence does not go unnoticed. Everyone turns to look at you as you" +
                 "enter the room.")

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
                "It's a good joke, recording the most late you've been to the hideout."
            )
            newline()

            // todo: sideplot Christmas record
            dline(
                "CHAR: Thirty-four minutes and fifty-two seconds! You're such a dummy. " +
                "If you had been just twenty seconds later, you'd beat the Christmas record."
            )

            line("You mention the teacher with the books but Char isn't taking excuses today.")
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

            dline("CHAR: We all know what a number station is. You've explained them before, idiot. Several. Times.")

            dline("ALEX: Well, a number station is something used by ultra-super-secret government spies.")

            line("Here he goes again.")
            newline()

            dline(
                "ALEX: The government transmits strings of numbers to the ultra-super-secret " +
                "spies."
            )

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

            changeSceneButton("sussex-july-3-school-12", "You honestly don't care.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-12") {
        page {
            dline(
                "ALEX: Instead, the government sends out special radio signals that the " +
                "spies pick up."
            )

            dline(
                "CHAR: Are you a spy? I don't see any other reason for this stupid " +
                "explanation."
            )

            line("Alex remains completely unfazed by Char's words.")
            newline()

            dline("ALEX: Well, I've discovered something. Something really cool, and really " +
                  "awesome.")

            line("It's definitely not going to be cool, and really awesome.")
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
                "CHAR: Dummy. How does that prove its nearby? It could just have a strong " +
                "signal."
            )

            line("Char has gotten involved now too.")
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
            dline("CHAR: That was really weird. Please don't do that again, you idiot.")

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
            changeSceneButton("sussex-july-3-school-17", "mysteries!")
        }
    }

    createAndRegisterScene("sussex-july-3-school-17") {
        page {
            dline("ALEX: Number stations are so weird and secret and freaky and spooky!")

            dline(
                "ALEX: I'm gonna go mental if I can't figure this out! I've got to solve " +
                "mysteries!"
            )

            dline(
                "CATE: Isn't the beauty of mysteries not knowing the solution? You would get " +
                "bored rather quickly if you could solve every one of them."
            )

            dline(
                "ALEX: Hmmm... Maybe! But I need to solve this one! I can barely sleep I'm so " +
                "excited about it!"
            )

            line(
                "At that statement, I think I notice Char smirking. But then you quickly snap " +
                 "back to reality."
            )

            dline(
                "ALEX: If anyone has any theories, please please please please please please let " +
                "me know! I'll buy you lunch!"
            )

            line("After that morning commotion, everyone gets back into their")
            changeSceneButton("sussex-july-3-school-18", "regular tasks.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-18") {
        page {
            line("Alex is tinkering with his two laptops, pulling various disgusting faces.")
            newline()

            line("Char is browsing something whilst grooming her immaculate hair.")
            newline()

            line("Cate is typing something. Something very big.")
            newline()

            line("You are playing an idle game. What a waste of time.")
            newline()

            line("Everyone continues their daily activities. The sound of silence fills the " +
                 "room, suffocating out any possible chance at discussion."
            )
            newline()

            line("This is the way everyone likes it.")
            line("No annoyances. No fuss. Just, peaceful silence.")

            changeSceneButton("sussex-july-3-school-19", "Until lunchtime, anyway.")
        }
    }

    // == POST-LUNCH == //
    createAndRegisterScene("sussex-july-3-school-19") {
        page {
            line(
                "Everyone remains in the hideout until lunchtime. The nanosecond the clock ticks over " +
                "to 12:55, everyone but you jumps up to run to the cafeteria."
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
            line("Then he tries to start a conversation.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-20") {
        page {
            dline("ALEX: So! I know you've all been really busy! But I hope somebody gave even " +
                 "a tiny little small miniscule amount of thought to my mystery!")

            dline("CHAR: No, you idiot. Nobody here cares about ")
        }
    }

}