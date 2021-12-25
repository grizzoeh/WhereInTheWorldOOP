package edu.fiuba.algo3.modelo.edificios;

import java.io.FileNotFoundException;

import edu.fiuba.algo3.modelo.Ciudad;
import javafx.scene.image.Image;

public interface Edificio {
    public String obtenerPistaFacil(Ciudad ciudadProxima);
    public String obtenerPistaMedia(Ciudad ciudadProxima);
    public String obtenerPistaDificil(Ciudad ciudadProxima);
    public int calcularTiempo();
    public Image calcularImg() throws FileNotFoundException;
}
