package com.leroygabrielse.dartsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_stats.*

class StatsActivity : AppCompatActivity() {

    private val stats = arrayListOf<Stats>()
    private val statsAdapter = StatsAdapter(stats)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        initViews()
    }
    private fun initViews(){
        rvStats.layoutManager = LinearLayoutManager(this@StatsActivity, RecyclerView.VERTICAL, false)
        rvStats.adapter = statsAdapter
    }
}
