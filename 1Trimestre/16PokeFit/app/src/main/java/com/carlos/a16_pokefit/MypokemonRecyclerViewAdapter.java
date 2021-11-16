package com.carlos.a16_pokefit;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.carlos.a16_pokefit.databinding.FragmentPokemonBinding;
import com.carlos.a16_pokefit.models.Pokemon;
import com.carlos.a16_pokefit.models.PokemonRespuesta;

import java.util.List;


public class MypokemonRecyclerViewAdapter extends RecyclerView.Adapter<MypokemonRecyclerViewAdapter.ViewHolder> {

    private final List<Pokemon> mValues;
    private Context context;

    public MypokemonRecyclerViewAdapter(List<Pokemon> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPokemonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.namePokemon.setText(mValues.get(position).getName());

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + mValues.get(position).getNumber() +".png")
                .into(holder.imagePokemon);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imagePokemon;
        public final TextView namePokemon;
        public Pokemon mItem;

        public ViewHolder(FragmentPokemonBinding binding) {
            super(binding.getRoot());
            imagePokemon = binding.fotoImage;
            namePokemon = binding.nombreTextView;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + namePokemon.getText() + "'";
        }
    }
}