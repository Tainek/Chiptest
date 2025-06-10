package com.ahorr.chiptest.data.remote.dto

data class DogBreedsResponse(
    val message: Map<String, List<String>>,
    val status: String
)