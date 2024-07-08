package com.curiousvsa.patterns

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.curiousvsa.patterns.mvi.LoginScreenMVI
import com.curiousvsa.patterns.mvvm.LoginScreenMVVM
import com.curiousvsa.simplelogin.R


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bt_mvvm = findViewById<Button>(R.id.bt_mvvm)
        val bt_mvi = findViewById<Button>(R.id.bt_mvi)

        bt_mvvm.setOnClickListener {
            openMVVMScreen();
        }
        bt_mvi.setOnClickListener {
            openMVIScreen();
        }
    }

    private fun openMVIScreen() {
        val intent = Intent(this, LoginScreenMVI::class.java)
        startActivity(intent)
    }

    private fun openMVVMScreen() {
        val intent = Intent(this, LoginScreenMVVM::class.java)
        startActivity(intent)
    }
}