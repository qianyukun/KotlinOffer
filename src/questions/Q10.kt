package questions

//输入一个整数，输出该数二进制表示中 1 的个数。其中负数用补码表示。
fun get1NumsForBinary(n: Int): Int {
    var count = 0
    var num = n
    while (num != 0) {
        count++
        num = (num - 1) and num
    }
    return count
}