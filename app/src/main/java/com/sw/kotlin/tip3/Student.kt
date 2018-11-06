package com.sw.kotlin.tip3

import android.util.Log

class Student(private var name: String) {

    private var age: Int? = null
    private var classId: Int? = null

    constructor(name: String, age: Int) : this(name) {
        this.age = age
        this.name = name
    }

    constructor(classId: Int, name: String, age: Int) : this(name, age) {
        this.classId = classId
        this.age = age
        this.name = name
    }

    fun sayHello() {
        Log.e("test", "hello $name")
        Log.e("test", "hello $classId")
        Log.e("test", "hello $age")
    }
}