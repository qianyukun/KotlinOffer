package questions

//输入数字 n，按顺序打印从 1 到最大的 n 位数十进制数，比如：输入 3，打印出 1 到 999.
fun printNbitsNum(n: Int) {
    if (n < 1)
        return
    var i = 1
    var list = ArrayList<String>()
    while (i <= n) {
        if (i == 1) {
            for (j in 0..9) {
                list.add(j.toString())
                println(j.toString())
            }
        } else {
            val listTemp = ArrayList<String>()
            for (j in 1..9) {
                for (string in list) {
                    println(j.toString() + string)
                    listTemp.add(j.toString() + string)
                }
            }
            list = listTemp
        }
        i++
    }
}