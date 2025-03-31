package com.example.internship2025.ui

import android.app.Application
import com.example.internship2025.di.AppComponent
import com.example.internship2025.di.DaggerAppComponent

class InternshipApp: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }
}