package com.example.project_medizenhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Screen13 : AppCompatActivity() {

    private lateinit var buttonPay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen13)

        buttonPay = findViewById(R.id.button7)

        buttonPay.setOnClickListener {
            // Navigate to Screen16
            startActivity(Intent(this@Screen13, Screen16::class.java))
        }
    }
}
