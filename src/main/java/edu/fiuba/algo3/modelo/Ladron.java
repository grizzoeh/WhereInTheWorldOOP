package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Ladron {
    private String nombre;
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;
    private Descripcion descripcion;

    public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo, ArrayList<String> descripciones) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.hobby = hobby;
        this.cabello = cabello;
        this.senia = senia;
        this.vehiculo = vehiculo;
        this.descripcion = new Descripcion(descripciones);


    }

    public String obtenerDescripcion() {
        return this.descripcion.obtenerDescripcionRandom();
    }

    public boolean coincideDesripcion(LadronModelo otroLadron){

        boolean resultado = true;

        resultado &= otroLadron.obtenerSexo() == this.sexo || otroLadron.obtenerSexo() == "???";
        resultado &= otroLadron.obtenerHobby() == this.hobby || otroLadron.obtenerHobby() == "???";
        resultado &= otroLadron.obtenerCabello() == this.cabello || otroLadron.obtenerCabello() == "???";
        resultado &= otroLadron.obtenerSenia() == this.senia || otroLadron.obtenerSenia() == "???";
        resultado &= otroLadron.obtenerVehiculo() == this.vehiculo || otroLadron.obtenerVehiculo() == "???";

        return resultado;
    }

    public boolean coincideNombre(String nombre){
        return this.nombre.equals(nombre);
    }

}