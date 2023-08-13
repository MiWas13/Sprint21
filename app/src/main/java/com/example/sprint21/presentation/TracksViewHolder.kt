package com.example.sprint21.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sprint21.R
import com.example.sprint21.domain.model.Track

class TracksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image: ImageView = itemView.findViewById(R.id.imageView)
    private val name: TextView = itemView.findViewById(R.id.name)
    private val artist: TextView = itemView.findViewById(R.id.artist)

    fun bind(track: Track) {
        name.text = track.name
        artist.text = track.artist
        Glide
            .with(itemView)
            .load(track.imageUrl)
            .centerCrop()
            .into(image)
    }
}