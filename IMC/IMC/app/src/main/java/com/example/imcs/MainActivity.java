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
    private EditText edPeso, edAltura, edNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPeso = findViewById(R.id.edPeso);
        edAltura = findViewById(R.id.edAltura);
        edNome = findViewById(R.id.edName);
    }

    public void calcularIMC(View view){

        Intent intent = new Intent(this, IMCResultado.class);

        Bundle bundle = new Bundle();

        bundle.putFloat("peso", Float.parseFloat(edPeso.getText().toString()));
        bundle.putFloat("altura", Float.parseFloat(edAltura.getText().toString()));
        bundle.putString("nome", (edNome.getText().toString()));
        intent.putExtras(bundle);

        startActivity(intent);
    }
}