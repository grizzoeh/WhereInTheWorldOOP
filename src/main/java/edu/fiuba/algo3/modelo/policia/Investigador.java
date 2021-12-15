package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasMedias;

public class Investigador implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    private String rutaArchivoMisiones;

    private int kmPorHora;

    public Investigador(){
        this.obtenedorDePistas = new ObtenedorDePistasMedias();
        this.rutaArchivoMisiones = "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelomisionesValiosas.json";
        this.kmPorHora = 1300;
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        return new Sargento();
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }
}
