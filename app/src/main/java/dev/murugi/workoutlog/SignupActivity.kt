package dev.murugi.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.murugi.workoutlog.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
     lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.tvSignupLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnSignup.setOnClickListener {
            validateSignUp()
        }
    }
    fun validateSignUp(){
        var name1 = binding.etFirstName.text.toString()
        var name2 = binding.etLastname.text.toString()
        var email = binding.etEmail.text.toString()
        var password = binding.etpassword2.text.toString()
        var confirmPass = binding.etConfirmpassword2.text.toString()

        if (name1.isBlank()){
            binding.tilFirstName.error = "First name is required"
        }
        if (name2.isBlank()){
            binding.tilSecondname.error = "Second name is required"
        }
        if (email.isBlank()){
            binding.tilEmail.error = "Email is required"
        }
        if (password.isBlank()){
            binding.tilPassword2.error = "Password is required"
        }
        if (confirmPass.isBlank()){
            binding.tilConfirmPassword2.error = "Confirm your password"
        }
        if (password.length < 8){
            binding.tilPassword2.error = "Minimum password characters allowed is 8"
        }
        if (password.length > 16){
            binding.tilPassword2.error = "Maximum password characters allowed is 16"
        }
        if (password != confirmPass){
            binding.tilConfirmPassword2.error = "Passwords do not match"
        }
    }
}