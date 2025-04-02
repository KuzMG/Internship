package com.example.core.service.dto.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity("course")
data class Course(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("rate")
    val rate: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("hasLike")
    val hasLike: Boolean,
    @SerializedName("publishDate")
    val publishDate: String
)
