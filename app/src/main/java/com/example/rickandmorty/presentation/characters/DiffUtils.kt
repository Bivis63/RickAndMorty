package com.example.rickandmorty.presentation.characters

import androidx.recyclerview.widget.DiffUtil
import com.example.rickandmorty.domain.models.Characters

class DiffUtils(
    private val oldList: List<Characters>,
    private val newList: List<Characters>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCharacter = oldList[oldItemPosition]
        val newCharacter = newList[newItemPosition]
        return oldCharacter.id == newCharacter.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCharacter = oldList[oldItemPosition]
        val newCharacter = newList[newItemPosition]
        return oldCharacter == newCharacter
    }
}