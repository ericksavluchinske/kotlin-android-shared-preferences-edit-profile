package com.example.sharedpreferenceseditprofile

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

    private fun validateInput(inputName: String?, inputRole: String?): Boolean{
        return when{
            inputName.isNullOrEmpty() -> {
                Toast.makeText(this,"Please type your name", Toast.LENGTH_LONG).show()
                binding.etName.requestFocus()
                false
            }
            inputRole.isNullOrEmpty() -> {
                Toast.makeText(this,"Please type your role", Toast.LENGTH_LONG).show()
                binding.etRole.requestFocus()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun insertSharedPreferences(inputName: String, inputRole: String){

        myEditor.apply(){
            putString("key_name",inputName)
            putString("key_role",inputRole)
            apply()
        }

        Toast.makeText(this,"Saved successfully",Toast.LENGTH_LONG).show()
    }
}