package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ladron {

    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;
    private Descripciones descripciones;

    public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo, ArrayList<String> descripciones) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.hobby = hobby;
        this.cabello = cabello;
        this.senia = senia;
        this.vehiculo = vehiculo;
        this.descripciones = new Descripciones(descripciones);
    }
}