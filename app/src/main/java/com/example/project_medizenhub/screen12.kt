package com.example.project_medizenhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button

class Screen12 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen12)

        val button = findViewById<Button>(R.id.button5)
        val blinkAnimation = AlphaAnimation(0.0f, 1.0f)
        blinkAnimation.duration = 500 // Duration of the blink
        blinkAnimation.repeatCount = AlphaAnimation.INFINITE // Repeat the animation infinitely
        button.startAnimation(blinkAnimation)

        button.setOnClickListener {
            // Stop the blink animation
            button.clearAnimation()

            // Navigate to Screen16
            val intent = Intent(this, Screen16::class.java)
            startActivity(intent)
        }
    }
}
