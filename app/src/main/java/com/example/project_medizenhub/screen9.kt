package com.example.project_medizenhub

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_medizenhub.databinding.ActivityScreen9Binding

class Screen9 : AppCompatActivity() {
    private val binding: ActivityScreen9Binding by lazy {
        ActivityScreen9Binding.inflate(layoutInflater)
    }

    private val tag = "Screen9"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)

        // Retrieve email, name, and password from SharedPreferences
        val email = sharedPreferences.getString("UserEmail", null)
        val name = sharedPreferences.getString("UserName", null)
        val password = sharedPreferences.getString("UserPassword", null)

        if (email.isNullOrEmpty() || name.isNullOrEmpty() || password.isNullOrEmpty()) {
            Log.e(tag, "User data not found in SharedPreferences")
            Toast.makeText(this, "User data not found", Toast.LENGTH_SHORT).show()
            // Handle the case where user data is not found in SharedPreferences
            // For example, navigate back to the login page (Screen3)
            finish()
            return
        }

        // Populate TextViews with retrieved data
        binding.name.text = "Name : $name"
        binding.email.text = "Email : $email"
        binding.password.text = "Password : $password"

        // Navigate back to Screen5 when button2 is clicked
        binding.button2.setOnClickListener {
            val intent = Intent(this, Screen5::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
}
