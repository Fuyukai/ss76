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
            line("That's okay. You're always late. Who's going to punish a sixth form student?")
            newline()

            // Actually, I wonder this too.
            line("You wonder why the teachers even bother to teach in July. It's too hot to " +
                 "pay any attention.")
            newline()

            line(
                "You awkwardly hurry through the front gates, your sleeves lightly glued to " +
                "the arms by the body sweat."
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
                "worry; after all, a school of this size can't keep track of all their students."
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
            line("Some of the other kids did not appreciate being infected with the flu, however.")
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

            line("You smile, vacuously. You don't really care for pleasantries.")
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

            line("You sigh, and agree. You're such a doormat.")
            newline()

            line("The teacher places the", addNewline = false)  // The
            pushSceneButton("sussex-july-3-textbooks", "books")
            line("into the arms.")
            line("Luckily the library is on the same floor. It's a short walk away. ")
            newline()

            line("The", addNewline = false)
            pushSceneButton("sussex-july-3-librarian", "librarian")
            line("is not a very fast person.")
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
                "The corridor slowly lit up with the harsh tones of the fluorescent lights " +
                "turning on, detecting someone else stepping foot in the hallowed hall."
            )
            line(
                "If you weren't a regular visitor, you could easily imagine that this floor was " +
                "abandoned. The floors were dusty and the only noises were the hum of server fans."
            )
            newline()

            line(
                "One side of rooms contained the classrooms. These were either the computer " +
                "labs that nobody used, or the science lessons for the"
            )
            pushSceneButton(CommonScenes.FLOOR_5_YEAR7S.id, "upper years")
            // wraps awkwardly without the stray newline...
            line("who were confined up here due to the destructive\ndemonstrations.")
            newline()

            line(
                "The other side contained storage rooms, and one padlocked door contained the " +
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
            line("Your")
            pushSceneButton(CommonScenes.FRIENDS.id, "friends")
            line("will be waiting inside.")
        }
    }

}