data class Node<T>(
    val value: T,
    var next: Node<T>? = null,
    var previous: Node<T>? = null
)

class Deque<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    // push to end
    fun push(value: T) {
        val pTail = tail
        if (pTail == null) { // empty list
            head = Node(value)
            tail = head
        } else { // new node at end
            pTail.next = Node(value, previous = pTail )
            tail = pTail.next
        }
    }
    // pop from tail
    fun pop(): T? {
        if (head == tail) {
            head = null
        } else {
            tail?.previous?.next = null
        }
        val value = tail?.value
        tail = tail?.previous
        return value
    }
    // push to head
    fun unshift(value: T) {
        val pHead = head
        if (pHead == null) { // empty list
            head = Node(value)
            tail = head
        } else {
            pHead.previous = Node(value, next = pHead )
            head = pHead.previous
        }
    }
    // pop from head
    fun shift(): T? {
        if (head == tail) {
            tail = null
        } else { // pop from head
            head?.next?.previous = null
        }
        val value = head?.value
        head = head?.next
        return value
    }
}


