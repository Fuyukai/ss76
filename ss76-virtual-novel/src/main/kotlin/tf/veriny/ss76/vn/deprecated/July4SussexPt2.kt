package tf.veriny.ss76.vn.deprecated

import com.badlogic.gdx.graphics.Color
import tf.veriny.ss76.engine.scene.createAndRegisterScene

public fun registerJuly4SussexPt2Scenes() {
    createAndRegisterScene("sussex-july-4-school-y-1") {
        topText = "SS76 - Route One - 04/07"
        clearScreenColour = Color.BLUE

        page {
            dline(
                "CHAR: We are not like a mystery club. I will not have you dirty my hideout " +
                "like this."
            )

            dline("ALEX: Miss Charlotte, please please please let us be a mystery club! It's so fun!")

            dline(
                "CHAR: You stay in your corner. I stay in my corner. That is how it has " +
                "worked until now, and that is how it will continue to work."
            )

            dline("JESS: I'm pretty sure it's not your corner, Charlotte.")

            dline("CHAR: I'm pretty sure nobody asked you, Jess.")

            dline("CATE: This mystery will be solved a lot more quickly if we all co-operate.")

            changeSceneButton(
                "sussex-july-4-school-y-2",
                "Char takes down the whiteboard on the wall."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-2") {
        page {
            dline(
                "CHAR: I will also be taking down my whiteboard, so none of you retards can " +
                "scribble all over it."
            )

            dline("JESS: It's not good to say slurs.")

            dline("ALEX: Okay! Mystery club corner! Let's get to work!")

            dline(
                "CHAR: Work? What are you working on? Cate said it herself, there's nothing to do " +
                "but wait."
            )

            dline("JESS: Excuse me, this is mystery club business. You stick to your corner!")

            dline("CHAR: This is my club room. I am entitled to know everything that goes on " +
                  "in here.")

            line("Oops. Char got into the", addNewline = false)
            changeSceneButton("sussex-july-4-school-y-3", "club room nonsense")
            line("too.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-3") {
        page {
            dline(
                "ALEX: There's still one missing lead! The phone number in the comments of " +
                "that racist website!"
            )

            dline("CATE: Oh, yes. I forgot to write down the number. Let me see.")

            line("...")
            newline()

            dline(
                "CATE: It has been automatically censored by the comment software. We only " +
                "have six out of the eleven digits available. Three at the beginning, three at the " +
                "end."
            )

            dline(
                "CATE: The three at the beginning are '014'. The three at the end are " +
                "¬shufnum¬666."
            )

            dline(
                "CHAR: That's completely useless. There's a hundred area codes beginning " +
                "with 14 and a thousand numbers for each. That's nearly two million possible " +
                "combinations. "
            )

            changeSceneButton("sussex-july-4-school-y-4", "Jess pulls out her phone and starts " +
                                                          "tapping.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-4") {
        page {
            dline(
                "CHAR: What are you doing? Do you seriously think you can dial all two " +
                "million numbers?"
            )

            dline("JESS: It would only take a million to have a 50% chance.")

            dline(
                "CHAR: You're so stupid. How long do you think it will take to enter in a " +
                "million numbers, dial them, and check if it's the same voice?"
            )

            dline("JESS: I have an autodialer app. At least I'm trying, unlike you.")

            line("Something flashes across Char's face.")
            newline()

            dline(
                "CHAR: An autodialer... That could work. We don't need your stupid solution, " +
                "I can do this properly."
            )

            line("Char drags her laptop over to in front of her and starts", addNewline = false)
            changeSceneButton("sussex-july-4-school-y-5", "frantically typing.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-5") {
        page {
            dline("ALEX: What are you doing, Miss Charlotte? It looks super duper intense!")

            dline("CHAR: Shut up, worm. I need to concentrate. Actually, give me your debit card.")

            dline("ALEX: Okay! Here you go! Do you need my passwords too?")

            line("Alex tries to hand his card over, but his hand is intercepted by Jess.")
            newline()

            dline("JESS: Excuse me. What the fuck?")

            dline("ALEX: It's cool! Miss Charlotte has never misused my card before!")

            dline("JESS: :push:¬shake¬ What do you mean, BEFORE? :pop:")

            changeSceneButton(
                "sussex-july-4-school-y-6",
                "Char swipes the card from Alex's hand and starts entering the details."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-6") {
        page {
            dline(
                "CHAR: I need to set up a few accounts, but they cost money. It's only a few " +
                "thousand pounds."
            )

            dline("JESS: Only a few thousand pounds?? Are you mental???")

            line(
                "It's not that much money. Alex can easily afford it. He'd just have to fire " +
                "one of his maids and get off his backside at home for once."
            )
            newline()

            dline("ALEX: That's less than she usually spends!")

            dline(
                "JESS: You are a vile, vile creature, Charlotte. You're stealing from a child."
            )

            dline("CHAR: It's not stealing. Alex is fine with it. Besides, it's for a good cause.")

            dline("ALEX: Yeah! I bet it's for a super duper good cause!")

            changeSceneButton("sussex-july-4-school-y-7", "It's for the greater good.")
        }
    }
    createAndRegisterScene("sussex-july-4-school-y-7") {
        page {
            dline(
                "CHAR: I need to set up a few accounts, but they cost money. It's only a few " +
                "thousand pounds."
            )

            dline(
                "ALEX: Accounts for what? Are you doing some super duper secret harassment work " +
                "again? I don't like it when you do that..."
            )

            dline(
                "CHAR: No, my dear friend. I'm buying phone numbers and writing an autodialer. " +
                "One vastly better than Jess' little app."
            )

            line("Alex's little rat face beams so much you could see it from space.")
            newline()

            dline(
                "ALEX: Wow! That's so super duper epically amazingly cool! With your genius, " +
                "we'll find the number in no time!"
            )

            changeSceneButton(
                "sussex-july-4-school-y-8",
                "You're certain that Char's programming genius will solve this in no time."
            )

        }
    }

    createAndRegisterScene("sussex-july-4-school-y-8") {
        page {
            dline("JESS: I am absolutely disgusted with you, you two-faced bitch.")

            dline(
                "JESS: First, you are rude and dismissive towards my friends, insulting their " +
                "character."
            )

            dline("JESS: Now, you're suddenly into it, but only on the condition that Alex " +
                  "gives you money.")

            line(
                "Jess is spouting conspiracy theories. You know she's just mad because she got " +
                "outdone on the autodialer."
            )
            newline()

            dline(
                "JESS: I'm going to go and get lunch so I don't murder you. Does anyone else " +
                "want anything?"
            )

            dline("CHAR: No thanks. You'll poison it.")

            dline("JESS: I wasn't asking you, cunt.")

            changeSceneButton(
                "sussex-july-4-school-y-9",
                "Jess takes the orders like the good maid she is, and departs for the cafeteria."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-9") {
        page {
            line("A little while passes. Alex is fiddling with the radio and the recording.")
            line("It's still going. Nothing is going to come of it.")
            newline()

            line("Char is deeply focused on her programming.")
            newline()

            line(
                "The door opens and Jess delicately walks in. Idiot. She has another grin on " +
                "her face."
            )
            newline()

            dline("JESS: Okay~ I've got everyone's meals here.")

            line("Alex and Cate both take their food, and Jess sits down.")
            newline()

            dline("JESS: Hey. Charlotte. Guess what I've got.")

            line("Char is oblivious to Jess' stupid taunting.")
            newline()

            changeSceneButton(
                "sussex-july-4-school-y-10",
                "Jess slams her fist down as hard as possible on the desk."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-10") {
        page {
            line("Char doesn't flinch. Jess winces in pain.")
            newline()

            dline("JESS: Ow! Fuck! Fucking pay attention when I'm trying to talk to you!")

            line(
                "Char closes her laptop. She's not finished yet, but she will be very soon."
            )
            newline()

            dline(
                "CHAR: You have cafeteria food. I ordered pizza to collect at the shop down " +
                "the road, so I don't really care."
            )

            line(
                "Jess' face fades. She needs to try better than that; Char is always one step " +
                "ahead."
            )
            newline()

            dline("CHAR: Now, if you don't mind, I'll be picking up my food.")

            dline("JESS: No, wait, that's not what I meant.")

            changeSceneButton("sussex-july-4-school-y-11", "Char stops at the door.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-11") {
        page {
            line(
                "Char turns around, teary eyed. Tears of happiness. She has an ear-to-ear " +
                "smile on display."
            )
            newline()

            dline(
                "CHAR: Oh my god. I can't believe it. I can't believe you'd do such a nice thing " +
                "for me."
            )

            dline(
                "CHAR: You're finally going to kill yourself with that knife you're hiding in " +
                "your bag."
            )

            line("Jess gets up and slaps Char on the face. The impact is hard enough to leave " +
                 "a horrible red mark on her perfect skin.")
            newline()

            line("Char is still grinning.")
            newline()

            dline("CHAR: Why are you hiding a knife in your bag, then?")

            line("Jess reaches into the bag and pulls out a gargantuan", addNewline = false)
            changeSceneButton("sussex-july-4-school-y-12", "stack of papers.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-12") {
        page {
            dline("JESS: I ran into Mr Hammond earlier. Your physics teacher.")

            line(
                "Hammond. He was the old bastard teaching the lesson that Char accidentally fell " +
                "into."
            )
            newline()

            line("He's one of the :push:@pink@ rudest and worst :pop: teachers in the school.")
            newline()

            dline(
                "JESS: He told me to deliver this to you. It needs to be completed by " +
                "tomorrow or you're gonna get it."
            )

            line(
                "Jess tries to dump it at Char's seat, but Char swiftly reaches over and " +
                "redirects it onto your lap."
            )
            newline()

            dline("CHAR: This needs to be completed by tomorrow, or we're both gonna get it.")

            line("With that,", addNewline = false)
            changeSceneButton("sussex-july-4-school-y-13", "she walks away down the corridor.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-13") {
        page {
            line("Char is sitting at the table, eating her pizza. " +
                 "She gave you a quarter of it when she got back, which you ate rather disgustingly. " +
                 "Maybe Char won't give you any more if you're going to do that."
            )
            newline()

            dline(
                "ALEX: Oh... That smells really amazingly good! Miss Charlotte, next time, " +
                "can I have some too?"
            )

            dline(
                "CHAR: Sorry, but it looks like Jess is feeding you. I wouldn't want to " +
                "interfere with her planning."
            )

            line(
                ":push:¬dialogue¬ JESS: Your face is going to get even more greasy if you " +
                "keep eating like that. :pop:"
            )
            line("CHAR: I'm sure you have some tips for dealing with that.")
            newline()

            line("Jess spits in Char's food. Char keeps eating,", addNewline = false)
            changeSceneButton("sussex-july-4-school-y-14", "completely unfazed.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-14") {
        page {
            line(
                "Char gets back to her programming. She's really good at it, but even the " +
                "best programmers need time."
            )
            newline()

            dline(
                "ALEX: Miss Charlotte, when are you going to be finished! I'm so super duper " +
                "excited to figure out this phone number!"
            )

            dline(
                "CHAR: I'm just putting the finishing touches on. It's already started " +
                "dialing."
            )

            line("Alex nearly passes out from excitement.")
            newline()

            dline("ALEX: Oh! My! God! How long is it going to take!")

            dline("CHAR: Probably the rest of the day, and then some. We won't know anything " +
                  "until tomorrow. There's a thousand numbers, and they need to dial two thousand each. " +
                  "Thirty second per call is a little over half a day.")

            line(
                "Char must feel great for being able to show off her skills, and also " +
                "being able to ", addNewline = false
            )
            changeSceneButton("sussex-july-4-school-y-15", "one-up Jess.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-15") {
        page {
            dline(
                "JESS: You're seriously going to dial two million numbers? That probably " +
                "counts as harassment."
            )

            dline("CHAR: Maybe, but that's only an issue if someone complains.")

            dline("JESS: Don't you know the fines for nuisance calls?")

            line(
                "You're sure Jess does. It's exactly the kind of completely and utterly " +
                "useless knowledge she would waste her time on."
            )
            line(
                "She has an exceptionally smug look on her face. Although, have you ever seen " +
                "her without one?"
            )
            newline()

            dline(
                "ALEX: Don't worry, Miss Charlotte! I'll pay the fines! As long as we know " +
                "what the number is!"
            )

            dline("CHAR: I'm not worried, little rat.")

            dline(
                "JESS: When Ofcom comes knocking on your door, I want to watch them drag you " +
                "out."
            )

            line("CHAR: They're not gonna come to my house.", addNewline = false)

            changeSceneButton("sussex-july-4-school-y-16", "I put down your details.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-16") {
        page {
            line("The next few minutes are nothing but a cacophony of yelling and screaming.")
            newline()

            dline("JESS: This is the final fucking straw! You cannot let anything go, can you?")

            dline("JESS: You keep starting shit with me, for what purpose? Just to piss me off?")

            line("Jess is the one actually guilty of this. She's talking nonsense.")
            newline()

            dline(
                "JESS: Well, I'm done. You win, Charlotte. Alex and Catherine, you deserve " +
                "better than to hang about in this dark shithole with her. I'm going home."
            )

            dline("CHAR: Don't let the door hit you on the way out.")

            dline("JESS: I hope you get hit by that massive", addNewline = false)
            changeSceneButton("sussex-july-4-school-y-17", "black van in the car park")
            dline("on your way out, and you end up crippled.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-17") {
        page {
            dline("CHAR: Wait. What did you just say? Jess, hold up.")

            dline("JESS: Fuck off and kill yourself.")

            dline("CHAR: No, seriously, wait. This is important. Jess. Wait!")

            line(
                "Jess exits the room, but Charlotte follows her. She has a sense of urgency that " +
                "I don't normally see. The door slams shut."
            )
            newline()

            dline("ALEX: Whoa. That sounded bad.")

            line(
                "Alex is looking concerned. Cate takes the opportunity to shove past me and " +
                "look at Charlotte's screen."
            )
            newline()

            dline(
                "CATE: Wow... this is incredible... I can't believe she wrote something this " +
                "complex so quickly..."
            )

            line("Cate starts", addNewline = false)
            changeSceneButton("sussex-july-4-school-y-18", "frantically copying down")
            line("Charlotte's code.")
        }
    }

    val oldDays = createAndRegisterScene("sussex-july-4-old-days") {
        page {
            line("You try and remember what Alex is talking about.")
            newline()

            line("Vague shapes reform in my memory, but nothing concrete.")
            newline()

            line(":push:@magenta@ But you can't, can you? :pop:")
            newline()

            backButton("« It's a bad idea.")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-18") {
        page {
            dline("CATE: Hey, Al, pass me over my laptop.")

            dline("ALEX: Are you stealing her code? She's gonna kill you.")

            dline(
                "CATE: Hehe. She'll never know. I assume she's too busy bullying Jess " +
                "outside to care right now."
            )

            dline(
                "ALEX: I wish Charlotte would stop attacking her so much. Go back to the old " +
                "days, you know? When we weren't",
                addNewline = false
            )
            pushSceneButton(oldDays.id, ":push:¬dialogue¬ at each-other's throats constantly. :pop:")
            newline(2)

            dline("CATE: She'd just take her anger back out on you, you know.")

            dline(
                "ALEX: Yeah, but we can take it. Jess is too meek and she just starts " +
                "crying."
            )

            dline(
                "CATE: I'm not sure it counts as 'taking it' if you just let her take your " +
                "money when she threatens to kill you."
            )

            changeSceneButton("sussex-july-4-school-y-19", "The door starts to open.")
            newline()
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-19") {
        page {
            line(
                "Jess and Char walk back in. Char is all teary-eyed. Jess looks like she won " +
                "a triumphant fight to the death against a terminally ill disabled toddler."
            )
            line(
                "Cate slowly slides suspiciously away from Char's computer. You're not sure " +
                "what she was doing, but it wasn't anything good."
            )
            newline()

            dline("JESS: Delete it.")

            line("Char sits at the table and messes with something on her laptop.")
            newline()

            dline("CHAR: Okay. It's done. I changed the details.")

            dline("JESS: Good. I'm glad we settled this.")

            line("Jess sits back down, with a horrible fucking evil look on her face.")
            newline()

            dline(
                "ALEX: Wow! Does this mean you two have stopped arguing! That's super duper " +
                "amazing!"
            )

            changeSceneButton("sussex-july-4-school-y-20",
                "Char doesn't offer a response to that stupid question. She sits there, solemnly."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-20") {
        page {
            line(
                "Char stares at her computer screen. Her eyes are burning a hole through " +
                "the panel."
            )
            newline()

            dline(
                "CHAR: This will be complete at about 8 o clock tonight. The numbers it " +
                "finds will be here for us tomorrow morning. Is that good enough for you, " +
                "idiot squad?"
            )

            dline(
                "CATE: That is very much appreciated. It seems like tomorrow will be an " +
                "exciting day."
            )

            line("Char stands up and starts packing her things.")
            newline()

            dline(
                "CHAR: I have some things to do. I'll be back before the end of the day. " +
                "Try not to get over-excited. I don't want to clean up your brain juices off the " +
              "floor."
            )

            line(
                "With that, Char leaves you to finish the homework you have been " +
                "procrastinating on. It's due tomorrow,", addNewline = false
            )
            changeSceneButton("sussex-july-4-school-y-21", "remember?")
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-21") {
        page {
            dline(
                "ALEX: Jessica, are you and Miss Charlotte friends again? It would be super " +
                "duper cool if you are!"
            )

            dline(
                "JESS: We came to an agreement. She stops being a fucking cunt to me constantly, " +
                "and I stay."
            )

            dline("CATE: That is very good to hear. Will you be here tomorrow, too?")

            dline(
                "JESS: I'll see what I can do. It's July; I'm sure I could get permission to " +
                "do independent study elsewhere."
            )

            dline(
                "ALEX: Cool! Epic! I'm so glad you're around! You're so super duper smart, " +
                "and you gave us that really cool info on that phone number!"
            )

            dline(
                "JESS: Well, this stuff doesn't really interest me that much, but I'm glad " +
                "you two are getting something out of it."
            )

            changeSceneButton(
                "sussex-july-4-school-y-22",
                "The words on the page swirl around inside your head."
            )
        }
    }

    createAndRegisterScene("sussex-july-4-school-y-22") {
        page {
            dline(
                "ALEX: It's a real shame Miss Charlotte doesn't find it interesting either. " +
                "She's so good at computers! I bet she could do super awesome stuff with my radio."
            )

            line(
                "The nuances of natural science assault your brain. The conversation around " +
                "you feels like it is getting harder to hear."
            )
            newline()

            dline("JESS: Yes... she does seem to be very obstructionist.")

            dline(
                "CATE: Charlotte has her own interests, and we have ours. It is perfectly " +
                "natural."
            )

            dline("JESS: That's not what I mean. She's dismissive, constantly. It's like she's")
            newline(4)

            changeSceneButton("sussex-july-4-wh-1", ">> Next")
        }
    }


}