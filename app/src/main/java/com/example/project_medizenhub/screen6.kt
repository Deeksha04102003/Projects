package com.example.project_medizenhub

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project_medizenhub.databinding.ActivityScreen6Binding

@Suppress("DEPRECATION")
class Screen6 : AppCompatActivity() {

    private val binding: ActivityScreen6Binding by lazy {
        ActivityScreen6Binding.inflate(layoutInflater)
    }

    private var quantity1 = 0
    private var quantity2 = 0
    private var quantity3 = 0
    private var quantity4 = 0
    private var quantity5 = 0
    private var quantity6 = 0
    private var quantity7 = 0
    private var quantity8 = 0
    private var quantity9 = 0
    private var quantity10 = 0
    private val pricePerUnit = 67.60
    private val itemPrice = 15.48
    private val maxQuantity = 5
    private val additionalItemPrice = 20.01
    private val a = 83.45
    private val b = 65.23
    private val c = 41.44
    private val d = 9.96
    private val e = 51.11
    private val f = 23.28
    private val g = 42.45
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen6)
        setContentView(binding.root)

        binding.proceedButton.setOnClickListener {

            val intent = Intent(this@Screen6, Screen10::class.java)

            startActivity(intent)

            // Finish the current activity (Screen6)
            finish()
        }


        val plusProgressBar: ProgressBar = findViewById(R.id.progressBar)
        val minusProgressBar: ProgressBar = findViewById(R.id.progressBar2)
        val plusProgressBar2: ProgressBar = findViewById(R.id.progressBar3)
        val minusProgressBar2: ProgressBar = findViewById(R.id.progressBar4)
        val priceTextView: TextView = findViewById(R.id.textView7)
        val quantityTextView: TextView = findViewById(R.id.textView8)
        val quantityTextView2: TextView = findViewById(R.id.textView14)
        val priceTextView2: TextView = findViewById(R.id.textView11)
        val plusProgressBar3: ProgressBar = findViewById(R.id.progressBar5)
        val minusProgressBar3: ProgressBar = findViewById(R.id.progressBar6)
        val quantityTextView3: TextView = findViewById(R.id.textView18)
        val priceTextView3: TextView = findViewById(R.id.textView16)
        val plusProgressBar4: ProgressBar = findViewById(R.id.progressBar7)
        val minusProgressBar4: ProgressBar = findViewById(R.id.progressBar8)
        val quantityTextView4: TextView = findViewById(R.id.textView23)
        val priceTextView4: TextView = findViewById(R.id.textView20)
        val plusProgressBar5: ProgressBar = findViewById(R.id.progressBar9)
        val minusProgressBar5: ProgressBar = findViewById(R.id.progressBar10)
        val quantityTextView5: TextView = findViewById(R.id.textView27)
        val priceTextView5: TextView = findViewById(R.id.textView25)
        val plusProgressBar6: ProgressBar = findViewById(R.id.progressBar11)
        val minusProgressBar6: ProgressBar = findViewById(R.id.progressBar12)
        val quantityTextView6: TextView = findViewById(R.id.textView31)
        val priceTextView6: TextView = findViewById(R.id.textView29)
        val plusProgressBar7: ProgressBar = findViewById(R.id.progressBar13)
        val minusProgressBar7: ProgressBar = findViewById(R.id.progressBar14)
        val quantityTextView7: TextView = findViewById(R.id.textView35)
        val priceTextView7: TextView = findViewById(R.id.textView33)
        val plusProgressBar8: ProgressBar = findViewById(R.id.progressBar15)
        val minusProgressBar8: ProgressBar = findViewById(R.id.progressBar16)
        val quantityTextView8: TextView = findViewById(R.id.textView39)
        val priceTextView8: TextView = findViewById(R.id.textView37)
        val plusProgressBar9: ProgressBar = findViewById(R.id.progressBar17)
        val minusProgressBar9: ProgressBar = findViewById(R.id.progressBar18)
        val quantityTextView9: TextView = findViewById(R.id.textView43)
        val priceTextView9: TextView = findViewById(R.id.textView41)
        val plusProgressBar10: ProgressBar = findViewById(R.id.progressBar19)
        val minusProgressBar10: ProgressBar = findViewById(R.id.progressBar20)
        val quantityTextView10: TextView = findViewById(R.id.textView47)
        val priceTextView10: TextView = findViewById(R.id.textView45)


        plusProgressBar.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity1 < maxQuantity) {
                // Increment quantity by 1
                quantity1++

                // Update UI for ProgressBar and ProgressBar2
                updateUI(priceTextView, quantityTextView)
                updateTotalPrice()
            }
        }

        // Minus ProgressBar click listener
        minusProgressBar.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity1 = if (quantity1 > 0) quantity1 - 1 else 0

            // Update UI for ProgressBar and ProgressBar2
            updateUI(priceTextView, quantityTextView)
            updateTotalPrice()
        }

        // Plus ProgressBar2 click listener
        plusProgressBar2.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity2 < maxQuantity) {
                // Increment quantity by 1
                quantity2++

                // Update UI for ProgressBar3 and ProgressBar4
                updateUI2(priceTextView2, quantityTextView2)
                updateTotalPrice()
            }
        }

        // Minus ProgressBar2 click listener
        minusProgressBar2.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity2 = if (quantity2 > 0) quantity2 - 1 else 0

            // Update UI for ProgressBar3 and ProgressBar4
            updateUI2(priceTextView2, quantityTextView2)
            updateTotalPrice()
        }

        plusProgressBar3.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity3 < maxQuantity) {
                // Increment quantity by 1
                quantity3++

                // Update UI for ProgressBar5 and ProgressBar6
                updateUI3(priceTextView3, quantityTextView3)
                updateTotalPrice()
            }
        }

        // Minus ProgressBar3 click listener
        minusProgressBar3.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity3 = if (quantity3 > 0) quantity3 - 1 else 0

            // Update UI for ProgressBar5 and ProgressBar6
            updateUI3(priceTextView3, quantityTextView3)
            updateTotalPrice()
        }

        // Minus ProgressBar3 click listener
        minusProgressBar4.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity4 = if (quantity4 > 0) quantity4 - 1 else 0

            // Update UI for ProgressBar5 and ProgressBar6
            updateUI4(priceTextView4, quantityTextView4)
            updateTotalPrice()
        }

        plusProgressBar4.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity4 < maxQuantity) {
                // Increment quantity by 1
                quantity4++

                // Update UI for ProgressBar5 and ProgressBar6
                updateUI4(priceTextView4, quantityTextView4)
                updateTotalPrice()
            }
        }

        minusProgressBar5.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity5 = if (quantity5 > 0) quantity5 - 1 else 0

            // Update UI for ProgressBar5 and ProgressBar6
            updateUI5(priceTextView5, quantityTextView5)
            updateTotalPrice()
        }

        plusProgressBar5.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity5 < maxQuantity) {
                // Increment quantity by 1
                quantity5++

                // Update UI for ProgressBar5 and ProgressBar6
                updateUI5(priceTextView5, quantityTextView5)
                updateTotalPrice()
            }
        }

        minusProgressBar6.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity6 = if (quantity6 > 0) quantity6 - 1 else 0

            // Update UI for ProgressBar5 and ProgressBar6
            updateUI6(priceTextView6, quantityTextView6)
            updateTotalPrice()
        }

        plusProgressBar6.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity6 < maxQuantity) {
                // Increment quantity by 1
                quantity6++

                // Update UI for ProgressBar5 and ProgressBar6
                updateUI6(priceTextView6, quantityTextView6)
                updateTotalPrice()
            }
        }

        minusProgressBar7.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity7 = if (quantity7 > 0) quantity7 - 1 else 0

            // Update UI for ProgressBar5 and ProgressBar6
            updateUI7(priceTextView7, quantityTextView7)
            updateTotalPrice()
        }

        plusProgressBar7.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity7 < maxQuantity) {
                // Increment quantity by 1
                quantity7++

                // Update UI for ProgressBar5 and ProgressBar6
                updateUI7(priceTextView7, quantityTextView7)
                updateTotalPrice()
            }
        }

        minusProgressBar8.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity8 = if (quantity8 > 0) quantity8 - 1 else 0

            // Update UI for ProgressBar5 and ProgressBar6
            updateUI8(priceTextView8, quantityTextView8)
            updateTotalPrice()
        }

        plusProgressBar8.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity8 < maxQuantity) {
                // Increment quantity by 1
                quantity8++

                // Update UI for ProgressBar5 and ProgressBar6
                updateUI8(priceTextView8, quantityTextView8)
                updateTotalPrice()
            }
        }

        minusProgressBar9.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity9 = if (quantity9 > 0) quantity9 - 1 else 0

            // Update UI for ProgressBar5 and ProgressBar6
            updateUI9(priceTextView9, quantityTextView9)
            updateTotalPrice()
        }

        plusProgressBar9.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity9 < maxQuantity) {
                // Increment quantity by 1
                quantity9++

                // Update UI for ProgressBar5 and ProgressBar6
                updateUI9(priceTextView9, quantityTextView9)
                updateTotalPrice()
            }
        }

        minusProgressBar10.setOnClickListener {
            // Decrease quantity by 1, but ensure it doesn't go below 0
            quantity10 = if (quantity10 > 0) quantity10 - 1 else 0

            // Update UI for ProgressBar5 and ProgressBar6
            updateUI10(priceTextView10, quantityTextView10)
            updateTotalPrice()
        }

        plusProgressBar10.setOnClickListener {
            // Check if the current quantity is less than the maximum allowed quantity
            if (quantity10 < maxQuantity) {
                // Increment quantity by 1
                quantity10++

                // Update UI for ProgressBar5 and ProgressBar6
                updateUI10(priceTextView10, quantityTextView10)
                updateTotalPrice()
            }
        }

        updateTotalPrice()
    }

    // Update UI with new quantity and price for ProgressBar and ProgressBar2
    @SuppressLint("SetTextI18n")
    private fun updateUI(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar and ProgressBar2
        quantityTextView.text = quantity1.toString()

        // Update price text based on the new quantity
        val totalPrice = quantity1 * pricePerUnit
        if (quantity1 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalPrice)
        }

    }

    // Update UI with new quantity and price for ProgressBar3 and ProgressBar4
    @SuppressLint("SetTextI18n")
    private fun updateUI2(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar3 and ProgressBar4
        quantityTextView.text = quantity2.toString()

        // Update price text for ProgressBar3 and ProgressBar4
        val totalItemPrice = quantity2 * itemPrice
        if (quantity2 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }


    @SuppressLint("SetTextI18n")
    private fun updateUI3(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar5 and ProgressBar6
        quantityTextView.text = quantity3.toString()

        // Update price text for ProgressBar5 and ProgressBar6
        val totalItemPrice = quantity3 * additionalItemPrice
        if (quantity3 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI4(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar5 and ProgressBar6
        quantityTextView.text = quantity4.toString()

        // Update price text for ProgressBar5 and ProgressBar6
        val totalItemPrice = quantity4 * a
        if (quantity4 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI5(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar5 and ProgressBar6
        quantityTextView.text = quantity5.toString()

        // Update price text for ProgressBar5 and ProgressBar6
        val totalItemPrice = quantity5 * b
        if (quantity5 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI6(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar5 and ProgressBar6
        quantityTextView.text = quantity6.toString()

        // Update price text for ProgressBar5 and ProgressBar6
        val totalItemPrice = quantity6 * c
        if (quantity6 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI7(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar5 and ProgressBar6
        quantityTextView.text = quantity7.toString()

        // Update price text for ProgressBar5 and ProgressBar6
        val totalItemPrice = quantity7 * d
        if (quantity7 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI8(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar5 and ProgressBar6
        quantityTextView.text = quantity8.toString()

        // Update price text for ProgressBar5 and ProgressBar6
        val totalItemPrice = quantity8 * e
        if (quantity8 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI9(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar5 and ProgressBar6
        quantityTextView.text = quantity9.toString()

        // Update price text for ProgressBar5 and ProgressBar6
        val totalItemPrice = quantity9 * f
        if (quantity9 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI10(priceTextView: TextView, quantityTextView: TextView) {
        // Update quantity text for ProgressBar5 and ProgressBar6
        quantityTextView.text = quantity10.toString()

        // Update price text for ProgressBar5 and ProgressBar6
        val totalItemPrice = quantity10 * g
        if (quantity10 == 0) {
            // Keep the last known price
            priceTextView.text = "%.2f RS".format(itemPrice)
        } else {
            priceTextView.text = "%.2f RS".format(totalItemPrice)
        }
    }

    @SuppressLint("SetTextI18n")
    internal fun updateTotalPrice() {
        val totalPriceTextView: TextView = findViewById(R.id.totalPriceTextView)

        // Get all individual item prices
        val prices = listOf(
            getPriceFromTextView(R.id.textView7),
            getPriceFromTextView(R.id.textView11),
            getPriceFromTextView(R.id.textView16),
            getPriceFromTextView(R.id.textView20),
            getPriceFromTextView(R.id.textView25),
            getPriceFromTextView(R.id.textView29),
            getPriceFromTextView(R.id.textView33),
            getPriceFromTextView(R.id.textView37),
            getPriceFromTextView(R.id.textView41),
            getPriceFromTextView(R.id.textView45)
        )

        // Calculate total price by summing up individual item prices
        val totalPrice = prices.sum()

        // Update total price text
        totalPriceTextView.text = "Total Price: %.2f RS".format(totalPrice)
    }


    // Function to extract price from TextView and return as a double
    private fun getPriceFromTextView(textViewId: Int): Double {
        val textView: TextView = findViewById(textViewId)
        val priceText = textView.text.toString().replace(" RS", "")
        return priceText.toDoubleOrNull() ?: 0.0
    }


    @Deprecated("Deprecated in Java")
    @SuppressLint("SetTextI18n")
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Screen5::class.java)

        startActivity(intent)
    }
}




