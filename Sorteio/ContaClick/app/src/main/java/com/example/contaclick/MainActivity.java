package com.example.contaclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    EditText EdMin, EdMax;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdMin = findViewById(R.id.EditMin);
        EdMax = findViewById(R.id.EditMax);
        tvResult = findViewById(R.id.textView);
    }

    public void randNumber(View v){
        int min, max;
        min =Integer.parseInt(EdMin.getText().toString());
        max =Integer.parseInt(EdMax.getText().toString());
        Random r = new Random();
        int resultado = r.nextInt(max - min + 1)+min;
        tvResult.setText(Integer.toString(resultado));
    }
    public void Count(View v){
    i++;
        TextView tv = (TextView) v;
        tv.setText(Integer.toString(i));
    }

}