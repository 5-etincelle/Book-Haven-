package com.example.bookhaven.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bookhaven.FavoriteFragment
import com.example.bookhaven.HomeFragment
import com.example.bookhaven.R
import com.example.bookhaven.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
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
//        val btn1=findViewById<Button>(R.id.button1)
//        val btn2=findViewById<Button>(R.id.button2)
//        val btn3=findViewById<Button>(R.id.button3)
//        btn1.setOnClickListener {
//           val intent=Intent(this, favorite::class.java)
//                startActivity(intent)
//
//        }
//        btn2.setOnClickListener {
//            val intent=Intent(this, quotes::class.java)
//            startActivity(intent)
//
//        }
//        btn3.setOnClickListener {
//            val intent=Intent(this, categorie::class.java)
//            startActivity(intent)
//        }

    bottomNavigationView=findViewById(R.id.botton_navigation)
    bottomNavigationView.setOnItemSelectedListener { menuItem->
        when(menuItem.itemId){
            R.id.bottom_Home ->{
                replaceFragment(HomeFragment())
                true
            }
            R.id.bottom_favorite ->{
                replaceFragment(FavoriteFragment())
                true
            }
            R.id.bottom_setting ->{
                replaceFragment(SettingFragment())
                true
            }
            else -> false
        }
    }
        replaceFragment(HomeFragment())
    }
    private  fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }
}