package com.example.uts

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class AlumniTambahDataActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var dbHelper: DBHelper
    private lateinit var etNim: EditText
    private lateinit var etNamaAlumni: EditText
    private lateinit var etTempatLahir: EditText
    private lateinit var etTanggalLahir: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etAgama: EditText
    private lateinit var etNoTelp: EditText
    private lateinit var etTahunMasuk: EditText
    private lateinit var etTahunLulus: EditText
    private lateinit var etPekerjaan: EditText
    private lateinit var etJabatan: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alumni_tambah_data)

        dbHelper = DBHelper(this)

        etNim = findViewById(R.id.etNim)
        etNamaAlumni = findViewById(R.id.etNamaAlumni)
        etTempatLahir = findViewById(R.id.etTempatLahir)
        etTanggalLahir = findViewById(R.id.etTanggalLahir)
        etAlamat = findViewById(R.id.etAlamat)
        etAgama = findViewById(R.id.etAgama)
        etNoTelp = findViewById(R.id.etNoTelp)
        etTahunMasuk = findViewById(R.id.etTahunMasuk)
        etTahunLulus = findViewById(R.id.etTahunLulus)
        etPekerjaan = findViewById(R.id.etPekerjaan)
        etJabatan = findViewById(R.id.etJabatan)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val nim = intent.getStringExtra("nim")
        if (nim != null) {
            loadAlumniData(nim)
        }

        etTanggalLahir = findViewById(R.id.etTanggalLahir)
        val btnTanggalLahir: Button = findViewById(R.id.btnTanggalLahir)
        btnTanggalLahir.setOnClickListener {
            showDatePickerDialog()
        }

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            val nim = findViewById<EditText>(R.id.etNim).text.toString()
            val nama = findViewById<EditText>(R.id.etNamaAlumni).text.toString()
            val tempatLahir = findViewById<EditText>(R.id.etTempatLahir).text.toString()
            val tanggalLahir = findViewById<EditText>(R.id.etTanggalLahir).text.toString()
            val alamat = findViewById<EditText>(R.id.etAlamat).text.toString()
            val agama = findViewById<EditText>(R.id.etAgama).text.toString()
            val noTelp = findViewById<EditText>(R.id.etNoTelp).text.toString()
            val tahunMasuk = findViewById<EditText>(R.id.etTahunMasuk).text.toString()
            val tahunLulus = findViewById<EditText>(R.id.etTahunLulus).text.toString()
            val pekerjaan = findViewById<EditText>(R.id.etPekerjaan).text.toString()
            val jabatan = findViewById<EditText>(R.id.etJabatan).text.toString()

            dbHelper.insertData(nim, nama, tempatLahir, tanggalLahir, alamat, agama, noTelp, tahunMasuk, tahunLulus, pekerjaan, jabatan)
            finish()
        }
    }

    private fun loadAlumniData(nim: String) {
        val cursor = dbHelper.getAlumniByNim(nim)
        if (cursor.moveToFirst()) {
            etNim.setText(cursor.getString(cursor.getColumnIndexOrThrow("nim")))
            etNamaAlumni.setText(cursor.getString(cursor.getColumnIndexOrThrow("nama")))
            etTempatLahir.setText(cursor.getString(cursor.getColumnIndexOrThrow("tempatLahir")))
            etTanggalLahir.setText(cursor.getString(cursor.getColumnIndexOrThrow("tanggalLahir")))
            etAlamat.setText(cursor.getString(cursor.getColumnIndexOrThrow("alamat")))
            etAgama.setText(cursor.getString(cursor.getColumnIndexOrThrow("agama")))
            etNoTelp.setText(cursor.getString(cursor.getColumnIndexOrThrow("noTelp")))
            etTahunMasuk.setText(cursor.getString(cursor.getColumnIndexOrThrow("tahunMasuk")))
            etTahunLulus.setText(cursor.getString(cursor.getColumnIndexOrThrow("tahunLulus")))
            etPekerjaan.setText(cursor.getString(cursor.getColumnIndexOrThrow("pekerjaan")))
            etJabatan.setText(cursor.getString(cursor.getColumnIndexOrThrow("jabatan")))
        }
        cursor.close()
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, this, year, month, dayOfMonth).show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = "$year-${month + 1}-$dayOfMonth"
        etTanggalLahir.setText(selectedDate)
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