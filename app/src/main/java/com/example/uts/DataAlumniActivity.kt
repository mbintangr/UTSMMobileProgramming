package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DataAlumniActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_data_alumni)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        dbHelper = DBHelper(this)

        // Insert dummy data if needed
        //dbHelper.insertDummyData()

        val listView: ListView = findViewById(R.id.listView)
        loadData(listView)

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedAlumni = listView.adapter.getItem(position) as Alumni
            val intent = Intent(this, AlumniDetailsActivity::class.java)
            intent.putExtra("nim", selectedAlumni.nim)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val listView: ListView = findViewById(R.id.listView)
        loadData(listView)
    }

    private fun loadData(listView: ListView) {
        val cursor = dbHelper.getAllAlumni()
        val alumniList = mutableListOf<Alumni>()

        if (cursor.moveToFirst()) {
            do {
                val nim = cursor.getString(cursor.getColumnIndexOrThrow("nim"))
                val nama = cursor.getString(cursor.getColumnIndexOrThrow("nama"))
                alumniList.add(Alumni(nim, nama))
            } while (cursor.moveToNext())
        }
        cursor.close()

        val adapter = AlumniAdapter(this, alumniList)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.tambah_data -> {
                val intent = Intent(this, AlumniTambahDataActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Tambah Data", Toast.LENGTH_SHORT).show()
            }
            R.id.data_alumni -> {
                val intent = Intent(this, DataAlumniActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Data Alumni", Toast.LENGTH_SHORT).show()
            }
            R.id.logout -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Logged Out!", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
