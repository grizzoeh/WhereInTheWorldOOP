package edu.fiuba.algo3.modelo.obtenedoresDePistas;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;

public interface ObtenedorDePistas {
    public String pedirPista(Edificio unEdifico, Mision unaMision);
}
