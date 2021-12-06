package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mision {
    private String objetoRobado;
    private Ladron ladron;
    private ArrayList<Ciudad> recorridoLadron;
    private ArrayList<Ciudad> ciudadesFalsas;
    private int index;


    public Mision(String objetoRobado, Ladron ladron, ArrayList<Ciudad> recorridoLadron, ArrayList<Ciudad> ciudadesFalsas) {
        this.objetoRobado = objetoRobado;
        this.ladron = ladron;
        this.recorridoLadron = recorridoLadron;
        this.ciudadesFalsas = ciudadesFalsas;
        this.index = 0;
    }

    public Ciudad obtenerProximaCiudad() {
        return (this.recorridoLadron.get(index+1));
    }

    public void viajarA(Ciudad unaCiudad) {
        if (this.recorridoLadron.contains(unaCiudad)) {
            this.index++;
        }
    }

    public String obtenerDescripcionSospechoso() {
        return this.ladron.obtenerDescripcion();
    }
}

