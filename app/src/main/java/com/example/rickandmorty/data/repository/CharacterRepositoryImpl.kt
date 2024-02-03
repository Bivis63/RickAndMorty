package com.example.rickandmorty.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.rickandmorty.data.Result
import com.example.rickandmorty.data.dto.toCharacter
import com.example.rickandmorty.data.network.ApiService
import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.domain.models.Characters
import com.example.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: ApiService
) : CharacterRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun getAllCharacters(): Flow<Result<List<Characters>>> = flow {
        emit(Result.Loading())
        try {
            val response = api.getAllCharacters().toCharacter()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(
                Result.Error(
                    message = "Что-то пошло не так",
                    data = null
                )
            )
        } catch (e: IOException) {
            emit(
                Result.Error(
                    message = "Сервер не найден, проверте интернет соединение",
                    data = null
                )
            )
        }
    }


    override suspend fun getCharacter(id: Int): Result<Character> {
        val response = try {
            api.getCharacter(id)
        } catch (e: Exception) {
            return Result.Error(message = "Произошла неизвестная ошибка")
        }
        return Result.Success(response.toCharacter())
    }
}