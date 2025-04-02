package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.database.entity.course.CourseDao
import com.example.core.database.entity.course.CourseEntity

@Database(
    version = 1,
    entities = [CourseEntity::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao

    companion object {
        const val DATABASE_NAME = "DB"
    }
}