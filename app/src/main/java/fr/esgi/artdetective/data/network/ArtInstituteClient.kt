package fr.esgi.artdetective.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ArtInstituteClient {
    private const val BASE_URL = "https://api.artic.edu/api/v1/"

    fun create(): ArtInstituteApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ArtInstituteApi::class.java)
}