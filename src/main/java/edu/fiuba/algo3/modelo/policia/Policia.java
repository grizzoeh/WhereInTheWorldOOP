package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.RegistroLadrones;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorCiudades;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorMisiones;

public class Policia {
    private String nombre;
    private Rango rango;
    private int cantidadDeArrestos;
    private int cantidadDePunialadas;

    public Policia(String nombre, LectorMisiones lectorMisiones){
        this.nombre = nombre;
        this.rango = new Novato(lectorMisiones);
        this.cantidadDeArrestos = 0;
        this.cantidadDePunialadas = 0;
    }

    public void ascender(){
        this.rango = this.rango.proximoRango();
    }

    public String policiaEntrarEnEdificioConMision(Edificio unEdificio, Mision unaMision){
        return this.rango.pedirPista(unEdificio, unaMision);

    }

    public double duracionViajeconDistancia(double unaDistancia){
        return (this.rango.calcularTiempoViajeA(unaDistancia));
    }

    public int recibirPunialada(){
        this.cantidadDePunialadas++;
        if (cantidadDePunialadas == 1) {
            return 2;
        }
        return 1;
    }

    public int recibirDisparo(){

        return 4;
    }

    public Mision nuevaMision(LectorCiudades lectorCiudades, RegistroLadrones registroLadrones) {
        return this.rango.asignarNuevaMision(lectorCiudades, registroLadrones);
    }
}
