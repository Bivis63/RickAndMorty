package com.example.rickandmorty.presentation.characters

import com.example.rickandmorty.domain.models.Characters

data class CharactersState(
    val characters: List<Characters> = emptyList(),
    val isLoading: Boolean = false
)