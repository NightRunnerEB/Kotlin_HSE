class RB : Component {
    var children: MutableList<Component> = mutableListOf()

    override fun showDetails(): String {
        val childrenDetails = "(" + children.joinToString { it.showDetails() } + ")"
        return childrenDetails
    }

    fun add(component: Component) {
        children.add(component)
    }

}

class SB : Component {

    override fun showDetails(): String {
        val childrenDetails = "[]"
        return childrenDetails
    }

    fun add(component: Component) {/*иллюзия возможности*/}
}

class FB : Component {
    var children: MutableList<Component> = mutableListOf()

    override fun showDetails(): String {
        val childrenDetails = "{" + children.joinToString { it.showDetails() } + "[]}"
        return childrenDetails
    }

    fun add(component: Component) {
        children.add(component)
    }
}