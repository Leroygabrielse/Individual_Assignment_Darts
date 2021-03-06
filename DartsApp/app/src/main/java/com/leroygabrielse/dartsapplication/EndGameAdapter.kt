package com.leroygabrielse.dartsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_game.view.*
import kotlinx.android.synthetic.main.stats_item.view.*

class EndGameAdapter(private val stats: ArrayList<EndGameStats>) : RecyclerView.Adapter<EndGameAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(stats: EndGameStats){
            itemView.tvWinner.text = "Winner: "+ stats.winner
            itemView.tvMatchName.text = stats.matchName
            itemView.tvContestants.text = stats.contestants
            itemView.tvDate.text = stats.date.toString()
            itemView.tvResult.text = stats.result
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stats_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = stats.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stats[position])
    }
}
