package edu.fiuba.algo3.modelo;

public class ObtenedorDePistasDificiles implements ObtenedorDePistas{
    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision){
        String parte1 = unEdificio.obtenerPistaDificil(unaMision.obtenerProximaCiudad());
        String parte2 = unaMision.obtenerDescripcionSospechoso();
        return parte2 + ", " + parte1;
    }
}