package com.carlos.a8_versionesdeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // 1 - Declaramos el elemento listView
    ListView lista;

    // 2 - Declaramos la lista de elementos a mostrar
    List<String> androidversionesLst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 3 - Conectamos los elementos con el diseño
        lista = findViewById(R.id.lstViewVersiones);

        // 4 - Cargamos la lista de elementos
        androidversionesLst = new ArrayList<>();

        androidversionesLst.add("Pie");
        androidversionesLst.add("Oreo");
        androidversionesLst.add("Nougat");
        androidversionesLst.add("Marshmallow");
        androidversionesLst.add("Lollipop");
        androidversionesLst.add("Kitkat");
        androidversionesLst.add("...");

        // 5 - Nos definimos el ADAPTADOR:
        //     El adaptador coge la lista de strings 'androidversionesLst' y las va pintando en el ListView. Tantos como elementos visuales
        ArrayAdapter adpVersionesAndroid = new ArrayAdapter(
                this,     // donde nos encontramos
                android.R.layout.simple_list_item_1,     // template que usamos para mostrar los resultados (nativo de android)
                androidversionesLst     // Los elementos a mostrar

        );

        // 6 - Vinculamos el listaView con la lista definida en el adaptador

        lista.setAdapter(adpVersionesAndroid);

        // 7 - Gestionamos el evento click en cada elemento de la lista
        lista.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String version = androidversionesLst.get(position);
        Toast.makeText(this,"La version seleccionada es " + version,Toast.LENGTH_SHORT).show();
    }
}