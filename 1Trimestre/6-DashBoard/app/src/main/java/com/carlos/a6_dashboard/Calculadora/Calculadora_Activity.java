package com.carlos.a6_dashboard.Calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.carlos.a6_dashboard.R;

public class Calculadora_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        setTitle("Calculadora");


        // Introduciomes el elemento resultado
        TextView resultadoCalc = findViewById(R.id.resultadoCalc);

        // introducimos los numeros
        EditText numeroUno = findViewById(R.id.introducirNumUno);
        EditText numeroDos = findViewById(R.id.introducirNumDos);



        // Introducimos todos los botones
        Button botonSumar = findViewById(R.id.btnSumar);
        Button botonRestar = findViewById(R.id.btnRestar);
        Button botonMulti = findViewById(R.id.btnMult);
        Button botonDividir = findViewById(R.id.btnDividir);


        // BOTON SUMAR
        botonSumar.setOnClickListener(view -> {
            String nUno = numeroUno.getText().toString();
            String nDos = numeroDos.getText().toString();
            // Si estan vacios los numeros a introducir, lanzamos un error
            if (!nUno.isEmpty() && !nDos.isEmpty()){
                // Convertimos los strings a enteros
                int uno = Integer.parseInt(nUno);
                int dos = Integer.parseInt(nDos);

                // Calculamos el resultado
                int result = uno + dos;

                // Creamos el resultado
                String resultadoMostrar = uno + " + " + dos + " = " + result;

                // Mostramos el resultado
                resultadoCalc.setText(resultadoMostrar);
            }else{
                Log.d("MainActivity", "Has introducido un campo vacio");

                Toast.makeText(this,"No has inrtrodicudo un valor",Toast.LENGTH_SHORT).show();
            }


        });

        // BOTON RESTAR
        botonRestar.setOnClickListener(view -> {
            String nUno = numeroUno.getText().toString();
            String nDos = numeroDos.getText().toString();
            // Si estan vacios los numeros a introducir, lanzamos un error
            if (!nUno.isEmpty() && !nDos.isEmpty()){
                // Convertimos los strings a enteros
                int uno = Integer.parseInt(nUno);
                int dos = Integer.parseInt(nDos);

                // Calculamos el resultado
                int result = uno - dos;

                // Creamos el resultado
                String resultadoMostrar = uno + " - " + dos + " = " + result;

                // Mostramos el resultado
                resultadoCalc.setText(resultadoMostrar);
            }else{
                Log.d("MainActivity", "Has introducido un campo vacio");

                Toast.makeText(this,"No has inrtrodicudo un valor",Toast.LENGTH_SHORT).show();
            }


        });

        // BOTON MULTIPLICAR
        botonMulti.setOnClickListener(view -> {
            String nUno = numeroUno.getText().toString();
            String nDos = numeroDos.getText().toString();
            // Si estan vacios los numeros a introducir, lanzamos un error
            if ((!nUno.isEmpty()) && (!nDos.isEmpty())

            ){
                // Convertimos los strings a enteros
                int uno = Integer.parseInt(nUno);
                int dos = Integer.parseInt(nDos);

                // Calculamos el resultado
                int result = uno * dos;

                // Creamos el resultado
                String resultadoMostrar = uno + " * " + dos + " = " + result;

                // Mostramos el resultado
                resultadoCalc.setText(resultadoMostrar);
            }else{
                Log.d("MainActivity", "Has introducido un campo vacio");

                Toast.makeText(this,"No has inrtrodicudo un valor",Toast.LENGTH_SHORT).show();
            }


        });

        botonDividir.setOnClickListener(view -> {
            String nUno = numeroUno.getText().toString();
            String nDos = numeroDos.getText().toString();
            // Si estan vacios los numeros a introducir, lanzamos un error
            if (!nUno.isEmpty() && !nDos.isEmpty()){
                // Convertimos los strings a enteros
                int uno = Integer.parseInt(nUno);
                int dos = Integer.parseInt(nDos);

                // Calculamos el resultado
                int result = uno / dos;

                // Creamos el resultado
                String resultadoMostrar = uno + " / " + dos + " = " + result;

                // Mostramos el resultado
                resultadoCalc.setText(resultadoMostrar);
            }else{
                Log.d("MainActivity", "Has introducido un campo vacio");

                Toast.makeText(this,"No has inrtrodicudo un valor",Toast.LENGTH_SHORT).show();
            }


        });




    }


}