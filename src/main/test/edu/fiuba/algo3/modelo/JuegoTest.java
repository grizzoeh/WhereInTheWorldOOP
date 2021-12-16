package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.policia.Policia;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.edificios.Banco;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.Puerto;

import java.time.LocalDateTime;
import java.time.Month;
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
        LocalDateTime hora = partida.obtenerHora();
        LocalDateTime horaEsperada = LocalDateTime.of(2021, Month.NOVEMBER, 22, 8, 0, 0);
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
        LocalDateTime horaBanco = partida.obtenerHora();
        LocalDateTime horaEsperadaBanco = LocalDateTime.of(2021, Month.NOVEMBER, 22, 8, 0, 0);
        String pistaEsperadaBanco = "La moneda es Drachmas, La sospechosa tenia el pelo de color castaño";
        String pistaBiblioteca = partida.policiaEntrarA(biblioteca);
        LocalDateTime horaBiblioteca = partida.obtenerHora();
        String pistaEsperadaBiblioteca = "La gente es Plato, La sospechosa tenia el pelo de color castaño";
        LocalDateTime horaEsperadaBiblioteca = LocalDateTime.of(2021, Month.NOVEMBER, 22, 9, 0, 0);
        assertEquals(pistaBanco, pistaEsperadaBanco);
        assertEquals(horaBanco, horaEsperadaBanco);
        assertEquals(pistaBiblioteca, pistaEsperadaBiblioteca);
        assertEquals(horaBiblioteca, horaEsperadaBiblioteca);
    }

    @Test
    public void test03PoliciaViajaDeMontrealAMexico() {
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        Coordenadas coordenadasMontreal = new Coordenadas(45.508888, -73.561668);
        Coordenadas coordenadasMexico = new Coordenadas(19.432608, -99.133209);
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
        LocalDateTime tiempoEsperadoViaje = LocalDateTime.of(2021, Month.NOVEMBER, 22, 10, 0, 0);
        LocalDateTime tiempoViaje = partida.obtenerHora();
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
        LocalDateTime horaEsperada1 = LocalDateTime.of(2021, Month.NOVEMBER, 22, 13, 0, 0);
        LocalDateTime horaEsperada2 = LocalDateTime.of(2022, Month.FEBRUARY, 9, 9, 0, 0);
        for (int i = 0; i < 3; i++) {
            String pista = partida.policiaEntrarA(aeropuerto);
            assertEquals(pista, pistaEsperada);
        }
        LocalDateTime hora = partida.obtenerHora();
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

        LocalDateTime horaEsperada = LocalDateTime.of(2021, Month.NOVEMBER, 23, 8, 0, 0);
        for (int i = 0; i < 16; i++) {
            partida.recibirPunialada();
        }
        LocalDateTime hora = partida.obtenerHora();
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

        LocalDateTime tiempoEsperadoViaje = LocalDateTime.of(2021, Month.NOVEMBER, 22, 8, 0, 0);;
        LocalDateTime tiempoViaje = partida.obtenerHora();
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

        RegistroLadrones registroLadrones = new RegistroLadrones(ladrones);

        computadora.actualizarSexo("Masculino");
        ArrayList<Ladron> sospechosos1 = computadora.posiblesLadrones(registroLadrones);

        OrdenDeArresto computadora2 = new OrdenDeArresto();
        computadora2.actualizarHobby("Tenis");
        ArrayList<Ladron> sospechosos2 = computadora2.posiblesLadrones(registroLadrones);

        OrdenDeArresto computadora3 = new OrdenDeArresto();
        computadora3.actualizarHobby("Femenino");
        computadora3.actualizarHobby("Rubio");
        ArrayList<Ladron> sospechosos3 = computadora3.posiblesLadrones(registroLadrones);

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
        partida.policiaEntrarA(banco);

        assertEquals(0, partida.obtenerCantidadDeArrestos());
        assertEquals(1, partida.obtenerCantidadDeEscapados());
    }

    @Test
    public void test09RoboIncanGoldMaskCon6ArrestosPrevios() {
        ArrayList<String> descripciones = new ArrayList<String>();
        descripciones.add("El sospechoso llevaba un distintivo de Futbol.");
        descripciones.add("El sospechoso tenia el pelo castaño.");
        descripciones.add("El sospechoso tenia un tatuaje en la cara.");
        descripciones.add("Vi al sospechoso bajarse de un auto color azul.");
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        Ladron ladron = new Ladron("Pedro", "Masculino", "Futbol", "Castaño", "Tatuaje en la cara", "Auto", descripciones);
        ladrones.add(ladron);
        Ladron ladron2 = new Ladron("Juan", "Masculino", "Futbol", "Castaño", "Tatuaje en la cara", "Moto", descripciones);
        ladrones.add(ladron2);

        Juego partida = new Juego(null, "Pepe", null, ladrones);
        // El policia realiza 6 arrestos.
        partida.ladronAtrapado();
        partida.ladronAtrapado();
        partida.ladronAtrapado();
        partida.ladronAtrapado();
        partida.ladronAtrapado();
        partida.ladronAtrapado();

        // Inicializo la mision:
        ArrayList<Ciudad> recorridoLadron = new ArrayList<Ciudad>();
        ArrayList<Ciudad> ciudadesFalsas = new ArrayList<Ciudad>();

        Coordenadas coordenadasMontreal = new Coordenadas(45.508888, -73.561668);
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        Banco banco = new Banco();
        Aeropuerto aeropuerto = new Aeropuerto();
        Biblioteca biblioteca = new Biblioteca();
        edificios.add(banco);
        edificios.add(aeropuerto);
        edificios.add(biblioteca);
        Ciudad montreal = new Ciudad("Montreal", coordenadasMontreal, "Maple Leaf Flag", "???", "???", "Gaspe Peninsula", "???", "Moose", "???", "French", "???", "???", "???", "Former French Colony", edificios);
        recorridoLadron.add(montreal);

        Coordenadas coordenadasAthens = new Coordenadas(37.983810, 23.727539);
        ArrayList<Edificio> edificios2 = new ArrayList<Edificio>();
        Banco banco2 = new Banco();
        Aeropuerto aeropuerto2 = new Aeropuerto();
        Biblioteca biblioteca2 = new Biblioteca();
        edificios2.add(banco2);
        edificios2.add(aeropuerto2);
        edificios2.add(biblioteca2);
        Ciudad athens = new Ciudad("Athens", coordenadasAthens, "Blue and White", "Drachmas", "???", "Aegean Sea", "Figs, Olives", "???", "Plato", "Greek", "???", "???", "Prime Minister", "Hellenic Republic", edificios2);
        recorridoLadron.add(athens);

        Coordenadas coordenadasCairo = new Coordenadas(30.044420, 31.235712);
        ArrayList<Edificio> edificios3 = new ArrayList<Edificio>();
        Banco banco3 = new Banco();
        Aeropuerto aeropuerto3 = new Aeropuerto();
        Biblioteca biblioteca3 = new Biblioteca();
        edificios3.add(banco3);
        edificios3.add(aeropuerto3);
        edificios3.add(biblioteca3);
        Ciudad cairo = new Ciudad("Cairo", coordenadasCairo,"???", "Pounds", "???", "Pharoahs Tomb", "Limestone", "???", "???", "Nubian", "???", "???", "???", "Ancient Alexandria", edificios3);

        Coordenadas coordenadasNewYork = new Coordenadas(43.156168, -75.844994);
        ArrayList<Edificio> edificios4 = new ArrayList<Edificio>();
        Banco banco4 = new Banco();
        Aeropuerto aeropuerto4 = new Aeropuerto();
        Biblioteca biblioteca4 = new Biblioteca();
        edificios4.add(banco4);
        edificios4.add(aeropuerto4);
        edificios4.add(biblioteca4);
        Ciudad newYork = new Ciudad("New York", coordenadasNewYork, "Red, White, and Blue", "Dollars", "???", "Grant's Tomb", "Fashion", "???", "Henry Hudson", "???", "???", "???", "???", "Subways", edificios4);

        Coordenadas coordenadasParis = new Coordenadas(48.856613, 2.352222);
        ArrayList<Edificio> edificios5 = new ArrayList<Edificio>();
        Banco banco5 = new Banco();
        Aeropuerto aeropuerto5 = new Aeropuerto();
        Biblioteca biblioteca5 = new Biblioteca();
        edificios5.add(banco5);
        edificios5.add(aeropuerto5);
        edificios5.add(biblioteca5);

        Ciudad paris = new Ciudad("Paris", coordenadasParis, "Red, White, and Blue", "Francs", "???", "Sienne", "Fashion","???","???","???","???","???","???","???", edificios5);

        recorridoLadron.add(montreal);
        recorridoLadron.add(athens);
        recorridoLadron.add(cairo);
        recorridoLadron.add(newYork);
        recorridoLadron.add(paris);

        Mision mision = new Mision("Gold Incan Mask", ladron, recorridoLadron, ciudadesFalsas);
        partida.asignarMision(mision, montreal);

        String pista1 = partida.policiaEntrarA(banco);
        String pista2 = partida.policiaEntrarA(aeropuerto);
        String pista3 = partida.policiaEntrarA(biblioteca);
        String pistaEsperada1 = "Las industrias son Figs, Olives, El sospechoso llevaba un distintivo de Futbol.";
        String pistaEsperada2 = "El lenguaje del pais es Greek, El sospechoso tenia el pelo castaño.";
        String pistaEsperada3 = "La religion principal es ???, El sospechoso tenia un tatuaje en la cara.";
        assertEquals(pistaEsperada1, pista1);
        assertEquals(pistaEsperada2, pista2);
        assertEquals(pistaEsperada3, pista3);
        partida.OrdenActualizarSexo("Masculino");
        partida.OrdenActualizarHobby("Futbol");
        partida.OrdenActualizarCabello("Castaño");
        partida.OrdenActualizarSenia("Tatuaje en la cara");

        partida.viajarA(athens);
        pista1 = partida.policiaEntrarA(banco2);
        pista2 = partida.policiaEntrarA(aeropuerto2);
        pista3 = partida.policiaEntrarA(biblioteca2);
        pistaEsperada1 = "Las industrias son ???, Vi al sospechoso bajarse de un auto color azul.";
        pistaEsperada2 = "El lenguaje del pais es French, El sospechoso llevaba un distintivo de Futbol.";
        pistaEsperada3 = "La religion principal es ???, El sospechoso tenia el pelo castaño.";
        assertEquals(pistaEsperada1, pista1);
        assertEquals(pistaEsperada2, pista2);
        assertEquals(pistaEsperada3, pista3);
        partida.OrdenActualizarVehiculo("Auto");
        partida.generarOrdenDeArresto();

        // Como ya lleno la orden de arresto, simplemente sigue los paises.

        partida.viajarA(cairo);
        partida.viajarA(newYork);
        partida.viajarA(paris); // Final del recorrido, arresta al ladron.
        partida.policiaEntrarA(banco5);


        assertEquals(partida.obtenerCantidadDeArrestos(), 7);
        assertEquals(partida.obtenerCantidadDeEscapados(), 0);

    }

}