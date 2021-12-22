package edu.fiuba.algo3.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.*;
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
    private LectorMisiones lectorMisiones = new LectorMisionesJSON();
    private LectorLadrones lectorLadrones = new LectorLadronesJSON();
    private LectorCiudades lectorCiudades = new LectorCiudadesJSON();
    private boolean activarAtaques;
    private int chancePunialada = 10;
    private int chanceDisparo = 10;

    public Juego(String nombrePolicia, boolean activarAtaques){
        this.cantidadDeArrestos = 0;
        this.sospechososEscapados = 0;
        this.activarAtaques = activarAtaques;
        this.policia = new Policia(nombrePolicia, this.lectorMisiones);
        this.ladrones = new RegistroLadrones(this.lectorLadrones.cargarLadrones());
    }

    public void iniciarNuevaMision() {
        this.reloj = new Reloj();
        this.ordenDeArresto =  new OrdenDeArresto();
        this.mision = policia.nuevaMision(this.lectorCiudades, this.ladrones);
        this.ciudadActual = this.mision.inicioRecorrido();
    }

    public void iniciarNuevaMisionPrueba(Mision mision) {
        this.reloj = new Reloj();
        this.ordenDeArresto = new OrdenDeArresto();
        this.mision = mision;
        this.ciudadActual = this.mision.inicioRecorrido();
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
        if (this.activarAtaques) {
            randomizarAtaques();
        }
        String pista = this.policia.policiaEntrarEnEdificioConMision(unEdificio, this.mision);
        int horas = unEdificio.calcularTiempo();
        this.reloj.pasarHoras(horas);

        return pista;
    }

    public void randomizarAtaques() {
        int punialada = ThreadLocalRandom.current().nextInt(0, this.chancePunialada);
        int disparo = ThreadLocalRandom.current().nextInt(0, this.chanceDisparo);
        if (disparo == 1) {
            this.recibirDisparo();
            return;
        }
        if (punialada == 1) {
            this.recibirPunialada();
            return;
        }
    }

    public LocalDateTime obtenerHora() {
        return this.reloj.obtenerFechaYHora();
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

    public ArrayList<Ciudad> viajesDisponibles(){
        return this.mision.ciudadesDisponibles();
    }
    public ArrayList<Edificio> edificiosDisponibles(){
        return this.ciudadActual.obtenerEdificios();
    }


}

