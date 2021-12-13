package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.generadoresDeMisiones.GeneradorDeMisionMuyValiosa;
import edu.fiuba.algo3.modelo.generadoresDeMisiones.GeneradorDeMisionValiosa;
import edu.fiuba.algo3.modelo.generadoresDeMisiones.GeneradorDeMisiones;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasMedias;

public class Detective implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    private GeneradorDeMisiones generadorDeMisiones;
    private int kmPorHora;

    public Detective(){
        this.obtenedorDePistas = new ObtenedorDePistasMedias();
        this.generadorDeMisiones = new GeneradorDeMisionValiosa();

        this.kmPorHora = 1100;
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        return new Investigador();
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }
}