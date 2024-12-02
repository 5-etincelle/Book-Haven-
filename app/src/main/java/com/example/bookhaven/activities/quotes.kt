package com.example.bookhaven.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.R
import com.example.bookhaven.adapters.Quotes_Adapter
import com.example.bookhaven.data.Book

class quotes : AppCompatActivity() {
    private lateinit var bookAdapter: Quotes_Adapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quotes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list= mutableListOf(
            Book(
                R.drawable.book6,"name book 1","titel book  1",1992,"5/5","It looks like you just wrote text.How can I assist you with it?How can I assist you with it?" +
                    "\" How can I assist you with it? "),
            Book(
                R.drawable.book3,"name book 2","titel book  2",1932,"4/5","It looks like you just wrote \"text.\n" +
                    "\" How can I assist you with it? "),
            Book(
                R.drawable.book4,"name book 3","titel book  3",1942,"3/5","It looks like you just wrote \"text.\n" +
                    "\" How can I assist you with it? "),
            Book(
                R.drawable.book1,"name book 4","titel book 4",1922,"4/5","It looks like you just wrote \"text.\n" +
                    "\" How can I assist you with it? ")
        )
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)
        bookAdapter= Quotes_Adapter(list)
        recyclerView.adapter=bookAdapter
    }
}