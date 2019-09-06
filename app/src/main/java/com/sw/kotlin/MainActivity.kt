package com.sw.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hk01.comm.ddutils.TimeUtils
import com.sw.kotlin.tip2.KotlinTip2Activity
import com.sw.kotlin.tip3.KotlinTip3Activity
import com.sw.kotlin.tip3.invokeActivity
import com.sw.kotlin.tip4.KotlinTip4Activity
import com.sw.kotlin.tip5.KotlinTip5Activity
import com.sw.kotlin.tip6.KotlinTip6Activity
import com.sw.kotlin.tip7.KotlinTip7Activity
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toTip2.setOnClickListener {
            invokeActivity(KotlinTip2Activity::class.java)
        }

        toTip3.setOnClickListener {
            invokeActivity(KotlinTip3Activity::class.java)
        }

        toTip4.setOnClickListener {
            invokeActivity(KotlinTip4Activity::class.java)
        }

        toTip5.setOnClickListener {
            invokeActivity(KotlinTip5Activity::class.java)
        }

        toTip6.setOnClickListener {
            invokeActivity(KotlinTip6Activity::class.java)
        }

        toTip7.setOnClickListener {
            invokeActivity(KotlinTip7Activity::class.java)
        }

        toTip8.setOnClickListener {
            invokeActivity(AnkoToDoListActivity::class.java)
        }

        toTip9.setOnClickListener {
            Log.d("djw", "" + TimeUtils.getYear())
        }

    }

}
