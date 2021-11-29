package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ciudad {
    private String nombre;
    private ArrayList<Edificio> edificios;
    //private Coordenada coordenada;
    private String bandera;
    private String moneda;
    private String geografia;
    private String landmarks;
    private String industrias;
    private String animales;
    private String gente;
    private String lenguaje;
    private String arte;
    private String religion;
    private String lider;
    private String extra;


    public Ciudad(String nombre,String bandera,String moneda,String geografia,String landmarks,String industrias,String animales,String gente,String lenguaje,String arte,String religion,String lider,String extra){
        this.nombre = nombre;
        this.bandera = bandera;
        this.moneda = moneda;
        this.geografia = geografia;
        this.landmarks = landmarks;
        this.industrias = industrias;
        this.animales = animales;
        this.gente = gente;
        this.lenguaje = lenguaje;
        this.arte = arte;
        this.religion = religion;
        this.lider = lider;
        this.extra = extra;

        this.edificios.add(new Aeropuerto());
        this.edificios.add(new Puerto());
        this.edificios.add(new Banco());
        this.edificios.add(new Biblioteca());
        //this.edificios.add(new Bolsa());

    }

    public int distanciaA(Ciudad otraCiudad){
        return None;
    } //TO DO

    public String pistaFacilAeropuerto(){
        return ("La bandera es de color" + this.bandera);
    }

    public String pistaMediaAeropuerto(){
        return ("El lenguaje del pais es" + this.lenguaje);
    }
    public String pistaDificilAeropuerto(){
        return ("Los landmarks son" + this.landmarks);
    }
    public String pistaFacilBanco(){
        return ("La moneda es " + this.moneda);
    }
    public String pistaMediaBanco(){
        return ("Las industrias son" + this.industrias);
    }

    public String pistaDificilBanco(){
        return ("Los animales son" + this.animales);
    }

    public String pistaFacilBiblioteca(){
        return ("La gente es" + this.gente);
    }
    public String pistaMediaBiblioteca(){
        return ("La religion principal es" + this.religion);
    }

    public String pistaDificilBiblioteca(){
        return ("El lider es" + this.lider);
    }


}
