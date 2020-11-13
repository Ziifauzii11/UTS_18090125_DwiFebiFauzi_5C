package com.dwifauzi.uts18090125

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "About Me"

            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        var profile = intent
        val nama = profile.getStringExtra("Nama")
        val nim = profile.getStringExtra("NIM")
        val kelas = profile.getStringExtra("Kelas")

        val tampil_nama = findViewById<TextView>(R.id.id_nama)
        val tampil_nim = findViewById<TextView>(R.id.id_nim)
        val tampil_kelas = findViewById<TextView>(R.id.id_kelas)

        tampil_nama.text = nama
        tampil_nim.text = nim
        tampil_kelas.text = kelas

        img_saya.setOnClickListener {
            Toast.makeText(this, "Foto Saya", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}