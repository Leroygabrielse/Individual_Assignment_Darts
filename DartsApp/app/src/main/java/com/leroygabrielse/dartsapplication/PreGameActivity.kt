package com.leroygabrielse.dartsapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pre_game.*
const val GAME_REQUEST_CODE = 300

class PreGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_game)

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
                }
            }
        }

        btnStart.setOnClickListener {view ->
            val intent = Intent(this, GameActivity::class.java)
            startActivityForResult(intent,
                GAME_REQUEST_CODE
            )
        }
        btnPlayer1.setOnClickListener {

        }
        btnPlayer2.setOnClickListener {

        }
    }
}