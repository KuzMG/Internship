package com.example.internship2025.ui.main_screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.core.repository.InternshipRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: InternshipRepository) :
    ViewModel() {
    fun hasLike(id: Int, hasLike: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.hasLike(id, hasLike)
        }
    }

    var sort: Boolean = false
        set(value) {
            field = value
            sortLiveData.value = value
        }
    private val sortLiveData = MutableLiveData<Boolean>()

    val errorLiveData: LiveData<Result<Boolean>>
        get() = _errorLiveData
    private val _errorLiveData = MutableLiveData<Result<Boolean>>()

    fun getCourses() = sortLiveData.switchMap {
        when (it) {
            true -> repository.getCoursesSort()
            false -> repository.getCourses()
        }
    }

    init {
        sort = false
        viewModelScope.launch(Dispatchers.IO) {
            _errorLiveData.postValue(repository.saveCourses())
        }
    }


}