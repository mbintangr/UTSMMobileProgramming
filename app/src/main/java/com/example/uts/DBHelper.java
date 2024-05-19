package com.example.uts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBName = "dataAlumni.db";

    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table alumni(nim TEXT primary key, nama TEXT, tempatLahir TEXT, tanggalLahir DATE, alamat TEXT, agama TEXT, noTelp TEXT, tahunMasuk TEXT, tahunLulus TEXT, pekerjaan TEXT, jabatan TEXT)");
        insertDummyData();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists alumni");
        onCreate(db);
    }

    public void insertDummyData() {
        insertData("123456", "John Doe", "New York", "1990-01-01", "123 Elm St", "Christianity", "1234567890", "2008", "2012", "Software Engineer", "Senior Developer");
        insertData("654321", "Jane Smith", "Los Angeles", "1992-02-02", "456 Oak St", "Islam", "0987654321", "2009", "2013", "Data Scientist", "Lead Data Scientist");
        insertData("112233", "Michael Johnson", "Chicago", "1988-03-03", "789 Pine St", "Hinduism", "1122334455", "2007", "2011", "Product Manager", "Product Lead");
        insertData("445566", "Emily Davis", "Houston", "1993-04-04", "101 Maple St", "Buddhism", "6677889900", "2010", "2014", "UX Designer", "Senior UX Designer");
        insertData("778899", "Daniel Brown", "Phoenix", "1991-05-05", "202 Birch St", "Atheism", "2233445566", "2008", "2012", "DevOps Engineer", "Lead DevOps Engineer");
    }

    public void insertData(String nim, String nama, String tempatLahir, String tanggalLahir, String alamat, String agama, String noTelp, String tahunMasuk, String tahunLulus, String pekerjaan, String jabatan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nim", nim);
        contentValues.put("nama", nama);
        contentValues.put("tempatLahir", tempatLahir);
        contentValues.put("tanggalLahir", tanggalLahir);
        contentValues.put("alamat", alamat);
        contentValues.put("agama", agama);
        contentValues.put("noTelp", noTelp);
        contentValues.put("tahunMasuk", tahunMasuk);
        contentValues.put("tahunLulus", tahunLulus);
        contentValues.put("pekerjaan", pekerjaan);
        contentValues.put("jabatan", jabatan);
        db.insert("alumni", null, contentValues);
    }

    public Cursor getAllAlumni() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT nim, nama FROM alumni", null);
    }

    public Cursor getAlumniByNim(String nim) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM alumni WHERE nim = ?", new String[]{nim});
    }

    public void deleteAlumniByNim(String nim) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("alumni", "nim = ?", new String[]{nim});
    }

    public void editAlumniByNim(String nim, String nama, String tempatLahir, String tanggalLahir, String alamat, String agama, String noTelp, String tahunMasuk, String tahunLulus, String pekerjaan, String jabatan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", nama);
        contentValues.put("tempatLahir", tempatLahir);
        contentValues.put("tanggalLahir", tanggalLahir);
        contentValues.put("alamat", alamat);
        contentValues.put("agama", agama);
        contentValues.put("noTelp", noTelp);
        contentValues.put("tahunMasuk", tahunMasuk);
        contentValues.put("tahunLulus", tahunLulus);
        contentValues.put("pekerjaan", pekerjaan);
        contentValues.put("jabatan", jabatan);

        db.update("alumni", contentValues, "nim = ?", new String[]{nim});
    }


}
