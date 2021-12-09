package com.example.proyecto_1_evaluacion_android.Turismo.model;

import java.io.Serializable;

public class Entidad implements Serializable {

    private int imgFoto;
    private String titulo;
    private String contenido;
    private String descripcion;

    public Entidad(int imgFoto, String titulo, String contenido, String descripcion) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;
        this.descripcion = descripcion;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
