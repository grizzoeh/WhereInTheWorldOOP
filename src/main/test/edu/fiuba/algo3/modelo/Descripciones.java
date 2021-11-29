package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Descripciones {
    private ArrayList<String> descripciones;
    private int numeroPista;


    public Descripciones(ArrayList<String> descripciones){
        this.descripciones = descripciones;
        this.numeroPista = 0;

    }

    public String obtenerDescripcionRandom(){

        String pista = descripciones.get(numeroPista % descripciones.size());
        this.numeroPista ++;
        return pista;

    }
}
