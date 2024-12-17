package com.example.bookhaven.activities

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookhaven.R
import com.example.bookhaven.data.Personne
import com.example.bookhaven.login_register.login_kotlin


class Splash_Activities : AppCompatActivity() {
    private lateinit var splashProgress: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.slash_2)
        splashProgress = findViewById(R.id.splashProgress)
        playProgress()
        Handler().postDelayed({
            val intent = Intent(this, login_kotlin::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
    fun playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100).setDuration(5000).start()
    }
}
