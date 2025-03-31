package com.example.internship2025.service.dto.model

import com.google.gson.annotations.SerializedName
import java.util.Date


data class Course(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("startDate")
    val startDate: Date,
    @SerializedName("hasLike")
    val hasLike: Boolean,
    @SerializedName("publishDate")
    val publishDate: Date
)
