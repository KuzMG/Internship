package com.example.course.adapter.holder

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.core.database.entity.course.CourseEntity
import com.example.course.R
import com.example.course.databinding.CourseListItemBinding
import java.text.SimpleDateFormat

class CourseViewHolder(
    private val binding: CourseListItemBinding,
    private val simpleDateFormat: SimpleDateFormat,
    private val clickHasLike: (course: CourseEntity) -> Unit,

    ) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: CourseEntity) {
        binding.apply {
            titleTextView.text = item.title
            textTextView.text = item.text
            priceTextView.text = root.context.getString(R.string.price, item.price)
            rateTextView.text = item.rate
            startDateTextView.text = simpleDateFormat.format(item.startDate)
            favoritesButton.setImageDrawable(
                ContextCompat.getDrawable(
                    root.context,
                    when (item.hasLike) {
                        true -> R.drawable.ic_favorites_16_fill
                        false -> R.drawable.ic_favorites_16

                    }
                )
            )
            favoritesButton.setOnClickListener {
                clickHasLike.invoke(item)
            }
        }
    }
}