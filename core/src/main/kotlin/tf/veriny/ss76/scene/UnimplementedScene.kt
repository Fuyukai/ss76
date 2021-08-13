package tf.veriny.ss76.scene
import tf.veriny.ss76.SS76
import tf.veriny.ss76.scene.text.Newline
import tf.veriny.ss76.scene.text.TextualNode
import tf.veriny.ss76.scene.text.TextualScene

public class UnimplementedScene(public val triedToLoad: String) : TextualScene(listOf()) {
    override fun sceneActive() {
        super.sceneActive()
        timer = 9999999
    }

    override val id: String = "unimplemented"

    override fun getTextToRender(): List<TextualNode> {
        val nodes = mutableListOf<TextualNode>()
        nodes += TextualNode.split("When the scene is unimplemented! :blush:", trailingNewline = true)
        nodes += Newline
        nodes += TextualNode.split(
            "Seriously though, you shouldn't be here. Please screenshot this screen and report " +
            "this issue to Lura!", trailingNewline = true
        )
        nodes += Newline

        val gotScene = System.getProperty("scene")
        if (gotScene != null) {
            nodes += TextualNode.split("Custom root scene: $gotScene", true)
        }

        val prev = SS76.previousScene
        val prevId = prev?.id
        val prevKlass = prev?.javaClass?.simpleName
        nodes += TextualNode.split("Previous scene was $prevId ($prevKlass)", true)
        nodes += TextualNode.split("Tried to load: $triedToLoad", true)

        nodes += Newline

        for ((idx, scene) in SS76.sceneStack.withIndex()) {
            val id = scene.id
            val klass = scene.javaClass.simpleName
            nodes += TextualNode.split("Stack #${idx}: $id (${klass})", true)
        }

        return nodes
    }
}