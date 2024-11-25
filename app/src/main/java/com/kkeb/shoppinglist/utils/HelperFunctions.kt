package com.kkeb.shoppinglist.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getFormattedDateTime(dt: Long, pattern: String = "EEE, dd MMM yyyy"): String {
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    return sdf.format(Date(dt))
}