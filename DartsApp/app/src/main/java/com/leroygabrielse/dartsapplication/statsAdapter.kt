package com.leroygabrielse.dartsapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.stats_items.view.*

class StatsAdapter(private val stats: List<Stats>): RecyclerView.Adapter<StatsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(stats: Stats){
            itemView.textView11.text = "Leg: 1"
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.stats_items, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return stats.size
    }

    override fun onBindViewHolder(holder: StatsAdapter.ViewHolder, position: Int) {
        holder.bind(stats[position])
    }
}