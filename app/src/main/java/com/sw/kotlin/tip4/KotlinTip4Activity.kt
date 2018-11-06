package com.sw.kotlin.tip4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.activity_tip4.*

class KotlinTip4Activity : AppCompatActivity() {

    var aInt: Int by CustomPreference(this, "age", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip4)

        btn1.setOnClickListener {
            test()
        }
    }
    
    private fun test() {
        println(aInt)//会从SharedPreference取这个数据
        aInt = 9 //会将这个数据写入SharedPreference
        println(aInt)//会从SharedPreference取这个数据
    }
}