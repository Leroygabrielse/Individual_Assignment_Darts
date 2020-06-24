package com.leroygabrielse.dartsapplication

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StatsDAO {
    @Query("SELECT * FROM statsTable")
    fun getAllStats(): LiveData<List<Stats>>

    @Insert
    suspend fun insertStats(stats: Stats)

    @Query("DELETE FROM statsTable")
    suspend fun deleteAllGames()
}