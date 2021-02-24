package com.example.practicasemana03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NombreActivity extends AppCompatActivity {

    private ConstraintLayout root;
    private Button confiBtn;
    private Button continuarBtn;
    private EditText nameInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        //Referenciar
        root = findViewById(R.id.root);
        confiBtn = findViewById(R.id.confiBtn);
        continuarBtn = findViewById(R.id.continuarBtn);
        nameInput = findViewById(R.id.nameInput);


        //Click paso de pantalla y pasar Input info
        continuarBtn.setOnClickListener(
                (v)->{
                    Intent n = new Intent(this, NotasActivity.class);
                    n.putExtra("user",nameInput.getText().toString());
                    startActivity(n);
                    finish();
                }
        );

        confiBtn.setOnClickListener(
                v->{
                    Intent a = new Intent(this, MainActivity.class);
                    startActivity(a);
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