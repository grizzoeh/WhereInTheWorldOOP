package edu.fiuba.algo3.modelo;

public class Detective implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    private int kmPorHora;

    public Detective(){
        this.obtenedorDePistas = new ObtenedorDePistasMedias();
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