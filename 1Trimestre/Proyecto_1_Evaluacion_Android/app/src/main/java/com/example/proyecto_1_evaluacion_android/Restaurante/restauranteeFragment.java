package com.example.proyecto_1_evaluacion_android.Restaurante;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto_1_evaluacion_android.R;
import com.example.proyecto_1_evaluacion_android.models.Restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class restauranteeFragment extends Fragment {

    /*RECOMENDACION: Me declaro la variable fuera para acceder a la variable
                    fuera del onCreateView
   */
    RecyclerView recyclerView;
    MyrestauranteeRecyclerViewAdapter adapterRestaurantes;

    // 3 - Creamos una lista de restaurantes
    List<Restaurante> restauranteList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public restauranteeFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static restauranteeFragment newInstance(int columnCount) {
        restauranteeFragment fragment = new restauranteeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Este metodo esta asociado a un xml
        View view = inflater.inflate(R.layout.fragment_restaurantee_list, container, false);

        //Aqui comprobamos que el elemento padre(xml) sea una instacia de RecyclerView
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                //  Getsor del RecyclerView por defecto. Situa los elementos uno debajo del otro
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // 4 - Lista de elementos (Restaurante)
            restauranteList = new ArrayList<>();

            // 5 - Añadimos los restaurantes
            restauranteList.add(new Restaurante("Restaurante 4 Vientos","https://lh6.googleusercontent.com/-ArmRioCX6m0/VNZO0mcYU6I/AAAAAAAAAAU/THaaBMM6cB4ADDrJtb4FlvLOTGAVB7gbwCJkC/w600-k/",4.3f,"Av. Maestrazgo,2 Cantavieja"));
            restauranteList.add(new Restaurante("Bar YoDi","https://media-cdn.tripadvisor.com/media/photo-s/07/67/25/5a/bar-cafeteria-yodi.jpg",4.4f,"C. Loreto,2 Cantavieja"));
            restauranteList.add(new Restaurante("Hotel Balfagon","https://media-cdn.tripadvisor.com/media/photo-s/08/10/f6/09/hotel-spa-balfagon.jpg",4.6f,"Av. Maestrazgo,20 Cantavieja"));
            restauranteList.add(new Restaurante("TapaVieja","https://media-cdn.tripadvisor.com/media/photo-s/10/c5/90/d1/img-20170923-wa0015-largejpg.jpg",3.9f,"Av. Aragón,5 Cantavieja"));
            restauranteList.add(new Restaurante("La Posada","https://www.turismomaestrazgo.com/wp-content/uploads/2015/07/pension-julian-4.jpg",4.2f,"Av. Las Tres Bylías,6 Cantavieja"));
            restauranteList.add(new Restaurante("Cafetería Sandra","https://img.restaurantguru.com/r446-Cafeteria-Sandra-interior.jpg",4.4f,"C. Mayor,18 Cantavieja"));
            restauranteList.add(new Restaurante("Bar Teleclub","https://turismomaestrazgo.org/wp-content/uploads/2021/06/Bar-Cafeteri%CC%81a-Teleclub-Cantavieja-1.jpeg",4.1f,"Av. Aragón,1 Cantavieja"));
            restauranteList.add(new Restaurante("Bar Gasolinera","https://turismocantaviejatravel.files.wordpress.com/2018/06/f8bca-dsc_0066.jpg",3.8f,"Av. Maestrazgo,8 Cantavieja"));


            // 2 - Asociamos el adaptador al RecyclerView
            adapterRestaurantes = new MyrestauranteeRecyclerViewAdapter(getActivity(), restauranteList);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}