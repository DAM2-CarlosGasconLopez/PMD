package com.carlos.tiempoencantavieja;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.DateTimeException;
import java.util.Date;

public class Tiempo {
    @SerializedName("fecha")
    @Expose
    private String fecha;

    @SerializedName("precipitacion")
    @Expose
    private Double Precipitacion;

    @SerializedName("viento")
    @Expose
    private Double Viento;

    @SerializedName("grados")
    @Expose
    private Double Grados;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecipitacion() {
        return Precipitacion;
    }

    public void setPrecipitacion(Double precipitacion) {
        Precipitacion = precipitacion;
    }

    public Double getViento() {
        return Viento;
    }

    public void setViento(Double viento) {
        Viento = viento;
    }

    public Double getGrados() {
        return Grados;
    }

    public void setGrados(Double grados) {
        Grados = grados;
    }
}
