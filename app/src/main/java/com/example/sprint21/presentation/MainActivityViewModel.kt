package com.example.sprint21.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprint21.domain.model.Track
import com.example.sprint21.domain.usecase.GetTracksUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel(
    private val getTracksUseCase: GetTracksUseCase
) : ViewModel() {
    val tracksData = MutableLiveData<List<Track>>()

    fun getTracks() {
        viewModelScope.launch {
            tracksData.postValue(getTracksUseCase())
        }
    }
}