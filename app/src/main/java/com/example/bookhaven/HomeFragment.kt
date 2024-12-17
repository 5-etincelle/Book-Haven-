package com.example.bookhaven

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.activities.RecommandationAdapter
import com.example.bookhaven.activities.categorie
import com.example.bookhaven.adapters.Favorite_Adapter
import com.example.bookhaven.adapters.ItemCategorieAdapter
import com.example.bookhaven.adapters.ListBookHomeAdapter
import com.example.bookhaven.data.Book
import com.example.bookhaven.data.CategorieBook
import com.example.bookhaven.data.fav
import com.example.bookhaven.data.list

class HomeFragment : Fragment() {
//    lateinit var list: List<Book>
    lateinit var listCategorieBook: List<CategorieBook>
    lateinit var itemCategorieAdapter: ItemCategorieAdapter
    lateinit var gridView: GridView
    lateinit var recyclerView: RecyclerView
    lateinit var bookAdapter: RecommandationAdapter
    lateinit var listview:RecyclerView
    lateinit var  ListViewAdapter:ListBookHomeAdapter
    lateinit var bookMoreRide:List<Book>

    @SuppressLint("MissingInflatedId")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view= inflater.inflate(R.layout.fragment_home, container, false)
        listCategorieBook = mutableListOf(CategorieBook("Sociology",R.drawable.sociole),
            CategorieBook("Self-Help",R.drawable.self_dev),
            CategorieBook("Romance",R.drawable.romance),
            CategorieBook("History",R.drawable.history),
            CategorieBook("Thriller",R.drawable.thrailler),
            CategorieBook("quetes",R.drawable.quetes)
        )

         gridView=view.findViewById(R.id.gridviewHome)
        listview=view.findViewById(R.id.listview)
        recyclerView=view.findViewById(R.id.recyclerView)
        itemCategorieAdapter= ItemCategorieAdapter(context,listCategorieBook)
        gridView.adapter=itemCategorieAdapter

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        bookMoreRide=list.filter { it.evaluation >="4.5" }
        bookAdapter= RecommandationAdapter(bookMoreRide)
        recyclerView.adapter=bookAdapter
        ListViewAdapter=ListBookHomeAdapter(context,list)
        listview.layoutManager= LinearLayoutManager(context)
        listview.adapter=ListViewAdapter
        bookAdapter.setOnItemClickListener(object :RecommandationAdapter.onItemClickListner{
            override fun onItemClick(position: Int) {
                val intent=Intent(context,book::class.java)
                intent.putExtra("image", fav[position].image)
                intent.putExtra("namebook", fav[position].name)
                intent.putExtra("nameauthorBook", fav[position].author)
                intent.putExtra("evaluationBook", fav[position].evaluation)
                intent.putExtra("pagesBook", fav[position].pages)
                intent.putExtra("genreBook", fav[position].genre)
                intent.putExtra("descriptionBook", fav[position].description)
                intent.putExtra("year", fav[position].year)



                startActivity(intent)
                Toast.makeText(context, "you clicked for item ${position}", Toast.LENGTH_SHORT).show()
            }

        })
        ListViewAdapter.setOnItemClickListener(object :ListBookHomeAdapter.onItemClickListner{
            override fun onItemClick(position: Int) {
                val intent=Intent(context,book::class.java)
                intent.putExtra("image", list[position].image)
                intent.putExtra("namebook", list[position].name)
                intent.putExtra("nameauthorBook", list[position].author)
                intent.putExtra("evaluationBook", list[position].evaluation)
                intent.putExtra("pagesBook", list[position].pages)
                intent.putExtra("genreBook", list[position].genre)
                intent.putExtra("descriptionBook", list[position].description)
                intent.putExtra("year", list[position].year)



                startActivity(intent)
                Toast.makeText(context, "you clicked for item ${position}", Toast.LENGTH_SHORT).show()
            }

        })

        gridView.setOnItemClickListener { parent, view, position, id ->
            Intent(context, categorie::class.java).also{
                it.putExtra("genre",listCategorieBook[position].nameCategorie)
                startActivity(it)

            }
        }


        return view


    }

    }
