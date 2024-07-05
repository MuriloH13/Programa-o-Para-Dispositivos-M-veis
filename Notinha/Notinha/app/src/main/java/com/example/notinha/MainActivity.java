package com.example.notinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText edtext;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("minhasnotinhas", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT,txt VARCHAR);");
        ContentValues cv = new ContentValues();
        cv.put("txt", "Baunilha");
        db.insert("notas", null, cv);
        edtext = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        findViewById(R.id.btnSalvar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtext.getText().toString();
                cv.put("txt", text);
                db.insert("notas", null, cv);
                listaNotas();

            }
        });
        listaNotas();
    }

    public void listaNotas() {
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<String> listaNotas = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            listaNotas.add(Integer.toString(cursor.getInt(0)) + cursor.getString(1));
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNotas);
        listView.setAdapter(adapter);
    }
}