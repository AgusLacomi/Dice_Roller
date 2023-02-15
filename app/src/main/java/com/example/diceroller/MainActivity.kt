package com.example.diceroller


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage : ImageView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main) // Layout inflated

        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.text = "Let´s Roll!"

        rollButton.setOnClickListener {
            val toastValue = rollDice()
            Toast.makeText(applicationContext, toastValue.toString(), Toast.LENGTH_SHORT).show()
        }

        diceImage = findViewById(R.id.dice_image)

    }

    private fun rollDice(): Int {

        val randomInt = (1..6).shuffled().last()

        val drawableResource = when (randomInt) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)

        return randomInt
    }
}