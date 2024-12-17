package com.example.bookhaven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.adapters.Quotes_Adapter
import com.example.bookhaven.data.Book
import com.example.bookhaven.data.list


class QuotesFragment : Fragment() {

   private lateinit var recyclerView:RecyclerView
   private lateinit var bookAdapter: Quotes_Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view=inflater.inflate(R.layout.fragment_quotes, container, false)

        recyclerView=view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(context)
        bookAdapter= Quotes_Adapter(list)
        recyclerView.adapter=bookAdapter
        return view
    }


}