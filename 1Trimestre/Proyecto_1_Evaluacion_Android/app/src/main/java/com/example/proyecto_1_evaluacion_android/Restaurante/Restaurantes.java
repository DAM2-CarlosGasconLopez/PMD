package com.example.proyecto_1_evaluacion_android.Restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyecto_1_evaluacion_android.R;

public class Restaurantes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);

        setTitle("Bares y Restaurantes");
    }
}