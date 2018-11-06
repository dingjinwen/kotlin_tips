package com.sw.kotlin.tip3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.activity_tip3.*

class KotlinTip3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip3)

        btn1.setOnClickListener {
            Log.e("test", "${hasEmpty("zhang san", "")}")
        }

        btn2.setOnClickListener {
            toast("扩展函数用法")
        }


        btn3.setOnClickListener {
            printBark(Animal())
            printBark(Dog())
        }

        btn4.setOnClickListener {
            Student(1, "zhang san", 20).sayHello()
        }

        btn5.setOnClickListener {
            Log.d("test", "instance:${SingleInstanceTwo.getInstance("zhang san")}")
            Log.d("test", "instance:${SingleInstanceThere.getInstance("zhang san")}")
        }

        btn6.setOnClickListener {
            Log.d("test", "instance:${StringUtils.isStartWithA("age")}")
            Log.d("test", "instance:${StringUtil.isStartWithA("name")}")
        }

        btn7.setOnClickListener {
            Log.d("test", StringUtils.alphabet())
            Log.d("test", StringUtils.alphabetApply())
            Log.d("test", StringUtils.alphabetWith())
            Log.d("test", StringUtils.alphabetLet())
            StringUtils.testAlso()
            StringUtils.testRun()
        }

        btn8.setOnClickListener {
            println("2 iInfix 1:${2 iInfix 1}") // 打印：2 iInfix 1
            // 与下面是相同的
            println("2.iInfix(1):${2.iInfix(1)}") // 打印：2.iInfix(1)
        }

    }

    /**
     * 变参函数
     */
    private fun hasEmpty(vararg strArray: String): Boolean {
        for (str in strArray) {
            if (str.isNullOrEmpty()) {
                return true
            }
        }
        return false
    }

    /**
     * 扩展是静态解析的
     */
    private fun printBark(animal: Animal) {
        Log.e("test", "${animal.bark()}")
    }

}


open class Animal

class Dog : Animal()

fun Animal.bark() = "animal"

fun Dog.bark() = "dog"


