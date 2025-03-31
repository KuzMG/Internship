package com.example.internship2025.ui.auth

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internship2025.R
import com.example.internship2025.repository.InternshipRepository
import com.example.internship2025.ui.auth.data.AuthFormState
import com.example.internship2025.ui.auth.data.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val repository: InternshipRepository) : ViewModel() {
    var email: String = ""
    var password: String = ""

    private val _authFormState = MutableLiveData<AuthFormState?>()
    val authFormState: LiveData<AuthFormState?> = _authFormState

    private val _authResult = MutableLiveData<Result<Status>?>()
    val authResult: LiveData<Result<Status>?> = _authResult

    fun check(_email: String, _password: String) {
        email = _email
        password = _password

        _authFormState.value = if (!isEmailValid(email)) {
            when (email.isEmpty()) {
                true -> AuthFormState()
                false -> AuthFormState(emailError = R.string.auth_registration_error_email)
            }
        } else if (password.isEmpty()) {
            AuthFormState()
        } else {
            AuthFormState(isContinue = true)
        }
    }

    private fun isEmailValid(email: String) =
        if (email.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            false
        }

    fun auth() {
        _authResult.value = Result.success(Status.LOADING)
        viewModelScope.launch(Dispatchers.IO) {
            _authResult.postValue(repository.auth(email,password))
        }
    }

}