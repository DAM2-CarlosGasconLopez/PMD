package com.carlos.a15cartapizzeria;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.carlos.a15cartapizzeria.databinding.FragmentPizzaBinding;

import java.util.List;


public class MyPizzaRecyclerViewAdapter extends RecyclerView.Adapter<MyPizzaRecyclerViewAdapter.ViewHolder> {

    private final List<Pizza> mValues;
    private Context context;


    public MyPizzaRecyclerViewAdapter(List<Pizza> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPizzaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtNombrePizza.setText(holder.mItem.getName());
        holder.txtDescripcionPizza.setText(holder.mItem.getDescription());

        // Aqui asignamos una imagen utilizando la libreria Glide
        Glide.with(context).load(holder.mItem.getImage()).into(holder.txtImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtNombrePizza;
        public final TextView txtDescripcionPizza;
        public final ImageView txtImageView;
        public Pizza mItem;

        public ViewHolder(FragmentPizzaBinding binding) {
            super(binding.getRoot());
            txtNombrePizza = binding.txtNamePizza;
            txtDescripcionPizza = binding.txtDescripcionPizza;
            txtImageView = binding.imgPizzaImagen;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtNombrePizza.getText() + "'";
        }
    }
}