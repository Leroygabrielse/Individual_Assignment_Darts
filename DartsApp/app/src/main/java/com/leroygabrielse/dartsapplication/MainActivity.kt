package com.leroygabrielse.dartsapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

const val PREGAME_REQUEST_CODE = 100
const val HISTORY_REQUEST_CODE = 200

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

        }
        btnLegs.setOnClickListener {
            etNumberOfLegs.setHint("Number of Legs")
        }
        btnBestof.setOnClickListener {

        }
        btnFirstTo.setOnClickListener {

        }
        btnStart.setOnClickListener { view ->
            val intent = Intent(this, PreGameActivity::class.java)
            startActivityForResult(intent,
                PREGAME_REQUEST_CODE
            )
        }
        fabHistory.setOnClickListener {
                view ->
            val intent = Intent(this, HistoryActivity::class.java)
            startActivityForResult(intent,
                HISTORY_REQUEST_CODE
            )
        }
    }
}