package com.example.internship2025.extensions

import androidx.fragment.app.Fragment
import com.example.internship2025.di.AppComponent


val Fragment.appComponent: AppComponent
    get() = context!!.appComponent


