package com.carlos.a6_dashboard.MotoGp.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.carlos.a6_dashboard.databinding.FragmentMotoBinding;
import com.carlos.a6_dashboard.MotoGp.model.MotoGP;

import java.util.List;


public class MymotoRecyclerViewAdapter extends RecyclerView.Adapter<MymotoRecyclerViewAdapter.ViewHolder> {

    private final List<MotoGP> mValues;
    private Context ctx;


    public MymotoRecyclerViewAdapter(List<MotoGP> mValues, Context ctx) {
        this.mValues = mValues;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentMotoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        // TExtViews
        holder.txtnombre.setText((mValues.get(position).getNombrePiloto()));
        holder.txtEquipo.setText((mValues.get(position).getNombreEquipo()));
        holder.txtPuntuacion.setText((mValues.get(position).getPuntuacion()));

        // RatingBar
        holder.rtbValoracion.setRating((mValues.get(position).getValoracion()));

        // imagenes
        Glide.with(ctx).load(mValues.get(position).getUrlFotoNacionalidad()).into(holder.imgNacionalidad);
        Glide.with(ctx).load(mValues.get(position).getUrlFotoPiloto()).into(holder.imgPiloto);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtnombre;
        public final TextView txtEquipo;
        public final TextView txtPuntuacion;
        public final ImageView imgNacionalidad;
        public final ImageView imgPiloto;
        public final RatingBar rtbValoracion;
        public MotoGP mItem;

        public ViewHolder(FragmentMotoBinding binding) {
            super(binding.getRoot());
            txtnombre = binding.txtViewNombre;
            txtEquipo = binding.txtNombreEquipo;
            txtPuntuacion = binding.txtPuntuacion;
            imgNacionalidad = binding.imgNacionalidad;
            imgPiloto = binding.imgPiloto;
            rtbValoracion = binding.ratingBarValoracion;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtnombre.getText() + "'";
        }
    }
}