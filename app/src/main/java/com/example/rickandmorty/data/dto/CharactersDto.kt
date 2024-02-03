package com.example.rickandmorty.data.dto

import com.example.rickandmorty.domain.models.Characters

data class CharactersDto(
    val info: Info,
    val results: List<Result>
)

fun CharactersDto.toCharacter(): List<Characters> {
    val resultEntries = results.mapIndexed { _, entries ->
        Characters(
            id = entries.id,
            image = entries.image,
            specie = entries.species,
            name = entries.name,
        )
    }
    return resultEntries
}