package edu.fiuba.algo3.modelo;

public interface Rango {
    public String pedirPista(Edificio unEdificio, Mision unaMision);
    public Mision generarMision();
    public Rango proximoRango();
    public float calcularTiempoViajeA(int Distancia);
}
