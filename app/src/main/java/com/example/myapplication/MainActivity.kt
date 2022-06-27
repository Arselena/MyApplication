package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottons()
    }

    private fun initBottons() {
        binding.button1.setOnClickListener() {
            Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener() {
            Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
        }
        binding.button3.setOnClickListener() {
            Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
        }
        binding.button4.setOnClickListener() {
            Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
        }
        binding.button5.setOnClickListener() {
            Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
        }
    }
}