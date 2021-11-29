package edu.fiuba.algo3.modelo;

public class Novato implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    private GeneradorDeMisiones generadorDeMisiones;
    private int kmPorHora;

    public Novato(){
        this.obtenedorDePistas = new ObtenedorDePistasFaciles();
        this.generadorDeMisiones = new GeneradorDeRoboComun();
        this.kmPorHora = 900;
    }


    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    //@Override
    //public Mision generarMision();

    @Override
    public Rango proximoRango(){
        return new Detective();
    }

    @Override
    public float calcularTiempoViajeA(int distancia){
        return distancia/this.kmPorHora;
    }
}
