package edu.fiuba.algo3.modelo;

public class Coordenadas {

    private double latitud;
    private double longitud;

    public Coordenadas(float latitud, float longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double distanciaA(Coordenadas otrasCoordenadas) {
        double dLat = Math.toRadians(otrasCoordenadas.latitud - this.latitud);
        double dLon = Math.toRadians(otrasCoordenadas.longitud - this.longitud);

        this.latitud = Math.toRadians(this.latitud);
        otrasCoordenadas.latitud = Math.toRadians(this.longitud);

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(this.latitud) *
                        Math.cos(otrasCoordenadas.latitud);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }
}
