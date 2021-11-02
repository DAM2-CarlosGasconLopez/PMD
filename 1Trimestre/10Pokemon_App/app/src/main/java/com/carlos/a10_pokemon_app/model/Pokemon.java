package com.carlos.a10_pokemon_app.model;



public class Pokemon {

    private String id;
    private String nombre;

    //le ponngo un entero porque contiene el id de la imagen
    private int imageId;
    private Type type;

    public enum Type{
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String nombre, int imageId, Type type) {
        this.id = id;
        this.nombre = nombre;
        this.imageId = imageId;
        this.type = type;
    }

    public int getImageId() {
        return imageId;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Type getType() {
        return type;
    }
}
