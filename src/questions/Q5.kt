package questions

import java.util.*

fun printLinkedListBackDirection() {

    val node1 = Node("1", null)
    val node2 = Node("2", node1)
    val node3 = Node("3", node2)
    val node4 = Node("4", node3)
    val node5 = Node("5", node4)
    val node6 = Node("6", node5)
    val head = Node("7", node6)
    backPrint1(head)
}

class Node {
    var data: String
    var next: Node? = null

    constructor(s: String, n: Node?) {
        data = s
        next = n
    }
}

fun backPrint1(head: Node?) {
    if (head == null) {
        return
    }
    val stack = ArrayDeque<Node>()
    var point: Node?= head
    while (point?.next != null) {
        println("add node ${point.data}")
        stack.addLast(point)
        point = point.next
    }

    var node :Node?
    node = stack.pollLast()
    while(node!=null){
        print(node.data)
        node = stack.pollLast()
    }

}

