package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.GeneradorRercorridos;
import edu.fiuba.algo3.modelo.Objeto;

import java.io.IOException;
import java.util.ArrayList;

public class ObjetoValioso extends Objeto {
    
    private String nombreCiudadRobado;
    
    private String nombre;

    public ObjetoValioso() throws IOException {
        super();
    }


    public ArrayList<Ciudad> generarRecorrido() throws IOException {
        GeneradorRercorridos generador = new GeneradorRercorridos();
        return generador.generarRecorridoAleatorio(5, this.nombreCiudadRobado);
    }
    
    
}
