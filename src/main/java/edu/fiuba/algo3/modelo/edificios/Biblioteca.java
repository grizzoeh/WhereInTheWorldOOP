package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public class Biblioteca implements Edificio {
    private int ingresos;


    public Biblioteca(){
        this.ingresos = 0;
    }

    @Override
    public String obtenerPistaFacil(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaFacilBiblioteca();
    }

    @Override
    public String obtenerPistaMedia(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaMediaBiblioteca();
    }

    @Override
    public String obtenerPistaDificil(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaDificilBiblioteca();
    }

    @Override
    public int calcularTiempo(){
        return ingresos;
    }
}
