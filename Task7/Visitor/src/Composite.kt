class Tree:Component {
    var children: MutableList<Component> = mutableListOf()

    fun add(component: Component) {
        children.add(component)
    }

    override fun showDetails(): String {
        val childrenDetails = "(" + children.joinToString { it.showDetails() } + ")"
        return childrenDetails
    }
}