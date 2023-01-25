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
        showSharedPreferences()
    }

    private fun initSharedPreferences(){

        mySharedPreferences = getSharedPreferences("my_shared_preferences", MODE_PRIVATE)
        myEditor = mySharedPreferences.edit()
    }

    private fun showSharedPreferences(){

        val name = mySharedPreferences.getString("key_name",null)
        val role = mySharedPreferences.getString("key_role",null)

        if (name != null && role != null){
            binding.tvName.text = name
            binding.tvRole.text = role

            binding.etName.setText("$name")
            binding.etRole.setText("$role")
        }else{
            binding.tvName.text = getString(R.string.empty_name)
            binding.tvRole.text = getString(R.string.empty_role)
        }
    }
}