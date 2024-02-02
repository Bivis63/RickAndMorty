package com.example.rickandmorty.domain.api

import com.example.rickandmorty.domain.models.Character

interface CharacterRepository {
    fun getAllCharacter(): List<Character>
}