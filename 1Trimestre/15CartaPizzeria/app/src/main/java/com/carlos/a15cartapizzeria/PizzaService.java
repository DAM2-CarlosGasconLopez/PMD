package com.carlos.a15cartapizzeria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PizzaService {

    @GET("/v2/pizzas")
    Call<List<Pizza>> obtenerPizzas();
}
