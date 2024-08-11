package com.example.project_medizenhub

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_medizenhub.databinding.ActivityScreen3Binding
import com.example.project_medizenhub.ui.theme.DatabaseHelper

class Screen3 : AppCompatActivity() {
    private val binding: ActivityScreen3Binding by lazy {
        ActivityScreen3Binding.inflate(layoutInflater)
    }

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dbHelper = DatabaseHelper(this)

        binding.loginbutton.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val user = dbHelper.getUserByEmailAndPassword(email, password)
                if (user != null) {
                    // Store the user's email, username, and password in SharedPreferences
                    val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("UserEmail", email)
                    editor.putString("UserName", user.name) // Assuming user has a field called 'name'
                    editor.putString("UserPassword", password) // Store password (not recommended for production)
                    editor.apply()

                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Screen5::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.dabutton.setOnClickListener {
            val intent = Intent(this, Screen4::class.java)
            startActivity(intent)
        }
    }
}
