package com.carlos.a6_dashboard.EdadCanina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.carlos.a6_dashboard.R;

public class EdadCanina_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edad_canina);

        setTitle("Edad Canina");

        // 1- Agregamos los ids a los elementos que se encuentran en el código
        EditText edadEdit = findViewById(R.id.edad_et);
        TextView resultadoText = findViewById(R.id.resultado_tv);
        Button boton = findViewById(R.id.button_btn);


        // Tipos de errores
        Log.d("MainActivity","La actividad principal se ha creado");




        // 2- Damos actividad al boton al ser pulsado
        boton.setOnClickListener( view -> {

            // 3- Recogemos el texto del EditText
            String edad = edadEdit.getText().toString();

            if (!edad.isEmpty()){
                // 4- Comvertimos ese String a entero
                int edadint = Integer.parseInt(edad);

                // 5- Calculamos la edad canina
                int resultado = edadint * 7;

                // 6- creamos el texto a mostrar
                String resultadoString = getString(R.string.texto_resultado,resultado);

                //7- Asignamnos el texto al elemento TextView
                resultadoText.setText(resultadoString);
            }else{
                Log.d("MainActivity", "Has introducido un campo vacio");

                Toast.makeText(this,getString(R.string.msg_toast),Toast.LENGTH_LONG).show();
            }


        });
    }
}