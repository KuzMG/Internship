package com.example.core.di.module

import android.app.Application
import androidx.room.Room
import com.example.core.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {
    @Singleton
    @Provides
    fun getDB(app: Application) =
        Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun getCourseDao(db: AppDatabase) = db.courseDao()

}