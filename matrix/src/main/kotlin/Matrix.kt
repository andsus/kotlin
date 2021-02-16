class Matrix(private val matrixAsString: String) {
    private val rows: List<List<Int>> by lazy { scanRows() }
    private val cols: List<List<Int>> by lazy { transpose() }
    fun scanRows() =
            matrixAsString.split("\n")
                .map { line -> line.trim().split(Regex("\\s+")).map(String::toInt) }
//    fun transpose() = (0 until rows[0].size)
//                .map { c -> rows.map { it[c] } }
    fun transpose() = List(rows[0].size) { c -> rows.map { it[c] } }

    fun column(colNr: Int): List<Int> {
        return cols[colNr - 1]
    }

    fun row(rowNr: Int): List<Int> {
        return rows[rowNr - 1]
    }
}
