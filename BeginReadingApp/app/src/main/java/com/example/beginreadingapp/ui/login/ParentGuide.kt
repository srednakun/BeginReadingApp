package com.example.beginreadingapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

import com.example.beginreadingapp.databinding.ContentParentGuideBinding
import com.example.beginreadingapp.ui.login.UserLogin

class parentGuide : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ContentParentGuideBinding

    fun goHome(view: View){
        val myIntent = Intent(this@parentGuide, Home::class.java)
        this@parentGuide.startActivity(myIntent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContentParentGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

