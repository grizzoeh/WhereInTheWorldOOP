package edu.fiuba.algo3.modelo;


import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.Puerto;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {

    @Test
    public void test01VisitarBancoEnMontreal() {
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        Banco banco = new Banco();
        edificios.add(banco);
        edificios.add(new Biblioteca());
        edificios.add(new Aeropuerto());
        Coordenadas coordenadasMontreal = new Coordenadas(45.508888, -73.561668);
        Coordenadas coordenadasAthens = new Coordenadas(37.983810, 23.727539);
        Ciudad montreal = new Ciudad("Montreal", coordenadasMontreal, "Maple Leaf Flag", "???", "???", "Gaspe Peninsula", "???", "Moose", "???", "French", "???", "???", "???", "Former French Colony", edificios);
        Ciudad athens = new Ciudad("Athens", coordenadasAthens, "Blue and White", "Drachmas", "???", "Aegean Sea", "Figs, Olives", "???", "Plato", "Greek", "???", "???", "Prime Minister", "Hellenic Republic", edificios);
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ciudades.add(athens);
        ArrayList<Ciudad> ciudadesFalsas = new ArrayList<Ciudad>();
        ArrayList<String> descripciones = new ArrayList<String>();
        descripciones.add("La sospechosa tenia el pelo de color castaño");
        Ladron ladron = new Ladron("Juieta", "Femenino", "Tenis", "Castaño", "", "Auto", descripciones);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision);

        String pista = partida.policiaEntrarA(banco);
        String hora = partida.obtenerHora();
        String horaEsperada = "Lunes 8 hs";
        String pistaEsperada = "La sospechosa tenia el pelo de color castaño, La moneda es Drachmas";
        assertEquals(pista, pistaEsperada);
        assertEquals(hora, horaEsperada);
    }

    @Test
    public void test02VisitarBancoYBibliotecaEnMontreal() {
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        Banco banco = new Banco();
        edificios.add(banco);
        Biblioteca biblioteca= new Biblioteca();
        edificios.add(biblioteca);
        edificios.add(new Aeropuerto());
        Coordenadas coordenadasMontreal = new Coordenadas(45.508888, -73.561668);
        Coordenadas coordenadasAthens = new Coordenadas(37.983810, 23.727539);
        Ciudad montreal = new Ciudad("Montreal", coordenadasMontreal, "Maple Leaf Flag", "???", "???", "Gaspe Peninsula", "???", "Moose", "???", "French", "???", "???", "???", "Former French Colony", edificios);
        Ciudad athens = new Ciudad("Athens", coordenadasAthens, "Blue and White", "Drachmas", "???", "Aegean Sea", "Figs, Olives", "???", "Plato", "Greek", "???", "???", "Prime Minister", "Hellenic Republic", edificios);
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ciudades.add(athens);
        ArrayList<Ciudad> ciudadesFalsas = new ArrayList<Ciudad>();
        ArrayList<String> descripciones = new ArrayList<String>();
        descripciones.add("La sospechosa tenia el pelo de color castaño");
        Ladron ladron = new Ladron("Juieta", "Femenino", "Tenis", "Castaño", "", "Auto", descripciones);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision);

        String pistaBanco = partida.policiaEntrarA(banco);
        String horaBanco = partida.obtenerHora();
        String horaEsperadaBanco = "Lunes 8 hs";
        String pistaEsperadaBanco = "La sospechosa tenia el pelo de color castaño, La moneda es Drachmas";
        String pistaBiblioteca = partida.policiaEntrarA(biblioteca);
        String horaBiblioteca = partida.obtenerHora();
        String pistaEsperadaBiblioteca = "La sospechosa tenia el pelo de color castaño, La gente es Plato";
        String horaEsperadaBiblioteca = "Lunes 9 hs";
        assertEquals(pistaBanco, pistaEsperadaBanco);
        assertEquals(horaBanco, horaEsperadaBanco);
        assertEquals(pistaBiblioteca, pistaEsperadaBiblioteca);
        assertEquals(horaBiblioteca, horaEsperadaBiblioteca);
    }

    @Test
    public void test03PoliciaViajaDeMontrealAMexico() {
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        Coordenadas coordenadasMontreal = new Coordenadas(45.508888, -73.561668);
        Coordenadas coordenadasMexico = new Coordenadas(23.634501, -102.552784);
        Ciudad montreal = new Ciudad("Montreal", coordenadasMontreal, "Maple Leaf Flag", "???", "???", "Gaspe Peninsula", "???", "Moose", "???", "French", "???", "???", "???", "Former French Colony", edificios);
        Ciudad mexico = new Ciudad("Mexico City", coordenadasMexico, "Green, White, and Red", "???", "???", "Mount Popocatepetl", "???", "Gila Monster", "Aztecs", "???", "Yucatecan Jewelry", "???", "???", "???", edificios);
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ciudades.add(mexico);
        ArrayList<Ciudad> ciudadesFalsas = new ArrayList<Ciudad>();
        ArrayList<String> descripciones = new ArrayList<String>();
        Ladron ladron = new Ladron("Juieta", "Femenino", "Tenis", "Castaño", "", "Auto", descripciones);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision);

        partida.viajarA(mexico);
        String tiempoEsperadoViaje = "Lunes 9 hs";
        String tiempoViaje = partida.obtenerHora();
        assertEquals(tiempoViaje, tiempoEsperadoViaje);
    }

    @Test
    public void test04EntrarRepetidamenteAEdificios() {
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        Aeropuerto aeropuerto = new Aeropuerto();
        Puerto puerto = new Puerto();
        edificios.add(puerto);
        edificios.add(aeropuerto);
        Coordenadas coordenadasMontreal = new Coordenadas(45.508888, -73.561668);
        Coordenadas coordenadasAthens = new Coordenadas(37.983810, 23.727539);
        Ciudad montreal = new Ciudad("Montreal", coordenadasMontreal, "Maple Leaf Flag", "???", "???", "Gaspe Peninsula", "???", "Moose", "???", "French", "???", "???", "???", "Former French Colony", edificios);
        Ciudad athens = new Ciudad("Athens", coordenadasAthens, "Blue and White", "Drachmas", "???", "Aegean Sea", "Figs, Olives", "???", "Plato", "Greek", "???", "???", "Prime Minister", "Hellenic Republic", edificios);
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ciudades.add(athens);
        ArrayList<Ciudad> ciudadesFalsas = new ArrayList<Ciudad>();
        ArrayList<String> descripciones = new ArrayList<String>();
        descripciones.add("La sospechosa tenia el pelo de color castaño");
        Ladron ladron = new Ladron("Juieta", "Femenino", "Tenis", "Castaño", "", "Auto", descripciones);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision);

        String pistaEsperada = "La sospechosa tenia el pelo de color castaño, La bandera es de color Blue and White";
        String horaEsperada1 = "Lunes 13 hs";
        String horaEsperada2 = "Miércoles 9 hs";
        for (int i = 0; i < 3; i++) {
            String pista = partida.policiaEntrarA(aeropuerto);
            assertEquals(pista, pistaEsperada);
        }
        String hora = partida.obtenerHora();
        assertEquals(hora, horaEsperada1);
        pistaEsperada = "La sospechosa tenia el pelo de color castaño, La bandera es de color Blue and White";
        for (int i = 0; i < 55; i++) {
            String pista = partida.policiaEntrarA(puerto);
            assertEquals(pista, pistaEsperada);
        }
        hora = partida.obtenerHora();
        assertEquals(hora, horaEsperada2);
    }

    @Test
    public void test05PoliciaRecibeCuchilladasYDuerme() {
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        Coordenadas coordenadasMontreal = new Coordenadas(45.508888, -73.561668);
        Ciudad montreal = new Ciudad("Montreal", coordenadasMontreal, "Maple Leaf Flag", "???", "???", "Gaspe Peninsula", "???", "Moose", "???", "French", "???", "???", "???", "Former French Colony", edificios);
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(montreal);
        ArrayList<Ciudad> ciudadesFalsas = new ArrayList<Ciudad>();
        ArrayList<String> descripciones = new ArrayList<String>();
        Ladron ladron = new Ladron("Juieta", "Femenino", "Tenis", "Castaño", "", "Auto", descripciones);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision);

        String horaEsperada = "Martes 8 hs";
        for (int i = 0; i < 16; i++) {
            partida.recibirPunialada();
        }
        String hora = partida.obtenerHora();
        assertEquals(hora, horaEsperada);
    }

}