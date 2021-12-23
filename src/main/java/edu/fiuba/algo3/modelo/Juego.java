package edu.fiuba.algo3.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import edu.fiuba.algo3.controlador.ControladorPrincipal2;
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
    private HashMap<String, ArrayList<String>> caracteristicasLadrones = this.lectorLadrones.obtenerCaracteristicas();
    private ControladorPrincipal2 controladorInterfazGrafica;
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
        this.controladorInterfazGrafica.actualizarFechaYHora(this.reloj.obtenerFechaYHora());
        this.controladorInterfazGrafica.actualizarCiudadActual(this.ciudadActual.obtenerNombre());
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
        if (!this.reloj.quedaTiempo()) {
            this.ladronEscapa();
        }
        this.mision.viajarA(unaCiudad);
        this.ciudadActual = unaCiudad;
        this.controladorInterfazGrafica.actualizarCiudadActual(this.ciudadActual.obtenerNombre());
        this.controladorInterfazGrafica.actualizarFechaYHora(this.reloj.obtenerFechaYHora());
    }

    public String policiaEntrarA(Edificio unEdificio) {
        if (mision.finalDelRecorrido(this.ciudadActual)) {
            this.ordenDeArresto.atraparLadron(this, this.mision);
            return "";
        }
        if (this.activarAtaques) {
            randomizarAtaques();
        }
        String pista = this.policia.policiaEntrarEnEdificioConMision(unEdificio, this.mision);
        int horas = unEdificio.calcularTiempo();
        this.reloj.pasarHoras(horas);
        if (!this.reloj.quedaTiempo()) {
            this.ladronEscapa();
            return "";
        }
        this.controladorInterfazGrafica.mostrarPista(pista);
        this.controladorInterfazGrafica.actualizarFechaYHora(this.reloj.obtenerFechaYHora());

        return pista;
    }

    public void randomizarAtaques() {
        int punialada = ThreadLocalRandom.current().nextInt(0, this.chancePunialada);
        int disparo = ThreadLocalRandom.current().nextInt(0, this.chanceDisparo);
        if (disparo == 1) {
            this.recibirDisparo();
            this.controladorInterfazGrafica.recibirDisparo();
            this.controladorInterfazGrafica.actualizarFechaYHora(this.reloj.obtenerFechaYHora());
            return;
        }
        if (punialada == 1) {
            this.recibirPunialada();
            this.controladorInterfazGrafica.recibirPunialada();
            this.controladorInterfazGrafica.actualizarFechaYHora(this.reloj.obtenerFechaYHora());
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
        this.controladorInterfazGrafica.cerrarVentanas();
        this.controladorInterfazGrafica.ladronAtrapado();
    }

    public void ladronEscapa() {
        this.sospechososEscapados++;
        this.controladorInterfazGrafica.cerrarVentanas();
        this.controladorInterfazGrafica.ladronEscapa();
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

    public ArrayList<Ladron> generarOrdenDeArresto(){
        return this.ordenDeArresto.posiblesLadrones(this.ladrones);
    }

    public ArrayList<Ciudad> viajesDisponibles(){
        return this.mision.ciudadesDisponibles();
    }

    public ArrayList<Edificio> edificiosDisponibles(){
        return this.ciudadActual.obtenerEdificios();
    }

    public HashMap<String, ArrayList<String>> obtenerCaracteristicas() {
        return this.caracteristicasLadrones;
    }

    public void establecerInterfazGrafica(ControladorPrincipal2 controladorInterfazGrafica) {
        this.controladorInterfazGrafica = controladorInterfazGrafica;
    }

}

