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
import android.widget.TextView;

import com.example.proyecto_1_evaluacion_android.MapsActivityCantavieja;
import com.example.proyecto_1_evaluacion_android.R;
import com.example.proyecto_1_evaluacion_android.Restaurante.Restaurantes;
import com.example.proyecto_1_evaluacion_android.Turismo.TurismoActivity;
import com.google.firebase.auth.FirebaseAuth;


public class Cuenta extends Fragment {

    Button btnCerrarSesion;
    TextView txt_Email;


    public Cuenta() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cuenta, container, false);

        //super.onCreate(savedInstanceState);



        txt_Email = view.findViewById(R.id.txtEmail);
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

        txt_Email.setText(email);




        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // borramos los datos guardados en preferencias
                SharedPreferences sesion = getActivity().getSharedPreferences("sesion", Context.MODE_PRIVATE);
                SharedPreferences.Editor Obj_editor = sesion.edit();
                Obj_editor.clear();
                Obj_editor.apply();

                FirebaseAuth.getInstance().signOut();
                getActivity().onBackPressed();
            }
        });
        return view;
    }
}