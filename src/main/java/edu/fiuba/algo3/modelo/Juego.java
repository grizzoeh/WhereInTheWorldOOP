package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {

    private Ciudad ciudadActual;
    private Edificio ubicacionActual;
    private ArrayList<Ladron> ladrones;
    private int cantidadDeArrestos;

    public Juego(Ciudad ciudadComienzo){

        this.ciudadActual = ciudadComienzo;
        this.cantidadDeArrestos = 0;



    }
}
