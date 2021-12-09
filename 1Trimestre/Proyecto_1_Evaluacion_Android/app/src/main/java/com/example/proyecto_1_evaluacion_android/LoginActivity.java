package com.example.proyecto_1_evaluacion_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

enum ProviderType {
    BASIC,
    GOOGLE
}
public class LoginActivity extends AppCompatActivity {

    Button btnRegistrarbutton, btnLoginbutton,btnLoginGoogleb;
    EditText txtEmailtext, txtPasswdtext;
    LinearLayout authLayout;


    // FIREBASE
    private FirebaseAuth firebaseAuth;
    // GOOGLE
    private GoogleSignInClient mGoogleSignInClient;


    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        authLayout.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        txtEmailtext = findViewById(R.id.txtEmail);
        txtPasswdtext = findViewById(R.id.txtPaswwd);
        btnRegistrarbutton = findViewById(R.id.btnRegistrar);
        btnLoginbutton = findViewById(R.id.btnLogin);
        btnLoginGoogleb = findViewById(R.id.btnLoginGoogle);


        authLayout = findViewById(R.id.authLayout);


        // Inicializo Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();
        // Comprobar si tenemos una sesion abierta
        comprobar();


        btnRegistrarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registroUsuarioEmailPass();
            }
        });

        btnLoginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loguarseConEmailAndPassword();
            }
        });

        btnLoginGoogleb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                logueoConGoogle();
            }
        });


    }


    private void logueoConGoogle() {
        // Al hacer click en el boton Login with Google
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("231445279827-r22mjgi7dog4kkhiu0t4co4peenqdn28.apps.googleusercontent.com")
                .requestEmail()
                .build();
        // Nos creamos el GoogleSignIn Client conlas opciones específicas de gso
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        startActivityForResult(mGoogleSignInClient.getSignInIntent(), 100);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == 100){
            //Esto significa que venimos de loguearnos con Google
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("FIREBASE", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("FIREBASE", "Google sign in failed", e);
            }

        }
    }



    private void firebaseAuthWithGoogle(String idToken) {

        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FIREBASE", "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            iraHome(user.getEmail(), ProviderType.GOOGLE);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FIREBASE", "signInWithCredential:failure", task.getException());

                        }
                    }
                });
    }


    private void comprobar() {
        SharedPreferences sesion = getSharedPreferences("sesion", Context.MODE_PRIVATE);
        String _email = sesion.getString("email", null);
        String _metodo = sesion.getString("metodo", null);
        if ( _email != null && _metodo != null){
            authLayout.setVisibility(View.INVISIBLE);
            iraHome(_email, ProviderType.valueOf(_metodo));
        }
    }

    private void loguarseConEmailAndPassword() {
        String _email = txtEmailtext.getText().toString();
        String _password = txtPasswdtext.getText().toString();
        if( !_email.isEmpty() && !_password.isEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(_email, _password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("FIREBASE", "signInWithEmail:success");
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                iraHome(_email, ProviderType.BASIC);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("FIREBASE", "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this,"ha fallado",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else{
            Toast.makeText(LoginActivity.this, "campoincompleto", Toast.LENGTH_SHORT).show();
        }
    }
    private void iraHome(String email, ProviderType tipoLogueo) {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        i.putExtra("email", email );
        i.putExtra("metodo", tipoLogueo.toString());
        startActivity(i);
    }

    private void registroUsuarioEmailPass() {

        String _email = txtEmailtext.getText().toString();
        String _password = txtPasswdtext.getText().toString();

        if ( !_email.isEmpty() && !_password.isEmpty() ){
            // Si el email y el password introducido no estan vacios
            firebaseAuth.createUserWithEmailAndPassword( _email, _password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if ( task.isSuccessful() ){
                                // El registro es satisfactorio
                                Log.i("FIREBASE","El usuario ha sido creado correctamente");
                                Toast.makeText(LoginActivity.this, "El Usuario SE HA CREADO ", Toast.LENGTH_LONG).show();
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                            } else {
                                Log.w("FIREBASE", "createUserWithEmailAndPassword: failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Ha fallado el CREARSE un usuario", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
        }else{
            Toast.makeText(LoginActivity.this, "R.string.camposIncompletos", Toast.LENGTH_SHORT).show();
        }
    }

}
