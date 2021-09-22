package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.adv.ADVRenderer
import tf.veriny.ss76.engine.adv.ADVScreen
import tf.veriny.ss76.engine.scene.sceneSequence

/**
 * 05/07 (Pt 1)
 */
public fun registerSussexJuly5Scenes(): Unit = sceneSequence("su5j-") {
    copyAndSetInventory("su5j-start") {
        //val catHair = InventoryItem(
        //    "CAT HAIR", CommonItemScenes.CAT_HAIR.id, CommonItemScenes.CAT_HAIR_USE.id
        //)
        //put("cat-hair", catHair)
    }
    setTopText("SS76 - Route One - 05/07")

    createAndRegisterOnePageScene("start") {
        line("Today's date is Wednesday, the 5rd of July.")
        newline()

        line("It's a sunny day. Some clouds :push:@sky@ break up the skyline. :pop:")
        line("It hasn't rained in as long as you can remember.")
        newline()

        changeSceneButton("su5j-pre-1", ">> Next")
    }

    createAndRegisterOnePageScene("pre-1") {
        line(
            "It's 8:00 in the morning. You're sitting in a cafe with your parents, who are " +
            "about to drive up north for their stupid fishing holiday."
        )
        newline()

        line("Everyone is waiting for their breakfast. Your parents are sifting through an " +
             "activities magazine provided by the boat company. You are sitting there, awkwardly.")
        newline()

        dline("MTHR: There's a pub there, and a pub there, and a brewery there...")

        dline("FTHR: If we moor up there it'll be great for pike fishing.")

        dline("MTHR: ... a pub there, a pub there, a pub there ...")

        dline("FTHR: Will the boat fit under the Potter Heigham bridge?")

        dline("MTHR: ... and I bet Great Yarmouth has some good pubs too.")

        dline("FTHR: Great Yarmouth is a shithole, we're not going there.")

        changeSceneButton("su5j-pre-2", "You wonder where your food is.")
    }

    createAndRegisterOnePageScene("pre-2") {
        line("They suddenly remember you exist and drop the activity book.")
        newline()

        dline("MTHR: Oh, my baby boy is going on his first extended holiday without us. " +
              "Are you sure you're going to be okay?")

        line("You nod.")
        newline()

        dline(
            "FTHR: We're just a phonecall away if you need us, and you can always ask " +
            "¬shuftxt¬zzzzz down the road too."
        )

        line("You nod.")
        newline()

        dline("MTHR: Did you pack everything? Did you pack the special clothes I got you?")

        line("You nod.")
        newline()

        dline("FTHR: Also, don't think we haven't seen you with that pretty girl. Did you pack-")

        changeSceneButton(
            "su5j-pre-3",
            "Your cheeks go bright red and your shake your head furiously."
        )
    }

    createAndRegisterOnePageScene("pre-3") {
        line(
            "Continuing this line of inquiry would be very lethal for everyone involved, but " +
            "just in time, the waiter arrives with your breakfast."
        )
        newline()

        line(
            "Your parents have an absolutely massive fry up. They're justifying it by needing " +
            "energy for going on their boat, but it's clearly excessive."
        )
        newline()

        line(
            "You have two slices of back bacon, two sausages, and two slices of buttered toast. " +
            "How boring."
        )
        newline()

        changeSceneButton("su5j-pre-4", "Everyone starts eating.")
    }

    createAndRegisterOnePageScene("pre-4") {
        line(
            "It tastes like mush. Horrible, tasteless mush, with a horrible, tasteless " +
            "texture."
        )
        newline()

        line("You almost gag, but you force yourself to swallow it. You don't complain about things.")
        line("You're so docile, it's almost cute.")
        newline()

        line("You take a sip of your orange juice. It tastes like the vague concept of water.")
        newline()

        line(
            "Your parents don't seem to have this issue. They keep eating, horribly, messily, " +
            "their own slop on their own plates."
        )
        newline()

        line("You look down at the food pretending to be a meal with disgust, but you eat it anyway.")
        newline()

        changeSceneButton("su5j-pre-5", "It scrapes down your throat like a half-chewed crisp.")
    }

    createAndRegisterOnePageScene("pre-5") {
        dline("FTHR: That was very good. I love this place.")

        dline("MTHR: That was bigger than I expected. We're going to be late now!")

        dline("FTHR: Okay, let's get going then.")

        dline("MTHR: Okay, darling, we're going now. We'll be back home in a week and we'll " +
              "see you in three. Have fun, and text me every day!")

        line("They get up, push their chairs in, and leave. You're all alone.")
        newline()

        line(
            "A waiter comes up and starts cleaning the plates off of your table. " +
            "You take this as", addNewline = false
        )
        changeSceneButton("su5j-pre-6", "your cue to leave.")
    }

    createAndRegisterOnePageScene("pre-6") {
        line(
            "Your parents took the car on a journey, so you have to walk back through the " +
            "town centre."
        )
        newline()

        line("You have a splatter of brown sauce down your shirt. Disgusting.")
        newline()

        line(
            "You try and awkwardly fold your t-shirt over to cover it up, but it just sticks to " +
            "itself and makes the stain worse."
        )
        newline()

        line(
            "There's not really many people around. It's still early on a work day, and most " +
            "kids are still in school. Your school just ends early for some reason."
        )
        newline()

        line(
            "The twisty artificial roads of the town centre fan out like a set of disgusting " +
            "tentacles into the suburbs."
        )
        newline()

        changeSceneButton("su5j-pre-7", "You make it back to your house.")
    }

    createAndRegisterOnePageScene("pre-7") {
        line(
            "The first order of business is to change your t-shirt. It's just a grey one, so " +
            "not too great a loss, but it's still stupid how messy you are."
        )
        newline()

        line(
            "Then, you need to make sure everything is packed properly. It would be very dumb " +
            "of you if you forgot to pack enough underwear, for example."
        )
        newline()

        line("Then, it's just waiting until Alex's driver arrives to pick you up, at 9:30. " +
             "You check the clock; you have about thirty minutes until then.")
        newline()

        line("You unlock the door and step inside. An unnatural silence invades your ears.")
        line("There's no half-used glasses on the worktop. The doors upstairs are closed, " +
             "making it look extraordinary dark. Even the butter dish sits empty.")
        newline()

        line("You close the door behind you.")
        newline()

        changeSceneButton("su5j-pre-8", "A harsh banging emanates from the door.")
    }

    createAndRegisterOnePageScene("pre-8") {
        line(
            "You don't get a chance to react before the door jumps open, narrowly missing you " +
            "by millimetres."
        )
        newline()

        line("There's a very scary presence standing behind you. The shadow of her outstretched " +
             "arm is visible just before you feel your neck get yanked backwards.")
        newline()

        dline("CHAR: HEY! WE'VE BEEN WAITING OUTSIDE FOR FIVE MINUTES! ARE YOU READY TO GO?")

        line("The hallway clock reads 9:45. The driver is also late, but that's besides the " +
             "point. Char notices your massive sauce stain.")
        newline()

        dline("CHAR: Oh my god. Did somebody shit on you?")

        changeSceneButton("su5j-pre-9", "She starts to drag you upstairs.")
    }

    createAndRegisterOnePageScene("pre-9") {
        dline("CHAR: Okay. I'll take your suitcase to the car, you put on a new top.")

        line("She unzips the case and throws the first applicable t-shirt at you.")
        newline()

        line("You stand there awkwardly, holding it in your arms. She stares at you.")
        newline()

        dline("CHAR: I'm not going to eat you. Put it on.")

        line(
            "You continue to stand there awkwardly. She zips the case back up and drags it " +
            "out of your room."
        )
        newline()

        line("You put the new t-shirt on. It's grey, too.")
        line("It's good to wear grey. It doesn't stick out.")
        newline()

        changeSceneButton(
            "su5j-pre-10",
            "You unplug your phone and your charger and leave after her."
        )
    }

    createAndRegisterOnePageScene("pre-10") {
        line("You turn the hall light on as you leave. Your mother always does it, to stop thieves.")
        newline()

        line("A good thief would probably rob houses with their hall lights left on all day.")
        newline()

        line(
            "The car is sitting in front of the house. It's a pretty nice one, but you " +
            "wouldn't know what brand it is. Cars are evil, no matter what species."
        )
        newline()

        line("Char has already loaded your suitcase into the boot. She's arguing with somebody.")
        newline()

        line("Who is it? The other person's silhouette is nearly unmistakable.")
        newline()

        changeSceneButton("su5j-pre-11", "It's a silhouette of pure nastiness.")
    }

    createAndRegisterOnePageScene("pre-11") {
        dline("JESS: Hello-o-o-o!")

        dline("CHAR: What the hell are you doing here?")

        dline("JESS: Well, I thought I would save the driver a trip~ And join you two here!")

        dline("JESS: I got here early just for you, but it looks like the driver is here early too.")

        dline("CHAR: I'm going to push you into the road and have you ran over.")

        dline("JESS: Aw, you don't even have the guts to kill me yourself.")

        line(
            "Char opens the door to the car as hard as possible, slamming it into Jess' ugly " +
            "face. She recoils briefly, but then pops back up annoyingly jovial as ever."
        )
        newline()

        line("She turns to you and holds your hand in hers.")

        dline("JESS: I hope you don't mind sitting in the middle.")

        changeSceneButton("su5j-pre-12", "You climb into the middle seat.")
    }

    createAndRegisterOnePageScene("pre-12") {
        line(
            "You're in a human sandwich. An angel on the left of you, a being of pure " +
            "evil on the right of you."
        )
        newline()

        line("Jess pulls out a newspaper (the Grauniad, what else?) and starts reading.")
        newline()

        dline("CHAR: If you get carsick, I will throw you out of the window.")

        dline("JESS: I'm already carsick. Carsick of you~")

        line(
            "The driver looks back at the passengers through the mirror, and gains a rather " +
            "disgusted look."
        )
        newline()

        dline("RCPT: Oh my god, not you.")

        changeSceneButton("su5j-pre-13", "It's that failure of a receptionist.")
    }

    createAndRegisterOnePageScene("pre-13") {
        dline(
            "RCPT: You spend an entire year being late, making me sit there waiting, but as " +
            "soon as it's off on your holibobs you turn up early? What a fucking joke."
        )

        dline("CHAR: Aren't you that failure of a receptionist? Did your mum get you this job, too?")

        dline("RCPT: Aren't you that vile little girl who -")

        dline("CHAR: Come off it. You look like a foot and act like one, too. Just drive us, driver.")

        dline("RCPT: I'll drive into a fucking bollard if you keep this up.")

        line("Char whacks the foot man with her ruler, leaving a sizeable gash in his neck.")
        newline()

        dline("CHAR: Like I said, just drive us. Driver.")

        changeSceneButton("su5j-drive-1", "He obliges and drives off.")
    }

    val carRenderer = CarRenderer()
    advRenderer = carRenderer

    createAndRegisterScene("drive-1") {
        page {
            line("The mansion is a long drive away.")
        }

        page {
            line(
                "It's about an hour away, down the motorway. Motorways are terrifying. " +
                "Horrible metal boxes flying at ninety miles per hour."
            )
        }

        page {
            line("Especially with so many idiot drivers on the road.")
        }

        page {
            dline("RCPT: HEY! GET OFF YOUR FUCKING PHONE YOU MANIAC!")
        }

        page {
            line("The foot man yells loud enough to shake the entire vehicle.")
        }

        page {
            dline("JESS: Hey! Look! Moo cows!")
        }

        page { line("Jess points at some ambulatory beef grazing on a hill.") }

        page {
            dline("CHAR: How old are you? Seven?")
        }

        page {
            dline(
                "JESS: Maybe if you had some joy in your life, you wouldn't be such an ugly " +
                "bitch~"
            )
        }

        page {
            changeSceneButton("su5j-drive-2", "The cars and the hills fly past.")
        }
    }

    createAndRegisterScene("drive-2") {
        page {
            dline("CHAR: How much longer?")
        }

        page {
            dline("JESS: Sentence fragment.")
        }

        page {
            dline("RCPT: Shut up and let me drive. We'll be there when we get there.")
        }

        page {
            line("The cars fly past. The GPS says to keep left in two hundred yards.")
        }

        page {
            dline("CHAR: It said to keep left. The exit is coming up.")
        }

        page { dline("JESS: Sentence fragment.") }

        page {
            dline(
                "RCPT: Do you want to drive? Huh? If you want to drive, then you can " +
                "critique my driving."
            )
        }

        page {
            line("The cars fly past. The GPS says to keep left in one hundred and fifty yards.")
        }

        page {
            dline("CHAR: Hey, dude, you're going to miss our exit.")
        }

        page {
            dline("JESS: Sentence fragment.")
        }

        page {
            line("The foot man ignores her.", addNewline = false)
            changeSceneButton("su5j-drive-3", "He's going to miss the exit.")
        }
    }

    createAndRegisterScene("drive-3") {
        page {
            line(
                "The engine starts to hit the rev limiter. The GPS says to keep left in " +
                "one hundred yards."
            )
        }

        page {
            dline("CHAR: Come on dude, move over. I don't want to be late.")
        }

        page {
            dline("JESS: Sentence fragment.")
        }

        page {
            dline(
                "CHAR: First of all, nothing I've been saying is a sentence fragment. " +
                "Second of all, shut the fuck up."
            )
        }

        page {
            dline("JESS: Wow, I'm impressed you know what a sentence fragment even is. " +
                  "You're such a big girl~")
        }

        page {
            dline("JESS: I'm not even talking to you, though. I'm commenting on this opinion piece.")
        }

        page {
            dline("CHAR: Use your thinking voice, then. I don't care about your stupid newspaper.")
        }

        page {
            line("The cars fly past. The engine starts to back off.")
        }

        page {
            line("The GPS says to keep left in fifty yards.")
        }

        page {
            changeSceneButton("su5j-drive-4", "The cars fly past. The engine splutters and stutters.")
        }
    }

    createAndRegisterScene("drive-4") {
        onLoad {
            val screen = SS76.screen
            if (screen is ADVScreen) {
                val renderer = screen.subrenderer as CarRenderer
                renderer.spooky = true
            }
        }

        page {
            dline("CHAR: Hey. Hey, foot man. What's happening to the car?")
        }

        page {
            line("The driver stares straight ahead. The GPS says to keep left.")
        }

        page {
            dline(
                "JESS: It's just slowing down to take the exit, silly. Surely you would have " +
                "learned this in physics?"
            )
        }

        page {
            dline("CHAR: It's clearly not slowing down. We're going to miss our fucking exit.")
        }

        page {
            line("The car continues ahead. The GPS says nothing this time.")
        }

        page {
            dline("CHAR: Hey! What the hell are you doing?")
        }

        page {
            line("Char starts to shake the driver from behind.")
        }

        page {
            line(":push:@magenta@ No response. :pop:")
        }

        page {
            dline("CHAR: Hey! You fucking idiot! The exit is literally just ahead!")
        }

        page {
            line(":push:@magenta@ No response. :pop:")
        }

        page {
            dline("CHAR: God, we're going to be so late.")
        }

        page {
            changeSceneButton(
                "su5j-drive-5",
                "She slinks back into her chair, preparing for the inevitable."
            )
        }
    }

    createAndRegisterScene("drive-5") {
        page {
            line("The engine backs off further. It's almost idling now.")
        }

        page {
            line("The car continues along the motorway.")
        }

        page {
            line("The GPS stays silent, calculating an alternative route.")
        }

        page {
            line("Char slinks down further into her seat.")
        }

        page {
            line("The engine cuts out. There's nothing but the sound of the wind and newspaper " +
                 "pages being read.")
        }

        page {
            line("The car continues along the motorway.")
        }

        page {
            line("The GPS stays silent. It's given up calculating, and accepts the inevitable.")
        }

        page {
            line("Char slinks off of her chair, into the footwell.")
        }

        page {
            dline("CHAR: Whoa! What the hell!")
        }

        page {
            line(
                "She tries pushing herself back up, but her hands just uselessly slide along " +
                "the car walls."
            )
        }

        page {
            dline("CHAR: Why is the car so slippery?? What the fuck????")
        }

        page {
            line("She finally grabs on to something and pulls herself back into her seat. " +
                 "She starts sliding down it again.")
        }

        page {
            dline("CHAR: Did somebody do something to my seat???")
        }

        page {
            dline("JESS: I'm fine. Maybe you just pissed yourself. It would be rather in " +
                  "character for you.")
        }

        page {
            dline("CHAR: I will piss all over your horrible little face -")
        }

        page {
            dline("JESS: Wow! We haven't even had our first date yet!")
        }

        page {
            dline("CHAR: Out of all the horrible things you have said in your pathetic little " +
                  "fucking life, that is by far the worst thing you have ever said to me.")
        }

        page {
            dline(
                "CHAR: If I had the choice between going out with you, and suicide, " +
                "not only would I kill myself, but I would come back to life to kill myself again."
            )
        }

        page {
            dline("CHAR: Not even in a thousand universes or a thousand dreams could I imagine " +
                  "a more vile prospect than that.")
        }

        page {
            dline("CHAR: Even the thought of thinking about the thought of doing so is making " +
                  "me suicidal.")
        }

        page {
            dline("CHAR: I think my body is physically rejecting the concept. I feel sick.")
        }

        page {
            dline("JESS: You're so mean~ There's nothing slippery over here.")
        }

        page {
            changeSceneButton(
                "su5j-drive-6",
                "She rubs her fingers down the window, making a horrific squeak."
            )
        }
    }

    createAndRegisterScene("drive-6") {
        page {
            line("The car continues along the motorway. The wind overpowers every other noise.")
        }

        page { line("Char looks wistfully out of her window.") }

        page { line("The driver stares non-wistfully out of the windscreen in front of him.") }

        page { dline("CHAR: Hey... did anyone else notice... that we're completely alone?") }

        page { line("There's no cars around. Not to the left. Not to the right. Not in front, nor behind.") }

        page {
            line(
                "This is the only car on the road. You, Jess, Char, and the foot man are " +
                "the only ones on the road."
            )
        }

        page { dline("JESS: There's a car right in front of us, silly.") }

        page { dline("CHAR: Uh, no there isn't. There's no cars. Anywhere. The engine isn't on, either...") }

        page { line("Jess points at a picture of a car in her newspaper.") }

        page { dline("JESS: See! It's right there!") }

        page {
            dline("CHAR: If I could reach you, I would take that newspaper and shove it down your throat.")
        }

        page {
            dline(
                "JESS: You sound so panicked and irritable. You're going to die early if you're " +
                "so stressed! How fantastic!"
            )
        }

        page { line("Char starts shaking the driver again.") }

        page { line(":push:@magenta@ Still no response. :pop:") }

        page { dline("CHAR: Hey! Are you fucking asleep or something?? Where are you taking us?") }

        page { dline("JESS: It's a disused piece of motorway, obviously.") }

        page {
            dline(
                "CHAR: What kind of motorway suddenly becomes disused? What about the engine? " +
                "How are we still moving whilst it's off?"
            )
        }

        page { dline("JESS: Maybe it's one of those fancy hybrid cars. They're so cool~") }

        page { dline("CHAR: Is everything a joke with you? Do you ever take anything seriously?") }

        page { line("You've only known Jess for as long as Char has, but you also noticed it.") }

        page { changeSceneButton("su5j-drive-7", "She treats everything as a joke.") }
    }

    createAndRegisterScene("drive-7") {
        page { dline("JESS: You're so cute when you're hysterical~") }

        page {
            dline(
                "CHAR: The car is moving but the engine is off. It's all slippery here. " +
                "It's almost as if..."
            )
        }

        page {
            line(
                "It's happening to you too. You brace your feet against the floor to stop " +
                "yourself from falling down."
            )
        }

        page { dline("CHAR: ... there's no friction??") }

        page { line("Jess reaches her gross little hand across you and pinches Char's cheek.") }

        page {
            dline("JESS: If there was no friction, I wouldn't be able to grab your cheek " +
                  "like this.")
        }

        page {
            line(
                "Char turns her head and bites Jess on the hand, as hard as possible. " +
                "Eight spots of blood start to appear."
            )
        }

        page { dline("JESS: See! Your teeth wouldn't be able to grip my hand either.") }

        page { line("Char starts shaking the driver harder, and harder, and harder.") }

        page { dline("CHAR: Hey! Wake up! Wake the fuck up!!!") }

        page { dline("JESS: It's no use. He's already gone.") }

        page { line("Char starts yanking the door handle, but there's no response. The door " +
                    "remains firmly sealed.") }

        page { dline("JESS: Hey now. It's really dangerous to open a door on the motorway, you know~") }

        page { dline("CHAR: Do you have any better ideas??? I can't do anything when I'm inside.") }

        page { dline("JESS: Ideas for what? Everything is fine inside, Charlotte. It's the outside that isn't fine.") }

        page { line("A flash of inspiration forces itself across Char's face. " +
                    "She whips her ruler out from inside her sleeve.") }

        page { dline("JESS: Do you have one of those in all your tops? You're like a seven year old.") }

        page { changeSceneButton("su5j-drive-8", "Char smashes it with all her force against the window.") }
    }

    createAndRegisterScene("drive-8") {
        onLoad {
            val screen = SS76.screen
            if (screen is ADVScreen) {
                val renderer = screen.subrenderer as CarRenderer
                renderer.spooky = false
            }
        }

        page { line("The window smashes open, and a gallon of glass flies out into the road.") }

        page { line("The engine roars to life, overpowering the wind now flooding the cockpit.") }

        page { dline("RCPT: WHOA! WHAT THE FUCK ARE YOU DOING BACK THERE?") }

        page { dline("JESS: What the fuck do you think you're doing, you fucking retard?") }

        page { line("For the first time in forever, Jess has lost her trademark shit-eating grin.") }

        page { dline("RCPT: DID YOU JUST BREAK THE WINDOW OPEN?") }

        page { dline("JESS: There's glass in my lap! There's glass all over me!") }

        page { line("Your cheek is bleeding slightly from the glass that flew into you.") }

        page { dline("CHAR: Oops. My hand slipped.") }

        page { line("Char's hand is covered in blood. She delicately holds her hands in her lap.") }

        page { line("The GPS says to take the exit.") }

        page { changeSceneButton("su5j-drive-9", "The driver takes the exit, and pulls " +
                                                 "the car over to the hard shoulder.") }
    }

    advRenderer = null

    createAndRegisterScene("drive-9") {
        page {
            line("There's a flurry of first aid.")
            newline()

            line("Jess dabs at your cheek with disinfectant wipes, and puts a plaster over the cut.")
            newline()

            line(
                "Char wraps her hand in a bunch of bandages. She looks really cool, like one of those " +
                "shonen protagonists."
            )
            newline()

            line("The foot man uses his jacket to cover up the window hole.")
            newline()

            dline("RCPT: Little girl, you owe me a new jacket.")

            dline("CHAR: Kill yourself, old man.")

            changeSceneButton("su5j-drive-10", "Everyone bundles back in.")
        }
    }

    createAndRegisterOnePageScene("drive-10") {
        line("The mansion is only a few minutes drive away from here. The driver pulls the car " +
             "into the driveway.")
        newline()

        line("Alex and Cate are waiting for you.")
        newline()

        line("ALEX: Whoa! What happened to you guys?!?! You're a whole hour late!!")
        line("CATE: Oh dear. Did you get in an accident?")
        newline()

        line("RCPT: A stupid little girl happened.")
        line("JESS: Charlotte broke the window!")
        line("CHAR: Extreme traffic jam.")
        newline()

        dline(
            "ALEX: Okay! We'll have you looked over by the nurses, just in time for the " +
            "super duper lunch!"
        )

        changeSceneButton("sussex-july-5-start-2", ">> Next")
    }

}