package com.example.proyecto_1_evaluacion_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto_1_evaluacion_android.Restaurante.Restaurantes;
import com.example.proyecto_1_evaluacion_android.Turismo.TurismoActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    CardView restauranteClick, localizacionClick, actividades, turismoClick, bandosClick, tiempo;
    Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        restauranteClick = findViewById(R.id.restaurante);
        localizacionClick = findViewById(R.id.localizacion);
        //actividades.findViewById(R.id.actividades);
        turismoClick = findViewById(R.id.turismo);
        bandosClick = findViewById(R.id.bandos);
        //tiempo.findViewById(R.id.tiempo);
        btnCerrarSesion = findViewById(R.id.btnBlock);

        //Recuperamos los datos del LoginActivity
        Bundle datos = this.getIntent().getExtras();
        String email = datos.getString("email");
        String metodo = datos.getString("metodo");
        // Guardado de datos
        SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = sesion.edit();
        Obj_editor.putString("email",email);
        Obj_editor.putString("metodo",metodo);
        Obj_editor.apply();
        Obj_editor.commit();



        restauranteClick.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Restaurantes.class);
            startActivity(intent);
        });

        localizacionClick.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MapsActivityCantavieja.class);
            startActivity(intent);
        });

        turismoClick.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TurismoActivity.class);
            startActivity(intent);
        });

        bandosClick.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.cantavieja.es/p-1-bandos");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // borramos los datos guardados en preferencias
                SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
                SharedPreferences.Editor Obj_editor = sesion.edit();
                Obj_editor.clear();
                Obj_editor.apply();

                FirebaseAuth.getInstance().signOut();
                onBackPressed();
            }
        });

    }
}