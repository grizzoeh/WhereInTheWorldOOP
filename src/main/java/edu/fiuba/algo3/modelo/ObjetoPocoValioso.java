package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.ArrayList;

public class ObjetoPocoValioso extends Objeto{
    
    private String nombre;
    
    private String nombreCiudadRobado;

    public ObjetoPocoValioso() throws IOException {
        super();
    }

    public ArrayList<Ciudad> generarRecorrido() throws IOException {
        GeneradorRercorridos generador = new GeneradorRercorridos();
        return generador.generarRecorridoAleatorio(3, this.nombreCiudadRobado);
    }
}
