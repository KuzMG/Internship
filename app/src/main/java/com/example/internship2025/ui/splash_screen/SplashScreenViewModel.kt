package com.example.internship2025.ui.splash_screen

import androidx.lifecycle.ViewModel
import com.example.core.repository.QueryPreferences
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(private val queryPreferences: QueryPreferences) :
    ViewModel() {

    val isFirstStart: Boolean
        get() = queryPreferences.isFirstStart

}