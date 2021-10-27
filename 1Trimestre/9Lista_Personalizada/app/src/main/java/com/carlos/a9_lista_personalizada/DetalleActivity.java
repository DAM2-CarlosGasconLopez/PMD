package com.carlos.a9_lista_personalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlos.a9_lista_personalizada.model.Entidad;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtTitulo,txtDescripcion;
    private ImageView imgFoto;
    private Entidad item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

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