package com.carlos.a19_firebasedam21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

enum ProviderType{
    BASIC, GOOGLE, FACEBOOK
}

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnRegistrar, btnLogin;

    private FirebaseAnalytics mFirebaseAnalytics;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");
        etEmail = findViewById(R.id.emailText);
        etPassword = findViewById(R.id.passwordText);
        btnRegistrar = findViewById(R.id.registerButton);
        btnLogin = findViewById(R.id.loginButton);


        // Servicio FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("DAM2", "Aplicacion iniciada");
        mFirebaseAnalytics.logEvent("DAM2", bundle);

        // Servicio FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroUsuarioEmailPass();
            }


        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loguearseWithEmailAndPassword();
            }
        });

    }

    private void loguearseWithEmailAndPassword() {
        String _email = etEmail.getText().toString();
        String _password = etPassword.getText().toString();

        final Task<AuthResult> authResultTask = mAuth.createUserWithEmailAndPassword(_email, _password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // El registro es satisfactorio
                            Log.d("FIREBASE", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            iraHome(_email, ProviderType.BASIC);

                        } else {
                            Log.w("FIREBASE", "signInWithEmail:success", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();

                        }
                    }

                });
    }

    private void registroUsuarioEmailPass() {
        String _email = etEmail.getText().toString();
        String _password = etPassword.getText().toString();

        if (!_email.isEmpty() && !_password.isEmpty()) {
            mAuth.createUserWithEmailAndPassword(_email, _password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // El registro es satisfactorio
                                Log.i("FIREBASE", "El usuario ha sido creado correctamente");
                                Toast.makeText(MainActivity.this, "El usuario se ha creado ", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                            } else {
                                Log.w("FIREBASE", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(MainActivity.this, "Ha fallado el crearse un usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }


    private void iraHome(String email, ProviderType tipoLogueo) {
        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        i.putExtra("email", email);
        i.putExtra("metodo", tipoLogueo);

    }
}