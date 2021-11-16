package tf.veriny.ss76.vn.side

import tf.veriny.ss76.engine.SceneManager
import tf.veriny.ss76.engine.scene.createAndRegisterScene

/**
 * Contains scenes relating to Alex's radio sideplot.
 */
public fun registerSidePlotAlexRadio(sm: SceneManager): Unit = with(sm) {
    createAndRegisterScene("side.sussex.alex-radio-0") {
        page {
            line("Alex really likes talking about his radio set.")
            newline()

            line(
                "He got it for Christmas a few years ago, when he was thirteen. " +
                "He's always been annoyingly fascinated with... 'magical invisible energies'."
            )
            newline()

            line("Alas, there's always", addNewline = false)
            changeSceneButton("side.sussex.alex-radio-1", "consequences")
            line("for getting too into something.")
        }
    }

    createAndRegisterScene("side.sussex.alex-radio-1") {
        page {
            line(
                "His radio set is very advanced. It's probably illegal. Whoever got it for him " +
                 "is really stupid."
            )
            newline()

            line("It's so powerful it can pick up certain types of other signals, with the " +
                 "right tuning.")
            newline()

            line(
                "Shortwave signals, AM and FM radio, radio time signals, even Wi-Fi signals " +
                "(which make a really horrible noise)."
            )
            newline()

            changeSceneButton("side.sussex.alex-radio-2", "Even baby monitor signals.")
        }
    }

    createAndRegisterScene("side.sussex.alex-radio-2") {
        page {
            line(
                "Alex has two younger sisters. You assume that the stupid gene runs in his " +
                "family, because otherwise they would've stopped after none."
            )
            newline()

            line(
                "His second sister was a very recent affliction at the time of that " +
                "Christmas, so his parents had a two-way baby monitor system presumably to ensure " +
                "she didn't start belting out slurs in her sleep or something."
            )
            newline()

            line(
                "This baby monitor system used standard radio signals, making it easy for " +
                "someone to overhear things he shouldn't've.", addNewline = false
            )
            newline()

            line(
                "Alex's family had a beloved grandmother, who spoiled all the children and " +
                "would visit every Boxing Day bringing the biggest and wildest gifts."
            )
            newline()

            line(
                "Unfortunately, that Christmas his grandmother ended up in hospital. " +
                "A nasty fall - the fitting fate for every parasitic pensioner."
            )
            newline()

            line("The children didn't know, but their", addNewline = false)

            changeSceneButton("side.sussex.alex-radio-4", "parents did.")
        }
    }


    createAndRegisterScene("side.sussex.alex-radio-4") {
        page {
            line(
                "Alex overheard this discussion from the kitchen on his radio. " +
                "Alex, the bastion of intelligence he is, immediately ran downstairs and started " +
                "screaming about how his Nan was dead."
            )
            newline()

            line(
                "Screaming and crying was abundant from all three children. " +
                "Some of it was genuine grief, but a lot of it was anger that they would miss " +
                "their special presents."
            )
            newline()

            line("His parent's reassurances fell on deaf ears. Alex had ruined Christmas.")
            newline(2)

            backButton()
        }
    }
}