package com.curiousvsa.patterns.mvvm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.curiousvsa.patterns.mvvm.data.viewModels.LoginViewModel
import com.curiousvsa.simplelogin.R

class LoginScreenMVVM : AppCompatActivity() {

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
            viewModel.login(username, password)
        }

        viewModel.loginResult.observe(this, Observer { success ->
            if (success) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()

            }
        })
    }
}

