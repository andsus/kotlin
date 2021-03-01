import java.util.concurrent.atomic.AtomicLong

class BankAccount {
    private var _closed: Boolean = false
    private val _balance: AtomicLong = AtomicLong(0)
    
    fun adjustBalance(amount: Long){
        check(!_closed)
        _balance.addAndGet(amount)
    }

    fun close() {
        _closed = true
    }

    val balance: Long
        get() {
            check(!_closed)
            return _balance.get()
        }
}
