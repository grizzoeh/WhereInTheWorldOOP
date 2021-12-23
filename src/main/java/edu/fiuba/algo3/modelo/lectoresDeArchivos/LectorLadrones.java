package edu.fiuba.algo3.modelo.lectoresDeArchivos;

import edu.fiuba.algo3.modelo.Ladron;

import java.util.ArrayList;
import java.util.HashMap;

public interface LectorLadrones {
    public ArrayList<Ladron> cargarLadrones();
    HashMap<String, ArrayList<String>> obtenerCaracteristicas();
}
