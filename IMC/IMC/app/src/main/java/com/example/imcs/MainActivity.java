package com.example.imcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imcs.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText edPeso, edAltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPeso = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);
    }

    public void calcularIMC(View view){
        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());
        DecimalFormat df = new DecimalFormat("##.##");
        double imc = peso / (altura * altura);
        String resultado = df.format(imc);

        Toast.makeText(this, "IMC: " + resultado, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), IMCResultado.class);
        intent.putExtra("imc", resultado);
        startActivity(intent);
    }
}