package com.example.multipageflowershop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class artificialsplashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artificialsplashscreen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }, 3000) // 3 seconds delay
    }
}
