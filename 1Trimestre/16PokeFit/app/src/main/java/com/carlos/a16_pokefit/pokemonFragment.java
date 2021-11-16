package com.carlos.a16_pokefit;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carlos.a16_pokefit.models.Pokemon;
import com.carlos.a16_pokefit.models.PokemonRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class pokemonFragment extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 3;
    RecyclerView recyclerView;
    MypokemonRecyclerViewAdapter adaptador;
    Retrofit retrofit;


    public pokemonFragment() {

    }


    public static pokemonFragment newInstance(int columnCount) {
        pokemonFragment fragment = new pokemonFragment();
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
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);


        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // INSTANCIA DE RETROFIT
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // OBTENER DATOS
            obtenerDatos(retrofit,context);



        }
        return view;
    }

    private void obtenerDatos(Retrofit retrofit, Context context) {
        PokemonService service = retrofit.create(PokemonService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon();
        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {

                if (response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta = response.body();

                    // Pokemon respuesta en una clase que nosotros creamos
                    // y que tiene un array list en java con el listado de
                    // los objectos Pokemon
                    ArrayList<Pokemon> listPokemon = pokemonRespuesta.getResults();

                    adaptador = new MypokemonRecyclerViewAdapter(listPokemon,context);
                    recyclerView.setAdapter(adaptador);

                }else{

                    // Detectar errores, opcional
                    Log.e("OJO","ERROR en onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {

                // Detectar errores, opcional
                Log.e("OJO","ERROR en onFailure: " + t.getMessage());
            }
        });
    }
}