package com.carlos.a10_pokemon_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlos.a10_pokemon_app.R;
import com.carlos.a10_pokemon_app.model.Pokemon;

import java.util.ArrayList;

public class PokemonListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Pokemon> pokemonList;
    private int layoutId;

    public PokemonListAdapter(Context context, ArrayList<Pokemon> pokemonList, int layoutId) {
        this.context = context;
        this.pokemonList = pokemonList;
        this.layoutId = layoutId;
    }


    @Override
    public int getCount() {
        return pokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Pokemon pokemon = (Pokemon) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item,null);

        TextView pokemonIdTextView = view.findViewById(R.id.pokemon_listIdTextView);
        TextView pokemonNameTextView = view.findViewById(R.id.pokemon_list_Name_textview);
        ImageView pokemonTypeImageView = view.findViewById(R.id.pokemon_list_image_View);

        // Llenamos los elementos de la lista
        pokemonIdTextView.setText(pokemon.getId());
        pokemonNameTextView.setText(pokemon.getNombre());
        final  Pokemon.Type type = pokemon.getType();

        // En base al superpoder que tenga le asiganremos un icono u otro
        switch (type){
            case FIRE:
                pokemonTypeImageView.setImageResource(R.drawable.fire);
                break;
            case WATER:
                pokemonTypeImageView.setImageResource(R.drawable.water);
                break;
            case PLANT:
                pokemonTypeImageView.setImageResource(R.drawable.plant);
                break;
            case ELECTRIC:
                pokemonTypeImageView.setImageResource(R.drawable.electric);
                break;

        }
        return view;
    }
}
