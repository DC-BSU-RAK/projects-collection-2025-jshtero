package com.example.multipageflowershop

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainPage : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val cart = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)
        setContentView(R.layout.activity_mainpage)

        findViewById<ImageView>(R.id.flower1).setOnClickListener {
            cart.add("Floral Arrangement 1")
            Toast.makeText(this, "Added Floral Arrangement 1 to cart", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.flower2).setOnClickListener {
            cart.add("Floral Arrangement 2")
            Toast.makeText(this, "Added Floral Arrangement 2", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.flower3).setOnClickListener {
            cart.add("Floral Arrangement 3")
            Toast.makeText(this, "Added Floral Arrangement 3", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.flower4).setOnClickListener {
            cart.add("Floral Arrangement 4")
            Toast.makeText(this, "Added Floral Arrangement 4", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.flower5).setOnClickListener {
            cart.add("Floral Arrangement 5")
            Toast.makeText(this, "Added Floral Arrangement 5", Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.flower6).setOnClickListener {
            cart.add("Floral Arrangement 6")
            Toast.makeText(this, "Added Floral Arrangement 6", Toast.LENGTH_SHORT).show()
        }

        val logoutBtn = findViewById<Button>(R.id.logoutbutton)
        logoutBtn.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }

        val cartBtn = findViewById<Button>(R.id.viewcart)
        cartBtn.setOnClickListener {
            val intent = Intent(this, CartPage::class.java)
            intent.putStringArrayListExtra("cartItems", ArrayList(cart))
            startActivity(intent)
        }
    }
}
