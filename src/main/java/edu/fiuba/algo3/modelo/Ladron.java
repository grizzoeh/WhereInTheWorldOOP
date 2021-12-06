package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Ladron {
    private ArrayList<String> datos;
    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;
    private Descripcion descripcion;

    public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo, ArrayList<String> descripciones) {

        this.datos = new ArrayList<String>(Arrays.asList(nombre,sexo,hobby,cabello,senia,vehiculo));

        this.descripcion = new Descripcion(descripciones);


    }

    public String obtenerDescripcion() {
        return this.descripcion.obtenerDescripcionRandom();
    }

    public boolean coincideDesripcion(Ladron otroLadron){
        boolean resultado = true;

        for (int i = 0; i< this.datos.size(); i++){
            resultado &= this.datos.get(i) == otroLadron.datos.get(i) || otroLadron.datos.get(i) == "???";


        }
        return resultado;
    }

}