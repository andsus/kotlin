class Robot {
    private var _name: String = names.next()

    val name: String
        get() = _name

    fun reset() {
        _name = names.next()
    }

    private companion object {
        // https://kotlinlang.org/docs/sequences.html#from-an-iterable
        // build a sequence based on function
        val names = generateSequence { 
            (('A'..'Z').shuffled().take(2) + ('0'..'9').shuffled().take(3)).joinToString("")
        }.distinct().iterator()
    }
}
