package com.leroygabrielse.dartsapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_pre_game.*
const val GAME_REQUEST_CODE = 300
const val EXTRA_GAME_DATA = "EXTRA_GAME_DATA"

var playerOneName = ""
var playerTwoName = ""
var gameName = ""
var numberOfLegsOrSets = ""

class PreGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_game)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        initViews()
    }

    @SuppressLint("ResourceAsColor")
    private fun initViews(){

        val bundle: Bundle? = intent.extras

        bundle?.let{
            bundle.apply {
                val game: Game? = getParcelable("EXTRA_GAME")
                if (game != null){
                    btnPlayer1.text = "${game.playerOneName}"
                    btnPlayer2.text = "${game.playerTwoName}"

                    playerOneName = "${game.playerOneName}"
                    playerTwoName = "${game.playerTwoName}"
                    gameName = "${game.GameName}"
                    numberOfLegsOrSets = "${game.numberOfLegsOrSets}"
                }
            }
        }

        btnStart.setOnClickListener {view ->
            onStartClick()

        }
        btnPlayer1.setOnClickListener {
            btnPlayer1.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton4))
            btnPlayer2.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorText))
            btnPlayer1.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorText))
            btnPlayer2.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorButton))

            switchStarter()
        }
        btnPlayer2.setOnClickListener {
            btnPlayer2.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorButton4))
            btnPlayer1.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(applicationContext, R.color.colorText))
            btnPlayer2.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorText))
            btnPlayer1.setTextColor(ContextCompat.getColor(applicationContext, R.color.colorButton))

            switchStarter()
        }
    }
    private fun onStartClick(){
        val game = Game(gameName, playerOneName, playerTwoName, numberOfLegsOrSets.toInt())
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra(EXTRA_GAME_DATA, game)
        startActivityForResult(intent, GAME_REQUEST_CODE)

    }
    private fun switchStarter(){
        val temp = playerOneName
        playerOneName = playerTwoName
        playerTwoName = temp
    }
}

