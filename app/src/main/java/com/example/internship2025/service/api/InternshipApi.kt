package com.example.internship2025.service.api

import com.example.internship2025.service.dto.response.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface InternshipApi {

    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(@Path("id") id: String): Response<CoursesResponse>


    companion object {
        val URL =
            "https://drive.usercontent.google.com/"
    }
}