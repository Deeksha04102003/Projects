package com.example.project_medizenhub

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Screen14 : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var accountEditText: EditText
    private lateinit var cvvEditText: EditText
    private lateinit var verifyButton: Button
    private lateinit var payButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen144)

        nameEditText = findViewById(R.id.editTextText5)
        accountEditText = findViewById(R.id.editTextText6)
        cvvEditText = findViewById(R.id.editTextText7)
        verifyButton = findViewById(R.id.button8)
        payButton = findViewById(R.id.button9)

        // Initially, make the pay button invisible
        payButton.visibility = View.GONE

        verifyButton.setOnClickListener {
            if (validateFields()) {
                // Show the pay button upon successful verification
                payButton.visibility = View.VISIBLE
                Toast.makeText(this@Screen14, "Verify Successful", Toast.LENGTH_SHORT).show()
            }
        }

        payButton.setOnClickListener {
            // Display "Please wait..." message
            payButton.text = "Please wait..."
            // Simulate payment successful after 5 seconds
            Handler().postDelayed({
                Toast.makeText(this@Screen14, "Payment Successful", Toast.LENGTH_SHORT).show()
                // Navigate to Screen16
                val intent = Intent(this@Screen14, Screen16::class.java)
                startActivity(intent)
                // Finish the current activity to prevent going back to Screen14
                finish()
            }, 5000)
        }
    }

    private fun validateFields(): Boolean {
        val name = nameEditText.text.toString()
        val account = accountEditText.text.toString()
        val cvv = cvvEditText.text.toString()

        if (name.isEmpty() || account.isEmpty() || cvv.isEmpty()) {
            Toast.makeText(this@Screen14, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return false
        }

        if (account.length != 12) {
            Toast.makeText(this@Screen14, "Account number must be 12 digits", Toast.LENGTH_SHORT).show()
            return false
        }

        if (cvv.length != 3) {
            Toast.makeText(this@Screen14, "CVV must be 3 digits", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
