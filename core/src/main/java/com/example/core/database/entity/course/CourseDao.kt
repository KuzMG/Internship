package com.example.core.database.entity.course

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entities: List<CourseEntity>)

    @Query("select * from course")
    fun get(): LiveData<List<CourseEntity>>

    @Query("select * from course order by startDateLong desc")
    fun getSort(): LiveData<List<CourseEntity>>

    @Query("select count(*) from course")
    fun count(): Int

    @Query("update course set hasLike=:hasLike where id=:id")
    fun hasLike(id: Int, hasLike: Boolean)

    @Query("select * from course where hasLike = 1")
    fun getFavorites(): LiveData<List<CourseEntity>>
}