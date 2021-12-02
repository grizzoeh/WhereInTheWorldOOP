package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.ArrayList;

public class ObjetoMuyValioso implements Objeto{

    public ObjetoMuyValioso(){

    }

    public ArrayList<Ciudad> generarRecorrido() throws IOException {
        GeneradorRercorridos generador = new GeneradorRercorridos();
        return generador.generarRecorridoAleatorio(5);
    }
}
