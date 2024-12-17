package com.example.bookhaven

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.adapters.Favorite_Adapter
import com.example.bookhaven.data.fav
import com.example.bookhaven.data.list


class FavoriteFragment : Fragment() {
    private lateinit var bookAdapter: Favorite_Adapter
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
     val view= inflater.inflate(R.layout.fragment_favorite, container, false)
        recyclerView=view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(context)
        bookAdapter= Favorite_Adapter(context,fav)
        recyclerView.adapter=bookAdapter
       bookAdapter.setOnItemClickListener(object :Favorite_Adapter.onItemClickListner{
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
//        bookAdapter.onItemClick = {
//            val intent=Intent(context,book::class.java)
//            intent.putExtra("book",it)
//            startActivity(intent)
//        }
       return view
    }




}