class TextRedactor(private var text: String = "") {

    fun getText():String {
        return text
    }

    fun changeText(text: String) {
        this.text = text
    }
}