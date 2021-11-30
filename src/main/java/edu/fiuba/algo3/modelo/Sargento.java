package edu.fiuba.algo3.modelo;

public class Sargento implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    private int kmPorHora;

    public Sargento(){
        this.obtenedorDePistas = new ObtenedorDePistasDificiles();
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
