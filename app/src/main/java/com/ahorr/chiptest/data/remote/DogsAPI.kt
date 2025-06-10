package com.ahorr.chiptest.data.remote

import com.ahorr.chiptest.data.remote.dto.BreedImageResponse
import com.ahorr.chiptest.data.remote.dto.DogBreedsResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsAPI {


    @GET("breeds/list/all")
    suspend fun getAllBreeds(): Response<DogBreedsResponse>

    @GET("breed/{breedName}/images/random")
    suspend fun getBreedImage(
        @Path("breedName") breedName: String
    ): Response<BreedImageResponse>


}