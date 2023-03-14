package com.example.bookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookapp.databinding.ActivityDashboardAdminBinding
import com.example.bookapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardAdminActivity : AppCompatActivity() {

    //viewbinding
    private lateinit var binding: ActivityDashboardAdminBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashboardAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init firebase Auth
        firebaseAuth=FirebaseAuth.getInstance()
        checkUser()

        //handle click,logout
        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
    }

    private fun checkUser(){
        //get current user
        var firebaseUser=firebaseAuth.currentUser

        if(firebaseUser==null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        else{
            //logged in,get and show user info
            val email=firebaseUser.email

            //set to textView of toolbar
            binding.subTitleTv.text=email


        }
    }
}