package com.example.internship2025.ui.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.internship2025.databinding.ActivityOnboardingBinding
import com.example.internship2025.ui.auth.AuthActivity
import com.example.internship2025.utils.startActivity

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continueButton.setOnClickListener {
            startActivity<AuthActivity>()
        }
    }
}