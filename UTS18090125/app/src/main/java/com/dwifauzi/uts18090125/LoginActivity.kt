package com.dwifauzi.uts18090125

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)


        btn_login.setOnClickListener {
            val nama: String = input_Nama.text.toString()
            val nim: Int = input_nim.text.toString().toInt()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAMA", nama)
            editor.putInt("NIM", nim)
            editor.apply()

            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        button2.setOnClickListener {
            moveTaskToBack(true);
            exitProcess(-1)
        }

    }
}