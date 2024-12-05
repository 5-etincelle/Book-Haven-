package com.example.bookhaven.login_register

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.bookhaven.R

class signUp :AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val email = findViewById<EditText>(R.id.email)
        val username = findViewById<EditText>(R.id.name)
        val password = findViewById<EditText>(R.id.password_register)
        val password_confirm = findViewById<EditText>(R.id.password_register_confirm)
        val num = findViewById<EditText>(R.id.num)


    }
}