package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.RegistroLadrones;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorCiudades;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorMisiones;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasFaciles;

public class Novato implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    private int kmPorHora;
    private LectorMisiones lectorMisiones;

    public Novato(LectorMisiones lectorMisiones){
        this.obtenedorDePistas = new ObtenedorDePistasFaciles();
        this.kmPorHora = 900;
        this.lectorMisiones = lectorMisiones;
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        this.lectorMisiones.ascender();
        return new Detective(this.lectorMisiones);
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }

    @Override
    public Mision asignarNuevaMision(LectorCiudades lectorCiudades, RegistroLadrones registroLadrones) {
        return this.lectorMisiones.cargarMisiones(lectorCiudades, registroLadrones);
    }
}
