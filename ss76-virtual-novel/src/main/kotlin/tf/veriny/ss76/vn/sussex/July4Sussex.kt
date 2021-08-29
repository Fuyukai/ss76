package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.createAndRegisterScene
import tf.veriny.ss76.vn.CommonScenes
import kotlin.random.Random

public fun registerSussexJuly4Scenes() {
    createAndRegisterScene("sussex-july-4-start") {
        onLoad {
            SS76.setTopText("SS76 - Route One - 03/07")
        }

        page {
            line("Today's date is Tuesday, the 4th of July.")
            newline()

            line("It's a sunny day. It's @pink@even @pink@¬shake¬hotter than yesterday.")
            line(":push:@sky@ Small clouds break up the skyline. :pop:")
            newline()

            line("It hasn't rained in weeks.")
            newline()

            changeSceneButton("sussex-july-4-pre-1", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-pre-1") {
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

            line("The neighbouring houses are empty, as usual. You can hear the sound of cars " +
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
            line(":push:¬shake¬ Soon, it'll claim its last victim. :pop:")
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
                ":push:¬shake¬ ????: What the fuck do you think you're fucking doing you " +
                "little tosser! :pop:",
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

            line("All drivers should be @pink@¬shake¬killed.")
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
            line("There's a poster stuck to the lift. You lean in to read it, and the lift doors " +
                 "open.")
            newline()

            line("A hand bursts out of the lift and drags you in by the collar.")
            newline()

            dline("CHAR: ¬shake¬YOU! You're late ¬shake¬AGAIN!")

            // oops! char fucked up when she made you late
            dline("CHAR: The one day you @violet@shouldn't @violet@be...")

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

            dline("JESS: :push:¬shake¬ IT'S JESSICA, NOT JESS! :pop:")

            line("You're dragged further up the hall.")

            dline("CHAR: I just need a break from Jess. She drives me spare.")

            dline(
                "CHAR: Here, walk with me. I want to avoid her evil bitch aura as much as " +
                "possible."
            )

            line("She drags you", addNewline = false)
            changeSceneButton("sussex-july-4-school-10", "up the corridor.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-10") {
        page {
            line(
                "You are walked up the corridor alongside Char. The sound of teaching can be " +
                "heard from some of the classrooms. Just nonsense about physics."
            )
            newline()

            line("You make it to the opposite corner from your home base and are sat down.")
            newline()

            dline("CHAR: I can't believe Alex summoned her back after what she did.")

            line("Char looks genuinely dejected. You don't blame her. It was a pretty vile thing.")
            newline()

            line("The door behind Char opens, and she falls backwards.")
            newline()

            line("Thirty plus one pairs of eyes", addNewline = false)
            changeSceneButton("sussex-july-4-school-11", "glare at her.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-11") {
        page {
            line("????: ¬shake¬YOU!")
            newline()

            line("The desiccated voice of an old man booms out.")
            newline()

            dline(
                "????: Miss Philips, not only do you have the audacity to miss my lessons, " +
                "but you have decided to interrupt my other lessons too!"
            )

            line("Char quickly recovers to her feet.")
            newline()

            dline(
                "CHAR: Fuck off you old bastard. You're shit at teaching. I've memorised " +
                "every part of this course by myself. I don't need to attend your boring lessons."
            )

            dline(
                "????: How dare you talk to me like that! The student manager will be hearing " +
                "about this!"
            )

            line("CHAR:", addNewline = false)
            changeSceneButton("sussex-july-4-school-12", "I doubt it.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-12") {
        page {
            line("Char slams the door shut and you are dragged away once again.")
            newline()

            line(
                "Char is really smart both academically and generally. She takes " +
                "four",
            )
            pushSceneButton(CommonScenes.A_LEVELS_SCENE.id, "A-levels,")
            line("those being Maths, Physics, Engineering and Computer\nScience.")
            newline()

            line(
                "She aced the mocks this year, too, so she's bound to get into any university " +
                "of her choice, although Char doesn't seem to care much "
            )

            line(
                "She got straight-A* grades at every STEM subject she took at GCSE level. " +
                "She failed the language and history subjects, though, but that was because the " +
                "test simply wasn't a fit for her."
            )
            newline()

            line(
                "Her intelligence seems to be natural, unlike that witch Jess who got hers " +
                "from a life of being a suck-up."
            )
            newline()

            changeSceneButton("sussex-july-4-school-13", "Your feet slide along the floor.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-13") {
        page {
            dline("CHAR: I've had two embarrassments this morning and it's all her fault.")

            line("Char is noticably upset. Her eyes are a little bit red.")

            dline(
                "CHAR: It's only been ten minutes. The idiot squad won't have finished " +
                "fiddling with their stupid radio yet."
            )

            dline("CHAR: I can't go back there now. We'll just have to wait.")

            line("Char slides down the wall. You fall over.")
            newline()

            line("She pulls out her phone and starts reading something. You sit there.")
            newline()

            line("She continues to read.")
            newline()

            changeSceneButton("sussex-july-4-school-14", "She continues to read.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-14") {
        page {
            line("She continues to read.")
            newline()

            line("The sound of rubber on lino can be heard in the distance.")
            newline()

            line("She continues to read.")
            newline()

            line("The sound is getting louder.")
            newline()

            line("She continues to read.")
            newline()

            line("The sound is really close now.")
            newline()

            line("Char puts her phone back into her pocket.")
            newline()

            changeSceneButton("sussex-july-4-school-15",
                "A small annoying child comes barrelling down the corridor."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-15") {
        page {
            dline(
                "ALEX: Miss Charlotte! Where did you go! Jessica said you died but I didn't " +
                "believe her!"
            )

            line(
                "Char rises up from the floor. She snaps back into her usual demeanor immediately"
            )
            newline()

            dline("CHAR: Dummy. How exactly would I have died in the last twenty minutes?")

            dline("ALEX: Jessica said you found a mirror and then killed yourself! I don't know " +
                  "why she says such mean things about you... I wish you two would be friends again!")

            dline(
                "CHAR: Do you have a reason to be here? Your body emits an idiocy field and " +
                "it's disturbing my inner thoughts."
            )

            dline("ALEX: Oh! Yes! We've done some ultra super duper cool analysis! " +
                  "You need to come back and listen!")

            changeSceneButton(
                "sussex-july-4-school-16",
                "Time for another boring explanation."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-16") {
        page {
            line(
                "You resume sliding down the corridor. At this rate, your ugly little shirt " +
                "will have no collar left."
            )
            newline()

            line("Jess is standing outside the door with a shit-eating grin on her face.")
            newline()

            dline("JESS: Eek! A zombie! You're so stricken with guilt, you've come back to life " +
                  "after your tragic suicide!")

            dline("CHAR: Eek! Jess!")

            line("Jess instantly loses the grin. Char pushes Jess out of the way and enters the " +
                 "cave again.")

            dline("CATE: Oh, you are back. I have done a lot of writing. I hope you enjoy it.")

            changeSceneButton(
                "sussex-july-4-school-17",
                "You cannot wait to be thoroughly unimpressed."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-17") {
        page {
            dline(
                "CHAR: It would be good if you three idiots get a move on. If I'm going to waste my " +
                "time, I would prefer to do it in my own way."
            )

            line("Alex and Cate are already engrossed in their computers.")

            line("Char sits down. Then she notices something. Something very bad. She gets back " +
                 "up again.")
            newline()

            line(
                "Jess walks back into the room. Char grabs her on the neck and starts " +
                "shaking her."
            )
            newline()

            line("CHAR: :push:¬shake¬ WHAT DID YOU DO TO MY WHITEBOARD?")
            newline()

            dline("JESS: Get your hands off me you fucking psycho!")

            line("The whiteboard has been wiped completely clean.")
            newline()

            line("Char throttles Jess. Jess desperately tries to break the chokehold.")
            newline()

            changeSceneButton(
                "sussex-july-4-school-18",
                "Char releases her, and sits back down."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-18") {
        page {
            line("Char has calmed down. She gives a big smile.")
            newline()

            dline(
                "CHAR: You're trying to get under my skin, aren't you? Well, it's not going " +
                "to work. You're nothing but a big idiot."
            )

            line("Jess coughs and coughs and coughs and tries to catch her breath.")
            line(
                "Alex and Cate have taken no notice of the interaction. They're fiddling with " +
                "their computers still."
            )
            newline()

            dline("JESS: I'm going to have you fucking done for assault!")
            dline(
                "CHAR: Dummy. It's your word against mine. You should be glad I didn't kill " +
                "you."
            )
            dline("JESS: You're mental. I never should've come back here.")

            line("The detective corner takes off their headphones.")

            dline("ALEX: Okay! We've gone over everything, and we're ready!")

            line("Alex is shaking", addNewline = false)
            changeSceneButton("sussex-july-4-school-19", "with joy.")
            newline()

            line("Either that, or his poor overstimulated brain is finally burnt out.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-19") {
        page {
            dline("JESS: Actually... I can't leave here.")
            dline("CHAR: You can, actually. It would be vastly preferred.")
            dline(
                "JESS: Two things. One, staying here pisses you off. " +
                "Two, Alex specifically asked me for help; your pettiness shouldn't stop me from " +
                "helping him."
            )
            dline(
                "CHAR: I am perfectly fine with you staying here. " +
                "I would just prefer you would fuck off down a hole."
            )
            dline("JESS: Oh, so you didn't dispute that I'm smart?")
            dline("CHAR: I didn't feel the need, Jess.")
            dline("JESS: That's good, because there was no need, Cuntlotte.")
            dline("CHAR: Really? Even the Year 8s have better insults.")

            changeSceneButton(
                "sussex-july-4-deduction-1",
                "Jess gives up arguing and grabs a chair from the side."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-1") {
        onLoad {
            SS76.clearScreenColor = Color.SLATE
        }

        page {
            dline("ALEX: Okay! Here we go!")

            dline("CHAR: Wait, wait, wait. Did you invent a stupid catchphrase too?")

            dline("CATE: Please, it is easier for everyone if you would listen and not interrupt.")

            line(
                "Cate never challenges Char's authority. She's far too into this detective " +
                "nonsense."
            )
            newline()

            dline("ALEX: I think a quick recap is in order, about what we discovered yesterday.")

            dline("CHAR: I already know what you discovered yesterday. I was forced to sit through it.")

            dline("ALEX: It's for the benefit of our guest! She doesn't know it!")

            line("Char gives Jess the side-eye.")
            newline()

            changeSceneButton("sussex-july-4-deduction-2", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-4-deduction-2") {
        page {
            dline("ALEX: Two days ago, I discovered a mysterious signal on")
        }
    }

}
