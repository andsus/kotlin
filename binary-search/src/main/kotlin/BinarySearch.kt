object BinarySearch {
    // list is sorted
    tailrec fun <T: Comparable<T>>search(list: List<T>, target: T, left: Int = 0, right: Int = list.size - 1): Int {
        require(left >= 0)
        if (left > right) throw NoSuchElementException()

        val pivot = (left + right) / 2
        val pivotValue = list[pivot]
        return when {
            pivotValue == target -> pivot
            target < pivotValue -> search(list, target, left, pivot - 1) // search on left side
            else -> search(list, target, pivot + 1, right) // search on right side
        }

    }
}