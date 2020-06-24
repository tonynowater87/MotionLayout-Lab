package com.tonynowater.librarytest

import org.junit.Assert
import org.junit.Test

import kotlin.random.Random

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        val currentScannedTags: MutableList<String> = mutableListOf()

        repeat(50) {
            val newList = listOf(Random.nextInt(0, 10).toString(), Random.nextInt(0, 10).toString())
            if (!currentScannedTags.containsAll(newList)) {
                currentScannedTags.addAll(newList)
            }
        }

        currentScannedTags.forEach {
            println(it)
        }

        currentScannedTags.removeAll(listOf("2", "4"))

        println("======== remove 2 and 4")

        currentScannedTags.forEach {
            println(it)
        }

        println("======== only 1 or 3")

        currentScannedTags.filter {
            (it == "1") or (it == "3")
        }.forEach {
            println(it)
        }
    }

    @Test
    fun `obj === `() {
        val obj1 = MyObj()
        val obj2 = MyObj()
        Assert.assertTrue(obj1 === obj2)
    }

    @Test
    fun `obj == `() {
        val obj1 = MyObj()
        val obj2 = MyObj()
        Assert.assertTrue(obj1 == obj2)
    }

    class MyObj : Object() {
        override fun equals(other: Any?): Boolean {
            return hashCode() == other.hashCode()
        }

        override fun hashCode(): Int {
            return 56
        }
    }

    @Test
    fun `compare test`() {

        val MAX_VALUE = "Function"
        val MIN_VALUE = "Character"

        var result = mutableListOf<TestObj>()

        var originData = listOf(
            TestObj(content = "E"),
            TestObj(content = "B"),
            TestObj(content = "C"),
            TestObj(content = "Function"),
            TestObj(content = "Character"),
            TestObj(content = "A")
        )

        originData.firstOrNull { it.content == MAX_VALUE }?.also {
            result.add(it)
        }

        originData.filter { it.content != MAX_VALUE && it.content != MIN_VALUE }
            .sortedWith(Comparator { o1, o2 ->
                o1.content.compareTo(o2.content)
            }).also {
                result.addAll(it)
            }

        originData.firstOrNull { it.content == MIN_VALUE }?.also {
            result.add(it)
        }

        result.forEachIndexed { index, testObj ->
            println("$index ${testObj.content}")
        }

    }

    data class TestObj(val content: String)
}
