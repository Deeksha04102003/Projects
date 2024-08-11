package com.example.project_medizenhub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

@Suppress("DEPRECATION")
class Screen7 : AppCompatActivity() {

    // Session state variable
    private var isLoggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen7)

        // Set isLoggedIn to true when the user logs in successfully
        isLoggedIn = true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (isLoggedIn) {
            // If the user is logged in, navigate back to Screen5
            val intent = Intent(this, Screen5::class.java)
            startActivity(intent)
        } else {
            // If the user is not logged in, perform default back button behavior
            super.onBackPressed()
        }
    }
}
