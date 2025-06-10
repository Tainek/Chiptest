package com.ahorr.chiptest.domain.repository

import com.ahorr.chiptest.data.remote.DogsAPI
import com.ahorr.chiptest.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val dogsAPI: DogsAPI by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogsAPI::class.java)
    }
}