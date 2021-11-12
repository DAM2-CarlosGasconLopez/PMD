package com.carlos.a14_retrofitv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView myJsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myJsonTextView = findViewById(R.id.jsonTxt);

        // 1 - Creamos una instancia de reprofit
        Retrofit retrofit = new Retrofit.Builder()
                // 2 - Ponemos la URL base
                .baseUrl("https://jsonplaceholder.typicode.com")
                // 3 - Necesitamos añadir un converter a esta response
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // 4 - Llamamos a la interfaz con create y la clase de la interfaz
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        // 5 - Creamos un Call del tipo de modelo de datos que vamos a recuperar
        Call<List<Post>> call = jsonPlaceHolderApi.obtenerPostDeLapApi();
        // 6 - El execute lo hara en el Main Thread, y no es recomendable hacerlo
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                // 7 - Manejamos la respuesta exitosa
                if (!response.isSuccessful()){
                    // no es un problema de tipo Failture, si no cualquier codigo http que no sea el 200
                    myJsonTextView.setText("codigo: " + response.code());
                }
                // 9 - Creamos una lista que tenga los post
                List<Post> listaPosts = response.body();
                // 10 - Creamos un for para recupèrar los elementos de la lista
                for (Post post: listaPosts){
                    String content = "";
                    content +="userID" + post.getUserId() + "\n";
                    content +="id" + post.getId() + "\n";
                    content +="title" + post.getTitle() + "\n";
                    content +="body" + post.getBody() + "\n\n\n";
                    myJsonTextView.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                // 8 - Aqui se manejan los errores di no se ha traido bien la respuesta
                myJsonTextView.setText((t.getMessage()));
            }
        });



    }
}