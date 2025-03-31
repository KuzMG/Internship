package com.example.internship2025.ui.auth

import android.R.attr.end
import android.R.attr.start
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.internship2025.databinding.ActivityAuthBinding
import com.example.internship2025.ui.auth.data.Status
import com.example.internship2025.ui.main_screen.MainScreenActivity
import com.example.internship2025.ui.util.TextWatcher
import com.example.internship2025.utils.appComponent
import com.example.internship2025.utils.startActivity


class AuthActivity : AppCompatActivity() {

    private val viewModel: AuthViewModel by viewModels {
        appComponent.multiViewModelFactory
    }
    private lateinit var binding: ActivityAuthBinding

    val textWatcher = object : TextWatcher() {
        override fun textChanged(text: String) {
            viewModel.check(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }
    val inputFilter = InputFilter { chs, start, end, _, _, _ ->
        val input: String = chs.subSequence(start, end).toString()
        return@InputFilter if (input.matches(".*[\\p{IsCyrillic}].*".toRegex())) {
            ""
        } else null

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.run {
            emailEditText.setText(viewModel.email)
            passwordEditText.setText(viewModel.password)
            emailEditText.filters = arrayOf(inputFilter)
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
                it ?: return@observe
                val result = it.getOrDefault(Status.ERROR)
                binding.run {
                    enterButton.visibility =
                        isVisible(result == Status.OK || result == Status.ERROR)
                    progressBar.visibility = isVisible(result == Status.LOADING)
                }
                it.exceptionOrNull()?.let { e ->
                    toast(e.message.toString())
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
        }

    }

    private fun isVisible(flag: Boolean) = if (flag) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


}
