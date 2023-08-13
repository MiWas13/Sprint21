package com.example.sprint21.domain.repositories

import com.example.sprint21.domain.model.Track

interface TracksRepository {
    suspend fun getTracks(): List<Track>
}