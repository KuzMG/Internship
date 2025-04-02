package com.example.core.repository

import com.example.core.database.entity.course.CourseDao
import com.example.core.database.entity.course.CourseEntity
import com.example.core.repository.data.Status
import com.example.core.service.api.InternshipApi
import javax.inject.Inject


class InternshipRepository @Inject constructor(
    private val internshipApi: InternshipApi,
    private val queryPreferences: QueryPreferences,
    private val courseDao: CourseDao
) {
    fun auth(email: String, password: String): Result<Status> {
        queryPreferences.isFirstStart = false
        return Result.success(Status.OK)
    }

    suspend fun saveCourses() = try {
        val response = internshipApi.getCourses()
        if (response.code() == 200) {
            val courses = response.body()!!.courses
            val courseEntity = courses.map {
                CourseEntity.toCourseEntity(it)
            }
            courseDao.insert(courseEntity)
            Result.success(true)
        } else {
            val code = response.code().toString()
            val error = response.errorBody()?.string() ?: ""
            Result.failure(Exception("$code $error"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    fun getCourses() = courseDao.get()
    fun getCoursesSort() = courseDao.getSort()

    fun hasLike(id: Int, hasLike: Boolean) {
        courseDao.hasLike(id, hasLike)
    }

    fun getFavorites() = courseDao.getFavorites()

}