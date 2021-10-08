package com.carlos.a5_registrodesocios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pasamos los parametros
        Button btnguardar = findViewById(R.id.btnGuardar);
        EditText txtNombre = findViewById(R.id.nombre_socio);
        EditText txtApellido = findViewById(R.id.apellido_socio);
        RatingBar rating = findViewById(R.id.rtbUno);

        btnguardar.setOnClickListener(view -> {

            String nombreSocio = txtNombre.getText().toString();
            String apellidoSocio = txtApellido.getText().toString();
            Float puntuacion = rating.getRating();

            Intent irDetalle = new Intent(this,Detail_Activity.class);
            startActivity(irDetalle);


        });

    }
  }