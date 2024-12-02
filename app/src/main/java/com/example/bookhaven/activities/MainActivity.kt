package com.example.bookhaven.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookhaven.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn1=findViewById<Button>(R.id.button1)
        val btn2=findViewById<Button>(R.id.button2)
        val btn3=findViewById<Button>(R.id.button3)
        btn1.setOnClickListener {
           val intent=Intent(this, favorite::class.java)
                startActivity(intent)

        }
        btn2.setOnClickListener {
            val intent=Intent(this, quotes::class.java)
            startActivity(intent)

        }
        btn3.setOnClickListener {
            val intent=Intent(this, categorie::class.java)
            startActivity(intent)
        }

    }
}