package com.example.internship2025.ui

import android.app.Application
import com.example.core.di.CoreComponent
import com.example.core.di.DaggerCoreComponent
import com.example.internship2025.di.AppComponent
import com.example.internship2025.di.DaggerAppComponent

class InternshipApp: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).coreComponent(coreComponent).build()
    }

     val coreComponent: CoreComponent by lazy {
         DaggerCoreComponent.builder().application(this).build()
     }
}