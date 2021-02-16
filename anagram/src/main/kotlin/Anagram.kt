class Anagram(source: String) {
    private val word = source.toLowerCase() 
    private val letters = word.toList().sorted()
    // anagram if it has equal sorted letters
    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { anagram ->
            val w = anagram.toLowerCase()
            w != word && w.toList().sorted() == letters
        }
        .toSet()
    }
}
