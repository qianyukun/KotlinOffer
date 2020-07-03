package questions

fun test2DArray() {
    var a = Array(9) { IntArray(9) }
    var dert = 0
    for (i in 0 until a.size) {
        val row = IntArray(9)
        for (j in 0 until row.size) {
            a[i][j] = ++dert
        }
    }

    for (i in a) {
        for (j in i) {
            print("$j ")
        }
        println()
    }

    print(if (findTarget(a, 9)) "true" else "false")
}

fun findTarget(array: Array<IntArray>, target: Int): Boolean {
    if (array == null) {
        return false
    }
    for (i in 0 until array.size) {
        for (j in 0 until array[i].size) {
            if (array[i][j] == target)
                return true
        }
    }
    return false
}