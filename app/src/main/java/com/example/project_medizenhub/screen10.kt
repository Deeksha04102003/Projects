package com.example.project_medizenhub

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Screen10 : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var editTextPinCode: EditText
    private lateinit var buttonAddAddress: Button
    private lateinit var buttonProceed: Button
    private lateinit var editTextPhoneNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen10)

        // Initialize your views
        editTextName = findViewById(R.id.editTextText2)
        editTextEmail = findViewById(R.id.editTextTextEmailAddress3)
        editTextAddress = findViewById(R.id.editTextText3)
        editTextPinCode = findViewById(R.id.editTextText10)
        buttonAddAddress = findViewById(R.id.button3)
        buttonProceed = findViewById(R.id.button11)
        editTextPhoneNumber = findViewById(R.id.editTextText11)

        // Retrieve logged-in user information
        val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val loggedInUserName = sharedPreferences.getString("UserName", "")
        val loggedInUserEmail = sharedPreferences.getString("UserEmail", "")

        // Populate EditText fields with user information
        editTextName.setText(loggedInUserName)
        editTextEmail.setText(loggedInUserEmail)

        // Set OnClickListener for Add Address Button
        buttonAddAddress.setOnClickListener {
            // Show address-related views
            editTextAddress.visibility = View.VISIBLE
            editTextPinCode.visibility = View.VISIBLE
            buttonProceed.visibility = View.VISIBLE
            editTextPhoneNumber.visibility= View.VISIBLE
            // Hide Add Address Button
            buttonAddAddress.visibility = View.INVISIBLE
        }

        // Set OnClickListener for Proceed Button
        buttonProceed.setOnClickListener {
            // Validate the entered data
            if (validateData()) {
                // Navigate to Screen10
                val intent = Intent(this, Screen11::class.java)
                startActivity(intent)
            } else {
                // Display error message
                Toast.makeText(this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Method to validate entered data
    private fun validateData(): Boolean {
        val name = editTextName.text.toString().trim()
        val email = editTextEmail.text.toString().trim()
        val address = editTextAddress.text.toString().trim()
        val pinCode = editTextPinCode.text.toString().trim()

        // Check if all fields are filled
        if (name.isEmpty() || email.isEmpty() || address.isEmpty() || pinCode.isEmpty()) {
            // Display error message or handle empty fields
            return false
        }

        // Check if phone number is 10 digits and pin code is 6 digits
        if (pinCode.length != 6) {
            // Display error message or handle invalid pin code
            Toast.makeText(this, "Pin code should be 6 digits", Toast.LENGTH_SHORT).show()
            return false
        }

        // Add more validation rules as per your requirements

        // If everything is valid
        return true
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("SetTextI18n")
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Screen6::class.java)

        startActivity(intent)
    }
}
