package com.lauramb.practica6_quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SeguirPregunta extends AppCompatActivity {

    TextView txtPasar;
    Button btnPasar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguir_pregunta);

        txtPasar = (TextView) findViewById(R.id.txtEtiqueta);
        btnPasar = (Button) findViewById(R.id.btnPasar);


    }
}