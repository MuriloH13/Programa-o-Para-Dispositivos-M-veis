package com.example.aplicacaobdd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    EditText edNome;
    ListView lista;
    Button btnCadastrar;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNome = findViewById(R.id.txtNome);
        lista = findViewById(R.id.Lista);
        btnCadastrar = findViewById(R.id.btn);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edNome.getText().toString();
                inserirNota(s);
                carregarListaNova();
            }
        });
        configDatabase();

    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarListaNova();
    }

    public void configDatabase(){
        db = openOrCreateDatabase("dbTabela",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Notas " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "txt TEXT);");
    }
    @SuppressLint("Range")
    public ArrayList<Nota> recuperarNotas() {
        ArrayList<Nota> notas = new ArrayList<Nota>();
        Cursor c = db.rawQuery("Select * from notas", null);
        c.moveToFirst();
        int id;
        String txt;
        while (!c.isAfterLast()) {
            id = c.getInt(c.getColumnIndex("id"));
            txt = c.getString(c.getColumnIndex("txt"));
            Nota nota = new Nota(id,txt);
            notas.add(nota);
            c.moveToNext();
        }
        return notas;
    }

    public ArrayList<String> notasTXT(ArrayList<Nota> notas){
        ArrayList<String> notasTXT = new ArrayList<String>();
    for(Nota nota : notas){
        notasTXT.add(nota.txt);
    }
    return notasTXT;
    }

    public void carregarListaNova(){
        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notasTXT(recuperarNotas())

        );
        lista.setAdapter(adapter);
    }

}