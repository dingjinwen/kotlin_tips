package com.sw.kotlin.tip7

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.activity_tip7.*

class KotlinTip7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip7)
        btn1.setOnClickListener {
            val lily = User("lily", 20)
            Log.e("test", lily.toString())

            val olderLily = lily.copy(age = 30)
            Log.e("test", olderLily.toString())
        }

        btn2.setOnClickListener {
            val (year, month, day) = Triple(2017, "6月", "14号")
            Log.e("test", "${year}年$month$day")

            val date = Triple(2017, "6月", "14号")
            Log.e("test", "${date.first}年${date.second}${date.third}")
        }

        btn3.setOnClickListener {
            val (name, age) = User("person", 20)
            println(name) // 打印person
            println(age) // 打印20
        }
    }
}
