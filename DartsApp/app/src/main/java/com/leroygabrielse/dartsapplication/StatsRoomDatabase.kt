package com.leroygabrielse.dartsapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Stats::class], version = 4, exportSchema = false)
abstract class StatsRoomDatabase: RoomDatabase(){
    abstract fun statsDao(): StatsDAO

    companion object {
        private const val DATABASE_NAME = "STATS_DATABASE"

        @Volatile
        private var INSTANCE: StatsRoomDatabase? = null

        fun getDatabase(context: Context): StatsRoomDatabase? {
            if (INSTANCE == null) {
                kotlin.synchronized(StatsRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            StatsRoomDatabase::class.java, DATABASE_NAME
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}