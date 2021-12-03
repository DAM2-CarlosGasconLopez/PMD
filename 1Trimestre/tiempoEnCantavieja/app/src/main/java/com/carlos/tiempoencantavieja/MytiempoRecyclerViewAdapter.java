package com.carlos.tiempoencantavieja;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlos.tiempoencantavieja.placeholder.PlaceholderContent.PlaceholderItem;
import com.carlos.tiempoencantavieja.databinding.FragmentTiempoBinding;

import java.time.DateTimeException;
import java.util.List;


public class MytiempoRecyclerViewAdapter extends RecyclerView.Adapter<MytiempoRecyclerViewAdapter.ViewHolder> {

    private final List<Tiempo> mValues;
    private Context context;

    public MytiempoRecyclerViewAdapter(List<Tiempo> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentTiempoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtNameFecha.setText((CharSequence) holder.mItem.getFecha());
        //holder.txtNamePrecipitacion.setText(holder.mItem.getGrados());
       // holder.txtNameViento.setText(holder.mItem.getViento());
       // holder.txtNameGrados.setText(holder.mItem.getGrados());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView txtNameFecha;
        public final TextView txtNamePrecipitacion;
        public final TextView txtNameViento;
        public final TextView txtNameGrados;
        public Tiempo mItem;

        public ViewHolder(FragmentTiempoBinding binding) {
            super(binding.getRoot());
            txtNameFecha = binding.txtfecha;
            txtNamePrecipitacion = binding.txtPrecipitacion;
            txtNameViento = binding.txtviento;
            txtNameGrados = binding.txtgrados;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtNameFecha.getText() + "'";
        }
    }
}