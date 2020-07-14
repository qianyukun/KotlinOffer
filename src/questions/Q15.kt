package questions

class GetKthNodeInLinkedList {
    fun test() {
        var head = SingleNode<Int>(null, 1)

        for (i in 2..10) {
            head = SingleNode<Int>(head, i)
        }

        getLastKthNode(head,3)
    }

    private fun getLastKthNode(head: SingleNode<Int>?, k: Int): SingleNode<Int>? {
        if (k < 0 || head == null) {
            return null
        }
        var lastKthNode: SingleNode<Int>? = head
        var count = 1
        while (count < k && lastKthNode?.next != null) {
            lastKthNode = lastKthNode.next
            count++
        }
        if (count <k){
            return null
        }
        var head1 = head
        var head1K = head
        while (lastKthNode?.next != null){
            lastKthNode = lastKthNode.next
            head1 = head1?.next
        }
        while (head1!=null){
            println(head1.value)
            head1 = head1.next
        }
        return  head1K
    }

}


