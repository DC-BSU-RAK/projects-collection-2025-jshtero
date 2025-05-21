package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var hatView: View
    private lateinit var shirtView: View
    private lateinit var pantsView: View
    private lateinit var styleResult: TextView

    private lateinit var hatButton: Button
    private lateinit var shirtButton: Button
    private lateinit var pantsButton: Button
    private lateinit var stylizeButton: Button
    private lateinit var discoverStyleButton: Button

    private var hatColor: Int = Color.RED
    private var shirtColor: Int = Color.GREEN
    private var pantsColor: Int = Color.BLUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hatView = findViewById(R.id.hatColor)
        shirtView = findViewById(R.id.shirtColor)
        pantsView = findViewById(R.id.pantsColor)
        styleResult = findViewById(R.id.styleResult)

        hatButton = findViewById(R.id.hatButton)
        shirtButton = findViewById(R.id.shirtButton)
        pantsButton = findViewById(R.id.pantsButton)
        stylizeButton = findViewById(R.id.stylizeButton)
        discoverStyleButton = findViewById(R.id.discoverStyleButton)

        hatButton.setOnClickListener {
            hatColor = getRandomColor()
            hatView.setBackgroundColor(hatColor)
        }

        shirtButton.setOnClickListener {
            shirtColor = getRandomColor()
            shirtView.setBackgroundColor(shirtColor)
        }

        pantsButton.setOnClickListener {
            pantsColor = getRandomColor()
            pantsView.setBackgroundColor(pantsColor)
        }

        stylizeButton.setOnClickListener {
            hatColor = getRandomColor()
            shirtColor = getRandomColor()
            pantsColor = getRandomColor()

            hatView.setBackgroundColor(hatColor)
            shirtView.setBackgroundColor(shirtColor)
            pantsView.setBackgroundColor(pantsColor)
        }

        discoverStyleButton.setOnClickListener {
            val style = determineAesthetic(hatColor, shirtColor, pantsColor)
            styleResult.text = "Your aesthetic is: $style"
        }
    }

    private fun getRandomColor(): Int {
        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)
        return Color.rgb(r, g, b)
    }

    private fun getRGB(color: Int): Triple<Int, Int, Int> {
        val r = Color.red(color)
        val g = Color.green(color)
        val b = Color.blue(color)
        return Triple(r, g, b)
    }

    private fun determineAesthetic(c1: Int, c2: Int, c3: Int): String {
        val (r1, g1, b1) = getRGB(c1)
        val (r2, g2, b2) = getRGB(c2)
        val (r3, g3, b3) = getRGB(c3)

        val avgR = (r1 + r2 + r3) / 3
        val avgG = (g1 + g2 + g3) / 3
        val avgB = (b1 + b2 + b3) / 3
        val brightness = (avgR + avgG + avgB) / 3

        return when {
            brightness > 220 -> "Minimalist"
            brightness > 180 && avgR > avgG && avgR > avgB -> "Warm & Vibrant"
            brightness > 180 && avgG > avgR && avgG > avgB -> "Nature Vibes"
            brightness > 180 && avgB > avgR && avgB > avgG -> "Cool & Calm"

            brightness in 130..180 && avgR > avgG && avgB > avgG -> "Modern & Moody"
            brightness in 130..180 && avgR in 130..180 && avgG in 130..180 && avgB in 130..180 -> "Neutral Core"
            brightness in 130..180 && avgR > 150 && avgG > 150 && avgB < 100 -> "Sunset Chic"

            brightness < 80 -> "Dark Academia"
            brightness < 130 && avgB > avgR && avgB > avgG -> "Midnight Cool"
            brightness < 130 && avgR > 150 && avgB > 150 -> "Cyber Pop"
            brightness < 130 && avgG > 160 && avgR < 100 -> "Forest Grunge"

            else -> "Basic Aesthetic."
        }
    }
}
