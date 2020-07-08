package questions

//输出斐波那契数列的第 n 项
fun printFbrNth(n: Int) {
    if (n < 0) {
        return
    }
    var lastOne = 1
    var lastTwo = 0
    var result = 0
    if (n == 0) {
        result = lastTwo
        println(result)
        return
    }
    if (n == 1) {
        result = lastOne
        println(result)
        return
    }
    for (curIndex in 2..n) {
        result = lastTwo + lastOne
        lastTwo = lastOne
        lastOne = result
    }
    println(result)
}

//一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一 个 n 级的台阶总共有多少种跳法。
//f(n) =f(n-1)+f(n-2)
fun printForgJump(n: Int): Int {
    if (n == 0) {
        return 0
    }

    if (n == 1) {
        return 1
    }

    var lastOne = 1
    var lastTwo = 0
    var result = 0
    for (index in 2..n) {
        result = lastOne + lastTwo
        lastTwo = lastOne
        lastOne = result
    }
    return result
}

//我们可以用 2X1 的小矩形横着或者竖着去覆盖更大的矩形。
// 请问用 n 个 2X1 的小矩形无重叠地覆盖一个 2Xn 的大矩形，
// 总共有多少种方法？

//同上 f(n) =f(n-1)+f(n-2)

//一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级……它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//f(n) = f(n-1)+f(n-2)+f(n-3)+...
//f(n-1)= f(n-2)+f(n-3)+...
//f(n)=2f(n-1)=4f(n-2)+...

fun forgJumNTimes(n:Int):Int{
    return Math.pow(2.0, (n-1).toDouble()).toInt()
}