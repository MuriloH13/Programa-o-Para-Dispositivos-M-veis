package com.example.aplicacaobdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    EditText edNome;
    ListView lista;
    Button btnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNome=findViewById(R.id.txtNome);

        db = openOrCreateDatabase("dbTabela",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Tabela(id INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT);");
        String msg = "Hello";

        ContentValues CV = new ContentValues();
        CV.put("nome", "Valor");

        db.insert("tabela",null, CV);
        db.update("tabela",CV, null, null);

        String s = new String("SQL");

        Cursor c = db.rawQuery(s, null);
        c.moveToFirst();
        s=c.getString(c.getColumnIndex("txt"));
    }

}