package com.example.bookhaven.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.R
import com.example.bookhaven.adapters.Favorite_Adapter.onItemClickListner
import com.example.bookhaven.data.Book

class RecommandationAdapter(val listBook:List<Book>): RecyclerView.Adapter<RecommandationAdapter.BookViewHolder>() {
    private lateinit var mListner:onItemClickListner
    interface onItemClickListner{
        fun onItemClick(position:Int)
    }
    fun setOnItemClickListener(listener:onItemClickListner){
        mListner=listener
    }
    class BookViewHolder(itemView: View,listner:onItemClickListner): RecyclerView.ViewHolder(itemView){
        val image: ImageView =itemView.findViewById(R.id.imageBook)
        init {
            itemView.setOnClickListener {
                listner.onItemClick(adapterPosition)
            }


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.item_recommandation,parent,false)
        return BookViewHolder(view,mListner)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val Book=listBook[position]
        holder.image.setImageResource(Book.image)

    }

    private fun registerForContextMenu() {
        TODO("Not yet implemented")
    }


}