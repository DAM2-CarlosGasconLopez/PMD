package com.carlos.a6_dashboard.Musica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlos.a6_dashboard.Musica.model.Entidad;
import com.carlos.a6_dashboard.R;

public class Detalle_Activity extends AppCompatActivity {

    private TextView txtTitulo,txtDescripcion;
    private ImageView imgFoto;
    private Entidad item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        setTitle("DISCOS ROCK ESPAÑA");

        item = (Entidad) getIntent().getSerializableExtra("item");
        if (item!=null){
            txtTitulo = findViewById(R.id.txtTituloDetalles);
            txtDescripcion = findViewById(R.id.txtDesctripcionDetalle);
            imgFoto = findViewById(R.id.imgFotoDetalle);


            txtTitulo.setText(item.getTitulo());
            txtDescripcion.setText(item.getContenido());
            imgFoto.setImageResource(item.getImgFoto());
        }
    }
}