package com.example.bookhaven.login_register

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bookhaven.R
import com.example.bookhaven.activities.MainActivity
import com.example.bookhaven.dao
import com.example.bookhaven.data.Personne
import kotlin.math.sign

class login_kotlin : AppCompatActivity() {
    val o1 = dao(mutableListOf(Personne(1,"ayoub","ayoub"), Personne(2,"admin","admin")))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page_layout)
        val btnSignIn = findViewById<Button>(R.id.btnL1)
        val signup = findViewById<TextView>(R.id.signUp)
        btnSignIn.setOnClickListener {
            val username = findViewById<EditText>(R.id.userName).text.toString()
            val password = findViewById<EditText>(R.id.passWord).text.toString()
            if ((username.isNotEmpty() && password.isNotEmpty()) && o1.check(username,password)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else Toast.makeText(this, "Empty input", Toast.LENGTH_LONG).show()
        }
        signup.setOnClickListener{
            val intent = Intent(this, signUp::class.java)
            startActivity(intent)
        }

    }
}