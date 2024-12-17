package com.example.bookhaven

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.activities.RecommandationAdapter
import com.example.bookhaven.activities.categorie
import com.example.bookhaven.adapters.Favorite_Adapter
import com.example.bookhaven.adapters.ItemCategorieAdapter
import com.example.bookhaven.data.Book
import com.example.bookhaven.data.CategorieBook
import com.example.bookhaven.data.list

class Home : AppCompatActivity() {
    lateinit var listCategorieBook: List<CategorieBook>
    lateinit var itemCategorieAdapter: ItemCategorieAdapter
    lateinit var gridView: GridView
    lateinit var recyclerView: RecyclerView
    lateinit var bookAdapter: RecommandationAdapter
    lateinit var listview: RecyclerView
    lateinit var  ListViewAdapter: Favorite_Adapter
    lateinit var bookMoreRide:List<Book>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listCategorieBook = mutableListOf(CategorieBook("Sociology",R.drawable.sociole),
            CategorieBook("Self-Help",R.drawable.self_dev),
            CategorieBook("Romance",R.drawable.romance),
            CategorieBook("History",R.drawable.history),
            CategorieBook("Thriller",R.drawable.thrailler),
            CategorieBook("quetes",R.drawable.quetes)
        )

        gridView=findViewById(R.id.gridviewHome)
        listview=findViewById(R.id.listview)
        recyclerView=findViewById(R.id.recyclerView)
        itemCategorieAdapter= ItemCategorieAdapter(this,listCategorieBook)
        gridView.adapter=itemCategorieAdapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        bookMoreRide=list.filter { it.evaluation >="4.5" }
        bookAdapter= RecommandationAdapter(bookMoreRide)
        recyclerView.adapter=bookAdapter
        ListViewAdapter=Favorite_Adapter(this,list)
        listview.layoutManager= LinearLayoutManager(this)
        listview.adapter=ListViewAdapter
        gridView.setOnItemClickListener { parent, view, position, id ->
            Intent(this, categorie::class.java).also{
                it.putExtra("genre",listCategorieBook[position].nameCategorie)
                startActivity(it)

            }
        }
    }
}