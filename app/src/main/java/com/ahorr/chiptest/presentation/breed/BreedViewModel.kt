package com.ahorr.chiptest.presentation.breed

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.ahorr.chiptest.domain.repository.DogInfoRepository
import kotlinx.coroutines.launch


@HiltViewModel
class BreedViewModel @Inject constructor() : ViewModel() {
    private val repository = DogInfoRepository()
    private val _breeds = mutableStateOf<List<String>>(emptyList())
    val breeds: State<List<String>> = _breeds


    init {
        fetchBreeds()
    }


    private fun fetchBreeds() {
        viewModelScope.launch {
            _breeds.value = repository.getDogBreeds()
        }
    }


}