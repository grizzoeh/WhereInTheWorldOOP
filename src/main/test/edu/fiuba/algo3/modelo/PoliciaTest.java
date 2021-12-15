package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.fiuba.algo3.modelo.policia.Policia;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Biblioteca;

public class PoliciaTest {
    Policia policia = new Policia("Juan");
    
    @Test
    public void test01UnNovatoTardaUnaHoraEnRecorrer900Km(){

        assertEquals(policia.duracionViajeconDistancia(900), 1);
    }

    @Test
    public void test02UnNovatoTardaDosHorasEnRecorrer1800Km(){

        assertEquals(policia.duracionViajeconDistancia(1800), 2);
    }

    @Test
    public void test03UnDetectiveTardaUnaHoraEnRecorrer1100Km(){

        policia.ascender();
        assertEquals(policia.duracionViajeconDistancia(1100), 1);
    }

    @Test
    public void test04UnDetectiveTardaDosHorasEnRecorrer2200Km(){
        policia.ascender();
        assertEquals(policia.duracionViajeconDistancia(2200), 2);
    }

    @Test
    public void test05UnInvestigadorTardaUnaHoraEnRecorrer1300Km(){

        policia.ascender();
        policia.ascender();
        assertEquals(policia.duracionViajeconDistancia(1300), 1);
    }

    @Test
    public void test06UnInvestigadorTardaDosHorasEnRecorrer2600Km(){
        policia.ascender();
        policia.ascender();
        assertEquals(policia.duracionViajeconDistancia(2600), 2);
    }

    @Test
    public void test07UnSargentoTardaUnaHoraEnRecorrer1500Km(){

        policia.ascender();
        policia.ascender();
        policia.ascender();
        assertEquals(policia.duracionViajeconDistancia(1500), 1);
    }

    @Test
    public void test08UnSargentoTardaDosHorasEnRecorrer3000Km(){
        policia.ascender();
        policia.ascender();
        policia.ascender();
        assertEquals(policia.duracionViajeconDistancia(3000), 2);
    }

    @Test
    public void test09UnPoliciaRecibeSuPrimerPuñalada(){
        assertEquals(policia.recibirPunialada(), 2);
    }

    @Test
    public void test10UnPoliciaRecibeMasDeDosPuñaladas(){
        assertEquals(policia.recibirPunialada(), 2);
        for (int i = 0; i < 5; i++) assertEquals(policia.recibirPunialada(), 1);
    }

    @Test
    public void test11UnNovatoEntraAUnaBiblioteca(){
        Biblioteca biblioteca = new Biblioteca();
        Ciudad ciudad = mock(Ciudad.class);
        Mision mision = mock(Mision.class);
        when(mision.obtenerDescripcionSospechoso()).thenReturn("pelo rojo");
        when(mision.obtenerProximaCiudad()).thenReturn(ciudad);
        when(ciudad.pistaFacilBiblioteca()).thenReturn("La gente es maya");
        assertEquals(policia.policiaEntrarEnEdificioConMision(biblioteca, mision), "La gente es maya, pelo rojo");
    }
}
