package com.example.carddeckapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://deckofcardsapi.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CardApiService{

    @GET("api/deck/new/draw/?count=1")
    suspend fun getCard():String
}

//Singleton

object CardApi{
    val retrofitService: CardApiService by lazy {
        retrofit.create(CardApiService::class.java)
    }
}