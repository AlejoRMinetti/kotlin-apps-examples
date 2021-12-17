package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
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