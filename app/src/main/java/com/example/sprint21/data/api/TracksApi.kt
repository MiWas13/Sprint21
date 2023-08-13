package com.example.sprint21.data.api

import com.example.sprint21.data.model.TrackApiResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface TracksApi {

    @GET("master/sprint_21")
    suspend fun getTracks(): Response<TrackApiResponseModel>
}