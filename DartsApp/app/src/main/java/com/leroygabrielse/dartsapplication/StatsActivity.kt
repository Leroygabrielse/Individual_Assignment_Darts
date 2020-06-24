package com.leroygabrielse.dartsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_stats.*

class StatsActivity : AppCompatActivity() {

    private val stats = arrayListOf<Stats>()
    private val statsAdapter = StatsAdapter(stats)

    private val viewModel: StatsActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        initViews()
        observeViewModel()
    }
    private fun initViews(){
        rvStats.layoutManager = LinearLayoutManager(this@StatsActivity, RecyclerView.VERTICAL, false)
        rvStats.adapter = statsAdapter
    }
    private fun observeViewModel(){
        viewModel.stats.observe(this, Observer {games->
            this@StatsActivity.stats.clear()
            this@StatsActivity.stats.addAll(games)
            statsAdapter.notifyDataSetChanged()
        })
    }




}
