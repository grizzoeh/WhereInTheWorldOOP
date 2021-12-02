package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.ArrayList;

public class ObjetoPocoValioso implements Objeto{

    public ArrayList<Ciudad> generarRecorrido() throws IOException {
        GeneradorRercorridos generador = new GeneradorRercorridos();
        return generador.generarRecorridoAleatorio(4);
    }
}
