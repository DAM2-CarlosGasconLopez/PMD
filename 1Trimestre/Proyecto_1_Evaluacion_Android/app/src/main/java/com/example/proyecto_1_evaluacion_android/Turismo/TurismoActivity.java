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
        setTitle("Turismo por Cantavieja");

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
        arrayEntidad.add(new Entidad(R.drawable.ujno, "Plaza de Cristo Rey", "Interes Arquitectonico", "La plaza es un espacio rectangular cerrado y asoportalado en tres de sus lados por la citada iglesia, la Casa Consistorial y la Casa Bayle. Los arcos que se abren a la plaza son apuntados y de medio punto. En algunos tramos se aprecia las bóvedas de crucería que soportan las galerías."));
        arrayEntidad.add(new Entidad(R.drawable.dos, "Museo de las Guerras Carlistas", "Museos de historia", "Museo especializado en la epoca de las guerras carlistas, ya que el general Ramón Cabrera vivió durante unos años en Cantavieja, dejando gueeras tanto en Mirambel, como en Cantavieja. Todavía se conserva su casa y su escudo."));
        arrayEntidad.add(new Entidad(R.drawable.trres, "Torre del campanario", "Lugares Historicos y Interes arquitectónico", "La torre es del siglo XVII, tiene un arco abierto en su base, que hace que la calle pase por debajo de ella, y además no solo tiene una de las vistas mas atractivas del pueblo y sus alrededores, sino que tambien tiene una exposición de lo que era una escuela antaño, en uno de los pisos y en otro también esta expuestos los mecanismos del reloj de la torre"));
        arrayEntidad.add(new Entidad(R.drawable.cuatro, "Oficina de turismo", "Centros de visitantes", ""));
        arrayEntidad.add(new Entidad(R.drawable.cinco, "Ayuntamiento de Cantavieja", "Interés arquitectonico ", ""));
        arrayEntidad.add(new Entidad(R.drawable.seis, "Iglesia de San Miguel", "Iglesisa y catedrales", ""));
        arrayEntidad.add(new Entidad(R.drawable.siete, "Iglesia de la Asuncion", "Iglesias y catedrales", ""));
        arrayEntidad.add(new Entidad(R.drawable.ocho, "Castillo Templario", "Castillos", ""));
        arrayEntidad.add(new Entidad(R.drawable.nueve, "Nevera Mediaval", "Zonas históricas", ""));
        arrayEntidad.add(new Entidad(R.drawable.diez, "Muralla del Antiguo Pueblo", "Ruinas Antiguas", ""));
        arrayEntidad.add(new Entidad(R.drawable.once, "Mirador de San Miguel", "Miradores", ""));

        adaptador = new Adaptador(arrayEntidad, this);
        lstItems.setAdapter(adaptador);
    }
}