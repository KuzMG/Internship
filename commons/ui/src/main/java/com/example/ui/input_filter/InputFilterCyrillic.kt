package com.example.ui.input_filter

import android.text.InputFilter
import android.text.Spanned

class InputFilterCyrillic : InputFilter {
    override fun filter(
        p0: CharSequence,
        p1: Int,
        p2: Int,
        p3: Spanned?,
        p4: Int,
        p5: Int
    ): CharSequence? {
        val input: String = p0.subSequence(p1, p2).toString()
        return if (input.matches(".*[\\p{IsCyrillic}].*".toRegex())) {
            ""
        } else null
    }
}