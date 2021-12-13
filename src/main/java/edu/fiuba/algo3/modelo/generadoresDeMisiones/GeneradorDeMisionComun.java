package edu.fiuba.algo3.modelo.generadoresDeMisiones;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorArchivoMisiones;

public class GeneradorDeMisionComun implements GeneradorDeMisiones{
    private String ruta;
    private LectorArchivoMisiones lectoDeArchivos;

    public GeneradorDeMisionComun(){
        this.ruta = "src/main/java/edu/fiuba/algo3/modelo/lectoresDeArchivos/modelomisionesComunes.json";
        this.lectoDeArchivos =  new LectorArchivoMisiones();
    }
    @Override
    public Mision generarMision(){
        return this.lectoDeArchivos.obtenerMisionRandom(this.ruta);
    }

}
