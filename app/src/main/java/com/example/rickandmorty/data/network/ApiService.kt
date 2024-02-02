package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.dto.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterDto

}