package `in`.vikram.githubprs.custom

enum class PRState {

    CLOSED("closed"),
    OPEN("open");

    private var state : String? = null

    constructor(state : String) {
        this.state = state
    }

    fun getValue() : String {
        return state!!
    }

}