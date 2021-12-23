package edu.fiuba.algo3.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import javafx.scene.image.Image;

public class Ciudad {
    private String nombre;
    private ArrayList<Edificio> edificios;
    private Coordenadas coordenadas;
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
    private String descripcion;
    private String ruta;


    public Ciudad(String nombre, Coordenadas coordenadas, String bandera, String moneda, String geografia, String landmarks, String industrias, String animales, String gente, String lenguaje, String arte, String religion, String lider, String extra, ArrayList<Edificio> edificios, String descripcion, String ruta){
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
        this.edificios = edificios;
        this.coordenadas = coordenadas;
        this.descripcion = descripcion;
        this.ruta = ruta;
    }

    public String obtenerNombre(){ return this.nombre; }

    public double distanciaA(Ciudad otraCiudad){
        return this.coordenadas.distanciaA(otraCiudad.coordenadas);
    }

    public String pistaFacilAeropuerto(){
        return this.bandera.equals("???") ? this.bandera : ("Le sospechose subio a un avion que llevava una bandera " + this.bandera);
    }
    public String pistaMediaAeropuerto(){
        return this.lenguaje.equals("???") ? this.lenguaje : ("Le sospechose cargaba con varios diccionarios de español a " + this.lenguaje);
    }
    public String pistaDificilAeropuerto(){
        return this.landmarks.equals("???") ? this.landmarks : ("Le sospechose tenia la intencion de visitar " + this.landmarks);
    }
    public String pistaFacilBanco(){
        return this.moneda.equals("???") ? this.moneda : ("Le sospechose cambio su dinero por " + this.moneda);
    }
    public String pistaMediaBanco(){
        return this.industrias.equals("???") ? this.industrias : ("Estaba muy interesade en las industrias de " + this.industrias);
    }
    public String pistaDificilBanco(){
        return this.animales.equals("???") ? this.animales : ("Le sospechose estaba leyendo informacion acerca de " + this.animales);
    }
    public String pistaFacilBiblioteca(){
        return this.gente.equals("???") ? this.gente : ("Le sospechose estaba leyendo informacion acerca de " + this.gente);
    }
    public String pistaMediaBiblioteca(){
        return this.religion.equals("???") ? this.religion : ("Parecia que le sospechose estaba muy interesade en " + this.religion);
    }
    public String pistaDificilBiblioteca(){
        return this.lider.equals("???") ? this.lider : ("Le sospechose invstigó acerca del " + this.lider + " del pais al que se dirigia");
    }
    public ArrayList<Edificio> obtenerEdificios() {
        return this.edificios;
    }
    public String obtenerDescripcion() {
        return this.descripcion;
    }
    @Override
    public String toString(){
        return this.obtenerNombre();
    }

    public Image calcularImg() throws FileNotFoundException {
        FileInputStream input = new FileInputStream(src/main/);
        Image image = new Image(input);
        return image;
    }

}

