package com.example.bookhaven.login_register

import android.annotation.SuppressLint
import android.app.Dialog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bookhaven.R
import com.example.bookhaven.activities.MainActivity
import com.example.bookhaven.dao
import com.example.bookhaven.data.Personne
import java.util.Timer
import java.util.TimerTask
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper

class signUp :AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    fun dialogerror1()
    {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error ")
        builder.setMessage("check your password you seems like it's not the same ")
        builder.setPositiveButton("OK"){dialog,_,-> dialog.dismiss()}
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }
    fun dialogSuc()
    {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custome_dialog_succ)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.findViewById<Button>(R.id.okButton).setOnClickListener {
            dialog.dismiss()
        }
        dialog.window?.setLayout(800, 500)
        val okButton = dialog.findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            val intent = Intent(this, login_kotlin::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            dialog.dismiss()
        }
        dialog.show()
    }
    fun dialogErr()
    {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custome_dialog_succ)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.findViewById<Button>(R.id.okButton).setOnClickListener {
            dialog.dismiss()
        }
        dialog.window?.setLayout(800, 500)
        val okButton = dialog.findViewById<Button>(R.id.okButton)
        okButton.setOnClickListener {
            val intent = Intent(this, login_kotlin::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            dialog.dismiss()
        }
        dialog.show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val Dao = dao(users)
        val signupBtn = findViewById<Button>(R.id.signUp)
        signupBtn.setOnClickListener{
            val email = findViewById<EditText>(R.id.email).text.toString()
            val username = findViewById<EditText>(R.id.name).text.toString()
            val password = findViewById<EditText>(R.id.password_register).text.toString()
            val password_confirm = findViewById<EditText>(R.id.password_register_confirm).text.toString()
            val num = findViewById<EditText>(R.id.num).toString()
            if (email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty() && password_confirm.isNotEmpty() && num.isNotEmpty()) {
                if (password != password_confirm)
                {
                    dialogerror1()
                }else{
                    val newUser = Personne(0, username, password, email, num)
                    Dao.addUser(newUser)
                    dialogSuc()
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this, login_kotlin::class.java)
                        startActivity(intent)
                    }, 7000)
                }
            }else{
                dialogErr()
            }
        }
    }
}