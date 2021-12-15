package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasDificiles;

public class Sargento implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    //private GeneradorDeMisiones generadorDeMisiones;
    private int kmPorHora;

    public Sargento(){
        this.obtenedorDePistas = new ObtenedorDePistasDificiles();
        //this.generadorDeMisiones = new GeneradorDeMisionMuyValiosa();
        this.kmPorHora = 1500;
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        return null;
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }
}
