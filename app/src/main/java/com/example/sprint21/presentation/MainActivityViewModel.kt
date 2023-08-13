package com.example.sprint21.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
    private val getTracksUseCase: GetTracksUseCase,
    private val customScope: CloseableCoroutineScope = CloseableCoroutineScope()
) :
    ViewModel(customScope) {
    val tracksData = MutableLiveData<List<Track>>()

    fun getTracks() {
        customScope.launch {
            tracksData.postValue(getTracksUseCase())
        }
    }
}

class CloseableCoroutineScope(
    context: CoroutineContext = SupervisorJob() + Dispatchers.Main.immediate
) : Closeable, CoroutineScope {
    override val coroutineContext: CoroutineContext = context
    override fun close() {
        coroutineContext.cancel()
    }
}