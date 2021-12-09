package com.example.proyecto_1_evaluacion_android.TabLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proyecto_1_evaluacion_android.MainActivity;
import com.example.proyecto_1_evaluacion_android.MapsActivityCantavieja;
import com.example.proyecto_1_evaluacion_android.R;
import com.example.proyecto_1_evaluacion_android.Restaurante.Restaurantes;
import com.example.proyecto_1_evaluacion_android.Turismo.TurismoActivity;
import com.google.firebase.auth.FirebaseAuth;


public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    CardView restauranteClick, localizacionClick, turismoClick, bandosClick;
    Button btnCerrarSesion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        super.onCreate(savedInstanceState);

        //getActivity().getActionBar().hide();

        restauranteClick = view.findViewById(R.id.restaurante);
        localizacionClick = view.findViewById(R.id.localizacion);
        turismoClick = view.findViewById(R.id.turismo);
        bandosClick = view.findViewById(R.id.bandos);
        btnCerrarSesion = view.findViewById(R.id.btnBlock);

        //Recuperamos los datos del LoginActivity
        Bundle datos = getActivity().getIntent().getExtras();
        String email = datos.getString("email");
        String metodo = datos.getString("metodo");
        // Guardado de datos
        SharedPreferences sesion = getActivity().getSharedPreferences("sesion", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = sesion.edit();
        Obj_editor.putString("email", email);
        Obj_editor.putString("metodo", metodo);
        Obj_editor.apply();
        Obj_editor.commit();


        restauranteClick.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Restaurantes.class);
            startActivity(intent);
        });

        localizacionClick.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MapsActivityCantavieja.class);
            startActivity(intent);
        });

        turismoClick.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), TurismoActivity.class);
            startActivity(intent);
        });

        bandosClick.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.cantavieja.es/p-1-bandos");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });




        return view;
    }
}