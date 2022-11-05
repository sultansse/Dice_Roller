package kz.ss_softwareit.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kz.ss_softwareit.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.textAsButton.setOnClickListener() {
            binding.textAsButton.text = "TEXT is changed!"
        }


        val rollButton: Button = findViewById(R.id.roll)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = arrayOf(dice.roll(), dice.roll())

        val diceImage1: ImageView = findViewById(R.id.imageView1)
        diceImage1.setImageResource(R.drawable.dice_2)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        diceImage2.setImageResource(R.drawable.dice_2)

        val drawableResource1 = when (diceRoll[0]) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawableResource1)

        val drawableResource2 = when (diceRoll[1]) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)

        diceImage1.contentDescription = diceRoll[0].toString()
        diceImage2.contentDescription = diceRoll[1].toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
