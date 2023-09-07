package com.projectIntro.componentlistapp

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataKomponen = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Komponen>("key_komponen", Komponen::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Komponen>("key_komponen")
        }
        val nameKomponen = findViewById<TextView>(R.id.nameKomponen)
        val descriptionItem = findViewById<TextView>(R.id.descriptionItem)
        val imageKomponen = findViewById<ImageView>(R.id.imageKomponen)

        if (dataKomponen!= null){
            nameKomponen.text = dataKomponen.name
            descriptionItem.text = dataKomponen.description
            imageKomponen.setImageResource(dataKomponen.photo)
        }
    }
}