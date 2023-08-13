package com.example.sprint21.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sprint21.domain.model.Track

@Entity(tableName = "tracks")
data class TrackModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "artist")
    val artist: String,
)

fun TrackModel.toDomainModel() = Track(
    id, imageUrl, name, artist
)

fun toListDomainModel(tracksList: List<TrackModel>) =
    tracksList.map {
        it.toDomainModel()
    }

