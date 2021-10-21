package com.lauramb.practica6_quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaramos los botones y llamamos a la clase pregunta
    private Pregunta[] preguntas = new Pregunta[3];
    RadioButton rbtn1, rbtn2,rbtn3;
    TextView pregunta, numContador;
    Button botonSend;


    private int preguntaActual;
    int buenas = 0;
    int malas = 0;

    @Override
    //Cuando se abre la aplicacion
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se cargan tres preguntas
        preguntas[0] = new Pregunta("1/3", "Rey de España en 2021", "Felipe VI", "Felipe V", "Juan Carlos I", 1);
        preguntas[1] = new Pregunta("2/3", "Heredera de la corona", "Letizia Ortiz", "Sofia de Borbon", "Leonor de Borbon", 3);
        preguntas[2] = new Pregunta("3/3", "Residencia habitual de los reyes", "Palacio de Oriente", "Palacio la Zarzuela", "Palacio de los maestres de Santiago.", 2);

        //Se asocian los elementos del diseño
        pregunta = (TextView) findViewById(R.id.txtvPregunta);
        numContador = (TextView) findViewById(R.id.txtvNumero);

        rbtn1 = (RadioButton) findViewById(R.id.rbtnUno);
        rbtn2 = (RadioButton) findViewById(R.id.rbtnDos);
        rbtn3 = (RadioButton) findViewById(R.id.rbtnTres);
        botonSend=(Button)findViewById(R.id.btnSend);


        //Cuando se pulsa el boton enviar
        botonSend.setOnClickListener(view -> {
            validacionPregunta();

        });

        cambiarPregunta();
    }

    private void validacionPregunta() {
        //Obtenemos lo que el usuario a seleccionado
        int resulSelec=0;
        if (rbtn1.isChecked()){
            resulSelec=1;
        }else if (rbtn2.isChecked()){
            resulSelec=2;
        }else if (rbtn3.isChecked()){
            resulSelec=3;
        }else{
            Toast.makeText(this,"No has seleccionado ninguna opción", Toast.LENGTH_SHORT).show();
        }

        //Guadarmos si la respuesta dada es correcta
        if (preguntas[0].getRespuestaCorrecta()== resulSelec){
            buenas++;
            preguntaActual++;

            // Llamamos al metodo para cambiar de pantalla
            segundaPantalla();

            cambiarPregunta();

            // Refrescamos lo botones para que no esten checkeados
            refrescarRadioButtons();

        }else{
            malas++;
            Toast.makeText(this,"Respuesta incorrecta", Toast.LENGTH_SHORT).show();

        }

    }

    private void segundaPantalla() {

        //Intent intent = new Intent(this, ActivitySegundo.class);
        //startActivity(intent);

    }

    private void refrescarRadioButtons() {
        rbtn1.setChecked(false);
        rbtn2.setChecked(false);
        rbtn3.setChecked(false);
    }


    public void cambiarPregunta(){

        // Cambiamos el número de la pregunta
        Pregunta numPreg = preguntas[preguntaActual];
        numContador.setText(numPreg.getNumero());

        // Cambiamos la pregunta
        Pregunta infoDePregunta = preguntas[preguntaActual];
        pregunta.setText(infoDePregunta.getPregunta());

        // Asignamos a cada boton su respuesta
        rbtn1.setText(infoDePregunta.getRespuesta()[0]);
        rbtn2.setText(infoDePregunta.getRespuesta()[1]);
        rbtn3.setText(infoDePregunta.getRespuesta()[2]);
    }

}
