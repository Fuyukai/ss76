package tf.veriny.ss76.vn.sussex

import tf.veriny.ss76.SS76
import tf.veriny.ss76.scene.text.buildDateMarkerScene
import tf.veriny.ss76.scene.text.createAndRegisterScene
import tf.veriny.ss76.scene.text.createScene
import tf.veriny.ss76.vn.CommonScenes

// this'll confuse anyone doing decompile dives
private val WHEN_THE_SEX_IS_SUS =
    """
⠀⠀⠀⡯⡯⡾⠝⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢊⠘⡮⣣⠪⠢⡑⡌
⠀⠀⠀⠟⠝⠈⠀⠀⠀⠡⠀⠠⢈⠠⢐⢠⢂⢔⣐⢄⡂⢔⠀⡁⢉⠸⢨⢑⠕⡌
⠀⠀⡀⠁⠀⠀⠀⡀⢂⠡⠈⡔⣕⢮⣳⢯⣿⣻⣟⣯⣯⢷⣫⣆⡂⠀⠀⢐⠑⡌
⢀⠠⠐⠈⠀⢀⢂⠢⡂⠕⡁⣝⢮⣳⢽⡽⣾⣻⣿⣯⡯⣟⣞⢾⢜⢆⠀⡀⠀⠪
⣬⠂⠀⠀⢀⢂⢪⠨⢂⠥⣺⡪⣗⢗⣽⢽⡯⣿⣽⣷⢿⡽⡾⡽⣝⢎⠀⠀⠀⢡
⣿⠀⠀⠀⢂⠢⢂⢥⢱⡹⣪⢞⡵⣻⡪⡯⡯⣟⡾⣿⣻⡽⣯⡻⣪⠧⠑⠀⠁⢐
⣿⠀⠀⠀⠢⢑⠠⠑⠕⡝⡎⡗⡝⡎⣞⢽⡹⣕⢯⢻⠹⡹⢚⠝⡷⡽⡨⠀⠀⢔
⣿⡯⠀⢈⠈⢄⠂⠂⠐⠀⠌⠠⢑⠱⡱⡱⡑⢔⠁⠀⡀⠐⠐⠐⡡⡹⣪⠀⠀⢘
⣿⣽⠀⡀⡊⠀⠐⠨⠈⡁⠂⢈⠠⡱⡽⣷⡑⠁⠠⠑⠀⢉⢇⣤⢘⣪⢽⠀⢌⢎
⣿⢾⠀⢌⠌⠀⡁⠢⠂⠐⡀⠀⢀⢳⢽⣽⡺⣨⢄⣑⢉⢃⢭⡲⣕⡭⣹⠠⢐⢗
⣿⡗⠀⠢⠡⡱⡸⣔⢵⢱⢸⠈⠀⡪⣳⣳⢹⢜⡵⣱⢱⡱⣳⡹⣵⣻⢔⢅⢬⡷
⣷⡇⡂⠡⡑⢕⢕⠕⡑⠡⢂⢊⢐⢕⡝⡮⡧⡳⣝⢴⡐⣁⠃⡫⡒⣕⢏⡮⣷⡟
⣷⣻⣅⠑⢌⠢⠁⢐⠠⠑⡐⠐⠌⡪⠮⡫⠪⡪⡪⣺⢸⠰⠡⠠⠐⢱⠨⡪⡪⡰
⣯⢷⣟⣇⡂⡂⡌⡀⠀⠁⡂⠅⠂⠀⡑⡄⢇⠇⢝⡨⡠⡁⢐⠠⢀⢪⡐⡜⡪⡊
⣿⢽⡾⢹⡄⠕⡅⢇⠂⠑⣴⡬⣬⣬⣆⢮⣦⣷⣵⣷⡗⢃⢮⠱⡸⢰⢱⢸⢨⢌
⣯⢯⣟⠸⣳⡅⠜⠔⡌⡐⠈⠻⠟⣿⢿⣿⣿⠿⡻⣃⠢⣱⡳⡱⡩⢢⠣⡃⠢⠁
⡯⣟⣞⡇⡿⣽⡪⡘⡰⠨⢐⢀⠢⢢⢄⢤⣰⠼⡾⢕⢕⡵⣝⠎⢌⢪⠪⡘⡌⠀
⡯⣳⠯⠚⢊⠡⡂⢂⠨⠊⠔⡑⠬⡸⣘⢬⢪⣪⡺⡼⣕⢯⢞⢕⢝⠎⢻⢼⣀⠀
⠁⡂⠔⡁⡢⠣⢀⠢⠀⠅⠱⡐⡱⡘⡔⡕⡕⣲⡹⣎⡮⡏⡑⢜⢼⡱⢩⣗⣯⣟
⢀⢂⢑⠀⡂⡃⠅⠊⢄⢑⠠⠑⢕⢕⢝⢮⢺⢕⢟⢮⢊⢢⢱⢄⠃⣇⣞⢞⣞⢾
⢀⠢⡑⡀⢂⢊⠠⠁⡂⡐⠀⠅⡈⠪⠪⠪⠣⠫⠑⡁⢔⠕⣜⣜⢦⡰⡎⡯⡾⡽
    """


private const val JULY_3_FORECAST = "It's a sunny day, with no clouds to be seen."
private val JULY_3_DATE_SCENE = buildDateMarkerScene(
    "sussex-july-3-start", "Monday", 3, JULY_3_FORECAST,
    "sussex-july-3-school-1"
)

public fun registerSussexJuly3Scenes() {
    SS76.registerScene(JULY_3_DATE_SCENE)

    // Getting to school
    createAndRegisterScene("sussex-july-3-school-1") {
        page {
            line(
                "It's a hot summer day. It's 9AM. You've just arrived at school, which you're " +
                "late for by a few minutes."
            )
            // Foreshadowing: He's gonna get punished for being late.
            line("That's okay. You're always late. Who's going to punish a sixth form student?")
            // Actually, I wonder this too.
            line("You wonder why the teachers even bother to teach in July. It's too hot to " +
                 "pay any attention.")
            newline()

            line(
                "You awkwardly hurry through the front gates, your sleeves lightly glued to " +
                "your arms by your body sweat."
            )

            // this awkwardly wraps...
            // throw-away line except to establish the size of the school.
            // why is the school so big? idk, makes it harder to find ppl. signifies well funded,
            // (although it's not, its in decline, how can I link this forward).
            // contrast to the ideal character traits of the MC, who is kinda out of place by being
            // a bit poorer.
            line(
                "There's a few students in the same situation as you. Some are clearly " +
                "panicking; maybe it's their first time being late. You think that they shouldn't " +
                "worry; after all, a", addNewline = false
            )
            pushSceneButton(CommonScenes.SCHOOL_SIZE.id, "school of this size")
            newline()
            line("can't keep track of all their students.")
            newline()

            changeSceneButton(
                "sussex-july-3-school-2",
                "You check today's schedule."
            )
        }
    }

    // Checking his schedule
    createAndRegisterScene("sussex-july-3-school-2") {
        page {
            line(
                "You have three classes a day, separated by a short twenty minute break in the " +
                "morning, and an hour's lunch in the afternoon. You also have a short period of form " +
                "time, but only around half of people were attending that after the first few weeks. " +
                "You're definitely not attending it."
            )
            newline()
            line(
                "Thursdays are great; you have all three subjects and no free periods. "
            )
            newline()

            line("08:50 - 10:20 - Mathematics")
            line("10:20 - 10:55 - Form")
            line("10:55 - 11:15 - Break")
            line("11:15 - 12:55 - Physics")
            line("12:55 - 13:50 - Lunch")
            line("13:50 - 15:30 - Computer Science")
            newline()

            line("Fuck that, you tell yourself.", addNewline = false)
            changeSceneButton("sussex-july-3-school-3", "You're skipping all of that.")

        }
    }

    // Time to skip class.
    createAndRegisterScene("sussex-july-3-school-3") {
        page {
            line("You make your way to the", addNewline = false)
            pushSceneButton(CommonScenes.SCHOOL_WORKING_LIFT.id, "working lift")
        }
    }

}