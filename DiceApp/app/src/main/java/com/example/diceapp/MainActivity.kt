package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create 2 new Dices object with 6 sides and roll it
        val dice1 = Dice(6)
        val dice1Roll = dice1.roll()
        val dice2 = Dice(6)
        val dice2Roll = dice2.roll()

        // Update the screen with the dice rolls
        val result1TextView: TextView = findViewById(R.id.dice1_textView)
        result1TextView.text = dice1Roll.toString()
        val result2TextView: TextView = findViewById(R.id.dice2_textView)
        result2TextView.text = dice2Roll.toString()
    }
}

/**
 * This is the Dice class
 * atribute:
 * numSide: the number of sides of the dice
 * method:
 * roll(): generate random number from 1 to numSide
 */
class Dice(private val numSides: Int) {
    /**
     * generate random number from 1 to numSide
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}