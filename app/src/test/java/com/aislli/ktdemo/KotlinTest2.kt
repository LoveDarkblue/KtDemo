package com.aislli.ktdemo

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class KotlinTest2 {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }
    interface Base {
        val message: String
        fun print()
    }

    class BaseImpl(val x: Int) : Base {
        override val message = "BaseImpl: x = $x"
        override fun print() { println(message) }
    }

    class Derived(b: Base) : Base by b {
        // This property is not accessed from b's implementation of `print`
        override val message = "Message of Derived"
    }

    @Test
    fun test18() {
        val b = BaseImpl(10)
        val derived = Derived(b)
        derived.print()
        println(derived.message)
    }
}