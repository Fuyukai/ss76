package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.scene.createScene
import tf.veriny.ss76.engine.scene.sceneSequence

/**
 * Registers scenes for Route One, Day One.
 */
public fun registerSu3JScenes(): Unit = sceneSequence("su3j-") {
    currentEffects.disableClickables = true
    enableInvert()
    disableTextSkip()

    createAndRegisterOnePageScene("prologue-1") {
        line("\"")
        line("And then she said the ancient phrase...")
        line("We're like the dreamer, who dreams and then lives inside the dream.")
        newline()
        line("I told her I understood. And then she said...")
        line("But who is the dreamer?")
        line("\"")
        newline()
        line("-- David Lynch, Twin Peaks: The Return, Part 14")
        newline()

        changeSceneButton("su3j-prologue-2", ">>>")
    }

    createAndRegisterOnePageScene("prologue-2") {
        dline("????: Do you find it easy to fall asleep at night?")

        dline("????: I can lie there, for hours, staring at my ceiling.")

        dline("????: I hate that feeling.")

        dline("????: I could be doing something else. Something useful and worthwhile.")

        dline("????: But, instead, I just lie there, hoping I'll fall asleep.")

        dline("????: Yet, if I get up, I'm tired again. It's a cycle.")

        changeSceneButton("su3j-prologue-3", ">>>")
    }

    createAndRegisterOnePageScene("prologue-3") {
        dline("????: Even if I fall asleep, I don't dream.")

        dline(
            "????: I go to bed, I wake up. Every day. I don't remember a single dream from " +
            "the last three years."
        )

        dline("????: I lose eight hours, and I get nothing back out of them.")

        dline("????: Does it happen to you? Do you dream?")

        line("The nighttime sun glares down above, just as it always does.")
        newline()

        dline("????: What if I am dreaming, but I just can't remember it?")

        changeSceneButton("su3j-prologue-4", ">>>")
    }

    createAndRegisterOnePageScene("prologue-4") {
        line("When you dream...")
        line("What do you dream about? :linger:120")
        newline()

        line("Do you dream about having superpowers, and saving the world? :linger:60")
        line("Do you dream about being a superstar, with legions of fans? :linger:60")
        line("Do you dream about falling in love, with the perfect person? :linger:60")
        newline()

        line("Do you dream about making the perfect world, for you, and for everyone? :linger:180")
        newline()

        changeSceneButton("su3j-prologue-5", "Or perhaps...")
    }

    disableInvert()
    currentEffects.backgroundColour = Color.BLACK

    createAndRegisterOnePageScene("prologue-5") {
        line("Do you dream about cleansing the impurity? :linger:60")
        line("Do you dream about removing your obstacles? :linger:60")
        line("Do you dream about the genocide of your enemies? :linger:60")
        newline()

        line("Do you dream about angels, leading the rapture? :linger:180")
        newline()

        line("They say dreams are an insight into our subconscious. Our psychology.")
        newline()

        line("Does having a good dream mean you're a good person? Does having a bad dream " +
             "mean you're a bad person? :linger:60")
        newline()

        changeSceneButton("su3j-prologue-6", ">>>")
    }

    currentEffects.backgroundColour = null
    enableInvert()

    createAndRegisterOnePageScene("prologue-6") {
        line("The flowers are singing and the birds are blooming around you.")
        newline()

        dline("????: If I don't dream, am I a good or a bad person?")

        line("The sun beats down with a soothing rhythm.")
        newline()

        dline("????: ...")

        line("The heat and the dirt straddles you like a soft blanket.")
        newline()

        dline("????: I think I could just fall asleep here.")

        changeSceneButton("su3j-start", ">>>")
    }

    disableInvert()
    currentEffects.disableClickables = false

    createAndRegisterOnePageScene("start") {
        line("Today's date is Monday, the 3rd of July.")
        newline()

        line("It's a @sky@sunny @sky@summer @sky@day. It's 21 degrees, and the humidity is 60%.")
        newline()

        changeSceneButton("su3j-school-1", ">> Next")
    }

    createAndRegisterOnePageScene("school-1") {
        line("It's three days until the school holiday.")
        newline()

        line("Three exciting, horribly boring days. It feels like forever since the school " +
             "year began just a few days ago.")
        newline()

        line(
            "It's nine o'clock. You have a free period in the morning, so you need to sign " +
            "in at the front desk or you'll get marked as absent."
        )
        newline()

        line("But the receptionist isn't here yet. He's late?")
        newline()

        line("You sit down on the bench that faces towards the glass windows. It's a muddy " +
             "and hazy view, coated with years of handprints and rain.")
        newline()

        changeSceneButton("su3j-school-2", "There's two people sitting besides you.")
    }

    createAndRegisterOnePageScene("school-2") {
        line("The first person is to your left.")
        newline()

        line("He is a man. About one hundred and eighty centimetres tall. He has hair, of no " +
             "defined colour. He has skin, of no defined complexion.")
        newline()

        line("Where his face would be is featureless. There is not no features, but there " +
             "are no features. There is an absence of the concept of features.")
        newline()

        line("His clothes are painted onto his body. A suit jacket, a t-shirt, and a pair of legs.")
        newline()

        line("He has no importance to you. He has no AI configured. He has no dialogue " +
             "responses if you try and talk to him.")
        newline()

        line("He sits there, motionless. He is unaffected by any force of physics. He's not " +
             "significant. He's nothing more than a speck in the universe!")
        newline()

        changeSceneButton("su3j-school-3", "He is just a background object.")
    }

    val charlotte = createAndRegisterScene("charlotte") {
        page {
            line("Name: Charlotte 'Char' Philips")
            line("Age: The same as you")
            line("Height: Pretty much the same as you")
            line("Hair colour: I think you get the idea")
            newline()

            line("She's your best friend, and has been for as long as you can remember.")
            newline()

            line("Whenever you've been, she's been there with you.")
            newline()

            line("It's almost as if your destinies are intertwined.")
            newline()

            backButton()
        }
    }

    createAndRegisterOnePageScene("school-3") {
        line("The second person is to your left.")
        newline()

        line("She is your", addNewline = false)
        pushSceneButton(charlotte.id, "best friend.")
        newline()

        line("You turn to look at her. She gives you a warm smile.")
        line("You turn to look at the desk. :linger:60 There's nobody there to give you a smile. Wet, or dry.")
        newline()

        line("You remain sitting. Shadows and figures dance through the glass of people " +
             "talking, :linger:30 living, :linger:30 chatting, :linger:30 existing. :linger:30")
        newline()

        line("The clock on the wall ticks away. :linger:60")
        line("Tick. :linger:60")
        line("Tick. :linger:180")
        line("Tick. :linger:180")
        newline()

        changeSceneButton("su3j-school-4", "It ticks backwards.")
    }

    createAndRegisterOnePageScene("school-4") {
        line("There's footsteps, :linger:30 no, :linger:30 stomping.")
        newline()

        dline("CHAR: Where's the receptionist?")

        line("He's late. He's so, very late. It's unacceptable! :linger:60")
        newline()

        line(
            "You turn to face him at the front desk. He slides the thin sign-in sheet over to you with an " +
            "exasperated sigh. :linger:60"
        )
        newline()

        line("Stomp. Stomp. Stomp. It's the stomping of somebody's heartbeat, inside their chest.")
        newline()

        line("Name. Initials. You write them out from muscle memory, pouring your heart and soul out " +
             "onto the pristine white sheet.")
        newline()

        line("Each entry here tells a story, and yours is no exception. It's a story of love " +
             "and death. A story of time and space.")
        newline()

        changeSceneButton(
            "su3j-school-5",
            "You slide it back over and it smacks the wall with a stomp."
        )
    }

    createAndRegisterOnePageScene("school-5") {
        line("It's a regular school day today. The impending event horizon has no bearing on " +
             "the lessons taught here today.")
        newline()

        line("You're an a-level student. You can't afford to slack off! The ¬shake¬pressure, " +
             ":linger:30 it's intense, and you can't crack!")
        newline()

        line("Your lesson is far, far, far upstairs. You grip the elevator door and slide it " +
             "open, pushing, pushing hard against its will.")
        newline()

        line("It groans and creaks, and squeals in pain, but the door gives in and opens up for you.")
        newline()

        line("Bursts of freezing steam fall out onto the floor, crackling and hissing. ")
        newline()

        line("You peer inside, to the vast expanse. The lift peers back at you, blinking. " +
             "It's dangerous to travel alone, but you're safe with her.")
        newline()

        dline("CHAR", addNewline = false, linger = false)
        changeSceneButton("su3j-school-6", "Let's go.")
    }

    createAndRegisterOnePageScene("school-6") {
        line("You step inside the lift, the carpet crunching and creaking under your bare soles.")
        newline()

        line("The air is hot and humid. It sticks to your skin as you walk deeper into the " +
             "jungle. You swat away mosquitoes and plants alike - it's not far now!")
        newline()

        dline("CHAR: I booked you a reservation. First class.")

        line("She's such a good friend. She loves you so dearly. First class! :linger:120")
        newline()

        line("Your knife is blunt, so blunt, but it gets the job done. It's hard to keep " +
             "swimming through the jungle air and slash away at the same time, but you get it done.")
        newline()

        line("The brush is thick and heavy, but it ends. It ends! You waltz out from the forest " +
             "and into the main service room.")
        newline()

        changeSceneButton("su3j-school-7", "Char hands you the reservation card.")
    }

    createAndRegisterOnePageScene("school-7") {
        dline("????: Good afternoon, miss. Do you have a reservation?")

        dline("CHAR: It's right here, in my pocket.")

        line("She points to her pocket, on her trousers.")
        newline()

        dline("????: That's okay. Right this way, please.")

        line("The waiter picks up a menu and pushes through the curtains behind you. The " +
             "gentle movement of the lift suspends them in the air momentarily, weightless.")
        newline()

        line("Your seats are fantastic. First class! It's a private booth, with private air, " +
             "private food, and private entertainment.")
        newline()

        line("You take your seat, and Char takes her seat, across from you.")
        newline()

        changeSceneButton("su3j-school-8", "You open the menu and start browsing.")
    }

    createAndRegisterOnePageScene("school-8") {
        dline("????: May I inquire what lesson you are travelling to today, miss?")

        dline("CHAR: I don't know today. We're in the mood for something exciting.")

        dline("????: I understand. Please press the button when you're ready to order. " +
              "The lift will be stopping in about two hours, so take your time.")

        dline("CHAR: Thank you.")

        line("The waiter leaves, and it's just you and Char alone in the booth. She opens her " +
             "menu and starts browsing too.")
        newline()

        line("The first class options are so much better than your home-cooked lunches. " +
             "Steak, burnt to perfection! You could never get that at home.")
        newline()

        dline("CHAR: I think we will get the burgers.")

        changeSceneButton("su3j-school-9", "She presses the call button.")
    }

    createAndRegisterOnePageScene("school-9") {
        dline("????: Are you ready to order?")

        dline("CHAR: Yes. We will get the burgers. Two cheeses.")

        dline("????: Here.")

        line("The waiter places the two beef burgers down on the table, then places the two " +
             "cheeses on top of them.")
        newline()

        line("It looks... rather unappetising.")
        newline()

        dline("????: I'm a doctor by trade, you know.")

        dline("CHAR: What type?")

        dline("????: Medical.")

        changeSceneButton("su3j-school-10", ">>>")
    }

    createAndRegisterOnePageScene("school-10") {
        dline("CHAR: Which show do you think is better? ¬shuftxt¬ER or ¬shuftxt¬House?")

        dline("????: They're incomparable, but I like ¬shuftxt¬House better.")

        dline("CHAR: That's not true. ¬shuftxt¬ER is obviously better.")

        dline("????: ¬shuftxt¬House is about a genius doctor who makes zebra diagnoses on " +
              "long shots, weaving a beautiful interpersonal soap opera drama throughout the " +
              "medicine. It's much more entertaining.")

        dline("CHAR: ¬shuftxt¬ER is about a group of doctors fighting against time in the " +
              "emergency room to keep everyone alive, whilst weaving beautiful soap opera drama " +
              "throughout the regular drama.")

        dline("????: See. They are the same, yet so different. How can you compare them?")

        changeSceneButton("su3j-school-11", ">>>")
    }

    createAndRegisterOnePageScene("school-11") {
        dline("CHAR: Things are made to be compared.")

        dline("????: If you want to compare them, compare them on the medicine.")

        dline("CHAR: I don't watch medical dramas for the medicine. I would watch 24 Hours of " +
              "A&E if I cared about the medicine.")

        dline("????: The medicine is a vital part of a medical drama. You should just watch a " +
              "regular soap if you don't care about the medicine.")

        dline("CHAR: But regular soaps aren't about intelligent people. I don't want to watch a " +
              "regular soap.")

        dline("????: You say this, but you dislike ¬shuftxt¬House, where the main premise is " +
              "the intelligent character.")

        dline("????: The lift is about to stop. I'll put the bill on your account.")

        line("It seems like the waiter isn't impressed by this line of reasoning.")
        newline()

        changeSceneButton("su3j-school-12", "<<<")
    }

    createAndRegisterOnePageScene("school-12") {
        dline("CHAR: Which show do you think is better? ¬shuftxt¬ER or ¬shuftxt¬House?")

        dline("????: They're incomparable, but I like ¬shuftxt¬House better.")

        dline("CHAR: That's not true. The medicine in ¬shuftxt¬House is significantly worse.")

        dline("????: That's not true. The writers worked with actual doctors to make sure the " +
              "medicine was accurate.")

        dline("CHAR: They use MRIs as lie detectors multiple times. How is that accurate?")

        dline("????: One oversight doesn't ruin the entire show. They shocked flatlines on " +
              "¬shuftxt¬ER multiple times. How is that accurate?")

        dline("CHAR: As you said, one oversight doesn't ruin the entire show.")

        changeSceneButton("su3j-school-13", ">>>")
    }

    createAndRegisterOnePageScene("school-13") {
        dline("????: But such a vital one? It's a sign that the writers simply don't care.")

        dline("CHAR: It doesn't ruin my enjoyment, and that's what is important.")

        dline("????: If glaring errors don't ruin your enjoyment, you should watch a regular soap.")

        dline("CHAR: But regular soaps aren't about intelligent people. I don't want to watch a regular soap.")

        dline("????: Nobody in ¬shuftxt¬ER is intelligent, either. One of the nurses tries to " +
              "kill herself in the first episode. That seems pretty stupid to me.")

        dline("????: The lift is about to stop. I'll put the bill on your account.")

        line("It seems like the waiter isn't impressed by this line of reasoning, either.")
        newline()

        changeSceneButton("su3j-school-14", "<<<")
    }

    createAndRegisterOnePageScene("school-14") {
        dline("CHAR: Which show do you think is better? ¬shuftxt¬ER or ¬shuftxt¬House?")

        dline("????: They're incomparable, but I like ¬shuftxt¬House better.")

        dline("CHAR: ¬shuftxt¬House is a show about an insufferable arsehole who bullies " +
              "people and repeatedly gets shot in the dick as a result.")

        dline("????: Yes, and that is the good part about it. It subverts the traditional " +
              "'insufferable genius' trope, by always having it backfire and never letting him improve.")

        dline("CHAR: The only redeeming factor is that it has medical mysteries. " +
              "I like the medical mysteries, but the drama is boring because everyone is horrible.")

        dline("????: Sorry, but that's not a good argument.")

        dline("????: The lift is about to stop. I'll put the bill on your account.")

        line("The waiter just dismissed her argument. He didn't even try and argue.")
        newline()

        changeSceneButton("su3j-school-15", "<<<")
    }

    createAndRegisterOnePageScene("school-15") {
        dline("CHAR: Which show do you think is better? ¬shuftxt¬ER or ¬shuftxt¬House?")

        dline("????: They're incomparable, but I like ¬shuftxt¬House better.")

        dline("CHAR: ¬shuftxt¬House is shit.")

        dline("????: Why did you ask me, then?")

        line("She turns to you.")
        newline()

        dline("CHAR: Kill him.")

        line("You take out your knife from the air and ¬mojibake¬stab")
        newline()

        dline("????: The lift is about to stop. I'll put the bill on your account.")

        line("The lift comes to a stop and the doors open in front of you.")
        newline()

        changeSceneButton("su3j-school-16", "You step out from the lift.")
    }

    createAndRegisterOnePageScene("school-16") {
        line("The air is dense and heavy - just the right mood for the unexplored wastelands " +
             "this high in the sky.")
        newline()

        line("The walls are lined with doors, many doors, so many doors! Each one, leads to a " +
             "new classroom.")
        newline()

        line("The classrooms, the unceasing torture. Eighteen years of a persons life is " +
             "wasted in there - but to what end?")
        newline()

        line("Your lesson... :linger:60 today? :linger:30 It's computer science. You're a STEM " +
             "student today. It's a practical skill, and it pays well, and there's definitely no " +
             "shortage of programmer jobs.")
        newline()

        line("Oh, but you're not using computers today. Fifty years of computers, but your " +
             "exam is still on paper!")
        newline()

        changeSceneButton("su3j-school-17", "It's terribly annoying.")
    }

    createAndRegisterOnePageScene("school-17") {
        line("The rows, the rows, the rows of classroom doors stretch out in front of you.")
        newline()

        line("There's no windows this far up. Of course not! That would be silly - looking " +
             "down, through the clouds? That would make anyone scared.")
        newline()

        line("The only light here is fluorescent, unfortunately. The sun would never dare to " +
             "step inside here. It's not his right to do so.")
        newline()

        line("You and Char walk along the corridor. Step, step, step. It's hard to block out " +
             "the screams, the endless screaming, from the tortured children within.")
        newline()

        line("There's so long to go until you make it to your lesson. It's such a horrible location!")
        newline()

        line(
            "Walking, walking in the beyond. It's so painfully slow. " +
            "You try to go faster, but your feet can't get a grip. You're burning out!"
        )
        newline()

        changeSceneButton("su3j-school-18", "It's lights out, and away we go!")
        line("But you're going to lose the race!")
    }

    createAndRegisterOnePageScene("school-18") {
        line(":fpw:1 You have a bad start, but Char has a fantastic start. She's got the inside line now.")
        newline()

        line("Down into turn one, you're on the dirty line and she's on the clean line.")
        newline()

        line("But it's not enough! You come out ahead, even with your bad start! She just " +
             "doesn't have the power!")
        newline()

        line("Down the inside through the chicane, and she's trying to have another go! She sticks " +
             "her nose in for a look, but backs off.")
        newline()

        line("She's going to have another go down through turn 5, around the outside! Has she " +
             "done it? Has Char overtaken you?")
        newline()

        line("It sure seems like it,", addNewline = false)
        changeSceneButton("su3j-school-19", "but can she make the move stick?")
    }

    createAndRegisterOnePageScene("school-19") {
        line(":fpw:1 Down into turn 6, you have the inside line - and you make the switch-back!")
        newline()

        line("But now it's down the main straight, and Char is within one second - she has DRS!")
        newline()

        line("DRS is open, her ring wing opens to gain more downforce. Gaining, gaining, she's " +
             "within three tenths!")
        newline()

        line("Is she gonna make a move into turn 7? I think she might! Down the inside line, " +
             "she gets ahead, and - oh - there's been contact! There's been contact!")
        newline()

        line("And it seems that both of our championship contenders are out of the race on lap one!")
        newline()

        line("This is going to put a mighty dent in the championship aspirations for " +
             "¬shuftxt¬Mercedes this season. This race was crucial, and now you're out!")
        newline()

        line("CHAR:", addNewline = false)
        changeSceneButton("su3j-school-20", "That's what you get when you don't leave the space.")
    }

    createAndRegisterOnePageScene("school-20") {
        line("Finally, it's the door to your lesson.")
    }
}