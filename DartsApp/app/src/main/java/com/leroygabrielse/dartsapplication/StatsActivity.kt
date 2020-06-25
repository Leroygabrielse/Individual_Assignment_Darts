package com.leroygabrielse.dartsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_stats.*
import kotlinx.android.synthetic.main.activity_stats_basic.*

class StatsActivity : AppCompatActivity() {

    private val stats = arrayListOf<Stats>()
    private val statsAdapter = StatsAdapter(stats)

    private val viewModel: StatsActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Game Stats"
        setContentView(R.layout.activity_stats_basic)
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        initViews()
        observeViewModel()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
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
