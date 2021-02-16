object ScrabbleScore {

    val scoreMap = hashMapOf (
        *"AIEOULNRSTaieoulnrst".map { it to 1 }.toTypedArray(),
        *"DGdg".map { it to 2 }.toTypedArray(),
        *"BCMPbcmp".map { it to 3 }.toTypedArray(),
        *"FHVWYfhvwy".map { it to 4 }.toTypedArray(),
        *"Kk".map { it to 5 }.toTypedArray(),
        *"JXjx".map { it to 8 }.toTypedArray(),
        *"QZqz".map { it to 10 }.toTypedArray()
    )

    fun scoreWord(word: String): Int {
 
        return word.toUpperCase().fold(0, { acc,ch ->
            if (ch in 'Z' downTo 'A') {
                acc + scoreLetter[ch]!!
            } else {
                acc
            }
        })
        
    }
}


// object ScrabbleScore {
//     private val scoreMap: Map<Char, Int> = listOf(
//         "AEIOULNRST" to 1,
//         "DG" to 2,
//         "BCMP" to 3,
//         "FHVWY" to 4,
//         "K" to 5,
//         "JX" to 8,
//         "QZ" to 10
//     ).flatMap { (ks, score) ->
//         ks.flatMap { k ->
//             // cover both uppercase and lowercase.
//             listOf(k to score, k.toLowerCase() to score)
//         }
//     }.toMap()

//     private fun scoreLetter(c: Char): Int = scoreMap[c] ?: 0

//     fun scoreWord(word: String): Int = word.sumBy(::scoreLetter)
// }