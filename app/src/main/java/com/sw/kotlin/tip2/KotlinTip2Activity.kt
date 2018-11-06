@file:JvmName("Tip2Test")

package com.sw.kotlin.tip2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.sw.kotlin.tips.R
import kotlinx.android.synthetic.main.activity_tip2.*
import kotlin.properties.Delegates

class KotlinTip2Activity : AppCompatActivity() {

    /**
     * 属性的组成部分
     */
    private var name = "zhang san"
        set(value) {
            field = value //field是（Backing field）幕后字段
        }
        get() = field

    /**
     * 自定义set 和 get 方法
     */
    private var namePlus = "li si"
        set(value) {
            field = "$value 123 "
        }
        get() {
            return "$field 大地零一 "
        }

    /**
     * get 和 set 是不允许访问本身的局部变量
     */
    private var count = 1
    private var size = 0
        set(value) {
            Log.e("test", "count:${count++}")
            size = if (value > 10) 15 else 0
//            field = if (value > 10) 15 else 0
        }

    /**
     * 延迟属性
     */
    private val content: String by lazy { initContent() }

    private fun initContent(): String {
        Log.e("test", "count:${count++}")
        return "zhang san"
    }

    /**
     * 可观察属性
     */
    private var mBackPressedTime by Delegates.observable(0L) { prop, old, new ->
        //三个参数，分别是：被赋值的属性，旧值和新值。
        Log.e("test", "prop:$prop")
        Log.e("test", "old:$old")
        Log.e("test", "new:$new")
        if (new - old > 1000) {
            Toast.makeText(this, "再按一次返回就退出", Toast.LENGTH_SHORT).show()
        }
        if (new - old in 1..1000) {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip2)

        btn1.setOnClickListener {
            Log.d("test", "name:$name")

            name = "li si"
            Log.d("test", "name:$name")
        }

        btn2.setOnClickListener {
            Log.d("test", "namePlus:$namePlus")

            namePlus = "zhang san"
            Log.d("test", "namePlus:$namePlus")
        }

        btn5.setOnClickListener {
            size = 100
            Log.d("test", "size:$size")
        }

        btn6.setOnClickListener {
            Log.d("test", "content:$content")
            Log.d("test", "content:$content")
            Log.d("test", "content:$content")
            Log.d("test", "content:$content")
        }

        btn7.setOnClickListener {
            val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
            val p = Person2(data)
            Log.d("test", "name:$p.name")
            Log.d("test", "company:$p.company")
        }
    }

    override fun onBackPressed() {
        mBackPressedTime = System.currentTimeMillis()
//        super.onBackPressed()
    }
}

class Person2(private val attributes: Map<String, String>) {
    val name: String by attributes
    val company: String by attributes
    val address: String by attributes
    val email: String by attributes
}

