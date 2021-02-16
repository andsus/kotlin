fun reverse(input: String): String {
    var result = mutableListOf<Char>()
    for ( i in input.length-1 downTo 0) {
        result.add(s[i])
    }
    return result.toString()

}
