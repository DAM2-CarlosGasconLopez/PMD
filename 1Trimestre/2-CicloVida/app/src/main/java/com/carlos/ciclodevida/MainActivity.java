package com.carlos.ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("CICLODEVIDA","Entramos al metodo onCreate()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CICLODEVIDA","Entramos al metodo onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CICLODEVIDA","Entramos al metodo onReturn()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CICLODEVIDA","Entramos al metodo onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("CICLODEVIDA","Entramos al metodo onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("CICLODEVIDA","Entramos al metodo onDestroy()");
    }

}