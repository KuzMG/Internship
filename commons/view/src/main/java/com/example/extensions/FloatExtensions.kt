package com.example.extensions

import android.content.Context
import android.util.TypedValue


fun Float.spToPx(context: Context) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    this,
    context.resources.displayMetrics
)

fun Float.dpToPx(context: Context)= TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        context.resources.displayMetrics
    )
