package com.example.sharedpreferenceseditprofile

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferenceseditprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mySharedPreferences: SharedPreferences
    private lateinit var myEditor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initSharedPreferences()
    }

    private fun initSharedPreferences(){

        mySharedPreferences = getSharedPreferences("my_shared_preferences", MODE_PRIVATE)
        myEditor = mySharedPreferences.edit()
    }
}