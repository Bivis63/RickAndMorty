package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.data.Result
import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int) : Result<Character>{
      return repository.getCharacter(id)
    }
}