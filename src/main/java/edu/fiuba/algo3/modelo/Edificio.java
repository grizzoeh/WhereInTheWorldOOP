package edu.fiuba.algo3.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Edificio {

    private BufferedReader archivo;
    private String nombreCiudadProxima;
    private String nombre;
    public Edificio(String nombreCiudadProxima, String pathArchivo, String nombre){
        try {
            this.archivo = new BufferedReader(new FileReader(pathArchivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.nombreCiudadProxima = nombreCiudadProxima;
        this.nombre = nombre;
    }
}
