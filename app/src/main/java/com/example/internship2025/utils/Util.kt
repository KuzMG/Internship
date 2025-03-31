package com.example.internship2025.utils

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.internship2025.di.AppComponent
import com.example.internship2025.ui.InternshipApp


val Context.appComponent: AppComponent
    get() = when (this) {
        is InternshipApp -> appComponent
        else -> applicationContext.appComponent
    }

val Fragment.appComponent: AppComponent
    get() = context!!.appComponent
