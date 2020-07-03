package questions

fun testInstance() {
    println(Instance.InstanceHolder.instance)
    println(Instance2.get())
    println(SingleInstance.getInstance(4))
}

class Instance private constructor() {
    class InstanceHolder {
        companion object {
            val instance = Instance()
        }
    }
}

/**
 * 某变量可以为null
 * 就在该变量后面加？
 */
class Instance2 private constructor() {
    companion object {
        private var instance: Instance2? = null
            get() {
                if (field == null) {
                    field = Instance2()
                }
                return field
            }

        fun get(): Instance2 {
            return instance!!
        }
    }
}

/**
 * 双重校验锁
 */
class SingleInstance private constructor(private var count: Int) {
    companion object {
        @Volatile
        private var instance: SingleInstance? = null

        fun getInstance(count: Int): SingleInstance {
            return instance ?: synchronized(this) {
                SingleInstance(count).also { instance = it }
            }
        }
    }

    fun print():Int{
        return count
    }
}

