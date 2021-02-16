class Squares(val n: Int) {
    private val _sumOfSquares: Int by lazy { sumOfSquares() }
    private val _squareOfSum: Int by lazy { squareOfSum() }
    
    private fun square(n: Int): Int = n * n

    fun sumOfSquares(): Int =
        (1..this.n).sumBy { square(it) }

    fun squareOfSum(): Int =
        square( (1..this.n).sum() )

    fun difference(): Int = _squareOfSum - _sumOfSquares

}
