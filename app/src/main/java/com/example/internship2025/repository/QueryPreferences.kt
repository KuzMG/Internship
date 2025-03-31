package com.example.internship2025.repository

import android.app.Application
import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

class QueryPreferences @Inject constructor(app: Application) {
    companion object{
        const val PREF_NAME = "CONFIG"
        const val PREF_IS_FIRST_START = "IS_FIRST_START"
    }
    private val prefs = app.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var isFirstStart: Boolean
        get() = prefs.getBoolean(PREF_IS_FIRST_START,true)
        set(value) = prefs.edit {
            putBoolean(PREF_IS_FIRST_START,value)
        }
}