package com.example.sprint21

import android.app.Application
import com.example.sprint21.data.repositories.TracksRepositoryImpl
import com.example.sprint21.data.api.TracksApi
import com.example.sprint21.data.database.TracksDatabase
import com.example.sprint21.domain.repositories.TracksRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        database = TracksDatabase.getInstance(applicationContext)
        tracksRepository = TracksRepositoryImpl(database)
        initService()
    }

    private fun initService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/MiWas13/ResultsJSON/")
            .client(createDefaultOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        serviceApi = retrofit.create(TracksApi::class.java)
    }

    private fun createDefaultOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

    companion object {

        lateinit var database: TracksDatabase
            private set

        lateinit var tracksRepository: TracksRepository
            private set

        lateinit var serviceApi: TracksApi
            private set
    }
}