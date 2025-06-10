package com.ahorr.chiptest.domain.repository

import com.ahorr.chiptest.data.remote.DogsAPI
import com.ahorr.chiptest.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogInfoRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(DogsAPI::class.java)

    suspend fun getDogBreeds(): List<String> {
        return try {
            val response = apiService.getAllBreeds()
            if (response.isSuccessful) {
                var keys = response.body()?.message?.keys?.toList() ?: emptyList()
                keys.forEach { }
                return keys
            } else {
                listOf(Constants.ERROR)
            }
        } catch (e: Exception) {
            listOf(Constants.ERROR)
        }
    }

    suspend fun getBreedImage(breedName: String): String {
        return try {
            val response = apiService.getBreedImage(breedName)
            if (response.isSuccessful) {
                return response.body()?.message.toString()
            } else {
                return Constants.ERROR
            }
        } catch (e: Exception) {
            return Constants.ERROR
        }

    }
}