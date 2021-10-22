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
    Button btnEnviar;


    private int preguntaActual;


    @Override
    //Cuando se abre la aplicacion
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se cargan tres preguntas
        preguntas[0] = new Pregunta("1/3", "¿En que comarca esta Cantavieja?", "Maestrazgo", "Gudar Javalambre", "Albarracín", 1);
        preguntas[1] = new Pregunta("2/3", "¿Cuantos habitantes tiene \n            Cantavieja?", "942", "689", "728", 3);
        preguntas[2] = new Pregunta("3/3", "¿A que altura se encuentra \n             Cantavieja?", "1401m", "1290m", "1103m", 2);

        //Se asocian los elementos del diseño
        pregunta = (TextView) findViewById(R.id.txtPregunta);
        numContador = (TextView) findViewById(R.id.txtNum);

        rbtn1 = (RadioButton) findViewById(R.id.rbtnUno);
        rbtn2 = (RadioButton) findViewById(R.id.rbtnDos);
        rbtn3 = (RadioButton) findViewById(R.id.rbtnTres);
        btnEnviar =(Button)findViewById(R.id.btnSend);


        //Cuando se pulsa el boton enviar
        btnEnviar.setOnClickListener(view -> {
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
        if (preguntas[preguntaActual].getRespuestaCorrecta()== resulSelec){

            // Llamamos al metodo para cambiar de pantalla
            segundaPantalla();

            // Cambiamos la pregunta
            preguntaActual++;

            // Cambiamos la pregunta
            cambiarPregunta();

            // Refrescamos lo botones para que no esten checkeados
            refrescarRadioButtons();

        }else{

            Toast.makeText(this,"Respuesta incorrecta", Toast.LENGTH_SHORT).show();

        }

    }

    private void segundaPantalla() {

        // Pasamos lo que nos hace falta en la segunda pantalla, para pasar de pregunta
         // Si la pregunta no es la ultima ...
        if (preguntaActual<3){
            Intent intent = new Intent(this,SeguirPregunta.class);
            intent.putExtra("Resultado", "RIGTH !!");
            intent.putExtra("Boton","Siguiente pregunta");
            intent.putExtra("Bool", false);
            startActivity(intent);
        }
        // // Pasamos lo que nos hace falta en la segunda pantalla, para volver a empezar el programa
        else{
            Intent intent = new Intent(this,SeguirPregunta.class);
            intent.putExtra("Resultado", "Partida acabada");
            intent.putExtra("Boton","Volver a empezar");
            intent.putExtra("Bool", true);
            intent.putExtra("cont",preguntaActual);

            startActivity(intent);


        }

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
