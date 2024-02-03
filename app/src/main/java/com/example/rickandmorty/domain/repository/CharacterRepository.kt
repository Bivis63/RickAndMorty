package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.data.Result
import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.domain.models.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<Result<List<Characters>>>

    suspend fun getCharacter(id: Int): Result<Character>
}