data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val rows: List<List<Int>>) {
    private val cols : List<List<Int>> by lazy { transpose() }
    private val maxInRow by lazy { rows.map { it.max() } }
    private val minInCol by lazy { cols.map { it.min() } }

    fun transpose() = List(rows[0].size) { c -> rows.map { it[c] } }

    val saddlePoints: Set<MatrixCoordinate> =
        rows.mapIndexed { r, row ->
            row.mapIndexedNotNull { c, cell ->
                if (cell == maxInRow[r] && cell == minInCol[c]) {
                    MatrixCoordinate(r+1, c+1)
                } else null
            }
        }.flatten().toSet()
}