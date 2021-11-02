package com.carlos.a10_pokemon_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.carlos.a10_pokemon_app.adapter.PokemonListAdapter;
import com.carlos.a10_pokemon_app.fragments.DetailFragment;
import com.carlos.a10_pokemon_app.interfaces.iComunicaFragments;
import com.carlos.a10_pokemon_app.model.Pokemon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements iComunicaFragments {

    DetailFragment detalleFragmentPokemon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Pokemon Go");

    }

    @Override
    public void enviarPokemon(Pokemon pokemon) {
        //Esta interfaz sirve como puente para comunicar Fragments
        // Toast.makeText(this,pokemon.getNombre(),Toast.LENGTH_SHORT).show();

        // Aqui realizaremos toda la logica necesaria para poder realizar el envio
        detalleFragmentPokemon = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.pokemon_detail_fragment);
        detalleFragmentPokemon.setPokemonImage(pokemon.getImageURL());
        detalleFragmentPokemon.playPokemonSound(pokemon.getSoundId());
    }
}