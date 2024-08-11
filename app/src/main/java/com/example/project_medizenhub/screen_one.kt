package com.example.project_medizenhub

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_one)
        Handler().postDelayed({
            val intent = Intent(this, Screen2::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }

}