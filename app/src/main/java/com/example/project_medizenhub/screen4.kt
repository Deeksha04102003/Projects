package com.example.project_medizenhub

import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_medizenhub.databinding.ActivityScreen4Binding
import com.example.project_medizenhub.ui.theme.DatabaseHelper
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat




@Suppress("DEPRECATION")
class Screen4 : AppCompatActivity() {
    private val binding: ActivityScreen4Binding by lazy {
        ActivityScreen4Binding.inflate(layoutInflater)
    }

    companion object {
        private const val REQUEST_SMS_PERMISSION = 1001
    }


    private lateinit var dbHelper: DatabaseHelper
    private var verificationCode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

        binding.signupbutton.setOnClickListener {
            val name = binding.editTextText.text.toString()
            val email = binding.editTextTextEmailAddress2.text.toString()
            val password = binding.editTextTextPassword2.text.toString()
            val phoneNumber = binding.editTextPhoneNumber.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && phoneNumber.isNotEmpty()) {
                // Perform phone number verification
                sendVerificationCode(phoneNumber)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.ahbutton.setOnClickListener {
            val intent = Intent(this, Screen3::class.java)
            startActivity(intent)
        }

        binding.verifyOtpButton.setOnClickListener {
            verifyVerificationCode()
        }
    }

    private fun sendVerificationCode(phoneNumber: String) {
        // Check if the permission is not granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            // Request the permission
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), REQUEST_SMS_PERMISSION)
        } else {
            // Permission already granted, proceed with sending SMS
            verificationCode = generateVerificationCode()
            val smsManager = SmsManager.getDefault()
            try {
                smsManager.sendTextMessage(phoneNumber, null, "Your verification code is: $verificationCode", null, null)
                binding.otpLayout.visibility = View.VISIBLE
                Toast.makeText(this, "Verification code sent to $phoneNumber", Toast.LENGTH_SHORT).show()
            } catch (ex: Exception) {
                Toast.makeText(this, "Failed to send verification code. Please try again", Toast.LENGTH_SHORT).show()
            }
        }
    }



    private fun generateVerificationCode(): String {
        // Generate a random 6-digit verification code
        return (100000..999999).random().toString()
    }

    // Verify the entered verification code
    private fun verifyVerificationCode() {
        val enteredCode = binding.editTextOTP.text.toString()
        if (enteredCode == verificationCode) {
            // Verification successful, proceed with registration
            registerUser()
        } else {
            // Invalid verification code
            Toast.makeText(this, "Invalid verification code", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registerUser() {
        val name = binding.editTextText.text.toString()
        val email = binding.editTextTextEmailAddress2.text.toString()
        val password = binding.editTextTextPassword2.text.toString()

        // Insert user data into the database
        val userId = dbHelper.insertUser(name, email, password)

        if (userId != -1L) {
            // Registration successful
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

            // Navigate to the next screen (replace NextActivity::class.java with the desired activity)
            val intent = Intent(this, Screen3::class.java)
            startActivity(intent)
            finish() // Optional: Close current activity to prevent user from going back
        } else {
            // Failed to register user
            Toast.makeText(this, "Failed to register user", Toast.LENGTH_SHORT).show()
        }
    }
}
