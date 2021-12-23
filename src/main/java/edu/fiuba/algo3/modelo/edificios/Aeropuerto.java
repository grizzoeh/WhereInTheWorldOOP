package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public class Aeropuerto implements Edificio {
    private int ingresos;
    private String nombre = "Aeropuerto";

    public Aeropuerto(){
        this.ingresos = 0;
    }

    @Override
    public String obtenerPistaFacil(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaFacilAeropuerto();
    }

    @Override
    public String obtenerPistaMedia(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaMediaAeropuerto();
    }

    @Override
    public String obtenerPistaDificil(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaDificilAeropuerto();
    }

    @Override
    public int calcularTiempo(){
        return ingresos;
    }
    @Override
    public String toString(){

        return this.nombre;
    }

}
