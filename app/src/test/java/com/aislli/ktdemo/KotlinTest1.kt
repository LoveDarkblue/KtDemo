package com.aislli.ktdemo

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.properties.Delegates

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class KotlinTest1 {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    class User {
        var name: String by Delegates.observable("<no name>") {
            prop, old, new ->
            println("$old -> $new")
        }

        var age: Int by Delegates.vetoable(0) {
            property, oldValue, newValue ->
            println("${property.name}:$oldValue:$newValue")
            false
        }
    }

    @Test
    fun test16() {
        val user = User()
        user.name = "first"
        user.name = "second"

        user.age = 1
        user.age = 2
    }

    interface Base {
        fun printMessage()
        fun printMessageLine()
    }

    class BaseImpl(val x: Int) : Base {
        override fun printMessage() { print(x) }
        override fun printMessageLine() { println(x) }
    }

    class Derived(b: Base) : Base by b {
        override fun printMessage() { print("abc") }
    }

    @Test
    fun test17() {
        val b = BaseImpl(10)
        Derived(b).printMessage()//执行自身类里复写的方法 abc
        Derived(b).printMessageLine()//执行代理类里已有的方法 10
    }
}