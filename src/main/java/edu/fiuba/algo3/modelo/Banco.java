package edu.fiuba.algo3.modelo;

public class Banco implements Edificio {
    private int ingresos;


    public Banco(){
        this.ingresos = 0;
    }

    @Override
    public String obtenerPistaFacil(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaFacilBanco();
    }

    @Override
    public String obtenerPistaMedia(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaMediaBanco();
    }

    @Override
    public String obtenerPistaDificil(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaDificilBanco();
    }

    @Override
    public int calcularTiempo(){
        return ingresos;
    }
}
