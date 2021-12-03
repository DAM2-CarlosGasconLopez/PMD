package com.carlos.tiempoencantavieja;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TiempoService {

    @GET()
    Call<List<Tiempo>> obtenerTiempo();
}
