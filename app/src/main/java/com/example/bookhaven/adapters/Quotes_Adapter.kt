package com.example.bookhaven.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.R
import com.example.bookhaven.data.Book

class Quotes_Adapter(val listBook:List<Book>): RecyclerView.Adapter<Quotes_Adapter.BookViewHolder>() {
    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val NameBook: TextView = itemView.findViewById(R.id.NameBook)
        val quotes:TextView=itemView.findViewById(R.id.quotes)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.form_quotes,parent,false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val Book=listBook[position]
        holder.NameBook.text=Book.name
        holder.quotes.text=Book.quotes

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