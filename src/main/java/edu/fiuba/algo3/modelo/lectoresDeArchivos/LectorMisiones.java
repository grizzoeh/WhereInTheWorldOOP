package edu.fiuba.algo3.modelo.lectoresDeArchivos;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.RegistroLadrones;

public interface LectorMisiones {
    public Mision cargarMisiones(LectorCiudades lectorCiudades, RegistroLadrones registroLadrones);
    public void ascender();
}
