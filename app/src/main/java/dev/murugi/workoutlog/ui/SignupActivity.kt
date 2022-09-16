package dev.murugi.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.murugi.workoutlog.databinding.ActivitySignupBinding
import dev.murugi.workoutlog.models.RegisterRequest
import dev.murugi.workoutlog.models.RegisterResponse
import dev.murugi.workoutlog.api.ApiClient
import dev.murugi.workoutlog.api.ApiInterface
import dev.murugi.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
     lateinit var binding: ActivitySignupBinding
     lateinit var sharedPrefs: SharedPreferences
     val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSignupLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnSignup.setOnClickListener {
            validateSignUp()
        }
    }
    override fun onResume(){
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { RegisterResponse ->
            Toast.makeText(baseContext,RegisterResponse?.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, LoginActivity::class.java))
        })
        userViewModel.loginErrorLiveData.observe(this, Observer { errorMessage->
            Toast.makeText(baseContext,errorMessage,Toast.LENGTH_LONG).show()
        })
    }

    fun validateSignUp(){
        var name1 = binding.etFirstName.text.toString()
        var name2 = binding.etLastname.text.toString()
        var phoneNumber = binding.etPhoneNumber.text.toString()
        var email = binding.etEmail.text.toString()
        var password = binding.etpassword2.text.toString()
        var confirmPass = binding.etConfirmpassword2.text.toString()


        var error = false

        if (name1.isBlank()){
            error = true
            binding.tilFirstName.error = "First name is required"
        }
        if (name2.isBlank()){
            error = true
            binding.tilSecondname.error = "Second name is required"
        }
        if (phoneNumber.isBlank()){
            error = true
            binding.tilPhoneNumber.error = "Phone number is required"
        }
        if (email.isBlank()){
            error = true
            binding.tilEmail.error = "Email is required"
        }
        if (password.isBlank()){
            error = true
            binding.tilPassword2.error = "Password is required"
        }
        if (confirmPass.isBlank()){
            error = true
            binding.tilConfirmPassword2.error = "Confirm your password"
        }
        if (password.length < 8){
            error = true
            binding.tilPassword2.error = "Minimum password characters allowed is 8"
        }
        if (password.length > 16){
            error = true
            binding.tilPassword2.error = "Maximum password characters allowed is 16"
        }
        if (password != confirmPass){
            error = true
            binding.tilConfirmPassword2.error = "Passwords do not match"
        }
        if (!error){
            val registerRequest = RegisterRequest(name1,name2,phoneNumber,email,password)
            userViewModel.registerUser(registerRequest)
        }
    }

}