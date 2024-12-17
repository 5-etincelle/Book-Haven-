package com.example.bookhaven.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.example.bookhaven.R
import com.example.bookhaven.adapters.CategorieAdapter
import com.example.bookhaven.book
import com.example.bookhaven.data.Book
import com.example.bookhaven.data.fav
import com.example.bookhaven.data.list

class categorie : AppCompatActivity() {
     lateinit var recherch:EditText
    lateinit var gridView:GridView
    lateinit var adap1:CategorieAdapter
    lateinit var adap2:CategorieAdapter
    lateinit var adap3:CategorieAdapter
    lateinit var adap4:CategorieAdapter
    lateinit var adap5:CategorieAdapter
    lateinit var listBook:List<Book>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_categorie)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        list = mutableListOf(
//            Book(
//                R.drawable.book6," book 1","titel book  1",1992,"5/5","It looks like you just wrote text.How can I assist you with it?How can I assist you with it?" +
//                        "\" How can I assist you with it? ","description pour le contenu","Romance","300"),
//            Book(
//                R.drawable.book3," book 2","titel book  2",1992,"5/5","It looks like you just wrote text.How can I assist you with it?How can I assist you with it?" +
//                        "\" How can I assist you with it? ","description pour le contenu","Romance","300"),
//            Book(
//                R.drawable.book3,"name book 3","titel book  3",1992,"5/5","It looks like you just wrote text.How can I assist you with it?How can I assist you with it?" +
//                        "\" How can I assist you with it? ","description pour le contenu","Romance","300"),
//            Book(
//                R.drawable.book6,"name book 4","titel book  4",1992,"5/5","It looks like you just wrote text.How can I assist you with it?How can I assist you with it?" +
//                        "\" How can I assist you with it? ","description pour le contenu","Thriller","300"),
//            Book(
//                R.drawable.book3,"name book 5","titel book  5",1992,"5/5","It looks like you just wrote text.How can I assist you with it?How can I assist you with it?" +
//                        "\" How can I assist you with it? ","description pour le contenu","History","300"),
//        )
        recherch=findViewById(R.id.barRecherche)

        val rec=intent.getStringExtra("genre")
       listBook=list.filter { it.genre==rec }
        gridView=findViewById(R.id.gridview)
        adap2=CategorieAdapter(this,listBook)
        registerForContextMenu(gridView)

        gridView.adapter=adap2
        gridView.setOnItemClickListener { parent, view, position, id ->
            Intent(this, book::class.java).also {
                startActivity(it)
            }
        }
        registerForContextMenu(gridView)

        recherch.doAfterTextChanged {
            val filtr= list.filter { it.name.startsWith(recherch.text.toString(),ignoreCase = true) }
            adap2=CategorieAdapter(this,filtr)
            gridView.adapter=adap2
        }
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.menu_listbook_home,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info:AdapterView.AdapterContextMenuInfo=item.menuInfo as AdapterView.AdapterContextMenuInfo
        val position:Int=info.position

        when(item.itemId){
            R.id.afficher ->{
//                Toast.makeText(this,"afficher element serat position $position",Toast.LENGTH_SHORT).show()
//                //pour envoyer le titre a autre activity et start activity
//                Intent(this,post_activity::class.java).also{
//                    it.putExtra("titre",postArray[position].titre)
//                    startActivity(it)
//                }
            }
            R.id.ajouter ->{
                fav.add(listBook[position])
                if(fav.contains(listBook[position])){
                    Toast.makeText(this,"book deja ajouter au favorite", Toast.LENGTH_SHORT).show()

                }else{
                    fav.add(listBook[position])
                    Toast.makeText(this,"book ajouter au favorite", Toast.LENGTH_SHORT).show()
                }


            }
        }
        return super.onContextItemSelected(item)
    }
}