package com.example.course.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core.database.entity.course.CourseEntity
import com.example.course.adapter.diff_util.CourseDiffUtil
import com.example.course.adapter.holder.CourseViewHolder
import com.example.course.databinding.CourseListItemBinding
import java.text.SimpleDateFormat


class CourseAdapter(private val clickHasLike: (course: CourseEntity) -> Unit) :
    ListAdapter<CourseEntity, CourseViewHolder>(CourseDiffUtil()) {
    private val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CourseViewHolder(
            CourseListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            simpleDateFormat,
            clickHasLike
        )


    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}
