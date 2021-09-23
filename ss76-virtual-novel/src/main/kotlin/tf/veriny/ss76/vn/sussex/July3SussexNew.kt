package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import ktx.graphics.copy
import tf.veriny.ss76.engine.scene.Inventory
import tf.veriny.ss76.engine.scene.sceneSequence
import tf.veriny.ss76.vn.CommonScenes
import tf.veriny.ss76.vn.CommonScenes.SCHOOL_WORKING_LIFT
import tf.veriny.ss76.vn.items.CommonItemScenes

public fun registerSussexJuly3Scenes(): Unit = sceneSequence {
    setTopText("SS76 - Route One - 03/07")

    copyAndSetInventory("s3j-start-inv") {
        put("phone", CommonItemScenes.PHONE_ITEM)
    }

    createAndRegisterScene("sussex-july-3-start") {
        page {
            line("Today's date is Monday, the 3rd of July.")
            newline()

            line("It's a sunny day, with @sky@no @sky@clouds to be seen.")
            line(":push:@sky@ It hasn't rained in weeks. :pop:")
            newline()

            changeSceneButton("sussex-july-3-school-1", ">> Next")
        }
    }

    createAndRegisterOnePageScene("su3j-school-desc") {
        line(
            "You attend a coed grammar school. Grammar schools are rare sights these days, " +
            "but coed ones are even rarer."
        )
        newline()

        line(
            "It's shaped in a gigantic square. It has six floors, each of which is excessively " +
            "large. Each floor has a large gap between its roof and the floor of the one above, " +
            "and is connected by four stairwells on each corner and one stairwell directly above " +
            "the reception hall, each one coiling around an elevator."
        )
        newline()


        line(
            "The government of the time gave out an absolutely massive grant to build this. " +
            "Legend has it, one of the administrators was blackmailing a cabinet " +
            "minister about some less-than-moral wartime activities."
        )
        newline()

        line(
            "The bottom three floors have windows on the classrooms and the stairs " +
            "connecting them, but the upper three don't."
        )
        newline()

        line(
            "That's a good thing, really. The thought of looking out at that height gives " +
            "you the shivers."
        )
        newline()

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-3-school-1") {
        line(
            "It's 9 o'clock on a hot summer July day. You've just arrived at school. " +
            "It's the second to last day today. How exciting."
        )
        newline()

        line(
            "You're late just like usual. You keep ignoring your alarm and oversleeping like a dummy."
        )
        newline()

        line("But that's okay. Sixth form students are basically immune to punishment.")
        newline()

        line("You unstick your sleeves from your arms and :push:`push-scene-su3j-school-desc`@linked@ " +
             "look up at the school :pop: as you push open the gate.")
        newline()

        line("Why do schools even bother to stay open in the summer?", addNewline = false)
        changeSceneButton("sussex-july-3-school-2", "It's far too hot to pay any attention.")
    }

    createAndRegisterOnePageScene("sussex-july-3-school-2") {
        line("You make your way to the reception hall embedded in the front of the building.")
        newline()

        line(
            "The walls are lined with gleaming white tiles; they are pretty much the only " +
            "clean part of the school."
        )
        newline()

        line("The receptionist looks up at you and starts glaring. You've interrupted his crossword. Again.")
        line("You're so inconsiderate.")
        newline()

        line("He slides the sign-in book in front of you without you even needing to ask.")
        newline()

        line("Date. Time. Name. Reason for being late. Signature. It's the same routine every morning.")
        newline()

        line("You slide it back behind the glass. Not too hard, though - that would be too rebellious.")
        newline()

        line("The receptionist checks the details to make sure you're not lying.", addNewline = false)
        changeSceneButton("sussex-july-3-school-3", "He probably has your signature memorised by now.")
    }

    createAndRegisterOnePageScene("sussex-july-3-school-3") {
        line(
            "The receptionist is a failure, just like you. The rumour among the other " +
            "delinquents is that he's the son of one of the other admin staff."
        )
        newline()

        line(
            "It's so persistent that his car was even tagged with \"Mother's Boy\" at one " +
            "point. You don't really get how that's an insult."
        )
        newline()

        line("He folds the book back over and prepares to deliver his daily timeless wisdom.")
        newline()

        dline("RCPT: I hope your teachers never say anything really important.")

        dline("RCPT: For example, something you need on an exam but you didn't learn.")

        dline("RCPT: And I really hope it doesn't cause you to fail, and end up being kicked out, " +
              "which causes you to miss our daily chats.")

        changeSceneButton("sussex-july-3-school-4", "You have no comeback, so you just awkwardly walk away.")
    }

    createAndRegisterOnePageScene("sussex-july-3-school-4") {
        line("You walk past the :push:`push-scene-${SCHOOL_WORKING_LIFT.id}`@linked@ eternally " +
             "broken lift :pop: and open the door to the stairwell.")
        newline()

        line(
            "There's four floors between you and the lesson you don't care about. For some " +
            "reason the climb never seems to get any easier."
        )
        newline()

        line(
            "You wonder why you bother attending anymore. You already failed the mocks this year. " +
            "You're going nowhere in life with ABBC grades."
        )
        newline()

        line(
            "But, you've never missed a lesson entirely before. It's better for your " +
            "self-esteem if you have at least one achievement."
        )
        newline()

        changeSceneButton(
            "sussex-july-3-school-5",
            "Eventually, you reach the stop, huffing and puffing."
        )
    }

    createAndRegisterOnePageScene("sussex-july-3-school-5") {
        line(
            "Your lesson - physics - is on the fifth floor. At some point, this floor was the " +
            "school's crown jewel; the country's best possible science education."
        )
        newline()

        line(
            "Nowadays the walls are lined with unused and abandoned science labs, with only " +
            "a few safe enough to use still. The school kept it very hush-hush, so nobody really " +
            "knows what happens - only that things were not worth salvaging."
        )
        newline()

        line(
            "A handful of really stupid kids have tried breaking into the disused rooms in " +
            "the past, but it never really ended well."
        )
        newline()

        line(
            "The floor is caked in dust and grime outside of the racing line along the middle. " +
            "If you wasn't a regular visitor, you could easily imagine that this area was " +
            "completely abandoned."
        )
        newline()

        line(
            "The noise of your footsteps is overshadowed by the chattering of students as " +
            "you approach the door to your classroom."
        )
        newline()

        changeSceneButton("sussex-july-3-school-6", "It creaks obtrusively as you open it.")
    }

    createAndRegisterOnePageScene("sj3-friends-1") {
        line("You have three friends. (What a loser.) Only one takes this subject, though.")
        newline()

        line(
            "You've known them since Year 7. Nobody from your old primary school passed " +
            "the entrance exam, so you had to make new friends. Naturally, you gravitated towards " +
            "the weirdos."
        )

        line("They are:")
        newline()

        pushSceneButton(
            CommonScenes.CHAR_BIOGRAPHY_1.id,
            "Charlotte 'Char' Philips,"
        )
        line("the most normal girl in existence")

        pushSceneButton(
            CommonScenes.ALEX_BIOGRAPHY_1.id,
            "Alexander 'Alex' Ashton,"
        )
        line("a hyperactive rat")

        pushSceneButton(
            CommonScenes.CATE_BIOGRAPHY_1.id,
            "Catherine 'Cate' Schwartz,"
        )
        line("the concept of virtue signalling given life")
        newline()

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-3-school-6") {
        line("Everyone is too wrapped up in their discussions to notice your extremely " +
             "non-sneaky entry. Doubly luckily, your teacher clearly hasn't arrived yet.")
        newline()

        line("You noisily tip-toe over to your regular seat around the workbench in the " +
             "middle of the room.")
        newline()

        line(
            "Your :push:`push-scene-sj3-friends-1`@linked@ best friend :pop: is sitting next to you."
        )
        newline()

        dline("CHAR: Did you know the katana is a stupid sword? Also, you're early today.")

        line(
            "Char sits there with her standard issue stationary: Two patterned A4 notebooks and " +
            "a fancy Japanese pen. She's so well-organised."
        )
        newline()

        dline("CHAR: You look like a mess. Did a monkey put that uniform on for you?")

        changeSceneButton(
            "sussex-july-3-school-7",
            "She reaches over and fixes your tie and collar."
        )
    }

    createAndRegisterOnePageScene("sussex-july-3-school-7") {
        dline(
            "CHAR: I hope you have your retard inhibitors on today. The rat texted me this " +
            "morning with something incoherent that he's going to expose us to at break."
        )

        line("The door bursts open and your physics teacher storms in, clearly furious.")
        newline()

        dline(
            "????: My apologies, children. I had to take some textbooks back to the library " +
            "and, well, you all know how slow that old git is."
        )

        line(
            "He walks to his desk at the front of the room and pulls a massive stack of papers " +
            "out of a drawer."
        )
        newline()

        dline(
            "????: Now, I know it's the last week but next year is crucially important for " +
            "your education. I've prepared some summer homework for everyone."
        )

        line("A massive groan shakes the walls.")
        newline()

        dline("????: It's also personalised, so there's no cheating.")

        changeSceneButton("sussex-july-3-school-8", "He walks around the class, handing them out.")
    }

    copyAndSetInventory("s3j-homework") {
        val homework = CommonItemScenes.PHYS_HW_ITEM
        put("physics-hw", homework)
    }

    createAndRegisterOnePageScene("sussex-july-3-school-8") {
        line("He drops your scarily massive homework bundle in front of you.")
        newline()

        line(
            "Mysteriously, Char's homework bundle flies through the air to drop in front of " +
            "you, too."
        )
        line(":push:@violet@ Physics Homework has been added to your inventory. :pop:")
        newline()

        dline(
            "CHAR: With your grades, you would get much better usage out of this than I " +
            "would. Good luck."
        )

        line(
            "You peer inside. The finer details of AS mechanics threaten to lunge from the " +
            "page and attack your head. You slam the paper shut and slide them both into your bag."
        )

        dline("????: Now, we have one more thing to cover on moments.")
        newline()

        changeSceneButton("sussex-july-3-break-1", "The minutes crawl by painfully.")
    }

    createAndRegisterOnePageScene("sussex-july-3-break-1") {
        line("The lesson eventually ends, and you take your extended break. Normally you would " +
             "have form time before it, but it's been cancelled for the Year 12s this week.")
        newline()

        line("Your break spot is outside a fire exit at the front of the school. It's nice and " +
             "secluded away from most of the native idiot population here.")
        newline()

        line("Unfortunately, two members of the species have made their way here too - your " +
             "two missing friends.")
        newline()

        line("Cate is sitting on top of a metal bar like a meditating monk. She's so excessive.")
        line("Alex is dancing around like he really needs to go to the toilet.")
        newline()

        changeSceneButton(
            "sussex-july-3-break-2",
            "You set your bag down and jump up on the bar too."
        )
    }

    createAndRegisterOnePageScene("su3j-holiday") {
        line("You haven't been on holiday for a few years now. Money has simply been too tight.")
        newline()

        line("This year, however, your mother got a promotion and a sizeable pay increase, " +
             "enough to afford a holiday every year.")
        newline()

        line("They always wanted to rent a holiday boat and this year they finally got the " +
             "chance.")
        newline()

        line(
            "However, being stuck on a boat in the middle of East Anglia with nothing to do " +
            "is one of the circles of hell for anyone below the age of forty, so you opted out."
        )
        newline()

        line("Instead, you're going to stay at Alex's house for a while. He's been bragging " +
             "about the construction work that's been done for a while now.")
        newline()

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-3-break-2") {
        dline("CATE: Good morning. How are you two today?")

        dline("CHAR: We're fine, although that bald bastard gave us summer homework.")

        dline("ALEX: I'm super duper fine too! I can-")

        dline("CHAR: I don't care what you are.")

        dline(
            "ALEX: 't wait for the summer! We had some super duper cool new stuff " +
            "installed just in time for the summer!"
        )

        pushSceneButton(
            "su3j-holiday",
            "You and your friends are spending three weeks at Alex's house this summer."
        )
        newline()

        dline("CHAR: Yeah, yeah, yeah. What nonsense was it that you wanted to tell us?")

        changeSceneButton(
            "sussex-july-3-break-3",
            "ALEX: Oh! Yes! Has anyone here heard of number stations?"
        )
    }

    createAndRegisterScene("sussex-july-3-break-3") {
        page {
            line("Everyone here knows about number stations. Alex has explained them multiple times before.")
            newline()

            dline("CHAR: We all know what a number station is. You've explained them before, idiot. Several. Times.")

            dline("ALEX: Well, a number station is something used by ultra-super-secret government spies.")

            line("Here he goes again. Alex really likes to talk about things nobody cares about.")
            newline()

            dline(
                "ALEX: The government transmits strings of numbers to the ultra-super-secret " +
                "spies."
            )

            line("Maybe he should keep this ultra-super-secret to himself.")
            newline()

            changeSceneButton(
                "sussex-july-3-school-12-1",
                "You're certain he would literally explode if he did that, though."
            )

        }
    }

    createAndRegisterScene("sussex-july-3-school-12-1") {
        page {
            dline("CATE: Why do they do that?")

            dline(
                "ALEX: Oh! Fantastic question! Well, when you're an ultra-super-secret spy, " +
                "you can't just phone someone up and ask them ultra-super-secret details!"
            )

            dline("CATE: Because somebody could be eavesdropping, right?")

            line(
                "Cate is trying to show off with her stupid interjections. " +
                "She probably secretly resents how everyone knows she isn't smart."
            )
            newline()

            dline(
                "ALEX: Yes! That's why!Instead, the government sends out special radio signals " +
                "that the spies pick up."
            )

            dline(
                "CHAR: Are you a spy? I don't see any other reason for this stupid " +
                "explanation."
            )

            dline(
                "ALEX: Well, I've discovered something. Something really cool, and really " +
                "awesome."
            )

            changeSceneButton(
                "sussex-july-3-school-13",
                "He has to calm himself down for a moment."
            )

        }
    }

    createAndRegisterScene("sussex-july-3-school-13") {
        page {
            dline("ALEX: I think I've found one nearby!")

            dline("CATE: Wow, really? Where is it?")

            dline("ALEX: I don't know!")

            line("He giggles to himself as if that was the funniest joke ever told.")
            newline()

            dline(
                "ALEX: I know it's nearby because the signal is really, really, really " +
                "strong on my", addNewline = false
            )
            pushSceneButton("side.sussex.alex-radio-0", "radio set.")
            newline(2)

            dline(
                "CHAR: Dummy. How does that prove it's nearby? It could just have a strong " +
                "signal."
            )

            line("Char has gotten involved with this nonsense too, now.")
            newline()

            line("ALEX: Well,", addNewline = false)
            changeSceneButton("sussex-july-3-school-14", "take a listen!")
        }
    }

    createAndRegisterScene("sussex-july-3-school-14") {
        page {
            line("Alex takes out his phone, and starts swiping up and down randomly.")
            newline()

            line("Everyone stands there in awkward silence for a minute, watching him.")
            newline()

            repeat(3) {
                line("..." + (" ".repeat(20)))
                newline()
            }

            dline(
                "ALEX: Aha! Found it! I've got so many recordings! So many cool and awesome " +
                "recordings! It takes a while to sort through them!"
            )

            line("He holds his phone up sideways and everyone leans in to hear better.")

            changeSceneButton("sussex-july-3-school-15", "He plays the recording.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-15") {
        page {
            line("A long, high-pitched pulse." + " ".repeat(20))
            newline()

            line("Then, a heavily slowed down song starts playing." + " ".repeat(20))
            newline()

            line("Then, a woman's voice. She says a string of numbers:")
            newline()

            line("SEVEN" + " ".repeat(15))
            line("SIX" + " ".repeat(15))
            line("FOUR" + " ".repeat(15))
            line("SEVEN" + " ".repeat(15))
            line("SEVEN" + " ".repeat(15))
            newline()

            line("Finally, a short high-pitched pulse,", addNewline = false)
            changeSceneButton("sussex-july-3-school-16", "and the sound stops.")
        }
    }

    createAndRegisterScene("sussex-july-3-school-16") {
        page {
            line("Alex is practically shaking in glee.")
            newline()

            dline("ALEX: Don't you wonder what that means? The pulses, do they have meanings?")

            dline("CATE: Maybe the pulses are for synchronisation, of some equipment?")

            line(
                "You bet Cate feels really smart for bringing that up. She always has to " +
                "show off."
            )
            newline()

            dline(
                "ALEX: Whoa. Good thinking! That's totally what's happening. " +
                "But what about the numbers?"
            )

            dline("CHAR: Dummy. Why do you care? These signals aren't for you.")

            line("Char is right. Alex is just eavesdropping.")
            newline()

            dline("ALEX: I have to know! I love", addNewline = false)
            changeSceneButton("sussex-july-3-school-i-1", "mysteries!")
        }
    }

    createAndRegisterScene("sussex-july-3-school-i-1") {
        page {
            dline("ALEX: Number stations are really weird and really secret and really freaky.")

            dline("ALEX: I'm gonna go mental if I can't solve this!")

            dline(
                "CATE: Surely the beauty of mysteries is not knowing the solution? You would get " +
                "bored rather quickly if you could solve every one of them."
            )

            dline(
                "CHAR: That's a stupid statement. What good is a mystery if you can't find " +
                "the answer? That's why I hate those stupid true crime podcasts."
            )

            dline("ALEX: Don't worry! Me and Cate are on the case! We'll figure it out!")

            dline("CHAR: Fine. Go pretend to be an idiotic detective. Just don't do it here.")

            changeSceneButton(
                "sussex-july-3-break-4",
                "The faint sound of a bell from inside signifies the end of breaktime."
            )
        }
    }

    createAndRegisterOnePageScene("su3j-ruler") {
        line("Char has a pocket sewn into the Inside of her jacket with a few essential items.")
        newline()

        line(
            "She has a small A7 notebook which she uses to take notes about things, alongside a " +
            "matching pen."
        )
        line("It seems like she goes through at least one per day.")
        newline()

        line(
            "She has a thirty centimetre metal ruler up there, which is useful either as " +
            "body armour or for thwacking idiots. It's not classed as a weapon, so it's all legal."
        )
        newline()

        line("There's some other items up there, but you've never been allowed to see them.")
        newline()

        line("She doesn't let anyone else know she has this, not even the idiots. It would be " +
             "quite embarrassing, wouldn't it?")
        newline()

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-3-break-4") {
        dline(
            "CATE: We have a free period next, so we will find a computer room and do some " +
            "analysis."
        )

        dline("CHAR: We have a lesson next, hopefully in a room far away from you two.")

        dline("ALEX: Just five more periods until the summer holiday! Bye-bye!")

        line("Dumb and dumber pry open the fire door and depart to ruin someone's lesson. " +
             "You hold it open with your foot and turn to see if Char is following you.")
        newline()

        dline(
            "CHAR: We shouldn't rush. It's the last week. I don't even know why we've " +
            "bothered coming in."
        )

        line(
            "Char pulls out her `push-scene-su3j-ruler`@linked@notebook and starts writing " +
            "something down."
        )

        dline("CHAR: You know, it's just too hot today. I hate summer.")

        changeSceneButton(
            "sussex-july-3-ts-1",
            "She pushes past you and walks down the corridor to your lesson."
        )
    }

    createAndRegisterOnePageScene("su3j-reserved") {
        line(
            "Don't underestimate the persuasive power of a swift chop to the fingers with a " +
            "metal ruler."
        )
        newline()

        backButton()
    }

    createAndRegisterOnePageScene("sussex-july-3-ts-1") {
        line(
            "The next lesson passes just as slowly as the first. Maths isn't your strong " +
            "point. Although, all your subjects are based on maths in some way. Why did you even " +
            "take them?"
        )
        newline()

        line("It's lunchtime now. You enter the cafeteria and make your way to your " +
             "`push-scene-su3j-reserved`@linked@reserved table directly in the middle of the hall.")
        newline()

        line("Cate and Alex are already here and have finished their lunches. " +
             "Cate has an spotless plate in front of her. Alex has three empty crisp packets in " +
             "front of him.")
        newline()

        line(
            "Char sits down with both your food and hers in her hands. She has a bacon sarnie, " +
            "and you have plain tomato soup."
        )
        newline()

        line("It tastes of tomato.")
        newline()

        changeSceneButton("sussex-july-3-ts-2", "Alex starts to vibrate in his seat.")
    }

    createAndRegisterOnePageScene("sussex-july-3-ts-2") {
        line("Char takes a bite out of her sandwich.")
        line("Alex shakes even faster.")
        newline()

        line("Char takes another bite out of her sandwich.")
        line("Alex appears to be forming a ghostly double image.")
        newline()

        line("Char takes another bite, dragging a slice of bacon out.")
        line("Alex's wavelength is so high he's disrupting local wifi networks.")
        newline()

        line("Char finishes her sandwich.")
        newline()

        dline("CATE: Charlotte, I think Alex wants to tell you something.")

        changeSceneButton("sussex-july-3-ts-3", "Char wipes her mouth with her napkin.")
    }

    createAndRegisterOnePageScene("sussex-july-3-ts-3") {
        dline("CHAR: Pleasant day today, isn't it?")

        line("He can't hold it in anymore. A hard chunk of verbal diarrhoea leaks from Alex's " +
             "mouth, followed by soft chunks of crisp remnant.")
        newline()

        dline("ALEX: Yergeddaferdareddearra!")

        dline("CHAR: Oh no. He's gone retarded. He's forgotten how to say words.")

        dline("ALEX: Imjustsoexciteditshardtofindthewords!")

        dline("CATE: Slow down. Think before you say each word.")

        dline("ALEX: Okay! We've done lots of thinking the last period!")

        dline("CHAR: That's great to hear. We have a free this afternoon, so we're going home now.")

        changeSceneButton("sussex-july-3-deduction-1", "Alex completely ignores Char.")
    }

    clearColour(Color.SLATE)
    setTopText("SIGNALLING SYSTEM 76")

    createAndRegisterScene("sussex-july-3-deduction-1") {
        page {
            dline("ALEX: Okay! ")

            dline(
                "ALEX: I was checking my files, and for some reason there was one really " +
                "extremely long recording."
            )

            dline(
                "ALEX: Turns out, I forgot to stop recording the signal! It goes on for " +
                "ten super duper long minutes!"
            )

            dline(
                "CATE: The recording started at 5:55, and ends at 6:07. " +
                "The signal repeats every minute, at seven seconds."
            )

            dline("CATE: The one we heard today was played at 5:55.")

            line("Cate is talking like she's a BBC news presenter.")
            newline()

            changeSceneButton("sussex-july-3-deduction-2", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-3-deduction-2") {
        page {
            dline("ALEX: However! We noticed something really very interesting!")

            dline("CATE: At 06:03, the message changed. Four of the numbers decremented by one.")

            dline("ALEX: It's a timestamp! The numbers are hours! When the hour ticks over each " +
                  "number changes by one!")

            dline("CATE: It seems most likely that the numbers are a set of distinct countdowns.")

            dline("CATE: We do not know what they are counting down to, or how long each decrement represents.")

            line(
                "Cate was really getting into character. It would be almost cute if she " +
                "wasn't so sickening."
            )
            newline()

            changeSceneButton("sussex-july-3-deduction-3", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-3-deduction-3") {
        page {
            dline("CATE: Interestingly, the fourth number didn't change.")

            dline(
                "ALEX: Yeah! It must mean seventy-seven, not two sevens! It's a super duper " +
                "cool double counter!"
            )

            dline(
                "CATE: So, assuming that it is an hourly counter, that gives us a breakdown " +
                "for all of the digits."
            )

            dline(
                "CATE: The first digit reached zero at approximately midnight last night." +
                "The second digit reached zero at 22:03, and the third at 21:03."
            )

            dline("CATE: The fourth and final digit will reach zero at 22:03, on the 6th of July.")

            dline("ALEX: Three days! Three long days! I can barely wait such an extremely ultimately long time!")

            changeSceneButton("sussex-july-3-deduction-4", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-3-deduction-4") {
        page {
            dline("CATE: This raises several questions.")

            dline("ALEX: First! What the hell do the numbers mean!")

            dline("ALEX: Second! Where the hell are the numbers coming from!")

            dline("ALEX: Third! What happens in three days time!")

            dline("CATE: Tonight, Alex will record as much as possible. Tomorrow, we will " +
                  "find if these are truly hourly counters, and what happens when they reset.")

            dline("ALEX: That was our totally awesome explanation!")

            changeSceneButton("sussex-july-3-school-i2-8", "You are not impressed.")
        }
    }

    clearColour(Color.BLUE.copy(blue = 200/255f))
    setTopText("SS76 - Route One - 03/07")

    createAndRegisterScene("sussex-july-3-school-i2-8") {
        page {
            line("Alex got a bit too excited there. The people from the neighbouring tables " +
                 "are looking over at him. Unfortunately, he has no humility.")
            newline()

            dline("CHAR: :push:¬shake¬ Do not yell. :pop: You are embarrassing me.")

            line("He suffers a ruler strike to the head, which leaves a mighty gash.")
            newline()

            dline("CATE: Charlotte, you really should not do that...")

            dline("CHAR: It's his own fault. Anyway, we're going home now.")

            line("Alex sits back down, rubbing his head. A good disciplinary smack is usually " +
                 "the only thing that affects his annoying disposition.")
            newline()

            dline("ALEX: Sorry... Miss Charlotte... I won't yell.")

            changeSceneButton(
                "sussex-july-3-school-i2-9",
                "He slinks down into his seat, holding back tears."
            )
        }
    }

    createAndRegisterOnePageScene("sussex-july-3-school-i2-9") {
        line(
            "Char gets up out of her chair and puts her bag on. Officially, you're not " +
            "allowed to leave school during a free - but, who's going to check?"
        )
        newline()

        dline("CHAR: It's the last day tomorrow.")

        line("She starts walking away, and you follow.")
        newline()

        dline("ALEX: Wait, hold on, Miss Charlotte. I have something for you.")

        line("The snivelling mess walks up to her and hands her an folded-over piece of paper.")
        newline()

        dline("ALEX: My dad wrote letters for all of you guys. This is yours.")

        dline("CHAR: Did you read it?")

        dline("ALEX: Well, it wasn't in an envelope...")

        line("It's written on a piece of notebook paper.", addNewline = false)

        changeSceneButton(
            "sussex-july-3-school-i2-10",
            "You peer over Char's shoulder to take a look at what it says."
        )
    }

    createAndRegisterOnePageScene("sussex-july-3-school-i2-10") {
        line("A friend of mine,")
        newline()

        line(":push:¬shuftxt¬ You are a stupid, overeager little rat, aren't you, eh?")
        newline()

        line("I'm pointing at you, I'm pointing at you, but I'm not actually addressing you, " +
             "I'm addressing the one prat in the country who's bothered to decompile the " +
             "scene code, take a read and actually work out the rubbish that I'm saying. " +
             "What a poor, sad life he's got!"
        )
        newline()

        line(
            "Frankly, your dialogue is crap anyway, anybody coulda done it, I hate the lot of you, " +
            "bollocks to you! :pop: "
        )

        line("From")
        newline()

        changeSceneButton("sussex-july-3-school-i2-12", "The words seem to swirl on the page.")
    }

    createAndRegisterOnePageScene("sussex-july-3-school-i2-12") {
        line(
            "The colour drains from Char's face and she reads it. She finishes it, folds it " +
            "over into a nice square, and files it into her notebook."
        )
        newline()

        dline("CHAR: Your dad wrote this?")

        dline("ALEX: Yeah... I think so... I don't get to see him much.")

        dline("CHAR: You're absolutely sure? Nobody else?")

        dline("ALEX: No... he doesn't even let the maids up there. He cooks his own food.")

        dline("CHAR: Okay. Thank you for giving me this.")

        line("She pulls a plaster out from her sleeve and pastes it onto Alex's forehead.")
        newline()

        dline("CHAR: I'll see you tomorrow.")

        changeSceneButton("sussex-july-3-walk-1", "You exit the building.")
    }

    clearColour(Color.BLUE)

    createAndRegisterScene("sussex-july-3-walk-1") {
        page {
            line(
                "Char insists on walking you home every day. You both live on the same street, " +
                "so it makes sense to walk together."
            )
            newline()

            line(
                "It's a mile walk. You trail behind her in silence, as she explains topics " +
                "you're far too stupid to understand. She's very good at explaining, though."
            )
            newline()

            line("You cut through the local", addNewline = false)
            pushSceneButton(CommonScenes.HEATHLAND.id, "heathland")
            line("as a shortcut.")
            line("The smell of burnt plants forces its way into your nose.")
            newline()

            dline(
                "CHAR: Ugh, some idiot probably flicked a cigarette down there. Someone " +
                "just kill all smokers."
            )

            changeSceneButton("sussex-july-3-walk-2", "Your mother was a smoker.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-2") {
        page {
            line(
                "Was. She gave it up ten years ago, so she would be spared. You agree with the " +
                "idea."
            )
            newline()

            line(
                "Char continues about the virtues of smoker genocide until you're at your " +
                "home road."
            )
            newline()

            line(
                "You live in a small suburb, in a small 2-bedroom terraced council house with " +
                "your parents. Nobody lives to the left of you. Nobody lives to the right of you."
            )
            newline()

            line("Those houses haven't been occupied for as long as you can remember.")
            newline()

            line("Char lives", addNewline = false)
            changeSceneButton("sussex-july-3-walk-3", "across the road from you.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-3") {
        page {
            line(
                "Char's house is much bigger than yours. It has absorbed the two plots " +
                "alongside it to create a six bedroom majesty."
            )
            newline()

            line(
                "Char's parents have installed all this fancy energy saving technology, " +
                "so the windows are always dark from the outside no matter what."
            )
            newline()

            line(
                "It has a massive front garden full of wild flowers and home grown " +
                "vegetables. The flowers are such that something is always in season, year-round, " +
                "making for a stunning display."
            )
            newline()

            line("It makes your house look quite", addNewline = false)
            changeSceneButton("sussex-july-3-walk-4", "pathetic")
            line("in comparison.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-4") {
        page {
            line(
                "Char stands by the side of the road, watching you as you walk to your front " +
                "door."
            )
            newline()

            line("You fumble with your keys, dropping them by accident. You can somehow feel the eye " +
                 "roll behind you.")
            newline()

            line("You enter and close the door behind you. ")
            newline()

            line(
                "It's only just gone 4 o'clock, but it's still surprisingly dark inside."
            )
            newline()

            line(
                "Your parents aren't home. They work until five. They don't pay you very " +
                "much attention anyway."
            )
            newline()

            changeSceneButton("sussex-july-3-walk-5","You make your way to your bedroom.")
        }
    }

    createAndRegisterScene("sussex-july-3-walk-5") {
        page {
            line("You look out the window. Your window faces forward.")
            line("Char is still there, looking for you.")
            newline()

            line(
                "You're glad she cares about you enough to see if you've gone upstairs. " +
                "You wouldn't want to trip over, break your neck, and have nobody realise for three " +
                "hours."
            )
            newline()

            line(
                "She gives you a smile, a wave, and walks away to her home. You draw the " +
                "curtains and turn on your lamp. It's almost night-time, and you can barely see."
            )
            newline()

            line("You sit down at your computer.")
            newline()

            line("Your phone starts to ring. The shrill tones hurt your head.")
            newline()

            line("Your mind goes hazy, and you go to bed.")
            newline()

            changeSceneButton("sussex-july-4-start", ">> Next")
        }
    }
}

