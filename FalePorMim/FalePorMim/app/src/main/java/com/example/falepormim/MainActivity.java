package com.example.falepormim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TTS tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edText);
        button=findViewById(R.id.button);
        tts = new TTS(this);
        button.setOnClickListener(v->{
            String s=editText.getText().toString();
            tts.speak(s);
        });


    }
}