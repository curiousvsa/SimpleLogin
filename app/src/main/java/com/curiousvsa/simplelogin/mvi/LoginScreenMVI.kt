package com.curiousvsa.patterns.mvi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.curiousvsa.patterns.mvi.model.LoginViewState
import com.curiousvsa.patterns.mvi.viewModel.LoginViewModel
import com.curiousvsa.simplelogin.R

class LoginScreenMVI : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etUsername = findViewById<TextView>(R.id.etUsername)
        val etPassword = findViewById<TextView>(R.id.etPassword)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            viewModel.processIntent(username, password)
        }

        viewModel.viewState.observe(this, Observer { state ->
            when (state) {
                is LoginViewState.Initial -> {
                }

                is LoginViewState.Loading -> {
                }

                is LoginViewState.Success -> {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    finish()
                }

                is LoginViewState.Error -> {
                    Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }
}
