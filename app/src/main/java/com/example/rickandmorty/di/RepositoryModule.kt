package com.example.rickandmorty.di

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repository.CharacterRepositoryImpl
import com.example.rickandmorty.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl):CharacterRepository
}