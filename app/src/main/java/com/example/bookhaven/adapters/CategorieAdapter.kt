package com.example.bookhaven.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.bookhaven.R
import com.example.bookhaven.data.Book

class CategorieAdapter(val context:Context,val list: List<Book>) : BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view=convertView?: LayoutInflater.from(context).inflate(R.layout.item_categorie,parent,false)
        val textNom=view.findViewById<TextView>(R.id.NameBook)
        val textAuteur=view.findViewById<TextView>(R.id.auteur)
        var image=view.findViewById<ImageView>(R.id.imageBook)
        var item=getItem(position) as Book
        textNom.text=item.name
        textAuteur.text=item.auteur
        image.setImageResource(item.image)
        return view
    }

}