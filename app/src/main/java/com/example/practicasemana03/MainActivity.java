package com.example.practicasemana03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAzul;
    private Button btnBlanco;
    private Button btnNegro;
    private ConstraintLayout root;


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = getSharedPreferences("boton", MODE_PRIVATE);
        String color = preferences.getString("color", "#FFFFFF");
        root.setBackgroundColor(Color.parseColor(color));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        btnAzul = findViewById(R.id.btnAzul);
        btnBlanco = findViewById(R.id.btnBlanco);
        btnNegro = findViewById(R.id.btnNegro);
        root = findViewById(R.id.root);

        SharedPreferences preferences = getSharedPreferences("boton", MODE_PRIVATE);
        //Click azul
        btnAzul.setOnClickListener(
                (v)->{
                    preferences.edit().putString("color", "#3b83bd").apply();
                  Intent a = new Intent(this, NombreActivity.class);
                  startActivity(a);
                  finish();
                }
        );

        //Click Blanco
        btnBlanco.setOnClickListener(
                (v)->{
                    preferences.edit().putString("color", "#e7d3af").apply();
                    Intent b = new Intent(this, NombreActivity.class);
                    startActivity(b);
                    finish();

                }
        );

        //Click Negro
        btnNegro.setOnClickListener(
                (v)->{
                    preferences.edit().putString("color", "#9c9c9c").apply();
                    Intent n = new Intent(this, NombreActivity.class);
                    startActivity(n);
                    finish();
                }
        );
    }
}