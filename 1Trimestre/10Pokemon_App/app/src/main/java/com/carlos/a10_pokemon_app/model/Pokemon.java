package com.carlos.a10_pokemon_app.model;



public class Pokemon {

    private String id;
    private String nombre;

    //le ponngo un entero porque contiene el id de la imagen
    //private int imageId;
    private String imageURL;
    private int soundId;
    private Type type;

    public enum Type{
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String nombre, String imageURL, int soundId, Type type) {
        this.id = id;
        this.nombre = nombre;
        this.imageURL = imageURL;
        this.soundId = soundId;
        this.type = type;
    }

    public int getSoundId() {
        return soundId;
    }

    public String getImageURL() {
        return imageURL;
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
