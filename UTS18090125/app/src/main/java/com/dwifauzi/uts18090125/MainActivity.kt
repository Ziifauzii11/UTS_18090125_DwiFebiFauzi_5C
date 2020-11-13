package com.dwifauzi.uts18090125

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_berita.setOnClickListener {
            val berita = Intent(this, BeritaActivity::class.java)
            startActivity(berita)
        }

        btn_cal.setOnClickListener {
            val cal = Intent(this, KalkulatorActivity::class.java)
            startActivity(cal)
        }

        btn_keluar.setOnClickListener {
            finish();

        }

        btn_about.setOnClickListener {
            val nama = "Dwi Febi Fauzi"
            val nim = "18090125"
            val kelas = "5C"

            val about = Intent(this, AboutActivity::class.java)
            about.putExtra("Nama", nama)
            about.putExtra("NIM", nim)
            about.putExtra("Kelas", kelas)
            startActivity(about)
        }
    }
}