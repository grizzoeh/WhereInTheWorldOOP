package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.policia.Policia;

public class Juego {

    private Ciudad ciudadActual;
    private Edificio ubicacionActual;
    private RegistroLadrones ladrones;
    private int cantidadDeArrestos;
    private Reloj reloj;
    private Policia policia;
    private Mision mision;
    private OrdenDeArresto ordenDeArresto;
    private int sospechososEscapados;

    public Juego(Ciudad ciudadComienzo, String nombre, Mision mision, ArrayList<Ladron> ladrones) {
        this.ciudadActual = ciudadComienzo;
        this.cantidadDeArrestos = 0;
        this.reloj = new Reloj();
        this.policia = new Policia(nombre);
        this.mision = mision;
        this.ladrones = new RegistroLadrones(ladrones);
        this.ordenDeArresto = new OrdenDeArresto();
    }

    public void viajarA(Ciudad unaCiudad) {
        double distancia = this.ciudadActual.distanciaA(unaCiudad);
        this.reloj.pasarHoras((int)this.policia.duracionViajeconDistancia(distancia));
        this.mision.viajarA(unaCiudad);
        this.ciudadActual = unaCiudad;

    }

    public String policiaEntrarA(Edificio unEdificio) {

        if (mision.finalDelRecorrido(this.ciudadActual)) {
            this.ordenDeArresto.atraparLadron(this, this.mision);
            return "El ladron ha sido atrapado!";
        }

        String pista = this.policia.policiaEntrarEnEdificioConMision(unEdificio, this.mision);
        int horas = unEdificio.calcularTiempo();
        this.reloj.pasarHoras(horas);

        return pista;
    }

    public String obtenerHora() {
        return this.reloj.aString();
    }

    public void recibirPunialada() {
        int horas = this.policia.recibirPunialada();
        this.reloj.pasarHoras(horas);
    }

    public void recibirDisparo() {
        int horas = this.policia.recibirDisparo();
        this.reloj.pasarHoras(horas);
    }

    public void ladronAtrapado() {
        this.cantidadDeArrestos++;
        if (this.cantidadDeArrestos == 5 || this.cantidadDeArrestos == 15 || this.cantidadDeArrestos == 35) {
            this.policia.ascender();
        }
    }

    public void asignarMision(Mision mision, Ciudad ciudadComienzo) {
        this.mision = mision;
        this.ciudadActual = ciudadComienzo;
    }

    public void ladronEscapa(){
        this.sospechososEscapados++;
    }

    public Policia obtenerPolicia() { // Unicamente para las pruebas
        return this.policia;
    }

    public int obtenerCantidadDeArrestos() {
        return this.cantidadDeArrestos;
    }

    public int obtenerCantidadDeEscapados() {
        return  this.sospechososEscapados;
    }

    public void OrdenActualizarVehiculo(String vehiculo) {
        this.ordenDeArresto.actualizarVehiculo(vehiculo);
    }

    public void OrdenActualizarHobby(String hobby) {
        this.ordenDeArresto.actualizarHobby(hobby);
    }

    public void OrdenActualizarSexo(String sexo) {
        this.ordenDeArresto.actualizarSexo(sexo);
    }

    public void OrdenActualizarCabello(String cabello) {
        this.ordenDeArresto.actualizarCabello(cabello);
    }

    public void OrdenActualizarSenia(String senia) {
        this.ordenDeArresto.actualizarSenia(senia);
    }

    public void generarOrdenDeArresto(){
        this.ordenDeArresto.posiblesLadrones(this.ladrones);
    }

}

