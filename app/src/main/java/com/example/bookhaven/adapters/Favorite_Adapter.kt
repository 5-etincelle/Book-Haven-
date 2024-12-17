package com.example.bookhaven.adapters


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bookhaven.R
import com.example.bookhaven.data.Book
import com.example.bookhaven.data.fav

class Favorite_Adapter(val context: Context?, val listBook:List<Book>): RecyclerView.Adapter<Favorite_Adapter.BookViewHolder>() {
//    var onItemClick:((Book)->Unit)?=null
    private lateinit var mListner:onItemClickListner
    interface onItemClickListner{
        fun onItemClick(position:Int)
    }
    fun setOnItemClickListener(listener:onItemClickListner){
        mListner=listener
    }
    class BookViewHolder(itemView: View ,listner: onItemClickListner): RecyclerView.ViewHolder(itemView){
        val image:ImageView=itemView.findViewById(R.id.imageBook)
        val NameBook: TextView = itemView.findViewById(R.id.NameBook)
        val NameAuteur: TextView = itemView.findViewById(R.id.auteur)
        val Annee:TextView=itemView.findViewById(R.id.annee)
        val optionsMenu: ImageView = itemView.findViewById(R.id.iconPopupMenu)
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
//        holder.itemView.setOnClickListener {
//            onItemClick?.invoke(Book)
//        }
         holder.optionsMenu.setOnClickListener {view ->
             val popupMenu=PopupMenu(context,view)
             popupMenu.menuInflater.inflate(R.menu.menu_favorite,popupMenu.menu)
             popupMenu.setOnMenuItemClickListener { menuItem ->
                 when (menuItem.itemId) {
                     R.id.afficher -> {
                         Toast.makeText(context, "Continue clicked on ", Toast.LENGTH_SHORT).show()
                         true
                     }
                     R.id.supprimer -> {
//                         val builder = AlertDialog.Builder(context!!)
//                         builder.setTitle("Confirmation")
//                         builder.setMessage("voulez vous supprimer book au favorite")
//                         builder.setPositiveButton("Oui") { dialog, _ ->
//                             fav.removeAt(position)
//                             notifyItemRemoved(position)
//                         }
//                         builder.setNegativeButton("Non") { dialog, _ ->
//                             dialog.dismiss()
//                         }
//                         builder.show()
                         val dialog=Dialog(context!!)
                         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                         dialog.setCancelable(false)
                         dialog.setContentView(R.layout.dialoge)
                         dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                          val btnOui:Button=dialog.findViewById(R.id.btnOui)
                         val btnNon:Button=dialog.findViewById(R.id.btnNon)
                         btnOui.setOnClickListener {
                             fav.removeAt(position)
                             notifyItemRemoved(position)
                             dialog.dismiss()
                         }
                         btnNon.setOnClickListener {
                             dialog.dismiss()
                         }
                         dialog.show()
                         true
                     }
                     else -> false
                 }


             }


             popupMenu.show()

         }

        }
}




