package edu.fiuba.algo3.modelo;

public class Ciudad {

    private String nombre;

    private Coordenada locacion;

    private Rango rango;

    public Ciudad(String nombre, Coordenada locacion){
        this. nombre = nombre;
        this.locacion = locacion;
    }

    public boolean tieneNombre(String nombre) {
        return (this.nombre == nombre);
    }

    public Edificio crearEdificio(String nombre){
        return this.rango.crearEdificio(nombre);
    }
}
