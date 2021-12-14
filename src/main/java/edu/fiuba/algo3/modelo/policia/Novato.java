package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasFaciles;

public class Novato implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    //private GeneradorDeMisiones generadorDeMisiones;
    private int kmPorHora;

    public Novato(){
        this.obtenedorDePistas = new ObtenedorDePistasFaciles();
        //this.generadorDeMisiones = new GeneradorDeMisionComun();
        this.kmPorHora = 900;
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        return new Detective();
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }
}
