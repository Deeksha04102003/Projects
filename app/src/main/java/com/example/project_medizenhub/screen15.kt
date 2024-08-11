package com.example.project_medizenhub

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Screen15 : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var payButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen15)

        usernameEditText = findViewById(R.id.editTextText8)
        passwordEditText = findViewById(R.id.editTextText9)
        payButton = findViewById(R.id.button10)

        payButton.setOnClickListener {
            if (validateFields()) {
                showLoading()
                Handler().postDelayed({
                    hideLoading()
                    showVerifySuccess()
                    navigateToScreen16()
                }, 2000)
            } else {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateFields(): Boolean {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        return username.isNotEmpty() && password.isNotEmpty()
    }

    @SuppressLint("SetTextI18n")
    private fun showLoading() {
        // Show loading indicator, change button text, or whatever loading UI you prefer
        payButton.text = "Please wait..."
        payButton.isEnabled = false
    }

    @SuppressLint("SetTextI18n")
    private fun hideLoading() {
        // Hide loading indicator and enable the button
        payButton.text = "PAY"
        payButton.isEnabled = true
    }

    @SuppressLint("SetTextI18n")
    private fun showVerifySuccess() {
        // Change button text to "VERIFY" to simulate verification
        payButton.text = "VERIFYING"
        // Show toast or message indicating payment successful
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToScreen16() {
        val intent = Intent(this, Screen16::class.java)
        startActivity(intent)
        // Finish the current activity to prevent going back to Screen15
        finish()
    }
}
