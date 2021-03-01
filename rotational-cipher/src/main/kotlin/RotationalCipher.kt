class RotationalCipher(private val key: Int) {
    init {
        require(key in (0..26))
    }

    fun encode(text: String): String {
        return text.map {
            when (it) {
                in ('a'..'z') -> rotate(it, 'z')
                in ('A'..'Z') -> rotate(it, 'Z')
                else -> it
            }
        }.joinToString("")
    }

    private inline fun rotate(c: Char, max: Char)
        = (c + key).run { if (this > max) this - 26 else this }
}
