package com.example.sprint21.data.model

import com.google.gson.annotations.SerializedName

data class TrackApiResponseModel(
    val data: List<TrackApiModel>
)

data class TrackApiModel(
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    val name: String,
    val artist: String
)

fun TrackApiModel.toTrackModel() = TrackModel(id, imageUrl, name, artist)

