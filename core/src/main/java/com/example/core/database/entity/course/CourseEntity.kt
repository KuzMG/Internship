package com.example.core.database.entity.course

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import com.example.core.extensions.toDate
import com.example.core.service.dto.model.Course
import java.util.Date

@Entity("course", primaryKeys = ["id"])
data class CourseEntity(
    @ColumnInfo()
    val id: Int,
    @ColumnInfo()
    val title: String,
    @ColumnInfo()
    val text: String,
    @ColumnInfo()
    val price: String,
    @ColumnInfo()
    val rate: String,
    @ColumnInfo()
    val startDateLong: Long,
    @ColumnInfo()
    val hasLike: Boolean,
    @ColumnInfo()
    val publishDateLong: Long
) {
    @Ignore
    val startDate = Date(startDateLong)

    @Ignore
    val publishDate = Date(publishDateLong)

    companion object {
        fun toCourseEntity(course: Course) =
            CourseEntity(
                course.id,
                course.title,
                course.text,
                course.price,
                course.rate,
                course.startDate.toDate("yyyy-mm-dd").time,
                course.hasLike,
                course.publishDate.toDate("yyyy-mm-dd").time
            )

    }
}
