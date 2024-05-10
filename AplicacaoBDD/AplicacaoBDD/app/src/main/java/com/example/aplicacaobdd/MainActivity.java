package com.example.aplicacaobdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteDatabase = openOrCreateDatabase("notas",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT);");
        String msg = "Hello";

        ContentValues contentValues = new ContentValues();
        contentValues.put("txt", "Ola Mundo");

        sqLiteDatabase.insert("notas",null,contentValues);
    }
}