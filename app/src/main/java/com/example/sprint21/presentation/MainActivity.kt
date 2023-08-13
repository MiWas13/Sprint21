package com.example.sprint21.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint21.R
import com.example.sprint21.domain.usecase.GetTracksUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel = MainActivityViewModel(GetTracksUseCase())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        observeViewModel()

        viewModel.getTracks()
    }


    private fun observeViewModel() {
        viewModel.tracksData.observe(this) {
            recyclerView.adapter = TracksAdapter(it)
        }
    }
}