package com.example.sprint21.data.repositories

import com.example.sprint21.App
import com.example.sprint21.data.database.TracksDatabase
import com.example.sprint21.data.model.toListDomainModel
import com.example.sprint21.data.model.toTrackModel
import com.example.sprint21.domain.model.Track
import com.example.sprint21.domain.repositories.TracksRepository

class TracksRepositoryImpl(private val database: TracksDatabase) : TracksRepository {

    override suspend fun getTracks(): List<Track> {

        val result = App.serviceApi.getTracks()
        if (result.isSuccessful) {
            result.body()?.let { response ->
                database.trackDao().insertAll(response.data.map { it.toTrackModel() })
            }
        }

        return toListDomainModel(database.trackDao().getTracksAll())
    }
}