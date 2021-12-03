package com.carlos.a19_firebasedam21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    TextView tvemail, tvmetodo;
    Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvemail = findViewById(R.id.emailTextView);
        tvmetodo = findViewById(R.id.modoTextView);

        // Recuperamos los datos del logiActivity
        Bundle datos = this.getIntent().getExtras();
        String email = datos.getString("email");
        String metodo = datos.getString("metodo");

        tvemail.setText(email);
        tvmetodo.setText(metodo);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                onBackPressed();
            }
        });

    }
}