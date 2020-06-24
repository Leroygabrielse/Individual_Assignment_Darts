package com.leroygabrielse.dartsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*

const val GAMESTATS_REQUEST_CODE = 400

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initViews()
    }
    private fun initViews(){

        tvThrownP1.setText("Darts: 0")
        tvThrownP2.setText("Darts: 0")
        tvAvgP1.setText("Avg: 0")
        tvAvgP2.setText("Avg: 0")

        tvHintP1.visibility = View.INVISIBLE
        tvHintP2.visibility = View.INVISIBLE

        btnStats.setOnClickListener {view->
            val intent = Intent(this, StatsActivity::class.java)
            startActivityForResult(intent,
                GAMESTATS_REQUEST_CODE
            )
        }
        btnEnter.setOnClickListener {

        }
        btnOne.setOnClickListener {
            enterNumber("1")
        }
        btnTwo.setOnClickListener {
            enterNumber("2")
        }
        btnThree.setOnClickListener {
            enterNumber("3")
        }
        btnFour.setOnClickListener {
            enterNumber("4")
        }
        btnFive.setOnClickListener {
            enterNumber("5")
        }
        btnSix.setOnClickListener {
            enterNumber("6")
        }
        btnSeven.setOnClickListener {
            enterNumber("7")
        }
        btnEight.setOnClickListener {
            enterNumber("8")
        }
        btnNine.setOnClickListener {
            enterNumber("9")
        }
        btnZero.setOnClickListener {
            enterNumber("0")
        }

        btnBackspace.setOnClickListener {
            if(tvScoreInput.text.toString().length > 1){
                val newScore = tvScoreInput.text.toString().substring(0, tvScoreInput.text.toString().length - 1)
                tvScoreInput.setText(newScore)
            }
            else if (tvScoreInput.text.toString().length == 1){
                tvScoreInput.setText("0")
            }

        }

    }
    fun enterNumber(number: String){
        val score = tvScoreInput.text.toString()
        if (score.toInt()<=18){
            if (score == "0"){
                tvScoreInput.setText(number)
            }
            else {
                tvScoreInput.setText(score + number)
            }
        }
    }
}
