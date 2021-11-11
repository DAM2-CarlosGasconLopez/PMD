package com.carlos.a6_dashboard.MotoGp.model;

public class MotoGP {
    private String nombrePiloto;
    private String urlFotoPiloto;
    private Float valoracion;
    private String nombreEquipo;
    private String urlFotoNacionalidad;
    private String puntuacion;

    public MotoGP(String nombrePiloto, String urlFotoPiloto, Float valoracion, String nombreEquipo, String urlFotoNacionalidad, String puntuacion) {
        this.nombrePiloto = nombrePiloto;
        this.urlFotoPiloto = urlFotoPiloto;
        this.valoracion = valoracion;
        this.nombreEquipo = nombreEquipo;
        this.urlFotoNacionalidad = urlFotoNacionalidad;
        this.puntuacion = puntuacion;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    public String getUrlFotoPiloto() {
        return urlFotoPiloto;
    }

    public void setUrlFotoPiloto(String urlFotoPiloto) {
        this.urlFotoPiloto = urlFotoPiloto;
    }

    public Float getValoracion() {
        return valoracion;
    }

    public void setValoracion(Float valoracion) {
        this.valoracion = valoracion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getUrlFotoNacionalidad() {
        return urlFotoNacionalidad;
    }

    public void setUrlFotoNacionalidad(String urlFotoNacionalidad) {
        this.urlFotoNacionalidad = urlFotoNacionalidad;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
}
