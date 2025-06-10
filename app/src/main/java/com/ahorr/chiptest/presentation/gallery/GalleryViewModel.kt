package com.ahorr.chiptest.presentation.gallery

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahorr.chiptest.domain.repository.DogInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor() : ViewModel() {


    private val _breedImages = mutableStateOf<Array<String>>(emptyArray())
    val breedImages: State<Array<String>> = _breedImages
    private val repository = DogInfoRepository()
    private var breedName = ""


    fun fetchImageURL() {
        viewModelScope.launch {
            val breedimg = repository.getBreedImage(breedName)
            println("Breed image = " + breedimg + "Index")

            if (_breedImages.value.isEmpty()) {
                _breedImages.value = Array<String>(10) { "" }
            } else {
                val newArray = breedImages.value.copyOf()
                for (i in 0..newArray.size - 1) {
                    if (newArray[i] == "") {
                        newArray[i] = breedimg
                        break
                    }
                }
                _breedImages.value = newArray
            }
        }
    }


    fun populateList(breedName: String) {
        this.breedName = breedName
        for (i in 0..9) {
            fetchImageURL()
        }
    }


}