package tf.veriny.ss76.vn.deprecated

import com.badlogic.gdx.graphics.Color
import ktx.graphics.copy
import tf.veriny.ss76.SS76
import tf.veriny.ss76.engine.scene.createAndRegisterScene


public fun registerSussexJuly5Pt2Scenes() {
    createAndRegisterScene("sussex-july-5-start-2") {
        topText = "SS76 - Route One - 05/07"

        page {
            line("Today's date is Wednesday, the 5rd of July.")
            newline()

            line("It's just gone @teal@13:00.")
            newline()

            line("It's a @sky@mildly @sky@cloudy day.")
            line("It hasn't rained in as long as you can remember.")
            newline()

            changeSceneButton("sussex-july-5-mansion-1", ">> Next")
            //changeSceneButton("demo-meta-menu", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-1") {
        page {
            line(
                "Alex lives in what is basically a dream house. It's in another town " +
                "entirely - about a thirty minute drive away."
            )
            newline()

            line(
                "His dad had it built two years ago, when his grandparents did actually " +
                "die and left him with a sizeable inheritance."
            )
            newline()

            line(
                "It has twenty bedrooms, four floors, an indoor and outdoor swimming pool, " +
                "an underground bunker for the impending zombie apocalypse, and a full-time staff " +
                "of maids, chefs, gardeners, and security."
            )
            newline()

            // n'wah
            line(
                "However, his dad is a proper nutter. He makes outsiders do a twenty minute " +
                "decontamination process before they're allowed inside the gates, so coming here is " +
                "something you need to plan for."
            )
            newline()

            changeSceneButton("sussex-july-5-mansion-2", "It's extremely unpleasant.")
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-2") {
        page {
            line(
                "You arrived here at around 10 o'clock, and you was thoroughly disinfected " +
                "half an hour later."
            )
            newline()

            line("Char led herself to her favourite guest room and barricaded herself in there " +
                 "for an hour to recover.")
            newline()

            line(
                "Alex left briefly for the school to recover some of the equipment left " +
                "behind."
            )
            newline()

            line("Jess left a while back because she had a lesson. (Loser.)")
            newline()

            line(
                "Finally, Cate was giving unwanted help to the maids. She would die if she " +
                "didn't show how virtuous she was on a daily basis."
            )
            newline()

            changeSceneButton("sussex-july-5-mansion-3",
                "Now, everyone has been summoned for lunch."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-3") {
        page {
            line(
                "This dining room may be the smallest of the four, but that doesn't stop it " +
                "from being pointlessly excessive."
            )
            newline()

            // akwardly forced metaphor
            line(
                "The table is designed to fit eight people, albeit with enough room " +
                "between them you have to pack your suitcase to change seat."
            )
            newline()

            line(
                "The walls are painted a horrible dark pink - the kind of colour you would " +
                "only paint as a joke. The ceiling has an awful modernist LED chandelier hanging " +
                "over the table."
            )
            newline()

            line(
                "Char and Alex sit down at the heads of the table. You and Cate sit next to them " +
                "on opposite sides. A maid pokes her head through the doors to tell everyone that",
                addNewline = false
            )
            changeSceneButton("sussex-july-5-mansion-4", "lunch will be in a few minutes.")
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-4") {
        page {
            dline("ALEX: It's super duper good that you're awake again, Miss Charlotte.")

            dline(
                "CATE: Yes, it is. I was quite worried about you. It is very unusual for you " +
                "to faint like that."
            )

            dline(
                "CHAR: Shut it. Whoever designed this house was such a massive idiot. These " +
                "bright lights always give me headaches."
            )

            dline("ALEX: They have to be bright; they're really really cool ultraviolet lights!")

            dline("CHAR: They're ¬shake¬what?")

            dline(
                "ALEX: Didn't you get sprayed at the gate? They put suncream on you so that " +
                "the lights don't burn you alive!"
            )

            dline("CHAR: What actual fucking nutter installs ultraviolet lights inside a house?")

            changeSceneButton(
                "sussex-july-5-mansion-5",
                "You now understand why your eyes feel so sandy."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-5") {
        page {
            dline("ALEX: Well, you know my dad.")

            dline("CHAR: No, I don't, actually.")

            dline("ALEX: Anyway! Lunch! I ordered everything specially for everyone!")

            line(
                "Meals at the Dummy Mansion work differently. There's one big meal early in " +
                "the afternoon, and then small snacks in the late evening. It's hell if you're not " +
                "used to it."
            )
            newline()

            dline("CATE: I hope my meal is not burnt like it was last week.")

            line(
                "The door opens and four maids come in, carrying large trays with those " +
                "stereotypical movie metal domes on top."
            )
            newline()

            changeSceneButton(
                "sussex-july-5-mansion-6",
                "They place the meals on the table and leave, wordlessly."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-6") {
        page {
            line("Cate has some kind of vile vegan pie, filled with the souls of dead plants.")
            line("Even her meals are pretentious.")
            newline()

            line("You have chicken soup.")
            newline()

            // What do you think of the picket fence?
            line(
                "Alex has a log cabin made out of chocolate fingers. That's not a meal."
            )
            line("Hopefully the person that made it realises their talents are wasted here.")
            newline()

            line("Char has the best meal; a still steaming hot fry up. " +
                 "Smoked back bacon, Cumberland sausages used as a breakwater between the beans and " +
                 "the perfectly fried egg, and a side of hot buttered medium brown toast and hash browns."
            )
            newline()

            changeSceneButton("sussex-july-5-mansion-7", "Everyone digs in.")
        }
    }

    val alexFloor = createAndRegisterScene("sussex-july-5-mansion-alex-floor") {
        page {
            line(
                "The ground floor of the mansion is the dining rooms, the pool, and assorted " +
                "unfurnished rooms."
            )
            newline()

            line(
                "The first floor is guest bedrooms and rooms used by the fleet of " +
                "housekeepers."
            )
            newline()

            line(
                "The second floor is entirely used by Alex. His bedroom and his various computer " +
                "and leisure rooms cover the entire floorplan. It's truly too much for one person."
            )
            newline()

            line("The way up to the third floor is blocked by two mean looking security men.")
            newline()

            backButton()
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-7") {
        page {
            line("After the meal, everyone goes up to Alex's", addNewline = false)
            pushSceneButton(alexFloor.id, "floor.")
            newline(2)

            line(
                "Alex pushes open the door to his main bedroom and falls backwards onto his " +
                "(excessively large) bed, and lies motionless. You stare at him through the " +
                "doorway."
            )

            dline("ALEX: I ate way way way more than I should and I am going to die.")

            dline("CATE: Do you want me to turn the light off?")

            dline("ALEX: That would be super appreciated.")

            line("Cate turns the light off and closes the door behind her.")
            newline()

            dline("CHAR: That'll teach him to eat real food next time. What an idiot.")

            dline("CATE: Do you want to see the new VR room?")

            changeSceneButton("sussex-july-5-mansion-8", "Char is already off.")
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-8") {
        page {
            line(
                "The room is massive. It has two of those experimental unidirectional " +
                "treadmills in the centre so that one can walk in real life and have it transmit " +
                "to the game."
            )
            newline()

            line(
                "There's cables running to a handful of computer towers in the corner, and " +
                "a projector displaying what's running on the VR kit."
            )
            newline()

            line("Char's eyes practically glow when she sees it.")
            newline()

            dline(
                "CHAR: Oh my. I've only ever heard rumours about this system. How did the " +
                "rat manage to get this?"
            )

            dline(
                "CATE: There are quite a few multiplayer games loaded onto it. I will play " +
                "alongside you."
            )

            dline(
                "CATE: Also, Jessica will be back this afternoon. I am sure she will also " +
                "play the games with you."
            )

            changeSceneButton("sussex-july-5-mansion-9", "Char is already strapped in.")
        }
    }

    createAndRegisterScene("sussex-july-5-mansion-9") {
        page {
            dline(
                "CATE: I do hope we make an effective team. I have played this game with " +
                "Alex but he does not do very well."
            )

            dline("CHAR: Yeah, yeah, whatever. I'll carry you, easy.")

            dline("CATE: Good. Let us make good use of the next six hours.")

            dline("CHAR: Why six? I could play this forever!")

            dline(
                "CATE: Alex wants to show us something this evening, outside. He has been quite " +
                "excited about it."
            )

            dline("CHAR: Great.")

            line(
                "Cate puts the headset on, and they both start playing the game. You sit and " +
                "watch on the projector."
            )
            newline()

            changeSceneButton("sussex-july-5-evening-1", "Eventually, night falls.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-1") {
        page {
            line(
                "Alex leads us to a spot in the garden, far away from the main house. It was " +
                "hidden in amongst the trees."
            )
            newline()

            line(
                "A small white-painted gazebo has been built here. It's very haphazardly " +
                "assembled, clearly by somebody who is very unskilled. There's eight chairs, laid out in " +
                "an octagon on the decking."
            )
            newline()

            dline(
                "ALEX: I had to sneak this stuff in myself, through one of the holes in the " +
                "back gate. I felt like a super duper cool secret spy!"
            )

            dline(
                "ALEX: It's just far enough that nobody from the house should be able to see " +
                "us."
            )

            dline("CATE: You built this yourself? That is very impressive.")

            line("Nails stick out from the wood. The paint is as thick as a thumb in some " +
                 "areas and already flaking off in others. It's", addNewline = false)
            changeSceneButton("sussex-july-5-evening-2", "not impressive at all.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-2") {
        page {
            dline("JESS: Yes, it's rather... you did well for your skill!")

            dline(
                "ALEX: I'm glad you super duper love it! I know it's a pain, but you guys " +
                "should come around here more often! I had this built just for us!"
            )

            dline(
                "JESS: It's a bit... dark. I'm sure some of our stupider friends might trip " +
                "and she might die."
            )

            line(
                "At that, Alex runs around the back and starts scurrying across the ground, completing " +
                "his transformation from human to rodent."
            )
            newline()

            dline("ALEX: Oh! I can't find it! It must've been buried!")

            line(
                "He starts digging. You don't know what he's looking for, but it's probably " +
                "not important if it's underground."
            )
            newline()

            dline("CATE: Alex, I think you left it on the deck last time.")

            changeSceneButton(
                "sussex-july-5-evening-3",
                "His dirt-covered head pops up at the other side of the gazebo."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-3") {
        page {
            dline("ALEX: Oh! That's right! Okay, let's see...")

            line(
                "Alex picks up a small white box, with cables coming out of both sides, and " +
                "starts fiddling with it."
            )
            newline()

            line("You're blinded. You take a step back and shield your eyes, and try and look up at " +
                 "the absolute disaster of a light job that the gazebo is covered in.")
            newline()

            dline("CHAR: Ack! What the hell! I can't see anything!")

            dline("JESS: Ack! I'm going blind!")

            line(
                "Cate put on a pair of sunglasses whilst nobody was looking. She just smiles " +
                "incessantly, as per usual."
            )
            newline()

            dline("ALEX: Oops! Sorry! I'll turn it down!")

            changeSceneButton(
                "sussex-july-5-evening-4",
                "The lights dim to an only mildly too bright level."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-4") {
        page {
            line("Now it is actually visible. You take in the majestic sight before you.")
            newline()

            dline("CHAR: It looks like a fucking Christmas tree.")

            line(
                "The gazebo is wrapped in all kinds of light strips: neon lights, LED " +
                "christmas lights, even some regular white LED bulbs."
            )
            newline()

            line("JESS: Well... it's certainly not dark anymore.")
            line("CHAR: I wish it was.")
            line("JESS: It's better than anything you could make.")
            newline()

            dline("ALEX: Okay! Now we can see! I even took some special chairs from the house!")

            changeSceneButton("sussex-july-5-evening-5", "Everyone claims a chair and sits down.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-5") {
        page {
            dline("JESS: Wow. These are really nice chairs. I can feel myself sinking...")

            dline("CHAR: What's with the extra chairs? Who are those for?")

            dline("ALEX: What extra chairs?")

            line("There's only five chairs here, arranged in a hexagon.")
            newline()

            dline(
                "CATE: The final counter expires tonight. This is a perfect location to see " +
                "what happens, is it not?"
            )

            dline("ALEX: I hope something super duper cool happens! We've waited three days for this!")

            dline("CHAR: Nothing is going to happen, idiots.")

            changeSceneButton("sussex-july-5-evening-6", "Something deep in your mind thinks otherwise.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-6") {
        clearScreenColour = Color.BLUE.copy(blue = 250/255f)

        page {
            dline("CHAR: No, nothing is going to happen. That's definite.")

            dline("JESS: We heard you the first time, stupid.")

            dline(
                "CATE: The night sky is really clear tonight. I think we could make some good " +
                "observations even from here."
            )

            dline(
                "CHAR: I can barely see my own hands with how bright these lights are. " +
                "There's no way we'll see anything in the sky."
            )

            dline("ALEX: I'll dim the lights even further! I love looking at the sky!")

            line("The lights cut out. It's pitch black, once again.")
            newline()

            dline("CATE: When I was a small child, my father would let me look through his " +
                  "telescope at the planets. I do believe I remember where they are.")

            changeSceneButton("sussex-july-5-evening-7", "Cate starts pointing things out.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-7") {
        clearScreenColour = Color.BLUE.copy(blue = 245/255f)

        page {
            dline("CATE: Over there, that bright spot. It is Jupiter, the largest planet.")

            dline("CATE: It is moving through the constellation of Virgo, that one. It looks " +
                  "like a stick man without a head.")

            dline("CATE: That constellation is related to the alleged Virgo 'galactic " +
                  "supercluster', although every respectable astronomer knows that we are actually " +
                  "part of the Laniakea supercluster.")

            line(
                "Cate is remarkably passionate about this. It's unusual for her to speak in " +
                "such a poised tone."
            )
            newline()

            dline("JESS: I guess you could say, it's the virgin Virgo versus the chad Laniakea.")

            line("Everyone glares at Jess. That was an atrocious joke.")
            newline()

            dline(
                "ALEX: What's that blinking light up there?! Is it a meteor? It's a meteor! " +
                "Is it going to crash into us and die?"
            )

            line("CATE:", addNewline = false)
            changeSceneButton("sussex-july-5-evening-8", "That is a plane.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-8") {
        clearScreenColour = Color.BLUE.copy(blue = 240/255f)

        page {
            dline("ALEX: Is it a plane that is going to crash into us and die?")

            line("CHAR: How can a plane die?")
            line("JESS: He meant that you would die.")
            newline()

            dline(
                "CATE: It has already passed us. I am sure that it is far up enough that it " +
                "could not crash into us anyway."
            )

            dline("ALEX: What's that light, over there?")

            dline("CATE: That would be... I am not sure.")

            dline("ALEX: Huh? Why not?")

            dline("CATE: That looks like Canopus, but it is in the wrong position.")

            dline(
                "CHAR: Then you're probably wrong. Stars don't just change position like " +
                "that."
            )

            line("CATE: ", addNewline = false)
            changeSceneButton("sussex-july-5-evening-9", "No, I am certain I am right.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-9") {
        clearScreenColour = Color.BLUE.copy(blue = 235/255f)

        page {
            dline("CATE: If you trace it down like this...")

            line("Cate moves her finger through the air in front of her, tracing a vague shape.")
            newline()

            dline(
                "CATE: All the other stars in Carina are there, but it is in the wrong place " +
                "in the sky. It should be over... there."
            )

            line("Cate points at a different region of the sky. Everyone turns to look at it.")
            newline()

            dline("JESS: Why... are there no stars there?")

            line(
                "The sky is completely blank. There's no light, not even the background light " +
                "pollution."
            )
            newline()

            dline(
                "CHAR: It's still early, plus it doesn't really get dark in the summer here. " +
                "They're probably just too faint to see."
            )

            changeSceneButton(
                "sussex-july-5-evening-10",
                "That seems like the most logical explanation."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-10") {
        clearScreenColour = Color.BLUE.copy(blue = 240/255f)

        page {
            dline("ALEX: What's that light, over there?")

            dline("CATE: That would be... Arcturus.")

            dline("CATE: If you trace it down like this...")

            line("Cate moves her finger through the air in front of her, tracing a vague shape.")
            newline()

            dline("CATE: ... then it looks like a kite.")

            line("Everyone tries tracing the stars in the sky with their fingers.")
            newline()

            dline("ALEX: Okay, like this...")

            line("CHAR: I don't see it.")
            line("JESS: Of course you don't. Do you even understand shapes?")
            newline()

            changeSceneButton("sussex-july-5-evening-11", "You don't see it, either.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-11") {
        clearScreenColour = Color.BLUE.copy(blue = 235/255f)

        page {
            dline(
                "CATE: It is okay if you cannot see it. The other stars are quite dim out " +
                "here, after all."
            )

            dline("ALEX: Wow... these stars are so far away. Does anyone else believe in aliens?")

            line("Those two sentences are completely unconnected.")
            newline()

            dline("JESS: I do! The universe is so big, there's GOT to be aliens somewhere!")

            dline(
                "ALEX: Yeah! I hope one day they visit us in their super duper cool " +
                "spaceships!"
            )

            dline(
                "JESS: Don't you think they already have? There's been so many reports about " +
                "UFOs abducting people. It sounds like they're preparing to invade us!"
            )

            // sus
            dline("ALEX: You're extremely right! I bet the aliens already live within our ranks!")

            changeSceneButton("sussex-july-5-evening-12", "An idiot feedback loop has started.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-12") {
        clearScreenColour = Color.BLUE.copy(blue = 230 / 255f)

        page {
            dline(
                "CHAR: I can say, with utmost certainty, that aliens do not exist and that you " +
                "are both gibbering retards with no clue about the universe."
            )

            dline("JESS: What makes you say that?")

            dline("CHAR: Think about it logically. First -")

            dline("ALEX: Oh, I almost forgot about this!")

            line(
                "Alex reaches below his seat and pulls up a folding table and a laptop. He " +
                "puts it in front of Char."
            )
            newline()

            dline(
                "ALEX: I went back to the school to get this, but you were so super duper " +
                "busy with that game I completely forgot to ask you about it!"
            )

            line(
                "Alex has interrupted a perfectly fine primate tradition of staring at the night sky " +
                "with his technological nonsense."
            )
            newline()

            dline("CHAR: Ugh. Now, of all times?")

            changeSceneButton(
                "sussex-july-5-deduction-1",
                "A very unhappy Char opens the laptop up."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-deduction-1") {
        clearScreenColour = Color.SLATE
        topText = "SIGNALLING SYSTEM 76"

        page {
            dline("CHAR: Wipe that stupid grin off your face.")

            dline("JESS: How did you know? It's too dark to see.")

            dline("CHAR: World's worst superpower. What is it that you even wanted off of me?")

            dline("ALEX: Your autodialer should have completed by now! What did it say!")

            dline("CHAR: Really? I don't want to do this now. I've had a good day so far.")

            dline("CATE: I will tell everyone the results for you, if you wish.")

            dline("CHAR: Don't touch my computer, weasel. Let me see here...")

            line("Char starts tapping away.")
            newline()

            changeSceneButton("sussex-july-5-deduction-2", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-5-deduction-2") {
        page {
            dline("CHAR: Okay. This finished this morning. There's five numbers.")

            dline("CATE: When did it finish?")

            line(
                "Cate has materialised a notebook and is writing in it, using a fountain pen. " +
                "It's clearly a budget model, though. You don't know why she doesn't use a biro like normal " +
                "people."
            )
            newline()

            dline("CHAR: I don't know. Why does that matter? I found the stupid numbers.")

            dline("CATE: I would like to plot an accurate timeline of our efforts.")

            dline(
                "CHAR: Literally nobody but you would ever need that time. I didn't record " +
                "it."
            )

            dline("CATE: That is very unfortunate. I will note right now as the time, then.")

            changeSceneButton("sussex-july-5-deduction-3", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-5-deduction-3") {
        page {
            dline("CATE: Could you please share the five numbers?")

            dline("JESS: Why are there five?")

            dline(
                "CHAR: Because that's how many it detected, idiot. I took an existing " +
                "text-to-speech engine and messed with the parameters until it sounded like the " +
                "speech on the radio recording."
            )

            dline(
                "CHAR: Whoever is sending the signal is very stupid, as their recording seems to " +
                "just play pre-recorded human soundbites, making it sound weird, but it makes it " +
                "really easy to match the sounds."
            )

            dline(
                "CHAR: It was a simple case of brute force matching the phonemes I generated " +
                "for every vowel and consonant sound against the recording."
            )

            dline(
                "CHAR: The comment on that website said that the other side hangs up " +
                "immediately, so I put a thirty second timeout and discarded any numbers that " +
                "failed it. "
            )

            changeSceneButton("sussex-july-5-deduction-4", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-5-deduction-4") {
        page {
            dline("ALEX: Wow! That sounds really complex!")

            dline("CATE: That sounds quadratically complex, even.")

            dline(
                "CHAR: It's very simple and easy, actually. It only sounds complex to stupid " +
                "people and bad programmers."
            )

            dline("CATE: But, we need the numbers.")

            dline("CHAR: Yes, I was getting to that, before a certain somebody interrupted. Here.")

            line("Char reads out the numbers, and Cate writes them down.")

            dline("CATE: Hmm. They do not seem to follow any sort of pattern.")

            dline("ALEX: Maybe there are more numbers with a different start and end! There " +
                  "could totally be a pattern there!")

            changeSceneButton("sussex-july-5-deduction-5", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-5-deduction-5") {
        page {
            dline(
                "ALEX: That is a possibility. We unfortunately will not know unless we " +
                "have another lead to follow up on."
            )

            dline("CATE: That would be super duper cool if we do find one.")

            line("You don't notice the issue, but Char does.")
            newline()

            dline("CHAR: Why did you two just speak like the other person?")

            dline("ALEX: Huh? What do you mean? I'm speaking super duper normally.")

            dline("CHAR: No, like, your voice came out of the wrong person.")

            dline("CATE: I think you are just seeing things.")

            dline("JESS: Hey, did anyone else notice the time? It's just ten past nine.")

            changeSceneButton("sussex-july-5-evening-13", ">> Next")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-13") {
        clearScreenColour = Color.BLUE.copy(blue = 225 / 255f)

        page {
            dline(
                "ALEX: Oh! One of the numbers should have totally changed now! We should " +
                "check what they are!"
            )

            dline("CATE: Did you check the numbers from yesterday, too?")

            dline("ALEX: Yeah! There was the same gap! The gap that we're in!")

            dline(
                "CATE: That is disappointing. Well, if you check now, you might have a " +
                "better result."
            )

            dline("ALEX: I left my radio in the house! I didn't want it to get wet out here!")

            line("It hasn't :push:@sky@ rained in weeks, though. :pop:")
            newline()

            dline("CATE: We have the phone numbers now. We can call one of those.")

            changeSceneButton(
                "sussex-july-5-evening-14",
                "That seems like a bad idea, but you don't know why."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-14") {
        clearScreenColour = Color.BLUE.copy(blue = 220 / 255f)

        page {
            dline("ALEX: Ah! I don't have any signal out here!")

            line("Everyone gets their phone out to check.")

            dline("CATE: I do not have any signal, either.")

            dline("CHAR: Me neither. I bet your nutjob father runs a phone jammer, too.")

            line("The new phone that Alex gave you is charging inside, so you can't check it.")
            newline()

            dline("JESS: I have four bars. I don't know what's wrong with you lot. ")

            line(
                "That shouldn't be right. Jess is on a different network, but there's no way " +
                "there's only one phone tower around."
            )
            newline()

            dline("JESS: Okay, give me the number.")

            changeSceneButton(
                "sussex-july-5-evening-15",
                "She starts to dial the number."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-15") {
        clearScreenColour = Color.BLUE.copy(blue = 215 / 255f)

        page {
            line("One ring. Two rings. Three rings.")
            newline()

            line("The other end picks up.")
            newline()

            line("There's no tones, only a brief amount of silence.")
            newline()

            line(
                "There's a horrible noise coming from the phone speaker, stripping away your " +
                "eardrums."
            )
            newline()

            line("It sounds like wind.")
            newline()

            changeSceneButton("sussex-july-5-evening-16", "The wind seems to pick up.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-16") {
        clearScreenColour = Color.BLUE.copy(blue = 210 / 255f)

        page {
            dline("JESS: Hey, did anyone else notice the time? It's just gone half past nine.")

            dline(
                "ALEX: Oh! One of the numbers should have totally changed now! We should " +
                "check what they are!"
            )

            dline("CATE: Did you check the numbers from yesterday, too?")

            dline("ALEX: Yeah! There was the same gap! The gap that we're in!")

            dline(
                "CATE: That is disappointing. Well, if you check now, you might have a " +
                "better result."
            )

            line("Char looks at Jess. Jess looks back at Char. They both look at Alex.")
            newline()

            dline("ALEX: I left my radio in the house! I didn't want it to get wet out here!")

            changeSceneButton(
                "sussex-july-5-evening-17",
                "It hasn't rained in months, though."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-17") {
        clearScreenColour = Color.BLUE.copy(blue = 210 / 255f)

        page {
            dline("CATE: We have the phone numbers now, though. We should call one of those.")

            dline("ALEX: That's a super duper brilliant fantastic idea!")

            line("Alex pulls his phone out and frowns at it.")

            dline("ALEX: I have no signal.")

            dline("CATE: I have no signal, either.")

            line(
                "The new phone that Alex gave you hasn't been set up yet, so you don't " +
                "bother checking."
            )
            newline()

            dline("CHAR: I have four bars... how do I have signal and you guys don't?")

            changeSceneButton(
                "sussex-july-5-evening-18",
                "Char hesitates, but starts to dial one of the numbers."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-18") {
        clearScreenColour = Color.BLUE.copy(blue = 195 / 255f)
        topText = "..."

        page {
            line("One ring. Two rings. The phone and the wind pick up.")
            newline()

            line("There's no tones, only a brief amount of silence.")
            newline()

            line(
                "There's a horrible noise coming from the phone speaker, " +
                "burrowing away in your brain."
            )
            newline()

            line("It sounds like wind.")
            newline()

            line("Everyone freezes with a pained expression on their face. Still.")
            line("It feels as if not even the strongest force in the universe could move them.")
            newline()

            changeSceneButton("sussex-july-5-evening-19", "The numbers are read out.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-19") {
        clearScreenColour = Color.BLUE.copy(blue = 180 / 255f)

        page {
            line(
                "The numbers are not any numbers you can comprehend. They hurt my ears. It " +
                "feels as if somebody is pushing a nail through your head."
            )
            newline()

            line(
                "The wind is really strong now, but nobody is moving. Cate's notebook flips " +
                "open and flies out into the abyss. She continues to have winced in pain."
            )
            newline()

            line(
                "Char is trying to turn her heard towards me. You see her jittering, " +
                "jittering, her body seemingly snapping back and forwards in time as she tries to " +
                "release her phone."
            )
            newline()

            line(
                "An infinite amount of time later, she finally releases the phone from her " +
                "grip. It flies towards the floor infinitely fast, and smashes."
            )
            newline()

            changeSceneButton("sussex-july-5-evening-20", "The wind stops.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-20") {
        clearScreenColour = Color.BLACK

        page {
            dline("JESS: Whoa! What the fuck are you doing?")

            line("Char has accidentally thrown her phone directly onto Jess' foot.")

            dline(
                "CHAR: What the fuck just - why did it change? Why did it happen again? " +
                "What time is it?"
            )

            line(
                "You wince from the volume of Char's yelling. Jess responds, in a perfectly " +
                "average volume."
            )

            dline("JESS: What the hell are you talking about? What changed? What happened again?")

            dline("CHAR: Don't fucking tell me you didn't see that.")

            dline("JESS: See what, Charlotte?")

            changeSceneButton("sussex-july-5-evening-21", "Jess gives a malicious smile.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-21") {
        page {
            dline("ALEX: Miss Charlotte, are you okay?")

            dline("CHAR: I asked, what time is it!!")

            dline(
                "JESS: It's a few minutes past ten, Charlotte. We were just talking about " +
                "the stars changing."
            )

            dline(
                "CHAR: I didn't believe it when I heard it. Not after all this time, not again."
            )

            line("Char falls back into her chair, crying.")
            newline()

            dline("ALEX: Miss Charlotte! What's wrong?! Do you want me to fetch the doctor?")

            dline("CHAR: You, rat, turn on the lights.")

            dline("ALEX: What? The really bright ones?")

            dline("CHAR: Turn on the fucking lights you little rat bastard!")

            changeSceneButton("sussex-july-5-evening-22", "Alex obliges.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-22") {
        page {
            line(
                "The lights turn back on, almost blinding you. The light creates rainbows " +
                "through the raindrops falling onto the gazebo deck."
            )
            newline()

            dline("CHAR: Oh no. Please no.")

            line("The lights stop at the gazebo walls. They stop, because there is nothing there.")
            newline()

            dline("JESS: Why are you acting so hysterical all of a sudden? It's just a phone.")

            line("For some reason, you feel the temptation to break Jess' horrible little nose.")
            newline()

            dline("CHAR: Please, look. Tell me, tell me - tell me you see that.")

            line("She points at nothing beyond the gazebo walls.")
            newline()

            changeSceneButton("sussex-july-5-evening-23", "ALEX: What, that tree?")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-23") {
        page {
            line("There's no tree there. There's nothing there but nothingness.")
            newline()

            line("You can't stare at it for too long. The rain is getting in your eyes.")
            newline()

            dline("CHAR: No, no, no, there's no fucking tree there. Look at it!")

            dline("CATE: It is just a tree. If you are that offended by it, I am sure that Alex " +
                  "could have it chopped down for you.")

            dline("JESS: That would be rather heartless, even by your very very low standards.")

            line("Jess is taunting a clearly upset girl. What a horrible fucking bitch she is.")
            newline()

            dline("CHAR: Okay. Okay. Go touch that tree for me then.")

            dline(
                "JESS: If it makes you stop snivelling like a baby, sure. Alex, go touch that " +
                "tree."
            )

            changeSceneButton(
                "sussex-july-5-evening-24",
                "He bounds up from the chair like an obedient dog."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-24") {
        page {
            line("His hand reaches nothing first. It happens instantly.")
            newline()

            dline("CHAR: Okay. Okay. I remember. That's okay, I remember.")

            dline("JESS: See, he touched the tree. Happy now?")

            line("Alex is stuck. He's stuck at the border of the gazebo, frozen, forever.")
            newline()

            line("His frozen body begins to redshift. Eventually, he'll be gone.")
            newline()

            dline("CATE: No, I do not think she wants it cut down.")

            dline("CATE: Yes, but she has stopped crying.")

            changeSceneButton("sussex-july-5-evening-25", "It happens to Cate, too.")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-25") {
        page {
            line(
                "Cate reaches to grab something from where Alex should be, and she freezes " +
                "forever."
            )
            newline()

            dline("CHAR: What's the time, now?")

            line("Char has sunk into her chair, even more. A mixture of tears and raindrops soak " +
                 "her face.")
            newline()

            dline("JESS: It's 10:06.")

            line(
                "The nothingness begins to approach. The edges of the gazebo fade into " +
                "nothingness. The backs of the chair fade into nothingness."
            )
            newline()

            line(
                "The edge of reality glows, blinding me again. The only thing I can see is " +
                "silhouettes against the backdrop."
            )
            newline()

            changeSceneButton(
                "sussex-july-5-evening-26",
                "The chairs are destroyed. All that remains is a small area in the middle."
            )
        }
    }

    createAndRegisterScene("sussex-july-5-evening-26") {
        clearScreenColour = Color.WHITE
        invert = true

        page {
            line(":push:@black@ The wind and the rain make it hard to hear anything anymore.")
            line("The last conversation ever unfolds in front of you.")
            newline()

            dline("@teal@????: It's been months now. I thought we ended it.")

            dline("@teal@????: It's Thursday tomorrow. What do you think will happen?")

            dline("@lime@????: I hope they come back.")

            dline("@teal@????: Deep in your heart, you didn't believe in the numbers either.")

            dline("@lime@????: You keep saying otherwise.")

            dline("@teal@????: You wrote it down wrong. It hasn't rained in weeks.")

            changeSceneButton("sussex-july-5-evening-27", "A soft hand grips your own.")
            line(":pop:")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-27") {
        clearScreenColour = Color.WHITE
        invert = true

        page {
            dline(":push:@black@ @teal@????: I'm sorry. This shouldn't've happened yet.")

            dline(":push:@black@ @teal@????: Don't believe a word she says about me.")

            dline(":push:@black@ @teal@????: She wants to destroy you. :pop:")

            changeSceneButton("sussex-july-5-end", "The figures fade into the light.")
        }
    }

    createAndRegisterScene("sussex-july-5-end") {
        clearScreenColour = Color.WHITE
        invert = true

        // todo: make this an effect
        onLoad { SS76.sceneManager.currentScene.timer = 9999999 }

        page {
            newline(11)
            line(" ".repeat(22), addNewline = false)
            changeSceneButton("sussex-july-6-start", "T h e  w o r l d  e n d s.")
        }
    }
}