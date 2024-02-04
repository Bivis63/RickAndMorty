package com.example.rickandmorty.presentation.characters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.domain.models.Characters
import com.squareup.picasso.Picasso

class CharactersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(view)

    fun bind (characters: Characters) = with(binding){
        val imageUrl =characters.image
        characterName.text =characters.name
        specie.text = characters.specie

        Picasso.get().load(imageUrl).into(iconCharacter)
    }


}