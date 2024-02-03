package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.NetworkClient
import com.example.rickandmorty.data.dto.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkClient() : NetworkClient {

    private val RickAndMortyBaseUrl = "https://rickandmortyapi.com/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(RickAndMortyBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val RickAndMortyService = retrofit.create(ApiService::class.java)

    override fun doRequest(dto: Any): Response {
        TODO("Not yet implemented")
    }
}