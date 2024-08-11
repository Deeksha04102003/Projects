package com.example.project_medizenhub

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project_medizenhub.databinding.ActivityScreen2Binding

class Screen2 : AppCompatActivity() {
    private val binding: ActivityScreen2Binding by lazy {
        ActivityScreen2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.nextbutton.setOnClickListener {
            val intent = Intent(this, Screen3::class.java)
            startActivity(intent)
        }
    }
}
