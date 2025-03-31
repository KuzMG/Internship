package com.example.internship2025.repository

import com.example.internship2025.service.api.InternshipApi
import com.example.internship2025.ui.auth.data.Status
import javax.inject.Inject

class InternshipRepository @Inject constructor(private val internshipApi: InternshipApi,
    private val queryPreferences: QueryPreferences) {
    fun auth(email: String, password: String): Result<Status> {
        queryPreferences.isFirstStart = false
        return Result.success(Status.OK)
    }
}