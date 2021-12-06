package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.policia.Policia;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.Puerto;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(ladron);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision, ladrones);

        String pista = partida.policiaEntrarA(banco);
        String hora = partida.obtenerHora();
        String horaEsperada = "Lunes 8 hs";
        String pistaEsperada = "La moneda es Drachmas, La sospechosa tenia el pelo de color castaño";
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
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(ladron);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision, ladrones);

        String pistaBanco = partida.policiaEntrarA(banco);
        String horaBanco = partida.obtenerHora();
        String horaEsperadaBanco = "Lunes 8 hs";
        String pistaEsperadaBanco = "La moneda es Drachmas, La sospechosa tenia el pelo de color castaño";
        String pistaBiblioteca = partida.policiaEntrarA(biblioteca);
        String horaBiblioteca = partida.obtenerHora();
        String pistaEsperadaBiblioteca = "La gente es Plato, La sospechosa tenia el pelo de color castaño";
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
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(ladron);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision, ladrones);

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
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(ladron);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision, ladrones);

        String pistaEsperada = "La bandera es de color Blue and White, La sospechosa tenia el pelo de color castaño";
        String horaEsperada1 = "Lunes 13 hs";
        String horaEsperada2 = "Miércoles 9 hs";
        for (int i = 0; i < 3; i++) {
            String pista = partida.policiaEntrarA(aeropuerto);
            assertEquals(pista, pistaEsperada);
        }
        String hora = partida.obtenerHora();
        assertEquals(hora, horaEsperada1);
        pistaEsperada = "La bandera es de color Blue and White, La sospechosa tenia el pelo de color castaño";
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
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(ladron);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision, ladrones);

        String horaEsperada = "Martes 8 hs";
        for (int i = 0; i < 16; i++) {
            partida.recibirPunialada();
        }
        String hora = partida.obtenerHora();
        assertEquals(hora, horaEsperada);
    }

    @Test
    public void test06PoliciaInvestigadorViajaDeMonterealAMexico() {
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
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(ladron);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision, ladrones);
        Policia policia = partida.obtenerPolicia();
        policia.ascender(); // Sube a Detective
        policia.ascender(); // Sube a Investigador
        partida.viajarA(mexico);

        String tiempoEsperadoViaje = "Lunes 8 hs";
        String tiempoViaje = partida.obtenerHora();
        assertEquals(tiempoViaje, tiempoEsperadoViaje);
    }

    @Test
    public void test07PoliciaCargaDatosEnOrdenDeArrestoYBuscaSospechosos() {
        ArrayList<String> descripciones = new ArrayList<String>();
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        Ladron ladron1 = new Ladron("Pedro", "Masculino", "Futbol", "Castaño", "Tatuaje en la cara", "Auto", descripciones);
        ladrones.add(ladron1);
        Ladron ladron2 = new Ladron("Juan", "Masculino", "Tenis", "Rubio", "Cicatriz en la pierna", "Moto", descripciones);
        ladrones.add(ladron2);
        Ladron ladron3 = new Ladron("Juieta", "Femenino", "Tenis", "Castaño", "Pecas", "Auto", descripciones);
        ladrones.add(ladron3);

        OrdenDeArresto computadora = new OrdenDeArresto();
        computadora.actualizarSexo("Masculino");
        ArrayList<Ladron> sospechosos1 = computadora.posiblesLadrones(ladrones);

        OrdenDeArresto computadora2 = new OrdenDeArresto();
        computadora2.actualizarHobby("Tenis");
        ArrayList<Ladron> sospechosos2 = computadora2.posiblesLadrones(ladrones);

        OrdenDeArresto computadora3 = new OrdenDeArresto();
        computadora3.actualizarHobby("Femenino");
        computadora3.actualizarHobby("Rubio");
        ArrayList<Ladron> sospechosos3 = computadora3.posiblesLadrones(ladrones);

        ArrayList<Ladron> sospechososEsperados1 = new ArrayList<Ladron>(Arrays.asList(ladron1, ladron2));
        ArrayList<Ladron> sospechososEsperados2 = new ArrayList<Ladron>(Arrays.asList(ladron2, ladron3));
        ArrayList<Ladron> sospechososEsperados3 = new ArrayList<Ladron>();
        assertEquals(sospechosos1, sospechososEsperados1);
        assertEquals(sospechosos2, sospechososEsperados2);
        assertEquals(sospechosos3, sospechososEsperados3);
    }

    @Test
    public void test08AtraparAUnSospechosoSinOrdenDeArresto() {
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
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        ladrones.add(ladron);
        Mision mision = new Mision("Tesoro Nacional de Montreal", ladron , ciudades, ciudadesFalsas);
        Juego partida = new Juego(montreal, "Pepe", mision, ladrones);

        partida.viajarA(athens);
        assertEquals(0, partida.obtenerCantidadDeArrestos());
        assertEquals(1, partida.obtenerCantidadDeEscapados());

    }

}