package com.example.ui.text_watcher

import android.text.Editable
import android.text.TextWatcher

abstract class TextWatcher : TextWatcher {
    abstract fun textChanged(text: String)
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        textChanged(p0.toString())
    }

    override fun afterTextChanged(p0: Editable?) {
    }
}