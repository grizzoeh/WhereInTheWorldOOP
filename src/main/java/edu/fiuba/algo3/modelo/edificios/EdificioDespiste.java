package edu.fiuba.algo3.modelo.edificios;

import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.Ciudad;
import javafx.scene.image.Image;

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

    @Override
    public Image calcularImg() throws FileNotFoundException {

        return null;
    }
}