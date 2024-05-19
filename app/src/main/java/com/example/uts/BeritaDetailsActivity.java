package com.example.uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class BeritaDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_details);

        String judul = getIntent().getStringExtra("judul");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String imageUrl = getIntent().getStringExtra("imageUrl");
        String beritaContent = getIntent().getStringExtra("beritaContent");

        TextView tvJudul = findViewById(R.id.tvJudul);
        TextView tvDeskripsi = findViewById(R.id.tvDeskripsi);
        TextView tvBeritaContent = findViewById(R.id.tvBeritaContent);
        ImageView ivBerita = findViewById(R.id.ivBerita);

        tvJudul.setText(judul);
        tvDeskripsi.setText(deskripsi);
        tvBeritaContent.setText(beritaContent);
        Glide.with(this).load(imageUrl).into(ivBerita);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.tambah_data) {
            Intent intent = new Intent(this, AlumniTambahDataActivity.class);
            Toast.makeText(this, "Tambah Data", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.data_alumni) {
            Toast.makeText(this, "Data Alumni", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.logout) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Logged Out!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
