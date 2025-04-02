package com.example.internship2025.ui.auth

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.core.repository.data.Status
import com.example.internship2025.databinding.ActivityAuthBinding
import com.example.internship2025.extensions.appComponent
import com.example.internship2025.ui.main_screen.MainScreenActivity
import com.example.ui.extensions.isVisible
import com.example.ui.extensions.showToast
import com.example.ui.extensions.startActivity
import com.example.ui.extensions.startActivityBrowser
import com.example.ui.input_filter.InputFilterCyrillic
import com.example.ui.text_watcher.TextWatcher


class AuthActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModels {
        appComponent.multiViewModelFactory
    }
    private lateinit var binding: ActivityAuthBinding

    private val textWatcher = object : TextWatcher() {
        override fun textChanged(text: String) {
            viewModel.check(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            emailEditText.setText(viewModel.email)
            passwordEditText.setText(viewModel.password)
            emailEditText.filters = arrayOf(InputFilterCyrillic())
        }
        viewModel.run {
            authFormState.observe(this@AuthActivity) { state ->
                state ?: return@observe
                binding.enterButton.isEnabled = state.isContinue
                state.emailError?.let {
                    binding.emailEditText.error = getString(it)
                }
            }
            authResult.observe(this@AuthActivity) {
                val result = it.getOrDefault(Status.ERROR)
                binding.run {
                    enterButton.isVisible(result == Status.OK || result == Status.ERROR)
                    progressBar.isVisible(result == Status.LOADING)
                }
                it.exceptionOrNull()?.let { e ->
                    showToast(e.message.toString())
                }
                if (result == Status.OK) {
                    startActivity<MainScreenActivity>()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        binding.run {
            emailEditText.addTextChangedListener(textWatcher)
            passwordEditText.addTextChangedListener(textWatcher)
            enterButton.setOnClickListener {
                viewModel.auth()
            }
            vkButton.setOnClickListener {
                startActivityBrowser("https://vk.com/")
            }
            okButton.setOnClickListener {
                startActivityBrowser("https://ok.ru/")
            }
        }

    }
}
