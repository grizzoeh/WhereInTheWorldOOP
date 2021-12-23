package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public class EdificioDespiste implements Edificio {
    private int ingresos;
    private String nombreEdificio;


    public EdificioDespiste(String nombreEdificio){

        this.ingresos = 0;
        this.nombreEdificio = nombreEdificio;
    }

    @Override
    public String obtenerPistaFacil(Ciudad ciudadProxima){
        ingresos++;
        return "!!!";
    }

    @Override
    public String obtenerPistaMedia(Ciudad ciudadProxima){
        ingresos++;
        return "!!!";
    }

    @Override
    public String obtenerPistaDificil(Ciudad ciudadProxima){
        ingresos++;
        return "!!!";
    }

    @Override
    public int calcularTiempo(){
        return ingresos;
    }

    @Override
    public String toString(){
        return this.nombreEdificio;
    }
}