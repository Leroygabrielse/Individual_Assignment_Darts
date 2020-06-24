package com.leroygabrielse.dartsapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*

const val PREGAME_REQUEST_CODE = 100
const val HISTORY_REQUEST_CODE = 200
const val EXTRA_GAME = "EXTRA_GAME"
var firstToString = "First to "
var legsOrSetsString = " Legs"

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            initViews()
        }
    @SuppressLint("ResourceAsColor")
    private fun initViews(){

        btnStart.setOnClickListener {
            Snackbar.make(tvBeginScore, "Works", Snackbar.LENGTH_LONG).show()
        }
        btnSets.setOnClickListener {
            etNumberOfLegs.setHint("Number of Sets")
            btnSets.setBackgroundColor(R.color.colorButton3)
            if (legsOrSetsString == " Legs"){
                legsOrSetsString = " Sets"
            }

        }
        btnLegs.setOnClickListener {
            etNumberOfLegs.setHint("Number of Legs")
            if (legsOrSetsString == " Sets"){
                legsOrSetsString = " Legs"
            }
        }
        btnBestof.setOnClickListener {
            if(firstToString == "First to "){
                firstToString = "Best of "
            }
        }
        btnFirstTo.setOnClickListener {
            if(firstToString == "Best of "){
                firstToString = "First to "
            }
        }
        btnStart.setOnClickListener { view ->
            onStartClick()
        }
        fabHistory.setOnClickListener {
                view ->
            val intent = Intent(this, HistoryActivity::class.java)
            startActivityForResult(intent,
                HISTORY_REQUEST_CODE
            )
        }

    }
    private fun onStartClick(){
        if(etPlayer1.text.toString().isNotBlank() && etPlayer2.text.toString().isNotBlank() && etNumberOfLegs.text.toString().isNotBlank()){
            val game = Game(firstToString + etNumberOfLegs.text.toString().toInt() + legsOrSetsString,etPlayer1.text.toString(), etPlayer2.text.toString(), etNumberOfLegs.text.toString().toInt())
            val intent = Intent(this, PreGameActivity::class.java)
            intent.putExtra(EXTRA_GAME, game)
            startActivityForResult(intent, PREGAME_REQUEST_CODE)
        }
    }
}