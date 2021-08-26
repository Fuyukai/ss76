package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.SS76
import tf.veriny.ss76.isInsideJar
import tf.veriny.ss76.scene.text.buildDateMarkerScene
import tf.veriny.ss76.scene.text.createAndRegisterScene
import tf.veriny.ss76.vn.CommonScenes
import kotlin.random.Random

private const val JULY_4_FORECAST = "It's a sunny day. It's even hotter than yesterday. " +
                                    "Small clouds break up the skyline. It hasn't rained in weeks."
private val JULY_4_DATE_SCENE = buildDateMarkerScene(
    "sussex-july-4-start", "Tuesday", 4, JULY_4_FORECAST,
    "sussex-july-4-pre-1"
)

public fun registerSussexJuly4Scenes() {
    SS76.registerScene(JULY_4_DATE_SCENE)

    createAndRegisterScene("sussex-july-4-pre-1") {
        onLoad {
            if (isInsideJar()) {
                SS76.changeScene(CommonScenes.END_OF_DEMO)
            }
        }

        page {
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

            line("The neighbour houses are empty, as usual. You can hear the sound of cars " +
                 "from the nearby main road.")
            line("There's not really anyone around.")
            newline()

            changeSceneButton("sussex-july-4-pre-2", "You start walking.")
        }
    }

    createAndRegisterScene("sussex-july-4-pre-2") {
        page {
            line("You have a different route on the walk to school than the walk back.")
            newline()

            line("The walk from school cuts through the heath, but the walk to school doesn't.")
            newline()

            line("The exit you use from the heath is very steep uphill.")
            newline()

            pushSceneButton(
                CommonScenes.FELL_DOWN_HEATH.id,
                "You've already fallen down it before,"
            )
            line("so you don't want to go\ndown there again.")
            newline()

            line("Luckily, there's a smaller", addNewline = false)
            changeSceneButton("sussex-july-4-pre-3", "shortcut")
            line("you can take.")
            newline()

            // Sus? Sus amongus?
            line(
                "The normal route isn't an option; you would have to dodge cars on the road as " +
                "there's no pavement."
            )
        }
    }

    // todo: call back to this.
    createAndRegisterScene("i-hate-gorse") {
        page {
            line("Ulex europaeus. Bastard plant.")
            newline()

            line(
                "There's nothing worse than going back to school after the summer holiday and " +
                "finding one of these has extended its horrible little tendril across your walking " +
                "route."
            )
            newline()

            line(
                "You don't care about mosquitos or wasps. It would be better for humanity if " +
                "all the funding wasted on malaria went to making the common gorse extinct."
            )
            newline()

            line("The gorse remains ignorant of its impending doom at our hand.")
            line("Soon, it'll claim its last victim.", shake = true)
            newline()

            backButton()
        }
    }

    createAndRegisterScene("sussex-july-4-pre-3") {
        page {
            line(
                "Unfortunately, today the shortcut is covered in muddy puddles. It's five " +
                "minutes less and far less treacherous than walking on the road. You're already " +
                "late, and you're a coward, so you have no choice."
            )
            newline()

            line("The sides are blocked by those annoying", addNewline = false)
            pushSceneButton("i-hate-gorse", "spiny shrubs,")
            line("so going\naround the puddles isn't an option.")
            newline()

            line("Your shoes are mostly watertight, except for the foot hole, " +
                 "and this water is knee deep.")
            newline()

            line("There's no way around it. You're going to have to walk straight through.")
            newline()

            line(
                "You're no stranger to this. You walk through this puddle every day. You always " +
                "pack a spare pair of socks for a reason."
            )
            newline()

            changeSceneButton("sussex-july-4-pre-4", "You dip your toes in.")
        }
    }

    createAndRegisterScene("sussex-july-4-pre-4") {
        page {
            line("You dip one foot in, slowly. The rubber seals on your shoe are holding.")
            newline()

            line("The mud level rises, slowly, slowly, slowly, as your foot goes deeper.")
            newline()

            line(
                "The mud level is almost at the foot hole. You close your eyes and brace " +
                "yourself as you slowly lower it further."
            )
            newline()

            line(
                "Your foot hits something hard. Slowly, you realise - it's the bottom of the " +
                 "puddle."
            )
            newline()

            changeSceneButton(
                "sussex-july-4-pre-5",
                "These puddles have never been deep."
            )
            newline(2)

            line(
                "You trounce along the rest of the puddles. Your shoes are disgusting, " +
                "but your socks are saved. Good thing you packed extra shoes."
            )
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
                "Your route takes you through the car park at the head of the heath. There's " +
                "a mild smattering of cars; either dog walkers, or parents dropping their lazy " +
                "children off."
            )
            newline()

            line("Suspiciously, an unmarked black van was parked right among the other cars.")
            if (Random.Default.nextInt(1_000_000_000) == 657567) {
                line("When the black van is sus!")
            }

            newline()

            line("You've never seen an unmarked black van. White vans are common. Black vans " +
                 "are common, but they usually have business information on the side.")
            newline()

            // foreshadowing...
            line("It has one of those", addNewline = false)
            pushSceneButton(CommonScenes.SPINNY_VAN_THING.id, "spinny things")
            line("on its roof.")
            newline()

            line("You think it might be a police van. But you're really not sure.")
            newline()

            changeSceneButton(
                "sussex-july-4-pre-6",
                "You give it a good stare as you walk past."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-pre-6") {
        page {
            line(
                "The final part of the heath is across from this car park. " +
                "It's situated directly next to a single carriageway, with an entrance and an " +
                "exit onto the road. There's no footpath, so you have to cross these directly."
            )
            newline()

            line("Sometimes, really stupid drivers like to do sixty mile-per-hour turns " +
                 "straight into the car park.")
            newline()

            line("You notice him too late. He slams on the brakes, stopping just inches from " +
                 "your body.")
            newline()

            line(
                "If the driver had been any later, you'd be nothing more than a pathetic " +
                "little blood splatter on the ground."
            )
            newline()

            changeSceneButton("sussex-july-4-pre-7", "The driver starts yelling.")
        }
    }

    createAndRegisterScene("sussex-july-4-pre-7") {
        page {
            dline(
                "????: What the fuck do you think you're fucking doing you little tosser!",
                shake=true
            )

            line("You just stare at him, pathetically.")
            newline()

            dline("????: Look where you're fucking going! Didn't they teach you to look both " +
                  "fucking ways in little shit school?")

            line("If Char was here, she'd tear him a new one.")
            line("But Char isn't here. It's just you. And you're incapable of " +
                 "standing up for yourself.")
            newline()

            changeSceneButton(
                "sussex-july-4-pre-8",
                "You half-jog away, trying not to cry."
            )
        }
    }

    // call forward to the monologue about charlotte's cat in ending #2
    // future me: make sure to write that. you know what we mean
    val cars = createAndRegisterScene("i-hate-cars") {
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

            line("All drivers should be", addNewline = false)
            line("killed.", shake = true)
            newline()

            backButton()
        }
    }

    createAndRegisterScene("sussex-july-4-pre-8") {
        page {
            line(
                "The heath goes on for a little while longer before it's cut down the middle " +
                "by a dual carriageway."
            )
            newline()

            line(
                "You sit down on a bench and change your shoes. The old ones go in a " +
                "plastic bag to avoid scuffing the inside of your bag."
            )
            newline()

            line("Not that there is anything to be scuffed, is there?")
            newline()

            line("You walk over the bridge over the A-road, looking wistfully at the vehicles " +
                 "driving by.")

            line("When you walked to school with Char, she would always get on about the", addNewline = false)
            pushSceneButton(cars.id, "evils of cars.")

            line("The cars seem to be going")
            changeSceneButton("sussex-july-4-pre-9", "slower than they should be.")
        }
    }

    createAndRegisterScene("sussex-july-4-pre-9") {
        page {
            line("You cross a roundabout, and then cut across a wooded area. It's way shorter " +
                 "than going the long way around."
            )
            newline()

            line("Your route through life is nothing but shortcuts.")
            newline()

            line("Through the tree trunks you see a black car speeding past down the road.")
            newline()

            line("That's far too unsafe. This area is heavily", addNewline = false)
            pushSceneButton(CommonScenes.FOREST_1.id, "forested")
            line(
                "and a\nspeeding car like that could easily veer off and kill a student, " +
                "or worse, a tree."
            )
            newline()

            changeSceneButton("sussex-july-4-pre-10", "That would be a real shame.")
        }
    }

    createAndRegisterScene("sussex-july-4-pre-10") {
        page {
            line(
                "You walk up the hill that your school is on. It's pretty steep. Your legs " +
                "ache slightly as you reach the peak."
            )
            newline()

            line(
                "It's a hot summer day. It's 9AM. You've just arrived at school, which you're " +
                "late for by a few minutes."
            )
            newline()

            line("That's okay. You're always late. Somehow, it doesn't matter how early you leave. " +
                 "But who's going to punish a sixth form student?")
            newline()

            line("You wonder why the teachers even bother to teach in July. It's too hot to " +
                 "pay any attention.")
            newline()

            changeSceneButton("sussex-july-4-school-1", "You enter the reception hall.")
        }
    }

    // == SCHOOL == //
    createAndRegisterScene("sussex-july-4-school-1") {
        page {
            line("The walls are as clean as ever. They glimmer in the sunlight.")
            newline()

            line("There's nobody around today. It's just you, and the stupid receptionist.")
            newline()

            line(
                "The receptionist glares at you. You've interrupted his sudoku. Again. You're " +
                "so inconsiderate."
            )
            newline()

            dline("RCPT: Did you know that modern phones come with several great apps?")

            dline("RCPT: One of those is called 'the alarm'. It helps people like you wake up " +
                  "on time.")

            dline("RCPT: Another is called 'the map'. It helps people like you not get lost and " +
                  "spend twenty minutes walking around aimlessly.")

            line("He hands you the sign-in sheet.", addNewline = false)
            changeSceneButton("sussex-july-4-school-2", "You make your way to the lift.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-2") {
        page {
            line("There's a poster stuck to the lift. You lean in read it, and the lift doors " +
                 "open.")
            newline()

            line("A hand bursts out of the lift and drags you in by the collar.")
            newline()

            line("CHAR:", addNewline = false)
            line("YOU! You're late AGAIN!", shake = true)

            // oops! char fucked up when she made you late
            dline("CHAR: The one day you shouldn't be...")

            line("You're in shock from being abducted. The lift doors close and the lift " +
                 "lurches upwards.")
            newline()

            dline(
                "CHAR: Alex and the others are already here. And, and, you'll never guess what " +
                "that fucking magpie bought in with him."
            )

            line(
                "She's right; you'll never guess. A faint memory bubbles to your mind, of " +
                "another time Char was this angry."
            )
            newline()

            line(
                "The door opens again, this time on the fifth floor. For some reason, it feels " +
                "like it took no time at all to get up here."
            )
            changeSceneButton(
                "sussex-july-4-school-3",
                "You're still attached as Char runs down the corridor."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-3") {
        page {
            line("At Char's speed, you quickly make it to the padlocked door.")
            newline()

            line("Char finally releases her safe grip on your shirt. Your eyes adjust and you " +
                 "take in your surroundings.")
            line("Around you are four people.")
            newline()

            line("Alex is standing, with his hands on some sort of box-y computer.")
            line("Cate is sitting at the table, looking at the computer. Her smile is visible " +
                 "from the back of her head. ")
            line("Char is glaring at the group. Her eyes are close to shooting laser beams.")
            line("There's a fourth person here. Your", addNewline = false)
            pushSceneButton(CommonScenes.FRIENDS_R1_TWO.id, "fourth friend.")
            newline()

            line("The fourth friend turns to", addNewline = false)
            changeSceneButton("sussex-july-4-school-4", "look")
            line("at you and Char.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-4") {
        onLoad {
            SS76.clearScreenColor = Color.PURPLE
        }

        page {
            line(
                "Jessica (or Jess as she likes to be called) and Char hate each-other."
            )
            newline()

            dline("JESS: Hello, Charlotte. It's very unlike you to be late.")

            dline(
                "CHAR: So it was true! There was a rumour amongst the younger children that there " +
                "was a reanimated corpse walking around. I had to investigate, of course."
            )

            dline(
                "JESS: Really! I heard that there was a rumour there was an unrepentant cunt " +
                "hiding her ugly, ugly face in the forbidden corridor."
            )

            dline(
                "CHAR: You're so very smart at academics but you're so very dumb at insults. " +
                "My dearest Jess, what events have led you to grace us with your presence today?"
            )

            dline(
                "JESS: My name is JESSICA, not JESS. You know this. Stop fucking calling me " +
                "that."
            )

            changeSceneButton("sussex-july-4-school-5", "The animosity in the air steadily builds.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-5") {
        page {
            dline("CHAR: Are you here just to piss me off?")

            dline(
                "JESS: No, of course not. I'm here at request of my good childhood friend Alex." +
                "He needed somebody smart today and there's nobody else here that he could rely on."
            )

            dline(
                "CHAR: Of course. The traitor would never dare to show her face again of her " +
                "own will."
            )

            dline("JESS: Maybe if you didn't have had your little tantrum, I would still " +
                  "spend my frees here.")

            dline(
                "CHAR: 'Have had?' Oh dear. You're telling me you got a predicated A* on " +
                "your mocks? I think I better let your teachers know."
            )

            dline("JESS: W-well, it's hard to talk properly when someone of... your decorum is " +
                  "spitting her primitive words at me!")

            line("Nobody asks, but Cate")
            changeSceneButton("sussex-july-4-school-6", "pipes up.")

        }
    }

    createAndRegisterScene("sussex-july-4-school-6") {
        onLoad {
            SS76.clearScreenColor = Color.BLUE
        }

        page {
            dline("CATE: I think it is very lovely that Jessica is helping us out with our " +
                  "mystery today.")

            line("Char turns and sits down in her chair. Jess is acting rather unreasonably, " +
                 "butting in on everyone's business.")

            dline("ALEX: Jessica... Miss Charlotte... have you stopped fighting?")

            dline("CHAR: If Jess has stopped talking, then yes.")

            dline("JESS: Yes Alex, we have. I'm sorry.")

            dline("CHAR: You should be.")

            dline("ALEX: Okay! That's super duper good to hear! Because I've bought something " +
                  "really cool today! That you both need to see!")

            changeSceneButton("sussex-july-4-school-7", "He points at the box.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-7") {
        page {
            dline("ALEX: This is my radio set!")

            dline(
                "ALEX: It's top of the line. It was made in the 1990s, " +
                "which is a super duper long time ago."
            )

            dline(
                "ALEX: It can only listen, not send. But it can listen to literally genuinely " +
                "everything!"
            )

            line("CHAR: That sounds illegal.")
            line("JESS: That sounds illegal.")
            newline()

            dline("CHAR: Jess, please let dearest Alex over here explain.")

            dline("ALEX: It has some output cords here that I can attach to my laptop to " +
                  "record. It's so old that it requires a super special adapter, though!")

            dline("CATE: Did you record any more of", addNewline = false)
            changeSceneButton("sussex-july-4-school-8", "the sound?")
        }
    }

    createAndRegisterScene("sussex-july-4-school-8") {
        page {
            dline("ALEX: I did! I recorded a super duper long sample! It starts when I got " +
                  "home yesterday, and stops when I woke up today.")

            dline(
                "CATE: That is very good to hear. I bought us two sets of headphones, so we can " +
                "listen to it without bothering our other friends."
            )

            line("Suck-up.")
            newline()

            dline("CATE: It would be much appreciated if you two did not fight.")

            dline("JESS: I won't start if Charlotte won't start.")

            dline(
                "CHAR: Why don't you fuck off up some teacher's backside? I'm sure they're " +
                "wondering why their colon feels so empty."
            )

            dline("JESS: I have a free period this morning, and my other two lessons are " +
                  "cancelled.")

            changeSceneButton("sussex-july-4-school-9", "She's going to be here all day. Great.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-9") {
        page {
            line("Char reattaches her grip to your shirt collar and takes you outside.")
            newline()

            line("Some of the lights fail to flicker on, leaving Char's face half shadowed.")
            newline()

            dline("CHAR: I just need a break from Jess. She driv-")

            dline("JESS: IT'S JESSICA, NOT JESS!", shake = true)

            line("You're dragged further up the hall.")

            dline("CHAR: I just need a break from Jess. She drives me spare.")

            line("She drags you up the corridor.")
        }
    }


}