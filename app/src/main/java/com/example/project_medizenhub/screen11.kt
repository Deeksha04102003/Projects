package com.example.project_medizenhub

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_medizenhub.databinding.ActivityScreen11Binding

@Suppress("DEPRECATION")
class Screen11 : AppCompatActivity() {

    private lateinit var binding: ActivityScreen11Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val radioButtons = listOf(
            binding.radioButton,
            binding.radioButton2,
            binding.radioButton3,
            binding.radioButton4
        )

        radioButtons.forEach { radioButton ->
            radioButton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    radioButtons.filter { it != radioButton }.forEach { it.isChecked = false }
                }
            }
        }

        binding.button4.setOnClickListener {
            if (radioButtons.any { it.isChecked }) {
                navigateToNextScreen()
            } else {
                Toast.makeText(this, "Please select one option to proceed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToNextScreen() {
        val intent = when {
            binding.radioButton.isChecked -> Intent(this, Screen12::class.java)
            binding.radioButton2.isChecked -> Intent(this, Screen13::class.java)
            binding.radioButton3.isChecked -> Intent(this, Screen14::class.java)
            binding.radioButton4.isChecked -> Intent(this, Screen15::class.java)
            else -> return // No RadioButton selected, do nothing
        }
        startActivity(intent)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, Screen10::class.java))
        finish()
    }
}

