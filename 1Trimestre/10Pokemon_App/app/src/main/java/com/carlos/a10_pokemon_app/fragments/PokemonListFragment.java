package com.carlos.a10_pokemon_app.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.carlos.a10_pokemon_app.MainActivity;
import com.carlos.a10_pokemon_app.R;
import com.carlos.a10_pokemon_app.adapter.PokemonListAdapter;
import com.carlos.a10_pokemon_app.interfaces.iComunicaFragments;
import com.carlos.a10_pokemon_app.model.Pokemon;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ListView lvPokemons;
    private PokemonListAdapter adaptador;
    private ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();

    //Declaro la interfaz que vamos a utilizar
    iComunicaFragments interfaz;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PokemonListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        interfaz = (iComunicaFragments) context;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonListFragment newInstance(String param1, String param2) {
        PokemonListFragment fragment = new PokemonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 1 - Creamos una lista a retornar
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        // 2 - A partir de este view vamos a obtener todos los views del fragment
        lvPokemons = view.findViewById(R.id.pokemon_listView);
        // 3 - Traemos el resto de codigo del MainActivity
        pokemonArrayList.add(new Pokemon("1","Bulbasaur","https://cdn.alfabetajuega.com/wp-content/uploads/2020/03/bulbasaur-pok%C3%A9mon.png",R.raw.bulbasaur,Pokemon.Type.PLANT));
        pokemonArrayList.add(new Pokemon("2","IvySaur","https://images.wikidexcdn.net/mwuploads/wikidex/6/60/latest/20151001164033/EP893_Ivysaur_de_Xana.png",R.raw.ivysaur,Pokemon.Type.PLANT));
        pokemonArrayList.add(new Pokemon("3","VenuaSaur","https://s3.eu-west-3.amazonaws.com/dexertoes-assets-production-7d0f29e6/uploads/2020/09/24185719/venusaur-pokemon-go.png",R.raw.venuasaur,Pokemon.Type.PLANT));
        pokemonArrayList.add(new Pokemon("4","Charmander","https://areajugones.sport.es/wp-content/uploads/2019/11/Pokemon-Espada-y-Escudo-Charmander.jpg",R.raw.charmander,Pokemon.Type.FIRE));
        pokemonArrayList.add(new Pokemon("5","Charmeleon","https://i.pinimg.com/originals/80/42/50/8042507726c9558b011c25c0ca4ecac8.png",R.raw.charmeleon,Pokemon.Type.WATER));
        pokemonArrayList.add(new Pokemon("6","Charizard","https://i.blogs.es/fb1922/1200px-ep803_charizard_de_ash/840_560.jpeg",R.raw.charizard,Pokemon.Type.FIRE));
        pokemonArrayList.add(new Pokemon("7","Squirtle","https://areajugones.sport.es/wp-content/uploads/2021/05/squirtle-pokemon.jpg",R.raw.squirtle,Pokemon.Type.WATER));
        pokemonArrayList.add(new Pokemon("8","Blastoise","https://images.wikidexcdn.net/mwuploads/wikidex/8/81/latest/20210528173042/EP1157_Blastoise_de_Gary.png",R.raw.blastoise,Pokemon.Type.ELECTRIC));
        pokemonArrayList.add(new Pokemon("25","Pikachu","https://areajugones.sport.es/wp-content/uploads/2021/02/pikachu-pokemon.jpg",R.raw.pikachu,Pokemon.Type.ELECTRIC));
        pokemonArrayList.add(new Pokemon("26","Raichu","https://www.egames.news/__export/1627425509127/sites/debate/img/2021/07/27/copia_de_egames_-_2021-07-27t163726_028.jpg_759710130.jpg",R.raw.raichu,Pokemon.Type.ELECTRIC));
        //  4 - Un contexto SIEMPRE va a depender de un Activity.
        // Cuando nos pida un contexto desde un Fragment, podemos obtenerlo con getActivity()
        adaptador = new PokemonListAdapter(getActivity(),pokemonArrayList,R.id.item);
        // 5 - Asignamos el adaptador
        lvPokemons.setAdapter(adaptador);

        // 6 - SetOnClick()
        lvPokemons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon selectedPokemon = (Pokemon) adaptador.getItem(position);
                if (selectedPokemon != null){
                    interfaz.enviarPokemon(selectedPokemon);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}