package questions

//给定一个 double 类型的浮点数 base
// 和 int 类型的整数 exponent。
// 求 base 的 exponent 次方。
// 不得使用库函数，不需要考虑大数问题

// x^5 = x*((x^2)^2) = x* (x^4)
//时间复杂度log(n)
fun power(base: Double, n: Int): Double {
    var d = base
    var exponent = n
    if (d == 0.0) {
        return 0.0
    }
    if (exponent == 0) {
        return 1.0
    }
    if (exponent == 1) {
        return d
    }
    if (d < 0) {
        d = 1 / d
        exponent = -n
    }
    var result = 1.0

    while (exponent > 0) {
        if (exponent and 1 == 1)
            result *= d
        d *= d
        exponent = exponent shr 1
    }
    return result
}