package com.carlos.a16_pokefit;

import com.carlos.a16_pokefit.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonService {
    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();
}
