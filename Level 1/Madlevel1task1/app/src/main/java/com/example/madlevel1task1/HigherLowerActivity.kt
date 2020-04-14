package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class HigherLowerActivity : AppCompatActivity() {
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    /**
     * Set the initial (UI) state of the game
     */
    private fun initViews() {
        btnHigher.setOnClickListener{onHigherClick()}
        btnEquals.setOnClickListener{onEqualsClick()}
        btnLower.setOnClickListener{onLowerClick()}
        updateUI()

    }

    /**
     * Update the last throw text and the dice image resource drawable with the current throw
     */
    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, this.lastThrow)

        when(currentThrow) {
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick(){
        rollDice()
        if(currentThrow > lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualsClick(){
        rollDice()
        if(currentThrow == lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        rollDice()
        if(currentThrow < lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }


    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }

}
