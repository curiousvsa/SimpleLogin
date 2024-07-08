package com.curiousvsa.patterns.mvi.model

sealed class LoginViewState {
    object Initial : LoginViewState()
    object Loading : LoginViewState()
    data class Success(val message: String) : LoginViewState()
    data class Error(val error: String) : LoginViewState()
}
