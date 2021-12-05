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
    private var lastRoll: Int? = null
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // additional functionality: if roll same number again, send a Toast
        if ( diceRoll == lastRoll){
            Toast.makeText(this, "$diceRoll rolled again!", Toast.LENGTH_SHORT).show()
        }
        lastRoll = diceRoll

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
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