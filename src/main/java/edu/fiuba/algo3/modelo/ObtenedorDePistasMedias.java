package edu.fiuba.algo3.modelo;

public class ObtenedorDePistasMedias implements ObtenedorDePistas{
    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision){
        String parte1 = unEdificio.obtenerPistaMedia(unaMision.obtenerProximaCiudad());
        String parte2 = unaMision.obtenerDescripcionSospechoso();
        return parte2 + ", " + parte1;
    }
}