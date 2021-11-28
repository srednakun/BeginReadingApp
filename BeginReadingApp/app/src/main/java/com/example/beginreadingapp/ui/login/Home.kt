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
import com.example.beginreadingapp.R
import com.example.beginreadingapp.databinding.ActivityHomeBinding
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.PopupWindow
import com.example.beginreadingapp.HelpPage
import com.example.beginreadingapp.adapters.CustomAdapter
import com.example.beginreadingapp.bookstoryactivity
import com.example.beginreadingapp.data.model.Book
import com.example.beginreadingapp.data.model.ReadingLevel



class Home : AdapterView.OnItemClickListener, AppCompatActivity()  {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    lateinit var bookGrid: GridView
    var bookList = arrayListOf<Book>(Book(ReadingLevel.K,R.drawable.frogs,"Frogs", R.drawable.frog_story),
        Book(ReadingLevel.K,R.drawable.flowers, "Flowers", R.drawable.flower_story ),
        Book(ReadingLevel.FIRST,R.drawable.lions,"Lions", R.drawable.lion_story ),
        Book(ReadingLevel.FIRST, R.drawable.fairy, "Fairy Friends", R.drawable.fairy_story),
        Book(ReadingLevel.SECOND, R.drawable.dragon, "The Great Emporor Dragon", R.drawable.dragon_story ),
        Book(ReadingLevel.SECOND, R.drawable.space, "Do you have space dreams?", R.drawable.space_story))
    var currentBookList = bookList



    fun showAllBooks(view: View){
        var customAdapter = CustomAdapter(applicationContext, bookList)
        bookGrid.adapter = customAdapter
    }

    fun sortButtons(view: View){
        currentBookList= arrayListOf()
        if(view.id == R.id.kButton){
            for(books in bookList){
                if(books.readingLevel == ReadingLevel.K){
                    currentBookList.add(books)
                }
            }

        }
        else if(view.id == R.id.firstButton){
            for(books in bookList){
                if(books.readingLevel == ReadingLevel.FIRST){
                    currentBookList.add(books)
                }
            }

        }
        else{
            for(books in bookList){
                if(books.readingLevel == ReadingLevel.SECOND){
                    currentBookList.add(books)
                }
            }

        }
        var customAdapter = CustomAdapter(applicationContext, currentBookList)
        bookGrid.adapter = customAdapter
    }


    fun openParentGuide(view: View){
        val myIntent = Intent(this@Home, parentGuide::class.java)
        this@Home.startActivity(myIntent)
    }

    fun goToCreatePage(view: View){
        val myIntent = Intent(this@Home, LoginActivity::class.java)
        this@Home.startActivity(myIntent)
    }

    fun openHelpPage(view: View){
        val myIntent = Intent(this@Home, HelpPage::class.java)
        this@Home.startActivity(myIntent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookGrid = findViewById(R.id.simpleGridView)
        var customAdapter = CustomAdapter(applicationContext, currentBookList)
        bookGrid.onItemClickListener = this
        bookGrid.adapter = customAdapter

        //change this code so it opens the book when clicked on
//        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // set an Intent to Another Activity
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("image", logos[position]); // put image data in Intent
//                startActivity(intent); // start Intent
//            }

        //simpleList = findViewById(binding.simpleGridView)
        //bookList.add(R.drawable.flowers)

    }

    //parent: AdapterView,
    override fun onItemClick(parent: AdapterView<*>?,view: View, position: Int, id: Long) {

        val myIntent = Intent(this@Home, bookstoryactivity::class.java).putExtra("viewId", currentBookList[position].story)
        this@Home.startActivity(myIntent)

    }
}