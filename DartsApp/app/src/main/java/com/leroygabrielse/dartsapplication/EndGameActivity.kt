package com.leroygabrielse.dartsapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_end_game.*
import kotlinx.android.synthetic.main.activity_stats.*
import java.time.LocalDate

class EndGameActivity : AppCompatActivity() {

    private val stats = arrayListOf<EndGameStats>()
    private val statsAdapter = EndGameAdapter(stats)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        initViews()
        getData()
    }
    private fun initViews(){
        rvMatchStats.layoutManager = LinearLayoutManager(this@EndGameActivity, RecyclerView.VERTICAL, false)
        rvMatchStats.adapter = statsAdapter

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getData(){
        val bundle: Bundle? = intent.extras
        bundle?.let{
            bundle.apply {
                val endGameStats: EndGameStats? = getParcelable("EXTRA_ENDGAME")
                if (endGameStats != null){
                    stats.add(EndGameStats("${endGameStats.winner}", "${endGameStats.matchName}", "${endGameStats.contestants}",
                        LocalDate.now()))
                    statsAdapter.notifyDataSetChanged()
                }
            }
    }
}}
