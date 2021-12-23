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

        resultado &= otroLadron.obtenerSexo().equals(this.sexo) || otroLadron.obtenerSexo().equals("???");
        resultado &= otroLadron.obtenerHobby().equals(this.hobby) || otroLadron.obtenerHobby().equals("???");
        resultado &= otroLadron.obtenerCabello().equals(this.cabello) || otroLadron.obtenerCabello().equals("???");
        resultado &= otroLadron.obtenerSenia().equals(this.senia) || otroLadron.obtenerSenia().equals("???");
        resultado &= otroLadron.obtenerVehiculo().equals(this.vehiculo) || otroLadron.obtenerVehiculo().equals("???");

        return resultado;
    }

    public boolean coincideNombre(String nombre){
        return this.nombre.equals(nombre);
    }

    public boolean sosEsteLadron(Ladron otroLadron){
        return this.nombre.equals(otroLadron.nombre);
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}