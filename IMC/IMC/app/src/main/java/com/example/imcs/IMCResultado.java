package com.example.imcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class IMCResultado extends AppCompatActivity {

    TextView tvResultado, tvPeso, tvAltura, tvNome;

    ImageView imageViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        imageViewResultado = findViewById(R.id.ImageViewResultado);
        tvAltura = findViewById(R.id.labelRAltura);
        tvPeso = findViewById(R.id.labelRPeso);
        tvNome = findViewById(R.id.labelRNome);
        tvResultado=findViewById(R.id.valorIMC);//

        Intent intent = getIntent(); // recuperamos a intenção que veio atividade anterior
        Bundle bundle = intent.getExtras();//

        Float peso, altura, imc;
        String nome;
        peso = bundle.getFloat("peso");
        altura = bundle.getFloat("altura");
        nome = bundle.getString("nome");
        imc = bundle.getFloat("imc");
        imc = peso / (altura * altura);

        tvAltura.setText(altura.toString());
        tvPeso.setText(peso.toString());
        tvResultado.setText(imc.toString());
        tvNome.setText(nome.toString());

        if (imc<18.5) {
            Toast.makeText(this, "Abaixo do peso", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.abaixopeso);
            tvResultado.setText("Abaixo do peso");
        } else if (imc>18.5 && imc<24.9){
            Toast.makeText(this, "Peso normal", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.normal);
            tvResultado.setText("Peso normal");
        }else if (imc>24.9 && imc<29.9){
            Toast.makeText(this, "Sobrepeso", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.sobrepeso);
            tvResultado.setText("Sobrepeso");
        }else if (imc>30 && imc<34.9){
            Toast.makeText(this, "Obesidade grau 1", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.obesidade1);
            tvResultado.setText("Obesidade grau 1");
        } else if (imc>35 && imc<39.9){
            Toast.makeText(this, "Obesidade grau 2", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.obesidade2);
            tvResultado.setText("Obesidade grau 2");
        }else if (imc>40){
            Toast.makeText(this, "Obesidade grau 3", Toast.LENGTH_SHORT).show();
            imageViewResultado.setImageResource(R.drawable.obesidade3);
            tvResultado.setText("Obesidade grau 3");
        }

    }
}