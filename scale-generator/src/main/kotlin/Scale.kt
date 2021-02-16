class Scale(private val tonic: String) {
    var scale: String = ""
    var chromatic = emptyList<String>()
    val sharp = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
    val flat = listOf("F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E")

    init {
        if (tonic.length==2 ) {
            this.scale = "${tonic.first().toUpperCase()}${tonic.last()}"
        } else {
            this.scale = tonic.toUpperCase()
        }
        if (sharp.indexOf(this.scale) != -1) {
            this.chromatic = sharp
        } else {
            this.chromatic = flat
        }
    }

        fun chromatic(): List<String> {
        return chromatic.slice( chromatic.indexOf(scale) until chromatic.size) +
                chromatic.slice( 0 until chromatic.indexOf(scale))
    }

    fun interval(intervals: String): List<String> {
        val chroma = chromatic()
        var pos = 0
        return intervals.dropLast(1).map { it -> if (it=='M') 2 else if (it=='A') 3 else 1 }.fold(listOf(chroma.first())) {
            acc, idx ->
                pos += idx
                acc + chroma[pos]
        }
    }

}
