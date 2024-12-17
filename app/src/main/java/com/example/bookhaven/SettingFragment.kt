 package com.example.bookhaven

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


 class SettingFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        // Set click listeners for settings items
        view.findViewById<TextView>(R.id.tvProfile).setOnClickListener {
            // Handle profile settings click
        }

        view.findViewById<TextView>(R.id.tvNotifications).setOnClickListener {
            // Handle notifications settings click
        }

        view.findViewById<TextView>(R.id.tvSecurity).setOnClickListener {
            // Handle security settings click
        }

        view.findViewById<TextView>(R.id.tvLanguage).setOnClickListener {
            // Handle language settings click
        }

        view.findViewById<TextView>(R.id.tvHelp).setOnClickListener {
            // Handle help & support click
        }
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }
}