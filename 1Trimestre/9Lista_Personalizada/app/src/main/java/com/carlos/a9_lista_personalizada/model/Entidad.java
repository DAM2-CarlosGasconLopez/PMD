package com.carlos.a9_lista_personalizada.model;

import java.io.Serializable;

public class Entidad implements Serializable {


    private int imgFoto;    // La imagen es un entero porque hara referencia a la id de la imagen
    private String titulo;
    private String contenido;


    public Entidad(int imgFoto, String titulo, String contenido) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.contenido = contenido;

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
}
