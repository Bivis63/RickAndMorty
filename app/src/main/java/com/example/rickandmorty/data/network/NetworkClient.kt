package com.example.rickandmorty.data.network


import com.example.rickandmorty.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response
}