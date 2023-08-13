package com.example.sprint21.domain.usecase

import com.example.sprint21.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetTracksUseCase {
    suspend operator fun invoke() =
        withContext(Dispatchers.Default) {
            App.tracksRepository.getTracks()
        }
}