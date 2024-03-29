class Originator {
    private var state = ""

    fun setState(state:String) {
        this.state = state
    }

    fun getState() : String {
        return state
    }

    fun saveStateToMemento():Memento {
        return Memento(state)
    }

    fun getStateFromMemento(memento: Memento) {
        state = memento.getState()
    }
}