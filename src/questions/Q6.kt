package questions

/*
输入前序遍历序列 {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 */
fun rebuildbinTree() {
    val preOrder: IntArray = intArrayOf(1, 2, 4, 7, 3, 5, 6, 8)
    val inOrder: IntArray = intArrayOf(4, 7, 2, 1, 5, 3, 8, 6)
    var root: TreeNode? = rebuild(preOrder, inOrder)
    preOrderPrint(root)
}

/**
 * preOrder copied:【root+left+right】
 * inOrder copied:【left+root+right】
 */
fun rebuild(preOrder: IntArray?, inOrder: IntArray?): TreeNode? {
    if (preOrder == null || inOrder == null
            || preOrder.isEmpty() || inOrder.isEmpty()
            || preOrder.size != inOrder.size)
        return null
    var rootNode: TreeNode = TreeNode(preOrder[0])
    //find root
    var indexOfRootInInOderArray: Int = -1
    for (i: Int in 0 until inOrder.size) {
        if (preOrder[0] == inOrder[i]) {
            indexOfRootInInOderArray = i
            break
        }
    }
    //rebuild （left）
    rootNode.leftNode = rebuild(preOrder.copyOfRange(1, indexOfRootInInOderArray+1),
            inOrder.copyOfRange(0, indexOfRootInInOderArray))
    //rebuild （right）
    rootNode.rightNode = rebuild(preOrder.copyOfRange(1 + indexOfRootInInOderArray, preOrder.size),
            inOrder.copyOfRange(1 + indexOfRootInInOderArray, inOrder.size))
    return rootNode
}

fun preOrderPrint(rootNode: TreeNode?) {
    if (rootNode == null) {
        return
    }
    print(rootNode.data)
    preOrderPrint(rootNode.leftNode)
    preOrderPrint(rootNode.rightNode)
}