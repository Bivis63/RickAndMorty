package com.example.rickandmorty.data.dto

import com.example.rickandmorty.domain.models.Location
import com.example.rickandmorty.domain.models.Origin

data class CharacterDto (
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
