package com.example.p5_basketball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    TextView txtLocalResoult, txtVisitanteResoult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        getSupportActionBar().hide();

        // Elementos
        txtLocalResoult = (TextView) findViewById(R.id.txtLocalResoult);
        txtVisitanteResoult = (TextView) findViewById(R.id.txtVisitanteResoult);

        // Recogemos datos del intent
        Bundle bundle = getIntent().getExtras();

        //Asignamos a los elementos
        txtLocalResoult.setText(bundle.getString("ResultadoLocal"));
        txtVisitanteResoult.setText(bundle.getString("ResultadoVisitante"));


    }
}