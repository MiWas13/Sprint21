package com.example.sprint21.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint21.R
import com.example.sprint21.domain.model.Track

class TracksAdapter(
    private val tracksList: List<Track>
) : RecyclerView.Adapter<TracksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.track_item_layout, parent, false)
        return TracksViewHolder(view)
    }

    override fun getItemCount(): Int = tracksList.size

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        holder.bind(tracksList[position])
    }


}