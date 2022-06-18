package dev.murugi.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.murugi.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
     lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
            validateLogin()
        }
    }
    fun validateLogin(){
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var error = false

        if (email.isBlank()){
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()){
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (!error){
//            startActivity(Intent(this, HomeActivity::class.java))
//            finish()
        }
    }
}