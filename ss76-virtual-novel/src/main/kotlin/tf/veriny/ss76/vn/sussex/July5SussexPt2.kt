package tf.veriny.ss76.vn.sussex

import com.badlogic.gdx.graphics.Color
import ktx.graphics.copy
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

            line(":push:@yellow@")
            line("Oh fuck it I can't be bothered to write any of this. It's just filler for " +
                 "character development purposes. I promise I'll finish this before the 4 day demo. " +
                 "If I don't you are allowed to execute me"
            )
            line("Blah blah time skip to 7pm, Jess came back from school, Alex led them to a " +
                 "special place in the garden cos uhh sentimental shit. Pretend I wrote all that.")
            line(":pop:")
            newline()

            changeSceneButton("sussex-july-5-evening-1", "Jump to the fun stuff")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-1") {
        page {
            line(
                "Alex led us to a spot in the garden, far away from the main house. It was " +
                "secluded in amongst (sus) the trees."
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

            changeSceneButton("sussex-july-5-evening-14", "")
        }
    }

    createAndRegisterScene("sussex-july-5-evening-14") {
        clearScreenColour = Color.BLUE.copy(blue = 220 / 225f)

        page {

        }
    }
}