package com.example.rickandmorty.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.Result
import com.example.rickandmorty.domain.usecase.GetCharactersUseCase
import com.example.rickandmorty.presentation.characters.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<CharactersState>()
    val uiState: LiveData<CharactersState> = _uiState

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun getCharacters() {
        viewModelScope.launch {
            getCharactersUseCase().onEach { result ->
                when (result) {
                    is Result.Success -> {
                        _uiState.value?.let {
                            val charecter = it.copy(
                                characters = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }

                    is Result.Error -> {
                        _uiState.value?.let {
                            val character = it.copy(
                                isLoading = false
                            )
                            _eventFlow.emit(
                                UIEvent.ShowSnackBar(
                                    result.message ?: "Unknown error"
                                )
                            )
                        }
                    }

                    is Result.Loading -> {
                        _uiState.value?.let {
                            val character =it.copy(
                                isLoading = true
                            )
                        }
                    }
                }
            }.launchIn(this)
        }
    }

    sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
    }


}