package tf.veriny.ss76.vn.sussex

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

            dline("JESS: First, you are rude are dismissive towards this, insulting my friends.")

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

            dline("CHAR: Now, if you don't mind, I'll be picking up my food.")

            dline("JESS: No, wait, that's not what I meant, you evil bitch.")

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
            dline("JESS: I ran into Mr Hammond earlier. You know, your physics teacher.")

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

            line("JESS: You're going to get fat and ugly if you eat so much pizza.")
            line("CHAR: ")

        }
    }
}