package com.example.internship2025.ui.main_screen.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.repository.InternshipRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesViewModel  @Inject constructor(private val repository: InternshipRepository): ViewModel() {

    fun getFavorites()= repository.getFavorites()

    fun hasLike(id:Int,hasLike: Boolean) {
        viewModelScope.launch(Dispatchers.IO){
            repository.hasLike(id,hasLike)
        }
    }
}