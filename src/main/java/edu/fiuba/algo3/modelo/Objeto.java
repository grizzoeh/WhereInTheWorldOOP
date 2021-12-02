package edu.fiuba.algo3.modelo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;



public class Objeto {

    private String nombre;

    private String NombreCiudadRobado;

    public ArrayList<Ciudad> generarRecorrido() throws IOException {
        return null;
    }

    public Objeto() throws IOException {
        RandomAccessFile lector = new RandomAccessFile(new File("E:\\Algoritmos 3\\AlgothiefMyBranch\\src\\txt\\objetos.txt"), "r");
        Random random = new Random();
        int numeroAleatorio = random.nextInt(30);
        String lineaObjeto = lector.readLine();
        for (int contador = 0; contador < numeroAleatorio; contador++) {
            lineaObjeto = lector.readLine();
        }
        String[] nombreYCiudad = lineaObjeto.trim().split(",");

        this.nombre = nombreYCiudad[0];
        this.NombreCiudadRobado = nombreYCiudad[1];
    }
}
