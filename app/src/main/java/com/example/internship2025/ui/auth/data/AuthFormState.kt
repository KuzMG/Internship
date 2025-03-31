package com.example.internship2025.ui.auth.data

import androidx.annotation.StringRes

data class AuthFormState(
    @StringRes
    val emailError: Int? = null,
    val isContinue: Boolean = false
)
