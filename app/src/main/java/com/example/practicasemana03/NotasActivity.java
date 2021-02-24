package com.example.practicasemana03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NotasActivity extends AppCompatActivity {

    private EditText pr1Input;
    private EditText pr2Input;
    private EditText quizInput;
    private EditText parcial1Input;
    private EditText parcial2Input;
    private Button btnCalcular;
    private TextView textView4;
    private ConstraintLayout root;
    private String user;
    private Double promedioFinal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        //Referenciar
        pr1Input = findViewById(R.id.pr1Input);
        pr2Input = findViewById(R.id.pr2Input);
        quizInput = findViewById(R.id.quizInput);
        parcial1Input = findViewById(R.id.parcial1Input);
        parcial2Input = findViewById(R.id.parcial2Input);
        btnCalcular = findViewById(R.id.btnCalcular);
        root = findViewById(R.id.root);
        textView4 = findViewById(R.id.textView4);


        //Info user  --- guardarlo como global -- condoble put extra
        user = getIntent().getExtras().getString("user");

        //Click cambio de pantalla
        btnCalcular.setOnClickListener(
                (v)->{
                    Intent c = new Intent(this, FinalActivity.class);
                    c.putExtra("user",user);

                    //Recibir notas
                    String pr1 = pr1Input.getText().toString();
                    double pri1Double = Double.parseDouble(pr1);

                    String pr2 = pr2Input.getText().toString();
                    double pri2Double = Double.parseDouble(pr2);

                    String quiz = quizInput.getText().toString();
                    double quizIn = Double.parseDouble(quiz);

                    String par1 = parcial1Input.getText().toString();
                    double parcial1 = Double.parseDouble(par1);

                    String par2 = parcial2Input.getText().toString();
                    double parcial2 = Double.parseDouble(par2);

                    //Operacion para promedio
                    promedioFinal = (pri1Double + pri2Double + quizIn + parcial1 + parcial2)/5;
                    Log.e("-<->",""+promedioFinal);
                    String promedioFinalSTR = String.valueOf(promedioFinal);
                    c.putExtra("notaFinal", promedioFinalSTR);


                    Log.e("---->", ""+pri1Double);
                    startActivity(c);
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