package tf.veriny.ss76.vn.sussex

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
            "wouldn't know what brand it is. Cars are evil."
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

        changeSceneButton("drive-1", "He obliges and drives off.")
    }

    createAndRegisterOnePageScene("drive-1") {
        line("The mansion is a long drive away. ")
    }
}