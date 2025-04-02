package com.example.core.extensions

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.toDate(pattern: String): Date {
    val format: DateFormat = SimpleDateFormat(pattern, Locale.ENGLISH)
    return format.parse(this)?: Date()
}