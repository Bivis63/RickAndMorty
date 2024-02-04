package com.example.rickandmorty.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.domain.models.Characters

class CharactersAdapter : RecyclerView.Adapter<CharactersViewHolder>() {

    var listCharacters = arrayListOf<Characters>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharactersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(listCharacters[position])
    }

    fun setCharacter(newCharacter: List<Characters>) {
        val diffCallback = DiffUtils(listCharacters, newCharacter ?: emptyList())
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        listCharacters.clear()
        if (!newCharacter.isNullOrEmpty()) {
            listCharacters.addAll(newCharacter)
        }
        diffResult.dispatchUpdatesTo(this)
    }
}