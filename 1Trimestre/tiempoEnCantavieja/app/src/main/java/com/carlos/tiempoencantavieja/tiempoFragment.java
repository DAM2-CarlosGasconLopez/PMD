package com.carlos.tiempoencantavieja;

import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carlos.tiempoencantavieja.placeholder.PlaceholderContent;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class tiempoFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    ConstraintLayout constraintLayout;
    MytiempoRecyclerViewAdapter adaptadorTiempo;
    //List<Tiempo> tiempolist;
    Retrofit retrofit;




    //public static final String BASE_URL = "https://opendata.aemet.es/opendata/api/observacion/convencional/datos/estacion/8486X/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJsb3NjdHZqQGdtYWlsLmNvbSIsImp0aSI6IjNhNTQwNTA4LTBhODUtNGIxNi1iMWJiLWFkNDkzZjY3MzhiMiIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNjM4NTQzMzg5LCJ1c2VySWQiOiIzYTU0MDUwOC0wYTg1LTRiMTYtYjFiYi1hZDQ5M2Y2NzM4YjIiLCJyb2xlIjoiIn0.l7zKZXg2-5FhhovOIYBCjBoNHS0uv1Z6GsPe2RQtd60";


    public tiempoFragment() {
    }


    public static tiempoFragment newInstance(int columnCount) {
        tiempoFragment fragment = new tiempoFragment();
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
        View view = inflater.inflate(R.layout.fragment_tiempo_list, container, false);

        if (view instanceof ConstraintLayout) {
            Context context = view.getContext();
            constraintLayout = (ConstraintLayout) view;
            if (mColumnCount <= 1) {
                constraintLayout.setConstraintSet(new ConstraintSet());
            } else {
                constraintLayout.setConstraintSet(new ConstraintSet());
            }
            // 1 - Uso RETROFIT para obtener la lista de Tiempo

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://opendata.aemet.es/opendata/sh/4ed07f21/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJsb3NjdHZqQGdtYWlsLmNvbSIsImp0aSI6IjNhNTQwNTA4LTBhODUtNGIxNi1iMWJiLWFkNDkzZjY3MzhiMiIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNjM4NTQzMzg5LCJ1c2VySWQiOiIzYTU0MDUwOC0wYTg1LTRiMTYtYjFiYi1hZDQ5M2Y2NzM4YjIiLCJyb2xlIjoiIn0.l7zKZXg2-5FhhovOIYBCjBoNHS0uv1Z6GsPe2RQtd60")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            // 2 - Llamo a obtenerLstTiempo para obtener la lista tiempo
            obtenerLstTiempo(retrofit,context);




        }
        return view;
    }

    private void obtenerLstTiempo(Retrofit retrofit,Context context) {

        TiempoService tiempoService = retrofit.create(TiempoService.class);
        Call<List<Tiempo>> tiempoList = tiempoService.obtenerTiempo();

        tiempoList.enqueue(new Callback<List<Tiempo>>() {
            @Override
            public void onResponse(Call<List<Tiempo>> call, Response<List<Tiempo>> response) {
                if(response.isSuccessful()){


                }else{
                    Log.e("TIEMPO","onResponse: Llamada fallida en onResponse");
                }
            }

            @Override
            public void onFailure(Call<List<Tiempo>> call, Throwable t) {
                Log.e("TIEMPO","onFailure: Llamada fallida en onFailure" +
                        "");
            }
        });

    }

}