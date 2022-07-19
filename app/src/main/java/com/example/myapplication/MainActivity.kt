package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nameText: EditText
    lateinit var playerNameTxt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameText = findViewById(R.id.EditPlayerName)
        playerNameTxt = findViewById(R.id.playerName)
        val rollBtn:Button = findViewById(R.id.rollButton)
        rollBtn.setOnClickListener {rollDice()}
        val updateBtn: Button = findViewById(R.id.updateButton)
        updateBtn.setOnClickListener {updateName(it)}
    }

    private fun updateName(view: View){
        playerNameTxt.text = nameText.text

        nameText.text.clear()
        nameText.clearFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    private fun rollDice(){
        val randNum = (1..6).random()
        numberTxt.Text = randNum.toString()

        val imgSrc = when(randNum) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImg.setImageResource(imgSrc)
    }

}