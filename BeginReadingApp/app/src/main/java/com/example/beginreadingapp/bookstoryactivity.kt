package com.example.beginreadingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.beginreadingapp.databinding.ActivityBookstoryactivityBinding
import com.example.beginreadingapp.ui.login.Home

class bookstoryactivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityBookstoryactivityBinding

    fun goHome(view: View){
        val myIntent = Intent(this@bookstoryactivity, Home::class.java)
        this@bookstoryactivity.startActivity(myIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityBookstoryactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //open the story
        val bookstory = intent.extras
        var value: Int = -1
        if(bookstory != null){
            value = bookstory.getInt("viewId")
            val currentBookImage = findViewById<ImageView>(R.id.bookStoryImage)
            currentBookImage.setImageResource(value)
            //android:src="@drawable/flower_story"
            //bookStoryImage
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_bookstoryactivity)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}