package com.example.core.service.api

import com.example.core.service.dto.response.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET

interface InternshipApi {

    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(): Response<CoursesResponse>


    companion object {
        val URL =
            "https://drive.usercontent.google.com/"
    }
}