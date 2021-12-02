package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.ArrayList;

public interface Objeto {

    public ArrayList<Ciudad> generarRecorrido() throws IOException;
}
