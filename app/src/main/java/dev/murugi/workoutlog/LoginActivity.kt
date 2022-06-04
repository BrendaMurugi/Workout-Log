package dev.murugi.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var etPassword: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btnLogin)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        btnLogin.setOnClickListener {
            validateLogin()
        }
    }
    fun validateLogin(){
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()

        if (email.isBlank()){
            tilEmail.error = "Email is required"
        }
        if (password.isBlank()){
            tilPassword.error = "Password is required"
        }
    }
}