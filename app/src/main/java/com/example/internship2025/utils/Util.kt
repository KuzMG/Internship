package com.example.internship2025.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
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

inline fun <reified T : Activity> Context.startActivityNewTask() {
    startActivity(
        Intent(this, T::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    )
}
inline fun <reified T : Activity> Context.startActivity() {
    startActivity(
        Intent(this, T::class.java)
    )
}