package com.sw.kotlin.tip3


object StringUtil {
    @JvmStatic
    fun isStartWithA(str: String): Boolean {
        return str.startsWith("a")
    }
}

class StringUtils {
    companion object {
        fun isStartWithA(str: String): Boolean {
            return str.startsWith("a")
        }

        /**
         * 打印字母表函数，在函数内result变量在好几处有使用到
         */
        fun alphabet(): String {
            val result = StringBuilder()
            result.append("START\n")
            for (letter in 'A'..'Z') {
                result.append(letter)
            }
            result.append("\nEND")
            return result.toString()
        }

        /**
         * apply用法
         * 打印字母表函数，apply函数，调用某对象的apply函数，在函数范围内，可以任意调用该对象的任意方法，并返回该对象
         */
        fun alphabetApply(): String {
            // fun <T> T.apply(f: T.() -> Unit): T { f(); return this }
            return StringBuilder().apply {
                append("START\n")
                for (letter in 'A'..'Z') {
                    append(letter)
                }
                append("\nEND")
            }.toString()
        }

        /**
         * 打印字母表函数，with函数是一个单独的函数，并不是Kotlin中的extension，所以调用方式有点不一样，返回是最后一行
         */
        fun alphabetWith(): String {
            // fun <T, R> with(receiver: T, f: T.() -> R): R = receiver.f()
            return with(StringBuilder()) {
                append("START\n")
                for (letter in 'A'..'Z') {
                    append(letter)
                }
                append("\nEND")
                toString()
            }
        }

        /**
         * 打印字母表函数，let函数，默认当前这个对象作为闭包的it参数，返回值是函数里面最后一行，或者指定return
         * XX?.let{}这种写法在代码中，比较常见
         * XX?:let{}
         */
        fun alphabetLet(): String {
            // fun <T, R> T.let(f: (T) -> R): R { f(this)}
            return StringBuilder().let {
                it.append("START\n")
                for (letter in 'A'..'Z') {
                    it.append(letter)
                }
                it.append("\nEND")
                it.toString()
                //  return it.toString()
            }
        }

        /**
         * also()函数和let()函数很像，但是返回值为该对象自己
         * 字面理解：做。。。的同时也做。。。
         */
        fun testAlso() {
            // fun <T> T.also(block: (T) -> Unit): T { block(this); return this }
            "testAlso".apply {
                println("this = " + this)
            }.also { println(it) }
        }

        /**
         * run函数和apply函数很像，只不过run函数是使用最后一行的返回，apply返回当前自己的对象。
         */
        fun testRun() {
            // fun <T, R> T.run(f: T.() -> R): R = f()
            "testRun".run {
                println("this = " + this)
            }.let { println(it) }
        }

    }
}