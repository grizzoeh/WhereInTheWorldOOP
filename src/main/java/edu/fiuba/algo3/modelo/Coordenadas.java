package edu.fiuba.algo3.modelo;

public class Coordenadas {

    private double latitud;
    private double longitud;

    public Coordenadas(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double distanciaA(Coordenadas otrasCoordenadas) {
        double copiaLatitudCiudadActual = this.latitud;
        double copiaLongitudCiudadActual = this.longitud;
        double copiaLatitudOtraCiudad = otrasCoordenadas.latitud;
        double copiaLongitudOtraCiudad = otrasCoordenadas.longitud;
        double dLat = Math.toRadians(copiaLatitudOtraCiudad - copiaLatitudCiudadActual);
        double dLon = Math.toRadians(copiaLongitudOtraCiudad - copiaLongitudCiudadActual);

        copiaLongitudCiudadActual = Math.toRadians(copiaLatitudCiudadActual);
        copiaLatitudOtraCiudad = Math.toRadians(copiaLongitudCiudadActual);

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(copiaLatitudCiudadActual) *
                        Math.cos(copiaLatitudOtraCiudad);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }
}
