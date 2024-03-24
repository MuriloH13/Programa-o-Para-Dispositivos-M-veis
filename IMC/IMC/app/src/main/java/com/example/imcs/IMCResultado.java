package com.example.imcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class IMCResultado extends AppCompatActivity {

    TextView tvResultado;

    ImageView imageViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        tvResultado=findViewById(R.id.tvResultadoIMC);// associei a variável local ao view na tela

        Intent intent = getIntent(); // recuperamos a intenção que veio atividade anterior
        Bundle bundle = intent.getExtras();//
        bundle.getString("imc");// recuperamos o valor do imc que foi passado na intenção

        tvResultado.setText(bundle.getString("imc"));// setamos o valor do imc no TextView

        double res = Double.parseDouble(tvResultado.getText().toString());// convertemos o valor do imc para double

        imageViewResultado=findViewById(R.id.ImageViewResultado);// associamos a variável local ao view na tela
        if(res < 18.5) {
            imageViewResultado.setImageResource(R.drawable.abaixopeso);
        }
        if(res >= 18.5 && res <= 24.9) {
            imageViewResultado.setImageResource(R.drawable.normal);
        }
        if(res >= 25 && res <= 29.9) {
            imageViewResultado.setImageResource(R.drawable.sobrepeso);
        }
        if(res >= 30 && res <= 34.9) {
            imageViewResultado.setImageResource(R.drawable.obesidade1);
        }
        if(res >= 35 && res <= 39.9) {
            imageViewResultado.setImageResource(R.drawable.obesidade2);
        }
        if(res >= 40) {
            imageViewResultado.setImageResource(R.drawable.obesidade3);
        }
    }
}