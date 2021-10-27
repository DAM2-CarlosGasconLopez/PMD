package com.carlos.a9_lista_personalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.carlos.a9_lista_personalizada.adaptadores.Adaptador;
import com.carlos.a9_lista_personalizada.model.Entidad;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lstItems;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayEntidad = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstItems = findViewById(R.id.lstViewItems);

        LlenarItems();

        // Gestionamos el evento click de la FORMA A

            /*lstItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {

                    Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                    intent.putExtra("item" , arrayEntidad.get(posicion));
                    startActivity(intent);
                }
            });
            */
    }

    private void LlenarItems() {
        arrayEntidad.add(new Entidad(R.drawable.dbs_1,"SS BLUES","Goku y Vegeta"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_2,"SS ROSE","Goku y Black"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_3,"DB HEROES 1","Personajes nuevos"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_4,"DB HEROES 2","Otros Personajes, Majin Boo"));
        arrayEntidad.add(new Entidad(R.drawable.dbs_5,"VEGETA","Sacrificio de Vegeta"));

        adaptador = new Adaptador(arrayEntidad,this);
        lstItems.setAdapter(adaptador);
    }
}