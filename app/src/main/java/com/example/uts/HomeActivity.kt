package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.uts.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        replaceFragment(HomeFragment())

        binding.btnHome.setOnClickListener {
            replaceFragment(HomeFragment())
        }

        binding.btnBerita.setOnClickListener {
            replaceFragment(BeritaFragment())
        }

        binding.btnProfile.setOnClickListener {
            replaceFragment(ProfileFragment())
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
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