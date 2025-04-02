package com.example.internship2025.ui.main_screen.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.course.adapter.CourseAdapter
import com.example.internship2025.databinding.FragmentFavoritesBinding
import com.example.internship2025.extensions.appComponent

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel: FavoritesViewModel by viewModels {
        appComponent.multiViewModelFactory
    }
    private val adapter = CourseAdapter { course ->
        viewModel.hasLike(course.id, !course.hasLike)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFavorites().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

}