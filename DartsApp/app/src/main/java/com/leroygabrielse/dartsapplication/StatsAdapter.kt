package com.leroygabrielse.dartsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.stats_items.view.*

class StatsAdapter (private val stats: List<Stats>) : RecyclerView.Adapter<StatsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(stats: Stats) {
            itemView.tvlegNumber.text = stats.legNumber.toString()
            itemView.tvWinner.text = stats.winner
            itemView.tvAvgP1.text = stats.avgp1.toString()
            itemView.tvAvgP2.text = stats.avgp2.toString()
            itemView.tvThrownP1.text = stats.thrownp1.toString()
            itemView.tvThrownP2.text =stats.thrownp2.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stats_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = stats.size

    override fun onBindViewHolder(holder: StatsAdapter.ViewHolder, position: Int) {
        return holder.bind(stats[position])
    }

}