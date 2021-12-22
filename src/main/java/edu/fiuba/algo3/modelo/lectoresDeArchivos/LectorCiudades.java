package edu.fiuba.algo3.modelo.lectoresDeArchivos;

import edu.fiuba.algo3.modelo.Ciudad;

import java.util.ArrayList;

public interface LectorCiudades {
    public ArrayList<Ciudad> cargarCiudades(ArrayList<String> nombresCiudades, Boolean esDespiste);

}
