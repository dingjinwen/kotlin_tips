package com.sw.kotlin.tip6

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.activity_tip6.*

class KotlinTip6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip6)

        btn1.setOnClickListener { _ ->
            //            oneParams({ it -> it * 2 })
            //            oneParams{ it -> it * 2 }
            oneParams { it * 2 }
        }

        btn2.setOnClickListener {
            unusedParams { _, used -> used * 2 }
        }

        btn3.setOnClickListener {
            //            logic(1, 2, { x, y -> x + y })
            logic(1, 2) { x, y -> x + y }
        }

        btn4.setOnClickListener {
            unusedParams { _, used ->
                println("print first")
                used * 2
//                return@unusedParams used * 2
            }
        }

        btn5.setOnClickListener {
            log("world", printMsg)
        }
    }

    /**
     * 当参数只有一个的时候，声明中可以不用显示声明参数，在使用参数时可以用 it 来替代那个唯一的参数
     */
    private fun oneParams(one: (Int) -> Int) {
        Log.e("test", "oneParams : ${one(5)}")
    }

    /**
     * 当有多个用不到的参数时，可以用下划线来替代参数名(1.1以后的特性)，但是如果已经用下划线来省略参数时，是不能使用 it 来替代当前参数的
     */
    private fun unusedParams(unused: (Int, Int) -> Int) {
        Log.e("test", "unusedParams : ${unused(5, 10)}")
    }

    /**
     * 如果函数的最后一个参数是一个函数，那么我们在用Lambda表达最后一个函数参数的时候，可以把它放在括号()外面
     */
    private fun logic(a: Int, b: Int, calc: (Int, Int) -> Int) {
        println("calc : ${calc(a, b)}")
    }

    /**
     * 高阶函数
     */
    private val printMsg = { str: String ->
        println(str)
    }

    private val log = { str: String, printLog: (String) -> Unit ->
        printLog(str)
    }
}


