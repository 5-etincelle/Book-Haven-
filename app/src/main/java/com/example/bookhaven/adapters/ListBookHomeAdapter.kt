package com.example.bookhaven.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.R
import com.example.bookhaven.adapters.Favorite_Adapter.onItemClickListner
import com.example.bookhaven.book
import com.example.bookhaven.data.Book
import com.example.bookhaven.data.fav

class ListBookHomeAdapter(val context: Context?, val listBook:List<Book>): RecyclerView.Adapter<ListBookHomeAdapter.BookViewHolder>() {
    private lateinit var mListner:onItemClickListner
    interface onItemClickListner{
        fun onItemClick(position:Int)
    }
    fun setOnItemClickListener(listener:onItemClickListner){
        mListner=listener
    }
    class BookViewHolder(itemView: View,listner:onItemClickListner): RecyclerView.ViewHolder(itemView){
        val image: ImageView =itemView.findViewById(R.id.imageBook)
        val NameBook: TextView = itemView.findViewById(R.id.NameBook)
        val NameAuteur: TextView = itemView.findViewById(R.id.auteur)
        val Annee: TextView =itemView.findViewById(R.id.annee)
    //        val evaluation: TextView =itemView.findViewById(R.id.evaluation)
        val optionsMenu: ImageView = itemView.findViewById(R.id.iconMenu)
        init {
            itemView.setOnClickListener {
                listner.onItemClick(adapterPosition)
            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.form_favorite,parent,false)
        return BookViewHolder(view,mListner)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val Book=listBook[position]
        holder.NameBook.text=Book.name
        holder.NameAuteur.text=Book.author
        holder.Annee.text=Book.year.toString()
//        holder.evaluation.text=Book.evaluation

        holder.image.setImageResource(Book.image)
        holder.optionsMenu.setOnClickListener {view ->
            val popupMenu= PopupMenu(context,view)
            popupMenu.menuInflater.inflate(R.menu.menu_listbook_home,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.afficher -> {
                        
                        Toast.makeText(context, "Continue clicked on ", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.ajouter -> {
                        if(fav.contains(listBook[position])){
                            Toast.makeText(context,"book deja ajouter au favorite",Toast.LENGTH_SHORT).show()

                        }else{
                            fav.add(listBook[position])
                            Toast.makeText(context,"book ajouter au favorite",Toast.LENGTH_SHORT).show()
                        }
                        true
                    }
                    else -> false
                }
            }

            // Show the popup menu
            popupMenu.show()
        }
    }


}

private fun registerForContextMenu() {
    TODO("Not yet implemented")
}
