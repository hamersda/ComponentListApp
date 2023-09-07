package com.projectIntro.componentlistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKomponens : RecyclerView
    private val list = ArrayList<Komponen>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKomponens = findViewById(R.id.rv_komponens)
        rvKomponens.setHasFixedSize(true)

        list.addAll(getListKomponens())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean{
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_list ->{
                rvKomponens.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvKomponens.layoutManager = GridLayoutManager(this,2)
            }
            R.id.about -> {
                startActivity(
                    Intent(this@MainActivity, AboutActivity::class.java)
                )
            }
        }
        return true
    }

    private fun getListKomponens(): ArrayList<Komponen>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listKomponen = ArrayList<Komponen>()
        for (i in dataName.indices){
            val komponen = Komponen(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listKomponen.add(komponen)
        }
        return listKomponen
    }

    private fun showSelectedKomponen (komponen: Komponen){
        Toast.makeText(this, "Kamu memilih " + komponen.name, Toast.LENGTH_SHORT).show()
    }

    private fun showRecyclerList(){
        rvKomponens.layoutManager = LinearLayoutManager(this)
        val listKomponenAdapter = ListKomponenAdapter(list)
        rvKomponens.adapter = listKomponenAdapter

        listKomponenAdapter.setOnItemClickCallback(object : ListKomponenAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Komponen){
                showSelectedKomponen(data)
            }
        })
    }
}