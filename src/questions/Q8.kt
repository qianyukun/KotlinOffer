package questions

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的 旋转。
// 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如
// 数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为 1。
// NOTE：给出的所 有元素都大于 0，若数组大小为 0，请返回-1。假设数
// 组中不存在重复元素

fun findMinInRevertArray(a: IntArray?): Int {
    if (a == null || a.isEmpty()) {
        return -1
    }
    var left = 0
    var right = a.size - 1
    var mid = (right + left) / 2
    while (left < right) {
        if (a[mid] > a[left]) {
            left = mid + 1
        } else {
            right = mid
        }
        mid = (right + left) / 2
    }
    return a[left]
}