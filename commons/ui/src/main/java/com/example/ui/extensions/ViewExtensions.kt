package com.example.ui.extensions

import android.view.View

fun View.isVisible(flag: Boolean) {
    visibility = if (flag) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}