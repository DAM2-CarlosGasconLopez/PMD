package com.lauramb.practica6_quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SeguirPregunta extends AppCompatActivity {

    TextView txtPasar;
    Button btnPasar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Cantavieja");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguir_pregunta);
        // declaramos los elementos
        txtPasar = (TextView) findViewById(R.id.txtEtiqueta);
        btnPasar = (Button) findViewById(R.id.btnPasar);
        int cont;

        // Recogemos los datos del intent
        Bundle bundle = getIntent().getExtras();

        // Asignamos a los elementos, los datos del intent/bundle
        txtPasar.setText(bundle.getString("Resultado"));
        btnPasar.setText(bundle.getString("Boton"));
        cont = bundle.getInt("cont");
        Boolean end = bundle.getBoolean("Bool");

        // Hacemos una accion del boton para volver a la pregunta o para volver a empezar el programa

        btnPasar.setOnClickListener(view -> {

           if (!btnPasar.getText().equals("Volver a empezar")) {
               super.onBackPressed();
           }else{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
           }


        });


    }
}