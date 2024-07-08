package com.curiousvsa.patterns.mvvm.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    fun login(username: String, password: String) {
        val isValid = isValidCredentials(username, password)
        _loginResult.value = isValid
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        // Replace with your actual validation logic
        return username == "admin" && password == "password"
    }
}

