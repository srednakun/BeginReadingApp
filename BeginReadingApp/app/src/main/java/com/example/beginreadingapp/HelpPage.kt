package com.example.beginreadingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.beginreadingapp.databinding.ActivityHelpPageBinding
import com.example.beginreadingapp.ui.login.Home
import com.example.beginreadingapp.ui.login.LoginActivity
import com.example.beginreadingapp.ui.login.parentGuide

class HelpPage : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHelpPageBinding

    fun openHomePage(view: View){
        val myIntent = Intent(this@HelpPage, Home::class.java)
        this@HelpPage.startActivity(myIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHelpPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}