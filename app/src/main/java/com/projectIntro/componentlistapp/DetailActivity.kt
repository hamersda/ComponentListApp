package com.projectIntro.componentlistapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

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

        val dataKomponenInfo = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<KomponenInfo>("key_komponen_info", KomponenInfo::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<KomponenInfo>("key_komponen_info")
        }
        val nameKomponen = findViewById<TextView>(R.id.nameKomponen)
        val descriptionItem = findViewById<TextView>(R.id.descriptionItem)
        val imageKomponen = findViewById<ImageView>(R.id.imageKomponen)
        val voltageInfo = findViewById<TextView>(R.id.tv_voltage_detail)
        val currentInfo = findViewById<TextView>(R.id.tv_current_detail)
        val typeInfo = findViewById<TextView>(R.id.tv_type_detail)

        if (dataKomponen!= null){
            nameKomponen.text = dataKomponen.name
            descriptionItem.text = dataKomponen.description
            imageKomponen.setImageResource(dataKomponen.photo)
        }

        if (dataKomponenInfo!= null){
            voltageInfo.text = dataKomponenInfo.voltage
            currentInfo.text = dataKomponenInfo.current
            typeInfo.text = dataKomponenInfo.type
        }

        //Button Action
        val btnShare = findViewById<Button>(R.id.action_share)
        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Konten Dibagikan")
            startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
        }
    }
}