package questions

class SingleNode<T> constructor(var next: SingleNode<T>?, var value: T) {

    companion object {
        fun buildSimpleList(): SingleNode<Int> {
            var head = SingleNode<Int>(null, 1)

            for (i in 2..10) {
                head = SingleNode<Int>(head, i)
            }
            return head
        }
    }
}