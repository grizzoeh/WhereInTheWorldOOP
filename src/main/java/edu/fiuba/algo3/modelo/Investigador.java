package edu.fiuba.algo3.modelo;

public class Investigador implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    private int kmPorHora;

    public Investigador(){
        this.obtenedorDePistas = new ObtenedorDePistasMedias();
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
