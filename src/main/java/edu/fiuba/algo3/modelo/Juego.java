package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {

    private Ciudad ciudadActual;
    private Edificio ubicacionActual;
    private ArrayList<Ladron> ladrones;
    private int cantidadDeArrestos;
    private Reloj reloj;
    private Policia policia;
    private Mision mision;

    public Juego(Ciudad ciudadComienzo, String nombre, Mision mision){
        this.ciudadActual = ciudadComienzo;
        this.cantidadDeArrestos = 0;
        this.reloj = new Reloj();
        this.policia = new Policia(nombre);
    }

    public void viajarA(Ciudad unaCiudad) {
        double distancia = this.ciudadActual.distanciaA(unaCiudad);
        this.reloj.pasarHoras((int)this.policia.duracionViajeconDistancia(distancia));
        this.mision.viajarA(unaCiudad);
        this.ciudadActual = unaCiudad;
    }

    public String policiaEntrarA(Edificio unEdificio) {
        String pista = this.policia.policiaEntrarEnEdificioConMision(unEdificio, this.mision);
        unEdificio.calcularTiempo();
        return pista;
    }

}
