package com.sw.kotlin.tip3

import android.util.Log

/**
 * 简单的写法，直接用伴生对象返回一个val修饰的外部类对象就可以了
 */
class SingleInstance private constructor() {
    companion object {
        val instance = SingleInstance()
    }
}

/**
 * 在类被调用的时候才去初始化他的对象,以下代码将线程安全问题交给虚拟机在静态内部类加载时处理，是一种推荐的写法：
 */
class SingleInstanceOne private constructor() {
    private object Holder {
        val INSTANCE = SingleInstanceOne()
    }

    companion object {
        val instance: SingleInstanceOne by lazy { Holder.INSTANCE }
    }
}

/**
 * 带参数的单例，简单写法
 */
class SingleInstanceTwo private constructor(name: String) {

    init {
        Log.e("test", "name:$name")
    }

    companion object {
        @Volatile
        private var instance: SingleInstanceTwo? = null

        fun getInstance(name: String): SingleInstanceTwo {
            if (instance == null) {
                synchronized(SingleInstanceTwo::class) {
                    if (instance == null) {
                        instance = SingleInstanceTwo(name)
                        Log.e("test", "instance:$instance")
                    }
                }
            }
            return instance!!
        }
    }
}

/**
 * 带参数的单例，去掉断言，google推荐的写法
 */
class SingleInstanceThere private constructor(name: String) {

    init {
        Log.e("test", "name:$name")
    }

    companion object {
        @Volatile
        private var instance: SingleInstanceThere? = null

        fun getInstance(name: String): SingleInstanceThere {
            return instance ?: synchronized(this) {
                instance ?: SingleInstanceThere(name).also {
                    instance = it
                    Log.e("test", "instance:$instance")
                }
            }
        }
    }
}