package com.leroygabrielse.dartsapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class StatsActivityViewModel(application: Application): AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val statsRepo = StatsRepo(application.applicationContext)

    val stats: LiveData<List<Stats>> = statsRepo.getAllStats()
}