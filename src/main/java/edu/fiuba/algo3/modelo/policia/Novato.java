package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.RegistroLadrones;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorMisiones;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasFaciles;

public class Novato implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
    private int kmPorHora;
    private String rutaArchivoMisiones;

    public Novato(){
        this.obtenedorDePistas = new ObtenedorDePistasFaciles();
        this.kmPorHora = 900;
        this.rutaArchivoMisiones = "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelomisionesComunes.json";
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        return new Detective();
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }

    @Override
    public Mision asignarNuevaMision(String rutaArchivoCiudades, RegistroLadrones registroLadrones) {
        LectorMisiones lector = new LectorMisiones();
        return lector.cargarMisiones(this.rutaArchivoMisiones, rutaArchivoCiudades, registroLadrones);
    }
}
