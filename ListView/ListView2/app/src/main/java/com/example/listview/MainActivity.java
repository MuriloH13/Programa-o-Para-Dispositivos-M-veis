package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] nomes = new String[]{ "XJ6(2023)", "kawasaki ninja h2r(2024)", "NXR 160 Bros ESDD(2024)", "FAZER FZ25 ABS", "XT 660R(2014)", "CB600F" };
    ListView lv;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                R.layout.item_lista,
                R.id.textViewNome,
                nomes

        );
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("clickitem", Integer.toString(i));
                Log.d("clickitem", nomes[i]);
                Bundle b = new Bundle();
                b.putString("nome", nomes[i]);
                Intent intent = new Intent(getApplicationContext(), ExibeActivity.class);
                intent.putExtra("posicao", i);
                startActivity(intent);
            }
        });
    }
}