package com.example.beginreadingapp.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.beginreadingapp.R
import com.example.beginreadingapp.data.model.Book


class CustomAdapter(var context: Context, var bookIds: ArrayList<Book>) :
    BaseAdapter() {
    var inflater: LayoutInflater
    override fun getCount(): Int {
        return bookIds.size
    }

    override fun getItem(i: Int): Any {
        return bookIds[i]
    }

    override fun getItemId(i: Int): Long {
        return bookIds[i].imageId.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        //var view = view
        var bookview = inflater.inflate(R.layout.bookcover, null) // inflate the layout
        val icon = bookview.findViewById<View>(R.id.bookStoryImage) as ImageView // get the reference of ImageView
        icon.setImageResource(bookIds[i].imageId) // set logo images
        return bookview
    }

    init {
        inflater = LayoutInflater.from(context)
    }
}