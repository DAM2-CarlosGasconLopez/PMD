package com.example.proyecto_1_evaluacion_android.Turismo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_1_evaluacion_android.R;
import com.example.proyecto_1_evaluacion_android.Turismo.Adaptadores.Adaptador;
import com.example.proyecto_1_evaluacion_android.Turismo.model.Entidad;

import java.util.ArrayList;

public class TurismoActivity extends AppCompatActivity {
    private ListView lstItems;
    private Adaptador adaptador;
    private ArrayList<Entidad> arrayEntidad = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turismo);
        setTitle(getString(R.string.turismodecantavieja));

        lstItems = findViewById(R.id.lstViewItems);

        LlenarItems();
        lstItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TurismoActivity.this, detalleTurismoActivity.class);
                intent.putExtra("item", arrayEntidad.get(i));
                startActivity(intent);
            }
        });

    }

    private void LlenarItems() {
        arrayEntidad.add(new Entidad(R.drawable.ujno, getString(R.string.plazacristo), getString(R.string.interes), getString(R.string.primerdescripcion)));
        arrayEntidad.add(new Entidad(R.drawable.dos, getString(R.string.guerrascarlistas), getString(R.string.museops), getString(R.string.museoespecializado)));
        arrayEntidad.add(new Entidad(R.drawable.trres, getString(R.string.campanario), getString(R.string.lugaRES), getString(R.string.latorre)));
        arrayEntidad.add(new Entidad(R.drawable.cuatro, getString(R.string.nosequedeturismo), getString(R.string.visitantes), getString(R.string.primerdescripcion)));
        arrayEntidad.add(new Entidad(R.drawable.cinco, getString(R.string.ayuntamientocantavieja), getString(R.string.interes), getString(R.string.primerdescripcion)));
        arrayEntidad.add(new Entidad(R.drawable.seis, getString(R.string.sanmiguel), getString(R.string.catedrles), getString(R.string.primerdescripcion)));
        arrayEntidad.add(new Entidad(R.drawable.siete, getString(R.string.asuncion), getString(R.string.catedrles), getString(R.string.museoespecializado)));
        arrayEntidad.add(new Entidad(R.drawable.ocho, getString(R.string.termplario), getString(R.string.castillos),getString(R.string.latorre)));
        arrayEntidad.add(new Entidad(R.drawable.nueve, getString(R.string.nevera), getString(R.string.cositas), getString(R.string.primerdescripcion)));
        arrayEntidad.add(new Entidad(R.drawable.diez, getString(R.string.antiguopueblo), getString(R.string.ruinas), getString(R.string.museoespecializado)));
        arrayEntidad.add(new Entidad(R.drawable.once, getString(R.string.miradorsanmiguwel), getString(R.string.miradores), getString(R.string.latorre)));

        adaptador = new Adaptador(arrayEntidad, this);
        lstItems.setAdapter(adaptador);
    }
}