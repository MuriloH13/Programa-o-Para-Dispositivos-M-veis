package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] nomes = new String[]{"Murilo", "Erik", "Gustavo", "Luigi", "Andrei"};

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes
        );

        lv.setAdapter(adapter);
        TratamentoClickItemListaNome itemClick = new TratamentoClickItemListaNome();
        lv.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("clickitem", Integer.toString(i));
                Log.d("clickitem", nomes[i]);
                Bundle b = new Bundle();
                b.putString("nome", nomes[i]);
                Intent i = new Intent(getApplicationContext(), SegundaActivity.class);
                i.putExtras(b);
                startActivity(i);

            }
        });
    }
}