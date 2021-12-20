package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.RegistroLadrones;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorCiudades;

public interface Rango {
    public String pedirPista(Edificio unEdificio, Mision unaMision);
    public Rango proximoRango();
    public double calcularTiempoViajeA(double Distancia);
    public Mision asignarNuevaMision(LectorCiudades lectorCiudades, RegistroLadrones registroLadrones);
}
