package questions

/**
 *
 * ==
 *  1. 如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等
 *  2. 如果作用于引用类型的变量，则比较的是所指向的对象的地址

 *  equals
 *  1. equals方法不能作用于基本数据类型的变量
 *  2. 如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
 *  3.诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。

 *  ===
 *  1. 对于基本数据类型，如果类型不同，其结果就是不等。如果同类型相比，与“==”一致，直接比较其存储的 “值”是否相等；
 *  2. 对于引用类型，与“==”一致，比较的是所指向的对象的地址
 */

fun test() {
    val s1 = CString("a")
    val s2 = CString("a")
    val s3 = CString("c")


    println(s1.equals(s2))
    println(s1 == s2)
    println(s1 === s2)
    println(s1 assign s2/* assign s3*/)
}

/**
 * open 修饰的类才可以被继承
 * 默认是final 不可继承
 */
open class CString(var str: String) {

    /**
     * 引用不一样 ｜ 内容不一样
     *  字符串赋值
     */
    infix fun assign(another: CString): CString {
        if (this !== another || this.str != another.str) {
            str = another.str
            println("set ${another.str}")
        }
        return this
    }

    override fun toString(): String {
        return "Cstring = $str"
    }

    /**
     * 重写equals方法
     * a==b 可以转换成
     * if(a == null){
     * return b== null
     * } else {
     * return a.equals(b)
     * }
     *
     * 即 a?.equals(b)?:b==null
     */
    override fun equals(other: Any?): Boolean {
        return when (other) {
            !is CString -> false
            else -> this === other || this.str == other.str
        }
    }

    override fun hashCode(): Int {
        return str.hashCode()
    }
}
