package com.example.rickandmorty.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rickandmorty.data.network.RetrofitNetworkClient
import com.example.rickandmorty.databinding.FragmentCharacterDetailsBinding
import com.example.rickandmorty.domain.models.Character
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding get() = _binding!!

    private var retrofitNetworkClient = RetrofitNetworkClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getCharacterButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val character = retrofitNetworkClient.RickAndMortyService.getCharacter(
                    getRandomIdCharacter()
                )
                requireActivity().runOnUiThread() {
                   showCharacter(character)
                }
            }
        }


    }

    private fun getRandomIdCharacter():Int{
        return Random.nextInt(1,101)
    }

    private fun showCharacter(character: Character){
        val imageUrl = character.image
        Picasso.get().load(imageUrl).into(binding.imageView)
        binding.location.text = "Location: ${character.location.name}"
        binding.name.text = "Name:  ${character.name}"
        binding.species.text = "Species: ${character.species}"
        binding.status.text = "status:  ${character.status}"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}