package com.example.sprint21.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sprint21.data.model.TrackModel

@Dao
interface TrackDao {

    @Query("SELECT * FROM tracks")
    fun getTracksAll(): List<TrackModel>

    @Query("SELECT * FROM tracks WHERE id LIKE :trackId")
    fun getTrackById(trackId: Int): TrackModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tracks: List<TrackModel>)

    @Delete
    fun delete(track: TrackModel)

    @Query("DELETE FROM tracks")
    fun deleteAll()
}
