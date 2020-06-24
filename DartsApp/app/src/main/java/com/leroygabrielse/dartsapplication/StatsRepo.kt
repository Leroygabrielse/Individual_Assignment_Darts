package com.leroygabrielse.dartsapplication

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StatsRepo (context: Context){
    private var statsDAO: StatsDAO?

    init{
        val statsRoomDatabase = StatsRoomDatabase.getDatabase(context)
        statsDAO = statsRoomDatabase?.statsDao()
    }

    fun getAllStats(): LiveData<List<Stats>>{
        return statsDAO?.getAllStats() ?: MutableLiveData(emptyList())
    }

    suspend fun insertStats(stats: Stats){
        statsDAO?.insertStats(stats)
    }
    suspend fun deleteAllStats() = statsDAO?.deleteAllGames()
}