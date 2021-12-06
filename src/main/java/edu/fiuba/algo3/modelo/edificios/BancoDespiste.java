package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.Ciudad;

public class BancoDespiste implements Edificio {
    private int ingresos;


    public BancoDespiste(){
        this.ingresos = 0;
    }

    @Override
    public String obtenerPistaFacil(Ciudad ciudadProxima){
        ingresos++;
        return "No paso el sospechoso por aca";
    }

    @Override
    public String obtenerPistaMedia(Ciudad ciudadProxima){
        ingresos++;
        return "No paso el sospechoso por aca";
    }

    @Override
    public String obtenerPistaDificil(Ciudad ciudadProxima){
        ingresos++;
        return "No paso el sospechoso por aca";
    }

    @Override
    public int calcularTiempo(){
        return ingresos;
    }
}