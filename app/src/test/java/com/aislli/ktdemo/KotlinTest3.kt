package com.aislli.ktdemo

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.reflect.KProperty

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class KotlinTest3 {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }
    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }

    class Example {
        var p: String by Delegate()
    }

    @Test
    fun test19(){
        val e = Example()
        e.p = "aaa"
        println(e.p)
    }

    val lazyValue: String by lazy {
        println("first!")
        "Hello"
    }

    @Test
    fun test20() {
        println(lazyValue)
        println(lazyValue)
    }

    class User(map: Map<String, Any?>) {
        val name: String by map
        val age: Int     by map
    }

    @Test
    fun test21() {
        val user = User(mapOf(
                "name" to "John Doe",
                "age"  to 25
        ))
        println(user.name) // Prints "John Doe"
        println(user.age)  // Prints 25

        var user1:User? = null

        println(user1)
    }
}