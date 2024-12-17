package com.example.bookhaven

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookhaven.adapters.Favorite_Adapter
import com.example.bookhaven.data.list

class book : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       val image=findViewById<ImageView>(R.id.bookimage)
        val namebook=findViewById<TextView>(R.id.namebook)
        val nameauthor=findViewById<TextView>(R.id.nameauthorbook)
        val evaluationBook=findViewById<TextView>(R.id.evaluationBook)
        val genrebook=findViewById<TextView>(R.id.genreBook)
        val pagesBook=findViewById<TextView>(R.id.pagesBook)
        val desdescriptionBook=findViewById<TextView>(R.id.descriptionBook)
        val year=findViewById<TextView>(R.id.yearBook)


        val imageBookRec=intent.getIntExtra("image",R.drawable.the_sevn_habits)
        val nameBookRec=intent.getStringExtra("namebook")
        val nameauthorBookRecu=intent.getStringExtra("nameauthorBook")
        val evaluationBookRecu=intent.getStringExtra("evaluationBook")
        val pagesBookRecu=intent.getStringExtra("pagesBook")
        val genreBookRecu=intent.getStringExtra("genreBook")
        val descriptionBookRecu=intent.getStringExtra("descriptionBook")
        val yearRecu=intent.getStringExtra("year").toString()


        image.setImageResource(imageBookRec)
        namebook.text=nameBookRec
        nameauthor.text=nameauthorBookRecu
        evaluationBook.text=evaluationBookRecu
        genrebook.text=genreBookRecu
        pagesBook.text=pagesBookRecu
        desdescriptionBook.text=descriptionBookRecu
        year.text=yearRecu

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bottom,menu)
        return super.onCreateOptionsMenu(menu)
    }
}
