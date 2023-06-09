package com.example.bookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //View binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //hanlde click,login
        binding.loginBtn.setOnClickListener {
                startActivity(Intent(this,LoginActivity::class.java))
        }

        //hand click,skip and continue to main screen
        binding.skipBtn.setOnClickListener {

            startActivity(Intent(this,DashboardUserActivity::class.java))

        }
    }
}