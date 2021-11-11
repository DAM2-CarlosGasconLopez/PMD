package com.carlos.a6_dashboard.MotoGp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carlos.a6_dashboard.R;
import com.carlos.a6_dashboard.MotoGp.model.MotoGP;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */

public class motoFragment extends Fragment {

    RecyclerView recyclerViewMotoGp;
    MymotoRecyclerViewAdapter adapterMotoGp;
    List<MotoGP> motoGPList;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;


    public motoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static motoFragment newInstance(int columnCount) {
        motoFragment fragment = new motoFragment();
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
        View view = inflater.inflate(R.layout.fragment_moto_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
             recyclerViewMotoGp = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerViewMotoGp.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerViewMotoGp.setLayoutManager(new GridLayoutManager(context, mColumnCount));

            }

            motoGPList = new ArrayList<>();

            // Añadimos los objetos
            motoGPList.add(new MotoGP("Fabio Quartararo","https://motoracenation.com/wp-content/uploads/2021/10/image-1-min-scaled.jpg",4.0f,"Yamaha Factory Racing","https://nautichandler.com/1337-medium_default/bandera-francia-75x50cm.jpg","267"));
            motoGPList.add(new MotoGP("Francesco Bagnaia","https://images.daznservices.com/di/library/DAZN_News/26/37/pecco-bagnaia-motogp-2021_1o5fb6w02lrv21ni1xusiq7qis.jpg?t=-1532002773&quality=60&h=450",4.0f,"Ducati Team","https://nautichandler.com/1349-medium_default/bandera-italia-45x30cm.jpg","227"));
            motoGPList.add(new MotoGP("Joan Mir Mayrata","https://www.motociclismo.es/uploads/s1/91/08/78/0/joan-mir-seguira-llevando-el-36-en-motogp-2021.jpeg",3.5f,"Team Suzuki","https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Bandera_de_Espa%C3%B1a.svg/1200px-Bandera_de_Espa%C3%B1a.svg.png","195"));
            motoGPList.add(new MotoGP("Jack Miller","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRk7tuo63CUGhIzOMlrQkwyhV2chc96yFiOXA&usqp=CAU",4.0f,"Ducati Team","https://aremitaliashop.com/2081-home_default/parche-bandera-australia.jpg","165"));
            motoGPList.add(new MotoGP("Johann Zarco","https://phantom-marca.unidadeditorial.es/0754d5218ef0759e1f4d91b8b5f1776f/crop/0x27/1022x601/resize/1320/f/jpg/assets/multimedia/imagenes/2021/06/04/16228117323644.jpg",4.0f,"Ducati Team","https://nautichandler.com/1337-medium_default/bandera-francia-75x50cm.jpg","163"));
            motoGPList.add(new MotoGP("Marc Márquez","https://okdiario.com/img/2021/03/21/marc-marquez.jpg",4.5f,"Repsol Honda Team","https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Bandera_de_Espa%C3%B1a.svg/1200px-Bandera_de_Espa%C3%B1a.svg.png","142"));
            motoGPList.add(new MotoGP("Brad Binder","https://cdn.24.co.za/files/Cms/General/d/10201/6478b29bf78e4f3080c5fcd6296d947c.jpg",4.0f,"Redbull KTM","https://www.banderasdelmundo.net/wp-content/uploads/2019/08/bandera-de-sudafrica.jpg","142"));
            motoGPList.add(new MotoGP("Aleix Espargaró","https://photos.motogp.com/2021/03/06/41-aleix-espargaro_lg61775_1.big.jpg",4.0f,"Aprilia Racing Team","https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Bandera_de_Espa%C3%B1a.svg/1200px-Bandera_de_Espa%C3%B1a.svg.png","113"));
            motoGPList.add(new MotoGP("Maverick Viñales","https://i.blogs.es/b024a5/vinales-malasia-motogp-2019/840_560.jpg",4.0f,"Aprilia Racing Team","https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Bandera_de_Espa%C3%B1a.svg/1200px-Bandera_de_Espa%C3%B1a.svg.png","106"));
            motoGPList.add(new MotoGP("Pol Espargaro","https://phantom-marca.unidadeditorial.es/44f8f7053f7f39eeccf3cb51a2dcad81/resize/1320/f/jpg/assets/multimedia/imagenes/2021/03/29/16170122155992.jpg",4.5f,"Repsol Honda Team","https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Bandera_de_Espa%C3%B1a.svg/1200px-Bandera_de_Espa%C3%B1a.svg.png","100"));
            motoGPList.add(new MotoGP("Alex Rins","https://i1.wp.com/motoracenation.com/wp-content/uploads/2021/05/552435c05a371070886f3545000284ea6d493d89a3b28b89d960ff605520c44e.png.jpeg?resize=640%2C480&ssl=1",3.5f,"Team Suzuki","https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Bandera_de_Espa%C3%B1a.svg/1200px-Bandera_de_Espa%C3%B1a.svg.png","99"));

            adapterMotoGp = new MymotoRecyclerViewAdapter(motoGPList,getActivity());
            recyclerViewMotoGp.setAdapter(adapterMotoGp);

        }
        return view;
    }
}