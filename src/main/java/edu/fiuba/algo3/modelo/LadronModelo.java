package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class LadronModelo {
    private String sexo;
    private String hobby;
    private String cabello;
    private String senia;
    private String vehiculo;

    public LadronModelo(String sexo, String hobby, String cabello, String senia, String vehiculo) {

        this.sexo = sexo;
        this.hobby = hobby;
        this.cabello = cabello;
        this.senia = senia;
        this.vehiculo = vehiculo;

    }

    public String obtenerSexo(){
        return this.sexo;

    }

    public String obtenerHobby(){
        return this.hobby;

    }

    public String obtenerCabello(){
        return this.cabello;

    }
    public String obtenerSenia(){
        return this.senia;

    }
    public String obtenerVehiculo(){
        return this.vehiculo;

    }



}
