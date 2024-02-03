package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.domain.models.Character

interface CharacterRepository {
    fun getAllCharacter(): List<Character>
}