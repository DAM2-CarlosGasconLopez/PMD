package com.example.proyecto_1_evaluacion_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto_1_evaluacion_android.Restaurante.Restaurantes;
import com.example.proyecto_1_evaluacion_android.TabLayout.Cuenta;
import com.example.proyecto_1_evaluacion_android.TabLayout.MainFragment;
import com.example.proyecto_1_evaluacion_android.TabLayout.ViewTabPagerAdapter;
import com.example.proyecto_1_evaluacion_android.Turismo.TurismoActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewTabPagerAdapter viewTabPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceStats){
        super.onCreate(savedInstanceStats);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        setUpView();
        setUpViewPagerAdapter();

    }

    private void setUpViewPagerAdapter() {
        viewTabPagerAdapter.addFragment(new MainFragment(),"Cantavieja");
        viewTabPagerAdapter.addFragment(new Cuenta(),getString(R.string.fwefwefwf));
        viewPager.setAdapter(viewTabPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

    private void setUpView() {
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        viewTabPagerAdapter= new ViewTabPagerAdapter(getSupportFragmentManager());
    }

}