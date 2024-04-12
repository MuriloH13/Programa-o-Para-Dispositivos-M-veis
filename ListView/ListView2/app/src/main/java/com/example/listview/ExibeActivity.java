package com.example.listview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExibeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe);
        int position = getIntent().getExtras().getInt("posicao");
        TextView tv = findViewById(R.id.textViewExibe);
        tv.setText(Integer.toString(position));
    }
}
