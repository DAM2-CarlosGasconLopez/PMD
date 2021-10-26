package com.carlos.a6_dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    RelativeLayout rellay_Calculadora, rellay_Amigos, rellay_Perrete, rellay_quizzes, rellay_galeria, rellay_mapas, rellay_restaurante, rellay_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellay_Calculadora = findViewById(R.id.rellay_calculadora);
        rellay_Amigos = findViewById(R.id.rellay_Friends);
        rellay_Perrete = findViewById(R.id.rellay_perrete);
        rellay_quizzes = findViewById(R.id.rellay_quizzes);
        rellay_galeria = findViewById(R.id.rellay_galery);
        rellay_mapas = findViewById(R.id.rellay_maps);
        rellay_restaurante = findViewById(R.id.rellay_ritorante);
        rellay_settings = findViewById(R.id.rellay_settings);

        // Calculadora
        rellay_Calculadora.setOnClickListener(view -> {
            Intent intent = new Intent(this, Calculadora_Activity.class);
            startActivity(intent);
        });

        // Amigos
        rellay_Amigos.setOnClickListener(view -> {
            Intent intent = new Intent(this, Amigos_Activity.class);
            startActivity(intent);
        });

        //Perrete
        rellay_Perrete.setOnClickListener(view -> {
            Intent intent = new Intent(this, EdadCanina_Activity.class);
            startActivity(intent);
        });

        // Quizzes
        rellay_quizzes.setOnClickListener(view -> {
            Intent intent = new Intent(this, Quizzes_Activity.class);
            startActivity(intent);
        });

        // Galeria
        rellay_galeria.setOnClickListener(view -> {
            Intent intent = new Intent(this, Galeria_Activity.class);
            startActivity(intent);
        });

        // Mapas
        rellay_mapas.setOnClickListener(view -> {
            Intent intent = new Intent(this, Mapas_Activity.class);
            startActivity(intent);
        });

        // Restaurante
        rellay_restaurante.setOnClickListener(view -> {
            Intent intent = new Intent(this, Restaurantes_Activity.class);
            startActivity(intent);
        });

        // Settings
        rellay_settings.setOnClickListener(view -> {
            Intent intent = new Intent(this, Herramientas_Activity.class);
            startActivity(intent);
        });


    }
}