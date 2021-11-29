package edu.fiuba.algo3.modelo;

public interface Edificio {
    public String obtenerPistaFacil(Ciudad ciudadProxima);
    public String obtenerPistaMedia(Ciudad ciudadProxima);
    public String obtenerPistaDificil(Ciudad ciudadProxima);
    public int calcularTiempo();
}
