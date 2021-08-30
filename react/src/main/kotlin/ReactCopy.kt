/*
interface Subscriber<T> {
    fun onNext(nextValue: T): Unit
}

interface Subscription {
    fun cancel()
}

abstract class Observable<T> {
    abstract val value: T
    protected var subscribers = mutableListOf<Subscriber<T>>()

    fun subscribe(subscriber: Subscriber<T>): Subscription {
        subscribers.add(subscriber)

        return createSubscription(subscriber)
    }

    protected fun notifySubscribers() = subscribers.forEach { it.onNext(value) }

    private fun createSubscription(subscriber: Subscriber<T>): Subscription {
        return object : Subscription {
            override fun cancel() {
                subscribers.removeIf { it == subscriber }
            }
        }
    }
}

class Reactor<T> {
    inner class InputCell(value: T) : Observable<T>() {
        override var value: T = value
            set(value) {
                field = value
                notifySubscribers()
            }
    }

    inner class ComputeCell(
        private vararg val sources: Observable<T>,
        private val computeFunction: (values: List<T>) -> T
    ) : Observable<T>(), Subscriber<T> {
        override var value: T = computeValue()
        private var lastEmittedValue: T? = value
        private var parentEmittedValuesCount = 0

        init {
            sources.forEach { it.subscribe(this) }
        }

        override fun onNext(nextValue: T) {
            parentEmittedValuesCount += 1
            value = computeValue()

            val allParentsHaveEmitted = parentEmittedValuesCount == sources.size
            val isNewValue = value != lastEmittedValue

            if (allParentsHaveEmitted) {
                parentEmittedValuesCount = 0

                if (isNewValue) {
                    lastEmittedValue = value
                    notifySubscribers()
                }
            }
        }

        fun addCallback(callback: (value: T) -> Unit) = subscribe(object : Subscriber<T> {
            override fun onNext(nextValue: T) {
                callback(nextValue)
            }
        })

        private fun computeValue() = computeFunction(sources.map { it.value })
    }
}

 */