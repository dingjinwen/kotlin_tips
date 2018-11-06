package com.sw.kotlin.tip2

abstract class BasePeople {
    /**
     * 用abstract修饰的属性,自身不能初始化，要在子类进行初始化，不能省略类型
     */
    abstract var name: String

    protected var age = 25
}