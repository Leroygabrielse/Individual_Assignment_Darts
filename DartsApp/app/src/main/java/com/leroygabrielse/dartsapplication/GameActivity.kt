package com.leroygabrielse.dartsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*

const val GAMESTATS_REQUEST_CODE = 400

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initViews()
    }
    private fun initViews(){
        btnStats.setOnClickListener {view->
            val intent = Intent(this, StatsActivity::class.java)
            startActivityForResult(intent,
                GAMESTATS_REQUEST_CODE
            )
        }
    }
}
