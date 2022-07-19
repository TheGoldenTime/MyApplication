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

    }
}