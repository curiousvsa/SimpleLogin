package com.curiousvsa.patterns.mvi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiousvsa.patterns.mvi.model.LoginViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _viewState = MutableLiveData<LoginViewState>()
    val viewState: LiveData<LoginViewState> = _viewState

    fun processIntent(username: String, password: String) {
        viewModelScope.launch {
            _viewState.value = LoginViewState.Loading
            delay(1000)

            if (isValidCredentials(username, password)) {
                _viewState.value = LoginViewState.Success("Login successful")
            } else {
                _viewState.value = LoginViewState.Error("Invalid credentials")
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        return username == "admin" && password == "password"
    }
}

