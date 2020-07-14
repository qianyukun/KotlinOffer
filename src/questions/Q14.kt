package questions

//将数组中的奇数放在偶数前,保证奇数之间原顺序，保证偶数之间顺序
class SortArrayMode2 {

    fun test() {
        sortArrayByMode2(intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10))
    }

    private fun sortArrayByMode2(a: IntArray?): IntArray? {
        if (a == null || a.isEmpty()) {
            return null
        }
        var lastOdd: Int = a.lastIndex
        var lastEven: Int = a.lastIndex

        while (lastEven >= 0 && lastOdd > 0) {
            //从后找到第一个奇数
            while (lastEven >= 0 && a[lastEven] % 2 == 0) {
                lastEven--
            }
            //从后找到第一个偶数
            while (lastOdd >= 0 && a[lastOdd] % 2 != 0) {
                lastOdd--
            }
            if (lastEven > lastOdd && lastOdd > 0) {
                val temp = a[lastOdd]
                var tempLastOdd = lastOdd
                while (tempLastOdd < lastEven) {
                    a[tempLastOdd] = a[tempLastOdd + 1]
                    tempLastOdd++
                }
                a[lastEven] = temp
            } else {
                lastOdd--
            }
            for (i in a) {
                print("$i ")
            }
            println()
        }
        return a
    }
}