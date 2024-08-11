package com.example.project_medizenhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

@Suppress("DEPRECATION")
class Screen8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen8)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Screen5::class.java)
        startActivity(intent)
        finish()
    }
}