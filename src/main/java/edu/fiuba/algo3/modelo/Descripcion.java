package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Descripcion {
    private ArrayList<String> pistas;
    private int index;

    public Descripcion(ArrayList<String> pistas) {
        this.pistas = pistas;
        this.index = 0;
    }

    public String obtenerDescripcionRandom(){
        String descripcion = pistas.get(index);
        this.index++;
        this.index = index % this.pistas.size();
        return  descripcion;
    }


}
