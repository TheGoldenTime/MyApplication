package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var nameText: EditText
    lateinit var playerNameTxt: TextView
    lateinit var numberTxt: TextView
    lateinit var diceImg: ImageView
    private val playerName: GameInfo = GameInfo("Ready Player One ?","1")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.gameInfo = playerName
        //diceImg = findViewById(R.id.diceImage)
        //nameText = findViewById(R.id.EditPlayerName)
        //playerNameTxt = findViewById(R.id.playerName)
        //numberTxt = findViewById(R.id.numberText)
        //val rollBtn:Button = findViewById(R.id.rollButton)
        //rollBtn.setOnClickListener {rollDice()}
        //val updateBtn: Button = findViewById(R.id.updateButton)
        //updateBtn.setOnClickListener {updateName(it)}

        binding.rollButton.setOnClickListener {rollDice()}
        binding.updateButton.setOnClickListener{updateName(it)}
    }

    private fun updateName(view: View){
        binding.apply{
            binding.playerName.text = binding.EditPlayerName.text
            binding.playerName.clearComposingText()
        }

        nameText.text.clear()
        nameText.clearFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun rollDice(){
        val randNum = (1..6).random()
        //numberTxt.text = randNum.toString()

        val imgSrc = when(randNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(imgSrc)
        binding.numberText.text = randNum.toString()
        //diceImg.setImageResource(imgSrc)
    }

}