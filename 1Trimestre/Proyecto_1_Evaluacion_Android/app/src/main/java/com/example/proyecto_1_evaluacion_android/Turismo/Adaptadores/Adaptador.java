package com.example.proyecto_1_evaluacion_android.Turismo.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyecto_1_evaluacion_android.R;
import com.example.proyecto_1_evaluacion_android.Turismo.detalleTurismoActivity;
import com.example.proyecto_1_evaluacion_android.Turismo.model.Entidad;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    // 1 - Creamos el array list de entidad que seran los datos que mostarra el listView
    private ArrayList<Entidad> lstEntidad;

    // 2 - Creamos un contexto
    private Context context;

    private LayoutInflater inflater;

    // 3 - Generamos el constructor


    public Adaptador(ArrayList<Entidad> lstEntidad, Context context) {
        this.lstEntidad = lstEntidad;
        this.context = context;
    }

    // Este metodo indicará al ListView cuantos datos van a cargar
    @Override
    public int getCount() { return lstEntidad.size(); }


    // Este metodo devolverá la posicion
    @Override
    public Object getItem(int posicion) {
        return lstEntidad.get(posicion);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    //Aqui se creara cada item y se le asignara los valores
    //         para cada elemento de cada item
    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {
        final Entidad entidad = (Entidad) getItem(posicion);
        // Creamos e inicializamos los elementos del item de la lista
        convertView = LayoutInflater.from(context).inflate(R.layout.designlist,null);
        ImageView imgFoto = convertView.findViewById(R.id.imgFoto);
        TextView txtTitulo = convertView.findViewById(R.id.txtTitulo);
        TextView txtContenido = convertView.findViewById(R.id.txtcontenido);

        // Llenamos los elementos con los valores de cada item
        imgFoto.setImageResource(entidad.getImgFoto());
        txtTitulo.setText(entidad.getTitulo());
        txtContenido.setText(entidad.getContenido());


        return convertView;
    }
}

