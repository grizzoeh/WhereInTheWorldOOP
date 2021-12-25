package edu.fiuba.algo3.modelo.edificios;

import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.Ciudad;
import javafx.scene.image.Image;

public class Biblioteca implements Edificio {
    private int ingresos;
    private String nombre = "Biblioteca";

    public Biblioteca(){
        this.ingresos = 0;
    }

    @Override
    public String obtenerPistaFacil(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaFacilBiblioteca();
    }

    @Override
    public String obtenerPistaMedia(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaMediaBiblioteca();
    }

    @Override
    public String obtenerPistaDificil(Ciudad ciudadProxima){
        ingresos++;
        return ciudadProxima.pistaDificilBiblioteca();
    }

    @Override
    public int calcularTiempo(){
        return ingresos;
    }
    @Override
    public String toString(){

        return this.nombre;
    }

    @Override
    public Image calcularImg() throws FileNotFoundException {

        Image image = new Image(getClass().getResourceAsStream("/escenas/img/biblioteca.PNG"));
        return image;
    }
}
