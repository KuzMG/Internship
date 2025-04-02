package com.example.ui.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

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

fun Context.startActivityBrowser(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

}

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}