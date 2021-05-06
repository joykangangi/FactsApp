package com.example.factsapp.screens

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.factsapp.R
import com.example.factsapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
   private val minPasswordLength = 6
    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.loginBtn?.setOnClickListener {  performLogin()  }
    }


    // Checking if the input in form is valid
    private fun validateInput(): Boolean {
        if (binding?.etEmail?.text.toString() == "") {
           binding?.etEmail?.error = "Please Enter Email"
            return false
        }
        if (binding?.etPassword?.text.toString() == "") {
            binding?.etPassword?.error = "Please Enter Password"
            return false
        }

        // checking the proper email format
        if (!isEmailValid(binding?.etEmail?.text.toString())) {
           binding?.etEmail?.error = getString(R.string.invalid_email)
            return false
        }

        // checking minimum password Length
        if (binding?.etPassword?.text?.length!! < minPasswordLength) {
            binding?.etPassword?.error = "Password Length must be more than " + minPasswordLength+ "characters"
            return false
        }
        return true
    }

    private fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Hook Click Event
   private fun performLogin() {
        if (validateInput()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

        }
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}