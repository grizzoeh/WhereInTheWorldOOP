package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.RegistroLadrones;
import edu.fiuba.algo3.modelo.edificios.Edificio;

public class Policia {
    private String nombre;
    private Rango rango;
    private int cantidadDeArrestos;
    private int cantidadDePunialadas;

    public Policia(String nombre){
        this.nombre = nombre;
        this.rango = new Novato();
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

    public Mision nuevaMision(String rutaArchivoCiudades, RegistroLadrones registroLadrones) {
        return this.rango.asignarNuevaMision(rutaArchivoCiudades, registroLadrones);
    }
}
