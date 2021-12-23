package edu.fiuba.algo3.modelo.obtenedoresDePistas;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;

public class ObtenedorDePistasDificiles implements ObtenedorDePistas{
    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision){
        String parte1 = unEdificio.obtenerPistaDificil(unaMision.obtenerProximaCiudad());
        String parte2 = unaMision.obtenerDescripcionSospechoso();
        if (parte1.equals("!!!")) {
            return "Le sospechose no paso por aca";
        }
        if (parte1.equals("???")) {
            return parte2;
        }
        return parte1 + ", " + parte2;
    }
}