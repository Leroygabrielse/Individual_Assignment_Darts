package com.leroygabrielse.dartsapplication

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

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
            
        }
    }
}