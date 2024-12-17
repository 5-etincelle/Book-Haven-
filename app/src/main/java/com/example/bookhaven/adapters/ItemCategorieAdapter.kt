package com.example.bookhaven.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.bookhaven.R
import com.example.bookhaven.data.CategorieBook

class ItemCategorieAdapter(val context: Context?, val listCategorie:List<CategorieBook>): BaseAdapter(){
        override fun getCount(): Int {
            return listCategorie.size
        }

        override fun getItem(p0: Int): Any {
            return listCategorie[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val view=p1?: LayoutInflater.from(context).inflate(R.layout.item_categorie_home,p2,false)
              var textNameCategorie=view.findViewById<TextView>(R.id.nameCategorie)
               var image=view.findViewById<ImageView>(R.id.imageCategorie)
            var element=getItem(p0) as CategorieBook
             textNameCategorie.text=element.nameCategorie
            image.setImageResource(element.imagecategorie)

            return view
        }
    }
