import kotlin.properties.Delegates

class Reactor<T> {

    abstract inner class Cell<T> {
        abstract var value: T
        val observables = mutableListOf<ComputeCell>()
    }

    inner class InputCell(value: T) : Cell<T>() {
        override var value by Delegates.observable(value)  { _,_,_ ->
            observables.forEach { it.propagate() }
            observables.forEach { it.runCallbacks() }
            }
    }

    inner class ComputeCell(
        private val computeValue: () -> T
    ) : Cell<T>() {
        override var value: T = computeValue()

        constructor(vararg cells: Cell<T>, f: (List<T>) -> T) :
            this({
                f(cells.map { it.value}) }) {
                    cells.forEach { it.observables.add(this) }
                }


        private var lastCallbackValue = value
        private var callbackId = 0
        private val callbacks = mutableMapOf<Int, (T) -> Any>()

        fun addCallback(callback: (value: T) -> Any) : Subscription {
            val id = callbackId++
            callbacks[id]= callback
            return object: Subscription {
                override fun cancel() {
                    callbacks.remove(id)
                }
            }
        }

        internal fun propagate() {
            val nextValue = computeValue()
            if (nextValue == value) {
                return
            }
            value = nextValue
            observables.forEach { it.propagate() }
        }

        internal fun runCallbacks() {
            if (value == lastCallbackValue) {
                return
            }
            lastCallbackValue = value
            callbacks.values.forEach {  it(value) }
            observables.forEach { it.runCallbacks() }
        }
     }
    interface Subscription {
        fun cancel()
    }

}