class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init {
        // Cast the covariance T type
        operator fun Number.plus(that: Number): Double = this.toDouble() + that.toDouble()
        operator fun Number.compareTo(that: Number) = this.toDouble().compareTo(that.toDouble())
        // all valid sides
        require(listOf(a,b,c).all { it > 0})

        // sum of 2 sides > the other side
        require(a + b > c)
        require(b + c > a)
        require(a + c > b)

    }

    val isEquilateral: Boolean = a == b && b == c
    val isIsosceles: Boolean =  a == b || b == c || a == c
    val isScalene: Boolean = !isEquilateral && !isIsosceles
}
