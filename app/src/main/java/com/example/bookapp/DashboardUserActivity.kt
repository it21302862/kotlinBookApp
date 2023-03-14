package com.example.bookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookapp.databinding.ActivityDashboardAdminBinding
import com.example.bookapp.databinding.ActivityDashboardUserBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardUserActivity : AppCompatActivity() {

    //viewbinding
    private lateinit var binding: ActivityDashboardUserBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click,logout
        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    private fun checkUser() {

        //get current user
        var firebaseUser = firebaseAuth.currentUser

        if (firebaseUser == null) {

            //not logged in,user can stay in user dashboard
            binding.subTitleTv.text = "Not logged In"
        } else {
            //logged in,get and show user info
            val email = firebaseUser.email

            //set to textView of toolbar
            binding.subTitleTv.text = email


        }
    }
}