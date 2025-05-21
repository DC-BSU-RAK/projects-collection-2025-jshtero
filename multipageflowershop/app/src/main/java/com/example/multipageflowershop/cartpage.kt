package com.example.multipageflowershop

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CartPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cartpage)

        val cartItemsTextView = findViewById<TextView>(R.id.cartitems)
        val backButton = findViewById<Button>(R.id.backbutton)

        // Retrieve cart items from intent
        val cartItems = intent.getStringArrayListExtra("cartItems")

        // Display them
        cartItemsTextView.text = if (cartItems != null && cartItems.isNotEmpty()) {
            cartItems.joinToString("\n")
        } else {
            "Your cart is empty."
        }

        // Go back to main page
        backButton.setOnClickListener {
            finish() // closes CartPage and returns to MainPage
        }
    }
}
