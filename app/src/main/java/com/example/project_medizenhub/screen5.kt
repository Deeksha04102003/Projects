package com.example.project_medizenhub

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_medizenhub.databinding.ActivityScreen5Binding

@Suppress("DEPRECATION")
class Screen5 : AppCompatActivity() {
    private val binding: ActivityScreen5Binding by lazy {
        ActivityScreen5Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.searchbutton.setOnClickListener {
            val intent = Intent(this, Screen6::class.java)
            startActivity(intent)
        }

        binding.logoutbutton.setOnClickListener {
            // Show a toast message indicating successful logout
            Toast.makeText(this, "Successfully logged out !!", Toast.LENGTH_SHORT).show()

            // Start Screen3 activity after logging out
            val intent = Intent(this, Screen3::class.java)
            startActivity(intent)

            // Finish current activity
            finish()
        }

        binding.profilebutton.setOnClickListener {
            val email = intent.getStringExtra("email")
            val password = intent.getStringExtra("password")
            val intent = Intent(this, Screen9::class.java).apply {
                putExtra("email", email)
                putExtra("password", password)
            }
            startActivity(intent)
        }

        // Handle button click to navigate to Screen8 with loading message
        binding.button.setOnClickListener {
            // Show loading message
            Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()

            // Simulate loading with delay
            Handler().postDelayed({
                // Navigate to Screen8
                val intent = Intent(this, Screen8::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }, 2000) // Delay time in milliseconds (e.g., 2000ms = 2 seconds)
        }

    }
}
