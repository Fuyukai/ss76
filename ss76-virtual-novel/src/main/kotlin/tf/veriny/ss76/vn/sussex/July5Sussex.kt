package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.engine.scene.createAndRegisterScene
import tf.veriny.ss76.vn.CommonScenes

public fun registerSussexJuly5Scenes() {
    createAndRegisterScene("sussex-july-5-start") {
        topText = "SS76 - Route One - 05/07"

        page {
            line("Today's date is Wednesday, the 5rd of July.")
            newline()

            line("It's a sunny day. Some clouds :push:@sky@ break up the skyline. :pop:")
            line("It hasn't rained in as long as you can remember.")
            newline()

            changeSceneButton("sussex-july-5-pre-1", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-5-pre-1") {
        page {
            line(
                "It's a hot summer day. It's 8:00am, and you're just sitting in your " +
                "pajamas."
            )
            newline()

            line(
                "You don't have to leave for school for another twenty minutes, so you " +
                "won't get dressed for another fifteen minutes."
            )
            newline()

            line(
                "Your cat is on your bed with you, asleep in a circle. That's unusual. She " +
                "prefers her (very expensive) cat tree, where she can judge you for your crimes " +
                "from high above."
            )
            newline()

            line(
                "What are you doing? Just sitting and staring at the ceiling can't be very " +
                "healthy."
            )
            line("Unfortunately, you don't have anything better to do.")
            newline()

            line(":push:@yellow@ <I need to rephrase this> :pop: \n")
            changeSceneButton("sussex-july-5-pre-2", "A sharp banging comes from the door downstairs.")
        }
    }

    createAndRegisterScene("sussex-july-5-pre-2") {
        page {
            line("You amble down the stairs. If you were to go any slower you would start " +
                 "to redshift.")
            newline()

            line("The banging continues.")
            newline()

            line(
                "You walk to the front door and unlock the inner door. " +
                "Your paranoid parents double lock it when they leave in the morning."
            )
            newline()

            line("The banging intensifies.")
            newline()

            line(
                "You open the inner door and step out into the porch. A very angry Char is " +
                "standing outside it."
            )
            newline()

            changeSceneButton(
                "sussex-july-5-pre-3",
                "She frantically bashes the outer door."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-pre-3") {
        page {
            dline("CHAR: Let me in you deaf prick! I've been knocking for the last ten minutes!")

            dline("CHAR: We have to leave, now! We're going to be late!")

            line("You normally leave at 8:20, but you are always late.")
            newline()

            dline(
                "CHAR: Get dressed! If you're not out here in two minutes, I'm breaking " +
                "this door down."
            )

            line(
                "You run upstairs and haphazardly put your uniform on. You don't even get a " +
                "chance to brush your teeth."
            )
            line(
                "You don't want to have to explain why the front door would be in tatters to " +
                "your mum."
            )
            newline()

            line(
                "You run out. You've forgotten to lock the door, but you don't notice. " +
                "It probably won't be an issue."
            )
            newline()

            dline("CHAR: Wow, did you forget how to dress yourself?")

            changeSceneButton(
                "sussex-july-5-pre-4",
                "She reaches over and gently adjusts your tie and collar."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-pre-4") {
        page {
            line("You walk at a brisk pace down the road, trailing behind Char. You don't " +
                 "know what's so urgent about being early today.")
            line("But it must be important.")
            newline()

            line(
                "It's been a long time since Char has walked with you to school. She always " +
                "goes by herself in the morning these days."
            )
            newline()

            line(
                "That's just how people are. Sometimes, they just do something differently. " +
                "It's perfectly normal."
            )
            newline()

            changeSceneButton(
                "sussex-july-5-pre-5",
                "Somewhere, deep in your mind, you feel like you missed it."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-pre-5") {
        page {
            line("Up the alley. Cross the alley. You're at the heath.")
            newline()

            dline("CHAR: Come on, we're cutting this way.")

            line("You're reluctant. A", addNewline = false)
            pushSceneButton(CommonScenes.FELL_DOWN_HEATH.id, "bad memory")
            line("flashes through your mind.")
            newline()

            line("The incline seems steeper than ever before. The bottom is a foggy abyss.")
            newline()

            dline("CHAR: Hey! What are you waiting for? Are you still scared of this hill?")

            line("You feel a pair of hands on your back ", addNewline = false)
            changeSceneButton(
                "sussex-july-5-pre-6", "as you are suddenly pushed down the hill."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-pre-6") {
        page {
            line(
                "You do an awkward semi-run down the path; the funny kind people do when " +
                "they're almost falling over but are trying to regain their balance."
            )
            newline()

            line("Luckily, you regain your balance and don't fall over. Char comes sliding down " +
                 "past you, as smooth as... something very smooth. A marble, maybe.")
            newline()

            dline(
                "CHAR: See! It's not scary, you little baby. Come on, this saves ten minutes. " +
                "If we get a move on we'll be just in time."
            )

            line(
                "You keep walking through the trees, following the well-walked " +
                "path cut through the shrubs down low by many generations of children and dog-walkers."
            )
            newline()

            line(
                "The sun shines from behind you causing your shadow to extend off into the " +
                "distance. Char paces slightly behind you, whacking the plants with a ruler as she " +
                "walks past."
            )
            newline()

            changeSceneButton("sussex-july-5-pre-7", "You keep walking.")
        }
    }

    createAndRegisterScene("sussex-july-5-pre-7") {
        page {
            line("The birdsong grows quieter as you delve deeper into the heath.")
            newline()

            line(
                "The birds don't like it this deep; there's nothing to nest on. It's just " +
                "bushes and rabbit holes."
            )
            newline()

            line("You keep walking.")
            newline()

            line(
                "You pass another recently burnt patch. There are already small " +
                "opportunistic plants reforming out of the ashes; they will surely turn into even " +
                "more annoying prickly stupid obstacles."
            )
            newline()

            line(
                "You wonder about what happens if the plants adapt to the fire. Then humanity " +
                "would be doomed. There's no way to control massive outbreaks without our fire."
            )
            newline()

            line(
                "It's humanity's oldest and most useful tool, after all. Especially for " +
                "disposing of unwanted things."
            )
            newline()

            changeSceneButton("sussex-july-5-pre-8", "You keep walking.")
        }
    }

    createAndRegisterScene("sussex-july-5-pre-8") {
        page {
            line("But, wait. This is a heathland. The plants are already adapted to fire, right?")
            newline()

            line("You keep walking.")
            newline()

            line(
                "You pass another recently burnt patch. There are already small " +
                "opportunistic plants reforming out of the ashes; they will surely turn into even " +
                "more annoying prickly stupid obstacles."
            )
            newline()

            line("You keep walking.")
            newline()

            line(
                "The birdsong is entirely gone. There's nothing but the crunching of footsteps " +
                "and the wind."
            )
            newline()

            line("You keep walking.")
            newline()

            line("You wonder about what happens if the plants adapt to the fire.")
            newline()

            changeSceneButton("sussex-july-5-pre-9", "You keep walking.")
        }
    }

    createAndRegisterScene("sussex-july-5-pre-9") {
        topText = "CANNOT DETERMINE DATE - PLEASE CHECK NETWORK CABLE"

        page {
            line("The wind seems to pick up. You keep walking.")
            newline()

            line("You pass another recently burnt patch. You keep walking.")
            newline()

            line(
                "Char is still pacing behind you, punishing any plant that dares cross the " +
                "human path. You keep walking."
            )
            newline()

            line("You pass another recently burnt patch. You keep walking.")
            newline()

            line("You pass another recently burnt patch. You keep walking.")
            newline()

            line("The sun has been in your eyes for a while now. You keep walking. " +
                 "You really wish you had sunglasses. Non-prescription ones are quite cheap, " +
                 "and you keep walking."
            )
            newline()

            changeSceneButton(
                "sussex-july-5-pre-10",
                "You wonder about what happens if the plants adapt to the fire."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-pre-10") {
        page {
            line("Suddenly, a massive gust of wind blows the ruler out of Char's hand.")
            line("She stops and runs to pick it back up, but stops when she notices.")
            newline()

            dline("CHAR: How long have we been walking?")

            line("You don't know. You're so fucking unobservant, aren't you?")
            newline()

            dline("CHAR: Where are we?")

            line("Char is having to shout over the wind. You snap out of your thoughts and take " +
                 "a look around. "
            )
            newline()

            dline("CHAR: Please tell me you see that, too.")

            changeSceneButton("sussex-july-5-pre-11",
                "You are not prepared for what you see."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-pre-11") {
        page {
            dline(
                "CHAR: How far in does this go... Surely we would have reached the car park " +
                "by now?"
            )

            line(
                "You've been walking on a slight curve the entire time, but there's no " +
                "mistaking it."
            )
            newline()

            line(
                "Behind you, the path extends out as far as you can see. In front of you, the " +
                "path extends out as far as you can see."
            )
            line("There's no plant smaller than eye level on either side of the path. " +
                 "Every so often, there's a large burnt-out area of varying depth. " +
                 ":push:@pink@ They all smell recent. :pop:")
            newline()

            dline("CHAR: I still have 4G in here. We must have just taken a wrong turn.")

            changeSceneButton("sussex-july-5-uhoh-1", "The sky above is a deep blue.")
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-1") {
        page {
            dline("CHAR: Okay... Maps is telling me that we're still just by the entrance.")

            dline("CHAR: But that doesn't make sense... we've been walking for at least ten minutes.")

            line(
                "Char's voice is shaking slightly. Of course it is. " +
                "That's a perfectly normal reaction."
            )
            newline()

            dline("CHAR: Okay. We should go back the other way, and take the long way around.")

            line(
                "You start walking back the other way. Char is trailing behind you again, " +
                "but much closer."
            )
            newline()

            dline(
                "CHAR: I don't recognise this bit... the path looked differently. " +
                "Are we going the wrong way?"
            )

            changeSceneButton("sussex-july-5-uhoh-2", "The sun is in your eyes again.")
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-2") {
        page {
            line(
                "You keep walking, back where you came from. The smell of recently burnt plant " +
                "forces its way into your lungs."
            )
            newline()

            line(
                "You keep walking. The wind is still blowing quite hard, but you're certain " +
                "there's no other ambient noise."
            )
            newline()

            line(
                "Your predicament keeps your mind empty. Five minutes pass, and then five " +
                "more. "
            )
            newline()

            dline("CHAR: Okay. Stay calm. The hill should be here pretty soon.")
            dline("CHAR: It can't be far away.")
            dline("CHAR: Once we go up it, let's just walk the slow route. Okay?")

            changeSceneButton(
                "sussex-july-5-uhoh-3",
                "You keep walking, and nod in agreement."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-3") {
        page {
            line(
                "You keep walking, and another five minutes pass. The path underneath you is " +
                "as freshly beaten as ever."
            )
            newline()

            line(
                "You keep walking, and another five minutes pass. The burnt heathland " +
                "delicately crumbles under your touch."
            )
            newline()

            line(
                "You keep walking, and another five minutes pass. The wind is still as strong " +
                "as ever."
            )
            newline()

            line(
                "You keep walking, and another five minutes pass. You don't notice anything " +
                "different this time."
            )
            newline()

            dline("CHAR: It's been twenty minutes. We've been walking back for twenty minutes.")
            line("CHAR:", addNewline = false)

            changeSceneButton(
                "sussex-july-5-uhoh-4",
                ":push:¬shake¬ But it all looks the same. :pop:"
            )
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-4") {
        page {
            line(
                "Char stops suddenly. This is going nowhere. She probably has a good idea of " +
                "how to get out of this."
            )
            newline()

            dline(
                "CHAR: Wherever... whatever... wherever we are, it's clear we're getting " +
                "nowhere."
            )

            dline(
                "CHAR: You're such an idiot. The one day I walk with you, and we get trapped " +
                "in the fucking heath."
            )

            line("She's right. This has never happened before. It's no coincidence.")
            newline()

            dline("CHAR: Here, help me up. I need to look over these bushes.")

            line("Char climbs up on your shoulders, and tries to look out over the edges.")
            newline()

            line(
                "She cups her hands around her eyes to get a good look at what lies beyond " +
                "the brick walls of the beaten path."
            )
            newline()

            changeSceneButton("sussex-july-5-uhoh-5", "But, she doesn't.")
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-5") {
        page {
            dline(
                "CHAR: I'm calling Cate. I'm sure she has some wisdom to hold over our head " +
                "in this situation."
            )

            line("Char's voice is really shaking now. She looks close to crying.")
            newline()

            dline("CHAR: Hello? Cate?")

            dline(
                "CHAR: Yes, I know, this is rare. Yes, I kn- Shut up. Look, I'm trapped in " +
                "the heath."
            )

            dline("CHAR: Yes, it sounds rid- Shut up!")

            dline("CHAR: Of course I would. Okay, look, I need your help.")

            line("Char suddenly recoils away from the phone.")
            newline()

            dline(
                "CHAR: Okay, yes, hello Jess. Please don't sh- Please don't shout into the " +
                "phone."
            )

            changeSceneButton(
                "sussex-july-5-uhoh-6",
                "Great. The whole point of leaving early has been ruined."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-6") {
        page {
            line(
                "Char talks over the phone for the next few minutes. Her face flashes many " +
                 "mixed emotions, going from anger, to worry, to sadness, back to anger, and finally " +
                 "to relief."
            )
            newline()

            dline("CHAR: Give me your phone. Alex will buy you a new one.")

            line(
                "You comply. Of course you do. Char takes out her pocket knife and stabs through " +
                "the back of it multiple times."
            )
            newline()

            line(
                "It starts to hiss. You think you should duck, but before you get a chance " +
                "Char chucks it into the air, and @pink@it @pink@explodes."
            )
            newline()

            line("Char puts her phone on speaker, and a tinny voice starts to pour out.")
            newline()

            changeSceneButton(
                "sussex-july-5-uhoh-7",
                "ALEX: We saw it! You're just by the entrance!"
            )
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-7") {
        page {
            dline("CHAR: We already fucking KNOW we're right by the entrance!")

            dline(
                "JESS: So what's the trouble? Just walk out. Don't tell me you're too stupid to " +
                "figure that out."
            )

            dline(
                "CHAR: Come down the slope and take a look. Don't go any further, I don't " +
                "want to spend eternity in here with one of you idiots."
            )

            dline("JESS: Alex, go down the slope.")

            dline("ALEX: Okay!")

            line(
                "The sound of tumbling and crashing comes out of the shockingly low quality " +
                "speaker."
            )
            newline()

            dline("ALEX: Ow! I slipped over! But I'm super duper okay now, and I'm down the slope!")

            changeSceneButton("sussex-july-5-uhoh-8", "CHAR: You don't see me, right?")
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-8") {
        topText = "SS76 - Route One - 05/07"

        page {
            dline("CATE: Alex, can you see Charlotte?")

            dline("ALEX: No! I can't see where her phone landed, either!")

            dline("CATE: He says he can't see you, or your phone.")

            dline("CHAR: Yes, idiot, I heard him. He's always shouting.")

            line("Wait a moment.")
            newline()

            dline("CHAR: Wait a moment. I heard him. ALEX, DO YOU HEAR ME?")

            line(
                "You didn't notice it, but the wind has died down. You should really be more " +
                "observant."
            )
            newline()

            changeSceneButton(
                "sussex-july-5-uhoh-9",
                "A small mammal bursts through the bushes."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-9") {
        page {
            dline("ALEX: Oh! Miss Charlotte! I found you!")

            dline("CHAR: Whoa! What the fuck! Where did you come from?")

            line(
                "You look around. The broken properties of the path are gone now - it's just " +
                "another winding clearing through the heath."
            )
            newline()

            dline("CHAR: How the fuck did you do that? Wait, what happened to the bushes?")

            line("It was back to normal now. Right?")
            newline()

            line("You and Char follow Alex back to the regular route.")
            newline()

            changeSceneButton("sussex-july-5-uhoh-10",
                "Jess is standing tall at the top of the incline."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-10") {
        page {
            line(
                "Char is standing awkwardly at the bottom of the hill. The experience has " +
                "drained her completely. Her face is pale and uneasy, her legs weak and shaking."
            )
            newline()

            line("It's rare to see Char so panicked, but you understand.")
            newline()

            line(
                "But of course, Jess can't resist some taunting. What a vile little creature " +
                "she is."
            )
            newline()

            dline(
                "JESS: Well, well, well. That's a new low, Charlotte. Getting lost in the " +
                "heath."
            )

            dline("JESS: You walk through here every day. How can you possibly get lost?")

            dline(
                "JESS: If you ask me nicely, I'll hold your hand tomorrow so it doesn't " +
                "happen again."
            )

            changeSceneButton(
                "sussex-july-5-uhoh-11",
                "Char slowly climbs the incline, wordless."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-uhoh-11") {
        page {
            line(
                "Everyone is standing outside the entrance now. One of Alex's cars is parked, " +
                "the driver looking incredibly frustrated at having to wait."
            )
            newline()

            dline(
                "ALEX: Gee, Miss Charlotte. You look really bad. Are you sure you want to " +
                "come to school today?"
            )

            dline("CHAR: Alex... I want to go to your mansion today. I need to be pampered.")

            dline("JESS: You're always pamp-")

            line("Char falls over into my arms, passed out. She's so light and delicate.")
            line(
                "I load her into the backseat of the car and buckle her in. She slumps over to " +
                "the side and rests her head on my shoulder. Everyone else climbs in around us."
            )
            newline()

            dline("ALEX: Okay, I'll call the maids and tell them we're having guests today.")

            changeSceneButton("sussex-july-52-start", ">> Next")
        }
    }
}