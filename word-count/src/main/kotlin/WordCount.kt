import java.util.Locale.US

object WordCount {
    private val notWordPattern = "[^\'a-zA-Z0-9]+".toRegex(RegexOption.IGNORE_CASE)

    fun phrase(phrase: String): Map<String, Int> =
        phrase.toLowerCase(US)
            .split(notWordPattern)
            .filter { it.isNotBlank() }
            .map { it.removeSurrounding("'") }
            .groupingBy { it }
            .eachCount()

}
