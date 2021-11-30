package edu.fiuba.algo3.modelo;

public class ObtenedorDePistasFaciles implements ObtenedorDePistas{
    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision){
        String parte1 = unEdificio.obtenerPistaFacil(unaMision.obtenerProximaCiudad());
        String parte2 = unaMision.obtenerDescripcionSospechoso();
        return parte2 + ", " + parte1;
    }
}
