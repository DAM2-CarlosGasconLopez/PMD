package com.carlos.a14_retrofitv1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> obtenerPostDeLapApi();
}
