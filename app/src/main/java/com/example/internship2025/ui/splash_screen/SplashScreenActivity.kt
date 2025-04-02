package com.example.internship2025.ui.splash_screen

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.internship2025.extensions.appComponent
import com.example.internship2025.ui.main_screen.MainScreenActivity
import com.example.internship2025.ui.onboarding.OnboardingActivity
import com.example.ui.extensions.startActivityNewTask

class SplashScreenActivity : AppCompatActivity() {
    private val viewModel: SplashScreenViewModel by viewModels {
        appComponent.multiViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (viewModel.isFirstStart) {
            startActivityNewTask<OnboardingActivity>()
        } else {
            startActivityNewTask<MainScreenActivity>()
        }
    }


}