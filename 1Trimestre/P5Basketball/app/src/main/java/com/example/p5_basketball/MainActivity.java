package com.example.p5_basketball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mas1Local,mas1Visitante,mas2Local,mas2Visitante,menos1Local,menos1Visitante,refrescar,pasarActivity;
    TextView txtLocal;
    TextView txtVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        setTitle("Basketball");

        // Buttons
        mas1Local = (Button) findViewById(R.id.btn1Local);
        mas1Visitante = (Button) findViewById(R.id.btn1Visitante);
        mas2Local = (Button) findViewById(R.id.btn2Local);
        mas2Visitante = (Button) findViewById(R.id.btn2Visitante);
        menos1Local = (Button) findViewById(R.id.btnMenosLocal);
        menos1Visitante = (Button) findViewById(R.id.btnMenosVisitante);

        refrescar = (Button) findViewById(R.id.btnRefresh);
        pasarActivity = (Button) findViewById(R.id.btnResultado);

        // TextViews
        txtLocal = (TextView) findViewById(R.id.txtPuntosLocal);
        txtVisitante = (TextView) findViewById(R.id.txtPuntosVisitante);

        // Ponemos los txt en 0
        txtLocal.setText(String.valueOf(0));
        txtVisitante.setText(String.valueOf(0));

        mas1Local.setOnClickListener(view -> {
            Integer ent;
            ent = Integer.parseInt((String) txtLocal.getText());
            txtLocal.setText(String.valueOf(ent + 1));
        });

        mas1Visitante.setOnClickListener(view -> {
            Integer ent;
            ent = Integer.parseInt((String) txtVisitante.getText());
            txtVisitante.setText(String.valueOf(ent + 1));
        });

        mas2Local.setOnClickListener(view -> {
            Integer ent;
            ent = Integer.parseInt((String) txtLocal.getText());
            txtLocal.setText(String.valueOf(ent + 2));
        });

        mas2Visitante.setOnClickListener(view -> {
            Integer ent;
            ent = Integer.parseInt((String) txtVisitante.getText());
            txtVisitante.setText(String.valueOf(ent + 2));
        });

        menos1Local.setOnClickListener(view -> {

            Integer ent;
            ent = Integer.parseInt((String) txtLocal.getText());
            if (ent >0) {
                txtLocal.setText(String.valueOf(ent - 1));
            }
        });

        menos1Visitante.setOnClickListener(view -> {
            Integer ent;
            ent = Integer.parseInt((String) txtVisitante.getText());
            if (ent > 0) {
                txtVisitante.setText(String.valueOf(ent - 1));
            }
        });

        refrescar.setOnClickListener(view -> {
            txtLocal.setText(String.valueOf(0));
            txtVisitante.setText(String.valueOf(0));
        });

        pasarActivity.setOnClickListener(view -> {
            Intent intent = new Intent(this,ResultadoActivity.class);
            intent.putExtra("ResultadoLocal", txtLocal.getText());
            intent.putExtra("ResultadoVisitante",txtVisitante.getText());
            startActivity(intent);
        });










    }
}