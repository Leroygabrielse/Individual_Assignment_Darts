package com.leroygabrielse.dartsapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            actionBar?.hide()
            initViews()
        }
    @SuppressLint("ResourceAsColor")
    private fun initViews(){

        btnStart.setOnClickListener {
            Snackbar.make(tvBeginScore, "Works", Snackbar.LENGTH_LONG).show()
        }
        btnSets.setOnClickListener {
            etNumberOfLegs.setHint("Number of Sets")
            if (legsOrSetsString == " Legs"){
                legsOrSetsString = " Sets"
            }
            btnSets.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton3))
            btnLegs.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton2))
            btnSets.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorText))
            btnLegs.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorButton))

        }
        btnLegs.setOnClickListener {
            etNumberOfLegs.setHint("Number of Legs")
            if (legsOrSetsString == " Sets"){
                legsOrSetsString = " Legs"
            }
            btnLegs.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton3))
            btnSets.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton2))
            btnLegs.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorText))
            btnSets.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorButton))
        }
        btnBestof.setOnClickListener {
            if(firstToString == "First to "){
                firstToString = "Best of "
            }
            btnBestof.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton3))
            btnFirstTo.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton2))
            btnBestof.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorText))
            btnFirstTo.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorButton))
        }
        btnFirstTo.setOnClickListener {
            if(firstToString == "Best of "){
                firstToString = "First to "
            }
            btnFirstTo.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton3))
            btnBestof.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton2))
            btnFirstTo.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorText))
            btnBestof.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorButton))
        }
        btnStart.setOnClickListener { view ->
            if(etNumberOfLegs.text.toString().toInt() % 2 == 0 && firstToString == "Best of "){
                Snackbar.make(tvBeginScore, "No possible game, enter uneven or change game type", Snackbar.LENGTH_LONG).show()
            }
            else {
                onStartClick()
            }

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