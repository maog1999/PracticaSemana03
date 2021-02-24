package com.example.practicasemana03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView feedbackText;
    private TextView notaInput;
    private Button otravezBtn;
    private ConstraintLayout root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        //Referenciar
        feedbackText = findViewById(R.id.feedbackText);
        notaInput = findViewById(R.id.notaInput);
        otravezBtn = findViewById(R.id.otravezBtn);
        root = findViewById(R.id.root);

        String notaFinal = getIntent().getExtras().getString("notaFinal");
        notaInput.setText(notaFinal);

        String infoUser = getIntent().getExtras().getString("user");
        feedbackText.setText("Hola "+ infoUser + ". Tu nota final es de");

        Log.e("-Nu->",""+notaFinal);


        otravezBtn.setOnClickListener(
                v -> {
                    Intent n = new Intent(this, MainActivity.class);
                    startActivity(n);
                    finish();
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("boton",MODE_PRIVATE);
        String color = preferences.getString("color","#FFFFFF");
        root.setBackgroundColor(Color.parseColor(color));
    }
}