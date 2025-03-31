package com.example.internship2025.ui.splash_screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.internship2025.ui.main_screen.MainScreenActivity
import com.example.internship2025.ui.onboarding.OnboardingActivity
import com.example.internship2025.utils.appComponent

class SplashScreenActivity : AppCompatActivity() {
    private val viewModel: SplashScreenViewModel by viewModels {
        appComponent.multiViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (viewModel.isFirstStart) {
            startActivity<OnboardingActivity>()
        } else {
            startActivity<MainScreenActivity>()
        }
    }

    private inline fun <reified T : Activity> startActivity() {
        startActivity(
            Intent(this, T::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        )
    }
}