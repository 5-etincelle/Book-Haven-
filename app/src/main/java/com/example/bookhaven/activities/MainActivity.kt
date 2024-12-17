package com.example.bookhaven.activities

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.ClipData.Item
import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bookhaven.FavoriteFragment
import com.example.bookhaven.Home
import com.example.bookhaven.HomeFragment
import com.example.bookhaven.QuotesFragment
import com.example.bookhaven.R
import com.example.bookhaven.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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



    bottomNavigationView=findViewById(R.id.botton_navigation)

    bottomNavigationView.setOnItemSelectedListener { menuItem->
        when(menuItem.itemId){
            R.id.bottom_Home ->{
                replaceFragment(HomeFragment())
//                Intent(this,Home::class.java).also {
//                    startActivity(it)
//                }
                true
            }
            R.id.bottom_favorite ->{
                replaceFragment(FavoriteFragment())
//                Intent(this,quotes::class.java).also {
//                    startActivity(it)
//                }
                true
            }
            R.id.bottom_setting ->{
                replaceFragment(SettingFragment())
                true
            }
            R.id.bottom_quotes ->{
                replaceFragment(QuotesFragment())
//                Intent(this,quotes::class.java).also {
//                    startActivity(it)
//                }
                true
            }


            else -> false
        }
    }
replaceFragment(HomeFragment())

    }

      fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }

}