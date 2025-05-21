package com.example.multipageflowershop

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginPage : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)

        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            startActivity(Intent(this, MainPage::class.java))
            finish()
        }

        setContentView(R.layout.activity_loginpage)

        val usernameInput = findViewById<EditText>(R.id.usernameinput)
        val passwordInput = findViewById<EditText>(R.id.passwordinput)
        val loginBtn = findViewById<Button>(R.id.loginbutton)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username == "artificialelegance" && password == "flowershop") {
                sharedPreferences.edit().apply {
                    putBoolean("isLoggedIn", true)
                    putString("username", username)
                    apply()
                }
                startActivity(Intent(this, MainPage::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
