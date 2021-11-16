package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.scene.sceneSequence
import java.lang.StringBuilder
import kotlin.random.Random

/**
 * Registers scenes for Route One, Day One.
 */
public fun registerSu3JScenes(sm: SceneManager): Unit = sm.sceneSequence("su3j-") {
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

        line("<The nighttime sun glares down above, just as it always does.>")
        newline()

        dline("????: What if I am dreaming, but I just can't remember it?")

        changeSceneButton("su3j-prologue-4", ">>>")
    }

    createAndRegisterOnePageScene("prologue-4") {
        line("When I dream...")
        line("What do I dream about? :linger:120")
        newline()

        line("Do I dream about having superpowers, and saving the world? :linger:60")
        line("Do I dream about being a superstar, with legions of fans? :linger:60")
        line("Do I dream about falling in love, with the perfect person? :linger:60")
        newline()

        line("Do I dream about making the perfect world, for you, and for everyone? :linger:180")
        newline()

        changeSceneButton("su3j-prologue-5", "Or perhaps...")
    }

    disableInvert()
    currentEffects.backgroundColour = Color.BLACK

    createAndRegisterOnePageScene("prologue-5") {
        line("Do I dream about cleansing the impurity? :linger:60")
        line("Do I dream about removing your obstacles? :linger:60")
        line("Do I dream about the genocide of your enemies? :linger:60")
        newline()

        line("Do I dream about angels, leading the rapture? :linger:180")
        newline()

        line("They say dreams are an insight into our subconscious. Our psychology.")
        newline()

        line("Does having a good dream mean I'm a good person? Does having a bad dream " +
             "mean I'm a bad person? :linger:60")
        newline()

        changeSceneButton("su3j-prologue-6", ">>>")
    }

    currentEffects.backgroundColour = null
    enableInvert()

    createAndRegisterOnePageScene("prologue-6") {
        line("<The flowers are singing and the birds are blooming around me.>")
        newline()

        dline("????: If I don't dream, am I a good or a bad person?")

        line("<The sun beats down with a soothing rhythm.>")
        newline()

        dline("????: ...")

        line("<The heat and the dirt straddles me like a soft blanket.>")
        newline()

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
        line(":fpw:3 You have a bad start, but Char has a fantastic start. She's got the inside line now.")
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
        line(":fpw:3 Down into turn 6, you have the inside line - and you make the switch-back!")
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
        line(
            "Finally, it's the door to your lesson. Shaking off your concussion, " +
            "you rip the door off of the hinges, as per routine, and throw it through the wall " +
            "behind you."
        )
        newline()

        line("It tumbles out into the void, twirling into the darkness. The wall grows back " +
             "with a horrible, slimy rumble.")
        newline()

        line("You take your seats at the front of the class, squarely in the middle. There's " +
             "no computers here, only old and dented and disgusting chairs.")
        newline()

        line("The teacher is vaguely standing at the whiteboard, scribbling and scratching " +
             "the horrible mind-control runes they use on students every day.")
        newline()

        dline(
            "????: :font:alt :push:¬mojibake¬ Okay, children. Today, we will be going over an example test. " +
            ":pop: :font:default"
        )

        line("Great! Truly wonderful! It's a computer class, but the only thing they teach you is " +
             "how to do written tests!")
        newline()

        line("As the old adage goes,", addNewline = false)
        changeSceneButton(
            "su3j-school-21",
            "computer science has nothing to do with computers nor science."
        )
    }

    createAndRegisterOnePageScene("school-21") {
        dline("????: :font:alt :push:¬mojibake¬ Everyone, get into :pop: @sky@groups " +
              "¬shake¬@blue@of five. :font:default")

        line("Oh! Even better! Now it's group work! Group work is the vestige of incompetent " +
             "jesters, who masquerade as torturers!")
        newline()

        line("And, to truly make this a joke, the class doesn't even divide into groups of five!")
        newline()

        line("It looks like you and Char are going to have to work all alone. Alone. Together. " +
             "With nobody else.")
        newline()

        line("The court jester hands out a bunch of blank inked tree husks, filled to the brim " +
             "with useless questions relating to the inner workings of magical silicon boxes. :linger:180")
        newline()

        line("It's hard to make computer science tests sound fun or interesting.")
        newline()

        changeSceneButton("su3j-school-22", "You flip the page over.")
    }

    createAndRegisterOnePageScene("school-22") {
        lline("Okay. The first question is easy.")
        newline()

        lline(
            "Part one. It's to do with input devices. " +
            "\"Name one input device and one output device.\""
        )
        newline()

        lline("In this case, it's a voice activated speaker with an assistant. It's similar to " +
             "one you might find in your phone.")
        newline()

        lline("A voice activated speaker has one important input device, and one important " +
             "output device.")
        newline()

        lline("The name of the input device is a microphone, and the reason is so that the " +
             "speaker is able to listen to voice commands passively.")
        newline()

        lline("The name of the output device is a loudspeaker, and the reason is so that the speaker " +
             "can respond to the aforementioned voice commands.")
        newline()

        changeSceneButton("su3j-school-23", "Easy enough.")
    }

    createAndRegisterOnePageScene("school-23") {
        lline("The next part of the first question is defining what an embedded operating " +
             "system is.")
        newline()

        lline("It's two marks, so there's obviously two components to it.")
        newline()

        lline("The first component is describing what an operating system is, to the " +
             "standards of the mark scheme.")
        newline()

        lline("Most people would say it's just the thing that runs everyone on the computer, " +
             "but that's not a good enough explanation for the examiner.")
        newline()

        lline("\"An operating system is the first program that runs when you turn the computer " +
             "on. It is responsible for managing the hardware and other software.\"")
        lline("You write that down, to start with.")
        newline()

        lline("\"An embedded operating system is similar, but it is stripped down to only the most " +
             "essential functionality for the hardware it is designed for. \"")
        newline()

        changeSceneButton("su3j-school-24", "That seems satisfactory.")
    }

    createAndRegisterOnePageScene("school-24") {
        lline("The final part is to do with truth tables. Truth be told, you've always had " +
             "a bit of trouble telling the truth when it comes to truth tables.")
        newline()

        lline("The internal CPU only works when two things are true.")
        newline()

        lline(
            "First, the privacy switch is off. This means that the smart speaker won't be " +
            "listening all of the time, in case you say sensitive things you wouldn't want it to " +
            "overhear."
        )
        lline("This will be called P, and is True when the button is on.")
        newline()

        lline("Second, the microphone must be generating a signal. This avoids wasting " +
              "energy running the processor when there's no noise.")
        lline("This will be called S, and is True when the signal is being generated.")
        newline()

        pushSceneButton("su3j-school-25", "This creates a simple truth table.")
    }

    createAndRegisterOnePageScene("school-25") {
        line("+-------+-------+-------+")
        line("| P     | S     | O     |")
        line("+=======+=======+=======+")
        line("| false | false | false |")
        line("+-------+-------+-------+")
        line("| true  | false | false |")
        line("+-------+-------+-------+")
        line("| false | true  | true  |")
        line("+-------+-------+-------+")
        line("| true  | true  | false |")
        line("+-------+-------+-------+")
        newline()

        lline("That seems correct. The logic adds up.")
        newline()

        changeSceneButton("su3j-school-26", "You flip over the page.")
    }

    createAndRegisterOnePageScene("school-26") {
        lline("The next part of the question is to draw logic gates for this.")
        newline()

        lline("This is bad. You're not very good at logic gates. You always get them mixed up in " +
             "your head.")
        newline()

        lline("You turn to Char and ask for her opinion. She's remained silent so far, more than ]" +
             "happy for you to put in the work.")
        newline()

        dline("CHAR: I think... it's NOT P xor S.")

        lline("That makes sense. You draw the symbols down onto the page, trying to remember what " +
              "they look like.")
        newline()

        changeSceneButton("su3j-school-27", "It looks scuffed, but it'll do.")
    }

    createAndRegisterOnePageScene("school-27") {
        lline("The final part of the question is about multicore processors. Define the term " +
              "multicore processor.")
        newline()

        lline("Once again, it's two marks. That means the obvious answer isn't correct.")
        newline()

        lline("It's rather sneaky, that. You can tell if the exam is looking for the obvious " +
              "answer or the mark scheme answer by the number of marks.")
        newline()

        lline("First, you write down the obvious answer. \"A multicore processor is a processor " +
              "that has multiple physical cores, as opposed to one.\"")
        newline()

        lline("That's obvious to anyone. But that would only get you one mark. You have to write " +
              "the most obtuse, pointless explanation to get the second mark.")
        newline()

        lline("\"This allows multiple processes to be ran simultaneously, as opposed to in a sequence.\"")
        newline()

        changeSceneButton("su3j-school-28", "Two marks in the bag.")
    }

    createAndRegisterOnePageScene("school-28") {
        lline("Okay. That was question one, completed. One question, nine to go.")
        newline()

        lline("The clock has barely ticked by. The rest of the classroom is chatting, " +
              "chatting, but you and Char are sitting there in ample silence.")
        newline()

        lline("It's so tedious. But, you have no choice but to move on. Onto question two.")
        newline()

        lline("This is about automatic electronic surveying on a motorway. Every time a " +
              "vehicle is captured on camera, a different symbol is entered into the database.")
        newline()

        lline("'C' for Car, 'M' for Motorbike, 'L' for Lorry, and 'O' for everything else.")
        newline()

        line("Like a modern sitcom, though, this is just a misdirection. The first part is " +
              "actually asking", addNewline = false)

        changeSceneButton("su3j-school-29", "about compression.")
    }

    createAndRegisterOnePageScene("school-29") {
        lline("Part one, for one mark, state what compression means.")
        newline()

        lline("This is simple. \"Compression is the act of making data smaller via algorithms.\" " +
              "It's an almost meaningless statement, but it gets you the mark.")
        newline()

        lline("The actual algorithms to do with compression are much more interesting.")
        newline()

        lline("It's quite interesting how you can make data smaller, but not actually lose " +
              "any of the data.")
        newline()

        lline("It's something you could only dream of having in the physical world.")
        newline()

        line("The next part asks about run-length encoding.", addNewline = false)
        changeSceneButton("su3j-school-30", "The simplest form of compression.")
    }

    createAndRegisterOnePageScene("school-30") {
        line("A flash grenade bursts through the wall, exploding with a dazzling spark!")
        newline()

        line("You're not blinded! You're invulnerable to such stupid and deceitful tricks! " +
             "But, who is flashbanging a lowly school classroom at this hour?")
        newline()

        line("It's not a drill, oh no - they use @sky@live @sky@grenades for that!")
        newline()

        line("An army of armed men march in through the wall, their majestic guns drawn " +
             "ready to fire.")
        newline()

        line("You take a moment to admire them - chiseled, manly, oh so beautiful. " +
             "The raw firepower of such a group - it's something to be envied!")
        newline()

        line("You're not a gun person though, so you haven't a clue what those majestic " +
             "weapons really are. They overshadow the disgusting squadron though.")
        newline()

        changeSceneButton("su3j-school-31", "They form a perimeter around the edge of the wall.")
    }

    createAndRegisterOnePageScene("school-31") {
        dline(":font:alt ????: Nobody move! This is a raid! :font:default")

        line("A raid? At this hour? It's preposterous! There are protocols to follow for this!")
        newline()

        line("It's not clear who exactly they're abducting today, but they must have done " +
             "some very naughty things indeed to cause a raid this late in the day!")
        newline()

        line("The men march around, inspecting every student and rodent in the room. " +
             "Behind the ears, below the eyelids, under the lips. No hiding places!")
        newline()

        line("You and Char are the last to be inspected. One of the soldiers stops in front " +
             "of Char and pulls a picture out from his jacket.")
        newline()

        line("He takes a look at Char. He takes a look at the picture. He takes a look at the " +
             "Char. He takes a look at picture.")
        newline()

        changeSceneButton("su3j-school-32", "He cracks her skull open with the butt of his gun.")
    }

    createAndRegisterOnePageScene("school-32") {
        line("Char dies on the floor, the red stuff flowing out of her head and staining the carpet.")
        newline()

        line("The men rapidly encircle you - they're going to be at Moscow before the winter! " +
             "Russia will surely fall!")
        newline()

        line("One of them grabs your upper arm, yanking you down onto the floor. " +
             "He steps on the base of your skull, leaning in with his whole weight - it's really " +
             "quite painful!")
        newline()

        dline("????: Citizen! You are under arrest under suspicion of ¬mojibake¬dcdsafsdfgsd")

        dline("????: You do not have to say anything. But it may harm your defence if you " +
              "do not mention when questioned something which you later rely on in court. " +
              "Anything you do say may be given in evidence.")

        line("He slips the handcuffs onto your hands, and yanks you back up by the hair.")
        newline()

        changeSceneButton("su3j-school-33", "You pull your hands apart and the handcuffs phase through your hands.")
    }

    createAndRegisterOnePageScene("school-33") {
        dline("CHAR: Hey! Over here!")

        line("Char yells out for you, and you run towards the voice. It's so distant, yet so tantalisingly close...")
        newline()

        line("The army men follow you, closing in, closing in! You've got to outrun them!")
        newline()

        line("The door to the classroom is just there, behind the horizon. " +
             "It's infinitely far away, so you start accelerating infinitely fast.")
        newline()

        line("It takes an infinite amount of time, but you make it! Just in time, too, " +
             "as the army men have closed the distance!")
        newline()

        line("You barrel through the door, and close it behind it you. There's a lot of banging, " +
             "and then a lot less banging, and then very little banging, and then no banging.")
        newline()

        line("The men behind the door decay, and decay, and their skeletons fade into dust " +
             "and their souls fade into the aether. Level up!")
        newline()

        changeSceneButton("su3j-school-34", "The hallway around you.")
    }

    createAndRegisterOnePageScene("school-34") {
        line("The hallway around you isn't the one you came in, oh no.")
        newline()

        line("This one is blue. It's all blue. The walls glow shades of blue.")
        newline()

        line("The light is blue. it's all blue. The lights glow shades of blue.")
        newline()

        line("You hold your hands up to your face, but it's just blue.")
        newline()

        line("You turn to Char. She's pale, ever so pale. But she's not blue. She's just Char.")
        newline()

        line("But, in the middle of the hallway, there's an interruption in the blue.")
        newline()

        changeSceneButton("su3j-school-35", "A single pedestal.")
    }

    createAndRegisterOnePageScene("school-35") {
        lline("It's a marble pedestal, guarded by one of the army men. How did he get in?")
        newline()

        line("But... he's different.")
        newline()

        line("He's not from around here. :linger:300")
        newline()

        changeSceneButton("su3j-school-36", ">>>")
    }

    createAndRegisterOnePageScene("school-36") {
        line("The pedestal pulls you in, it's irresistible. Nobody has the will to avoid it.")
        newline()

        line("But the army man... He's not just guarding.")
        line("He's dancing. :linger:120")
        newline()

        line("There's no music. There's no sound but your footsteps.")
        newline()

        line("The pedestal keeps pulling, tugging, on your brain. You don't even dare think " +
             "about stopping, for it would know. It would know.")
        newline()

        line("The man keeps dancing. He's staring at the pedestal, dancing. Dancing flatly, " +
             "with no soul. With no life.")
        newline()

        changeSceneButton("su3j-school-37", ">>>")
    }

    createAndRegisterOnePageScene("school-37") {
        line("On the pedestal. It's a phone, a phone, one of those old landline phones.")
        newline()

        line("The phone cable disappears inside the pedestal.")
        newline()

        line("It's not the pedestal that pulls you in. The pedestal is nothing! It's dumb! " +
             "It is WORTHLESS!")
        newline()

        line("It is nothing more than something created to hold something else up!")
        newline()

        line("The phone! The phone! It is what is important! It controls you! It makes you run!")
        newline()

        changeSceneButton("su3j-school-38", "It makes the man dance!")
    }

    val ringing = Gdx.audio.newMusic(Gdx.files.internal("audio/ringing.ogg"))
    ringing.isLooping = true

    createAndRegisterScene("school-38") {
        onLoad { ringing.play() }

        page {
            lline("The phone is dialing.")
            newline()

            lline("The man is dancing to the dialing.")
            newline()

            lline("The dialing is drawing you in. ")
            newline()

            line("It's so audible now. It pierces your ears. It burrows into your mind, " +
                 "assaulting your head.")
            newline()

            changeSceneButton("su3j-school-39", "It hurts.")
        }
    }

    val baseMessages = listOf(
        "layer protocols in the SS7 suite were dedicated to the setup, maintenance, and release of telephone calls.",
        "channel for a conversation prior to the exchange of control information, non-facility associated signalin",
        "de, SS7 signaling progresses from ",
        "SS7 separates signaling from the voice circuits. An SS7 network must be made up of SS7-capable",
        "In 2008, several SS7 vulnerabilities were published that permitted the tracking of cell ph",
    )
    val newMessages = mutableListOf<String>()

    for (message in baseMessages) {
        val words = message.split(" ")
        val buf = StringBuilder()
        for (word in words) {
            val shouldMojibake = Random.Default.nextInt(0, 2) == 1
            if (shouldMojibake) buf.append("¬mojibake¬$word")
            else buf.append(word)
            buf.append(" ")
        }
        newMessages.add(buf.toString())
    }

    createAndRegisterOnePageScene("school-39") {
        line("The man dances to the dialing. On, and off. He's muttering to himself, on, and off, " +
             "with the dialing.")
        newline()

        val message = if (Random.Default.nextInt(0, 600) == 300) {
            "UVB-76, also known by the nickname \"The Buzzer\", is a shortwave radio station that " +
            "broadcasts on the frequency of 4625 kHz. It broadcasts a short, monotonous " +
            "buzz tone, repeating at a rate of approximately 25 tones per minute, " +
            "24 hours per day."
        } else { newMessages.random() }

        dline("????: $message")

        line("You're at the pedestal now. Staring. Staring. Staring. Deeply into the phone.")
        newline()

        line("You see the ringing loop around your head. It twists and turns and coils and " +
             "tightens, strangling and suffocating.")
        newline()

        line("It's rude not to answer, isn't it?")
        newline()

        changeSceneButton("su3j-school-40", "You pick up the phone.")
    }

    createAndRegisterScene("school-40") {
        onLoad { ringing.stop() }

        page {
            dline("????: Is this ¬mojibake¬YOU?")

            dline("YOU : Yes")

            dline("????: Is Charlotte with you?")

            line("You look around. It's just you, the phone, and the dancer.")
            newline()

            dline("YOU : No")

            dline("????: Are you :font:alt", addNewline = false)
            changeSceneButton("su3j-epilogue-1", "¬mojibake¬awake? :font:default")
        }
    }

    enableInvert()
    currentEffects.disableClickables = true

    createAndRegisterOnePageScene("epilogue-1") {
        line("<I wake up with a jolt.>")
        newline()

        line("Uwaaa. What happened?")
        newline()

        dline("????: You fell asleep out in the sun. I had to drag you back in before you " +
              "burnt to a crisp.")

        line("I was having such a good dream.")
        newline()

        dline("????: Just get under the blanket and go back to sleep. I'll still be here.")

        changeSceneButton("su4j-start", ">>> Next")
    }
}