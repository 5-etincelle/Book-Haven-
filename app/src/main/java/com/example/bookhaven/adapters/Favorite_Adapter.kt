package com.example.bookhaven.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.R
import com.example.bookhaven.data.Book

class Favorite_Adapter(val listBook:List<Book>): RecyclerView.Adapter<Favorite_Adapter.BookViewHolder>() {
    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image:ImageView=itemView.findViewById(R.id.imageBook)
        val NameBook: TextView = itemView.findViewById(R.id.NameBook)
        val NameAuteur: TextView = itemView.findViewById(R.id.auteur)
        val Annee:TextView=itemView.findViewById(R.id.annee)
        val evaluation:TextView=itemView.findViewById(R.id.evaluation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.form_favorite,parent,false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val Book=listBook[position]
        holder.NameBook.text=Book.name
        holder.NameAuteur.text=Book.auteur
        holder.Annee.text=Book.anne.toString()
        holder.evaluation.text=Book.evaluation
        holder.image.setImageResource(Book.image)


        holder.itemView.setOnLongClickListener { view ->
            registerForContextMenu()
            view.showContextMenu()
            true
        }

    }

    private fun registerForContextMenu() {
        TODO("Not yet implemented")
    }
}