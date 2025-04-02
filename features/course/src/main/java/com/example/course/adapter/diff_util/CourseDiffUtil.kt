package com.example.course.adapter.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.core.database.entity.course.CourseEntity

class CourseDiffUtil: DiffUtil.ItemCallback<CourseEntity>() {
    override fun areItemsTheSame(oldItem: CourseEntity, newItem: CourseEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CourseEntity, newItem: CourseEntity): Boolean {
        return oldItem == newItem
    }
}