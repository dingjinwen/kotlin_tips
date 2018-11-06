package com.sw.kotlin.tip5

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.activity_tip5.*

class KotlinTip5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip5)
        btn1.setOnClickListener {
            //这个实例中，用狗代理了猫,帮猫处理了叫声的操作
            Cat(Dog()).bark()
            //输出：wangwang
        }

        btn2.setOnClickListener {
            //这个实例中，用innerSet代理了CountingSet2,帮CountingSet2处理了add,addAll的操作
            val hashSet = hashSetOf("1", "2", "3", "4")
            val set = CountingSet2(hashSet)
            set.addAll(listOf("5", "6", "7"))
            Log.e("test", "set-----${set.size}----${set.objectAdded}")
            //输出：set-----7----7
        }
    }
}