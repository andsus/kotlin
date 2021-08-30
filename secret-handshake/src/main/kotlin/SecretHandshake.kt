object HandshakeCalculator {
    infix fun Int.hasBitOn(bit: Int): Boolean = ((this shr bit) and 0x1) == 1


    // extends Int with shift-right AND bit operation
    infix fun Int.isBitOn(bit: Int): Boolean = ((this shr bit) and 0x1) == 1
    private val signals = Signal.values()

    fun calculateHandshake(number: Int): List<Signal> {
        /*
        val digits = mutableListOf<Signal>().apply {

           if (number isBitOn 0) add(Signal.WINK)
           if (number isBitOn 1) add(Signal.DOUBLE_BLINK)
           if (number isBitOn 2) add(Signal.CLOSE_YOUR_EYES)
           if (number isBitOn 3) add(Signal.JUMP)
           if (number isBitOn 4) this.reverse()
        }
        return digits
        */

        return signals
        .filterIndexed { i, _ -> number hasBitOn i }
        .let { if (number hasBitOn signals.size) it.reversed() else it }

    }
}