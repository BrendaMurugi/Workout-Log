package dev.murugi.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tilFirstName: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tilSecondname: TextInputLayout
    lateinit var etLastname: TextInputEditText
    lateinit var tilEmail: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var tilPassword2: TextInputLayout
    lateinit var etpassword2: TextInputEditText
    lateinit var tilConfirmPassword2: TextInputLayout
    lateinit var etConfirmpassword: TextInputEditText
    lateinit var btnSignup: Button
    lateinit var tvSignupLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        tilFirstName = findViewById(R.id.tilFirstName)
        etFirstName = findViewById(R.id.etFirstName)
        tilSecondname = findViewById(R.id.tilSecondname)
        etLastname = findViewById(R.id.etLastname)
        tilEmail = findViewById(R.id.tilEmail)
        etEmail = findViewById(R.id.etEmail)
        tilPassword2 = findViewById(R.id.tilPassword2)
        etpassword2 = findViewById(R.id.etpassword2)
        tilConfirmPassword2 = findViewById(R.id.tilConfirmPassword2)
        etConfirmpassword = findViewById(R.id.etConfirmpassword2)
        btnSignup = findViewById(R.id.btnSignup)
        tvSignupLink = findViewById(R.id.tvSignupLink)

        tvSignupLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnSignup.setOnClickListener {
            validateSignUp()
        }
    }
    fun validateSignUp(){
        var name1 = etFirstName.text.toString()
        var name2 = etLastname.text.toString()
        var email = etEmail.text.toString()
        var password = etpassword2.text.toString()
        var confirmPass = etConfirmpassword.text.toString()

        if (name1.isBlank()){
            tilFirstName.error = "First name is required"
        }
        if (name2.isBlank()){
            tilSecondname.error = "Second name is required"
        }
        if (email.isBlank()){
            tilEmail.error = "Email is required"
        }
        if (password.isBlank()){
            tilPassword2.error = "Password is required"
        }
        if (confirmPass.isBlank()){
            tilConfirmPassword2.error = "Confirm your password"
        }
        if (password != confirmPass){
            tilConfirmPassword2.error = "Password does not match"
        }
    }
}