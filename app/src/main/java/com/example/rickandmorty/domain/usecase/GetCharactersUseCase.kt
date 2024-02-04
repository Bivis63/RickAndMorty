package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.Result
import com.example.rickandmorty.domain.models.Characters
import com.example.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    operator fun invoke(): Flow<Result<List<Characters>>> {
        return repository.getAllCharacters()
    }
}