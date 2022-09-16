package dev.murugi.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.murugi.workoutlog.R
import dev.murugi.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
     lateinit var binding: ActivityHomeBinding
     lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogout.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
            logoutRequest()
        }

        castViews()
        setupBottomNav()
    }
    fun castViews(){

    }
    fun setupBottomNav(){
        binding.bnvHome.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.track ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else->false
            }
        }
    }
    fun logoutRequest(){
        sharedPref.edit().clear().commit()
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}