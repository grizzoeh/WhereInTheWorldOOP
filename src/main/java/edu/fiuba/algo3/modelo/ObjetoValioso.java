package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.GeneradorRercorridos;
import edu.fiuba.algo3.modelo.Objeto;

import java.io.IOException;
import java.util.ArrayList;

public class ObjetoValioso implements Objeto {

    public ArrayList<Ciudad> generarRecorrido() throws IOException {
        GeneradorRercorridos generador = new GeneradorRercorridos();
        return generador.generarRecorridoAleatorio(6);
    }
}
