package com.example.uts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.profile_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etNim = view.findViewById<EditText>(R.id.etNim)
        val etNama = view.findViewById<EditText>(R.id.etNama)
        val etKelas = view.findViewById<EditText>(R.id.etKelas)

        // Retrieve SharedPreferences
        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        // Get values using keys
        val email = sharedPreferences.getString("Email", "")
        val nim = sharedPreferences.getString("Nim", "")
        val nama = sharedPreferences.getString("Nama", "")
        val kelas = sharedPreferences.getString("Kelas", "")

        // Set values to UI elements
        etEmail.setText(email)
        etNim.setText(nim)
        etNama.setText(nama)
        etKelas.setText(kelas)

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(requireContext(), "Logged Out!", Toast.LENGTH_SHORT).show()
        }
    }

}