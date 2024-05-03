package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExibeActivity extends AppCompatActivity {

    ImageView imageViewMoto;
    TextView motoTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        motoTxt=findViewById(R.id.textViewExibe);
        String moto = i.getStringExtra("motos");
        imageViewMoto = findViewById(R.id.imageView);

        if(moto.equals("XJ6(2023)")){
            imageViewMoto.setImageResource(R.drawable.XJ6);
            motoTxt.setText("XJ6(2023)");
        }

    }
}
