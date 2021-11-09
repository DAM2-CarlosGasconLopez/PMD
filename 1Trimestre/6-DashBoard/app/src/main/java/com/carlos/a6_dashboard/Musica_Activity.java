package com.carlos.a6_dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Musica_Activity extends AppCompatActivity {
    private ListView lstItems;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayEntidad = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        setTitle("DISCOS ROCK ESPAÑA");
        lstItems = findViewById(R.id.lstViewItems);

        LlenarItems();

    }

    private void LlenarItems() {
        arrayEntidad.add(new Entidad(R.drawable.besosdeperromarea,"BESOS DE PERRO","Marea"));
        arrayEntidad.add(new Entidad(R.drawable.veintiocho,"28.000 PUÑALADAS","Marea"));
        arrayEntidad.add(new Entidad(R.drawable.dfgdfg,"SINDICATO DEL CRIMEN","Kaotiko"));
        arrayEntidad.add(new Entidad(R.drawable.kaotiko,"DESTINO ESCRITO","Kaotiko"));
        arrayEntidad.add(new Entidad(R.drawable.kaotikoo,"MUNDO KAOTIKO","Kaotiko"));
        arrayEntidad.add(new Entidad(R.drawable.elultimo,"EL ULTIMO EL DE LA POLLA","La Polla Records"));
        arrayEntidad.add(new Entidad(R.drawable.lpr,"NO SOMOS NADA","La Polla Records"));
        arrayEntidad.add(new Entidad(R.drawable.platero,"VOY A ACABAR BORRACHO","Platero y Tu"));
        arrayEntidad.add(new Entidad(R.drawable.plateroo,"HAY POCO ROCK & ROLL","Platero y Tu"));
        arrayEntidad.add(new Entidad(R.drawable.sakpincontrolable,"INCONTROLABLE","Ska-p"));
        arrayEntidad.add(new Entidad(R.drawable.skap,"QUE CORRA LA VOZ !","Ska-p"));
        arrayEntidad.add(new Entidad(R.drawable.skapp,"99 %","Ska-p"));

        adaptador = new Adaptador(arrayEntidad,this);
        lstItems.setAdapter(adaptador);
    }
}