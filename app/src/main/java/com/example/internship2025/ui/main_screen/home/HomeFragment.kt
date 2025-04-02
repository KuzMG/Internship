package com.example.internship2025.ui.main_screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.internship2025.databinding.FragmentHomeBinding
import com.example.internship2025.extensions.appComponent
import com.example.course.adapter.CourseAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels {
        appComponent.multiViewModelFactory
    }
    private val adapter = CourseAdapter{ course ->
        viewModel.hasLike(course.id, !course.hasLike)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.errorLiveData.observe(viewLifecycleOwner) { result ->
            result.exceptionOrNull()?.let {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.getCourses().observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
        binding.sortConstraintLayout.setOnClickListener {
            viewModel.sort = !viewModel.sort
        }
    }



}