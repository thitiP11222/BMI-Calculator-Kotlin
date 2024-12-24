package com.example.fitcheck

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitcheck.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calBtn.setOnClickListener{
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        val weight = binding.weightEdit.text.toString().toFloatOrNull()
        val height = binding.heightEdit.text.toString().toFloatOrNull()
        
        
        if(weight != null && height != null){
            val bmi = weight/ (height/100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            val bmiCategory = when {
                bmi< 18.5 -> "You are underweight."
                bmi< 25 -> "Great! You’re in a healthy range!"
                bmi< 30 -> "You’re slightly overweight."
                else -> "High BMI detected."
            }

            binding.result.text = "BMI: $bmiResult \n$bmiCategory"

        }
        else {
            binding.result.text = "Invalid Input"
        }
    }
}