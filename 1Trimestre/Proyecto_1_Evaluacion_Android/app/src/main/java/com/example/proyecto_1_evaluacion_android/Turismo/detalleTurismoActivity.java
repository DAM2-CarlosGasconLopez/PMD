package com.example.proyecto_1_evaluacion_android.Turismo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_1_evaluacion_android.R;
import com.example.proyecto_1_evaluacion_android.Turismo.model.Entidad;

public class detalleTurismoActivity extends AppCompatActivity {

    private TextView txtTitulo,txtDescripcion;
    private ImageView imgFoto;
    private Entidad item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_turismo);

        setTitle(getString(R.string.turismodecantavieja));

        item = (Entidad) getIntent().getSerializableExtra("item");
        if (item!=null){
            txtTitulo = findViewById(R.id.txtTituloDetalles);
            txtDescripcion = findViewById(R.id.txtDesctripcionDetalle);
            imgFoto = findViewById(R.id.imgFotoDetalle);


            txtTitulo.setText(item.getTitulo());
            txtDescripcion.setText(item.getDescripcion());
            imgFoto.setImageResource(item.getImgFoto());
        }
    }
}