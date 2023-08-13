package com.example.sprint21.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sprint21.data.model.TrackModel

@Database(entities = [TrackModel::class], version = 1)
abstract class TracksDatabase : RoomDatabase() {

    abstract fun trackDao(): TrackDao

    companion object {
        @Volatile
        private lateinit var instance: TracksDatabase

        fun getInstance(context: Context): TracksDatabase {
            synchronized(this) {
                if (!Companion::instance.isInitialized) {
                    instance = Room.databaseBuilder(
                        context,
                        TracksDatabase::class.java, "get-track-database"
                    ).allowMainThreadQueries().build()
                }
                return instance
            }
        }
    }
}