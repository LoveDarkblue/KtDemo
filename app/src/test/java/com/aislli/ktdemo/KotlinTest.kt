package com.aislli.ktdemo

import org.junit.Assert.*
import org.junit.Test
import kotlin.properties.Delegates

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class KotlinTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun test1() {
        var a = 1
        val s1 = "a is $a" //直接获取a的值
        a = 2
        val s2 = "${s1.replace("is", "was")}, but now is $a" //在大括号里可写表达式
        println(s1)//a is 1
        println(s2)//a was 1, but now is 2
    }

    @Test
    fun test2() {
        val a = 1
        val b = 2
        println(if (a > b) a else b)
    }

    @Test
    fun test3() {
        val args = arrayOf("1", "2")
        for (name in args)//相当于java的增强for循环
            println("Hello, ${name}!")

        for (i in args.indices) {//带下标的for循环
            println("Hello, ${args[i]}!")
        }
    }

    @Test
    fun test4() {
        val args = arrayOf("FR", "EN")
        val language = if (args.isEmpty()) "EN" else args[0]
        println(when (language) {
            "EN" -> "Hello!"
            "FR" -> "Salut!"
            "IT" -> "Ciao!"
            else -> "Sorry, I can't greet you in $language yet"
        })

        val listOf = listOf<Int>(0, 1, 2)
        when {
            1 in listOf -> println("found 1")
            3 in listOf -> println("found 3")
        }
    }

    @Test
    fun test5() {
        var i = 0
        while (i < 5) {
            println(i++)
        }
    }

    @Test
    fun test6() {
        for (x in 1..3) {
            print(x) //1 2 3
        }
        println()
        for (x in 1..10 step 2) {
            print(x)//13579
        }
        println()
        for (x in 10 downTo 1 step 2) {
            print(x)//10 8 6 4 2
        }
    }

    //zip
    @Test
    fun test7() {
        val list1 = listOf("a", "b", "c", "d")//自动推断类型，无需指定
        val list2 = listOf(1, 2, 3)
        val zip = list1.zip(list2)

        for (item in zip) {
            print(item)
        }
        println()
        for (item in zip) {
            print(item.first)
            print(item.second)
            println()
        }
    }

    //unzip
    @Test
    fun test8() {
        val listOf = listOf(Pair("a", "b"), Pair(1, 2))
        println(listOf)
        println(listOf.unzip().first)
        println(listOf.unzip().second)
    }

    @Test
    fun test9() {
        val list1 = listOf("a", "b", "c", "d")
        val list2 = listOf(1, 2, 3)
        val list = list1 + list2
        print(list)
    }

    @Test
    fun test10() {
        val list = listOf<Int>(1, 2, 3, 4, 5, 6)
        val partition = list.partition { it % 2 == 0 }
        print(partition.first)
    }

    @Test
    fun test11() {
        val list = listOf<Int>(11, -2, 1)
        println(list.reversed())//倒序排序
        println(list.sorted())//自然排序
        println(list.sortedDescending())//自然降序排序
        println(list.sortedBy { -it })//根据指定函数自然排序
        println(list.sortedByDescending { -it })//根据指定函数自然降序排序
    }

    @Test
    fun test12() {
        val list = listOf<Int>(11, -2, 1)
        assertTrue(list.contains(11))
        assertEquals(-2, list.elementAt(1))//返回第1个元素，如果长度小于1，会抛IndexOutOfBoundsException
        assertEquals(11, list.elementAtOrElse(3, { 8 + it }))//如果没有第3个元素，则返回8+3
        assertNull(list.elementAtOrNull(10))//如果角标越界，返回null

        assertEquals(1, list.first { it - 1 == 0 })//返回符合条件的第一个元素
        assertEquals(-2, list.last { it % 2 == 0 })//返回符合条件的最后一个元素

        assertNull(list.firstOrNull { it % 3 == 0 })//返回符合条件的第一个元素，如果没有则返回Null
        assertNull(list.lastOrNull { it % 3 == 0 })//返回符合条件的最后一个元素，如果没有则返回null

        val list1 = listOf(11, -2, 1, -2)
        assertEquals(1, list1.indexOf(-2))//返回这个元素的位置，如果未找到返回-1
        assertEquals(3, list1.lastIndexOf(-2))//返回这个元素的倒数第一的位置，如果未找到返回-1

        assertEquals(1, list.indexOfFirst { it % 2 == 0 })//返回符合条件的第一个元素的位置，如果没找到返回-1
        assertEquals(1, list.indexOfLast { it % 2 == 0 })//返回符合条件的最后一个元素的位置，如果没找到返回-1

        println(list.single { it % 2 == 0 })//返回符合条件的单个元素，如果没有或超过一个会抛出IllegalArgumentException  执行结果：-2
        assertNull(list.singleOrNull { it % 3 == 0 })//返回符合条件的单个元素，如果没有或超过一个返回null
    }

    @Test
    fun test13() {
        val list = listOf(11, -3, 1)
        val list1 = listOf(-1, 2, 3, -4, -5, 6)
        assertEquals(listOf(1), list.drop(2))//删掉List里前2个元素
        println(list1.dropWhile { it < 3 })//删掉从第一项起满足条件的元素，直到遇到不满足条件为止，到了3这里就不满足了，所以结果为[3, -4, -5, 6]
        println(list1.dropLastWhile { it < 0 })//删掉从最后一项起满足条件的元素，直到遇到不满足条件的元素为止，第一项6就不满足，所以结果为[-1, 2, 3, -4, -5, 6]

        assertEquals(listOf(-3), list.filter { it < 0 })//返回List里符合条件的元素集合
        assertEquals(listOf(11, 1), list.filterNot { it < 0 })//返回List里不符合条件的元素集合
        val list2 = listOf(11, -3, 1, null)
        assertEquals(listOf(11, -3, 1), list2.filterNotNull())//返回集合中不为null的元素
        val list3 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        println(list3.slice(listOf(1, 3, 5)))//返回集合中指定下标的元素集合 [2, 4, 6]
        println(list3.slice(listOf(1, 5))) // [2, 6]
        println(list3.slice(1..5 step 2)) //返回index1到5步长2的元素，[2, 4, 6]
        assertEquals(listOf(1, 2), list3.take(2))//返回前n个元素的集合
        assertEquals(listOf(9, 10), list3.takeLast(2))//返回最后n个元素的集合
        assertEquals(listOf(1, 2), list3.takeWhile { it < 3 })//从第一个开始返回所有符合条件的元素的集合
    }

    @Test
    fun test14() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        println(list.flatMap { listOf(it.toString() + "a") })//遍历一个集合，并把这个集合变成一个新的集合返回 [1a, 2a, 3a, 4a, 5a, 6a]
        assertEquals(mapOf("a" to listOf(1, 3, 5), "b" to listOf(2, 4, 6)), list.groupBy { if (it % 2 == 0) "b" else "a" })//根据指定条件把list分成两组组成map，以"a","b"为组名(key)
        val groupBy = list.groupBy {
            //根据条件把list分成多组list组成map {a=[1, 2], b=[3, 4], c=[5, 6]}
            when {
                it < 3 -> "a"
                it < 5 -> "b"
                else -> "c"
            }
        }
        println(groupBy)

        println(list.mapIndexed { index, it -> index * it })//带index和对应值遍历List，可对每个值操作后返回一个新的List [0, 2, 6, 12, 20, 30]
    }

    @Test
    fun test15() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        assertTrue(list.any { it % 2 == 0 })//至少有一个匹配条件的元素，就返回true，否则false
        assertTrue(list.all { it < 10 })//全部元素都满足条件才会返回true
        assertEquals(3, list.count { it % 2 == 0 })//返回满足条件的元素的个数
        assertEquals(31, list.fold(10) { total, next -> total + next })//先加10,再从List的第一个元素一直累加到最后一个
        assertEquals(31, list.foldRight(10) { total, next -> total + next })//效果同上，从右边开始累加
        list.forEach { print(it) }//遍历所有元素 123456
        println()
        list.forEachIndexed { index, value
            ->
            println("index $index ： $value")
        }//带下标遍历所有元素

        assertEquals(6, list.max())//最大值
        assertEquals(1, list.maxBy { -it })//根据条件去处后返回最大值
        //min minBy效果相反
        assertTrue(list.none { it % 7 == 0 })//如果找不到符合条件的元素就返回true
        assertEquals(21, list.reduce { total, next -> total + next })//效果同fold，但是没初始值
        assertEquals(21, list.reduceRight { total, next -> total + next })//效果同上，从右边开始
        assertEquals(3, list.sumBy { it % 2 })//遍历所有元素进行运算后结果累加
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
}