package questions

import java.util.*

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的 元素为 int 类型。
 * 对于有好好的队列不用，用两个栈实现也是脑残（可能真有这种只有栈没有队列的场景）
 */

fun testTwoStackPlayAsQueue(){

    val queue = QueueMadeOfTwoStack<Int>()
    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(4)

    print(queue.pop())
    print(queue.pop())
    print(queue.pop())
    print(queue.pop())
}

class QueueMadeOfTwoStack<T>{
    val stackPush = ArrayDeque<T>()
    val stackPop = ArrayDeque<T>()

    /**
     * O(1),O(N)
     */
    fun push(t:T){
        stackPush.push(t)
    }

    /**
     *
     */
    fun pop():T{
        if (stackPop.isEmpty()){
            while (stackPush.peek()!=null){
                stackPop.push(stackPush.pop())
            }
        }
        return stackPop.pop()
    }
}