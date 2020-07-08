package questions

//O(1)时间删除链表节点
class ListNode constructor(var next: ListNode?,var value:Int)

fun deleteNode(h: ListNode?, deleteListNode: ListNode?) :ListNode?{
    var head:ListNode? = h
    var deleteNode = deleteListNode
    if (head == null)
        return null
    if (deleteNode == null)
        return head
    if (deleteNode.next != null) {
        //中间节点
        deleteNode.value = deleteNode.next!!.value
        deleteNode.next = deleteNode.next!!.next
    } else if(head == deleteNode){
        //只有一个头节点
        head = null
        deleteNode = null
    } else {
        //尾节点,找到尾节点的前节点，置空前节点的next
        var curNode = head
        while (curNode!!.next!= deleteListNode){
            curNode = curNode.next
        }
        curNode.next=null
        deleteNode = null
    }
    return head
}