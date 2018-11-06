package com.sw.kotlin.tip5

/**
 * Created by dingjinwen01 on 2018/9/5.
 */
class CountingSet2<T>(private val innerSet: MutableCollection<T> = HashSet()) :MutableCollection<T> by innerSet{

    var objectAdded = 0

    init {
        objectAdded += innerSet.size
    }

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}