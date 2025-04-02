package com.example.internship2025.extensions

import android.content.Context
import com.example.internship2025.di.AppComponent
import com.example.internship2025.ui.InternshipApp


val Context.appComponent: AppComponent
    get() = when (this) {
        is InternshipApp -> appComponent
        else -> applicationContext.appComponent
    }




