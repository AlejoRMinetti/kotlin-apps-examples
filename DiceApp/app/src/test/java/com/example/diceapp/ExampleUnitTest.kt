package com.example.diceapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun generates_number() {
        for ( i in 1..100){
        val dice = Dice(7)
        val rollResult = dice.roll()
        println("rollResult: ${rollResult}   attempt: ${i}")
        assertTrue( "The value of rollResult was not between 1 and 6",
            rollResult in 1..6
        )
        }
    }

}