package edu.fiuba.algo3.modelo;

public interface Rango {
    public String pedirPista(Edificio unEdificio, Mision unaMision);
    public Rango proximoRango();
    public double calcularTiempoViajeA(double Distancia);
}
